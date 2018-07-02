/*
 * Copyright (c) 2018, The University of Memphis, MD2K Center of Excellence
 *
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

package org.md2k.mcerebrum.api.datakitapi;

import android.os.Parcel;

public class DataSourceQuery extends AbstractDataSource {
    private DataSourceQuery() {
        super();
    }
    private DataSourceQuery(Parcel in){
        super(in);
    }

    private DataSourceQuery(Builder dataSourceBuilder) {
        dataSourceType = dataSourceBuilder.dataSourceType;
        dataSourceId=dataSourceBuilder.dataSourceId;
        platformType=dataSourceBuilder.platformType;
        platformId=dataSourceBuilder.platformId;
        platformAppType=dataSourceBuilder.platformAppType;
        platformAppId=dataSourceBuilder.platformAppId;
        applicationType=dataSourceBuilder.applicationType;
        applicationId=dataSourceBuilder.applicationId;
    }
    public String getDataSourceType(){
        return dataSourceType;
    }
    public String getDataSourceId(){
        return dataSourceId;
    }
    public String getPlatformType(){
        return platformType;
    }
    public String getPlatformId(){
        return platformId;
    }
    public String getPlatformAppType(){
        return platformAppType;
    }
    public String getPlatformAppId(){
        return platformAppId;
    }
    public String getApplicationType(){
        return applicationType;
    }
    public String getApplicationId(){
        return applicationId;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        String dataSourceType = null;
        String dataSourceId = null;
        String platformType = null;
        String platformId = null;
        String platformAppType = null;
        String platformAppId = null;
        String applicationType = null;
        String applicationId = null;
        Builder() {
        }
        public Builder setDataSourceType(String dataSourceType) {
            this.dataSourceType = dataSourceType;
            return this;
        }
        public Builder setDataSourceId(String datasourceId) {
            this.dataSourceId = datasourceId;
            return this;
        }

        public Builder setPlatformType(String platformType) {
            this.platformType = platformType;
            return this;
        }
        public Builder setPlatformId(String platformId) {
            this.platformId = platformId;
            return this;
        }
        public Builder setPlatformAppType(String platformApp) {
            this.platformAppType = platformApp;
            return this;
        }
        public Builder setPlatformAppId(String platformAppId) {
            this.platformAppId = platformAppId;
            return this;
        }

        public Builder setApplicationType(String applicationType) {
            this.applicationType = applicationType;
            return this;
        }
        public Builder setApplicationId(String applicationId) {
            this.applicationId = applicationId;
            return this;
        }
        public DataSourceQuery build() {
            return new DataSourceQuery(this);
        }
    }
    @Override
    public int describeContents() {
        return 0;
    }
    public static final Creator<DataSourceQuery> CREATOR = new Creator<DataSourceQuery>() {
        @Override
        public DataSourceQuery createFromParcel(Parcel in) {
            return new DataSourceQuery(in);
        }

        @Override
        public DataSourceQuery[] newArray(int size) {
            return new DataSourceQuery[size];
        }
    };

}

