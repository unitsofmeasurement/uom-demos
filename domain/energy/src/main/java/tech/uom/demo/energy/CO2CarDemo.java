/*
 *  Units of Measurement Demos for Java
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
import static tech.units.indriya.unit.Units.*;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Volume;

import tech.units.indriya.format.SimpleUnitFormat;
import tech.units.indriya.quantity.Quantities;
import tech.uom.domain.energy.quantity.CarbonFootprint;
import tech.uom.domain.energy.quantity.FuelConsumption;
import tech.uom.lib.common.function.DoubleFactorSupplier;

/**
 * Carbon Footprint calculator for cars
 * @author Werner
 * @see <a href="https://spritrechner.biz/co2-rechner-fuer-autos.html">CO2-Rechner für Autos (DE)</a>
 * @version 1.6
 */
public class CO2CarDemo {
	
	public static void main(String[] args) {
		if (args == null || args.length < 4) {
			usage();
		} else {
			System.out.println(String.format("Car: %s", args[0]));
			FuelType fuelType = FuelType.valueOf(args[1]);
			Quantity<Length> km100 = Quantities.getQuantity(100, KILO(METRE));
			Quantity<Volume> fuel = Quantities.getQuantity(Double.valueOf(args[2]), LITRE);
			Quantity<FuelConsumption> fuelConsumption = fuel.divide(km100).multiply(100).asType(FuelConsumption.class);
			SimpleUnitFormat.getInstance().label(fuelConsumption.getUnit(), "l/100 km");
			System.out.println(fuelConsumption);
			Quantity<CarbonFootprint> carbon100 = fuelConsumption.multiply(fuelType.getFactor()).asType(CarbonFootprint.class);
			SimpleUnitFormat.getInstance().label(carbon100.getUnit(), "g CO2/km");
			System.out.println(carbon100);
			Quantity<Length> distance = Quantities.getQuantity(Double.valueOf(args[3]), KILO(METRE));
			System.out.println(distance);
			Quantity<?> carbonTotal = carbon100.multiply(distance);
			Quantity<Mass> carbonGrams = Quantities.getQuantity(carbonTotal.getValue(), GRAM);
			System.out.println(carbonGrams.to(KILOGRAM));
		}
	}
	
	private static void usage() {
		System.out.println("Usage: CO2CarDemo <Car> <FuelType> (PETROL/DIESEL) <Consumption per 100 km> <Distance in km>");
	}

	enum FuelType implements DoubleFactorSupplier {
		PETROL(23.8), DIESEL(26.5);

		private final double factor;
		
		private FuelType(double factor) {
			this.factor = factor;
		}
		
		@Override
		public double getFactor() {
			return factor;
		}
	}
}
