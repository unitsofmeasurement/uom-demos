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
package tech.uom.demo.systems.ucum;

import static javax.measure.MetricPrefix.KILO;
import static systems.uom.ucum.format.UCUMFormat.Variant.*;
import static systems.uom.ucum.UCUM.*;

import systems.uom.ucum.UCUM;
import systems.uom.ucum.format.UCUMFormat;

import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.unit.Units;

public class UCUMDemo {

    public static void main(String[] args) {
		var atomicMassUnit = ATOMIC_MASS_UNIT;
		System.out.println(atomicMassUnit.getSymbol());

		var mass = Quantities.getQuantity(10, atomicMassUnit);
		System.out.println(mass);

		var massInKg = mass.to(Units.KILOGRAM);
		System.out.println(massInKg);

		final var cs = UCUMFormat.getInstance(CASE_SENSITIVE);
		var unit = cs.parse("m/s");
		System.out.println(unit);

		// unit = format.parse("m^1*s^-1");
		// System.out.println(unit);

		System.out.println(UCUM.PARSEC);
		var print = UCUMFormat.getInstance(PRINT);
		System.out.println(print.format(UCUM.PARSEC));

		var hz = UCUM.HERTZ;
		System.out.println(hz);
		System.out.println(hz.getBaseUnits());
		System.out.println(print.format(UCUM.HERTZ));

		var khz = KILO(hz);
		System.out.println(khz.getBaseUnits());

		unit = cs.parse("Hz");
		System.out.println(unit);
		unit = cs.parse("kHz");
		System.out.println(unit);
		var oneLiter = Quantities.getQuantity(1, LITER);
		System.out.println(oneLiter.to(LITER_DM3).getValue());
    }
}
