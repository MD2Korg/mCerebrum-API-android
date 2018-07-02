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
import android.os.Parcelable;

import java.util.HashMap;

/**
 * Builder class for <code>DataSource</code> objects
 */
public class DataDescriptor implements Parcelable{
    private String title;
    private String summary;
    private String description;
    private double minValue;
    private double maxValue;
    private String[] possibleValuesAsString;
    private int[] possibleValuesAsInt;
    private String unit;
    private HashMap<String, String> custom = new HashMap<>();

    private DataDescriptor() {
    }

    protected DataDescriptor(Parcel in) {
        title = in.readString();
        summary = in.readString();
        description = in.readString();
        minValue = in.readDouble();
        maxValue = in.readDouble();
        possibleValuesAsString = in.createStringArray();
        possibleValuesAsInt = in.createIntArray();
        unit = in.readString();
        int size = in.readInt();
        if (size == -1) custom = null;
        else {
            custom = new HashMap<>();
            for (int j = 0; j < size; j++) {
                custom.put(in.readString(), in.readString());
            }
        }

    }

    public static final Creator<DataDescriptor> CREATOR = new Creator<DataDescriptor>() {
        @Override
        public DataDescriptor createFromParcel(Parcel in) {
            return new DataDescriptor(in);
        }

        @Override
        public DataDescriptor[] newArray(int size) {
            return new DataDescriptor[size];
        }
    };

    public String getTitle(){
        return title;
    }
    public String getSummary(){
        return summary;
    }
    public String getDescription(){
        return description;
    }
    public double getMinValue(){
        return minValue;
    }
    public double getMaxValue(){
        return maxValue;
    }
    public String getUnit(){
        return unit;
    }
    public String[] getPossibleValuesAsString(){
        return possibleValuesAsString;
    }
    public int[] getPossibleValuesAsInt(){
        return possibleValuesAsInt;
    }
    public String getValue(String key){
        if(custom==null) return null;
        return custom.get(key);
    }
    private DataDescriptor(Builder builder) {
        title = builder.title;
        summary = builder.summary;
        description = builder.description;
        minValue = builder.minValue;
        maxValue = builder.maxValue;
        unit = builder.unit;
        possibleValuesAsString =builder.possibleValuesAsString;
        possibleValuesAsInt =builder.possibleValuesAsInt;
        custom= builder.custom;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(summary);
        parcel.writeString(description);
        parcel.writeDouble(minValue);
        parcel.writeDouble(maxValue);
        parcel.writeStringArray(possibleValuesAsString);
        parcel.writeIntArray(possibleValuesAsInt);
        parcel.writeString(unit);
        if (custom == null)
            parcel.writeInt(-1);
        else {
            int size = custom.size();
            parcel.writeInt(size);
            for (HashMap.Entry<String, String> entry : custom.entrySet()) {
                parcel.writeString(entry.getKey());
                parcel.writeString(entry.getValue());
            }
        }
    }

    public static class Builder {
        private String title;
        private String summary;
        private String description;
        private double minValue;
        private double maxValue;
        private String unit;
        private String[] possibleValuesAsString;
        private int[] possibleValuesAsInt;
        private HashMap<String, String> custom = new HashMap<>();

        Builder() {
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setMinValue(double minValue) {
            this.minValue = minValue;
            return this;
        }

        public Builder setMaxValue(double maxValue) {
            this.maxValue = maxValue;
            return this;
        }
        public Builder setPossibleValues(String[] possibleValues) {
            this.possibleValuesAsString=possibleValues;
            return this;
        }
        public Builder setPossibleValues(int[] possibleValues) {
            this.possibleValuesAsInt=possibleValues;
            return this;
        }

        public Builder setValue(String key, String value) {
            this.custom.put(key, value);
            return this;
        }

        public Builder setUnit(String unit) {
            this.unit = unit;
            return this;
        }
        public DataDescriptor build() {
            return new DataDescriptor(this);
        }
    }
}
