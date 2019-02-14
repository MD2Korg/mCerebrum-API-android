package org.md2k.mcerebrumapi.core.datakitapi;

import androidx.test.filters.SmallTest;

@SmallTest
public class DataSourceRequestAndroidUnitTest {
/*    private DataSourceRequest testDataSourceRequest;

    @Before
    public void createDataSourceRequest() {
        testDataSourceRequest = CommonObjectConstructors.createDataSourceRequest();
    }

    @Test
    public void dataSourceRequestBuilderTest() {
        assertEquals(TestingConstants.DATA_SOURCE_TYPE_ARRAY[0], testDataSourceRequest.getDataSourceType());
        assertEquals(TestingConstants.DATASOURCE_ID_ARRAY[0], testDataSourceRequest.getDataSourceId());
        assertEquals(TestingConstants.PLATFORM_TYPE_ARRAY[0], testDataSourceRequest.getPlatformType());
        assertEquals(TestingConstants.PLATFORM_ID_ARRAY[0], testDataSourceRequest.getPlatformId());
        assertEquals(TestingConstants.PLATFORM_APP_TYPE_ARRAY[0], testDataSourceRequest.getPlatformAppType());
        assertEquals(TestingConstants.PLATFORM_APP_ID_ARRAY[0], testDataSourceRequest.getPlatformAppId());
        assertEquals(TestingConstants.APPLICATION_TYPE_ARRAY[0], testDataSourceRequest.getApplicationType());
    }

    @Test
    public void dataSourceRequestParcelableWriteReadTest() {
        // Write to parcel.
        Parcel parcel = Parcel.obtain();
        testDataSourceRequest.writeToParcel(parcel, testDataSourceRequest.describeContents());

        // After writing, reset the parcel for reading.
        parcel.setDataPosition(0);

        // Read the data.
        DataSourceRequest createdFromParcel = DataSourceRequest.CREATOR.createFromParcel(parcel);
        DataSourceRequest[] createdFromParcelArray = DataSourceRequest.CREATOR.newArray(1);

        // Verify results.
        assertNotEquals(0, createdFromParcelArray.length);
        assertThat(createdFromParcel, is(equalTo(testDataSourceRequest)));
    }

    @Test
    public void dataSourceRequestHashCodeTest() {
        DataSourceRequest testDataSourceRequest2 = CommonObjectConstructors.createDataSourceRequest();
        assertEquals(testDataSourceRequest.hashCode(), testDataSourceRequest2.hashCode());
    }*/
}
