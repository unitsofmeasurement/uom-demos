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
package org.unitsofmeasurement.demo;

import static org.unitsofmeasurement.impl.system.SI.*;

import javax.measure.quantity.Length;

import org.unitsofmeasurement.impl.AbstractMeasurement;

/**
 * @author Werner Keil
 *
 */
public class UnitDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractMeasurement<Length> l = AbstractMeasurement.of(100d, METRE);
		System.out.println(l);
//		AbstractMeasurement<Area> a = AbstractMeasurement.of(10, HECTAR);
//		System.out.println(a);
	}

}
