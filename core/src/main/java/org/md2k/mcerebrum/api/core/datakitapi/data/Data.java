package org.md2k.mcerebrum.api.core.datakitapi.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.Arrays;

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
public class Data implements Parcelable {
    private DataType dataType;
    private SampleType sampleType;
    private long startTimestamp;
    private long endTimestamp;
    private Object sample;

    /**
     * Constructor
     * This constructor creates an <code>Data</code> object from a <code>Parcel</code>.
     *
     * @param in Parceled <code>Data</code> object.
     */
    protected Data(Parcel in) {
        switch (sampleType) {
            case BYTE_ARRAY:
                in.readByteArray((byte[]) sample);
                break;
            case INT_ARRAY:
                in.readIntArray((int[]) sample);
                break;
            case BOOLEAN_ARRAY:
                in.readBooleanArray((boolean[]) sample);
                break;
            case LONG_ARRAY:
                in.readLongArray((long[]) sample);
                break;
            case DOUBLE_ARRAY:
                in.readDoubleArray((double[]) sample);
                break;
            case STRING_ARRAY:
            case OBJECT:
            case ENUM:
                in.readStringArray((String[]) sample);
                break;
        }

    }

    /**
     * Embedded <code>CREATOR</code> class for generating instances of <code>Data</code>
     * from a <code>Parcel</code>.
     */
    public static final Creator<Data> CREATOR = new Creator<Data>() {

        /**
         * Creates an <code>Data</code> object from a <code>Parcel</code>.
         *
         * @param in <code>Parcel</code> containing the <code>Data</code>.
         * @return The constructed <code>Data</code>.
         */
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        /**
         * Creates an array for <code>Data</code> of the given size.
         *
         * @param size Size of the array to create.
         * @return Returns an array for <code>Data</code> objects.
         */
        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    /**
     * Constructor
     * This constructor to create data from the sample.
     *
     * @param dataType       The data type (POINT/ANNOTATION/...).
     * @param sampleType     The sample type (BOOLEAN_ARRAY/INTEGER_ARRAY/...).
     * @param startTimestamp The start timestamp for when the event was started.
     * @param endTimestamp   The end timestamp for when the event was ended.
     * @param sample         The data  sampled from the data source.
     */
    private Data(DataType dataType, SampleType sampleType, long startTimestamp, long endTimestamp, Object sample) {
        this.dataType = dataType;
        this.sampleType = sampleType;
        this.sample = sample;
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
    }

    /**
     * Returns the type of the data.
     *
     * @return The type of the data.
     */
    public DataType getDataType() {
        return dataType;
    }

    /**
     * Returns the value of the start timestamp.
     *
     * @return The the value of the start timestamp.
     */
    public long getStartTimestamp() {
        return startTimestamp;
    }

    /**
     * Returns the value of the end timestamp.
     *
     * @return The the value of the end timestamp.
     */
    public long getEndTimestamp() {
        return endTimestamp;
    }

    /**
     * Returns the value of the timestamp.
     *
     * @return The the value of the timestamp.
     */
    public long getTimestamp() {
        return startTimestamp;
    }

    /**
     * Returns the type of the sample.
     *
     * @return The type of the sample.
     */
    public SampleType getSampleType() {
        return sampleType;
    }

    /**
     * Returns the sample (converted to assigned type).
     *
     * @return The sample  (converted to assigned type).
     */
    public <T extends Object> T getSample() {
        return (T) sample;
    }

    /**
     * Always returns 0 because this parcel doesn't contain any special objects.
     * From <a href = https://developer.android.com/reference/android/os/Parcelable>Google's Android documentation</a>:
     * Describe the kinds of special objects contained in this Parcelable instance's marshaled representation.
     * For example, if the object will include a file descriptor in the output of
     * writeToParcel(Parcel, int), the return value of this method must include the CONTENTS_FILE_DESCRIPTOR bit.
     *
     * @return 0.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Writes the calling <code>DataPointBoolean</code> to the passed <code>Parcel</code>.
     *
     * @param dest  <code>Parcel</code> to write to.
     * @param flags This should always be the value returned from <code>describeContents()</code>.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(sampleType.getValue());
        switch (sampleType) {
            case BYTE_ARRAY:
                dest.writeByteArray((byte[]) sample);
                break;
            case INT_ARRAY:
                dest.writeIntArray((int[]) sample);
                break;
            case BOOLEAN_ARRAY:
                dest.writeBooleanArray((boolean[]) sample);
                break;
            case LONG_ARRAY:
                dest.writeLongArray((long[]) sample);
                break;
            case DOUBLE_ARRAY:
                dest.writeDoubleArray((double[]) sample);
                break;
            case STRING_ARRAY:
            case OBJECT:
            case ENUM:
                dest.writeStringArray((String[]) sample);
                break;
        }
    }


    /**
     * Creates a data point where the sample type is byte array.
     *
     * @param timestamp The timestamp for when the data was collected.
     * @param sample    The sample that was collected.
     */
    public static Data createPoint(long timestamp, byte[] sample) {
        return new Data(DataType.POINT, SampleType.BYTE_ARRAY, timestamp, timestamp, sample);
    }

    /**
     * Creates a data point where the sample type is enum.
     *
     * @param timestamp The timestamp for when the data was collected.
     * @param sample    The sample that was collected.
     */
    public static Data createPoint(long timestamp, EnumType sample) {
        return new Data(DataType.POINT, SampleType.ENUM, timestamp, timestamp, new String[]{String.valueOf(sample.getId()), sample.getName()});
    }

    /**
     * Creates a data point where the sample type is boolean array.
     *
     * @param timestamp The timestamp for when the data was collected.
     * @param sample    The sample that was collected.
     */
    public static Data createPoint(long timestamp, boolean[] sample) {
        return new Data(DataType.POINT, SampleType.BOOLEAN_ARRAY, timestamp, timestamp, sample);
    }

    /**
     * Creates a data point where the sample type is integer array.
     *
     * @param timestamp The timestamp for when the data was collected.
     * @param sample    The sample that was collected.
     */
    public static Data createPoint(long timestamp, int[] sample) {
        return new Data(DataType.POINT, SampleType.INT_ARRAY, timestamp, timestamp, sample);
    }

    /**
     * Creates a data point where the sample type is long array.
     *
     * @param timestamp The timestamp for when the data was collected.
     * @param sample    The sample that was collected.
     */
    public static Data createPoint(long timestamp, long[] sample) {
        return new Data(DataType.POINT, SampleType.LONG_ARRAY, timestamp, timestamp, sample);
    }

    /**
     * Creates a data point where the sample type is double array.
     *
     * @param timestamp The timestamp for when the data was collected.
     * @param sample    The sample that was collected.
     */
    public static Data createPoint(long timestamp, double[] sample) {
        return new Data(DataType.POINT, SampleType.DOUBLE_ARRAY, timestamp, timestamp, sample);
    }

    /**
     * Creates a data point where the sample type is string array.
     *
     * @param timestamp The timestamp for when the data was collected.
     * @param sample    The sample that was collected.
     */
    public static Data createPoint(long timestamp, String[] sample) {
        return new Data(DataType.POINT, SampleType.STRING_ARRAY, timestamp, timestamp, sample);
    }

    /**
     * Creates a data point where the sample type is object.
     *
     * @param timestamp The timestamp for when the data was collected.
     * @param sample    The sample that was collected.
     */
    public static <T> Data createPoint(long timestamp, T sample) {
        Gson gson = new Gson();
        String str = gson.toJson(sample);
        return new Data(DataType.POINT, SampleType.OBJECT, timestamp, timestamp, str);
    }

    /**
     * Creates a data annotation where the sample type is enum.
     *
     * @param startTimestamp The timestamp of the beginning of the data collection.
     * @param endTimestamp   The timestamp of the end of the data collection.
     * @param sample         The sample that was collected.
     */
    public static Data createAnnotation(long startTimestamp, long endTimestamp, EnumType sample) {
        return new Data(DataType.ANNOTATION, SampleType.ENUM, startTimestamp, endTimestamp, new String[]{String.valueOf(sample.getId()), sample.getName()});
    }

    /**
     * Creates a data annotation where the sample type is boolean array.
     *
     * @param startTimestamp The timestamp of the beginning of the data collection.
     * @param endTimestamp   The timestamp of the end of the data collection.
     * @param sample         The sample that was collected.
     */
    public static Data createAnnotation(long startTimestamp, long endTimestamp, boolean[] sample) {
        return new Data(DataType.ANNOTATION, SampleType.BOOLEAN_ARRAY, startTimestamp, endTimestamp, sample);
    }

    /**
     * Creates a data annotation where the sample type is integer array.
     *
     * @param startTimestamp The timestamp of the beginning of the data collection.
     * @param endTimestamp   The timestamp of the end of the data collection.
     * @param sample         The sample that was collected.
     */
    public static Data createAnnotation(long startTimestamp, long endTimestamp, int[] sample) {
        return new Data(DataType.ANNOTATION, SampleType.INT_ARRAY, startTimestamp, endTimestamp, sample);
    }

    /**
     * Creates a data annotation where the sample type is long array.
     *
     * @param startTimestamp The timestamp of the beginning of the data collection.
     * @param endTimestamp   The timestamp of the end of the data collection.
     * @param sample         The sample that was collected.
     */
    public static Data createAnnotation(long startTimestamp, long endTimestamp, long[] sample) {
        return new Data(DataType.ANNOTATION, SampleType.LONG_ARRAY, startTimestamp, endTimestamp, sample);
    }

    /**
     * Creates a data annotation where the sample type is double array.
     *
     * @param startTimestamp The timestamp of the beginning of the data collection.
     * @param endTimestamp   The timestamp of the end of the data collection.
     * @param sample         The sample that was collected.
     */
    public static Data createAnnotation(long startTimestamp, long endTimestamp, double[] sample) {
        return new Data(DataType.ANNOTATION, SampleType.DOUBLE_ARRAY, startTimestamp, endTimestamp, sample);
    }

    /**
     * Creates a data annotation where the sample type is string array.
     *
     * @param startTimestamp The timestamp of the beginning of the data collection.
     * @param endTimestamp   The timestamp of the end of the data collection.
     * @param sample         The sample that was collected.
     */
    public static Data createAnnotation(long startTimestamp, long endTimestamp, String[] sample) {
        return new Data(DataType.ANNOTATION, SampleType.STRING_ARRAY, startTimestamp, endTimestamp, sample);
    }

    /**
     * Creates a data annotation where the sample type is object.
     *
     * @param startTimestamp The timestamp of the beginning of the data collection.
     * @param endTimestamp   The timestamp of the end of the data collection.
     * @param sample         The sample that was collected.
     */
    public static <T> Data createAnnotation(long startTimestamp, long endTimestamp, T sample) {
        Gson gson = new Gson();
        String str = gson.toJson(sample);
        return new Data(DataType.ANNOTATION, SampleType.OBJECT, startTimestamp, endTimestamp, str);
    }

    /**
     * Creates a new <code>Data</code> object with the fields of the calling object.
     *
     * @return A new <code>Data</code>.
     */
    public Data clone() {
        return new Data(dataType, sampleType, startTimestamp, endTimestamp, sample);
    }

    /**
     * Compares the passed object to the calling object.
     * If the passed object is not an instance of this class, false is returned.
     *
     * @param toCompare Object to compare.
     * @return True if the objects are equivalent and false if they are not.
     */
    @Override
    public boolean equals(Object toCompare) {
        return (toCompare instanceof Data
                && this.getDataType().equals(((Data) toCompare).getDataType())
                && this.getSampleType().equals(((Data) toCompare).getSampleType())
                && this.getStartTimestamp() == ((Data) toCompare).getStartTimestamp()
                && this.getEndTimestamp() == ((Data) toCompare).getEndTimestamp()
                && this.getSample().equals(((Data) toCompare).getSample())

        );
    }
/*
    public boolean equalsIgnoreTimestamp(Data data){
        if(toCompare )
    }
    private boolean equalsSample(Data ){

    }
*/

    /**
     * Calculates and returns a hash code for the calling object.
     * The hash code is calculated using the method denoted in "Effective Java" and described in this Medium
     * <a href="https://medium.com/codelog/overriding-hashcode-method-effective-java-notes-723c1fedf51c">post</a>.
     *
     * @return The hash code of the calling object.
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + dataType.hashCode();
        result = 31 * result + sampleType.hashCode();
        result = 31 * result + (int) (startTimestamp ^ (startTimestamp >>> 32));
        result = 31 * result + (int) (endTimestamp ^ (endTimestamp >>> 32));
        switch (sampleType) {
            case INT_ARRAY:
                result = 31 * result + Arrays.hashCode((int[]) sample);
                break;
            case LONG_ARRAY:
                result = 31 * result + Arrays.hashCode((long[]) sample);
                break;
            case DOUBLE_ARRAY:
                result = 31 * result + Arrays.hashCode((double[]) sample);
                break;
            case BYTE_ARRAY:
                result = 31 * result + Arrays.hashCode((byte[]) sample);
                break;
            case BOOLEAN_ARRAY:
                result = 31 * result + Arrays.hashCode((boolean[]) sample);
                break;
            case STRING_ARRAY:
                result = 31 * result + Arrays.hashCode((String[]) sample);
                break;
            case OBJECT:
                result = 31 * result + sample.hashCode();
                break;
        }
//        result = 31 * result + sample.hashCode();
        return result;
    }

}
