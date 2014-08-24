/**
 *  Unit-API - Units of Measurement API for Java
 *  Copyright 2010-2014, Jean-Marie Dautelle, Werner Keil, V2COM and individual
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

import static tec.uom.ri.util.SI.*;
import static tec.uom.ri.util.US.*;

import javax.measure.Measurement;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import tec.uom.ri.AbstractMeasurement;
import tec.uom.ri.AbstractQuantity;
import tec.uom.ri.util.SI;
import tec.uom.ri.util.US;

/**
 * @author Werner Keil
 *
 */
public class UnitDemo {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		AbstractQuantity<Length> l = AbstractQuantity.of(100d, METRE);
		System.out.println(l);
		l = AbstractQuantity.of(74L, FOOT);
		System.out.println(l);
		l = l.to(METRE);
		System.out.println(l);
		AbstractMeasurement<Area, Number> a = (AbstractMeasurement<Area, Number>) AbstractMeasurement
				.of(10, US.HECTARE);
		System.out.println(a);
		Measurement<Area, Number> na = a.to(SQUARE_FOOT);
		AbstractQuantity<Mass> m = AbstractQuantity.of(12, SI.KILOGRAM);
		System.out.println(m);
	}

}
