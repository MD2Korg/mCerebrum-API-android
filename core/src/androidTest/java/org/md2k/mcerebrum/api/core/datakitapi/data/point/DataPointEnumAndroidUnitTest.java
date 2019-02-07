package org.md2k.mcerebrum.api.core.datakitapi.data.point;

import android.support.test.filters.SmallTest;

@SmallTest
public class DataPointEnumAndroidUnitTest {
/*    private final long testTimestamp = TestingConstants.TEST_TIMESTAMP;

    private final MCEnum testSample = MCEnumMocker.B;
    private MCData mDataPointEnum;

    private final MCEnum[] testSampleArray = {MCEnumMocker.A, MCEnumMocker.B, MCEnumMocker.C};
    private MCData mDataPointEnumArray;

    // Create the object.
    @Before
    public void createDataPointEnum() {
        mDataPointEnum = MCData.createPointEnumArray(testTimestamp, MCEnumMocker.A);
        mDataPointEnumArray = MCData.createPointEnumArray(testTimestamp, testSampleArray);
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
        MCData dataPointClone = mDataPointEnum.clone();
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
        MCData createdFromParcel = MCData.CREATOR.createFromParcel(parcel);
        MCData[] createdFromParcelArray = MCData.CREATOR.newArray(1);

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
        MCData createdFromParcel = MCData.CREATOR.createFromParcel(parcel);
        MCData[] createdFromParcelArray = MCData.CREATOR.newArray(1);

        // Verify results.
        assertNotEquals(0, createdFromParcelArray.length);
        assertThat(createdFromParcel, is(equalTo(mDataPointEnumArray)));
    }

    @Test
    public void dataPointEnumHashcodeTest() {
        MCData dataClone = mDataPointEnum.clone();
        assertEquals(mDataPointEnum.hashCode(), dataClone.hashCode());

        MCData dpbWithDifferentTimestamp = new DataPointEnum(testTimestamp + 10, testSample);
        assertNotEquals(dpbWithDifferentTimestamp.hashCode(), dataClone.hashCode());

        MCData dpbWithDifferentSample = new DataPointEnum(testTimestamp, (byte)1010);
        assertNotEquals(dpbWithDifferentSample.hashCode(), dataClone.hashCode());
    }*/
}