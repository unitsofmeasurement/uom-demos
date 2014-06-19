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
package org.unitsofmeasurement.demo.types;

import static org.junit.Assert.assertEquals;

import javax.measure.Unit;
import javax.measure.quantity.Acceleration;
import javax.measure.quantity.Force;

import org.junit.Test;
import org.unitsofmeasurement.ri.quantity.AccelerationAmount;
import org.unitsofmeasurement.ri.quantity.ForceAmount;
import org.unitsofmeasurement.ri.quantity.MassAmount;
import org.unitsofmeasurement.ri.util.SI;
import org.unitsofmeasurement.ri.util.US;

/**
 * 
 * @author Chris Senior
 * @author Werner Keil
 *
 */
public class NewtonsSecondLawTest {

//	@Test
//	public void testCalculateForce() {
//		MassAmount m = new MassAmount(1000, SI.KILOGRAM);
//		AccelerationAmount a = new AccelerationAmount(2.5, SI.METRES_PER_SQUARE_SECOND);
//		ForceAmount force = NewtonsSecondLaw.calculateForce(m, a);
//	    System.out.println("ForceAmountL= " + force.longValue(SI.NEWTON));
//		assertEquals(2500, force.doubleValue(SI.NEWTON), 0.0001);
//	}
	
	// TODO change System.out.println to OutputHelper.println
	
	@Test
	public void testCalculateForce() {
		MassAmount m = new MassAmount(1000, SI.GRAM);
		AccelerationAmount a = new AccelerationAmount(2.5, SI.METRES_PER_SQUARE_SECOND);
		ForceAmount force = NewtonsSecondLaw.calculateForce(m, a);
		System.out.println("ForceAmount = " + force.doubleValue(SI.NEWTON));
		assertEquals(2.5, force.doubleValue(SI.NEWTON), 0.0001);
	}
	
	@Test
	public void testCalculateForceKg() {
		MassAmount m = new MassAmount(1, SI.KILOGRAM);
		AccelerationAmount a = new AccelerationAmount(2.5, SI.METRES_PER_SQUARE_SECOND);
		ForceAmount force = NewtonsSecondLaw.calculateForce(m, a);
		System.out.println("ForceAmount = " + force.doubleValue(SI.NEWTON));
		assertEquals(2.5, force.doubleValue(SI.NEWTON), 0.0001);
	}
	
	@Test
	public void testWithOddUnits() {
		MassAmount m = new MassAmount(100, US.POUND);
		@SuppressWarnings("unchecked") // we know this creates an acceleration!
		Unit<Acceleration> inch_per_square_second = (Unit<Acceleration>)US.INCH.divide(SI.SECOND).divide(SI.SECOND);
		System.out.println(inch_per_square_second);
		AccelerationAmount a = new AccelerationAmount(100, inch_per_square_second);
		ForceAmount force = NewtonsSecondLaw.calculateForce(m, a);
		assertEquals(867961.6621451874, force.doubleValue(SI.NEWTON), 0.0000000001);
		// Pound-force (http://en.wikipedia.org/wiki/Pound-force) is a unit for Force in English engineering units and British gravitational units 
		Unit<Force> poundForce = SI.NEWTON.multiply(4.448222);
		assertEquals(3860886.16071079, force.doubleValue(poundForce), 0.0000000001);				
	}
	
}
