package org.md2k.mcerebrum.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = findViewById(R.id.button);

/*
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MCerebrumAPI.connect(new ConnectionCallback() {
                    @Override
                    public void onSuccess() {
                        Log.d("abc", "Connected");
                        int[] values=new int[]{5,4,2};
                        Data point = Data.createPointByteArray(System.currentTimeMillis(), values);
                        MCerebrumAPI.insertData(rid, point);

                    }

                    @Override
                    public void onError(int status) {
                        Log.d("abc", "connection on error: " + status + " " + MCStatus.getMessage(status));
                    }
                });
            }
        });
*/
    }
/*
    public void connect(){
        MCerebrumAPI.connect(new ConnectionCallback() {
            @Override
            public void onSuccess() {
                DataSourceRegister req = DataSource.RegisterBuilder()
                        .setDataType(DataType.POINT)
                        .setSampleType(SampleType.INT_ARRAY)
                        .addDataDescriptor(DataDescriptor.builder().setName("ACL_X").build())
                        .addDataDescriptor(DataDescriptor.builder().setName("ACL_Y").build())
                        .addDataDescriptor(DataDescriptor.builder().setName("ACL_Z").build())
                        .setDataSourceType("ACCELEROMETER")
                        .setPlatformType("PHONE")
                        .setDataSourceMetaData(DataSourceMetaData.builder().setUnit("METER_PER_SECOND_SQUARED").build())
                        .build();
               Registration r = MCerebrumAPI.registerDataSource(req);
            }

            @Override
            public void onError(int status) {
                String errorMessage = MCStatus.getMessage(status);
                Log.e("abc","error: "+errorMessage);
            }
        });
    }
*/
/*
    public void insert(){
        MCerebrumAPI.authenticate(new AuthenticationCallback() {
            @Override
            public void onSuccess() {
                DataSourceCreator d = DataSourceCreator.builder(DataSourceType.ACCELEROMETER, DataType.POINT_BOOLEAN_ARRAY).build();

*/
/*
                Registration r = MCerebrumAPI.mcDataAPI.register(d);
                Data data = Data.createPointByteArray(DateTime.getCurrentTime(), new int[]{2});
                MCerebrumAPI.mcDataAPI.insertData(r,data);
*//*

            }

            @Override
            public void onError(int status) {

            }
        });
*/
/*
        MCerebrumAPI.register(d, new RegisterCallback() {
            @Override
            public void onSuccess(Registration registration) {

            }

            @Override
            public void onError(Status status) {

            }
        });
        Registration r=null;
*/


    /*
            Log.d("abc","createRegister...callback start");
            MCerebrumAPI.createRegister(DataSourceCreator.builder("abc",DataType.BOOLEAN).build()).resultCallback(new ConnectionCallback() {
                @Override
                public void onConnected() {
                    Log.d("abc","createRegister callback received");
                }

                @Override
                public void onError(MCerebrumException e) {

                }

                @Override
                public void onDisconnected() {

                }
            });

            Log.d("abc","createRegister...i am at the end");

            // prepare data source
    /*
            Data d;
            DataSourceCreator c = DataSourceCreator.builder("ACCELEROMETER", DataType.DATAPOINT_DOUBLE)
                    .setPlatformAsPhone()
                    .build();
            // createRegister dataSource
            Registration r = MCerebrumAPI.createRegister(c);
            // prepare a data point
            long curTime = System.currentTimeMillis();
            double[] d = new double[]{0.0, 9.8, 0.0};
            DataPointDouble data = new DataPointDouble(curTime, d);
            // insert the data point
            MCerebrumAPI.insert(r, data);

        }
    */
    public void query() {
/*
        // prepare datasource to check availability in mCerebrum (Here: phone accelerometer)
        DataSourceRequest q = DataSourceRequest.builder()
                .setDataSourceType(DATASOURCE.TYPE.ACCELEROMETER)
                .setPlatformType(PLATFORM.TYPE.PHONE)
                .build();
        // search datasource in mCerebrum
        DataSourceSet dataSourceSet = MCerebrumAPI.createFind(q);
        // get phone accelerometer data for last 5 seconds
        long curTime = System.currentTimeMillis();
        DataSet dataSet = MCerebrumAPI.query(dataSourceSet.getDataSources()[0], curTime - 5000, curTime);
        */
/* to get last 5 phone accelerometer data, use following:

            DataSet dataSet = mCerebrumAPI.query(dataSourceSet.getDataSources()[0], 5);

        *//*

        // measure the size of the received data
        int sampleSize = dataSet.getData().length;
        // iterate data
        for (int i = 0; i < sampleSize; i++) {
            DataPointDouble dataPointDouble = (DataPointDouble) dataSet.getData()[i];
            long timeStamp = dataPointDouble.getTimestamp();
            double[] samples = dataPointDouble.getSample();
            Log.d("mcerebrum", "Time=" + timeStamp + " x=" + samples[0] + " y=" + samples[1] + " z=" + samples[2]);
        }
*/
    }

}
