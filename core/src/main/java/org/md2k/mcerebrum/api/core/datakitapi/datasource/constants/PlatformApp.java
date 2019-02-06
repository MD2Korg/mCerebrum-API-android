package org.md2k.mcerebrum.api.core.datakitapi.datasource.constants;
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

/**
 * This class defines constants for Platform Application Metadata denoting the type and id.
 * The type denotes what type of sensor (AutoSense, Phone, Omron, EasySense,
 * MotionSense, Beacon and their subtypes). The id denotes the sensor's location.
 */

public final class PlatformApp {
    private PlatformApp() {
    }

    public static class TYPE {
        /**
         * Default is <code>"AUTOSENSE_CHEST"</code>.
         */
        public static final String AUTOSENSE_CHEST = "AUTOSENSE_CHEST";

        /**
         * Default is <code>"AUTOSENSE_BLE"</code>.
         */
        public static final String AUTOSENSE_BLE = "AUTOSENSE_BLE";

        /**
         * Default is <code>"AUTOSENSE_WRIST"</code>.
         */
        public static final String AUTOSENSE_WRIST = "AUTOSENSE_WRIST";

        /**
         * Default is <code>"MICROSOFT_BAND"</code>.
         */
        public static final String MICROSOFT_BAND = "MICROSOFT_BAND";

        /**
         * Default is <code>"PHONE"</code>.
         */
        public static final String PHONE = "PHONE";

        /**
         * Default is <code>"OMRON_BLOOD_PRESSURE"</code>.
         */
        public static final String OMRON_BLOOD_PRESSURE = "OMRON_BLOOD_PRESSURE";

        /**
         * Default is <code>"OMRON_WEIGHT_SCALE"</code>.
         */
        public static final String OMRON_WEIGHT_SCALE = "OMRON_WEIGHT_SCALE";

        /**
         * Default is <code>"EASYSENSE"</code>.
         */
        public static final String EASYSENSE = "EASYSENSE";

        /**
         * Default is <code>"MOTION_SENSE"</code>.
         */
        public static final String MOTION_SENSE = "MOTION_SENSE";
        /**
         * Default is <code>"MOTION_SENSE_HRV"</code>.
         */
        public static final String MOTION_SENSE_HRV = "MOTION_SENSE_HRV";
        /**
         * Default is <code>"MOTION_SENSE_HRV_PLUS"</code>.
         */
        public static final String MOTION_SENSE_HRV_PLUS = "MOTION_SENSE_HRV_PLUS";

        /**
         * Default is <code>"ORALB_BRUSH"</code>.
         */
        public static final String ORALB_BRUSH = "ORALB_BRUSH";


        /**
         * Default is <code>"BEASON"</code>.
         */
        public static final String BEACON = "BEACON";
    }

    public static class ID {
        /**
         * Default is <code>"CHEST"</code>.
         */
        public static final String CHEST = "CHEST";

        /**
         * Default is <code>"LEFT_WRIST"</code>.
         */
        public static final String LEFT_WRIST = "LEFT_WRIST";

        /**
         * Default is <code>"RIGHT_WRIST"</code>.
         */
        public static final String RIGHT_WRIST = "RIGHT_WRIST";

    }

}
