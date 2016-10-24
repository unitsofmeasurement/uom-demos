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
package tec.uom.demo.systems.jscience;

import javax.measure.Measurable;
import javax.measure.Measure;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.unit.NonSI;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

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
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
	@SuppressWarnings("rawtypes")
	Measure length = Measure.valueOf(10, SI.METRE);
	// LengthAmount length = new LengthAmount(10, SI.KILOGRAM);
	// this won't work ;-)

	System.out.println(length);
	Unit<Length> lenUnit = length.getUnit();
	System.out.println(lenUnit);

	System.out.println(length.doubleValue(NonSI.FOOT));
	// System.out.println(length.doubleValue(USCustomary.POUND));
	// this won't work either.
	// UnitConverter footConv = lenUnit.getConverterTo(NonSI.INCH);
	System.out.print(((Measurable<Length>) length).doubleValue(NonSI.INCH));
	System.out.println(" " + NonSI.FOOT);

	Measurable<Mass> mass = Measure.valueOf(1000, SI.GRAM);
	Measurable<Mass> mass2 = Measure.valueOf(1, SI.KILOGRAM);
	System.out.println(mass.equals(mass2));
    }
}