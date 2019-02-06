# mCerebrum-API-android
[![Build Status](https://travis-ci.org/MD2Korg/mCerebrum-API-android.svg?branch=master)](https://travis-ci.org/MD2Korg/mCerebrum-API-android)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/36f4bb30e9554b34b24220781f77ffe1)](https://app.codacy.com/app/monowar-hossain/mCerebrum-API-android?utm_source=github.com&utm_medium=referral&utm_content=MD2Korg/mCerebrum-API-android&utm_campaign=Badge_Grade_Dashboard)
[ ![Download](https://api.bintray.com/packages/md2korg/mCerebrum/core/images/download.svg) ](https://bintray.com/md2korg/mCerebrum/core/_latestVersion)

mCerebrum is a configurable smartphone software platform for mobile and wearable sensors. It provides support for reliable data collection from mobile and wearable sensors, and offers real-time processing of these data.


This Android library is the communication API for mCerebrum and is utilized by all applications that wish to communicate with mCerebrum.

You can find more information about MD2K software on our [software website](https://md2k.org/software) or the MD2K organization on our [MD2K website](https://md2k.org/).

## Usage

### Dependency
Include the library in your `build.gradle`
```groovy
implementation "org.md2k.mcerebrum.api:core:<latest_version>"
```
(Please replace `<latest_version>` with this: [ ![Download](https://api.bintray.com/packages/md2korg/mCerebrum/core/images/download.svg) ](https://bintray.com/md2korg/mCerebrum/core/_latestVersion)
)


### Using mCerebrumAPI

- Step 1: initialize MCerebrumAPI
- Step 2: Connect to mCerebrum through ``connect()`` function.
- Step 3: InThen, you can insert, query or subscribe any datastream. Functions supported by mCerebrum: `connect()`, `disconnect()`, `registerDataSource()`, `queryDataSource()`, `subscribeDataSourceAsync()`, `queryData()`, `queryCount()`, `subscribe()`, `unsubscribe()`

#### Initialize mCerebrumAPI
Initialize MCerebrumAPI before using it.
```java
mCerebrumAPI.init(context);
```

#### Connect to mCerebrum
Step 1: Use connect() function to connect to `mCerebrum`
```java
 MCerebrumAPI.connect(new ConnectionCallback() {
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
- Step 1: Connect to mCerebrum (as [Connect to mCerebrum](conect) )
- Step 2: Create DataSourceRegister using `DataSource.RegisterBuilder()`
- Step 3: Register datasource to mCerebrum
<br><br> Example: 
```
// register Accelerometer datastream

//Step 2:
DataSourceRegister req = DataSource.RegisterBuilder()
                        .setDataType(DataType.POINT)
                        .setSampleType(SampleType.INT_ARRAY)
                        .addDataDescriptor(DataDescriptor.Builder().setName("ACL_X").build())
                        .addDataDescriptor(DataDescriptor.Builder().setName("ACL_Y").build())
                        .addDataDescriptor(DataDescriptor.Builder().setName("ACL_Z").build())
                        .setDataSourceType("ACCELEROMETER")
                        .setPlatformType("PHONE")
                        .setDataSourceMetaData(DataSourceMetaData.Builder().setUnit("METER_PER_SECOND_SQUARED").build())
                        .build();
//Step 3:
Registration r = MCerebrumAPI.registerDataSource(dataSourceRegisterCreator);
 ```

#### Insert Data to mCerebrum

Supported data types: `BOOLEAN_ARRAY`, `BYTE_ARRAY`, `INT_ARRAY`, `LONG_ARRAY`, `DOUBLE_ARRAY`, `STRING_ARRAY`, `ENUM`, `OBJECT`

- Step 1: Connect to mCerebrum
- Step 2: Create DataSourceRegister using `DataSource.RegisterBuilder()`
- Step 3: Register datasource to mCerebrum
- Step 4: Insert data to mCerebrum using registered id returned by `registerDataSource()` function

```
// insert accelerometer data

double[] values=new double[]{5.4,4.1,-2.0};
Data point = Data.createPoint(System.currentTimeMillis(), values);
MCerebrumAPI.insertData(rid, point);
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
| POINT| Creates data with timestamp|
| ANNOTATION|Creates data with starttime and endtime|
#### Supported SampleType
|   SampleType|Example (Point)|Example(Annotation)
|---|---|---|
| BOOLEAN_ARRAY| `Data.createPoint(time, boolean[]{true, false}`|`Data.createAnnotation(startTime, endTime, boolean[]{true, false}`|
| BYTE_ARRAY|Creates data with starttime and endtime|

#### Supported Functionality

```
int connect(ConnectionCallback c);
int disconnect(ConnectionCallback c);
Registration register(DataSourceCreator d);
int unregister(Registration r);
DataSourceSet find(DataSourceQuery d);
int insert(Registration r, Data[] d);
DataSet query(DataSource dataSource, int lastNPoint);
DataSet query(DataSource dataSource, long startTimestamp, long endTimestamp);
DataSet querySummary(DataSource dataSource, long startTimestamp, long endTimestamp);
DataSet queryCount(DataSource dataSource, long startTimestamp, long endTimestamp);
int subscribe(DataSource dataSource, DataCallback callback);
int unsubscribe(dataSource dataSource, DataCallback callback);
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
