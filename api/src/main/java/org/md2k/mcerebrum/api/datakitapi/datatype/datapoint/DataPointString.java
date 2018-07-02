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

package org.md2k.mcerebrum.api.datakitapi.datatype.datapoint;

import android.os.Parcel;
import android.os.Parcelable;

import org.md2k.mcerebrum.api.datakitapi.datatype.Data;

import java.util.Arrays;

/**
 * This class creates <code>DataType</code> objects for samples that have string data types in an array.
 */
public class DataPointString extends Data implements Parcelable {

    /**
     * The data point collected from the data source.
     */
    private String[] sample;

    /**
     * Constructor
     *
     * @param timestamp The timestamp for when the data was collected.
     * @param sample The data point sampled from the data source.
     */
    public DataPointString(long timestamp, String[] sample) {
        super(timestamp);
        this.sample = new String[sample.length];
        System.arraycopy(sample, 0, this.sample, 0, sample.length);
    }
    public DataPointString(long timestamp, String sample) {
        super(timestamp);
        this.sample = new String[1];
        this.sample[0] = sample;
    }

    public DataPointString clone(){
        return new DataPointString(getTimestamp(), sample);
    }

    /**
     * Constructs a <code>DataTypeStringArray</code> object from a <code>Parcel</code>.
     *
     * @param in Parceled <code>DataTypeStringArray</code> object.
     */
    protected DataPointString(Parcel in) {
        super(in);
        sample = in.createStringArray();
    }

    /**
     * Writes the <code>DataTypeStringArray</code> to a parcel.
     *
     * @param dest  The parcel to which the application should be written.
     * @param flags Additional flags about how the object should be written.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeStringArray(sample);
    }

    /**
     * @return Always returns 0.
     */
    @Override
    public int describeContents() {
        return 0;
    }


    /**
     * @return The the value of the sample.
     */
    public String[] getSample() {
        return sample;
    }

    /**
     * <code>Creator</code> for <code>DataTypeStringArray</code> objects.
     */
    public static final Creator<DataPointString> CREATOR = new Creator<DataPointString>() {

        /**
         * Creates a new <code>DataTypeStringArray</code> object from a <code>Parcel</code>.
         *
         * @param in The parcel holding the data type.
         * @return The constructed <code>DataTypeStringArray</code> object
         */
        @Override
        public DataPointString createFromParcel(Parcel in) {
            return new DataPointString(in);
        }

        /**
         * Creates a new array of the specified size for <code>DataTypeStringArray</code> objects.
         *
         * @param size The size of the new <code>DataTypeStringArray</code> array.
         * @return The <code>DataTypeStringArray</code> array.
         */
        @Override
        public DataPointString[] newArray(int size) {
            return new DataPointString[size];
        }
    };
}
