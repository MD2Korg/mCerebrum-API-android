package org.md2k.mcerebrum.api.core.datakitapi.data.point;

import android.os.Parcel;
import android.support.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.md2k.mcerebrum.api.core.datakitapi.TestingConstants;
import org.md2k.mcerebrum.api.core.datakitapi.data.Data;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThat;

@SmallTest
public class DataBooleanTest {
    private final long testTimestamp = TestingConstants.TEST_TIMESTAMP;

    private final boolean testSample = true;
    private Data mDataPointBoolean;

    private final boolean[] testSampleArray = {true, false, true};
    private Data mDataPointBooleanArray;

    // Create the object.
    @Before
    public void createDataPointBoolean() {
        mDataPointBoolean = Data.createPoint(testTimestamp, testSample);
        mDataPointBooleanArray = Data.createPoint(testTimestamp, testSampleArray);
    }

    @Test
    public void fieldAccuracyTest() {
        assertEquals(testTimestamp, mDataPointBoolean.getTimestamp());
        boolean[] res = mDataPointBoolean.getSample();
        boolean[] resArray = mDataPointBooleanArray.getSample();
        assertEquals(testSample, res[0]);
        assertEquals(testTimestamp, mDataPointBooleanArray.getTimestamp());
        assertArrayEquals(testSampleArray, resArray);
    }

    @Test
    public void dataPointBooleanCloneTest() {
        Data dataPointClone = mDataPointBoolean.clone();
        assertThat(dataPointClone, is(equalTo(mDataPointBoolean)));
        assertNotSame(mDataPointBoolean, dataPointClone);
    }


    @Test
    public void dataPointBooleanParcelableWriteReadTest() {
        // Write data to parcel.
        Parcel parcel = Parcel.obtain();
        mDataPointBoolean.writeToParcel(parcel, mDataPointBoolean.describeContents());

        // After writing, reset the parcel for reading
        parcel.setDataPosition(0);

        // Read the data.
        Data createdFromParcel = Data.CREATOR.createFromParcel(parcel);
        Data[] createdFromParcelArray = Data.CREATOR.newArray(1);

        // Verify results.
        assertNotEquals(0, createdFromParcelArray.length);
        assertThat(createdFromParcel, is(equalTo(mDataPointBoolean)));
    }
    @Test
    public void dataPointBooleanArrayParcelableWriteReadTest() {
        // Write data to parcel.
        Parcel parcel = Parcel.obtain();
        mDataPointBooleanArray.writeToParcel(parcel, mDataPointBooleanArray.describeContents());

        // After writing, reset the parcel for reading
        parcel.setDataPosition(0);
        // Read the data.
        Data createdFromParcel = Data.CREATOR.createFromParcel(parcel);
        Data[] createdFromParcelArray = Data.CREATOR.newArray(1);

        // Verify results.
        assertNotEquals(0, createdFromParcelArray.length);
        assertThat(createdFromParcel, is(equalTo(mDataPointBooleanArray)));
    }
    @Test
    public void equalsNullObjectTest() {
        Data nullBoolean = null;
        Data nullBoolean1 = null;

        assertThat(nullBoolean, is(equalTo(nullBoolean1)));
        assertThat(nullBoolean, is(not(equalTo(mDataPointBoolean))));
    }

    @Test
    public void dataPointBooleanHashcodeTest() {
        Data dataClone = mDataPointBoolean.clone();
        assertEquals(mDataPointBoolean.hashCode(), dataClone.hashCode());

        Data dpbWithDifferentTimestamp = Data.createPoint(testTimestamp + 10, testSample);
        assertNotEquals(dpbWithDifferentTimestamp.hashCode(), dataClone.hashCode());

        Data dpbWithDifferentSample = Data.createPoint(testTimestamp, false);
        assertNotEquals(dpbWithDifferentSample.hashCode(), dataClone.hashCode());
    }
}
