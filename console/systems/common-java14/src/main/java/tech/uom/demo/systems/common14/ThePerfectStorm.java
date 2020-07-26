/*
 *  Units of Measurement Console Demos
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
package tech.uom.demo.systems.common14;

import static javax.measure.MetricPrefix.KILO;
import static systems.uom.common.USCustomary.MILE_PER_HOUR;
import static tech.units.indriya.quantity.Quantities.getQuantity;
import static tech.units.indriya.unit.Units.KILOMETRE_PER_HOUR;
import static tech.units.indriya.unit.Units.METRE;
import static tech.uom.demo.systems.common14.types.SaffirSimpsonHurricaneWindScale.Category.*;

import tech.units.indriya.format.SimpleUnitFormat;
import tech.uom.demo.systems.common14.types.SaffirSimpsonHurricaneWindScale;

import javax.measure.quantity.Time;
import java.util.regex.Pattern;

/**
 * @author Werner Keil
 * @version 1.3
 * @see {@link SaffirSimpsonHurricaneWindScale}
 */
public class ThePerfectStorm {
	// Constants
	private static final SaffirSimpsonHurricaneWindScale STD = SaffirSimpsonHurricaneWindScale.of(
			null, getQuantity(38, MILE_PER_HOUR), TROPICAL_DEPRESSION);
	private static final SaffirSimpsonHurricaneWindScale STS = SaffirSimpsonHurricaneWindScale.of(
			getQuantity(39, MILE_PER_HOUR),	getQuantity(73, MILE_PER_HOUR), TROPICAL_STORM);
	private static final SaffirSimpsonHurricaneWindScale S1 = SaffirSimpsonHurricaneWindScale.of(
			getQuantity(74, MILE_PER_HOUR),	getQuantity(95, MILE_PER_HOUR), ONE);
	private static final SaffirSimpsonHurricaneWindScale S2 = SaffirSimpsonHurricaneWindScale.of(
			getQuantity(96, MILE_PER_HOUR),	getQuantity(110, MILE_PER_HOUR), TWO);
	private static final SaffirSimpsonHurricaneWindScale S3 = SaffirSimpsonHurricaneWindScale.of(
			getQuantity(111, MILE_PER_HOUR), getQuantity(129, MILE_PER_HOUR), THREE);
	private static final SaffirSimpsonHurricaneWindScale S4 = SaffirSimpsonHurricaneWindScale.of(
			getQuantity(130, MILE_PER_HOUR), getQuantity(156, MILE_PER_HOUR), FOUR);
	private static final SaffirSimpsonHurricaneWindScale S5 = SaffirSimpsonHurricaneWindScale.of(
			getQuantity(157, MILE_PER_HOUR), null, FIVE);

	private static final double DEFAULT_DIST_KM = 500d;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean verbose = false;
		if (args != null && args.length > 0 && !isNumeric(args[0])) {
			if ("-v".equals(args[0])) verbose = true;
		}
		
		var argument = -1;
		var distKm = DEFAULT_DIST_KM;
		
		if (verbose) {
			System.out.println(STD);
			System.out.println(STS);
			System.out.println(S1);
			System.out.println(S2);
			System.out.println(S3);
			System.out.println(S4);
			System.out.println(S5);
			
			if (args != null && args.length > 1 && isNumeric(args[1])) {
				argument = Integer.valueOf(args[1]).intValue();					
			}
			if (args != null && args.length > 2 && isNumeric(args[2])) {
				distKm = Double.valueOf(args[2]).doubleValue();						
			}		
		} else {
			if (args != null && args.length > 0 && isNumeric(args[0])) {
				argument = Integer.valueOf(args[0]).intValue();			
			}
			if (args != null && args.length > 1 && isNumeric(args[1])) {
				distKm = Double.valueOf(args[1]).doubleValue();						
			}
		}
		
		// With Java 14 the switch/case segment gets much more compact
		var scale = switch (argument) {
			case 0 -> STS;
			case 1 -> S1;
			case 2 -> S2;
			case 3 -> S3;
			case 4 -> S4;
			case 5 -> S5;
			default -> STD;
		};

		// If the wind scale has a maximum we take that assuming the worst case, otherwise the minimum
		final var metricSpeed = scale.hasMaximum() ?
				scale.getMaximum().to(KILOMETRE_PER_HOUR) :
				scale.getMinimum().to(KILOMETRE_PER_HOUR);

		System.out.print(metricSpeed);
		System.out.println(" (" +  Messages.getString("SaffirSimpsonHurricaneWindScale." + scale.getCategory(), true) 
		  + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		final var distance = getQuantity(distKm, KILO(METRE));
		System.out.println(String.format(Messages.getString("ThePerfectStorm.1"), distance)); //$NON-NLS-1$
		final var timeToEvacuate = distance.divide(metricSpeed).asType(Time.class);
		SimpleUnitFormat.getInstance().label(timeToEvacuate.getUnit(), "h");
		System.out.println(String.format(Messages.getString("ThePerfectStorm.3"), timeToEvacuate)); //$NON-NLS-1$
	}

	private static final Pattern PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

	private static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		return PATTERN.matcher(strNum).matches();
	}
}
