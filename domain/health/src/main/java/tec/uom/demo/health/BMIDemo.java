/**
 *  Unit-API - Units of Measurement API for Java
 *  Copyright 2013-2015, Jean-Marie Dautelle, Werner Keil, V2COM and individual
 *  contributors by the @author tag.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package tec.uom.demo.health;

import static tec.units.ri.util.SI.METRE;
import static tec.units.ri.util.SI.KILOGRAM;
import static tec.units.ri.util.SI.SQUARE_METRE;

import javax.measure.Quantity;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import tec.units.ri.quantity.Quantities;

/**
 * This is a simple BMI (Body Mass Index) calculator
 * 
 * @version 0.3
 * @author Werner
 *
 */
public class BMIDemo {
	private static final BMIRange VERY_SEVERELY_UNDERWEIGHT_BMI = BMIRange.of(
			Quantities.getQuantity(30, SQUARE_METRE).divide(
					Quantities.getQuantity(2, KILOGRAM)), null);
	private static final BMIRange SEVERELY_UNDERWEIGHT_BMI = BMIRange.of(
			Quantities.getQuantity(30, SQUARE_METRE).divide(
					Quantities.getQuantity(2, KILOGRAM)),
			Quantities.getQuantity(32, SQUARE_METRE).divide(
					Quantities.getQuantity(2, KILOGRAM)));
	private static final BMIRange NORMAL_BMI = BMIRange.of(
			Quantities.getQuantity(18.5, SQUARE_METRE).divide(
					Quantities.getQuantity(1, KILOGRAM)),
			Quantities.getQuantity(25, SQUARE_METRE).divide(
					Quantities.getQuantity(1, KILOGRAM)));
	private static final BMIRange OVERWEIGHT_BMI = BMIRange.of(
			Quantities.getQuantity(25, SQUARE_METRE).divide(
					Quantities.getQuantity(1, KILOGRAM)),
			Quantities.getQuantity(60, SQUARE_METRE).divide(
					Quantities.getQuantity(2, KILOGRAM)));

	public static void main(String[] args) {
		Double dHeight;
		Double dWeight;
		if (args.length > 0) {
			dHeight = Double.parseDouble(args[0]);
			dWeight = Double.parseDouble(args[1]);
		} else {
			dHeight = 1.85d;
			dWeight = 85d;
		}

		Quantity<Length> height = Quantities.getQuantity(dHeight, METRE);
		// Quantity<Length> heightUS = Quantities.getQuantity(dHeight, FOOT); //
		// for US measure units, just add a single line, see below:-)
		// Quantity<Length> height = heightUS.to(METRE);
		Quantity<Mass> mass = Quantities.getQuantity(dWeight, KILOGRAM);

		// Quantity<Area> squareHeight =
		// height.multiply(dHeight).asType(Area.class); // this would fail, as
		// Double value results in Length, not Area
		Quantity<Area> squareHeight = height.multiply(height)
				.asType(Area.class);
		Quantity<?> bmi = mass.divide(squareHeight);
		System.out.println(bmi);
		printCategory(bmi);
	}

	private static final void printCategory(final Quantity<?> bmi) {
		if (bmi.getValue().doubleValue() <= VERY_SEVERELY_UNDERWEIGHT_BMI
				.getMinimum().getValue().doubleValue()) {
			System.out.println(VERY_SEVERELY_UNDERWEIGHT_BMI.getCategory());
		}
		if (bmi.getValue().doubleValue() >= SEVERELY_UNDERWEIGHT_BMI
				.getMinimum().getValue().doubleValue()
				&& bmi.getValue().doubleValue() <= SEVERELY_UNDERWEIGHT_BMI
						.getMaximum().getValue().doubleValue()) {
			System.out.println(SEVERELY_UNDERWEIGHT_BMI.getCategory());
		}
		if (bmi.getValue().doubleValue() >= NORMAL_BMI.getMinimum().getValue()
				.doubleValue()
				&& bmi.getValue().doubleValue() <= NORMAL_BMI.getMaximum()
						.getValue().doubleValue()) {
			System.out.println(NORMAL_BMI.getCategory());
		}
		if (bmi.getValue().doubleValue() >= OVERWEIGHT_BMI.getMinimum()
				.getValue().doubleValue()
				&& bmi.getValue().doubleValue() <= OVERWEIGHT_BMI.getMaximum()
						.getValue().doubleValue()) {
			System.out.println(OVERWEIGHT_BMI.getCategory());
		}

	}
}
