package org.md2k.mcerebrum.api.core.datakitapi.ipc.subscribe_data;

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
class DataSubscribers {
    private ArrayList<Subscriber> subscribers;

    DataSubscribers() {
        subscribers = new ArrayList<>();
    }

    ArrayList<SubscribeDataCallback> getCallback(int sessionId) {
        ArrayList<SubscribeDataCallback> arrayList = new ArrayList<>();
        for (int i = 0; i < subscribers.size(); i++) {
            if (subscribers.get(i).sessionId == sessionId)
                arrayList.add(subscribers.get(i).callback);
        }
        return arrayList;
    }

    boolean hasCallback(SubscribeDataCallback subscribeDataCallback) {
        for (int i = 0; i < subscribers.size(); i++)
            if (subscribers.get(i).callback == subscribeDataCallback)
                return true;
        return false;
    }

    boolean hasUUID(String uuid) {
        for (int i = 0; i < subscribers.size(); i++)
            if (subscribers.get(i).uuid.equals(uuid))
                return true;
        return false;
    }

    private int getUUID(String uuid) {
        for (int i = 0; i < subscribers.size(); i++)
            if (subscribers.get(i).uuid.equals(uuid))
                return subscribers.get(i).sessionId;
        return -1;

    }

    void remove(SubscribeDataCallback callback) {
        int index = -1;
        for (int i = 0; i < subscribers.size(); i++)
            if (subscribers.get(i).callback == callback) {
                index = i;
                break;
            }
        if (index != -1)
            subscribers.remove(index);
    }

    String getUUID(SubscribeDataCallback callback) {
        for (int i = 0; i < subscribers.size(); i++)
            if (subscribers.get(i).callback == callback)
                return subscribers.get(i).uuid;
        return null;
    }

    int getSessionId(SubscribeDataCallback callback) {
        for (int i = 0; i < subscribers.size(); i++)
            if (subscribers.get(i).callback == callback)
                return subscribers.get(i).sessionId;
        return -1;
    }

    void add(String uuid, SubscribeDataCallback subscribeDataCallback) {
        int sessionId = getUUID(uuid);
        subscribers.add(new Subscriber(uuid, sessionId, subscribeDataCallback));
    }

    void add(String uuid, int sessionId, SubscribeDataCallback subscribeDataCallback) {
        subscribers.add(new Subscriber(uuid, sessionId, subscribeDataCallback));
    }
/*
    private boolean addIfExist(String uuid, SubscribeDataSourceCallback subscribeDataCallback) {
        for (int i = 0; i < subscribers.size(); i++)
            if (subscribers.get(i).uuid.equals(uuid)) {
                subscribers.add(new Subscriber(uuid, subscribers.get(i).sessionId, subscribeDataCallback));
            }
    }
*/

    class Subscriber {
        String uuid;
        int sessionId;
        SubscribeDataCallback callback;

        Subscriber(String uuid, int sessionId, SubscribeDataCallback subscribeDataCallback) {
            this.uuid = uuid;
            this.sessionId = sessionId;
            this.callback = subscribeDataCallback;
        }
    }

}
