/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.inlong.sort.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class to create instances from class objects and checking failure reasons.
 *
 * <p>Copied from Flink project.</p>
 */
public class InstantiationUtil {

    private static final Logger LOG = LoggerFactory.getLogger(InstantiationUtil.class);

    public static byte[] serializeObject(Object o) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(o);
            oos.flush();
            return baos.toByteArray();
        }
    }

    public static void serializeObject(OutputStream out, Object o) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(o);
    }

    public static boolean isSerializable(Object o) {
        try {
            serializeObject(o);
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    public static <T> T deserializeObject(byte[] bytes, ClassLoader cl)
            throws IOException, ClassNotFoundException {
        return deserializeObject(bytes, cl, false);
    }

    @SuppressWarnings("unchecked")
    public static <T> T deserializeObject(InputStream in, ClassLoader cl)
            throws IOException, ClassNotFoundException {
        return deserializeObject(in, cl, false);
    }

    @SuppressWarnings("unchecked")
    public static <T> T deserializeObject(byte[] bytes, ClassLoader cl, boolean isFailureTolerant)
            throws IOException, ClassNotFoundException {

        return deserializeObject(new ByteArrayInputStream(bytes), cl, isFailureTolerant);
    }

    @SuppressWarnings("unchecked")
    public static <T> T deserializeObject(InputStream in, ClassLoader cl, boolean isFailureTolerant)
            throws IOException, ClassNotFoundException {

        final ClassLoader old = Thread.currentThread().getContextClassLoader();
        // not using resource try to avoid AutoClosable's close() on the given stream
        try {
            ObjectInputStream oois = isFailureTolerant
                    ? new InstantiationUtil.FailureTolerantObjectInputStream(in, cl)
                    : new InstantiationUtil.ClassLoaderObjectInputStream(in, cl);
            Thread.currentThread().setContextClassLoader(cl);
            return (T) oois.readObject();
        } finally {
            Thread.currentThread().setContextClassLoader(old);
        }
    }

    /**
     * A custom ObjectInputStream that can load classes using a specific ClassLoader.
     */
    public static class ClassLoaderObjectInputStream extends ObjectInputStream {

        protected final ClassLoader classLoader;

        public ClassLoaderObjectInputStream(InputStream in, ClassLoader classLoader)
                throws IOException {
            super(in);
            this.classLoader = classLoader;
        }

        @Override
        protected Class<?> resolveClass(ObjectStreamClass desc)
                throws IOException, ClassNotFoundException {
            if (classLoader != null) {
                String name = desc.getName();
                try {
                    return Class.forName(name, false, classLoader);
                } catch (ClassNotFoundException ex) {
                    // check if class is a primitive class
                    Class<?> cl = primitiveClasses.get(name);
                    if (cl != null) {
                        // return primitive class
                        return cl;
                    } else {
                        // throw ClassNotFoundException
                        throw ex;
                    }
                }
            }

            return super.resolveClass(desc);
        }

        @Override
        protected Class<?> resolveProxyClass(String[] interfaces)
                throws IOException, ClassNotFoundException {
            if (classLoader != null) {
                ClassLoader nonPublicLoader = null;
                boolean hasNonPublicInterface = false;

                // define proxy in class loader of non-public interface(s), if any
                Class<?>[] classObjs = new Class<?>[interfaces.length];
                for (int i = 0; i < interfaces.length; i++) {
                    Class<?> cl = Class.forName(interfaces[i], false, classLoader);
                    if ((cl.getModifiers() & Modifier.PUBLIC) == 0) {
                        if (hasNonPublicInterface) {
                            if (nonPublicLoader != cl.getClassLoader()) {
                                throw new IllegalAccessError(
                                        "conflicting non-public interface class loaders");
                            }
                        } else {
                            nonPublicLoader = cl.getClassLoader();
                            hasNonPublicInterface = true;
                        }
                    }
                    classObjs[i] = cl;
                }
                try {
                    return Proxy.getProxyClass(
                            hasNonPublicInterface ? nonPublicLoader : classLoader, classObjs);
                } catch (IllegalArgumentException e) {
                    throw new ClassNotFoundException(null, e);
                }
            }

            return super.resolveProxyClass(interfaces);
        }

        // ------------------------------------------------

        private static final HashMap<String, Class<?>> primitiveClasses = new HashMap<>(9);

        static {
            primitiveClasses.put("boolean", boolean.class);
            primitiveClasses.put("byte", byte.class);
            primitiveClasses.put("char", char.class);
            primitiveClasses.put("short", short.class);
            primitiveClasses.put("int", int.class);
            primitiveClasses.put("long", long.class);
            primitiveClasses.put("float", float.class);
            primitiveClasses.put("double", double.class);
            primitiveClasses.put("void", void.class);
        }
    }

    /**
     * An {@link ObjectInputStream} that ignores serialVersionUID mismatches when deserializing
     * objects of anonymous classes or our Scala serializer classes and also replaces occurences of
     * GenericData.Array (from Avro) by a dummy class so that the KryoSerializer can still be
     * deserialized without Avro being on the classpath.
     *
     * <p>Uses this specific object input stream to read serializers,
     * so that mismatching serialVersionUIDs of anonymous classes / Scala serializers are ignored.
     * This is a required workaround to maintain backwards compatibility for our pre-1.3 Scala
     * serializers. See FLINK-6869 for details.</p>
     *
     * @see <a href="https://issues.apache.org/jira/browse/FLINK-6869">FLINK-6869</a>
     */
    public static class FailureTolerantObjectInputStream
            extends
                InstantiationUtil.ClassLoaderObjectInputStream {

        // initialize this set to support compatible manually
        private static final Set<String> compatibleClasses = new HashSet<>();

        public FailureTolerantObjectInputStream(InputStream in, ClassLoader cl) throws IOException {
            super(in, cl);
        }

        @Override
        protected ObjectStreamClass readClassDescriptor()
                throws IOException, ClassNotFoundException {
            ObjectStreamClass streamClassDescriptor = super.readClassDescriptor();

            try {
                Class.forName(streamClassDescriptor.getName(), false, classLoader);
            } catch (ClassNotFoundException ignored) {
                // ignore this exception
            }

            final Class localClass = resolveClass(streamClassDescriptor);
            final String name = localClass.getName();
            if (compatibleClasses.contains(name) || isAnonymousClass(localClass)) {
                final ObjectStreamClass localClassDescriptor = ObjectStreamClass.lookup(localClass);
                if (localClassDescriptor != null
                        && localClassDescriptor.getSerialVersionUID() != streamClassDescriptor
                                .getSerialVersionUID()) {
                    LOG.warn("Ignoring serialVersionUID mismatch for class {}; was {}, now {}.",
                            streamClassDescriptor.getName(),
                            streamClassDescriptor.getSerialVersionUID(),
                            localClassDescriptor.getSerialVersionUID());

                    streamClassDescriptor = localClassDescriptor;
                }
            }

            return streamClassDescriptor;
        }

    }

    private static boolean isAnonymousClass(Class clazz) {
        final String name = clazz.getName();

        // isAnonymousClass does not work for anonymous Scala classes
        // additionally check by class name
        if (name.contains("$anon$") || name.contains("$anonfun") || name.contains("$macro$")) {
            return true;
        }

        // calling isAnonymousClass or getSimpleName can throw InternalError for certain Scala
        // types, see https://issues.scala-lang.org/browse/SI-2034
        // until we move to JDK 9, this try-catch is necessary
        try {
            return clazz.isAnonymousClass();
        } catch (InternalError e) {
            return false;
        }
    }

}
