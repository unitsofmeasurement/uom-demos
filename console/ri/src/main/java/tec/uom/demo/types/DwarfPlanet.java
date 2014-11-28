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
import static tec.units.ri.util.SI.*;
import static tec.units.ri.util.SIPrefix.*;

import javax.measure.Quantity;
import javax.measure.quantity.Acceleration;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import tec.units.ri.AbstractQuantity;
import tec.units.ri.AbstractQuantityFactory;


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
 * @version 1.4
 */
public enum DwarfPlanet {
	CERES(newMass(9.43e+20, KILOGRAM), newLength(0.4873e6, METRE)),
    PLUTO(newMass(1.305e+22, KILOGRAM), newLength(1.153e6, METRE)),
    HAUMEA(newMass(4.006e+21, KILOGRAM), newLength(620, KILO(METRE))),
    MAKEMAKE(newMass(3e+21, KILOGRAM), newLength(715, KILO(METRE))),
    ERIS(newMass(1.67e+22, KILOGRAM), newLength(1163, KILO(METRE)));

    private final AbstractQuantity<Mass> mass;   // in kilograms

    private final AbstractQuantity<Length> radius; // in meters

    DwarfPlanet(AbstractQuantity<Mass> mass, AbstractQuantity<Length> radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public Quantity<Mass> getMass() {
        return mass;
    }

    public Quantity<Length> getRadius() {
        return radius;
    }

    public Acceleration surfaceGravity() {
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
		sb.append("Radius: ");
		sb.append(getRadius());
		sb.append("; ");
		sb.append("Surface Gravity: ");
		sb.append(surfaceGravity());
		return sb.toString();
	}
}