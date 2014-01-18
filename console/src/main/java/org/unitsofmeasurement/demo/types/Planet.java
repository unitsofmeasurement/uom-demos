/**
 * Copyright (c) 2013 Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.demo.types;

import static org.unitsofmeasurement.impl.system.SI.*;
import static org.unitsofmeasurement.demo.types.SolarSystem.G;

import javax.measure.Unit;
import javax.measure.quantity.Acceleration;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import org.unitsofmeasurement.impl.AbstractMeasurement;
import org.unitsofmeasurement.impl.model.quantity.AccelerationAmount;
import org.unitsofmeasurement.impl.model.quantity.LengthAmount;
import org.unitsofmeasurement.impl.model.quantity.MassAmount;


/**
 * @author  <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.1
 * 
 * This <type>enum</type> is inspired by Josh Bloch's example in <a href="http://www.oracle.com/technetwork/java/effectivejava-136174.html">Effective Java Second Edition</a>
 * 
 * <p>
 * Suppose you want to add data and behavior to an enum. 
 * For example consider <a href="http://en.wikipedia.org/wiki/Planet">planets</a> of the <a href="http://en.wikipedia.org/wiki/Solar_System">solar system</a>.  
 * Each planet knows its mass and radius, and can calculate its surface gravity and the weight of an object on the planet. 
 * Here is how it looks:
 * </p>
 */
public enum Planet {

    MERCURY(newMass(3.303e+23, KILOGRAM), newLength(2.4397e6, METRE)),
    VENUS(newMass(4.869e+24, KILOGRAM), newLength(6.0518e6, METRE)),
    EARTH(newMass(5.976e+24, KILOGRAM), newLength(6.37814e6, METRE)),
    MARS(newMass(6.421e+23, KILOGRAM), newLength(3.3972e6, METRE)),
    JUPITER(newMass(1.9e+27, KILOGRAM), newLength(7.1492e7, METRE)),
    SATURN(newMass(5.688e+26, KILOGRAM), newLength(6.0268e7, METRE)),
    URANUS(newMass(8.686e+25, KILOGRAM), newLength(2.5559e7, METRE)),
    NEPTUNE(newMass(1.024e+26, KILOGRAM), newLength(2.4746e7, METRE));

    private final AbstractMeasurement<Mass> mass;   // in kilograms

    private final AbstractMeasurement<Length> radius; // in meters

    Planet(AbstractMeasurement<Mass> mass, AbstractMeasurement<Length> radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public AbstractMeasurement<Mass> getMass() {
        return mass;
    }

    public AbstractMeasurement<Length> getRadius() {
        return radius;
    }

    public Acceleration surfaceGravity() {
        double m = mass.doubleValue(KILOGRAM);
        double r = radius.doubleValue(METRE);
        return new AccelerationAmount(
                G * m / (r * r), METRES_PER_SQUARE_SECOND);
    }

    private static AbstractMeasurement<Mass> newMass(double value, Unit<Mass> unit) {
        return new MassAmount(value, unit);
    }

    private static AbstractMeasurement<Length> newLength(double value, Unit<Length> unit) {
        return new LengthAmount(value, unit);
    }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("; ");
		sb.append(Mass.class.getSimpleName());
		sb.append(": ");
		sb.append(getMass());
		sb.append("; ");
		sb.append("Radius:");
		sb.append(getRadius());
		sb.append("; ");
		sb.append("Surface Gravity: ");
		sb.append(surfaceGravity());
		return sb.toString();
	}
}