package org.md2k.mcerebrumapi.core;

public class MCerebrumAPIAndroidUnitTest {

/*    private MCerebrumAPI testmCerebrumAPINotInit;
    private Context testContext;
    private ConnectionCallback testConnectionCallback;
    private ConnectionCallback testConnectionCallbackNull;
    private DataSourceCreator testDataSourceCreator;
    private PlatformMetaData testPlatformMetaData;
    private PlatformAppMetaData testPlatformAppMetaData;
    private ApplicationMetaData testAppMetaData;
    private DataDescriptor testDataDescriptor;
    private DataSourceMetaData testDataSourceMetaData;
    private Registration testRegistration;
    private DataSourceRequest testDataSourceRequest;
    private DataSourceRequest.builder testDataSourceRequestBuilder;
    private DataSourceSet testDataSourceSet;
    private Data testData;
    private Data[] testDataArray;

    private final String testDataSourceType = TestingConstants.DATA_SOURCE_TYPE_ARRAY[0];
    private final String testDataSourceId = TestingConstants.DATASOURCE_ID_ARRAY[0];
    private final String testPlatformType = TestingConstants.PLATFORM_TYPE_ARRAY[0];
    private final String testPlatformId = TestingConstants.PLATFORM_ID_ARRAY[0];
    private final String testPlatformAppType = TestingConstants.PLATFORM_APP_ID_ARRAY[0];
    private final String testPlatformAppId = TestingConstants.PLATFORM_APP_ID_ARRAY[0];
    private final String testApplicationType = TestingConstants.APPLICATION_TYPE_ARRAY[0];
    private final long testTimestamp = TestingConstants.TEST_TIMESTAMP;

    private void createRegistration() {
        testRegistration = MCerebrumAPI.register(testDataSourceCreator);
    }

    private void createDataSourceRequest() {
        testDataSourceRequestBuilder = DataSourceRequest.builder();
        testDataSourceRequest = testDataSourceRequestBuilder.setDataSourceType(testDataSourceType)
                .setDataSourceId(testDataSourceId).setPlatformType(testPlatformType)
                .setPlatformId(testPlatformId).setPlatformAppId(testPlatformAppId)
                .setPlatformAppType(testPlatformAppType).setApplicationType(testApplicationType).build();
    }

    @Before
    public void gettingStarted() {
        testConnectionCallback = new ConnectionCallback() {
            @Override
            public void onConnected() {}

            @Override
            public void onError(MCerebrumException e) {}

            @Override
            public void onDisconnected() {}
        };

        // Initialize mCerebrumAPI
        testContext = InstrumentationRegistry.getContext();
        MCerebrumAPI.init(testContext);

        // Create DataSourceCreator
        testPlatformMetaData = CommonObjectConstructors.createPlatformMetaData();
        testPlatformAppMetaData = CommonObjectConstructors.createPlatformAppMetaData();
        testAppMetaData = CommonObjectConstructors.createApplicationMetaData();
        testDataDescriptor = CommonObjectConstructors.createDataDescriptor();
        testDataSourceMetaData = CommonObjectConstructors.createDataSourceMetaData();
        testDataSourceCreator = CommonObjectConstructors.createDataSourceCreator();

        testData = new Data(testTimestamp);
        testDataArray = new Data[1];
        testDataArray[0] = testData;
    }

    @Ignore // Waiting for datakitapi to be finished.
    @Test
    public void connectionTest() {
        assertEquals(MCerebrumStatus.INVALID_PARAMETER, MCerebrumAPI.connect(testConnectionCallbackNull));
        assertEquals(MCerebrumStatus.MCEREBRUM_API_NOT_INITIALIZED, testmCerebrumAPINotInit.connect(testConnectionCallback));
        assertEquals(MCerebrumStatus.SUCCESS, MCerebrumAPI.connect(testConnectionCallback));
    }

    // Test after this point will always fail until connectionTest() is passing.

    @Ignore // Waiting for datakitapi to be finished.
    @Test
    public void registerTest() {
        assertNull(testmCerebrumAPINotInit.register(testDataSourceCreator));
        assertEquals(testDataSourceCreator, MCerebrumAPI.register(testDataSourceCreator).getDataSource()); // This will not work without a comparative method in DataSourceCreator
        assertEquals(MCerebrumStatus.SUCCESS, MCerebrumAPI.register(testDataSourceCreator).getStatus());
    }

    @Ignore // Waiting for datakitapi to be finished.
    @Test
    public void insertTest() {
        createRegistration();

        // Test for an array of data
        assertEquals(MCerebrumStatus.MCEREBRUM_API_NOT_INITIALIZED,
                testmCerebrumAPINotInit.insert(testRegistration, testDataArray));
        assertEquals(MCerebrumStatus.SUCCESS, MCerebrumAPI.insert(testRegistration, testDataArray));

        // Test for single data object
        assertEquals(MCerebrumStatus.MCEREBRUM_API_NOT_INITIALIZED,
                testmCerebrumAPINotInit.insert(testRegistration, testData));
        assertEquals(MCerebrumStatus.SUCCESS, MCerebrumAPI.insert(testRegistration, testData));
    }

    @Ignore // Waiting for datakitapi to be finished.
    @Test
    public void findTest() {
        createDataSourceRequest();
        assertEquals(MCerebrumStatus.MCEREBRUM_API_NOT_INITIALIZED, testmCerebrumAPINotInit.find(testDataSourceRequest));
        assertEquals(testDataSourceSet, MCerebrumAPI.find(testDataSourceRequest));
    }

    @Ignore // Waiting for datakitapi to be finished.
    // This test requires registerTest() to be passing.
    @Test
    public void unregisterTest() {
        createRegistration();
        assertEquals(MCerebrumStatus.MCEREBRUM_API_NOT_INITIALIZED,
                testmCerebrumAPINotInit.unregister(testRegistration));
    }

    @Ignore // Waiting for datakitapi to be finished.
    @Test
    public void disconnectTest() {
        assertEquals(MCerebrumStatus.INVALID_PARAMETER, MCerebrumAPI.disconnect(testConnectionCallbackNull));
        assertEquals(MCerebrumStatus.MCEREBRUM_API_NOT_INITIALIZED, testmCerebrumAPINotInit.disconnect(testConnectionCallback));
        assertEquals(MCerebrumStatus.SUCCESS, MCerebrumAPI.disconnect(testConnectionCallback));
    }*/
}
