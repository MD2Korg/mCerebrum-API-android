package org.md2k.mcerebrum.api.core.extensionapi;

import org.md2k.mcerebrum.api.core.MCExtension;
import org.md2k.mcerebrum.api.core.extensionapi.Param;
import org.md2k.mcerebrum.api.core.extensionapi.ICallback;
interface IExtensionRemoteService{
    MCExtension getExtensionInfo();
    void execute(String type, String id, String param, ICallback callback);
}
