package org.md2k.mcerebrumapi.core.datakitapi.datasource;
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


public class MCDataSourceResult implements Parcelable {
    protected int dsId;
    protected long creationTime;
    protected long lastUpdateTime;
    protected long lastDataTime;
    protected MCDataSource dataSource;

    public MCDataSourceResult(Parcel in) {
        dsId = in.readInt();
        creationTime = in.readLong();
        lastUpdateTime = in.readLong();
        lastDataTime = in.readLong();
        dataSource = in.readParcelable(MCDataSource.class.getClassLoader());
    }

    public static final Creator<MCDataSourceResult> CREATOR = new Creator<MCDataSourceResult>() {
        @Override
        public MCDataSourceResult createFromParcel(Parcel in) {
            return new MCDataSourceResult(in);
        }

        @Override
        public MCDataSourceResult[] newArray(int size) {
            return new MCDataSourceResult[size];
        }
    };

    public MCDataSourceResult(int dsId, long creationTime, long lastUpdateTime, MCDataSource dataSource) {
        this.dsId = dsId;
        this.creationTime = creationTime;
        this.lastUpdateTime = lastUpdateTime;
        this.dataSource = dataSource;
        this.lastDataTime = -1;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(dsId);
        parcel.writeLong(creationTime);
        parcel.writeLong(lastUpdateTime);
        parcel.writeLong(lastDataTime);
        parcel.writeParcelable(dataSource, i);
    }

    public int getDsId() {
        return dsId;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public long getLastDataTime() {
        return lastDataTime;
    }

    public MCDataSource getDataSource() {
        return dataSource;
    }

    public void setLastDataTime(long lastDataTime) {
        this.lastDataTime = lastDataTime;
    }


}
