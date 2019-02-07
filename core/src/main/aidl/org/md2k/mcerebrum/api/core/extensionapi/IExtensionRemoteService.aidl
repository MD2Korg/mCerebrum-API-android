package org.md2k.mcerebrum.api.core.extensionapi;

import org.md2k.mcerebrum.api.core.extensionapi.MCExtensionAPI;
import org.md2k.mcerebrum.api.core.extensionapi.Param;
import org.md2k.mcerebrum.api.core.extensionapi.ICallback;
interface IExtensionRemoteService{
    MCExtensionAPI getExtensionInfo();
    void execute(String type, String id, String param, ICallback callback);
}
