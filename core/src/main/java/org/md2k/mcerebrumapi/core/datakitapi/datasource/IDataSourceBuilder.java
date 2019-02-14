package org.md2k.mcerebrumapi.core.datakitapi.datasource;

import org.md2k.mcerebrumapi.core.data.MCDataType;
import org.md2k.mcerebrumapi.core.data.MCSampleType;
import org.md2k.mcerebrumapi.core.datakitapi.datasource.metadata.ApplicationMetaData;
import org.md2k.mcerebrumapi.core.datakitapi.datasource.metadata.DataDescriptor;
import org.md2k.mcerebrumapi.core.datakitapi.datasource.metadata.DataSourceMetaData;
import org.md2k.mcerebrumapi.core.datakitapi.datasource.metadata.PlatformMetaData;

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
interface IDataSourceBuilder {
    interface IDataType {
        ISample setDataType(MCDataType dataType);
    }

    interface ISample {
        IDataDescriptor1 setSampleType(MCSampleType sampleType);
    }

    interface IDataDescriptor1 {
        IDataDescriptor2 addDataDescriptor(DataDescriptor dataDescriptor);
    }

    interface IDataDescriptor2 {
        IDataDescriptor2 addDataDescriptor(DataDescriptor dataDescriptor);

        IRegister setDataSourceType(String dataSourceType);
    }

    interface IQuery {
        IQuery setDataSourceType(String dataSourceType);

        IQuery setDataSourceId(String dataSourceId);

        IQuery setPlatformType(String platformType);

        IQuery setPlatformId(String platformId);

        IQuery setPlatformAppType(String platformAppType);

        IQuery setPlatformAppId(String platformAppId);

        IQuery setApplicationType(String applicationType);

        IQuery setApplicationId(String applicationId);

        IQuery fromUUID(String uuid);

        DataSourceQuery build();
    }

    interface IRegister {
        IRegister setDataSourceId(String dataSourceId);

        IRegister setPlatformType(String platformType);

        IRegister setPlatformId(String platformId);

        IRegister setApplicationType(String applicationType);

        IRegister setApplicationId(String applicationId);

        IRegister setDataSourceMetaData(DataSourceMetaData dataSourceMetaData);

        IRegister setPlatformMetaData(PlatformMetaData platformMetaData);

        IRegister setApplicationMetaData(ApplicationMetaData applicationMetaData);

        DataSourceRegister build();
    }
}