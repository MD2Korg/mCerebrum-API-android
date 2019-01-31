/*
 * Copyright (c) 2018, The University of Memphis, MD2K Center of Excellence
 *
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

package org.md2k.mcerebrum.api.core.datakitapi.datasource.metadata;

import java.util.HashMap;

/**
 * Builder class for <code>DataSource</code> objects
 */
public class PlatformAppMetaData {
    /**
     * Title of the platform
     */
    private static final String TITLE = "TITLE";
    /**
     * Summary of the platform
     */
    private static final String SUMMARY = "SUMMARY";
    /**
     * Description of the platform
     */
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final String OPERATING_SYSTEM = "OPERATING_SYSTEM";
    private static final String MANUFACTURER = "MANUFACTURER";
    private static final String MODEL = "MODEL";
    private static final String VERSION_FIRMWARE = "VERSION_FIRMWARE";
    private static final String VERSION_HARDWARE = "VERSION_HARDWARE";
    private static final String DEVICE_ID = "DEVICE_ID";
    private HashMap<String, String> metaData;

    public String getTitle() {
        return metaData.get(TITLE);
    }

    public String getSummary() {
        return metaData.get(SUMMARY);
    }

    public String getDescription() {
        return metaData.get(DESCRIPTION);
    }

    public String getOperationSystem() {
        return metaData.get(OPERATING_SYSTEM);
    }

    public String getManufacturer() {
        return metaData.get(MANUFACTURER);
    }

    public String getModel() {
        return metaData.get(MODEL);
    }

    public String getVersionFirmware() {
        return metaData.get(VERSION_FIRMWARE);
    }

    public String getVersionHardware() {
        return metaData.get(VERSION_HARDWARE);
    }

    public String getDeviceId() {
        return metaData.get(DEVICE_ID);
    }

    public String getMetaData(String key) {
        return metaData.get(key);
    }

    public HashMap<String, String> getMetaData() {
        return new HashMap<>(metaData);
    }

    private PlatformAppMetaData(PlatformAppMetaDataBuilder builder) {
        this.metaData = new HashMap<>(builder.metaData);
    }


    public static PlatformAppMetaDataBuilder Builder() {
        return new PlatformAppMetaDataBuilder();
    }

    public static class PlatformAppMetaDataBuilder {
        private HashMap<String, String> metaData;

        public PlatformAppMetaDataBuilder() {
            metaData = new HashMap<>();
        }

        public PlatformAppMetaDataBuilder setTitle(String title) {
            if (title != null)
                metaData.put(TITLE, title);
            return this;
        }

        public PlatformAppMetaDataBuilder setSummary(String summary) {
            if (summary != null)
                metaData.put(SUMMARY, summary);
            return this;
        }

        public PlatformAppMetaDataBuilder setDescription(String description) {
            if (description != null)
                metaData.put(DESCRIPTION, description);
            return this;
        }

        public PlatformAppMetaDataBuilder setOperationSystem(String operationSystem) {
            if (operationSystem != null)
                metaData.put(OPERATING_SYSTEM, operationSystem);
            return this;
        }

        public PlatformAppMetaDataBuilder setManufacturer(String manufacturer) {
            if (manufacturer != null)
                metaData.put(MANUFACTURER, manufacturer);
            return this;
        }

        public PlatformAppMetaDataBuilder setModel(String model) {
            if (model != null)
                metaData.put(MODEL, model);
            return this;
        }

        public PlatformAppMetaDataBuilder setVersionFirmware(String versionFirmware) {
            if (versionFirmware != null)
                metaData.put(VERSION_FIRMWARE, versionFirmware);
            return this;
        }

        public PlatformAppMetaDataBuilder setVersionHardware(String versionHardware) {
            if (versionHardware != null)
                metaData.put(VERSION_HARDWARE, versionHardware);
            return this;
        }

        public PlatformAppMetaDataBuilder setDeviceId(String deviceId) {
            if (deviceId != null)
                metaData.put(DEVICE_ID, deviceId);
            return this;
        }

        public PlatformAppMetaDataBuilder setMetaData(String key, String value) {
            if (key != null && value != null)
                this.metaData.put(key, value);
            return this;
        }

        public PlatformAppMetaDataBuilder setMetaData(HashMap<String, String> metaData) {
            if (metaData == null) return this;
            for (HashMap.Entry<String, String> entry : metaData.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null)
                    this.metaData.put(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public PlatformAppMetaData build() {
            return new PlatformAppMetaData(this);
        }
    }
}
