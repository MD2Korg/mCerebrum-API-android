package org.md2k.mcerebrum.api.core.datakitapi.datatype.datapoint;

import android.os.Parcel;
import android.support.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

@SmallTest
public class DataPointBooleanAndroidUnitTest {
    private final long testTimestamp = 1268660460;

    private final boolean testSample = true;
    private DataPointBoolean mDataPointBoolean;

    private final boolean[] testSampleArray = {true, false, true};
    private DataPointBoolean mDataPointBooleanArray;

    // Create the object.
    @Before
    public void createDataPointBoolean() {
        mDataPointBoolean = new DataPointBoolean(testTimestamp, testSample);
        mDataPointBooleanArray = new DataPointBoolean(testTimestamp, testSampleArray);
    }

    @Test
    public void dataPointBooleanCloneTest() {
        DataPointBoolean dataPointClone = mDataPointBoolean.clone();
        assertEquals(mDataPointBoolean.getTimestamp(), dataPointClone.getTimestamp());
        assertArrayEquals(mDataPointBoolean.getSample(), dataPointClone.getSample());
        assertNotEquals(mDataPointBoolean, dataPointClone);
    }

    @Test
    public void dataPointBoolean_ParcelableWriteRead() {
        // Write data to parcel.
        Parcel parcel = Parcel.obtain();
        mDataPointBoolean.writeToParcel(parcel, mDataPointBoolean.describeContents());

        // After writing, reset the parcel for reading
        parcel.setDataPosition(0);

        // Read the data.
        DataPointBoolean createdFromParcel = DataPointBoolean.CREATOR.createFromParcel(parcel);
        DataPointBoolean[] createdFromParcelArray = DataPointBoolean.CREATOR.newArray(1);

        // Verify results.
        assertThat(createdFromParcelArray.length, is(not(0)));
        assertEquals(createdFromParcel.getTimestamp(), mDataPointBoolean.getTimestamp());
        assertArrayEquals(createdFromParcel.getSample(), mDataPointBoolean.getSample());
    }

    @Test
    public void dataPointBooleanArray_ParcelableWriteRead() {
        // Write data to parcel.
        Parcel parcel = Parcel.obtain();
        mDataPointBooleanArray.writeToParcel(parcel, mDataPointBooleanArray.describeContents());

        // After writing, reset the parcel for reading
        parcel.setDataPosition(0);

        // Read the data.
        DataPointBoolean createdFromParcel = DataPointBoolean.CREATOR.createFromParcel(parcel);
        DataPointBoolean[] createdFromParcelArray = DataPointBoolean.CREATOR.newArray(1);

        // Verify results.
        assertThat(createdFromParcelArray.length, is(not(0)));
        assertEquals(createdFromParcel.getTimestamp(), mDataPointBooleanArray.getTimestamp());
        assertArrayEquals(createdFromParcel.getSample(), mDataPointBooleanArray.getSample());
    }
}