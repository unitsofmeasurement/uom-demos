/**
 * Copyright (c) 2013 Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.demo;

import static org.unitsofmeasurement.impl.system.SI.METRE;

import javax.measure.quantity.Length;

import org.unitsofmeasurement.impl.AbstractMeasurement;

/**
 * @author Werner
 *
 */
public class UnitDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractMeasurement<Length> l = AbstractMeasurement.of(100d, METRE);
		System.out.println(l);
	}

}
