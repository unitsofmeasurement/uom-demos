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
package org.unitsofmeasurement.demo.types;

import static org.unitsofmeasurement.impl.util.SI.*;
import static org.unitsofmeasurement.impl.util.SIPrefix.*;
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
 * This <type>enum</type> is inspired by Josh Bloch's example in <a href="http://www.oracle.com/technetwork/java/effectivejava-136174.html">Effective Java Second Edition</a>
 * 
 * <p>
 * Suppose you want to add data and behavior to an enum. 
 * For example consider <a href="http://en.wikipedia.org/wiki/Dwarf_planet">dwarf planets</a> of the <a href="http://en.wikipedia.org/wiki/Solar_System">solar system</a>. 
 * Each planet knows its mass and radius, and can calculate its surface gravity and the weight of an object on the planet. 
 * Here is how it looks:
 * </p>
 * @author  <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.2
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