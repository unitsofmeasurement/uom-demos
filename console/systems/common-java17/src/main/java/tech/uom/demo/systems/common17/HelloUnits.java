/*
 *  Units of Measurement Console Demos
 *  Copyright (c) 2005-2019, Werner Keil and others.
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
import javax.measure.Unit;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import si.uom.SI;
import systems.uom.common.USCustomary;
import tech.units.indriya.quantity.Quantities;

/**
 * This is a back-port of UOMo HelloUnits to prove similar behavior, especially
 * for Bugzilla item 338334
 * 
 * @author Werner Keil
 */
public class HelloUnits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Quantity<Length> length = Quantities.getQuantity(10, SI.METRE);
		// LengthAmount length = new LengthAmount(10, SI.KILOGRAM);
		// this won't work ;-)

		System.out.println(length);
		Unit<Length> lenUnit = length.getUnit();
		System.out.println(lenUnit);

		System.out.print(length.to(USCustomary.FOOT).getValue());
		System.out.println(" " + USCustomary.FOOT);
		// System.out.println(length.doubleValue(USCustomary.POUND));
		// this won't work either.
		// UnitConverter footConv = lenUnit.getConverterTo(USCustomary.INCH);
		System.out.println(length.to(USCustomary.INCH));

		Quantity<Mass> mass = Quantities.getQuantity(1000, SI.GRAM);
		Quantity<Mass> mass2 = Quantities.getQuantity(1, SI.KILOGRAM);
		System.out.println(mass.equals(mass2));
	}
}