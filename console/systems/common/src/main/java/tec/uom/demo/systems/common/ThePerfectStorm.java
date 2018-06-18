/*
 *  Units of Measurement Demos for Java
 *  Copyright (c) 2005-2017, Jean-Marie Dautelle, Werner Keil, V2COM.
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
package tec.uom.demo.systems.common;

import static tec.uom.demo.types.SaffirSimpsonHurricaneWindScale.Category.FIVE;
import static tec.uom.demo.types.SaffirSimpsonHurricaneWindScale.Category.FOUR;
import static tec.uom.demo.types.SaffirSimpsonHurricaneWindScale.Category.ONE;
import static tec.uom.demo.types.SaffirSimpsonHurricaneWindScale.Category.THREE;
import static tec.uom.demo.types.SaffirSimpsonHurricaneWindScale.Category.TROPICAL_DEPRESSION;
import static tec.uom.demo.types.SaffirSimpsonHurricaneWindScale.Category.TROPICAL_STORM;
import static tec.uom.demo.types.SaffirSimpsonHurricaneWindScale.Category.TWO;
import static javax.measure.MetricPrefix.KILO;
import static tec.units.indriya.unit.Units.METRE;
import static systems.uom.common.USCustomary.MILE_PER_HOUR;
import static tec.units.indriya.unit.Units.KILOMETRE_PER_HOUR;

import javax.measure.Quantity;
//import javax.measure.quantity.Energy;
import javax.measure.quantity.Length;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Time;

import tec.units.indriya.format.SimpleUnitFormat;
import tec.units.indriya.quantity.Quantities;
import tec.uom.demo.types.SaffirSimpsonHurricaneWindScale;

/**
 * @author Werner Keil
 * @version 0.8
 * @see {@link SaffirSimpsonHurricaneWindScale}
 */
public class ThePerfectStorm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final SaffirSimpsonHurricaneWindScale std = SaffirSimpsonHurricaneWindScale.of(
				null, Quantities.getQuantity(38, MILE_PER_HOUR), TROPICAL_DEPRESSION);
		System.out.println(std);

		final SaffirSimpsonHurricaneWindScale sts = SaffirSimpsonHurricaneWindScale.of(
				Quantities.getQuantity(39, MILE_PER_HOUR),
				Quantities.getQuantity(73, MILE_PER_HOUR), TROPICAL_STORM);
		System.out.println(sts);

		final SaffirSimpsonHurricaneWindScale s1 = SaffirSimpsonHurricaneWindScale.of(
				Quantities.getQuantity(74, MILE_PER_HOUR),
				Quantities.getQuantity(95, MILE_PER_HOUR), ONE);
		System.out.println(s1);

		final SaffirSimpsonHurricaneWindScale s2 = SaffirSimpsonHurricaneWindScale.of(
				Quantities.getQuantity(96, MILE_PER_HOUR),
				Quantities.getQuantity(110, MILE_PER_HOUR), TWO);
		System.out.println(s2);

		final SaffirSimpsonHurricaneWindScale s3 = SaffirSimpsonHurricaneWindScale.of(
				Quantities.getQuantity(111, MILE_PER_HOUR),
				Quantities.getQuantity(129, MILE_PER_HOUR), THREE);
		System.out.println(s3);

		final SaffirSimpsonHurricaneWindScale s4 = SaffirSimpsonHurricaneWindScale.of(
				Quantities.getQuantity(130, MILE_PER_HOUR),
				Quantities.getQuantity(156, MILE_PER_HOUR), FOUR);
		System.out.println(s4);

		final SaffirSimpsonHurricaneWindScale s5 = SaffirSimpsonHurricaneWindScale.of(
				Quantities.getQuantity(157, MILE_PER_HOUR), null, FIVE);
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
					scale.getMaximum().to(KILOMETRE_PER_HOUR) :
					scale.getMinimum().to(KILOMETRE_PER_HOUR);

			System.out.print(metricSpeed);
			System.out.println(" (" + scale.getCategory() + ")");
			Quantity<Length> l = Quantities.getQuantity(500, KILO(METRE));
			System.out.println(String.format("Distance: %s", l));
			
			Quantity<Time> timeToEvacuate = l.divide(metricSpeed).asType(Time.class);
			//Quantity<?> timeToEvacuate = l.divide(metricSpeed); if you don't want to cast ;-)
			SimpleUnitFormat.getInstance().label(timeToEvacuate.getUnit(), "h");
			System.out.println(String.format("Time to evacuate: %s", timeToEvacuate));
		} else {
			System.out.println("No scale given.");
		}
	}
}
