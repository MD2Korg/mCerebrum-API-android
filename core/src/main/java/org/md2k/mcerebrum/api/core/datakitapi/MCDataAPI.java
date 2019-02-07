package org.md2k.mcerebrum.api.core.datakitapi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;

import org.md2k.mcerebrum.api.core.datakitapi.data.MCData;
import org.md2k.mcerebrum.api.core.datakitapi.datasource.DataSourceQuery;
import org.md2k.mcerebrum.api.core.datakitapi.datasource.DataSourceRegister;
import org.md2k.mcerebrum.api.core.datakitapi.datasource.DataSourceResult;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.authenticate.ConnectionCallback;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.data.QueryDataCallback;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.insert_datasource.RegisterCallback;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.insert_datasource.Registration;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.query_data_count.CountDataCallback;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.query_datasource.QueryDataSourceCallback;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.subscribe_data.SubscribeDataCallback;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.subscribe_datasource.SubscribeDataSourceCallback;

import java.util.ArrayList;

/*
 * Copyright (c) 2016, The University of Memphis, MD2K Center
 * - Syed Monowar Hossain <monowar.hossain@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
public final class MCDataAPI {
    @SuppressLint("StaticFieldLeak")
    private static MCDataAPI instance = null;
    private Context context;
    private static org.md2k.mcerebrum.api.core.datakitapi.MCData mcDataAPI = null;

    public static void init(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        if (instance == null) {
            instance = new MCDataAPI(context.getApplicationContext());
            mcDataAPI = new org.md2k.mcerebrum.api.core.datakitapi.MCData();
        }
    }

    private MCDataAPI(Context context) {
        this.context = context;
    }

    public static Context getContext() {
        if (instance == null) return null;
        return instance.context;
    }

    public static void connect(ConnectionCallback connectionCallback) {
        Preconditions.checkAPIInitialized(instance);
        Preconditions.checkNotNull(connectionCallback);
        mcDataAPI.connect(connectionCallback);
    }
    public static boolean isConnected(){
        Preconditions.checkAPIInitialized(instance);
        return mcDataAPI.isConnected();
    }

    public static void disconnect(ConnectionCallback connectionCallback) {
        mcDataAPI.disconnect(connectionCallback);
    }

/*
    public static void disconnectAll() {
        mcDataAPI.disconnectAll();
    }
*/

    public static Registration registerDataSource(final DataSourceRegister dataSourceRegister) {
        Preconditions.checkAPIInitialized(instance);
        Preconditions.checkNotNull(dataSourceRegister);
        return mcDataAPI.registerDataSource(dataSourceRegister);
    }

    public static void registerDataSourceAsync(final DataSourceRegister dataSourceRegister, RegisterCallback registerCallback) {
        Preconditions.checkAPIInitialized(instance);
        Preconditions.checkNotNull(dataSourceRegister);
        Preconditions.checkNotNull(registerCallback);
        mcDataAPI.registerDataSourceAsync(dataSourceRegister, registerCallback);
    }

    public static ArrayList<DataSourceResult> queryDataSource(DataSourceQuery dataSourceQuery) {
        Preconditions.checkAPIInitialized(instance);
        Preconditions.checkNotNull(dataSourceQuery);
        return mcDataAPI.queryDataSource(dataSourceQuery);
    }

    public static void queryDataSourceAsync(DataSourceQuery dataSourceQuery, QueryDataSourceCallback queryDataSourceCallback) {
        Preconditions.checkAPIInitialized(instance);
        Preconditions.checkNotNull(dataSourceQuery);
        Preconditions.checkNotNull(queryDataSourceCallback);
        mcDataAPI.queryDataSourceAsync(dataSourceQuery, queryDataSourceCallback);
    }

    public static void subscribeDataSourceAsync(DataSourceQuery dataSourceQuery, SubscribeDataSourceCallback subscribeDataSourceCallback) {
        Preconditions.checkAPIInitialized(instance);
        Preconditions.checkNotNull(dataSourceQuery);
        Preconditions.checkNotNull(subscribeDataSourceCallback);
        mcDataAPI.subscribeDataSourceAsync(dataSourceQuery, subscribeDataSourceCallback);
    }

    public static void unsubscribeDataSourceAsync(SubscribeDataSourceCallback subscribeDataSourceCallback) {
        Preconditions.checkAPIInitialized(instance);
        Preconditions.checkNotNull(subscribeDataSourceCallback);
        mcDataAPI.unsubscribeDataSourceAsync(subscribeDataSourceCallback);
    }

    public static ArrayList<MCData> queryData(DataSourceResult dataSourceResult, long startTimestamp, long endTimestamp) {
        Preconditions.checkAPIInitialized(instance);
        Preconditions.checkNotNull(dataSourceResult);
        return mcDataAPI.queryDataByTime(dataSourceResult, startTimestamp, endTimestamp);
    }

    public static void queryDataAsync(DataSourceResult dataSourceResult, long startTimestamp, long endTimestamp, QueryDataCallback queryCallback) {
        Preconditions.checkAPIInitialized(instance);
        Preconditions.checkNotNull(dataSourceResult);
        Preconditions.checkNotNull(queryCallback);
        mcDataAPI.queryDataByTimeAsync(dataSourceResult, startTimestamp, endTimestamp, queryCallback);
    }

    public static ArrayList<MCData> queryData(DataSourceResult dataSourceResult, int lastN) {
        Preconditions.checkAPIInitialized(instance);
        Preconditions.checkNotNull(dataSourceResult);
        return mcDataAPI.queryDataByNumber(dataSourceResult, lastN);
    }

    public static void queryDataAsync(DataSourceResult dataSourceResult, int lastN, QueryDataCallback queryCallback) {
        Preconditions.checkAPIInitialized(instance);
        Preconditions.checkNotNull(dataSourceResult);
        Preconditions.checkNotNull(queryCallback);
        mcDataAPI.queryDataByNumberAsync(dataSourceResult, lastN, queryCallback);
    }

    public static int queryDataCount(DataSourceResult dataSourceResult, long startTimestamp, long endTimestamp) {
        Preconditions.checkAPIInitialized(instance);
        Preconditions.checkNotNull(dataSourceResult);
        return mcDataAPI.queryDataCount(dataSourceResult, startTimestamp, endTimestamp);
    }

    public static void queryDataCountAsync(DataSourceResult dataSourceResult, long startTimestamp, long endTimestamp, CountDataCallback countDataCallback) {
        Preconditions.checkAPIInitialized(instance);
        Preconditions.checkNotNull(dataSourceResult);
        Preconditions.checkNotNull(countDataCallback);
        mcDataAPI.queryDataCountAsync(dataSourceResult, startTimestamp, endTimestamp, countDataCallback);
    }

    public static int insertData(Registration registration, MCData data) {
        Preconditions.checkNotNull(data);
        return insertData(registration, new MCData[]{data});
    }

    public static int insertData(Registration registration, MCData[] data) {
        Preconditions.checkAPIInitialized(instance);
        Preconditions.checkNotNull(registration);
        Preconditions.checkNotNull(data);
        return mcDataAPI.insertData(registration, data);
    }

    public static void subscribeDataAsync(DataSourceResult dataSourceResult, SubscribeDataCallback subscribeDataCallback) {
        Preconditions.checkAPIInitialized(instance);
        Preconditions.checkNotNull(dataSourceResult);
        Preconditions.checkNotNull(subscribeDataCallback);
        mcDataAPI.subscribeDataAsync(dataSourceResult, subscribeDataCallback);
    }

    public static void unsubscribeDataAsync(SubscribeDataCallback subscribeDataCallback) {
        Preconditions.checkAPIInitialized(instance);
        Preconditions.checkNotNull(subscribeDataCallback);
        mcDataAPI.unsubscribeDataAsync(subscribeDataCallback);
    }

/*
    public static Data queryDataSummary(DataSourceResult dataSourceResult, long startTimestamp, long endTimestamp) {
        Preconditions.checkAPIInitialized(instance);
        Preconditions.checkNotNull(dataSourceResult);
        return mcDataAPI.queryDataSummary(dataSourceResult, startTimestamp, endTimestamp);
    }

    public static void queryDataSummaryAsync(DataSourceResult dataSourceResult, long startTimestamp, long endTimestamp, DataSummaryCallback queryCallback) {
        Preconditions.checkAPIInitialized(instance);
        Preconditions.checkNotNull(dataSourceResult);
        Preconditions.checkNotNull(queryCallback);
        mcDataAPI.queryDataSummaryAsync(dataSourceResult, startTimestamp, endTimestamp, queryCallback);
    }
/*
    public static boolean system(int operation){
        Preconditions.checkAPIInitialized(instance);
        try {
        return instance.connectionAPI.systemExec(operation);
        } catch (MCerebrumException e) {
            return false;
        }
    }
    public static void systemAsync(int operation, SystemCallback systemCallback){
        Preconditions.checkAPIInitialized(instance);
        Preconditions.checkNotNull(systemCallback);
        try {
            instance.connectionAPI.systemExecAsync(operation, systemCallback);
        } catch (MCerebrumException e) {
            systemCallback.onError(e.getStatus());
        }
    }

*/

}
