package org.md2k.mcerebrumapi.core.extensionapi.app;

import org.md2k.mcerebrumapi.core.data.MCValue;

interface IExtensionCallback{
    void onSuccess(in MCValue value);
    void onError(String message);
}
