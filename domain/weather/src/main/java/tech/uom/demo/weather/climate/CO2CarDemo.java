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
package tech.uom.demo.weather.climate;

import static javax.measure.MetricPrefix.KILO;
import static tech.units.indriya.unit.Units.*;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import tech.units.indriya.format.SimpleUnitFormat;
import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.unit.Units;
import tech.uom.domain.energy.quantity.FuelConsumption;
import tech.uom.lib.common.function.DoubleFactorSupplier;

/**
 * Carbon Footprint calculator for cars
 * @author Werner Keil
 * @author Andi Huber
 * @see <a href="https://spritrechner.biz/co2-rechner-fuer-autos.html">CO2-Rechner für Autos (DE)</a>
 * @version 1.9
 */
public class CO2CarDemo {
	
	public static void main(String[] args) {
		if (args == null || args.length < 4) {
			usage();
		} else {
		    
	        // definitions
	        final Unit<Length> UNIT_100_KM = KILO(METRE).multiply(100);

	        final Unit<FuelConsumption> UNIT_LITRE_PER_100KM = LITRE.divide(UNIT_100_KM)
	                .asType(FuelConsumption.class);
	        SimpleUnitFormat.getInstance().label(UNIT_LITRE_PER_100KM, "l/100 km"); //$NON-NLS-1$
	        
	        final Unit<SpecificCarbonEmission> UNIT_GRAM_CO2_PER_LITRE = Units.GRAM.divide(LITRE)
                    .asType(SpecificCarbonEmission.class);
	        SimpleUnitFormat.getInstance().label(UNIT_GRAM_CO2_PER_LITRE, Messages.getString("CO2CarDemo.0")); //$NON-NLS-1$
	        
	        // given
	        print(Messages.getString("CO2CarDemo.2"), args[0]); //$NON-NLS-1$
	        FuelType fuelType = FuelType.valueOf(args[1]);
	        
	        Quantity<FuelConsumption> fuelConsumption = Quantities.getQuantity(Double.valueOf(args[2]), UNIT_LITRE_PER_100KM);
	        print(Messages.getString("CO2CarDemo.3"), fuelConsumption); //$NON-NLS-1$
	        
	        Quantity<Length> distance = Quantities.getQuantity(Double.valueOf(args[3]), KILO(METRE));
	        print(Messages.getString("CO2CarDemo.4"), distance); //$NON-NLS-1$
	        
	        Quantity<SpecificCarbonEmission> specificCarbonEmission = 
	                Quantities.getQuantity(fuelType.getFactor(), UNIT_GRAM_CO2_PER_LITRE);
	        print(Messages.getString("CO2CarDemo.5"), 
	        		Messages.getString("CO2CarDemo." + fuelType.name(), true), 
	        		specificCarbonEmission); //$NON-NLS-1$ //$NON-NLS-2$
	        
	        Quantity<Mass> carbonEmissionTotal = specificCarbonEmission
	                .multiply(distance)
	                .multiply(fuelConsumption)
	                .asType(Mass.class);
	        print(Messages.getString("CO2CarDemo.6"), carbonEmissionTotal.to(KILOGRAM)); //$NON-NLS-1$
		}
	}
    
	private static interface SpecificCarbonEmission extends Quantity<SpecificCarbonEmission> {
    }

    private static void print(String format, Object ...args) {
        System.out.println(String.format(format, args));
    }
		
	private static void usage() {
		System.out.println(Messages.getString("CO2CarDemo.7")); //$NON-NLS-1$
	}

	enum FuelType implements DoubleFactorSupplier {
	    PETROL(2392), DIESEL(2640); // gram CO2 per liter of fuel
	    
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
