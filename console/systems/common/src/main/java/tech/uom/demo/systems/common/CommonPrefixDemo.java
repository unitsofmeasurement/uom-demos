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
package tech.uom.demo.systems.common;

import static javax.measure.MetricPrefix.KILO;
import static javax.measure.MetricPrefix.NANO;
import static systems.uom.common.USCustomary.LITER;

import javax.measure.Quantity;
import javax.measure.format.UnitFormat;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Volume;

import systems.uom.common.IndianPrefix;
import tech.units.indriya.format.SimpleUnitFormat;
import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.unit.Units;

public class CommonPrefixDemo {
	public static void main(String... args) {
		Quantity<Length> len = Quantities.getQuantity(10, IndianPrefix.LAKH(Units.METRE));
		System.out.println(len);
		Quantity<Mass> kg = Quantities.getQuantity(50, KILO(Units.GRAM));
		System.out.println(kg);
		
		System.out.println(Quantities.getQuantity(3.3, LITER).toString());
		Quantity<Volume> nl = Quantities.getQuantity(3.3, NANO(LITER));
		System.out.println(nl.toString());
		//UnitFormat format = EBNFUnitFormat.getInstance();
		UnitFormat format = SimpleUnitFormat.getInstance();
		System.out.println(format.format(nl.getUnit()));
	}
}
