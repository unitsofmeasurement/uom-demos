/*
 *  Unit-API - Units of Measurement API for Java
 *  Copyright (c) 2005-2015, Jean-Marie Dautelle, Werner Keil, V2COM.
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
package tech.uom.demo.energy;

import static tech.uom.demo.energy.DemoUnitSystem.WATTHOUR;

import javax.measure.Quantity;
import javax.measure.quantity.Energy;
import javax.measure.quantity.Power;
import javax.measure.quantity.Time;

import tech.units.indriya.quantity.Quantities;
import javax.measure.MetricPrefix;
import tech.units.indriya.unit.Units;

public class EnergyDemo {

	public static void main(String[] args) {
		//System.out.println(DemoUnitSystem.WATTHOUR);
		Quantity<Power> power = Quantities.getQuantity(1000, MetricPrefix.MILLI(Units.WATT));
		Quantity<Time> time = Quantities.getQuantity(15, Units.MINUTE);
		Quantity<Energy> energy = power.multiply(time).asType(Energy.class);
		System.out.println(energy); //Ouput 15000.00 J/s·min -> correct
		System.out.println(energy.to(Units.JOULE)); //Output 900.00 J -> correct
		System.out.println(energy.to(WATTHOUR)); //Output expected: 0.25 Wh
		System.out.println(energy.to(MetricPrefix.KILO(Units.JOULE))); //Output expected something like 0.90 kJ or 0.90 kNm
		Quantity<Energy> result = energy.to(MetricPrefix.KILO(WATTHOUR));
		System.out.println(result); //Output expected 0.00025 kWh
	}
}
