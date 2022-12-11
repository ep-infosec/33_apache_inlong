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

import React, { useState } from 'react';
import { Button, Card, Modal, message } from 'antd';
import { PageContainer, Container } from '@/components/PageContainer';
import HighTable from '@/components/HighTable';
import { useRequest } from '@/hooks';
import { useTranslation } from 'react-i18next';
import request from '@/utils/request';
import { defaultSize } from '@/configs/pagination';
import DataSourcesCreateModal from './DetailModal';
import { getFilterFormContent, getColumns } from './config';

const Comp: React.FC = () => {
  const { t } = useTranslation();

  const [options, setOptions] = useState({
    // keyword: '',
    pageSize: defaultSize,
    pageNum: 1,
  });

  const [createModal, setCreateModal] = useState<Record<string, unknown>>({
    visible: false,
  });

  const {
    data,
    loading,
    run: getList,
  } = useRequest(
    {
      url: '/user/listAll',
      method: 'POST',
      data: options,
    },
    {
      refreshDeps: [options],
    },
  );

  const onEdit = ({ id }) => {
    setCreateModal({
      visible: true,
      id,
    });
  };

  const onDelete = async ({ id }) => {
    Modal.confirm({
      title: t('basic.DeleteConfirm'),
      onOk: async () => {
        await request({
          url: '/user/delete',
          method: 'DELETE',
          params: {
            id,
          },
        });
        await getList();
        message.success(t('basic.DeleteSuccess'));
      },
    });
  };

  const onChange = ({ current: pageNum, pageSize }) => {
    setOptions(prev => ({
      ...prev,
      pageNum,
      pageSize,
    }));
  };

  const onFilter = allValues => {
    setOptions(prev => ({
      ...prev,
      ...allValues,
      pageNum: 1,
    }));
  };

  const pagination = {
    pageSize: options.pageSize,
    current: options.pageNum,
    total: data?.total,
  };

  return (
    <PageContainer useDefaultBreadcrumb={false} useDefaultContainer={false}>
      <Container>
        <Card>
          <HighTable
            suffix={
              <Button type="primary" onClick={() => setCreateModal({ visible: true })}>
                {t('pages.UserManagement.CreateAccount')}
              </Button>
            }
            filterForm={{
              content: getFilterFormContent(),
              onFilter,
            }}
            table={{
              columns: getColumns({ onEdit, onDelete }),
              rowKey: 'id',
              dataSource: data?.list,
              pagination,
              loading,
              onChange,
            }}
          />
        </Card>
      </Container>

      <DataSourcesCreateModal
        {...createModal}
        visible={createModal.visible as boolean}
        onOk={async () => {
          await getList();
          setCreateModal({ visible: false });
        }}
        onCancel={() => setCreateModal({ visible: false })}
      />
    </PageContainer>
  );
};

export default Comp;
