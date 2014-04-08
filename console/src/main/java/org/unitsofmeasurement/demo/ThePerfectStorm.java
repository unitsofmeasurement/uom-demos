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

import static org.unitsofmeasurement.ri.util.CommonUnits.KILOMETRES_PER_HOUR;
import static org.unitsofmeasurement.ri.util.SI.METRE;
import static org.unitsofmeasurement.ri.util.SIPrefix.*;
import static org.unitsofmeasurement.ri.util.US.MILES_PER_HOUR;
import static org.unitsofmeasurement.demo.types.SaffirSimpsonHurricaneWindScale.Category.*;

import javax.measure.quantity.Length;
import javax.measure.quantity.Time;
import javax.measure.quantity.Speed;

import org.unitsofmeasurement.demo.types.SaffirSimpsonHurricaneWindScale;
import org.unitsofmeasurement.ri.AbstractQuantity;

/**
 * @author Werner Keil
 * @version 0.7
 * @see {@link SaffirSimpsonHurricaneWindScale}
 */
public class ThePerfectStorm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final SaffirSimpsonHurricaneWindScale std = SaffirSimpsonHurricaneWindScale.of(
				null, AbstractQuantity.of(38, MILES_PER_HOUR), TROPICAL_DEPRESSION);
		System.out.println(std);
		
		final SaffirSimpsonHurricaneWindScale sts = SaffirSimpsonHurricaneWindScale.of(
				AbstractQuantity.of(39, MILES_PER_HOUR),
				AbstractQuantity.of(73, MILES_PER_HOUR), TROPICAL_STORM);
		System.out.println(sts);
		
		final SaffirSimpsonHurricaneWindScale s1 = SaffirSimpsonHurricaneWindScale.of(
				AbstractQuantity.of(74, MILES_PER_HOUR),
				AbstractQuantity.of(95, MILES_PER_HOUR), ONE);
		System.out.println(s1);
		
		final SaffirSimpsonHurricaneWindScale s2 = SaffirSimpsonHurricaneWindScale.of(
				AbstractQuantity.of(96, MILES_PER_HOUR),
				AbstractQuantity.of(110, MILES_PER_HOUR), TWO);
		System.out.println(s2);
		
		final SaffirSimpsonHurricaneWindScale s3 = SaffirSimpsonHurricaneWindScale.of(
				AbstractQuantity.of(111, MILES_PER_HOUR),
				AbstractQuantity.of(129, MILES_PER_HOUR), THREE);
		System.out.println(s3);
		
		final SaffirSimpsonHurricaneWindScale s4 = SaffirSimpsonHurricaneWindScale.of(
				AbstractQuantity.of(130, MILES_PER_HOUR),
				AbstractQuantity.of(156, MILES_PER_HOUR), FOUR);
		System.out.println(s4);
		
		final SaffirSimpsonHurricaneWindScale s5 = SaffirSimpsonHurricaneWindScale.of(
				AbstractQuantity.of(157, MILES_PER_HOUR), null, FIVE);
		System.out.println(s5);
		
		int argument = -1;
		if (args!= null && args.length>0) {
			argument = Integer.valueOf(args[0]).intValue();
		}
		
		SaffirSimpsonHurricaneWindScale scale = null;
		switch (argument) {
			case 0:
				scale = sts;
				break;
			case 1:
				scale = s1;
				break;
			case 2:
				scale = s2;
				break;
			case 3:
				scale = s3;
				break;
			case 4:
				scale = s4;
				break;
			case 5:
				scale = s5;
				break;
			default:
				scale = std;
		}
		
		if (scale !=null) {
			final AbstractQuantity<Speed> metricSpeed = scale.hasUpperBound() ?
					(AbstractQuantity<Speed>) scale.getMaximum().to(KILOMETRES_PER_HOUR) :
						(AbstractQuantity<Speed>) scale.getMinimum().to(KILOMETRES_PER_HOUR);
					
			System.out.print(metricSpeed);
			System.out.println(" (" + scale.getCategory() + ")");
			AbstractQuantity<Length> l = AbstractQuantity.of(500, KILO(METRE));
			System.out.println(String.format("Distance: %s", l));
			
			@SuppressWarnings("unchecked")
			AbstractQuantity<Time> timeToEvacuate = (AbstractQuantity<Time>) l.divide(metricSpeed);
			System.out.println(String.format("Time to evacuate: %s", timeToEvacuate));
		} else {
			System.out.println("No scale given.");
		}
	}
}
