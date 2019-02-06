package org.md2k.mcerebrum.api.core.datakitapi.datatype.datapoint;

import android.support.test.filters.SmallTest;

@SmallTest
public class DataPointLongAndroidUnitTest {
/*    private static final double DELTA = TestingConstants.DELTA;
    private final long testTimestamp = TestingConstants.TEST_TIMESTAMP;

    private final long testSample = 1;
    private DataPointLong mDataPointLong;

    private final long[] testSampleArray = {-3874901, -1, 0, 1, 784309147};
    private DataPointLong mDataPointLongArray;

    // Create the object.
    @Before
    public void createDataPointLong() {
        mDataPointLong = new DataPointLong(testTimestamp, testSample);
        mDataPointLongArray = new DataPointLong(testTimestamp, testSampleArray);
    }

    @Test
    public void fieldAccuracyTest() {
        assertEquals(testTimestamp, mDataPointLong.getTimestamp());
        assertEquals(testSample, mDataPointLong.getSample()[0], DELTA);
        assertEquals(testTimestamp, mDataPointLongArray.getTimestamp());
        assertArrayEquals(testSampleArray, mDataPointLongArray.getSample());
    }

    @Test
    public void dataPointLongCloneTest() {
        DataPointLong dataPointClone = mDataPointLong.clone();
        assertThat(dataPointClone, is(equalTo(mDataPointLong)));
        assertNotSame(mDataPointLong, dataPointClone);
    }

    @Test
    public void dataPointLongParcelableWriteReadTest() {
        // Write data to parcel.
        Parcel parcel = Parcel.obtain();
        mDataPointLong.writeToParcel(parcel, mDataPointLong.describeContents());

        // After writing, reset the parcel for reading
        parcel.setDataPosition(0);

        // Read the data.
        DataPointLong createdFromParcel = DataPointLong.CREATOR.createFromParcel(parcel);
        DataPointLong[] createdFromParcelArray = DataPointLong.CREATOR.newArray(1);

        // Verify results.
        assertNotEquals(0, createdFromParcelArray.length);
        assertThat(createdFromParcel, is(equalTo(mDataPointLong)));
    }

    @Test
    public void dataPointLongArrayParcelableWriteReadTest() {
        // Write data to parcel.
        Parcel parcel = Parcel.obtain();
        mDataPointLongArray.writeToParcel(parcel, mDataPointLongArray.describeContents());

        // After writing, reset the parcel for reading
        parcel.setDataPosition(0);

        // Read the data.
        DataPointLong createdFromParcel = DataPointLong.CREATOR.createFromParcel(parcel);
        DataPointLong[] createdFromParcelArray = DataPointLong.CREATOR.newArray(1);

        // Verify results.
        assertNotEquals(0, createdFromParcelArray.length);
        assertThat(createdFromParcel, is(equalTo(mDataPointLongArray)));
    }


    @Test
    public void dataPointLongHashcodeTest() {
        DataPointLong dataClone = mDataPointLong.clone();
        assertEquals(mDataPointLong.hashCode(), dataClone.hashCode());

        DataPointLong dpbWithDifferentTimestamp = new DataPointLong(testTimestamp + 10, testSample);
        assertNotEquals(dpbWithDifferentTimestamp.hashCode(), dataClone.hashCode());

        DataPointLong dpbWithDifferentSample = new DataPointLong(testTimestamp, (long)475894890);
        assertNotEquals(dpbWithDifferentSample.hashCode(), dataClone.hashCode());
    }*/
}