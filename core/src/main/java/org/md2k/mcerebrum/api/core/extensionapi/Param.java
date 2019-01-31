package org.md2k.mcerebrum.api.core.extensionapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

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
public class Param implements Parcelable {
    private String type;
    private String id;
    private String title;
    private String summary;

    public Param(@NonNull String type, @NonNull String id, @NonNull String title, @NonNull String summary) {
        this.type = type;
        this.id = id;
        this.title = title;
        this.summary = summary;
    }

    protected Param(Parcel in) {
        type = in.readString();
        id = in.readString();
        title = in.readString();
        summary = in.readString();
    }

    public static final Creator<Param> CREATOR = new Creator<Param>() {
        @Override
        public Param createFromParcel(Parcel in) {
            return new Param(in);
        }

        @Override
        public Param[] newArray(int size) {
            return new Param[size];
        }
    };

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getSummary() {
        return summary;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(type);
        parcel.writeString(id);
        parcel.writeString(title);
        parcel.writeString(summary);
    }

    @Override
    public boolean equals(Object toCompare) {
        if (toCompare instanceof Param) {
            return ((this.type.equals(((Param) toCompare).type)) &&
                    (this.id.equals(((Param) toCompare).id))) &&
                    ((this.title.equals(((Param) toCompare).title)) &&
                            (this.summary.equals(((Param) toCompare).summary)));
        } else
            return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + type.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + summary.hashCode();
        return result;
    }

}
