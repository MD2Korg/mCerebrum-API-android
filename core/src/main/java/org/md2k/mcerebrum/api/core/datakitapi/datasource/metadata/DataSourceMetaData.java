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
import java.util.Map;

/**
 * This class defines the <code>DataSourceMetaData</code> object. This object provides a structure
 * for organizing the metadata related to the data source that collects a data point. This class
 * implements <code>Parcelable</code> so that the <code>DataSourceMetaData</code> objects can be
 * parceled with their data points. Metadata of note includes the application title, summary, description,
 * and data collection rate (denoted as data rate). These fields are stored in a hash map of strings.
 */
public class DataSourceMetaData {
    private static final String TITLE = "TITLE";
    private static final String SUMMARY = "SUMMARY";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final String DATA_RATE_TYPE = "DATA_RATE_TYPE";
    private static final String DATA_RATE_VALUE = "DATA_RATE_VALUE";

    private HashMap<String, String> metaData;

    /**
     * Returns the title.
     *
     * @return The title.
     */
    public String getTitle() {
        return metaData.get(TITLE);
    }

    /**
     * Returns the summary.
     *
     * @return The summary.
     */
    public String getSummary() {
        return metaData.get(SUMMARY);
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
     * Returns the metadata field for the given key.
     *
     * @param key Key of the the metadata to return. This key should be the name of the field in all
     *            capital letters, any spaces should be underscores.
     * @return The metadata field for the given key.
     */
    public String getMetaData(String key) {
        return metaData.get(key);
    }

    public HashMap<String, String> getMetaData() {
        return new HashMap<>(metaData);
    }

    /**
     * Constructor
     *
     * @param builder Builder object defining how to construct the <code>DataSourceMetaData</code>.
     */
    private DataSourceMetaData(DataSourceMetaDataBuilder builder) {
        this.metaData = new HashMap<>(builder.metaData);
    }

    /**
     * Creates a new <code>Builder</code> object to define an <code>DataSourceMetaData</code> object.
     *
     * @return A new <code>Builder</code>.
     */
    public static DataSourceMetaDataBuilder Builder() {
        return new DataSourceMetaDataBuilder();
    }

    /**
     * Embedded class that defines the <code>Builder</code> for <code>DataSourceMetaData</code>.
     */
    public static class DataSourceMetaDataBuilder {
        private HashMap<String, String> metaData;

        /**
         * Constructor
         * This constructor initializes a new hash map.
         */
        public DataSourceMetaDataBuilder() {
            metaData = new HashMap<>();
        }

        /**
         * Constructor
         *
         * @param metaData Hash map of metadata to add to the <code>Builder</code>.
         */
        DataSourceMetaDataBuilder(HashMap<String, String> metaData) {
            this.metaData = new HashMap<>();
            this.metaData.putAll(metaData);
        }

        /**
         * Sets the <code>TITLE</code> key of the hash map.
         *
         * @param title Value to associate <code>TITLE</code> to.
         * @return The modified <code>Builder</code>.
         */
        public DataSourceMetaDataBuilder setTitle(String title) {
            if (title != null)
                this.metaData.put(TITLE, title);
            return this;
        }

        /**
         * Sets the <code>SUMMARY</code> key of the hash map.
         *
         * @param summary Value to associate <code>SUMMARY</code> to.
         * @return The modified <code>Builder</code>.
         */
        public DataSourceMetaDataBuilder setSummary(String summary) {
            if (summary != null)
                this.metaData.put(SUMMARY, summary);
            return this;
        }

        /**
         * Sets the <code>DESCRIPTION</code> key of the hash map.
         *
         * @param description Value to associate <code>DESCRIPTION</code> to.
         * @return The modified <code>Builder</code>.
         */
        public DataSourceMetaDataBuilder setDescription(String description) {
            if (description != null)
                this.metaData.put(DESCRIPTION, description);
            return this;
        }

        /**
         * Puts a custom key and value into the hash map.
         *
         * @param key   Key to add to the hash map.
         * @param value Value to add to the hash map.
         * @return The modified <code>Builder</code>.
         */
        public DataSourceMetaDataBuilder setMetaData(String key, String value) {
            this.metaData.put(key, value);
            return this;
        }

        /**
         * Takes an existing hash map and merges it into the <code>Builder</code>'s hash map.
         *
         * @param metaData Hash map to add to the <code>Builder</code>.
         * @return The modified <code>Builder</code>.
         */
        public DataSourceMetaDataBuilder setMetaData(HashMap<String, String> metaData) {
            for (HashMap.Entry<String, String> entry : metaData.entrySet())
                this.metaData.put(entry.getKey(), entry.getValue());
            return this;
        }

        /**
         * Passes the <code>Builder</code> to the <code>DataSourceMetaData</code> constructor.
         *
         * @return The resulting <code>DataSourceMetaData</code> object.
         */
        public DataSourceMetaData build() {
            return new DataSourceMetaData(this);
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
        if (toCompare instanceof DataSourceMetaData) {
            if (metaData.size() != ((DataSourceMetaData) toCompare).metaData.size()) return false;
            for (Map.Entry<String, String> entry : metaData.entrySet()) {
                if (!((DataSourceMetaData) toCompare).metaData.containsKey(entry.getKey()))
                    return false;
                if (!entry.getValue().equals(((DataSourceMetaData) toCompare).metaData.get(entry.getKey())))
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
