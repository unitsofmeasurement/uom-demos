/**
 * Copyright (c) 2013-2014 Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.demo;

import static org.unitsofmeasurement.impl.system.CommonUnits.KILOMETRES_PER_HOUR;
import static org.unitsofmeasurement.impl.system.SIPrefix.*;
import static org.unitsofmeasurement.impl.system.SI.METRE;
import static org.unitsofmeasurement.impl.system.US.MILES_PER_HOUR;
import static org.unitsofmeasurement.demo.types.SaffirSimpsonHurricaneWindScale.Category.*;

import javax.measure.quantity.Length;
import javax.measure.quantity.Time;
import javax.measure.quantity.Speed;

import org.unitsofmeasurement.demo.types.SaffirSimpsonHurricaneWindScale;
import org.unitsofmeasurement.impl.AbstractMeasurement;

/**
 * @author Werner Keil
 *@see {@link SaffirSimpsonHurricaneWindScale}
 */
public class ThePerfectStorm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final SaffirSimpsonHurricaneWindScale std = SaffirSimpsonHurricaneWindScale.of(
				null, AbstractMeasurement.of(38, MILES_PER_HOUR), TROPICAL_DEPRESSION);
		System.out.println(std);
		
		final SaffirSimpsonHurricaneWindScale sts = SaffirSimpsonHurricaneWindScale.of(
				AbstractMeasurement.of(39, MILES_PER_HOUR),
				AbstractMeasurement.of(73, MILES_PER_HOUR), TROPICAL_STORM);
		System.out.println(sts);
		
		final SaffirSimpsonHurricaneWindScale s1 = SaffirSimpsonHurricaneWindScale.of(
				AbstractMeasurement.of(74, MILES_PER_HOUR),
				AbstractMeasurement.of(95, MILES_PER_HOUR), ONE);
		System.out.println(s1);
		
		final SaffirSimpsonHurricaneWindScale s2 = SaffirSimpsonHurricaneWindScale.of(
				AbstractMeasurement.of(96, MILES_PER_HOUR),
				AbstractMeasurement.of(110, MILES_PER_HOUR), TWO);
		System.out.println(s2);
		
		final SaffirSimpsonHurricaneWindScale s3 = SaffirSimpsonHurricaneWindScale.of(
				AbstractMeasurement.of(111, MILES_PER_HOUR),
				AbstractMeasurement.of(129, MILES_PER_HOUR), THREE);
		System.out.println(s3);
		
		final SaffirSimpsonHurricaneWindScale s4 = SaffirSimpsonHurricaneWindScale.of(
				AbstractMeasurement.of(130, MILES_PER_HOUR),
				AbstractMeasurement.of(156, MILES_PER_HOUR), FOUR);
		System.out.println(s4);
		
		final SaffirSimpsonHurricaneWindScale s5 = SaffirSimpsonHurricaneWindScale.of(
				AbstractMeasurement.of(157, MILES_PER_HOUR), null, FIVE);
		System.out.println(s5);
		
		final SaffirSimpsonHurricaneWindScale scale = s4;
		
		final AbstractMeasurement<Speed> metricSpeed = scale.hasMaximum() ?
				(AbstractMeasurement<Speed>) scale.getMaximum().to(KILOMETRES_PER_HOUR) :
					(AbstractMeasurement<Speed>) scale.getMinimum().to(KILOMETRES_PER_HOUR);
				
		System.out.print(metricSpeed);
		System.out.println(" (" + scale.getCategory() + ")");
		AbstractMeasurement<Length> l = AbstractMeasurement.of(500, KILO(METRE));
		System.out.println(String.format("Distance: %s", l));
		
		@SuppressWarnings("unchecked")
		AbstractMeasurement<Time> timeToEvacuate = (AbstractMeasurement<Time>) l.divide(metricSpeed);
		System.out.println(String.format("Time to evacuate: %s", timeToEvacuate));
	}

}
