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
package tec.uom.demo.types;

import static tec.uom.demo.types.SolarSystem.*;
import static tec.units.ri.spi.SI.*;

import javax.measure.Quantity;
import javax.measure.quantity.Acceleration;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import tec.units.ri.AbstractQuantity;
import tec.units.ri.AbstractQuantityFactory;


/**
 * @author  <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.3
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

    private final AbstractQuantity<Mass> mass;   // in kilograms

    private final AbstractQuantity<Length> radius; // in meters

    Planet(AbstractQuantity<Mass> mass, AbstractQuantity<Length> radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public Quantity<Mass> getMass() {
        return mass;
    }

    public Quantity<Length> getRadius() {
        return radius;
    }

    public Quantity<Acceleration> surfaceGravity() {
        double m = mass.doubleValue(KILOGRAM);
        double r = radius.doubleValue(METRE);
        return AbstractQuantityFactory.getInstance(Acceleration.class).create(
                G * m / (r * r), METRES_PER_SQUARE_SECOND);
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