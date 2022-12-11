/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.inlong.manager.common.utils;

import org.apache.inlong.manager.pojo.cluster.ClusterTagRequest;
import org.apache.inlong.manager.common.validation.UpdateValidation;
import org.apache.inlong.manager.common.util.ValidationUtils;
import org.apache.inlong.manager.service.ServiceBaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

/**
 * Test {@link ValidationUtils}
 */
class ValidationUtilsTest extends ServiceBaseTest {

    @Resource
    Validator validator;

    @Test
    void testValidate4Group() {
        ConstraintViolationException violationException = Assertions.assertThrows(
                ConstraintViolationException.class,
                () -> ValidationUtils.validate(validator, new ClusterTagRequest(), UpdateValidation.class));

        Assertions.assertTrue(violationException.getMessage().contains("id cannot be null"));
    }

    @Test
    void testValidate() {
        ConstraintViolationException violationException = Assertions.assertThrows(
                ConstraintViolationException.class,
                () -> ValidationUtils.validate(validator, new ClusterTagRequest()));

        Assertions.assertTrue(violationException.getMessage().contains("clusterTag cannot be blank"));
    }

}
