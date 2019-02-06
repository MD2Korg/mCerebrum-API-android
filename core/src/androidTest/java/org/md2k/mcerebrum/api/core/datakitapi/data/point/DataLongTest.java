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
public class DataLongTest {
    private static final double DELTA = TestingConstants.DELTA;
    private final long testTimestamp = TestingConstants.TEST_TIMESTAMP;

    private final long testSample = 1;
    private Data mDataPointLong;

    private final long[] testSampleArray = {-3874901, -1, 0, 1, 784309147};
    private Data mDataPointLongArray;

    // Create the object.
    @Before
    public void createDataPointLong() {
        mDataPointLong = Data.createPoint(testTimestamp, testSample);
        mDataPointLongArray = Data.createPoint(testTimestamp, testSampleArray);
    }

    @Test
    public void fieldAccuracyTest() {
        assertEquals(testTimestamp, mDataPointLong.getTimestamp());
        long[] r1, r2;
        r1 = mDataPointLong.getSample();
        r2 = mDataPointLongArray.getSample();
        assertEquals(testSample, r1[0], DELTA);
        assertEquals(testTimestamp, mDataPointLongArray.getTimestamp());
        assertArrayEquals(testSampleArray, r2);
    }

    @Test
    public void dataPointLongCloneTest() {
        Data dataPointClone = mDataPointLong.clone();
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
        Data createdFromParcel = Data.CREATOR.createFromParcel(parcel);
        Data[] createdFromParcelArray = Data.CREATOR.newArray(1);

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
        Data createdFromParcel = Data.CREATOR.createFromParcel(parcel);
        Data[] createdFromParcelArray = Data.CREATOR.newArray(1);

        // Verify results.
        assertNotEquals(0, createdFromParcelArray.length);
        assertThat(createdFromParcel, is(equalTo(mDataPointLongArray)));
    }


    @Test
    public void dataPointLongHashcodeTest() {
        Data dataClone = mDataPointLong.clone();
        assertEquals(mDataPointLong.hashCode(), dataClone.hashCode());

        Data dpbWithDifferentTimestamp = Data.createPoint(testTimestamp + 10, testSample);
        assertNotEquals(dpbWithDifferentTimestamp.hashCode(), dataClone.hashCode());

        Data dpbWithDifferentSample = Data.createPoint(testTimestamp, (long) 475894890);
        assertNotEquals(dpbWithDifferentSample.hashCode(), dataClone.hashCode());
    }
}