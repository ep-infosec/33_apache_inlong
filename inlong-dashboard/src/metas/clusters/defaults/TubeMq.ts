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

import i18n from '@/i18n';
import { DataWithBackend } from '@/metas/DataWithBackend';
import { RenderRow } from '@/metas/RenderRow';
import { RenderList } from '@/metas/RenderList';
import { ClusterInfo } from '../common/ClusterInfo';

const { I18n } = DataWithBackend;
const { FieldDecorator } = RenderRow;

export default class TubeMqCluster
  extends ClusterInfo
  implements DataWithBackend, RenderRow, RenderList
{
  @FieldDecorator({
    type: 'input',
    rules: [{ required: true }],
    tooltip: i18n.t('pages.Clusters.Tube.MasterRpcUrlHelper'),
    props: {
      placeholder: '127.0.0.1:8715,127.0.1.2:8715',
    },
  })
  @I18n('RPC URL')
  url: string;

  @FieldDecorator({
    type: 'input',
    rules: [{ required: true }],
    tooltip: i18n.t('pages.Clusters.Tube.MasterWebUrlHelper'),
    props: {
      placeholder: 'http://127.0.0.1:8080',
    },
  })
  @I18n('Web URL')
  masterWebUrl: string;

  @FieldDecorator({
    type: 'input',
    props: {
      placeholder: 'Required if the cluster is configured with Token',
    },
  })
  @I18n('Token')
  token: string;
}
