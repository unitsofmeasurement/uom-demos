/*
 *  Units of Measurement Demos for Java
 *  Copyright (c) 2005-2020, Werner Keil and others.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-385, Units of Measurement nor the names of their contributors may be used to endorse or promote products derived from this software without specific prior written permission.
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
package tech.uom.demo.systems.common;

import static javax.measure.MetricPrefix.KILO;
import static tech.units.indriya.unit.Units.METRE;
import static tech.uom.demo.systems.common.types.SaffirSimpsonHurricaneWindScale.Category.FIVE;
import static tech.uom.demo.systems.common.types.SaffirSimpsonHurricaneWindScale.Category.FOUR;
import static tech.uom.demo.systems.common.types.SaffirSimpsonHurricaneWindScale.Category.ONE;
import static tech.uom.demo.systems.common.types.SaffirSimpsonHurricaneWindScale.Category.THREE;
import static tech.uom.demo.systems.common.types.SaffirSimpsonHurricaneWindScale.Category.TROPICAL_DEPRESSION;
import static tech.uom.demo.systems.common.types.SaffirSimpsonHurricaneWindScale.Category.TROPICAL_STORM;
import static tech.uom.demo.systems.common.types.SaffirSimpsonHurricaneWindScale.Category.TWO;
import static systems.uom.common.USCustomary.MILE_PER_HOUR;
import static tech.units.indriya.unit.Units.KILOMETRE_PER_HOUR;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Time;

import tech.units.indriya.format.SimpleUnitFormat;
import tech.units.indriya.quantity.Quantities;
import tech.uom.demo.systems.common.types.SaffirSimpsonHurricaneWindScale;

/**
 * @author Werner Keil
 * @version 1.1
 * @see {@link SaffirSimpsonHurricaneWindScale}
 */
public class ThePerfectStorm {
	// Constants
	private static final SaffirSimpsonHurricaneWindScale STD = SaffirSimpsonHurricaneWindScale.of(
			null, Quantities.getQuantity(38, MILE_PER_HOUR), TROPICAL_DEPRESSION);
	private static final SaffirSimpsonHurricaneWindScale STS = SaffirSimpsonHurricaneWindScale.of(
			Quantities.getQuantity(39, MILE_PER_HOUR),
			Quantities.getQuantity(73, MILE_PER_HOUR), TROPICAL_STORM);
	private static final SaffirSimpsonHurricaneWindScale S1 = SaffirSimpsonHurricaneWindScale.of(
			Quantities.getQuantity(74, MILE_PER_HOUR),
			Quantities.getQuantity(95, MILE_PER_HOUR), ONE);
	private static final SaffirSimpsonHurricaneWindScale s2 = SaffirSimpsonHurricaneWindScale.of(
			Quantities.getQuantity(96, MILE_PER_HOUR),
			Quantities.getQuantity(110, MILE_PER_HOUR), TWO);
	private static final SaffirSimpsonHurricaneWindScale s3 = SaffirSimpsonHurricaneWindScale.of(
			Quantities.getQuantity(111, MILE_PER_HOUR),
			Quantities.getQuantity(129, MILE_PER_HOUR), THREE);
	private static final SaffirSimpsonHurricaneWindScale s4 = SaffirSimpsonHurricaneWindScale.of(
			Quantities.getQuantity(130, MILE_PER_HOUR),
			Quantities.getQuantity(156, MILE_PER_HOUR), FOUR);
	private static final SaffirSimpsonHurricaneWindScale s5 = SaffirSimpsonHurricaneWindScale.of(
			Quantities.getQuantity(157, MILE_PER_HOUR), null, FIVE);

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		System.out.println(STD);
		System.out.println(STS);
		System.out.println(S1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);

		int argument = -1;
		if (args != null && args.length > 0) {
			argument = Integer.valueOf(args[0]).intValue();
		}

		SaffirSimpsonHurricaneWindScale scale = null;
		switch (argument) {
			case 0:
				scale = STS;
				break;
			case 1:
				scale = S1;
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
				scale = STD;
		}

		if (scale !=null) {
			final Quantity<Speed> metricSpeed = scale.hasMaximum() ?
					scale.getMaximum().to(KILOMETRE_PER_HOUR) :
					scale.getMinimum().to(KILOMETRE_PER_HOUR);

			System.out.print(metricSpeed);
			System.out.println(" (" +  Messages.getString("SaffirSimpsonHurricaneWindScale." + scale.getCategory(), true) 
			  + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			Quantity<Length> l = Quantities.getQuantity(500, KILO(METRE));
			System.out.println(String.format(Messages.getString("ThePerfectStorm.1"), l)); //$NON-NLS-1$
			
			Quantity<Time> timeToEvacuate = l.divide(metricSpeed).asType(Time.class);
			//Quantity<?> timeToEvacuate = l.divide(metricSpeed); //if you don't want to cast ;-)
			SimpleUnitFormat.getInstance().label(timeToEvacuate.getUnit(), Messages.getString("ThePerfectStorm.2")); //$NON-NLS-1$
			System.out.println(String.format(Messages.getString("ThePerfectStorm.3"), timeToEvacuate)); //$NON-NLS-1$
		} else {
			System.out.println(Messages.getString("ThePerfectStorm.4")); //$NON-NLS-1$
		}
	}
}
