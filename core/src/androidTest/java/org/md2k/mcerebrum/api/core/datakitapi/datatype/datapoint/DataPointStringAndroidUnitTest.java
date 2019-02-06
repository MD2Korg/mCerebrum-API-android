package org.md2k.mcerebrum.api.core.datakitapi.datatype.datapoint;

import android.support.test.filters.SmallTest;

@SmallTest
public class DataPointStringAndroidUnitTest {
/*    private final long testTimestamp = TestingConstants.TEST_TIMESTAMP;

    private final String testSample = "Hello world";
    private DataPointString mDataPointString;

    private final String testEmptyString = "";
    private DataPointString mDataPointEmptyString;

    private final String[] testSampleArray = {"Test 1", "Test 2", ""};
    private DataPointString mDataPointStringArray;

    @Before
    public void createDataPointString() {
        mDataPointString = new DataPointString(testTimestamp, testSample);
        mDataPointStringArray = new DataPointString(testTimestamp, testSampleArray);
        mDataPointEmptyString = new DataPointString(testTimestamp, testEmptyString);
    }

    @Test
    public void fieldAccuracyTest() {
        assertEquals(testTimestamp, mDataPointString.getTimestamp());
        assertEquals(testSample, mDataPointString.getSample()[0]);

        assertEquals(testTimestamp, mDataPointEmptyString.getTimestamp());
        assertThat(mDataPointEmptyString.getSample()[0], isEmptyString());

        assertEquals(testTimestamp, mDataPointStringArray.getTimestamp());
        assertArrayEquals(testSampleArray, mDataPointStringArray.getSample());
    }

    @Test
    public void dataPointStringCloneTest() {
        DataPointString dataPointClone = mDataPointString.clone();
        assertThat(dataPointClone, is(equalTo(mDataPointString)));
        assertNotSame(mDataPointString, dataPointClone);
    }

    @Test
    public void dataPointStringParcelableWriteReadTest() {
        // Write data to parcel.
        Parcel parcel = Parcel.obtain();
        mDataPointString.writeToParcel(parcel, mDataPointString.describeContents());

        // After writing, reset the parcel for reading
        parcel.setDataPosition(0);

        // Read the data.
        DataPointString createdFromParcel = DataPointString.CREATOR.createFromParcel(parcel);
        DataPointString[] createdFromParcelArray = DataPointString.CREATOR.newArray(1);

        // Verify results.
        assertNotEquals(0, createdFromParcelArray.length);
        assertThat(createdFromParcel, is(equalTo(mDataPointString)));
    }

    @Test
    public void dataPointStringEmptyParcelableWriteReadTest() {
        // Write data to parcel.
        Parcel parcel = Parcel.obtain();
        mDataPointEmptyString.writeToParcel(parcel, mDataPointEmptyString.describeContents());

        // After writing, reset the parcel for reading
        parcel.setDataPosition(0);

        // Read the data.
        DataPointString createdFromParcel = DataPointString.CREATOR.createFromParcel(parcel);
        DataPointString[] createdFromParcelArray = DataPointString.CREATOR.newArray(1);

        // Verify results.
        assertNotEquals(0, createdFromParcelArray.length);
        assertThat(createdFromParcel, is(equalTo(mDataPointEmptyString)));
    }

    @Test
    public void dataPointStringArrayParcelableWriteReadTest() {
        // Write data to parcel.
        Parcel parcel = Parcel.obtain();
        mDataPointStringArray.writeToParcel(parcel, mDataPointStringArray.describeContents());

        // After writing, reset the parcel for reading
        parcel.setDataPosition(0);

        // Read the data.
        DataPointString createdFromParcel = DataPointString.CREATOR.createFromParcel(parcel);
        DataPointString[] createdFromParcelArray = DataPointString.CREATOR.newArray(1);

        // Verify results.
        assertNotEquals(0, createdFromParcelArray.length);
        assertThat(createdFromParcel, is(equalTo(mDataPointStringArray)));
    }*/
}