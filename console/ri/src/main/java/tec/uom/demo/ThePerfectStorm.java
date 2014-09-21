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

import static tec.uom.demo.types.SaffirSimpsonHurricaneWindScale.Category.FIVE;
import static tec.uom.demo.types.SaffirSimpsonHurricaneWindScale.Category.FOUR;
import static tec.uom.demo.types.SaffirSimpsonHurricaneWindScale.Category.ONE;
import static tec.uom.demo.types.SaffirSimpsonHurricaneWindScale.Category.THREE;
import static tec.uom.demo.types.SaffirSimpsonHurricaneWindScale.Category.TROPICAL_DEPRESSION;
import static tec.uom.demo.types.SaffirSimpsonHurricaneWindScale.Category.TROPICAL_STORM;
import static tec.uom.demo.types.SaffirSimpsonHurricaneWindScale.Category.TWO;
import static tec.units.ri.util.CommonUnits.KILOMETRES_PER_HOUR;
import static tec.units.ri.util.SI.METRE;
import static tec.units.ri.util.SIPrefix.KILO;
import static tec.units.ri.util.US.MILES_PER_HOUR;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Time;

import tec.units.ri.quantity.BaseQuantity;
import tec.uom.demo.types.SaffirSimpsonHurricaneWindScale;

/**
 * @author Werner Keil
 * @version 0.7.1
 * @see {@link SaffirSimpsonHurricaneWindScale}
 */
public class ThePerfectStorm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final SaffirSimpsonHurricaneWindScale std = SaffirSimpsonHurricaneWindScale.of(
				null, BaseQuantity.of(38, MILES_PER_HOUR), TROPICAL_DEPRESSION);
		System.out.println(std);

		final SaffirSimpsonHurricaneWindScale sts = SaffirSimpsonHurricaneWindScale.of(
				BaseQuantity.of(39, MILES_PER_HOUR),
				BaseQuantity.of(73, MILES_PER_HOUR), TROPICAL_STORM);
		System.out.println(sts);

		final SaffirSimpsonHurricaneWindScale s1 = SaffirSimpsonHurricaneWindScale.of(
				BaseQuantity.of(74, MILES_PER_HOUR),
				BaseQuantity.of(95, MILES_PER_HOUR), ONE);
		System.out.println(s1);

		final SaffirSimpsonHurricaneWindScale s2 = SaffirSimpsonHurricaneWindScale.of(
				BaseQuantity.of(96, MILES_PER_HOUR),
				BaseQuantity.of(110, MILES_PER_HOUR), TWO);
		System.out.println(s2);

		final SaffirSimpsonHurricaneWindScale s3 = SaffirSimpsonHurricaneWindScale.of(
				BaseQuantity.of(111, MILES_PER_HOUR),
				BaseQuantity.of(129, MILES_PER_HOUR), THREE);
		System.out.println(s3);

		final SaffirSimpsonHurricaneWindScale s4 = SaffirSimpsonHurricaneWindScale.of(
				BaseQuantity.of(130, MILES_PER_HOUR),
				BaseQuantity.of(156, MILES_PER_HOUR), FOUR);
		System.out.println(s4);

		final SaffirSimpsonHurricaneWindScale s5 = SaffirSimpsonHurricaneWindScale.of(
				BaseQuantity.of(157, MILES_PER_HOUR), null, FIVE);
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
			Quantity<Length> l = BaseQuantity.of(500, KILO(METRE));
			System.out.println(String.format("Distance: %s", l));

			@SuppressWarnings("unchecked")
			Quantity<Time> timeToEvacuate = (Quantity<Time>) l.divide(metricSpeed);
			System.out.println(String.format("Time to evacuate: %s", timeToEvacuate));
		} else {
			System.out.println("No scale given.");
		}
	}
}
