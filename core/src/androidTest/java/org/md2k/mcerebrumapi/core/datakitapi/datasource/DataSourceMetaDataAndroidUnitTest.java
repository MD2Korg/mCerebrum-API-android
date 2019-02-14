package org.md2k.mcerebrumapi.core.datakitapi.datasource;


import androidx.test.filters.SmallTest;

@SmallTest
public class DataSourceMetaDataAndroidUnitTest {
/*    private final String testTitle = TestingConstants.TEST_TITLE;
    private final String testSummary = TestingConstants.TEST_SUMMARY;
    private final String testDescription = TestingConstants.TEST_DESCRIPTION;
    private final String testKey = TestingConstants.TEST_KEY;
    private final String testValue = TestingConstants.TEST_VALUE;
    private DataSourceMetaData testDataSourceMetaData;

    @Test
    public void dataSourceMetaDataBuilderTest() {
        testDataSourceMetaData = new DataSourceMetaData.builder().setMetaData(testKey, testValue).build();
        assertEquals(testValue, testDataSourceMetaData.getMetaData(testKey));

        testDataSourceMetaData = new DataSourceMetaData.builder().setName(testTitle)
                .setSummary(testSummary).setDescription(testDescription).build();
        assertEquals(testTitle, testDataSourceMetaData.getName());
        assertEquals(testSummary, testDataSourceMetaData.getDescription());
        assertEquals(testDescription, testDataSourceMetaData.getDescription());
        assertNull(testDataSourceMetaData.getMetaData(testKey));
    }

    @Test
    public void dataSourceMetaDataParcelableWriteReadComparableTest() {
        testDataSourceMetaData = CommonObjectConstructors.createDataSourceMetaData();

        // Write to parcel
        Parcel parcel = Parcel.obtain();
        testDataSourceMetaData.writeToParcel(parcel, testDataSourceMetaData.describeContents());

        // After writing, reset the parcel for reading
        parcel.setDataPosition(0);

        // Read the data.
        DataSourceMetaData createdFromParcel = DataSourceMetaData.CREATOR.createFromParcel(parcel);
        DataSourceMetaData[] createdFromParcelArray = DataSourceMetaData.CREATOR.newArray(1);

        // Verify results.
        assertNotEquals(0, createdFromParcelArray.length);
        assertThat(createdFromParcel, is(equalTo(testDataSourceMetaData)));
    }

    @Test
    public void dataSourceMetaDataHashCodeTest() {
        testDataSourceMetaData = CommonObjectConstructors.createDataSourceMetaData();
        DataSourceMetaData testDataSourceMetaData2 = CommonObjectConstructors.createDataSourceMetaData();
        assertEquals(testDataSourceMetaData.hashCode(), testDataSourceMetaData2.hashCode());
    }*/
}
