# mCerebrum-API-android
[![Build Status](https://travis-ci.org/MD2Korg/mCerebrum-API-android.svg?branch=master)](https://travis-ci.org/MD2Korg/mCerebrum-API-android)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/36f4bb30e9554b34b24220781f77ffe1)](https://app.codacy.com/app/monowar-hossain/mCerebrum-API-android?utm_source=github.com&utm_medium=referral&utm_content=MD2Korg/mCerebrum-API-android&utm_campaign=Badge_Grade_Dashboard)
[ ![Download](https://api.bintray.com/packages/md2korg/mCerebrum/core/images/download.svg) ](https://bintray.com/md2korg/mCerebrum/core/_latestVersion)

mCerebrum is a configurable smartphone software platform for mobile and wearable sensors. It provides support for reliable data collection from mobile and wearable sensors, and offers real-time processing of these data.


This Android library is the communication API for mCerebrum and is utilized by all applications and libraries that wish to communicate with mCerebrum.

You can find more information about MD2K software on our [software website](https://md2k.org/software) or the MD2K organization on our [MD2K website](https://md2k.org/).

## Usage

### Dependency
Include the library in your `build.gradle`

```groovy
 implementation "org.md2k.mcerebrum.api:core:0.0.1-RC3"
 ```


### Using MCDataKitAPI

- Step 1: initialize MCDataKitAPI
- Step 2: Connect to mCerebrum through ``connect()`` function.
- Step 3: Then, you can insert, query or subscribe any datastream.
  Functions supported by mCerebrum: `connect()`, `disconnect()`,
  `registerDataSource()`, `queryDataSource()`,
  `subscribeDataSourceAsync()`, `queryData()`, `queryCount()`,
  `subscribe()`, `unsubscribe()`

#### Initialize MCDataKitAPI
Initialize MCDataKitAPI before using it.
```java
MCDataKitAPI.init(context);
```

#### Connect
Step 1: Use connect() function to connect to `mCerebrum`
```java
 MCDataKitAPI.connect(new MCConnectionCallback() {
     @Override
     public void onSuccess() {
     }

     @Override
     public void onError(int status) {
         String errorMessage = MCStatus.getMessage(status);
         Log.e("abc","error: "+errorMessage);
     }
 });
}
```
#### Register DataSource
- Step 1: Create DataSourceRegister using
  `MCDataSource.RegisterBuilder()`
- Step 2: Register datasource to mCerebrum

Example:
```java
// register Accelerometer datastream

//Step 1: create datasource:
        MCDataSourceRegister req = MCDataSource.registerBuilder()
                .setDataType(MCDataType.POINT)
                .setSampleTypeAsDoubleArray(3)
                .setDataDescriptor(0, MCDataDescriptor.builder("Accelerometer X").build())
                .setDataDescriptor(1, MCDataDescriptor.builder("Accelerometer Y").build())
                .setDataDescriptor(2, MCDataDescriptor.builder("Accelerometer Z").build())
                .setDataSourceType("ACCELEROMETER")
                .setPlatformType("PHONE")
                .setDataSourceMetaData(MCDataSourceMetaData.builder().setUnit(MCUnit.METER_PER_SECOND_SQUARED).build())
                .build();
//Step 3: register to mCerebrum
        MCRegistration res = MCDataKitAPI.registerDataSource(req);
 ```

#### Insert Data

Supported data types: `BOOLEAN_ARRAY`, `BYTE_ARRAY`, `INT_ARRAY`, `LONG_ARRAY`, `DOUBLE_ARRAY`, `STRING_ARRAY`, `ENUM`, `OBJECT`

- Step 1: Register datasource to mCerebrum (as previous)
- Step 2: Insert data to mCerebrum using registered id returned by
  `registerDataSource()` function

```java
// insert accelerometer data
        MCData data = MCData.createPointDoubleArray(System.currentTimeMillis(), new double[]{0.0, 0.0, 9.8});
        MCDataKitAPI.insertData(res, data); // "res" is the registration id. see previous example for more information.

```
#### Subscribe data


#### Query Data

There are 2 ways to query data from mCerebrum. a) **`query by time`** b) **`query last N samples`**.

Steps:
- Connect to mCerebrum
- Create a datasource using `DataSourceRequest` and search using `find()` function
- Query data with specific datasource (returned by `find()` function)

```
    public void query() {
        // prepare datasource to check availability in mCerebrum (Here: phone accelerometer)
        DataSourceQuery q = DataSourceQuery.builder()
                .setDataSourceType(DATASOURCE.TYPE.ACCELEROMETER)
                .setPlatformType(PLATFORM.TYPE.PHONE)
                .build();
        // search datasource in mCerebrum
        DataSourceSet dataSourceSet = mCerebrumAPI.find(q);
        // get phone accelerometer data for last 5 seconds
        long curTime = System.currentTimeMillis();
        DataSet dataSet = mCerebrumAPI.query(dataSourceSet.getDataSources()[0], curTime - 5000, curTime);
        /* to get last 5 phone accelerometer data, use following:

            DataSet dataSet = mCerebrumAPI.query(dataSourceSet.getDataSources()[0], 5);

        */
        // measure the size of the received data
        int sampleSize = dataSet.getData().length;
        // iterate data
        for (int i = 0; i < sampleSize; i++) {
            DataPointDouble dataPointDouble = (DataPointDouble) dataSet.getData()[i];
            long timeStamp = dataPointDouble.getTimestamp();
            double[] samples = dataPointDouble.getSample();
            Log.d("mcerebrum", "Time=" + timeStamp + " x=" + samples[0] + " y=" + samples[1] + " z=" + samples[2]);
        }
    }
```
#### Supported DataType
|   DataType||
|---|---|
| POINT| Data with timestamp|
| ANNOTATION|Data with starttime and endtime|
#### Supported SampleType
|   SampleType|Example (Point)|Example(Annotation)
|---|---|---|
|BOOLEAN_ARRAY| 
|BYTE_ARRAY|
|INT_ARRAY|
|LONG_ARRAY|
|DOUBLE_ARRAY|
|STRING_ARRAY|
|ENUM|
|OBJECT|

#### Supported Functionality

```java
void init(Context context);

//connection
void connect(MCConnectionCallback c);
boolean isConnected();
void disconnect(ConnectionCallback c);

//datasource

MCRegistration registerDataSource(MCDataSourceRegister r);
ArrayList<MCDataSourceResult> queryDataSource(MCDataSourceQuery q);
void subscribeDataSourceAsync(MCDataSourceQuery q, MCSubscribeDataSourceCallback s);
void unsubscribeDataSourceAsync(MCSubscribeDataSourceCallback s);

//data

ArrayList<MCData> queryData(MCDataSourceResult r, long startTimestamp, long endTimestamp);
ArrayList<MCData> queryData(MCDataSourceResult r, int lastN);
int queryDataCount(MCDataSourceResult r, long startTimestamp, long endTimestamp);
int insertData(MCRegistration reg, MCData d);
int insertData(MCRegistration reg, MCData[] d);
void subscribeDataAsync(MCDataSourceResult r, MCSubscribeDataCallback s);
void unsubscribeDataAsync(MCSubscribeDataCallback s);

```

## Contributing
Please read our [Contributing Guidelines](https://md2k.org/software/under-the-hood/contributing) for details on the process for submitting pull requests to us.

We use the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html).

Our [Code of Conduct](https://md2k.org/software/CodeofConduct) is the [Contributor Covenant](https://www.contributor-covenant.org/).

Bug reports can be submitted through [JIRA](https://md2korg.atlassian.net/secure/Dashboard.jspa).

Our discussion forum can be found [here](https://discuss.md2k.org/).

## Versioning

We use [Semantic Versioning](https://semver.org/) for versioning the software which is based on the following guidelines.

MAJOR.MINOR.PATCH (example: 3.0.12)

  1. MAJOR version when incompatible API changes are made,
  2. MINOR version when functionality is added in a backwards-compatible manner, and
  3. PATCH version when backwards-compatible bug fixes are introduced.

For the versions available, see [this repository's tags](https://github.com/MD2Korg/mCerebrum-API-android/tags).

## Contributors

Link to the [list of contributors](https://github.com/MD2Korg/mCerebrum-API-android/graphs/contributors) who participated in this project.

## License

This project is licensed under the BSD 2-Clause - see the [license](https://md2k.org/software-under-the-hood/software-uth-license) file for details.

## Acknowledgments

* [National Institutes of Health](https://www.nih.gov/) - [Big Data to Knowledge Initiative](https://datascience.nih.gov/bd2k)
  * Grants: R01MD010362, 1UG1DA04030901, 1U54EB020404, 1R01CA190329, 1R01DE02524, R00MD010468, 3UH2DA041713, 10555SC
* [National Science Foundation](https://www.nsf.gov/)
  * Grants: 1640813, 1722646
* [Intelligence Advanced Research Projects Activity](https://www.iarpa.gov/)
  * Contract: 2017-17042800006
