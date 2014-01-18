/**
 * Copyright (c) 2013 Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.demo.types;

import static org.unitsofmeasurement.impl.system.SIPrefix.*;
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
 * For example consider <a href="http://en.wikipedia.org/wiki/Dwarf_planet">dwarf planets</a> of the <a href="http://en.wikipedia.org/wiki/Solar_System">solar system</a>. 
 * Each planet knows its mass and radius, and can calculate its surface gravity and the weight of an object on the planet. 
 * Here is how it looks:
 * </p>
 */
public enum DwarfPlanet {
	CERES(newMass(9.43e+20, KILOGRAM), newLength(0.4873e6, METRE)),
    PLUTO(newMass(1.305e+22, KILOGRAM), newLength(1.153e6, METRE)),
    HAUMEA(newMass(4.006e+21, KILOGRAM), newLength(620, KILO(METRE))),
    MAKEMAKE(newMass(3e+21, KILOGRAM), newLength(715, KILO(METRE))),
    ERIS(newMass(1.67e+22, KILOGRAM), newLength(1163, KILO(METRE)));

    private final AbstractMeasurement<Mass> mass;   // in kilograms

    private final AbstractMeasurement<Length> radius; // in meters

    DwarfPlanet(AbstractMeasurement<Mass> mass, AbstractMeasurement<Length> radius) {
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
		sb.append("Radius: ");
		sb.append(getRadius());
		sb.append("; ");
		sb.append("Surface Gravity: ");
		sb.append(surfaceGravity());
		return sb.toString();
	}
}