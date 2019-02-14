package org.md2k.mcerebrumapi.core.datakitapi;

import org.md2k.mcerebrumapi.core.datakitapi.ipc._Session;
import org.md2k.mcerebrumapi.core.datakitapi.ipc.IDataKitRemoteCallback;

interface IDataKitRemoteService{
    _Session execute(in _Session _session);
    void executeAsync(in _Session _session, IDataKitRemoteCallback iDataKitRemoteCallback);
}
