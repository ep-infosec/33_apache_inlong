/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import React from 'react';
import i18n from '@/i18n';
import StatusTag, { StatusTagProps } from '@/components/StatusTag';
import { ClockCircleFilled } from '@/components/Icons';

type StatusProp = {
  label: string;
  value: string | number;
  type: StatusTagProps['type'];
  icon?: StatusTagProps['icon'];
};

export const statusList: StatusProp[] = [
  {
    label: i18n.t('meta.Group.Status.Draft'),
    value: 0,
    type: 'default',
  },
  {
    label: i18n.t('meta.Group.Status.Cancel'),
    value: 30,
    type: 'default',
  },
  {
    label: i18n.t('meta.Group.Status.BeSubmitted'),
    value: 100,
    type: 'primary',
    icon: <ClockCircleFilled />,
  },
  {
    label: i18n.t('meta.Group.Status.BeApproved'),
    value: 101,
    type: 'warning',
  },
  {
    label: i18n.t('meta.Group.Status.Reject'),
    value: 102,
    type: 'error',
  },
  {
    label: i18n.t('meta.Group.Status.Approved'),
    value: 103,
    type: 'success',
  },
  {
    label: i18n.t('meta.Group.Status.InPlace'),
    value: 110,
    type: 'primary',
    icon: <ClockCircleFilled />,
  },
  {
    label: i18n.t('meta.Group.Status.ConfigurationFailed'),
    value: 120,
    type: 'error',
  },
  {
    label: i18n.t('meta.Group.Status.ConfigurationSuccess'),
    value: 130,
    type: 'success',
  },
];

export const statusMap = statusList.reduce(
  (acc, cur) => ({
    ...acc,
    [cur.value]: cur,
  }),
  {},
);

export const genStatusTag = (value: StatusProp['value']) => {
  const item = statusMap[value] || {};

  return <StatusTag type={item.type || 'default'} title={item.label || value} icon={item.icon} />;
};
