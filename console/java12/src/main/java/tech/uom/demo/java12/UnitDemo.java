/*
 * Units of Measurement Demos Java
 * Copyright (c) 2005-2018, Jean-Marie Dautelle, Werner Keil and others.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-385, Unit-API nor the names of their contributors may be used to endorse or promote products derived from this software without specific prior written permission.
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
package tech.uom.demo.java12;

import static javax.measure.MetricPrefix.NANO;
import static tech.units.indriya.unit.Units.LITRE;

import javax.measure.quantity.Speed;

import tech.units.indriya.quantity.Quantities;
import javax.measure.MetricPrefix;
import tech.units.indriya.unit.Units;

public class UnitDemo {

	public static void main(String[] args) {
		var kmh = MetricPrefix.KILO(Units.METRE).divide(Units.HOUR).asType(Speed.class);
		var kmh3 = MetricPrefix.KILO(Units.METRE).multiply(Units.HOUR);
		
		System.out.println(kmh);
		System.out.println(kmh3);
				
		System.out.println(Units.KILOGRAM);
		System.out.println(Units.KILOGRAM.getSymbol());
		System.out.println(Units.KILOGRAM.getName());
		
		System.out.println(Units.GRAM);
		System.out.println(Units.GRAM.getSymbol());
		System.out.println(Units.GRAM.getName());
		
//		Unit<Dimensionless> d = Units.METRE.asType(Dimensionless.class);
//		System.out.println(d);
		var l33 = Quantities.getQuantity(3.3, LITRE);
		System.out.println(l33.toString());
		var nl33 = Quantities.getQuantity(3.3, NANO(LITRE)).toString();
		System.out.println(nl33);
		var l33div = l33.divide(2);
		System.out.println(l33div);
	}

}
