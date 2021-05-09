/*
 *  Units of Measurement Demos for Java
 *  Copyright (c) 2005-2021, Werner Keil and others.
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
 * 3. Neither the name of JSR-385, Units of Measurement nor the names of their contributors may be used to endorse or promote products
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
package tech.uom.demo.java16;

import static javax.measure.MetricPrefix.CENTI;
import static tech.units.indriya.unit.Units.KILOGRAM;
import static tech.units.indriya.unit.Units.METRE;

import tech.units.indriya.function.AbstractConverter;
import tech.units.indriya.function.AddConverter;
import tech.units.indriya.function.MultiplyConverter;
import tech.units.indriya.function.RationalNumber;
import tech.units.indriya.quantity.Quantities;

public class UnitConverterDemo {
    public static void main(String[] args) {
		var sourceUnit = METRE;
		var targetUnit = CENTI(METRE);
		var converter = sourceUnit.getConverterTo(targetUnit);
		double length1 = 4.0;
		double length2 = 6.0;
		double result1 = converter.convert(length1);
		double result2 = converter.convert(length2);
		System.out.println(result1);
		System.out.println(result2);
		var quantLength1 = Quantities.getQuantity(4.0, sourceUnit);
		var quantLength2 = Quantities.getQuantity(6.0, targetUnit);
		var quantResult1 = quantLength1.to(targetUnit);
		System.out.println(quantResult1);
		
		double mass1 = 5.0;
		double result3 = converter.convert(mass1); // does compile
		System.out.println(result3);
		var quantMass1 = Quantities.getQuantity(5.0, KILOGRAM);
		
        final AbstractConverter fahrenheitToKelvin = (AbstractConverter) 
                new AddConverter(RationalNumber.of(27315, 100))
                .concatenate(MultiplyConverter.ofRational(5, 9))
                .concatenate(new AddConverter(-32));
        System.out.println(fahrenheitToKelvin.linearFactor());
    }
}
