package org.md2k.mcerebrum.api.core.datakitapi.datatype.datapoint;

import android.support.test.filters.SmallTest;

@SmallTest
public class DataPointEnumAndroidUnitTest {
/*    private final long testTimestamp = TestingConstants.TEST_TIMESTAMP;

    private final byte testSample = 1;
    private DataPointEnum mDataPointEnum;

    private final byte[] testSampleArray = {-126, -1, 0, 1, 127};
    private DataPointEnum mDataPointEnumArray;

    // Create the object.
    @Before
    public void createDataPointEnum() {
        mDataPointEnum = new DataPointEnum(testTimestamp, testSample);
        mDataPointEnumArray = new DataPointEnum(testTimestamp, testSampleArray);
    }

    @Test
    public void fieldAccuracyTest() {
        assertEquals(testTimestamp, mDataPointEnum.getTimestamp());
        assertEquals(testSample, mDataPointEnum.getSample()[0]);
        assertEquals(testTimestamp, mDataPointEnumArray.getTimestamp());
        assertArrayEquals(testSampleArray, mDataPointEnumArray.getSample());
    }

    @Test
    public void dataPointEnumCloneTest() {
        DataPointEnum dataPointClone = mDataPointEnum.clone();
        assertThat(dataPointClone, is(equalTo(mDataPointEnum)));
        assertNotSame(mDataPointEnum, dataPointClone);
    }

    @Test
    public void dataPointEnumParcelableWriteReadTest() {
        // Write data to parcel.
        Parcel parcel = Parcel.obtain();
        mDataPointEnum.writeToParcel(parcel, mDataPointEnum.describeContents());

        // After writing, reset the parcel for reading
        parcel.setDataPosition(0);

        // Read the data.
        DataPointEnum createdFromParcel = DataPointEnum.CREATOR.createFromParcel(parcel);
        DataPointEnum[] createdFromParcelArray = DataPointEnum.CREATOR.newArray(1);

        // Verify results.
        assertNotEquals(0, createdFromParcelArray.length);
        assertThat(createdFromParcel, is(equalTo(mDataPointEnum)));
    }

    @Test
    public void dataPointEnumArrayParcelableWriteReadTest() {
        // Write data to parcel.
        Parcel parcel = Parcel.obtain();
        mDataPointEnumArray.writeToParcel(parcel, mDataPointEnumArray.describeContents());

        // After writing, reset the parcel for reading
        parcel.setDataPosition(0);

        // Read the data.
        DataPointEnum createdFromParcel = DataPointEnum.CREATOR.createFromParcel(parcel);
        DataPointEnum[] createdFromParcelArray = DataPointEnum.CREATOR.newArray(1);

        // Verify results.
        assertNotEquals(0, createdFromParcelArray.length);
        assertThat(createdFromParcel, is(equalTo(mDataPointEnumArray)));
    }

    @Test
    public void dataPointEnumHashcodeTest() {
        DataPointEnum dataClone = mDataPointEnum.clone();
        assertEquals(mDataPointEnum.hashCode(), dataClone.hashCode());

        DataPointEnum dpbWithDifferentTimestamp = new DataPointEnum(testTimestamp + 10, testSample);
        assertNotEquals(dpbWithDifferentTimestamp.hashCode(), dataClone.hashCode());

        DataPointEnum dpbWithDifferentSample = new DataPointEnum(testTimestamp, (byte)1010);
        assertNotEquals(dpbWithDifferentSample.hashCode(), dataClone.hashCode());
    }*/
}