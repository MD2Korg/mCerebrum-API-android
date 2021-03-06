package org.md2k.mcerebrumapi.core.data.point;

import org.md2k.mcerebrumapi.core.datakitapi.TestingConstants;
import org.md2k.mcerebrumapi.core.data.MCData;

public class DataObjectMocker {
    /*
        This class creates an object with several primitive type fields to test DataPointObject.
     */

    private static final long TEST_TIMESTAMP = TestingConstants.TEST_TIMESTAMP;
    private static final byte TEST_BYTE = 23;
    private static final short TEST_SHORT = 4304;
    private static final int TEST_INT = 235890824;
    private static final long TEST_LONG = 890589984L;
    private static final char TEST_CHAR = 'x';
    private static final float TEST_FLOAT = 850425458.0f;
    private static final double TEST_DOUBLE = 758940257.0;
    private static final boolean  TEST_BOOLEAN = true;

    private static final byte[] TEST_BYTE_ARRAY = {-128, 0, 127};
    private static final short[] TEST_SHORT_ARRAY = {-2^15, 0, (2^15)-1};
    private static final int[] TEST_INT_ARRAY = {-2^31, 0, (2^31)-1};
    private static final long[] TEST_LONG_ARRAY = {-2^63, 0 , (2^63)-1};
    private static final char[] TEST_CHAR_ARRAY = {0, 65535};
    private static final Float[] TEST_FLOAT_ARRAY = {(float) (-3.40282346638528860 * Math.exp(38)),
                                              (float)(-1.40129846432481707 * Math.exp(-45)),
                                              (float)(1.40129846432481707 * Math.exp(-45)),
                                              (float)(3.40282346638528860 * Math.exp(38))};
    private static final Double[] TEST_DOUBLE_ARRAY = {-1.7976931348623157 * Math.exp(308),
                                                -4.9 * Math.exp(-324), 4.9 * Math.exp(-324),
                                                1.7976931348623157 * Math.exp(308)};
    private static final Boolean[] TEST_BOOLEAN_ARRAY = {true, false};
    private static final Object[] TEST_ALL_TYPE_ARRAY = {TEST_BYTE, TEST_SHORT, TEST_INT, TEST_LONG,
                                                  TEST_CHAR, TEST_FLOAT, TEST_DOUBLE, TEST_BOOLEAN};
    private static final String[] TEST_STRING_ARRAY = {"I may remark that the curious transformations many formulae can undergo,",
                                                "the unsuspected and to a beginner apparently impossible identity of forms ",
                                                "exceedingly dissimilar at first sight, is I think one of the chief ",
                                                "difficulties in the early part of mathematical studies.",
                                                "~ Ada Lovelace"};

    // Constructors for single data points
    public static MCData createDPOByte() {
        return MCData.createPointObject(TEST_TIMESTAMP, TEST_BYTE);
    }

    public static MCData createDPOShort() {
        return MCData.createPointObject(TEST_TIMESTAMP, TEST_SHORT);
    }

    public static MCData createDPOInt() {
        return MCData.createPointObject(TEST_TIMESTAMP, TEST_INT);
    }

    public static MCData createDPOLong() {
        return MCData.createPointObject(TEST_TIMESTAMP, TEST_LONG);
    }

    public static MCData createDPOChar() {
        return MCData.createPointObject(TEST_TIMESTAMP, TEST_CHAR);
    }

    public static MCData createDPOFloat() {
        return MCData.createPointObject(TEST_TIMESTAMP, TEST_FLOAT);
    }

    public static MCData createDPODouble() {
        return MCData.createPointObject(TEST_TIMESTAMP, TEST_DOUBLE);
    }

    public static MCData createDPOBoolean() {
        return MCData.createPointObject(TEST_TIMESTAMP, TEST_BOOLEAN);
    }

    // Constructors for generic arrays of data
    public static MCData createDPOByteArray() {
        return MCData.createPointObject(TEST_TIMESTAMP, TEST_BYTE_ARRAY);
    }

    public static MCData createDPOShortArray() {
        return MCData.createPointObject(TEST_TIMESTAMP, TEST_SHORT_ARRAY);
    }

    public static MCData createDPOIntArray() {
        return MCData.createPointObject(TEST_TIMESTAMP, TEST_INT_ARRAY);
    }

    public static MCData createDPOLongArray() {
        return MCData.createPointObject(TEST_TIMESTAMP, TEST_LONG_ARRAY);
    }

    public static MCData createDPOCharArray() {
        return MCData.createPointObject(TEST_TIMESTAMP, TEST_CHAR_ARRAY);
    }

    public static MCData createDPOFloatArray() {
        return MCData.createPointObject(TEST_TIMESTAMP, TEST_FLOAT_ARRAY);
    }

    public static MCData createDPODoubleArray() {
        return MCData.createPointObject(TEST_TIMESTAMP, TEST_DOUBLE_ARRAY);
    }

    public static MCData createDPOBooleanArray() {
        return MCData.createPointObject(TEST_TIMESTAMP, TEST_BOOLEAN_ARRAY);
    }

    public static MCData createDPOAllTypeArray() {
        return MCData.createPointObject(TEST_TIMESTAMP, TEST_ALL_TYPE_ARRAY);
    }

    // Constructor for String array
    public static MCData createDPOStringArray() {
        return MCData.createPointStringArray(TEST_TIMESTAMP, TEST_STRING_ARRAY);
    }
}
