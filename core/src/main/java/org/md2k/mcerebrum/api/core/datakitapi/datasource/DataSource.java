package org.md2k.mcerebrum.api.core.datakitapi.datasource;
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

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import org.md2k.mcerebrum.api.core.datakitapi.data.DataType;
import org.md2k.mcerebrum.api.core.datakitapi.data.SampleType;
import org.md2k.mcerebrum.api.core.datakitapi.datasource.metadata.ApplicationMetaData;
import org.md2k.mcerebrum.api.core.datakitapi.datasource.metadata.DataDescriptor;
import org.md2k.mcerebrum.api.core.datakitapi.datasource.metadata.DataSourceMetaData;
import org.md2k.mcerebrum.api.core.datakitapi.datasource.metadata.PlatformAppMetaData;
import org.md2k.mcerebrum.api.core.datakitapi.datasource.metadata.PlatformMetaData;

import java.util.ArrayList;
import java.util.HashMap;

public class DataSource implements Parcelable, DataSourceQuery, DataSourceRegister {
    private static final String SEPARATOR = "-";

    protected String dataSourceType = null;
    protected String dataSourceId = null;
    protected String platformType = null;
    protected String platformId = null;
    protected String platformAppType = null;
    protected String platformAppId = null;
    protected String applicationType = null;
    protected String applicationId = null;


    protected int dataType = DataType.POINT.getValue();
    protected int sampleType = SampleType.INT_ARRAY.getValue();

    protected HashMap<String, String> dataSourceMetaData = new HashMap<>();
    protected HashMap<String, String> platformMetaData = new HashMap<>();
    protected HashMap<String, String> platformAppMetaData = new HashMap<>();
    protected HashMap<String, String> applicationMetaData = new HashMap<>();
    protected ArrayList<HashMap<String, String>> dataDescriptors = new ArrayList<>();

    protected DataSource() {
    }

    protected DataSource(String uuid) {
        String[] splits = uuid.split(SEPARATOR);
        if (splits.length > 0 && splits[0] != null && splits[0].length() != 0)
            this.dataSourceType = splits[0];
        if (splits.length > 1 && splits[1] != null && splits[1].length() != 0)
            this.dataSourceId = splits[1];
        if (splits.length > 2 && splits[2] != null && splits[2].length() != 0)
            this.platformType = splits[2];
        if (splits.length > 3 && splits[3] != null && splits[3].length() != 0)
            this.platformId = splits[3];
        if (splits.length > 4 && splits[4] != null && splits[4].length() != 0)
            this.platformAppType = splits[4];
        if (splits.length > 5 && splits[5] != null && splits[5].length() != 0)
            this.platformAppId = splits[5];
        if (splits.length > 6 && splits[6] != null && splits[6].length() != 0)
            this.applicationType = splits[6];
        if (splits.length > 7 && splits[7] != null && splits[7].length() != 0)
            this.applicationId = splits[7];

    }

    public static final Creator<DataSource> CREATOR = new Creator<DataSource>() {
        @Override
        public DataSource createFromParcel(Parcel in) {
            return new DataSource(in);
        }

        @Override
        public DataSource[] newArray(int size) {
            return new DataSource[size];
        }
    };

    public static IDataSourceBuilder.IDataType registerBuilder() {
        return new DataSourceRegisterBuilder();
    }

    public static IDataSourceBuilder.IQuery queryBuilder() {
        return new DataSourceQueryBuilder();
    }

    public String getDataSourceType() {
        return dataSourceType;
    }

    public String getDataSourceId() {
        return dataSourceId;
    }

    public String getPlatformType() {
        return platformType;
    }

    public String getPlatformId() {
        return platformId;
    }

    public String getPlatformAppType() {
        return platformAppType;
    }

    public String getPlatformAppId() {
        return platformAppId;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public DataType getDataType() {
        return DataType.getDataType(dataType);
    }

    public SampleType getSampleType() {
        return SampleType.getSampleType(sampleType);
    }

    public DataSourceMetaData getDataSourceMetaData() {
        return DataSourceMetaData.builder().setMetaData(dataSourceMetaData).build();
    }

    public PlatformMetaData getPlatformMetaData() {
        return PlatformMetaData.builder().setMetaData(platformMetaData).build();
    }

    public PlatformAppMetaData getPlatformAppMetaData() {
        return PlatformAppMetaData.builder().setMetaData(platformAppMetaData).build();
    }

    public ApplicationMetaData getApplicationMetaData() {
        return ApplicationMetaData.builder().setMetaData(applicationMetaData).build();
    }

    public ArrayList<DataDescriptor> getDataDescriptors() {
        ArrayList<DataDescriptor> dds = new ArrayList<>();
        for (int i = 0; i < dataDescriptors.size(); i++) {
            dds.add(DataDescriptor.builder().setDescriptor(dataDescriptors.get(i)).build());
        }
        return dds;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    private DataSource(Parcel in) {
        dataSourceType = in.readString();
        dataSourceId = in.readString();
        platformType = in.readString();
        platformId = in.readString();
        platformAppType = in.readString();
        platformAppId = in.readString();
        applicationType = in.readString();
        applicationId = in.readString();

        dataType = in.readInt();
        sampleType = in.readInt();

        dataSourceMetaData = readHashMapFromParcel(in);
        platformMetaData = readHashMapFromParcel(in);
        platformAppMetaData = readHashMapFromParcel(in);
        applicationMetaData = readHashMapFromParcel(in);
        dataDescriptors = readHashMapArrayFromParcel(in);

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(dataSourceType);
        parcel.writeString(dataSourceId);
        parcel.writeString(platformType);
        parcel.writeString(platformId);
        parcel.writeString(platformAppType);
        parcel.writeString(platformAppId);
        parcel.writeString(applicationType);
        parcel.writeString(applicationId);

        parcel.writeInt(dataType);
        parcel.writeInt(sampleType);

        writeHashMapToParcel(parcel, dataSourceMetaData);
        writeHashMapToParcel(parcel, platformMetaData);
        writeHashMapToParcel(parcel, platformAppMetaData);
        writeHashMapToParcel(parcel, applicationMetaData);
        writeDataDescriptorToParcel(parcel, dataDescriptors);
    }

    private ArrayList<HashMap<String, String>> readHashMapArrayFromParcel(Parcel in) {
        ArrayList<HashMap<String, String>> dataDescriptors;
        int size = in.readInt();
        dataDescriptors = new ArrayList<>();
        for (int i = 0; i < size; i++)
            dataDescriptors.add(readHashMapFromParcel(in));
        return dataDescriptors;
    }

    private void writeDataDescriptorToParcel(Parcel parcel, ArrayList<HashMap<String, String>> dataDescriptors) {
        int size = dataDescriptors.size();
        parcel.writeInt(size);
        for (HashMap<String, String> dataDescriptor : dataDescriptors)
            writeHashMapToParcel(parcel, dataDescriptor);
    }

    private HashMap<String, String> readHashMapFromParcel(Parcel in) {
        HashMap<String, String> metaData = new HashMap<>();
        int size = in.readInt();
        for (int j = 0; j < size; j++) {
            metaData.put(in.readString(), in.readString());
        }
        return metaData;
    }

    private void writeHashMapToParcel(Parcel parcel, HashMap<String, String> metaData) {
        int size = metaData.size();
        parcel.writeInt(size);
        for (HashMap.Entry<String, String> entry : metaData.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DataSource))
            return false;
        DataSource d = (DataSource) obj;
        return toUUID().equals(d.toUUID())
                && dataSourceMetaData.equals(d.dataSourceMetaData)
                && platformMetaData.equals(d.platformMetaData)
                && platformAppMetaData.equals(d.platformAppMetaData)
                && applicationMetaData.equals(d.applicationMetaData)
                && dataDescriptors.equals(d.dataDescriptors)
                && dataType == d.dataType
                && sampleType == d.sampleType;
    }

    public String toUUID() {
        String uuid = "";
        if (dataSourceType != null) uuid += dataSourceType;
        uuid += SEPARATOR;
        if (dataSourceId != null) uuid += dataSourceId;
        uuid += SEPARATOR;
        if (platformType != null) uuid += platformType;
        uuid += SEPARATOR;
        if (platformId != null) uuid += platformId;
        uuid += SEPARATOR;
        if (platformAppType != null) uuid += platformAppType;
        uuid += SEPARATOR;
        if (platformAppId != null) uuid += platformAppId;
        uuid += SEPARATOR;
        if (applicationType != null) uuid += applicationType;
        uuid += SEPARATOR;
        if (applicationId != null) uuid += applicationId;
        return uuid;
    }

    public boolean isSubset(DataSource master) {
        if (this.dataSourceType != null && !this.dataSourceType.equals(master.dataSourceType))
            return false;
        if (this.dataSourceId != null && !this.dataSourceId.equals(master.dataSourceId))
            return false;
        if (this.platformType != null && !this.platformType.equals(master.platformType))
            return false;
        if (this.platformId != null && !this.platformId.equals(master.platformId)) return false;
        if (this.platformAppType != null && !this.platformAppType.equals(master.platformAppType))
            return false;
        if (this.platformAppId != null && !this.platformAppId.equals(master.platformAppId))
            return false;
        if (this.applicationType != null && !this.applicationType.equals(master.applicationType))
            return false;
        return this.applicationId == null || this.applicationId.equals(master.applicationId);
    }

    public boolean isEqualUUID(DataSource d) {
        return toUUID().equals(d.toUUID());
    }

}
