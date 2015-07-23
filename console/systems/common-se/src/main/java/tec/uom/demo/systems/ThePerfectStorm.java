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
package tec.uom.demo.systems;

import static tec.uom.demo.types.SaffirSimpsonHurricaneWindScale.Category.FIVE;
import static tec.uom.demo.types.SaffirSimpsonHurricaneWindScale.Category.FOUR;
import static tec.uom.demo.types.SaffirSimpsonHurricaneWindScale.Category.ONE;
import static tec.uom.demo.types.SaffirSimpsonHurricaneWindScale.Category.THREE;
import static tec.uom.demo.types.SaffirSimpsonHurricaneWindScale.Category.TROPICAL_DEPRESSION;
import static tec.uom.demo.types.SaffirSimpsonHurricaneWindScale.Category.TROPICAL_STORM;
import static tec.uom.demo.types.SaffirSimpsonHurricaneWindScale.Category.TWO;
import static tec.uom.se.unit.Units.KILOMETRES_PER_HOUR;
import static tec.uom.se.unit.Units.METRE;
import static tec.uom.se.unit.MetricPrefix.KILO;
import static tec.uom.se.unit.US.MILES_PER_HOUR;

import javax.measure.Quantity;
//import javax.measure.quantity.Energy;
import javax.measure.quantity.Length;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Time;

import tec.uom.demo.types.SaffirSimpsonHurricaneWindScale;
import tec.uom.se.quantity.Quantities;

/**
 * @author Werner Keil
 * @version 0.7.4
 * @see {@link SaffirSimpsonHurricaneWindScale}
 */
public class ThePerfectStorm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final SaffirSimpsonHurricaneWindScale std = SaffirSimpsonHurricaneWindScale.of(
				null, Quantities.getQuantity(38, MILES_PER_HOUR), TROPICAL_DEPRESSION);
		System.out.println(std);

		final SaffirSimpsonHurricaneWindScale sts = SaffirSimpsonHurricaneWindScale.of(
				Quantities.getQuantity(39, MILES_PER_HOUR),
				Quantities.getQuantity(73, MILES_PER_HOUR), TROPICAL_STORM);
		System.out.println(sts);

		final SaffirSimpsonHurricaneWindScale s1 = SaffirSimpsonHurricaneWindScale.of(
				Quantities.getQuantity(74, MILES_PER_HOUR),
				Quantities.getQuantity(95, MILES_PER_HOUR), ONE);
		System.out.println(s1);

		final SaffirSimpsonHurricaneWindScale s2 = SaffirSimpsonHurricaneWindScale.of(
				Quantities.getQuantity(96, MILES_PER_HOUR),
				Quantities.getQuantity(110, MILES_PER_HOUR), TWO);
		System.out.println(s2);

		final SaffirSimpsonHurricaneWindScale s3 = SaffirSimpsonHurricaneWindScale.of(
				Quantities.getQuantity(111, MILES_PER_HOUR),
				Quantities.getQuantity(129, MILES_PER_HOUR), THREE);
		System.out.println(s3);

		final SaffirSimpsonHurricaneWindScale s4 = SaffirSimpsonHurricaneWindScale.of(
				Quantities.getQuantity(130, MILES_PER_HOUR),
				Quantities.getQuantity(156, MILES_PER_HOUR), FOUR);
		System.out.println(s4);

		final SaffirSimpsonHurricaneWindScale s5 = SaffirSimpsonHurricaneWindScale.of(
				Quantities.getQuantity(157, MILES_PER_HOUR), null, FIVE);
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
			final Quantity<Speed> metricSpeed = scale.hasMaximum() ?
					scale.getMaximum().to(KILOMETRES_PER_HOUR) :
					scale.getMinimum().to(KILOMETRES_PER_HOUR);

			System.out.print(metricSpeed);
			System.out.println(" (" + scale.getCategory() + ")");
			Quantity<Length> l = Quantities.getQuantity(500, KILO(METRE));
			System.out.println(String.format("Distance: %s", l));
			Quantity<Time> timeToEvacuate = l.divide(metricSpeed).asType(Time.class);
			//Quantity<?> timeToEvacuate = l.divide(metricSpeed); if you don't want to cast ;-)
			System.out.println(String.format("Time to evacuate: %s", timeToEvacuate));
		} else {
			System.out.println("No scale given.");
		}
	}
}
