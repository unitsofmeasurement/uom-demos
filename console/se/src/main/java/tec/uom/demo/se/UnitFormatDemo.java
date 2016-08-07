/*
 *  Unit-API - Units of Measurement API for Java
 *  Copyright (c) 2005-2015, Jean-Marie Dautelle, Werner Keil, V2COM.
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
 * 3. Neither the name of JSR-363, Unit-API nor the names of its contributors may be used to endorse or promote products
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
package tec.uom.demo.se;

import static tec.uom.se.unit.MetricPrefix.KILO;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.measure.Unit;
import javax.measure.format.UnitFormat;
import javax.measure.quantity.Speed;

import tec.uom.se.AbstractUnit;
import tec.uom.se.format.LocalUnitFormat;
import tec.uom.se.format.SimpleUnitFormat;
import tec.uom.se.unit.Units;

public class UnitFormatDemo {

	public static void main(String[] args) {
		
		UnitFormat localFormat = LocalUnitFormat.getInstance();
		
//		Unit<Speed> kmh = KILO(Units.METRE).divide(Units.HOUR).asType(Speed.class);
//		Unit<Speed> kmh2 = SIPrefix.KILO(Units.METRE).multiply(UCUM.HOUR).asType(Speed.class);
		
		Unit<?> parsed = AbstractUnit.parse("%");
//		Unit<?> parsed = localFormat.parse("%");
		System.out.println(parsed);
		
//		SimpleUnitFormat.getInstance(SimpleUnitFormat.Flavor.ASCII).label(Units.LUX, "l²");
		
//		DecimalFormat df = new DecimalFormat();
//		System.out.println(df.toPattern());
		
		parsed = AbstractUnit.parse("W");
		System.out.println(parsed);
		
		localFormat = LocalUnitFormat.getInstance(Locale.ENGLISH);
		String output = localFormat.format(Units.LITRE);
		System.out.println(output);
		
		localFormat = LocalUnitFormat.getInstance(Locale.JAPANESE);
		output = localFormat.format(Units.METRE);
		System.out.println(output);
	}

}
