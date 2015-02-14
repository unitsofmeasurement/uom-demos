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
package tec.uom.demo;

import static tec.units.ri.spi.SI.*;
import static tec.units.ri.spi.SIPrefix.*;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.UnitConverter;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import tec.units.ri.quantity.Quantities;

public class UnitConverterDemo {

	public static void main(String[] args) {
		Unit<Length> sourceUnit = METRE;
		Unit<Length> targetUnit = CENTI(METRE);
		UnitConverter converter = sourceUnit.getConverterTo(targetUnit);
		double length1 = 4.0;
		double length2 = 6.0;
		double result1 = converter.convert(length1);
		double result2 = converter.convert(length2);
		System.out.println(result1);
		System.out.println(result2);
		Quantity<Length> quantLength1 = Quantities.getQuantity(4.0, sourceUnit);
		Quantity<Length> quantLength2 = Quantities.getQuantity(6.0, targetUnit);
		Quantity<Length> quantResult1 = quantLength1.to(targetUnit);
		System.out.println(quantResult1);
		
		double mass1 = 5.0;
		double result3 = converter.convert(mass1); // does compile
		System.out.println(result3);
		Quantity<Mass> quantMass1 = Quantities.getQuantity(5.0, KILOGRAM);
		//quantMass1.to(targetUnit); // won't compile
 	}
}
