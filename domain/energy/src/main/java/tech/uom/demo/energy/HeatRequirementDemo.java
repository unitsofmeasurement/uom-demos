/*
 *  Units of Measurement Demos for Java
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
package tech.uom.demo.energy;

import static javax.measure.MetricPrefix.KILO;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Energy;
import javax.measure.quantity.Power;
import javax.measure.quantity.Temperature;
import javax.measure.quantity.Time;
import javax.measure.quantity.Volume;

import tech.units.indriya.format.SimpleUnitFormat;
import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.unit.Units;

/**
 * 
 * @author Werner
 * @see <a href="http://www.dagego.de/info_waermebedarf.html">Dageto Wärmebedarfsermittlung (DE)</a>
 */
public class HeatRequirementDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Quantity<Volume> volume = Quantities.getQuantity(1000, Units.LITRE);
		Quantity<Temperature> temperature = Quantities.getQuantity(20, Units.KELVIN);
		Quantity<Energy> energy = (Quantity<Energy>) volume.multiply(temperature);
		Quantity<Energy> result = (energy.multiply(4200)).divide(3600);
//		System.out.println(result);
		final Unit<Energy> wattHour = result.getUnit();
		SimpleUnitFormat.getInstance().label(wattHour, "Wh");
//		System.out.println(result);
		Quantity<Energy> kwH = result.to(KILO(wattHour));
		SimpleUnitFormat.getInstance().label(KILO(wattHour), "KWh");
		System.out.println(kwH);
		Quantity<Power> kiloWatt = Quantities.getQuantity(9.5, KILO(Units.WATT));
		Quantity<Time> time =  (Quantity<Time>) kwH.divide(kiloWatt);
		SimpleUnitFormat.getInstance().label(time.getUnit(), "h");
		System.out.println(time);
	}

}
