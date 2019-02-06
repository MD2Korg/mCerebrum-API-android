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
public class DataDoubleTest {
    private static final double DELTA = TestingConstants.DELTA;
    private final long testTimestamp = TestingConstants.TEST_TIMESTAMP;

    private final double testSample = 6.2831853071;
    private Data mDataPointDouble;

    private final double[] testSampleArray = {3.14159265359, 1.61803398874989484, 2.71828, 6.2831853071};
    private Data mDataPointDoubleArray;

    @Before
    public void createDataPointDouble() {
        mDataPointDouble = Data.createPoint(testTimestamp, testSample);
        mDataPointDoubleArray = Data.createPoint(testTimestamp, testSampleArray);
    }

    @Test
    public void fieldAccuracyTest() {
        assertEquals(testTimestamp, mDataPointDouble.getTimestamp());
        double[] r1, r2;
        r1 = mDataPointDouble.getSample();
        r2 = mDataPointDoubleArray.getSample();
        assertEquals(testSample, r1[0], DELTA);
        assertEquals(testTimestamp, mDataPointDoubleArray.getTimestamp());
        assertArrayEquals(testSampleArray, r2, DELTA);
    }

    @Test
    public void dataPointDoubleCloneTest() {
        Data dataPointClone = mDataPointDouble.clone();
        assertThat(dataPointClone, is(equalTo(mDataPointDouble)));
        assertNotSame(mDataPointDouble, dataPointClone);
    }

    @Test
    public void dataPointDoubleParcelableWriteReadTest() {
        // Write data to parcel.
        Parcel parcel = Parcel.obtain();
        mDataPointDouble.writeToParcel(parcel, mDataPointDouble.describeContents());

        // After writing, reset the parcel for reading
        parcel.setDataPosition(0);

        // Read the data.
        Data createdFromParcel = Data.CREATOR.createFromParcel(parcel);
        Data[] createdFromParcelArray = Data.CREATOR.newArray(1);

        // Verify results.
        assertNotEquals(0, createdFromParcelArray.length);
        assertThat(createdFromParcel, is(equalTo(mDataPointDouble)));
    }

    @Test
    public void dataPointDoubleArrayParcelableWriteReadTest() {
        // Write data to parcel.
        Parcel parcel = Parcel.obtain();
        mDataPointDoubleArray.writeToParcel(parcel, mDataPointDoubleArray.describeContents());

        // After writing, reset the parcel for reading
        parcel.setDataPosition(0);

        // Read the data.
        Data createdFromParcel = Data.CREATOR.createFromParcel(parcel);
        Data[] createdFromParcelArray = Data.CREATOR.newArray(1);

        // Verify results.
        assertNotEquals(0, createdFromParcelArray.length);
        assertThat(createdFromParcel, is(equalTo(mDataPointDoubleArray)));
    }

    @Test
    public void dataPointDoubleHashcodeTest() {
        Data dataClone = mDataPointDouble.clone();
        assertEquals(mDataPointDouble.hashCode(), dataClone.hashCode());

        Data dpbWithDifferentTimestamp = Data.createPoint(testTimestamp + 10, testSample);
        assertNotEquals(dpbWithDifferentTimestamp.hashCode(), dataClone.hashCode());

        Data dpbWithDifferentSample = Data.createPoint(testTimestamp, Math.sqrt(2));
        assertNotEquals(dpbWithDifferentSample.hashCode(), dataClone.hashCode());
    }
}