package org.md2k.mcerebrum.api.core;

import android.os.RemoteException;

import org.md2k.mcerebrum.api.core.datakitapi.data.Data;
import org.md2k.mcerebrum.api.core.datakitapi.datasource.DataSourceQuery;
import org.md2k.mcerebrum.api.core.datakitapi.datasource.DataSourceRegister;
import org.md2k.mcerebrum.api.core.datakitapi.datasource.DataSourceResult;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.IDataKitRemoteCallback;
import org.md2k.mcerebrum.api.core.datakitapi.ipc._Session;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.data.QueryDataCallback;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.data.SyncCallback;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.insert_data._InsertDataExec;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.insert_data._InsertDataIn;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.insert_datasource.RegisterCallback;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.insert_datasource.Registration;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.insert_datasource._InsertDataSourceIn;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.insert_datasource._InsertDataSourceOut;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.query_data_by_number._QueryDataByNumberIn;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.query_data_by_number._QueryDataByNumberOut;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.query_data_by_time._QueryDataByTimeIn;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.query_data_by_time._QueryDataByTimeOut;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.query_data_count.CountDataCallback;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.query_data_count._QueryDataCountIn;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.query_data_count._QueryDataCountOut;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.query_datasource.QueryDataSourceCallback;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.query_datasource._QueryDataSourceIn;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.query_datasource._QueryDataSourceOut;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.subscribe_data.SubscribeDataCallback;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.subscribe_data._SubscribeDataIn;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.subscribe_data._SubscribeDataOut;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.subscribe_data._UnsubscribeDataIn;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.subscribe_datasource.SubscribeDataSourceCallback;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.subscribe_datasource._SubscribeDataSourceIn;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.subscribe_datasource._SubscribeDataSourceOut;
import org.md2k.mcerebrum.api.core.datakitapi.ipc.subscribe_datasource._UnsubscribeDataSourceIn;
import org.md2k.mcerebrum.api.core.status.Status;

import java.util.ArrayList;
import java.util.HashMap;

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
class MCData extends Connection {
    private HashMap<SubscribeDataSourceCallback, IDataKitRemoteCallback.Stub> subscriptionDataSourceList;
    private HashMap<SubscribeDataCallback, IDataKitRemoteCallback.Stub> subscriptionDataList;
    private _InsertDataExec insertDataExec;

    MCData() {
        subscriptionDataSourceList = new HashMap<>();
        subscriptionDataList = new HashMap<>();
        insertDataExec = new _InsertDataExec(new SyncCallback() {
            @Override
            public void sync() {
                _Session in = _InsertDataIn.create(createSessionId(), insertDataExec.getData());

                try {
                    execute(in);
                } catch (RemoteException e) {
                    //TODO:
                }
            }
        });
    }

    Registration registerDataSource(DataSourceRegister dataSourceRegister) {
        _Session in = _InsertDataSourceIn.create(createSessionId(), dataSourceRegister.getDataSource());
        _Session out;
        try {
            out = execute(in);
        } catch (RemoteException e) {
            //TODO:
            return null;
        }
        return new Registration(_InsertDataSourceOut.getDataSourceResult(out.getBundle()));
    }

    void registerDataSourceAsync(DataSourceRegister dataSourceRegister, final RegisterCallback registerCallback) {
        _Session in = _InsertDataSourceIn.create(createSessionId(), dataSourceRegister.getDataSource());
        try {
            executeAsync(in, new IDataKitRemoteCallback.Stub() {
                @Override
                public void onReceived(_Session _session) throws RemoteException {
                    if (Status.isSuccessful(_session.getStatus()))
                        registerCallback.onRegister(new Registration(_InsertDataSourceOut.getDataSourceResult(_session.getBundle())), _session.getStatus());
                    else registerCallback.onRegister(null, _session.getStatus());
                }
            });
        } catch (Exception e) {
            registerCallback.onRegister(null, Status.CONNECTION_ERROR);
        }
    }

    ArrayList<DataSourceResult> queryDataSource(DataSourceQuery dataSourceQuery) {
        _Session in = _QueryDataSourceIn.create(createSessionId(), dataSourceQuery.getDataSource());
        _Session session = null;
        try {
            session = execute(in);
        } catch (RemoteException e) {
            //TODO:
            return null;
        }
        return _QueryDataSourceOut.getDataSourceResults(session.getBundle());
    }

    void queryDataSourceAsync(DataSourceQuery dataSourceQuery, final QueryDataSourceCallback queryDataSourceCallback) {
        _Session in = _QueryDataSourceIn.create(createSessionId(), dataSourceQuery.getDataSource());

        try {
            executeAsync(in, new IDataKitRemoteCallback.Stub() {
                @Override
                public void onReceived(_Session _session) throws RemoteException {
                    if (Status.isSuccessful(_session.getStatus()))
                        queryDataSourceCallback.onReceive(_QueryDataSourceOut.getDataSourceResults(_session.getBundle()), _session.getStatus());
                    else queryDataSourceCallback.onReceive(null, _session.getStatus());
                }
            });
        } catch (Exception e) {
            queryDataSourceCallback.onReceive(null, Status.CONNECTION_ERROR);
        }
    }

    void subscribeDataSourceAsync(DataSourceQuery dataSourceQuery, final SubscribeDataSourceCallback subscribeDataSourceCallback) {
        if (subscriptionDataSourceList.containsKey(subscribeDataSourceCallback)) return;
        _Session in = _SubscribeDataSourceIn.create(createSessionId(), dataSourceQuery.getDataSource());
        IDataKitRemoteCallback.Stub iDataKitRemoteCallback = new IDataKitRemoteCallback.Stub() {
            @Override
            public void onReceived(_Session _session) throws RemoteException {
                subscribeDataSourceCallback.onReceive(_SubscribeDataSourceOut.getDataSourceResult(_session.getBundle()));
            }
        };
        subscriptionDataSourceList.put(subscribeDataSourceCallback, iDataKitRemoteCallback);

        try {
            executeAsync(in, iDataKitRemoteCallback);
        } catch (RemoteException e) {
            //TODO:
            subscribeDataSourceCallback.onError(Status.CONNECTION_ERROR);
        }
    }

    void unsubscribeDataSourceAsync(SubscribeDataSourceCallback subscribeDataSourceCallback) {
        if (!subscriptionDataSourceList.containsKey(subscribeDataSourceCallback)) return;
        try {
            executeAsync(_UnsubscribeDataSourceIn.create(createSessionId()), subscriptionDataSourceList.get(subscribeDataSourceCallback));
        } catch (RemoteException e) {
            //TODO:
        }
        subscriptionDataSourceList.remove(subscribeDataSourceCallback);
    }


    ArrayList<Data> queryDataByTime(DataSourceResult dataSourceResult, long startTimestamp, long endTimestamp) {
        insertDataExec.syncIfRequired(dataSourceResult.getDsId());
        _Session in = _QueryDataByTimeIn.create(createSessionId(), dataSourceResult.getDsId(), startTimestamp, endTimestamp);
        try {
            _Session out = execute(in);
            return _QueryDataByTimeOut.getData(out.getBundle());
        } catch (RemoteException e) {
            //TODO:
            return null;
        }
    }


    void queryDataByTimeAsync(DataSourceResult dataSourceResult, long startTimestamp, long endTimestamp, final QueryDataCallback queryCallback) {
        insertDataExec.syncIfRequired(dataSourceResult.getDsId());
        _Session in = _QueryDataByTimeIn.create(createSessionId(), dataSourceResult.getDsId(), startTimestamp, endTimestamp);
        try {
            executeAsync(in, new IDataKitRemoteCallback.Stub() {
                @Override
                public void onReceived(_Session _session) throws RemoteException {
                    if (Status.isSuccessful(_session.getStatus()))
                        queryCallback.onReceive(_QueryDataByTimeOut.getData(_session.getBundle()), _session.getStatus());
                    else queryCallback.onReceive(null, _session.getStatus());
                }
            });
        } catch (Exception e) {
            queryCallback.onReceive(null, Status.CONNECTION_ERROR);
        }
    }


    ArrayList<Data> queryDataByNumber(DataSourceResult dataSourceResult, int lastNData) {
        insertDataExec.syncIfRequired(dataSourceResult.getDsId());
        _Session in = _QueryDataByNumberIn.create(createSessionId(), dataSourceResult.getDsId(), lastNData);
        try {
            _Session out = execute(in);
            return _QueryDataByNumberOut.getData(out.getBundle());
        } catch (RemoteException e) {
            //TODO:
            return null;
        }
    }


    void queryDataByNumberAsync(DataSourceResult dataSourceResult, int lastNData, final QueryDataCallback queryCallback) {
        insertDataExec.syncIfRequired(dataSourceResult.getDsId());
        _Session in = _QueryDataByNumberIn.create(createSessionId(), dataSourceResult.getDsId(), lastNData);
        try {
            executeAsync(in, new IDataKitRemoteCallback.Stub() {
                @Override
                public void onReceived(_Session _session) throws RemoteException {
                    if (Status.isSuccessful(_session.getStatus()))
                        queryCallback.onReceive(_QueryDataByNumberOut.getData(_session.getBundle()), _session.getStatus());
                    else queryCallback.onReceive(null, _session.getStatus());
                }
            });
        } catch (Exception e) {
            queryCallback.onReceive(null, Status.CONNECTION_ERROR);
        }
    }

    int queryDataCount(DataSourceResult dataSourceResult, long startTimestamp, long endTimestamp) {
        insertDataExec.syncIfRequired(dataSourceResult.getDsId());
        _Session in = _QueryDataCountIn.create(createSessionId(), dataSourceResult.getDsId(), startTimestamp, endTimestamp);
        try {
            _Session out = execute(in);
            return _QueryDataCountOut.getCount(out.getBundle());
        } catch (RemoteException e) {
            //TODO:
            return -1;
        }
    }

    void queryDataCountAsync(DataSourceResult dataSourceResult, long startTimestamp, long endTimestamp, final CountDataCallback callback) {
        insertDataExec.syncIfRequired(dataSourceResult.getDsId());
        _Session in = _QueryDataCountIn.create(createSessionId(), dataSourceResult.getDsId(), startTimestamp, endTimestamp);
        try {
            executeAsync(in, new IDataKitRemoteCallback.Stub() {
                @Override
                public void onReceived(_Session _session) throws RemoteException {
                    if (Status.isSuccessful(_session.getStatus()))
                        callback.onReceive(_QueryDataCountOut.getCount(_session.getBundle()), _session.getStatus());
                    else callback.onReceive(-1, _session.getStatus());
                }
            });
        } catch (Exception e) {
            callback.onReceive(-1, Status.CONNECTION_ERROR);
        }
    }

    int insertData(Registration registration, Data[] data) {
        for (Data aData : data)
            if (registration.getDataSource().getSampleType() != aData.getSampleType() || registration.getDataSource().getDataType() != aData.getDataType())
                return Status.INVALID_DATA;
        insertDataExec.addData(registration, data);
        return Status.SUCCESS;
    }

    void subscribeDataAsync(DataSourceResult dataSourceResult, final SubscribeDataCallback subscribeDataCallback) {
        if (subscriptionDataList.containsKey(subscribeDataCallback)) return;
        _Session in = _SubscribeDataIn.create(createSessionId(), dataSourceResult);
        IDataKitRemoteCallback.Stub iDataKitRemoteCallback = new IDataKitRemoteCallback.Stub() {
            @Override
            public void onReceived(_Session _session) throws RemoteException {
                ArrayList<Data> data = _SubscribeDataOut.getData(_session.getBundle());
                for (int i = 0; i < data.size(); i++)
                    subscribeDataCallback.onReceive(data.get(i));
            }
        };
        subscriptionDataList.put(subscribeDataCallback, iDataKitRemoteCallback);

        try {
            executeAsync(in, iDataKitRemoteCallback);
        } catch (RemoteException e) {
            //TODO:
            subscribeDataCallback.onError(Status.CONNECTION_ERROR);
        }
    }

    void unsubscribeDataAsync(SubscribeDataCallback subscribeDataCallback) {
        if (!subscriptionDataList.containsKey(subscribeDataCallback)) return;
        try {
            executeAsync(_UnsubscribeDataIn.create(createSessionId()), subscriptionDataList.get(subscribeDataCallback));
        } catch (RemoteException e) {
            //TODO:
        }
        subscriptionDataList.remove(subscribeDataCallback);
    }


}
