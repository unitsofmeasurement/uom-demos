/**
 *  Unit-API - Units of Measurement API for Java
 *  Copyright 2013-2014, Jean-Marie Dautelle, Werner Keil, V2COM and individual
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

import javax.measure.Quantity;
import javax.measure.quantity.Area;
import javax.measure.quantity.Energy;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import tec.units.ri.quantity.Quantities;

/**
 * This is a simple BMI (Body Mass Index) calculator
 * @version 0.2
 * @author Werner
 *
 */
public class BMIDemo {

	public static void main(String[] args) {
		Quantity<Length> height = Quantities.getQuantity(1.87d, METRE);
		Quantity<Mass> mass = Quantities.getQuantity(85d, KILOGRAM);
		
		Quantity<Area> squareHeight = height.multiply(height);
		Quantity<?> bmi = mass.divide(squareHeight);
		//Energy e = (Energy) mass.divide(squareHeight);
		System.out.println(bmi);
	}

}
