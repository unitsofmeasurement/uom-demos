/*
 * Units of Measurement Demos
 * Copyright © 2005-2023, Werner Keil and others.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 *    and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-363, Unit-API nor the names of their contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package tech.uom.demo.retail.types;

import tech.uom.lib.common.function.Coded;

// TODO add remaining ISO parts as per https://www.csiu.co/resources-and-links/iso-container-size-and-type-iso-6346
// TODO try using records in a Java 17+ demo
public class Container implements Coded<String> {
    final ContainerLength length;
    final ContainerHeight height;
    final String type;
    
    public ContainerLength getLength() {
        return length;
    }

    public ContainerHeight getHeight() {
        return height;
    }
   
    public Container(final ContainerLength length, final ContainerHeight height, final String type) {
        super();
        this.length = length;
        this.height = height;
        this.type = type;
    }

    @Override
    public String getCode() {
        final StringBuilder code = new StringBuilder();
        code.append(length.getCode());
        code.append(height.getCode());
        code.append(type);
        return code.toString();
    }
}
