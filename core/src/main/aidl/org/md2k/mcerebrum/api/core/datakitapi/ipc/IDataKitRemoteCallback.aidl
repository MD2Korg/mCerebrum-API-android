package org.md2k.mcerebrum.api.core.datakitapi.ipc;

import org.md2k.mcerebrum.api.core.datakitapi.ipc._Session;

interface IDataKitRemoteCallback{
    void onReceived(in _Session _session);
}
