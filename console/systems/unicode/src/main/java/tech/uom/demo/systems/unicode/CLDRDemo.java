/*
 *  Units of Measurement Console Demos
 *  Copyright (c) 2005-2020, Werner Keil and others.
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
package tech.uom.demo.systems.unicode;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import systems.uom.quantity.Information;
import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.unit.Units;
import static systems.uom.unicode.CLDR.*;

public class CLDRDemo {
    public static void main(String[] args) {
	Quantity<Mass> carat = Quantities.getQuantity(100, CARAT);
	System.out.println(carat);
	Quantity<Mass> caratsInKg = carat.to(Units.KILOGRAM);
	System.out.println(caratsInKg);

	Quantity<Information> bit = Quantities.getQuantity(20, BIT);
	System.out.println(bit);
	Quantity<Information> bytes = bit.to(BYTE);
	System.out.println(bytes);

	Unit pressure = Units.PASCAL;
	System.out.println(pressure);
	
//	Quantity<InformationRate> bps = Quantities.getQuantity(10, BIT_PER_SECOND);
//	System.out.println(bps);
	
	Quantity<Length> len = Quantities.getQuantity(10, PARSEC);
	System.out.println(len);
    }
}
