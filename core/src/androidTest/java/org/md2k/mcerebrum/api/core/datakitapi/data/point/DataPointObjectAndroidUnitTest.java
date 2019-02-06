package org.md2k.mcerebrum.api.core.datakitapi.data.point;

import android.os.Parcel;
import android.support.test.filters.SmallTest;

import org.junit.Test;
import org.md2k.mcerebrum.api.core.datakitapi.TestingConstants;
import org.md2k.mcerebrum.api.core.datakitapi.data.Data;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

@SmallTest
public class DataPointObjectAndroidUnitTest {
    // Objects created with a single data point
    private Data testDPOByte = DataPointObjectMocker.createDPOByte();
    private Data testDPOShort = DataPointObjectMocker.createDPOShort();
    private Data testDPOInt = DataPointObjectMocker.createDPOInt();
    private Data testDPOLong = DataPointObjectMocker.createDPOLong();
    private Data testDPOChar = DataPointObjectMocker.createDPOChar();
    private Data testDPOFloat = DataPointObjectMocker.createDPOFloat();
    private Data testDPODouble = DataPointObjectMocker.createDPODouble();
    private Data testDPOBoolean = DataPointObjectMocker.createDPOBoolean();

    // Objects created with an array of data points.
    private Data testDPOByteArray = DataPointObjectMocker.createDPOByteArray();
    private Data testDPOShortArray = DataPointObjectMocker.createDPOShortArray();
    private Data testDPOIntArray = DataPointObjectMocker.createDPOIntArray();
    private Data testDPOLongArray = DataPointObjectMocker.createDPOLongArray();
    private Data testDPOCharArray = DataPointObjectMocker.createDPOCharArray();
    private Data testDPOFloatArray = DataPointObjectMocker.createDPOFloatArray();
    private Data testDPODoubleArray = DataPointObjectMocker.createDPODoubleArray();
    private Data testDPOBooleanArray = DataPointObjectMocker.createDPOBooleanArray();
    private Data testDPOAllTypeArray = DataPointObjectMocker.createDPOAllTypeArray();
    private Data testDPOStringArray = DataPointObjectMocker.createDPOStringArray();

    private Data[] allTestDPO = {testDPOByte, testDPOShort, testDPOInt, testDPOLong,
                                    testDPOChar, testDPOFloat, testDPODouble, testDPOBoolean};
    private Data[] allTestDPOArrays = {testDPOByteArray, testDPOShortArray, testDPOIntArray,
                                          testDPOLongArray, testDPOCharArray, testDPOFloatArray,
                                          testDPODoubleArray, testDPOBooleanArray, testDPOAllTypeArray,
                                          testDPOStringArray};
    @Test
    public void fieldAccuracyTest() {
        final long testTimestamp = TestingConstants.TEST_TIMESTAMP;

        for (Data dataPointObject : allTestDPO) {
            assertEquals(testTimestamp, dataPointObject.getTimestamp());
        }

        for (Data dataPointObject : allTestDPOArrays) {
            assertEquals(testTimestamp, dataPointObject.getTimestamp());
        }
    }

    @Test
    public void dataPointObjectCloneTest() {
        for (Data dataPointObject : allTestDPO) {
            Data dataPointObjectClone = dataPointObject.clone();
            assertThat(dataPointObjectClone, is(equalTo(dataPointObject)));
        }
    }

    @Test
    public void dataPointObjectArrayCloneTest() {
        for (Data dataPointObject : allTestDPOArrays) {
            Data dataPointObjectClone = dataPointObject.clone();
            assertThat(dataPointObjectClone, is(equalTo(dataPointObject)));
        }
    }

    @Test
    public void dataPointObjectParcelableWriteReadTest() {
        for (Data dataPointObject : allTestDPO) {
            // Write data to parcel.
            Parcel parcel = Parcel.obtain();
            dataPointObject.writeToParcel(parcel, dataPointObject.describeContents());


            // After writing, reset the parcel for reading
            parcel.setDataPosition(0);

            // Read the data.
            Data createdFromParcel = Data.CREATOR.createFromParcel(parcel);
            Data[] createdFromParcelArray = Data.CREATOR.newArray(1);

            // Verify results.
            assertNotEquals(0, createdFromParcelArray.length);
            assertThat(createdFromParcel, is(equalTo(dataPointObject)));
        }
    }

    @Test
    public void dataPointObjectArrayParcelableWriteReadTest() {
        for (Data dataPointObject : allTestDPOArrays) {
            // Write data to parcel.
            Parcel parcel = Parcel.obtain();
            dataPointObject.writeToParcel(parcel, dataPointObject.describeContents());

            // After writing, reset the parcel for reading
            parcel.setDataPosition(0);

            // Read the data.
            Data createdFromParcel = Data.CREATOR.createFromParcel(parcel);
            Data[] createdFromParcelArray = Data.CREATOR.newArray(1);

            // Verify results.
            assertNotEquals(0, createdFromParcelArray.length);
            assertThat(createdFromParcel, is(equalTo(dataPointObject)));
        }
    }


    @Test
    public void dataPointObjectHashcodeTest() {
        for (Data dataPointObject : allTestDPOArrays) {
            Data dataPointObjectClone = dataPointObject.clone();
            assertEquals(dataPointObject.hashCode(), dataPointObjectClone.hashCode());
        }
    }
}