package org.md2k.mcerebrumapi.core.datakitapi.datasource;

import androidx.test.filters.SmallTest;

@SmallTest
public class DataDescriptorAndroidUnitTest {
/*
    private static final double DELTA = TestingConstants.DELTA;
    private final String testTitle = TestingConstants.TEST_TITLE;
    private final String testSummary = TestingConstants.TEST_SUMMARY;
    private final String testDescription = TestingConstants.TEST_DESCRIPTION;
    private final double testMinValue = TestingConstants.TEST_MIN_VALUE;
    private final double testMaxValue = TestingConstants.TEST_MAX_VALUE;
    private final String[] testPossibleValuesAsString = TestingConstants.TEST_POSSIBLE_VALUES_AS_STRING;
    private final int[] testPossibleValuesAsInt = TestingConstants.TEST_POSSIBLE_VALUES_AS_INT;
    private final String testUnit = TestingConstants.TEST_UNIT;
    private final String testKey = TestingConstants.TEST_KEY;
    private final String testValue = TestingConstants.TEST_VALUE;
    private DataDescriptor testDataDescriptor;

    @Test
    public void dataDescriptorBuilderTest() {
        testDataDescriptor = new DataDescriptor.builder().setValue(testKey, testValue).build();
        assertEquals(testValue, testDataDescriptor.getValue(testKey));

        testDataDescriptor = new DataDescriptor.builder().setName(testTitle)
                .setSummary(testSummary).setDescription(testDescription).setMinValue(testMinValue)
                .setMaxValue(testMaxValue).setPossibleValues(testPossibleValuesAsString)
                .setPossibleValues(testPossibleValuesAsInt).setUnit(testUnit).build();
        assertEquals(testTitle, testDataDescriptor.getName());
        assertEquals(testSummary, testDataDescriptor.getDescription());
        assertEquals(testDescription, testDataDescriptor.getDescription());
        assertEquals(testMinValue, testDataDescriptor.getMinValue(), DELTA);
        assertEquals(testMaxValue, testDataDescriptor.getMaxValue(), DELTA);
        assertArrayEquals(testPossibleValuesAsString, testDataDescriptor.getPossibleValuesAsString());
        assertArrayEquals(testPossibleValuesAsInt, testDataDescriptor.getPossibleValuesAsInt());
        assertEquals(testUnit, testDataDescriptor.getUnit());
        assertNull(testDataDescriptor.getValue(testKey));
    }

    @Test
    public void dataDescriptorParcelableWriteReadTest() {
        testDataDescriptor = CommonObjectConstructors.createDataDescriptor();

        // Write to parcel
        Parcel parcel = Parcel.obtain();
        testDataDescriptor.writeToParcel(parcel, testDataDescriptor.describeContents());

        // After writing, reset the parcel for reading
        parcel.setDataPosition(0);

        // Read the data.
        DataDescriptor createdFromParcel = DataDescriptor.CREATOR.createFromParcel(parcel);
        DataDescriptor[] createdFromParcelArray = DataDescriptor.CREATOR.newArray(1);

        // Verify results.
        assertNotEquals(0, createdFromParcelArray.length);
        assertThat(createdFromParcel, is(equalTo(testDataDescriptor)));
    }

    @Test
    public void setTestDataDescriptorHashCodeTest() {
        testDataDescriptor = CommonObjectConstructors.createDataDescriptor();
        DataDescriptor testDataDescriptor2 = CommonObjectConstructors.createDataDescriptor();
        assertEquals(testDataDescriptor.hashCode(), testDataDescriptor2.hashCode());
    }
*/
}
