package org.md2k.mcerebrum.api.core.datakitapi.data;

import android.support.test.filters.SmallTest;

@SmallTest
public class DataSetAndroidUnitTest {
/*
    private final int actualDataSize = 0;
    private final int receivedDataSize = 1; //890589984
    private int[] samplingTypes = {DataSet.SAMPLING_TYPE.ALL.getCode(),
                                   DataSet.SAMPLING_TYPE.FIRST_N_SAMPLE.getCode(),
                                   DataSet.SAMPLING_TYPE.DISTRIBUTED_N_SAMPLE.getCode()};
    private int[] statuses = TestingConstants.STATUS_INT_ARRAY;

    private long testTimestamp = 1268660460;
    private DataPointBoolean testDataPointBoolean = DataPointMocker.createDataPointBoolean();
    private DataPointByte testDataPointByte = DataPointMocker.createDataPointByte();
    private DataPointDouble testDataPointDouble = DataPointMocker.createDataPointDouble();
    private DataPointEnum testDataPointEnum = DataPointMocker.createDataPointEnum();
    private DataPointInt testDataPointInt = DataPointMocker.createDataPointInt();
    private DataPointLong testDataPointLong = DataPointMocker.createDataPointLong();
    private DataPointObject testDataPointObject = DataPointObjectMocker.createDPOAllTypeArray();
    private DataPointString testDataPointString = DataPointMocker.createDataPointString();
    private DataAnnotationEnum testDataAnnotationEnum = DataPointMocker.createDataAnnoEnum();
    private DataPointBoolean testDataPointBooleanArray = DataPointMocker.createDataPointBooleanArray();
    private DataPointByte testDataPointByteArray = DataPointMocker.createDataPointByteArray();
    private DataPointDouble testDataPointDoubleArray = DataPointMocker.createDataPointDoubleArray();
    private DataPointEnum testDataPointEnumArray = DataPointMocker.createDataPointEnumArray();
    private DataPointInt testDataPointIntArray = DataPointMocker.createDataPointIntArray();
    private DataPointLong testDataPointLongArray = DataPointMocker.createDataPointLongArray();
    private DataPointString testDataPointStringArray = DataPointMocker.createDataPointStringArray();


    private Data testData = new Data(testTimestamp);
    private Data[] data = {testDataPointBoolean, testDataPointByte, testDataPointDouble,
                           testDataPointEnum, testDataPointInt, testDataPointLong, testDataPointObject,
                           testDataPointString, testDataAnnotationEnum, testDataPointBooleanArray,
                           testDataPointByteArray, testDataPointDoubleArray, testDataPointEnumArray,
                           testDataPointIntArray, testDataPointLongArray, testDataPointStringArray, testData};
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
    public void dataSetSamplingAllParcelableWriteReadTest() {
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
        assertNotEquals(0, createdFromParcelArrayAll.length);
        assertThat(createdFromParcelAll, is(equalTo(testDataSetSamplingAll)));
    }

    @Test
    public void dataSetSamplingFirstNParcelableWriteReadTest() {
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
        assertNotEquals(0, createdFromParcelArrayFirstN.length);
        assertThat(createdFromParcelFirstN, is(equalTo(testDataSetSamplingFirstN)));
    }

    @Test
    public void dataSetSamplingDistributedNParcelableWriteReadTest() {
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
        assertNotEquals(0, createdFromParcelArrayDistributedN.length);
        assertThat(createdFromParcelDistributedN, is(equalTo(testDataSetSamplingDistributedN)));
    }

    @Test
    public void dataSetHashCodeTest() {
        DataSet testDataSetSamplingAll2 = new DataSet(data, actualDataSize, receivedDataSize, samplingTypes[0]);
        assertEquals(testDataSetSamplingAll.hashCode(), testDataSetSamplingAll2.hashCode());
    }
*/
}
