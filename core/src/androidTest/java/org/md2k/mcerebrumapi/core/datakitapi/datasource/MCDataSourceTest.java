package org.md2k.mcerebrumapi.core.datakitapi.datasource;

import org.junit.Test;
import org.md2k.mcerebrumapi.core.data.MCDataType;
import org.md2k.mcerebrumapi.core.data.MCSampleType;
import org.md2k.mcerebrumapi.core.datakitapi.datasource.metadata.MCDataDescriptor;
import org.md2k.mcerebrumapi.core.datakitapi.datasource.metadata.MCDataSourceMetaData;
import org.md2k.mcerebrumapi.core.datakitapi.datasource.unit.MCUnit;

import static org.junit.Assert.assertEquals;

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
public class MCDataSourceTest {
    @Test
    public void createDataSourceForObject() {
        MCDataSourceRegister req = MCDataSource.registerBuilder().setDataType(MCDataType.POINT).setSampleTypeAsObject().setDataDescriptor(MCDataDescriptor.builder("PrivacyList").build()).setDataSourceType("PRIVACY").build();
        assertEquals(req.getDataType(), MCDataType.POINT);
        assertEquals(req.getSampleType(), MCSampleType.OBJECT);
        assertEquals(req.getDataDescriptors().get(0).getName(), "PrivacyList");
        assertEquals(req.getDataSourceType(), "PRIVACY");
    }
    @Test
    public void createDataSourceForIntArray() {
        MCDataSourceRegister req = MCDataSource.registerBuilder().setDataType(MCDataType.POINT).setSampleTypeAsIntArray(3)
                .setDataDescriptor(0, MCDataDescriptor.builder("X").build())
                .setDataDescriptor(1, MCDataDescriptor.builder("Y").build())
                .setDataDescriptor(2, MCDataDescriptor.builder("Z").build())
                .setDataSourceType("A")
                .setDataSourceMetaData(MCDataSourceMetaData.builder().setUnit(MCUnit.METER_PER_SECOND_SQUARED).build())
                .build();
        assertEquals(req.getDataType(), MCDataType.POINT);
        assertEquals(req.getSampleType(), MCSampleType.INT_ARRAY);
        assertEquals(req.getDataDescriptors().get(0).getName(), "X");
        assertEquals(req.getDataDescriptors().get(1).getName(), "Y");
        assertEquals(req.getDataDescriptors().get(2).getName(), "Z");
        assertEquals(req.getDataSourceMetaData().getUnit(), MCUnit.METER_PER_SECOND_SQUARED.name());
        assertEquals(req.getDataSourceType(), "A");
    }

}
