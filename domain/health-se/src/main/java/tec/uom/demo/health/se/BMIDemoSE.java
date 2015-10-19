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
package tec.uom.demo.health.se;

import static tec.uom.se.unit.Units.KILOGRAM;
import static tec.uom.se.unit.Units.SQUARE_METRE;
import static tec.uom.se.unit.Units.METRE;

import javax.measure.Quantity;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import tec.uom.domain.health.se.util.BMIRange;
import tec.uom.se.quantity.Quantities;

/**
 * This is a simple BMI (Body Mass Index) calculator
 * @version 0.7
 * @author Werner
 *
 */
public class BMIDemoSE {
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
		if(args.length > 0) {
			dHeight = Double.parseDouble(args[0]);
			dWeight = Double.parseDouble(args[1]);
		} else {
			dHeight = 1.85d;
			dWeight = 85d;
		}

		Quantity<Length> height = Quantities.getQuantity(dHeight, METRE);
		Quantity<Mass> mass = Quantities.getQuantity(dWeight, KILOGRAM);
		
		Quantity<Area> squareHeight = height.multiply(height).asType(Area.class);
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
