package org.md2k.mcerebrum.api.core.datakitapi.data.point;

import android.os.Parcel;
import android.support.test.filters.SmallTest;

import org.junit.Test;
import org.md2k.mcerebrum.api.core.datakitapi.TestingConstants;
import org.md2k.mcerebrum.api.core.datakitapi.data.MCData;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

@SmallTest
public class DataObjectTest {
    // Objects created with a single data point
    private MCData testDPOByte = DataObjectMocker.createDPOByte();
    private MCData testDPOShort = DataObjectMocker.createDPOShort();
    private MCData testDPOInt = DataObjectMocker.createDPOInt();
    private MCData testDPOLong = DataObjectMocker.createDPOLong();
    private MCData testDPOChar = DataObjectMocker.createDPOChar();
    private MCData testDPOFloat = DataObjectMocker.createDPOFloat();
    private MCData testDPODouble = DataObjectMocker.createDPODouble();
    private MCData testDPOBoolean = DataObjectMocker.createDPOBoolean();

    // Objects created with an array of data points.
    private MCData testDPOByteArray = DataObjectMocker.createDPOByteArray();
    private MCData testDPOShortArray = DataObjectMocker.createDPOShortArray();
    private MCData testDPOIntArray = DataObjectMocker.createDPOIntArray();
    private MCData testDPOLongArray = DataObjectMocker.createDPOLongArray();
    private MCData testDPOCharArray = DataObjectMocker.createDPOCharArray();
    private MCData testDPOFloatArray = DataObjectMocker.createDPOFloatArray();
    private MCData testDPODoubleArray = DataObjectMocker.createDPODoubleArray();
    private MCData testDPOBooleanArray = DataObjectMocker.createDPOBooleanArray();
    private MCData testDPOAllTypeArray = DataObjectMocker.createDPOAllTypeArray();
    private MCData testDPOStringArray = DataObjectMocker.createDPOStringArray();

    private MCData[] allTestDPO = {testDPOByte, testDPOShort, testDPOInt, testDPOLong,
                                    testDPOChar, testDPOFloat, testDPODouble, testDPOBoolean};
    private MCData[] allTestDPOArrays = {testDPOByteArray, testDPOShortArray, testDPOIntArray,
                                          testDPOLongArray, testDPOCharArray, testDPOFloatArray,
                                          testDPODoubleArray, testDPOBooleanArray, testDPOAllTypeArray,
                                          testDPOStringArray};
    @Test
    public void fieldAccuracyTest() {
        final long testTimestamp = TestingConstants.TEST_TIMESTAMP;

        for (MCData dataPointObject : allTestDPO) {
            assertEquals(testTimestamp, dataPointObject.getTimestamp());
        }

        for (MCData dataPointObject : allTestDPOArrays) {
            assertEquals(testTimestamp, dataPointObject.getTimestamp());
        }
    }

    @Test
    public void dataPointObjectCloneTest() {
        for (MCData dataPointObject : allTestDPO) {
            MCData dataPointObjectClone = dataPointObject.clone();
            assertThat(dataPointObjectClone, is(equalTo(dataPointObject)));
        }
    }

    @Test
    public void dataPointObjectArrayCloneTest() {
        for (MCData dataPointObject : allTestDPOArrays) {
            MCData dataPointObjectClone = dataPointObject.clone();
            assertThat(dataPointObjectClone, is(equalTo(dataPointObject)));
        }
    }

    @Test
    public void dataPointObjectParcelableWriteReadTest() {
        for (MCData dataPointObject : allTestDPO) {
            // Write data to parcel.
            Parcel parcel = Parcel.obtain();
            dataPointObject.writeToParcel(parcel, dataPointObject.describeContents());


            // After writing, reset the parcel for reading
            parcel.setDataPosition(0);

            // Read the data.
            MCData createdFromParcel = MCData.CREATOR.createFromParcel(parcel);
            MCData[] createdFromParcelArray = MCData.CREATOR.newArray(1);

            // Verify results.
            assertNotEquals(0, createdFromParcelArray.length);
            assertThat(createdFromParcel, is(equalTo(dataPointObject)));
        }
    }

    @Test
    public void dataPointObjectArrayParcelableWriteReadTest() {
        for (MCData dataPointObject : allTestDPOArrays) {
            // Write data to parcel.
            Parcel parcel = Parcel.obtain();
            dataPointObject.writeToParcel(parcel, dataPointObject.describeContents());

            // After writing, reset the parcel for reading
            parcel.setDataPosition(0);

            // Read the data.
            MCData createdFromParcel = MCData.CREATOR.createFromParcel(parcel);
            MCData[] createdFromParcelArray = MCData.CREATOR.newArray(1);

            // Verify results.
            assertNotEquals(0, createdFromParcelArray.length);
            assertThat(createdFromParcel, is(equalTo(dataPointObject)));
        }
    }


    @Test
    public void dataPointObjectHashcodeTest() {
        for (MCData dataPointObject : allTestDPOArrays) {
            MCData dataPointObjectClone = dataPointObject.clone();
            assertEquals(dataPointObject.hashCode(), dataPointObjectClone.hashCode());
        }
    }
}