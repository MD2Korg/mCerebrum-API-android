package org.md2k.mcerebrum.api.core.datakitapi.datatype.datapoint;

import android.support.test.filters.SmallTest;

@SmallTest
public class DataPointIntAndroidUnitTest {
/*    private final long testTimestamp = TestingConstants.TEST_TIMESTAMP;

    private final int testSample = 1;
    private DataPointInt mDataPointInt;

    private final int[] testSampleArray = {-3874901, -1, 0, 1, 784309147};
    private DataPointInt mDataPointIntArray;

    // Create the object.
    @Before
    public void createDataPointInt() {
        mDataPointInt = new DataPointInt(testTimestamp, testSample);
        mDataPointIntArray = new DataPointInt(testTimestamp, testSampleArray);
    }

    @Test
    public void fieldAccuracyTest() {
        assertEquals(testTimestamp, mDataPointInt.getTimestamp());
        assertEquals(testSample, mDataPointInt.getSample()[0]);
        assertEquals(testTimestamp, mDataPointIntArray.getTimestamp());
        assertArrayEquals(testSampleArray, mDataPointIntArray.getSample());
    }

    @Test
    public void dataPointIntCloneTest() {
        DataPointInt dataPointClone = mDataPointInt.clone();
        assertThat(dataPointClone, is(equalTo(mDataPointInt)));
        assertNotSame(mDataPointInt, dataPointClone);
    }

    @Test
    public void dataPointIntParcelableWriteReadTest() {
        // Write data to parcel.
        Parcel parcel = Parcel.obtain();
        mDataPointInt.writeToParcel(parcel, mDataPointInt.describeContents());

        // After writing, reset the parcel for reading
        parcel.setDataPosition(0);

        // Read the data.
        DataPointInt createdFromParcel = DataPointInt.CREATOR.createFromParcel(parcel);
        DataPointInt[] createdFromParcelArray = DataPointInt.CREATOR.newArray(1);

        // Verify results.
        assertNotEquals(0, createdFromParcelArray.length);
        assertThat(createdFromParcel, is(equalTo(mDataPointInt)));
    }

    @Test
    public void dataPointIntArrayParcelableWriteReadTest() {
        // Write data to parcel.
        Parcel parcel = Parcel.obtain();
        mDataPointIntArray.writeToParcel(parcel, mDataPointIntArray.describeContents());

        // After writing, reset the parcel for reading
        parcel.setDataPosition(0);

        // Read the data.
        DataPointInt createdFromParcel = DataPointInt.CREATOR.createFromParcel(parcel);
        DataPointInt[] createdFromParcelArray = DataPointInt.CREATOR.newArray(1);

        // Verify results.
        assertNotEquals(0, createdFromParcelArray.length);
        assertThat(createdFromParcel, is(equalTo(mDataPointIntArray)));
    }

    @Test
    public void dataPointIntHashcodeTest() {
        DataPointInt dataClone = mDataPointInt.clone();
        assertEquals(mDataPointInt.hashCode(), dataClone.hashCode());

        DataPointInt dpbWithDifferentTimestamp = new DataPointInt(testTimestamp + 10, testSample);
        assertNotEquals(dpbWithDifferentTimestamp.hashCode(), dataClone.hashCode());

        DataPointInt dpbWithDifferentSample = new DataPointInt(testTimestamp, 42);
        assertNotEquals(dpbWithDifferentSample.hashCode(), dataClone.hashCode());
    }*/
}