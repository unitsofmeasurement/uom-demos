/**
 * Copyright (c) 2013-2014 Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.demo;

import static org.unitsofmeasurement.impl.system.SI.*;

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
//		AbstractMeasurement<Area> a = AbstractMeasurement.of(10, HECTAR);
//		System.out.println(a);
	}

}
