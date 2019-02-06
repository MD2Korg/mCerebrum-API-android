package org.md2k.mcerebrum.api.core.extensionapi;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import org.md2k.mcerebrum.api.core.MCExtension;

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
public abstract class MCExtensionService extends Service {
    protected abstract MCExtension getMCExtension();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private final IExtensionRemoteService.Stub mBinder = new IExtensionRemoteService.Stub() {
        @Override
        public MCExtension getExtensionInfo() {
            return getMCExtension();
        }

        @Override
        public void execute(String type, String id, String param, ICallback callback) throws RemoteException {
            switch (type) {
                case IBackgroundProcess.TYPE:
                    runBackgroundProcess(id, callback);
                    break;
                case IPermission.TYPE:
                    runPermission(id, callback);
                    break;
                case UserInterface.TYPE:
                    runUserInterface(id, param, callback);
                    break;
                case IConfigure.TYPE:
                    runConfigure(id, param, callback);
                    break;
                case Action.TYPE:
                    runAction(id, param, callback);
                    break;
                default:
            }
        }
    };

    private void runBackgroundProcess(String id, ICallback iCallback) throws RemoteException {
        switch (id) {
            case IBackgroundProcess.ID_START:
                getMCExtension().getiBackgroundProcess().start();
                iCallback.onSuccess(null);
                break;
            case IBackgroundProcess.ID_STOP:
                getMCExtension().getiBackgroundProcess().stop();
                iCallback.onSuccess(null);
                break;
            case IBackgroundProcess.ID_IS_RUNNING:
                boolean result = getMCExtension().getiBackgroundProcess().isRunning();
                iCallback.onSuccess(String.valueOf(result));
                break;
            default:
        }
    }

    private void runPermission(String id, ICallback iCallback) throws RemoteException {
        switch (id) {
            case IPermission.ID_REQUEST_PERMISSION:
                getMCExtension().getiUserPermission().requestPermission();
                iCallback.onSuccess(null);
                break;
            case IPermission.ID_HAS_PERMISSION:
                boolean result = getMCExtension().getiUserPermission().hasPermission();
                iCallback.onSuccess(String.valueOf(result));
                break;
            default:
        }
    }

    private void runUserInterface(String id, String param, ICallback iCallback) throws RemoteException {
        ArrayList<UserInterface> list = getMCExtension().getUserInterfaces();
        for (int i = 0; i < list.size(); i++) {
            Param uiParam = list.get(i).getParam();
            if (uiParam.getId().equals(id)) {
                list.get(i).getMcUserInterface().openUserInterface(param);
                iCallback.onSuccess(null);
                return;
            }
        }
        iCallback.onSuccess(null);
    }

    private void runAction(String id, String param, ICallback iCallback) throws RemoteException {
        ArrayList<Action> list = getMCExtension().getActions();
        for (int i = 0; i < list.size(); i++) {
            Param uiParam = list.get(i).getParam();
            if (uiParam.getId().equals(id)) {
                list.get(i).getMcAction().run(param, iCallback);
                return;
            }
        }
        iCallback.onSuccess(null);
    }

    private void runConfigure(String id, String param, ICallback iCallback) throws RemoteException {
        switch (id) {
            case IConfigure.ID_SET:
                getMCExtension().getiConfigure().setConfiguration(param);
                iCallback.onSuccess(null);
                break;
            case IConfigure.ID_GET_STATE:
                ConfigState c = getMCExtension().getiConfigure().getConfigurationState();
                iCallback.onSuccess(String.valueOf(c.getValue()));
                break;
            default:
        }
    }

}
