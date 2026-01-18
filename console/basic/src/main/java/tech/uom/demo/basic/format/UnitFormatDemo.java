/*
 *  Unit-API - Units of Measurement API for Java
 *  Copyright (c) 2005-2016, Jean-Marie Dautelle, Werner Keil, V2COM.
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
package tech.uom.demo.basic.format;

import static tech.units.indriya.unit.Units.LITRE;

import java.text.DecimalFormat;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.format.QuantityFormat;
import javax.measure.format.UnitFormat;
import javax.measure.quantity.Volume;
import javax.measure.spi.ServiceProvider;

import tech.units.indriya.AbstractUnit;
import tech.units.indriya.format.EBNFUnitFormat;
import tech.units.indriya.format.NumberDelimiterQuantityFormat;
import tech.units.indriya.format.SimpleUnitFormat;
import tech.units.indriya.quantity.Quantities;

public class UnitFormatDemo {

	public static void main(String[] args) {
		
//		UnitFormat localFormat = LocalUnitFormat.getInstance();
		
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
		
		UnitFormat format = ServiceProvider.current().getFormatService().getUnitFormat();
		
//		Unit u = ServiceProvider.current().getUnitFormatService().getUnitFormat().parse("1/l");
		Unit u = ServiceProvider.current().getFormatService().getUnitFormat().parse("g/l");
		System.out.println(u);
		
//		Unit u1 = format.parse("m*");
//		System.out.println(u1);
		
//		Unit u2 = EBNFUnitFormat.getInstance().parse("m-");
//		System.out.println(u2);
//		
//		Unit u3 = LocalUnitFormat.getInstance().parse("m");
//		System.out.println(u3);
		NumberDelimiterQuantityFormat ndqf = NumberDelimiterQuantityFormat.getInstance();
		
		Quantity<Volume> l6 = Quantities.getQuantity(6, LITRE);
		Quantity<Volume> l3 = l6.divide(2);
		System.out.println(ndqf.format(l3));
		
		QuantityFormat ndqf2 = NumberDelimiterQuantityFormat.builder().
				setNumberFormat(new DecimalFormat("00.000")).
				setUnitFormat(SimpleUnitFormat.getInstance()).
				build();
		System.out.println(ndqf2.format(l3));
		
		Unit u4 = SimpleUnitFormat.getInstance().parse("invalid");
		System.out.println(u4);
	}

}
