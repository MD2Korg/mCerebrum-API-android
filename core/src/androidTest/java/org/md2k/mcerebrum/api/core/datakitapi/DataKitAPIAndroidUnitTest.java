package org.md2k.mcerebrum.api.core.datakitapi;

public class DataKitAPIAndroidUnitTest {
/*    // Variables for testing null cases
    DataKitAPI testDataKitAPIwithNullmCerebrumAPI;
    MCerebrumAPI testmCerebrumAPINullInstance;
    ConnectionCallback testConnectionCallbackNull;

    // Variables for testing nonnull cases
    DataKitAPI testDataKitAPI;
    MCerebrumAPI testmCerebrumAPI;
    Context testContext;
    ConnectionCallback testConnectionCallback = new ConnectionCallback() {
        @Override
        public void onConnected() {

        }

        @Override
        public void onError(MCerebrumException e) {

        }

        @Override
        public void onDisconnected() {

        }
    };

    @Before
    public void gettingStarted() {
        // Initialize mCerebrumAPI
        testContext = InstrumentationRegistry.getContext();
        testmCerebrumAPI.init(testContext);

        // Create DataKitAPI instance.
        testDataKitAPI = new DataKitAPI(testmCerebrumAPI);
    }

    @Ignore // Waiting for datakitapi to be finished.
    @Test
    public void nullmCerebrumAPITest() {
        testDataKitAPIwithNullmCerebrumAPI = new DataKitAPI(testmCerebrumAPINullInstance);
        assertNull(testDataKitAPIwithNullmCerebrumAPI);
    }

    @Ignore // Waiting for datakitapi to be finished.
    @Test
    public void nullConnectionCallbackConnectTest() {
        assertEquals(MCerebrumStatus.INVALID_PARAMETER, testDataKitAPI.connect(testConnectionCallbackNull));
    }

    @Ignore // Waiting for datakitapi to be finished.
    @Test
    public void successfulConnectionTest() {
        assertEquals(MCerebrumStatus.SUCCESS, testDataKitAPI.connect(testConnectionCallback));
        *//*
        This test is currently failing (returns MCEREBRUM_APP_NOT_INSTALLED (2)) because an exception
        is thrown when the connectionCallback is supposed to be added to an arraylist that is not initialized.
         *//*
    }*/
}
