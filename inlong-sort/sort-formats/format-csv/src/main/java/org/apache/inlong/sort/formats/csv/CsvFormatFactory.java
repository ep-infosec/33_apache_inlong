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

package org.apache.inlong.sort.formats.csv;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.serialization.SerializationSchema;
import org.apache.flink.table.api.ValidationException;
import org.apache.flink.table.descriptors.DescriptorProperties;
import org.apache.flink.table.factories.DeserializationSchemaFactory;
import org.apache.flink.table.factories.SerializationSchemaFactory;
import org.apache.flink.table.factories.TableFormatFactoryBase;
import org.apache.flink.types.Row;
import org.apache.inlong.sort.formats.base.DefaultTableFormatDeserializer;
import org.apache.inlong.sort.formats.base.DefaultTableFormatSerializer;
import org.apache.inlong.sort.formats.base.ProjectedDeserializationSchemaFactory;
import org.apache.inlong.sort.formats.base.ProjectedSerializationSchemaFactory;
import org.apache.inlong.sort.formats.base.TableFormatConstants;
import org.apache.inlong.sort.formats.base.TableFormatDeserializer;
import org.apache.inlong.sort.formats.base.TableFormatDeserializerFactory;
import org.apache.inlong.sort.formats.base.TableFormatSerializer;
import org.apache.inlong.sort.formats.base.TableFormatSerializerFactory;
import org.apache.inlong.sort.formats.base.TableFormatUtils;
import org.apache.inlong.sort.formats.common.BasicFormatInfo;
import org.apache.inlong.sort.formats.common.FormatInfo;
import org.apache.inlong.sort.formats.common.RowFormatInfo;

/**
 * Table format factory for providing configured instances of CSV-to-row
 * serializer and deserializer.
 */
public final class CsvFormatFactory
        extends
            TableFormatFactoryBase<Row>
        implements
            DeserializationSchemaFactory<Row>,
            SerializationSchemaFactory<Row>,
            ProjectedDeserializationSchemaFactory,
            ProjectedSerializationSchemaFactory,
            TableFormatDeserializerFactory,
            TableFormatSerializerFactory {

    public CsvFormatFactory() {
        super(Csv.FORMAT_TYPE_VALUE, 1, true);
    }

    @Override
    public List<String> supportedFormatProperties() {
        final List<String> properties = new ArrayList<>();
        properties.add(TableFormatConstants.FORMAT_SCHEMA);
        properties.add(TableFormatConstants.FORMAT_CHARSET);
        properties.add(TableFormatConstants.FORMAT_DELIMITER);
        properties.add(TableFormatConstants.FORMAT_ESCAPE_CHARACTER);
        properties.add(TableFormatConstants.FORMAT_QUOTE_CHARACTER);
        properties.add(TableFormatConstants.FORMAT_NULL_LITERAL);
        properties.add(TableFormatConstants.FORMAT_IGNORE_ERRORS);
        return properties;
    }

    @Override
    public CsvDeserializationSchema createDeserializationSchema(
            Map<String, String> properties) {
        final DescriptorProperties descriptorProperties =
                getValidatedProperties(properties);

        final RowFormatInfo rowFormatInfo =
                TableFormatUtils.getRowFormatInfo(descriptorProperties);

        return buildDeserializationSchema(descriptorProperties, rowFormatInfo);
    }

    @Override
    public CsvSerializationSchema createSerializationSchema(
            Map<String, String> properties) {
        final DescriptorProperties descriptorProperties =
                getValidatedProperties(properties);

        final RowFormatInfo rowFormatInfo =
                TableFormatUtils.getRowFormatInfo(descriptorProperties);

        return buildSerializationSchema(descriptorProperties, rowFormatInfo);
    }

    @Override
    public DeserializationSchema<Row> createProjectedDeserializationSchema(
            Map<String, String> properties,
            int[] fields) {
        final DescriptorProperties descriptorProperties =
                getValidatedProperties(properties);

        final RowFormatInfo rowFormatInfo =
                TableFormatUtils.getRowFormatInfo(descriptorProperties);
        final RowFormatInfo projectedRowFormatInfo =
                TableFormatUtils.projectRowFormatInfo(rowFormatInfo, fields);

        return buildDeserializationSchema(descriptorProperties, projectedRowFormatInfo);
    }

    @Override
    public SerializationSchema<Row> createProjectedSerializationSchema(
            Map<String, String> properties,
            int[] fields) {
        final DescriptorProperties descriptorProperties =
                getValidatedProperties(properties);

        final RowFormatInfo rowFormatInfo =
                TableFormatUtils.getRowFormatInfo(descriptorProperties);
        final RowFormatInfo projectedRowFormatInfo =
                TableFormatUtils.projectRowFormatInfo(rowFormatInfo, fields);

        return buildSerializationSchema(descriptorProperties, projectedRowFormatInfo);
    }

    @Override
    public TableFormatDeserializer createFormatDeserializer(
            Map<String, String> properties) {
        final DescriptorProperties descriptorProperties =
                getValidatedProperties(properties);

        final RowFormatInfo rowFormatInfo =
                TableFormatUtils.getRowFormatInfo(descriptorProperties);

        final CsvDeserializationSchema deserializationSchema =
                buildDeserializationSchema(descriptorProperties, rowFormatInfo);

        boolean ignoreErrors =
                descriptorProperties
                        .getOptionalBoolean(TableFormatConstants.FORMAT_IGNORE_ERRORS)
                        .orElse(TableFormatConstants.DEFAULT_IGNORE_ERRORS);

        return new DefaultTableFormatDeserializer(deserializationSchema, ignoreErrors);
    }

    @Override
    public TableFormatSerializer createFormatSerializer(
            Map<String, String> properties) {
        final DescriptorProperties descriptorProperties =
                getValidatedProperties(properties);

        final RowFormatInfo rowFormatInfo =
                TableFormatUtils.getRowFormatInfo(descriptorProperties);

        final CsvSerializationSchema serializationSchema =
                buildSerializationSchema(descriptorProperties, rowFormatInfo);

        boolean ignoreErrors =
                descriptorProperties
                        .getOptionalBoolean(TableFormatConstants.FORMAT_IGNORE_ERRORS)
                        .orElse(TableFormatConstants.DEFAULT_IGNORE_ERRORS);

        return new DefaultTableFormatSerializer(serializationSchema, ignoreErrors);
    }

    public static DescriptorProperties getValidatedProperties(
            Map<String, String> properties) {
        DescriptorProperties descriptorProperties = new DescriptorProperties(true);
        descriptorProperties.putProperties(properties);

        CsvValidator validator = new CsvValidator();
        validator.validate(descriptorProperties);

        return descriptorProperties;
    }

    private static CsvDeserializationSchema buildDeserializationSchema(
            DescriptorProperties descriptorProperties,
            RowFormatInfo rowFormatInfo) {
        for (FormatInfo formatInfo : rowFormatInfo.getFieldFormatInfos()) {
            if (!(formatInfo instanceof BasicFormatInfo)) {
                throw new ValidationException("Currently only basic formats " + "are supported in csv formats.");
            }
        }

        CsvDeserializationSchema.Builder builder =
                new CsvDeserializationSchema.Builder(rowFormatInfo);

        descriptorProperties.getOptionalString(TableFormatConstants.FORMAT_CHARSET)
                .ifPresent(builder::setCharset);

        descriptorProperties.getOptionalCharacter(TableFormatConstants.FORMAT_DELIMITER)
                .ifPresent(builder::setDelimiter);

        descriptorProperties.getOptionalCharacter(TableFormatConstants.FORMAT_ESCAPE_CHARACTER)
                .ifPresent(builder::setEscapeCharacter);

        descriptorProperties.getOptionalCharacter(TableFormatConstants.FORMAT_QUOTE_CHARACTER)
                .ifPresent(builder::setQuoteCharacter);

        descriptorProperties.getOptionalString(TableFormatConstants.FORMAT_NULL_LITERAL)
                .ifPresent(builder::setNullLiteral);

        return builder.build();
    }

    private static CsvSerializationSchema buildSerializationSchema(
            DescriptorProperties descriptorProperties,
            RowFormatInfo rowFormatInfo) {
        for (FormatInfo formatInfo : rowFormatInfo.getFieldFormatInfos()) {
            if (!(formatInfo instanceof BasicFormatInfo)) {
                throw new ValidationException("Currently only basic formats " + "are supported in csv formats.");
            }
        }

        CsvSerializationSchema.Builder builder =
                new CsvSerializationSchema.Builder(rowFormatInfo);

        descriptorProperties.getOptionalString(TableFormatConstants.FORMAT_CHARSET)
                .ifPresent(builder::setCharset);

        descriptorProperties.getOptionalCharacter(TableFormatConstants.FORMAT_DELIMITER)
                .ifPresent(builder::setDelimiter);

        descriptorProperties.getOptionalCharacter(TableFormatConstants.FORMAT_ESCAPE_CHARACTER)
                .ifPresent(builder::setEscapeCharacter);

        descriptorProperties.getOptionalCharacter(TableFormatConstants.FORMAT_QUOTE_CHARACTER)
                .ifPresent(builder::setQuoteCharacter);

        descriptorProperties.getOptionalString(TableFormatConstants.FORMAT_NULL_LITERAL)
                .ifPresent(builder::setNullLiteral);

        return builder.build();
    }
}
