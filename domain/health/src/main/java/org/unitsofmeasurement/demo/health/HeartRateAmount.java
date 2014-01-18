/**
 * Copyright (c) 2013 Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.demo.health;

import javax.measure.Unit;

import org.unitsofmeasurement.impl.BaseMeasurement;

/**
 * Represents the speed of heart beat.
 * The standard unit for this quantity is "bpm" (Beats per Minute).
 *
 * @author  <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.1, Date: 2013-12-30
 */
public final class HeartRateAmount extends BaseMeasurement<HeartRate> implements HeartRate {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7105140153324121388L;

	public HeartRateAmount(Number number, Unit<HeartRate> unit) {
		super(number, unit);
	}
        
        public static HeartRateAmount of(Number number, Unit<HeartRate> unit) {
            return new HeartRateAmount(number, unit);
        }
}

