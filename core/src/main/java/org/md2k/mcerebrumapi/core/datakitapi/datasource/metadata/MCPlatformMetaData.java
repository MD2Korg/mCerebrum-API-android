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

package org.md2k.mcerebrumapi.core.datakitapi.datasource.metadata;

import java.util.HashMap;
import java.util.Map;

/**
 * This class defines the <code>PlatformMetaData</code> object. This object provides a structure
 * for organizing the metadata related to the platform that collects a data point. This class
 * implements <code>Parcelable</code> so that the <code>PlatformMetaData</code> objects can be
 * parceled with their data points. Metadata of note includes the application title, summary, description,
 * operating system, manufacturer, model, version firmware, version hardware, and device id.
 * These fields are stored in a hash map of strings.
 */
public class MCPlatformMetaData {
    private static final String NAME = "NAME";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final String OPERATING_SYSTEM = "OPERATING_SYSTEM";
    private static final String MANUFACTURER = "MANUFACTURER";
    private static final String MODEL = "MODEL";
    private static final String VERSION_FIRMWARE = "VERSION_FIRMWARE";
    private static final String VERSION_HARDWARE = "VERSION_HARDWARE";
    private static final String DEVICE_ID = "DEVICE_ID";
    private HashMap<String, String> metaData;

    /**
     * Returns the name.
     *
     * @return The name.
     */
    public String getName() {
        return metaData.get(NAME);
    }

    /**
     * Returns the description.
     *
     * @return The description.
     */
    public String getDescription() {
        return metaData.get(DESCRIPTION);
    }

    /**
     * Returns the operating system.
     *
     * @return The operating system.
     */
    public String getOperationSystem() {
        return metaData.get(OPERATING_SYSTEM);
    }

    /**
     * Returns the manufacturer.
     *
     * @return The manufacturer.
     */
    public String getManufacturer() {
        return metaData.get(MANUFACTURER);
    }

    /**
     * Returns the model.
     *
     * @return The model.
     */
    public String getModel() {
        return metaData.get(MODEL);
    }

    /**
     * Returns the version firmware.
     *
     * @return The version firmware.
     */
    public String getVersionFirmware() {
        return metaData.get(VERSION_FIRMWARE);
    }

    /**
     * Returns the version hardware.
     *
     * @return The version hardware.
     */
    public String getVersionHardware() {
        return metaData.get(VERSION_HARDWARE);
    }

    /**
     * Returns the device id.
     *
     * @return The device id.
     */
    public String getDeviceId() {
        return metaData.get(DEVICE_ID);
    }

    /**
     * Returns the metadata field for the given key.
     *
     * @param key Key of the the metadata to return. This key should be the name of the field in all
     *            capital letters, any spaces should be underscores.
     * @return The metadata field for the given key.
     */
    public String getMetaData(String key) {
        return metaData.get(key);
    }

    /**
     * Returns the metadata field as a hashMap.
     *
     * @return The metadata field as a hashMap.
     */
    public HashMap<String, String> getMetaData() {
        return new HashMap<>(metaData);
    }


    /**
     * Constructor
     *
     * @param builder builder object defining how to construct the <code>PlatformMetaData</code>.
     */
    private MCPlatformMetaData(PlatformMetaDataBuilder builder) {
        this.metaData = new HashMap<>(builder.metaData);
    }


    /**
     * Creates a new <code>builder</code> object to define an <code>PlatformMetaData</code> object.
     *
     * @return A new <code>builder</code>.
     */
    public static PlatformMetaDataBuilder builder() {
        return new PlatformMetaDataBuilder();
    }


    /**
     * Embedded class that defines the <code>builder</code> for <code>PlatformMetaData</code>.
     */
    public static class PlatformMetaDataBuilder {
        private HashMap<String, String> metaData;

        /**
         * Constructor
         * This constructor initializes a new hash map.
         */
        public PlatformMetaDataBuilder() {
            metaData = new HashMap<>();
        }

        /**
         * Sets the <code>NAME</code> key of the hash map.
         *
         * @param name Value to associate <code>NAME</code> to.
         * @return The modified <code>builder</code>.
         */
        public PlatformMetaDataBuilder setName(String name) {
            if (name != null)
                metaData.put(NAME, name);
            return this;
        }

        /**
         * Sets the <code>DESCRIPTION</code> key of the hash map.
         *
         * @param description Value to associate <code>DESCRIPTION</code> to.
         * @return The modified <code>builder</code>.
         */
        public PlatformMetaDataBuilder setDescription(String description) {
            if (description != null)
                metaData.put(DESCRIPTION, description);
            return this;
        }

        /**
         * Sets the <code>OPERATING_SYSTEM</code> key of the hash map.
         *
         * @param operationSystem Value to associate <code>OPERATING_SYSTEM</code> to.
         * @return The modified <code>builder</code>.
         */
        public PlatformMetaDataBuilder setOperationSystem(String operationSystem) {
            if (operationSystem != null)
                metaData.put(OPERATING_SYSTEM, operationSystem);
            return this;
        }

        /**
         * Sets the <code>MANUFACTURER</code> key of the hash map.
         *
         * @param manufacturer Value to associate <code>MANUFACTURER</code> to.
         * @return The modified <code>builder</code>.
         */
        public PlatformMetaDataBuilder setManufacturer(String manufacturer) {
            if (manufacturer != null)
                metaData.put(MANUFACTURER, manufacturer);
            return this;
        }

        /**
         * Sets the <code>MODEL</code> key of the hash map.
         *
         * @param model Value to associate <code>MODEL</code> to.
         * @return The modified <code>builder</code>.
         */
        public PlatformMetaDataBuilder setModel(String model) {
            if (model != null)
                metaData.put(MODEL, model);
            return this;
        }

        /**
         * Sets the <code>VERSION_FIRMWARE</code> key of the hash map.
         *
         * @param versionFirmware Value to associate <code>VERSION_FIRMWARE</code> to.
         * @return The modified <code>builder</code>.
         */
        public PlatformMetaDataBuilder setVersionFirmware(String versionFirmware) {
            if (versionFirmware != null)
                metaData.put(VERSION_FIRMWARE, versionFirmware);
            return this;
        }

        /**
         * Sets the <code>VERSION_HARDWARE</code> key of the hash map.
         *
         * @param versionHardware Value to associate <code>VERSION_HARDWARE</code> to.
         * @return The modified <code>builder</code>.
         */
        public PlatformMetaDataBuilder setVersionHardware(String versionHardware) {
            if (versionHardware != null)
                metaData.put(VERSION_HARDWARE, versionHardware);
            return this;
        }

        /**
         * Sets the <code>DEVICE_ID</code> key of the hash map.
         *
         * @param deviceId Value to associate <code>DEVICE_ID</code> to.
         * @return The modified <code>builder</code>.
         */
        public PlatformMetaDataBuilder setDeviceId(String deviceId) {
            if (deviceId != null)
                metaData.put(DEVICE_ID, deviceId);
            return this;
        }

        /**
         * Puts a custom key and value into the hash map.
         *
         * @param key   Key to add to the hash map.
         * @param value Value to add to the hash map.
         * @return The modified <code>builder</code>.
         */
        public PlatformMetaDataBuilder setMetaData(String key, String value) {
            if (key != null && value != null)
                this.metaData.put(key, value);
            return this;
        }

        /**
         * Takes an existing hash map and merges it into the <code>builder</code>'s hash map.
         *
         * @param metaData Hash map to add to the <code>builder</code>.
         * @return The modified <code>builder</code>.
         */
        public PlatformMetaDataBuilder setMetaData(HashMap<String, String> metaData) {
            if (metaData == null) return this;
            for (HashMap.Entry<String, String> entry : metaData.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null)
                    this.metaData.put(entry.getKey(), entry.getValue());
            }
            return this;
        }

        /**
         * Passes the <code>builder</code> to the <code>PlatformMetaData</code> constructor.
         *
         * @return The resulting <code>PlatformMetaData</code> object.
         */
        public MCPlatformMetaData build() {
            return new MCPlatformMetaData(this);
        }
    }
    /**
     * Compares the passed object to the calling object.
     * If the passed object is not an instance of this class, false is returned.
     *
     * @param toCompare Object to compare.
     * @return True if the objects are equivalent and false if they are not.
     */
    @Override
    public boolean equals(Object toCompare) {
        if (toCompare instanceof MCPlatformMetaData) {
            if (metaData.size() != ((MCPlatformMetaData) toCompare).metaData.size()) return false;
            for (Map.Entry<String, String> entry : metaData.entrySet()) {
                if (!((MCPlatformMetaData) toCompare).metaData.containsKey(entry.getKey()))
                    return false;
                if (!entry.getValue().equals(((MCPlatformMetaData) toCompare).metaData.get(entry.getKey())))
                    return false;
            }
            return true;
        } else
            return false;
    }

    /**
     * Calculates and returns a hash code for the calling object.
     * The hash code is calculated using the method denoted in "Effective Java" and described in this Medium
     * <a href="https://medium.com/codelog/overriding-hashcode-method-effective-java-notes-723c1fedf51c">post</a>.
     *
     * @return The hash code of the calling object.
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + metaData.hashCode();
        return result;
    }

}
