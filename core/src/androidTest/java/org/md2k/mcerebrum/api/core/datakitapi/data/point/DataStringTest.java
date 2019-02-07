package org.md2k.mcerebrum.api.core.datakitapi.data.point;

import android.os.Parcel;
import android.support.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.md2k.mcerebrum.api.core.datakitapi.TestingConstants;
import org.md2k.mcerebrum.api.core.datakitapi.data.MCData;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.text.IsEmptyString.isEmptyString;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThat;

@SmallTest
public class DataStringTest {
    private final long testTimestamp = TestingConstants.TEST_TIMESTAMP;

    private final String testSample = "Hello world";
    private MCData mDataPointString;

    private final String testEmptyString = "";
    private MCData mDataPointEmptyString;

    private final String[] testSampleArray = {"Test 1", "Test 2", ""};
    private MCData mDataPointStringArray;

    @Before
    public void createDataPointString() {
        mDataPointString = MCData.createPointStringArray(testTimestamp, testSample);
        mDataPointStringArray = MCData.createPointStringArray(testTimestamp, testSampleArray);
        mDataPointEmptyString = MCData.createPointStringArray(testTimestamp, testEmptyString);
    }

    @Test
    public void fieldAccuracyTest() {
        String[] r1 = mDataPointString.getSample();
        String[] r2 = mDataPointEmptyString.getSample();
        String[] r3 = mDataPointStringArray.getSample();
        assertEquals(testTimestamp, mDataPointString.getTimestamp());
        assertEquals(testSample, r1[0]);

        assertEquals(testTimestamp, mDataPointEmptyString.getTimestamp());
        assertThat(r2[0], isEmptyString());

        assertEquals(testTimestamp, mDataPointStringArray.getTimestamp());
        assertArrayEquals(testSampleArray, r3);
    }

    @Test
    public void dataPointStringCloneTest() {
        MCData dataPointClone = mDataPointString.clone();
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
        MCData createdFromParcel = MCData.CREATOR.createFromParcel(parcel);
        MCData[] createdFromParcelArray = MCData.CREATOR.newArray(1);

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
        MCData createdFromParcel = MCData.CREATOR.createFromParcel(parcel);
        MCData[] createdFromParcelArray = MCData.CREATOR.newArray(1);

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
        MCData createdFromParcel = MCData.CREATOR.createFromParcel(parcel);
        MCData[] createdFromParcelArray = MCData.CREATOR.newArray(1);

        // Verify results.
        assertNotEquals(0, createdFromParcelArray.length);
        assertThat(createdFromParcel, is(equalTo(mDataPointStringArray)));
    }
}