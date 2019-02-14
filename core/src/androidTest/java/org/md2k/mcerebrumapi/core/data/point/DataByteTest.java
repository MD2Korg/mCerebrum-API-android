package org.md2k.mcerebrumapi.core.data.point;

import android.os.Parcel;
import androidx.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.md2k.mcerebrumapi.core.datakitapi.TestingConstants;
import org.md2k.mcerebrumapi.core.data.MCData;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThat;

@SmallTest
public class DataByteTest {
    private final long testTimestamp = TestingConstants.TEST_TIMESTAMP;

    private final byte testSample = 1;
    private MCData mDataPointByte;

    private final byte[] testSampleArray = {-126, -1, 0, 1, 127};
    private MCData mDataPointByteArray;

    // Create the object.
    @Before
    public void createDataPointByte() {
        mDataPointByte = MCData.createPointByteArray(testTimestamp, testSample);
        mDataPointByteArray = MCData.createPointByteArray(testTimestamp, testSampleArray);
    }

    @Test
    public void fieldAccuracyTest() {
        byte[] r1 = mDataPointByte.getSample();
        byte[] r2 = mDataPointByteArray.getSample();

        assertEquals(testTimestamp, mDataPointByte.getTimestamp());
        assertEquals(testSample, r1[0]);
        assertEquals(testTimestamp, mDataPointByteArray.getTimestamp());
        assertArrayEquals(testSampleArray, r2);
    }

    @Test
    public void dataPointByteCloneTest() {
        MCData dataPointClone = mDataPointByte.clone();
        assertThat(dataPointClone, is(equalTo(mDataPointByte)));
        assertNotSame(mDataPointByte, dataPointClone);
    }

    @Test
    public void dataPointByteParcelableWriteReadTest() {
        // Write data to parcel.
        Parcel parcel = Parcel.obtain();
        mDataPointByte.writeToParcel(parcel, mDataPointByte.describeContents());

        // After writing, reset the parcel for reading
        parcel.setDataPosition(0);

        // Read the data.
        MCData createdFromParcel = MCData.CREATOR.createFromParcel(parcel);
        MCData[] createdFromParcelArray = MCData.CREATOR.newArray(1);

        // Verify results.
        assertNotEquals(0, createdFromParcelArray.length);
        assertThat(createdFromParcel, is(equalTo(mDataPointByte)));
    }

    @Test
    public void dataPointByteArrayParcelableWriteReadTest() {
        // Write data to parcel.
        Parcel parcel = Parcel.obtain();
        mDataPointByteArray.writeToParcel(parcel, mDataPointByteArray.describeContents());

        // After writing, reset the parcel for reading
        parcel.setDataPosition(0);

        // Read the data.
        MCData createdFromParcel = MCData.CREATOR.createFromParcel(parcel);
        MCData[] createdFromParcelArray = MCData.CREATOR.newArray(1);

        // Verify results.
        assertNotEquals(0, createdFromParcelArray.length);
        assertThat(createdFromParcel, is(equalTo(mDataPointByteArray)));
    }

    @Test
    public void dataPointByteHashcodeTest() {
        MCData dataClone = mDataPointByte.clone();
        assertEquals(mDataPointByte.hashCode(), dataClone.hashCode());

        MCData dpbWithDifferentTimestamp = MCData.createPointByteArray(testTimestamp + 10, testSample);
        assertNotEquals(dpbWithDifferentTimestamp.hashCode(), dataClone.hashCode());

        MCData dpbWithDifferentSample = MCData.createPointByteArray(testTimestamp, (byte) 101);
        assertNotEquals(dpbWithDifferentSample.hashCode(), dataClone.hashCode());
    }
}
