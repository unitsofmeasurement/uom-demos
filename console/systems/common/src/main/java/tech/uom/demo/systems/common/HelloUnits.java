/*
 *  Units of Measurement Demos for Java
 *  Copyright (c) 2005-2016, Jean-Marie Dautelle, Werner Keil, V2COM.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-363, Unit-API nor the names of their contributors may be used to endorse or promote products derived from this software without specific prior written permission.
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

import java.time.Duration;
import java.time.Period;
import java.time.temporal.TemporalUnit;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Time;

import si.uom.SI;
import systems.uom.common.USCustomary;
import tech.units.indriya.AbstractQuantity;
import tech.units.indriya.quantity.NumberQuantity;
import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.quantity.time.TimeQuantities;

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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Quantity<Length> length = Quantities.getQuantity(10, SI.METRE);
		// LengthAmount length = new LengthAmount(10, SI.KILOGRAM);
		// this won't work ;-)

		System.out.println(length);
		Unit<Length> lenUnit = length.getUnit();
		System.out.println(lenUnit);

		//System.out.println(((AbstractQuantity) length).doubleValue(USCustomary.FOOT));
		// System.out.println(length.doubleValue(USCustomary.POUND));
		// this won't work either.
		// UnitConverter footConv = lenUnit.getConverterTo(USCustomary.INCH);
		//System.out.print(((AbstractQuantity<Length>) length).doubleValue(USCustomary.INCH));
		System.out.println(" " + USCustomary.FOOT);

		Quantity<Mass> mass = Quantities.getQuantity(1000, SI.GRAM);
		Quantity<Mass> mass2 = Quantities.getQuantity(1, SI.KILOGRAM);
		System.out.println(mass.equals(mass2));
		
		Period p1 = Period.parse("P1Y2M3D");
		System.out.println(p1);
		//Period p2 = Period.parse("P2M3D1Y"); fails
		Duration d1 = Duration.parse("P2DT3H4M");
		System.out.println(d1);
		//Duration d2 = Duration.parse("P4M2DT3H");
		for (TemporalUnit tu : p1.getUnits()) {
			Quantity<Time> timeQuantity = TimeQuantities.getQuantity(Long.valueOf(p1.get(tu)).longValue(), tu);
			System.out.println(timeQuantity);
		}
	}
}