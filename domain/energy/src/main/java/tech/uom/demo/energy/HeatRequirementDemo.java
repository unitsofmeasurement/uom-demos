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
 * 3. Neither the name of JSR-385, Units of Measurement nor the names of their contributors may be used to endorse or promote products derived from this software without specific prior written permission.
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
import static javax.measure.Quantity.Scale.*;

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

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 
 * @author Werner
 * @see <a href="http://www.dagego.de/info_waermebedarf.html">Dageto
 *      Wärmebedarfsermittlung (DE)</a>
 */
public class HeatRequirementDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//setting default locale to German
		Locale.setDefault(new Locale("de", "DE"));
		ResourceBundle resourceBundle = ResourceBundle.getBundle("Labels");

		Quantity<Volume> volume = Quantities.getQuantity(1000, Units.LITRE);
		System.out.println(String.format(resourceBundle.getString("what_work_is_required_to_heat_water"),
				volume));
		Quantity<Temperature> deltaT = Quantities.getQuantity(20, Units.KELVIN, RELATIVE);
		Quantity<Energy> energy = (Quantity<Energy>) volume.multiply(deltaT);
		Quantity<Energy> W = (energy.multiply(4200)).divide(3600);
		final Unit<Energy> wattHour = W.getUnit();
		SimpleUnitFormat.getInstance().label(wattHour, "Wh");
		Quantity<Energy> kwH = W.to(KILO(wattHour));
		SimpleUnitFormat.getInstance().label(KILO(wattHour), "KWh");
		System.out.println(kwH);
		Quantity<Power> kiloWatt = Quantities.getQuantity(9.5, KILO(Units.WATT));
		Quantity<Time> time = (Quantity<Time>) kwH.divide(kiloWatt);
		SimpleUnitFormat.getInstance().label(time.getUnit(), "h");
		System.out.println(String.format(resourceBundle.getString("If_only%_s_are_available,_it_will_take_longer."),
				kiloWatt));
		System.out.println(String.format(resourceBundle.getString("Namely"),time));
	}
}
