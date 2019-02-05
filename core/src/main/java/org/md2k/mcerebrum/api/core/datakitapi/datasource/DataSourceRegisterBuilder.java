package org.md2k.mcerebrum.api.core.datakitapi.datasource;

import org.md2k.mcerebrum.api.core.datakitapi.data.DataType;
import org.md2k.mcerebrum.api.core.datakitapi.data.SampleType;
import org.md2k.mcerebrum.api.core.datakitapi.datasource.metadata.ApplicationMetaData;
import org.md2k.mcerebrum.api.core.datakitapi.datasource.metadata.DataDescriptor;
import org.md2k.mcerebrum.api.core.datakitapi.datasource.metadata.DataSourceMetaData;
import org.md2k.mcerebrum.api.core.datakitapi.datasource.metadata.PlatformMetaData;

/*
 * Copyright (c) 2016, The University of Memphis, MD2K Center
 * - Syed Monowar Hossain <monowar.hossain@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
public class DataSourceRegisterBuilder
        implements IDataSourceBuilder.IDataType,
        IDataSourceBuilder.ISample, IDataSourceBuilder.IDataDescriptor1, IDataSourceBuilder.IDataDescriptor2, IDataSourceBuilder.IRegister {
    private DataSource dataSource;

    DataSourceRegisterBuilder() {
        dataSource = new DataSource();
    }

    @Override
    public IDataSourceBuilder.ISample setDataType(DataType dataType) {
        dataSource.dataType = dataType.getValue();
        return this;
    }

    @Override
    public IDataSourceBuilder.IDataDescriptor1 setSampleType(SampleType sampleType) {
        dataSource.sampleType = sampleType.getValue();
        return this;
    }

    @Override
    public IDataSourceBuilder.IDataDescriptor2 addDataDescriptor(DataDescriptor dataDescriptor) {
        if (dataDescriptor == null) dataDescriptor = DataDescriptor.Builder().build();
        dataSource.dataDescriptors.add(dataDescriptor.getDescriptor());
        return this;
    }

    @Override
    public IDataSourceBuilder.IRegister setDataSourceType(String dataSourceType) {
        dataSource.dataSourceType = dataSourceType;
        return this;
    }

    @Override
    public IDataSourceBuilder.IRegister setDataSourceId(String dataSourceId) {
        dataSource.dataSourceId = dataSourceId;
        return this;
    }

    @Override
    public IDataSourceBuilder.IRegister setPlatformType(String platformType) {
        dataSource.platformType = platformType;
        return this;
    }

    @Override
    public IDataSourceBuilder.IRegister setPlatformId(String platformId) {
        dataSource.platformId = platformId;
        return this;
    }

    @Override
    public IDataSourceBuilder.IRegister setApplicationType(String applicationType) {
        dataSource.applicationType = applicationType;
        return this;
    }

    @Override
    public IDataSourceBuilder.IRegister setApplicationId(String applicationId) {
        dataSource.applicationId = applicationId;
        return this;
    }

    @Override
    public IDataSourceBuilder.IRegister setDataSourceMetaData(DataSourceMetaData dataSourceMetaData) {
        dataSource.dataSourceMetaData = dataSourceMetaData.getMetaData();
        return this;
    }

    @Override
    public IDataSourceBuilder.IRegister setPlatformMetaData(PlatformMetaData platformMetaData) {
        dataSource.platformMetaData = platformMetaData.getMetaData();
        return this;
    }

    @Override
    public IDataSourceBuilder.IRegister setApplicationMetaData(ApplicationMetaData applicationMetaData) {
        dataSource.applicationMetaData = applicationMetaData.getMetaData();
        return this;
    }

    @Override
    public DataSourceRegister build() {
        return dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}
