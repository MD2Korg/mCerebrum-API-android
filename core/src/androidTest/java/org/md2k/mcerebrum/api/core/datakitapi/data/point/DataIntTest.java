package org.md2k.mcerebrum.api.core.datakitapi.data.point;

import android.os.Parcel;
import android.support.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.md2k.mcerebrum.api.core.datakitapi.TestingConstants;
import org.md2k.mcerebrum.api.core.datakitapi.data.Data;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThat;

@SmallTest
public class DataIntTest {
    private final long testTimestamp = TestingConstants.TEST_TIMESTAMP;

    private final int testSample = 1;
    private Data mDataPointInt;

    private final int[] testSampleArray = {-3874901, -1, 0, 1, 784309147};
    private Data mDataPointIntArray;

    // Create the object.
    @Before
    public void createDataPointInt() {
        mDataPointInt = Data.createPoint(testTimestamp, testSample);
        mDataPointIntArray = Data.createPoint(testTimestamp, testSampleArray);
    }

    @Test
    public void fieldAccuracyTest() {
        assertEquals(testTimestamp, mDataPointInt.getTimestamp());
        int[] res = mDataPointInt.getSample();
        int[] res1 = mDataPointIntArray.getSample();
        assertEquals(testSample, res[0]);
        assertEquals(testTimestamp, mDataPointIntArray.getTimestamp());
        assertArrayEquals(testSampleArray, res1);
    }

    @Test
    public void dataPointIntCloneTest() {
        Data dataPointClone = mDataPointInt.clone();
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
        Data createdFromParcel = Data.CREATOR.createFromParcel(parcel);
        Data[] createdFromParcelArray = Data.CREATOR.newArray(1);

        // Verify results.
        assertNotEquals(0, createdFromParcelArray.length);
        assertEquals(createdFromParcel, mDataPointInt);
    }

    @Test
    public void dataPointIntArrayParcelableWriteReadTest() {
        // Write data to parcel.
        Parcel parcel = Parcel.obtain();
        mDataPointIntArray.writeToParcel(parcel, mDataPointIntArray.describeContents());

        // After writing, reset the parcel for reading
        parcel.setDataPosition(0);

        // Read the data.
        Data createdFromParcel = Data.CREATOR.createFromParcel(parcel);
        Data[] createdFromParcelArray = Data.CREATOR.newArray(1);

        // Verify results.
        assertNotEquals(0, createdFromParcelArray.length);
        assertEquals(createdFromParcel, mDataPointIntArray);
    }

    @Test
    public void dataPointIntHashcodeTest() {
        Data dataClone = mDataPointInt.clone();
        assertEquals(mDataPointInt.hashCode(), dataClone.hashCode());

        Data dpbWithDifferentTimestamp = Data.createPoint(testTimestamp + 10, testSample);
        assertNotEquals(dpbWithDifferentTimestamp.hashCode(), dataClone.hashCode());

        Data dpbWithDifferentSample = Data.createPoint(testTimestamp, 42);
        assertNotEquals(dpbWithDifferentSample.hashCode(), dataClone.hashCode());
    }
}