/*
 *  Units of Measurement Demos for Java
 *  Copyright (c) 2015-2020, Werner Keil and others.
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
package tech.uom.demo.systems.si;

import static si.uom.SI.*;
import static si.uom.NonSI.DEGREE_ANGLE;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Angle;
import javax.measure.quantity.Mass;

import tech.units.indriya.quantity.Quantities;

public class SIDemo {
	public static void main(String[] args) {
		Unit<Mass> atomicMassUnit = UNIFIED_ATOMIC_MASS;
		System.out.println(atomicMassUnit + " (" + atomicMassUnit.getName() + "; " + atomicMassUnit.getSymbol() + ")");

		Quantity<Mass> mass = Quantities.getQuantity(10, atomicMassUnit);
		System.out.println(mass);

		Quantity<Mass> massInKg = mass.to(KILOGRAM);
		System.out.println(massInKg);

		System.out.println(WATT_PER_STERADIAN);
		System.out.println(WATT_PER_STERADIAN_PER_SQUARE_METRE);

		Quantity<Angle> angle = Quantities.getQuantity(Math.PI, RADIAN);
		System.out.println(angle.to(DEGREE_ANGLE));

		System.out.println(AVOGADRO_CONSTANT);
	}

}
