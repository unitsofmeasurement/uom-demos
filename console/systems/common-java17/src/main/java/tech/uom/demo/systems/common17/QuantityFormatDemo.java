/*
 *  Units of Measurement Demos for Java
 *  Copyright (c) 2005-2024, Werner Keil and others.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-385, Units of Measurement nor the names of their contributors may be used to endorse or promote products derived from this software without specific prior written permission.
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
package tech.uom.demo.systems.common17;

import javax.measure.Quantity;
import javax.measure.spi.ServiceProvider;

import systems.uom.common.USCustomary;
import tech.units.indriya.format.EBNFUnitFormat;
import tech.units.indriya.format.SimpleUnitFormat;

public class QuantityFormatDemo {

	public static void main(String[] args) {
        SimpleUnitFormat.getInstance().alias(USCustomary.MILE, "mile");
        EBNFUnitFormat.getInstance().label(USCustomary.MILE, "mi");
        EBNFUnitFormat.getInstance().alias(USCustomary.MILE, "mile");
        // TODO this should go into Systems Common and similar libraries
        
        Quantity<?> q1 = ServiceProvider.current().getFormatService().getQuantityFormat().parse("3 km");
        Quantity<?> q2 = ServiceProvider.current().getFormatService().getQuantityFormat().parse("3 mi");
        Quantity<?> q3 = ServiceProvider.current().getFormatService().getQuantityFormat().parse("3 mile");
        //Quantity<?> q4 = ServiceProvider.current().getFormatService().getQuantityFormat().parse("3 2/km"); // Exception in SimpleUnitFormat
        Quantity<?> q5 = ServiceProvider.current().getFormatService().getQuantityFormat("EBNF").parse("3 1/km");
        Quantity<?> q6 = ServiceProvider.current().getFormatService().getQuantityFormat("EBNF").parse("3 1/mi");
        System.out.println(q6);
        Quantity<?> q7 = ServiceProvider.current().getFormatService().getQuantityFormat("EBNF").parse("3 1/mile");
        System.out.println(q7);
        Quantity<?> q8 = ServiceProvider.current().getFormatService().getQuantityFormat("EBNF").parse("3 mile");
        System.out.println(q8);
	}

}