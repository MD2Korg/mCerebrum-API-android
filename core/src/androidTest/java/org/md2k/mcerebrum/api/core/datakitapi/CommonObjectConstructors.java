package org.md2k.mcerebrum.api.core.datakitapi;

public class CommonObjectConstructors {

/*
    public static PlatformMetaData createPlatformMetaData() {
        return PlatformMetaData.builder().setTitle(TestingConstants.TEST_TITLE)
                .setSummary(TestingConstants.TEST_SUMMARY)
                .setDescription(TestingConstants.TEST_DESCRIPTION)
                .setOperationSystem(TestingConstants.TEST_OPERATING_SYSTEM)
                .setManufacturer(TestingConstants.TEST_MANUFACTURER)
                .setModel(TestingConstants.TEST_MODEL)
                .setVersionFirmware(TestingConstants.TEST_VERSION_FIRMWARE)
                .setVersionHardware(TestingConstants.TEST_VERSION_HARDWARE)
                .setDeviceId(TestingConstants.TEST_DEVICE_ID)
                .setMetaData(TestingConstants.TEST_KEY, TestingConstants.TEST_VALUE)
                .setMetaData(TestingConstants.TEST_HASHMAP_METADATA).build();
    }

    public static PlatformAppMetaData createPlatformAppMetaData() {
        PlatformAppMetaData.Builder testPlatformAppMetaDataBuilder = PlatformAppMetaData.builder();
        return testPlatformAppMetaDataBuilder.setTitle(TestingConstants.TEST_TITLE)
                .setSummary(TestingConstants.TEST_SUMMARY)
                .setDescription(TestingConstants.TEST_DESCRIPTION)
                .setOperationSystem(TestingConstants.TEST_OPERATING_SYSTEM)
                .setManufacturer(TestingConstants.TEST_MANUFACTURER)
                .setModel(TestingConstants.TEST_MODEL)
                .setVersionFirmware(TestingConstants.TEST_VERSION_FIRMWARE)
                .setVersionHardware(TestingConstants.TEST_VERSION_HARDWARE)
                .setDeviceId(TestingConstants.TEST_DEVICE_ID)
                .setValue(TestingConstants.TEST_KEY, TestingConstants.TEST_VALUE)
                .build();
    }

    public static ApplicationMetaData createApplicationMetaData() {
        ApplicationMetaData.Builder testAppMetaDataBuilder = ApplicationMetaData.builder();
        return testAppMetaDataBuilder.setTitle(TestingConstants.TEST_TITLE)
                .setSummary(TestingConstants.TEST_SUMMARY)
                .setDescription(TestingConstants.TEST_DESCRIPTION)
                .setVersionName(TestingConstants.TEST_VERSION_NAME)
                .setVersionNumber(TestingConstants.TEST_VERSION_NUMBER)
                .setMetaData(TestingConstants.TEST_KEY, TestingConstants.TEST_VALUE)
                .build();
    }

    public static DataDescriptor createDataDescriptor() {
        DataDescriptor.Builder testDataDescriptorBuilder = DataDescriptor.builder();
        return testDataDescriptorBuilder.setName(TestingConstants.TEST_TITLE)
                .setSummary(TestingConstants.TEST_SUMMARY)
                .setDescription(TestingConstants.TEST_DESCRIPTION)
                .setMinValue(TestingConstants.TEST_MIN_VALUE)
                .setMaxValue(TestingConstants.TEST_MAX_VALUE)
                .setPossibleValues(TestingConstants.TEST_POSSIBLE_VALUES_AS_STRING)
                .setPossibleValues(TestingConstants.TEST_POSSIBLE_VALUES_AS_INT)
                .setUnit(TestingConstants.TEST_UNIT)
                .setValue(TestingConstants.TEST_KEY, TestingConstants.TEST_VALUE)
                .build();
    }

    public static DataSourceMetaData createDataSourceMetaData() {
        return DataSourceMetaData.builder().setTitle(TestingConstants.TEST_TITLE)
                .setSummary(TestingConstants.TEST_SUMMARY)
                .setDescription(TestingConstants.TEST_DESCRIPTION)
                .setDataRate(TestingConstants.TEST_SAMPLE_NO, TestingConstants.TIME_UNITS[0])
                .build();
    }

    public static DataSourceCreator createDataSourceCreator() {
        DataSourceCreator.Builder testDataSourceCreatorBuilder =
                DataSourceCreator.builder(TestingConstants.DATA_SOURCE_TYPE_ARRAY[0], TestingConstants.DATA_TYPE_ARRAY[0]);
        return testDataSourceCreatorBuilder.setDataSourceId(TestingConstants.DATASOURCE_ID_ARRAY[0])
                .setPlatformType(TestingConstants.PLATFORM_TYPE_ARRAY[0])
                .setPlatformId(TestingConstants.PLATFORM_ID_ARRAY[0])
                .setPlatformAppType(TestingConstants.PLATFORM_APP_TYPE_ARRAY[0])
                .setPlatformAppId(TestingConstants.PLATFORM_ID_ARRAY[0])
                .setApplicationType(TestingConstants.APPLICATION_TYPE_ARRAY[0])
                .setDataSourceMetadata(createDataSourceMetaData())
                .setPlatformMetadata(createPlatformMetaData())
                .setPlatformAppMetadata(createPlatformAppMetaData())
                .setApplicationMetaData(createApplicationMetaData())
                .setDataRate(TestingConstants.TEST_SAMPLE_NO, TestingConstants.TIME_UNITS[0])
                .setDataDescriptor(0, createDataDescriptor())
                .build();
    }

    public static DataSourceCreator createDataSourceCreatorWithPlatformAsPhone() {
        return DataSourceCreator.builder(TestingConstants.DATA_SOURCE_TYPE_ARRAY[0], TestingConstants.DATA_TYPE_ARRAY[0])
                .setDataSourceId(TestingConstants.DATASOURCE_ID_ARRAY[0])
                .setPlatformAppType(TestingConstants.PLATFORM_APP_TYPE_ARRAY[0])
                .setPlatformAppId(TestingConstants.PLATFORM_APP_ID_ARRAY[0])
                .setApplicationType(TestingConstants.APPLICATION_TYPE_ARRAY[0])
                //.setApplicationId(TestingConstants.APPLICATION_ID_ARRAY[0])
                .setDataSourceMetadata(createDataSourceMetaData())
                .setPlatformAppMetadata(createPlatformAppMetaData())
                .setApplicationMetaData(createApplicationMetaData())
                .setPlatformAsPhone().build();
    }

    public static DataSourceReadWrite createDataSourceReadWrite() {
        ArrayList<DataDescriptor> testDataDescriptors = new ArrayList<>();
        testDataDescriptors.add(createDataDescriptor());

        DataSourceReadWrite testDataSourceReadWrite = new DataSourceReadWrite();
        testDataSourceReadWrite.setDataSourceType(TestingConstants.DATA_SOURCE_TYPE_ARRAY[0]);
        testDataSourceReadWrite.setDataSourceId(TestingConstants.DATASOURCE_ID_ARRAY[0]);
        testDataSourceReadWrite.setPlatformType(TestingConstants.PLATFORM_TYPE_ARRAY[0]);
        testDataSourceReadWrite.setPlatformId(TestingConstants.PLATFORM_ID_ARRAY[0]);
        testDataSourceReadWrite.setPlatformAppType(TestingConstants.PLATFORM_APP_TYPE_ARRAY[0]);
        testDataSourceReadWrite.setPlatformAppId(TestingConstants.PLATFORM_ID_ARRAY[0]);
        testDataSourceReadWrite.setApplicationType(TestingConstants.APPLICATION_TYPE_ARRAY[0]);
        testDataSourceReadWrite.setPlatformMetadata(createPlatformMetaData());
        testDataSourceReadWrite.setPlatformAppMetadata(createPlatformAppMetaData());
        testDataSourceReadWrite.setApplicationMetadata(createApplicationMetaData());
        testDataSourceReadWrite.setDataDescriptors(testDataDescriptors);
        testDataSourceReadWrite.setDataSourceMetadata(createDataSourceMetaData());
        return testDataSourceReadWrite;
    }

    public static DataSourceRequest createDataSourceRequest() {
        DataSourceRequest.Builder testDataSourceRequestBuilder = DataSourceRequest.builder();
        return testDataSourceRequestBuilder.setDataSourceType(TestingConstants.DATA_SOURCE_TYPE_ARRAY[0])
                .setDataSourceId(TestingConstants.DATASOURCE_ID_ARRAY[0])
                .setPlatformType(TestingConstants.PLATFORM_TYPE_ARRAY[0])
                .setPlatformId(TestingConstants.PLATFORM_ID_ARRAY[0])
                .setPlatformAppType(TestingConstants.PLATFORM_APP_TYPE_ARRAY[0])
                .setPlatformAppId(TestingConstants.PLATFORM_APP_ID_ARRAY[0])
                .setApplicationType(TestingConstants.APPLICATION_TYPE_ARRAY[0])
                .build();
    }
*/
}
