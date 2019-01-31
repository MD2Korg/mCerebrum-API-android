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


public class DataSourceResult implements Parcelable {
    protected int dsId;
    protected long creationTime;
    protected long lastActiveTime;
    protected DataSource dataSource;

    public DataSourceResult(Parcel in) {
        dsId = in.readInt();
        creationTime = in.readLong();
        lastActiveTime = in.readLong();
        dataSource = in.readParcelable(DataSource.class.getClassLoader());
    }

    public static final Creator<DataSourceResult> CREATOR = new Creator<DataSourceResult>() {
        @Override
        public DataSourceResult createFromParcel(Parcel in) {
            return new DataSourceResult(in);
        }

        @Override
        public DataSourceResult[] newArray(int size) {
            return new DataSourceResult[size];
        }
    };

    public DataSourceResult(int dsId, long creationTime, long lastActiveTime, DataSource dataSource) {
        this.dsId = dsId;
        this.creationTime = creationTime;
        this.lastActiveTime = lastActiveTime;
        this.dataSource = dataSource;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(dsId);
        parcel.writeLong(creationTime);
        parcel.writeLong(lastActiveTime);
        parcel.writeParcelable(dataSource, i);
    }

    public int getDsId() {
        return dsId;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public long getLastActiveTime() {
        return lastActiveTime;
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}
