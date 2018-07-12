package org.md2k.mcerebrum.api.core.datakitapi.datatype;

import android.os.Parcel;
import android.support.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.md2k.mcerebrum.api.core.datakitapi.datatype.dataannotation.DataAnnotationEnum;
import org.md2k.mcerebrum.api.core.datakitapi.datatype.datapoint.DataPointBoolean;
import org.md2k.mcerebrum.api.core.datakitapi.datatype.datapoint.DataPointByte;
import org.md2k.mcerebrum.api.core.datakitapi.datatype.datapoint.DataPointDouble;
import org.md2k.mcerebrum.api.core.datakitapi.datatype.datapoint.DataPointEnum;
import org.md2k.mcerebrum.api.core.datakitapi.datatype.datapoint.DataPointInt;
import org.md2k.mcerebrum.api.core.datakitapi.datatype.datapoint.DataPointLong;
import org.md2k.mcerebrum.api.core.datakitapi.datatype.datapoint.DataPointObject;
import org.md2k.mcerebrum.api.core.datakitapi.datatype.datapoint.DataPointString;
import org.md2k.mcerebrum.api.core.datakitapi.status.MCerebrumStatus;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SmallTest
public class DataSetAndroidUnitTest {
    private int actualDataSize = 100;
    private int receivedDataSize = 101;
    private int[] samplingTypes = {DataSet.SAMPLING_TYPE.ALL.getCode(),
                                   DataSet.SAMPLING_TYPE.FIRST_N_SAMPLE.getCode(),
                                   DataSet.SAMPLING_TYPE.DISTRIBUTED_N_SAMPLE.getCode()};
    private int[] statuses = {MCerebrumStatus.UNKNOWN_ERROR, MCerebrumStatus.SUCCESS,
                              MCerebrumStatus.MCEREBRUM_API_NOT_INITIALIZED,
                              MCerebrumStatus.MCEREBRUM_APP_NOT_INSTALLED,
                              MCerebrumStatus.CONNECTION_ERROR, MCerebrumStatus.INVALID_PARAMETER,
                              MCerebrumStatus.INVALID_DATA_SOURCE,
                              MCerebrumStatus.MISSING_DATA_SOURCE_TYPE, MCerebrumStatus.MISSING_DATA_TYPE,
                              MCerebrumStatus.DATA_SOURCE_NOT_REGISTERED, MCerebrumStatus.INVALID_DATA,
                              MCerebrumStatus.INCONSISTENT_DATA_TYPE, MCerebrumStatus.INVALID_TIMESTAMP,
                              MCerebrumStatus.DATA_SIZE_TOO_LARGE};

    private long testTimestamp = 1268660460;
    private long testStartTimestamp = 1268660060;
    private long testEndTimestamp = 1268660460;
    private final boolean testSampleBoolean = true;
    private DataPointBoolean testDataPointBoolean = new DataPointBoolean(testTimestamp, testSampleBoolean);
    private final byte testSampleByte = 1;
    private DataPointByte testDataPointByte = new DataPointByte(testTimestamp, testSampleByte);
    private final double testSampleDouble = 6.2831853071;
    private DataPointDouble testDataPointDouble = new DataPointDouble(testTimestamp, testSampleDouble);
    private final byte testSampleEnum = 1;
    private DataPointEnum testDataPointEnum = new DataPointEnum(testTimestamp, testSampleEnum);
    private final int testSampleInt = -1;
    private DataPointInt testDataPointInt = new DataPointInt(testTimestamp, testSampleInt);
    private final long testSampleLong = -3874901;
    private DataPointLong testDataPointLong = new DataPointLong(testTimestamp, testSampleLong);
    private final String testSampleObject = "Hello object";
    private DataPointObject testDataPointObject= new DataPointObject(testTimestamp, testSampleObject);
    private final String testSampleString = "Hello string";
    private DataPointString testDataPointString = new DataPointString(testTimestamp, testSampleString);
    private byte testSampleAnnotationEnum = 127;
    private DataAnnotationEnum testDataAnnotationEnum = new DataAnnotationEnum(testStartTimestamp,
            testEndTimestamp, testSampleAnnotationEnum);
    private Data testData = new Data(testTimestamp);
    private Data[] data = {testDataPointBoolean, testDataPointByte, testDataPointDouble,
                           testDataPointEnum, testDataPointInt, testDataPointLong, testDataPointObject,
                           testDataPointString, testDataAnnotationEnum, testData};
    private DataSet testDataSetSamplingAll;
    private DataSet testDataSetSamplingFirstN;
    private DataSet testDataSetSamplingDistributedN;

    @Before
    public void createDataSets() {
        testDataSetSamplingAll = new DataSet(data, actualDataSize, receivedDataSize, samplingTypes[0]);
        testDataSetSamplingFirstN = new DataSet(data, actualDataSize, receivedDataSize, samplingTypes[1]);
        testDataSetSamplingDistributedN = new DataSet(data, actualDataSize, receivedDataSize, samplingTypes[2]);
    }

    @Test
    public void statusTest() {
        for (int status : statuses) {
            testDataSetSamplingAll.setStatus(status);
            testDataSetSamplingFirstN.setStatus(status);
            testDataSetSamplingDistributedN.setStatus(status);
            assertEquals(status, testDataSetSamplingAll.getStatus());
            assertEquals(status, testDataSetSamplingFirstN.getStatus());
            assertEquals(status, testDataSetSamplingDistributedN.getStatus());
        }
    }

    @Test
    public void dataSetSamplingAll_ParcelableWriteRead() {
        // Write data to parcel.
        Parcel parcelAll = Parcel.obtain();
        testDataSetSamplingAll.writeToParcel(parcelAll, testDataSetSamplingAll.describeContents());

        // After writing, reset the parcel for reading
        parcelAll.setDataPosition(0);

        // Read the data.
        DataSet createdFromParcelAll = DataSet.CREATOR.createFromParcel(parcelAll);
        DataSet[] createdFromParcelArrayAll = DataSet.CREATOR.newArray(1);
        DataSet readFromParcelAll = new DataSet();
        readFromParcelAll.readFromParcel(parcelAll);

        // Verify results.
        assertThat(createdFromParcelArrayAll.length, is(not(0)));
        assertEquals(testDataSetSamplingAll.getActualDataSize(), createdFromParcelAll.getActualDataSize());
        assertEquals(testDataSetSamplingAll.getReceivedDataSize(), createdFromParcelAll.getReceivedDataSize());
        assertArrayEquals(testDataSetSamplingAll.getData(), createdFromParcelAll.getData());
        assertEquals(DataSet.SAMPLING_TYPE.ALL.getCode(), createdFromParcelAll.getSamplingType());

        assertEquals(testDataSetSamplingAll.getActualDataSize(), readFromParcelAll.getActualDataSize());
        assertEquals(testDataSetSamplingAll.getReceivedDataSize(), readFromParcelAll.getReceivedDataSize());
        assertArrayEquals(testDataSetSamplingAll.getData(), readFromParcelAll.getData());
        assertEquals(DataSet.SAMPLING_TYPE.ALL.getCode(), readFromParcelAll.getSamplingType());
    }

    @Test
    public void dataSetSamplingFirstN_ParcelableWriteRead() {
        // Write data to parcel.
        Parcel parcelFirstN = Parcel.obtain();
        testDataSetSamplingFirstN.writeToParcel(parcelFirstN, testDataSetSamplingFirstN.describeContents());

        // After writing, reset the parcel for reading
        parcelFirstN.setDataPosition(0);

        // Read the data.
        DataSet createdFromParcelFirstN = DataSet.CREATOR.createFromParcel(parcelFirstN);
        DataSet[] createdFromParcelArrayFirstN = DataSet.CREATOR.newArray(1);
        DataSet readFromParcelFirstN = new DataSet();
        readFromParcelFirstN.readFromParcel(parcelFirstN);

        // Verify results.
        assertThat(createdFromParcelArrayFirstN.length, is(not(0)));
        assertEquals(testDataSetSamplingFirstN.getActualDataSize(), createdFromParcelFirstN.getActualDataSize());
        assertEquals(testDataSetSamplingFirstN.getReceivedDataSize(), createdFromParcelFirstN.getReceivedDataSize());
        assertArrayEquals(testDataSetSamplingFirstN.getData(), createdFromParcelFirstN.getData());
        assertEquals(DataSet.SAMPLING_TYPE.FIRST_N_SAMPLE.getCode(), createdFromParcelFirstN.getSamplingType());

        assertEquals(testDataSetSamplingFirstN.getActualDataSize(), readFromParcelFirstN.getActualDataSize());
        assertEquals(testDataSetSamplingFirstN.getReceivedDataSize(), readFromParcelFirstN.getReceivedDataSize());
        assertArrayEquals(readFromParcelFirstN.getData(), testDataSetSamplingFirstN.getData());
        assertEquals(DataSet.SAMPLING_TYPE.FIRST_N_SAMPLE.getCode(), readFromParcelFirstN.getSamplingType());
    }

    @Test
    public void dataSetSamplingDistributedN_ParcelableWriteRead() {
        // Write data to parcel.
        Parcel parcelDistributedN = Parcel.obtain();
        testDataSetSamplingDistributedN.writeToParcel(parcelDistributedN,
                testDataSetSamplingDistributedN.describeContents());

        // After writing, reset the parcel for reading
        parcelDistributedN.setDataPosition(0);

        // Read the data.
        DataSet createdFromParcelDistributedN = DataSet.CREATOR.createFromParcel(parcelDistributedN);
        DataSet[] createdFromParcelArrayDistributedN = DataSet.CREATOR.newArray(1);
        DataSet readFromParcelDistributedN = new DataSet();
        readFromParcelDistributedN.readFromParcel(parcelDistributedN);

        // Verify results.
        assertThat(createdFromParcelArrayDistributedN.length, is(not(0)));
        assertEquals(testDataSetSamplingDistributedN.getActualDataSize(), createdFromParcelDistributedN.getActualDataSize());
        assertEquals(testDataSetSamplingDistributedN.getReceivedDataSize(), createdFromParcelDistributedN.getReceivedDataSize());
        assertArrayEquals(testDataSetSamplingDistributedN.getData(), createdFromParcelDistributedN.getData());
        assertEquals(DataSet.SAMPLING_TYPE.DISTRIBUTED_N_SAMPLE.getCode(), createdFromParcelDistributedN.getSamplingType());

        assertEquals(testDataSetSamplingDistributedN.getActualDataSize(), readFromParcelDistributedN.getActualDataSize());
        assertEquals(testDataSetSamplingDistributedN.getReceivedDataSize(), readFromParcelDistributedN.getReceivedDataSize());
        assertArrayEquals(testDataSetSamplingDistributedN.getData(), readFromParcelDistributedN.getData());
        assertEquals(DataSet.SAMPLING_TYPE.DISTRIBUTED_N_SAMPLE.getCode(), readFromParcelDistributedN.getSamplingType());
    }
}