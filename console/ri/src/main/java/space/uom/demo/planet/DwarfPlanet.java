/*
 *  Unit-API - Units of Measurement API for Java
 *  Copyright (c) 2005-2015, Jean-Marie Dautelle, Werner Keil, V2COM.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-363, Unit-API nor the names of their contributors may be used to endorse or promote products derived from this software without specific prior written permission.
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
package space.uom.demo.planet;

import static space.uom.demo.planet.SolarSystem.*;
import static tec.units.ri.unit.MetricPrefix.*;
import static tec.units.ri.unit.Units.*;

import javax.measure.Quantity;
import javax.measure.quantity.Acceleration;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import tec.units.ri.AbstractQuantity;
import tec.units.ri.spi.DefaultQuantityFactory;


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

    public Quantity<Acceleration> surfaceGravity() {
        double m = mass.doubleValue(KILOGRAM);
        double r = radius.doubleValue(METRE);
        return DefaultQuantityFactory.getInstance(Acceleration.class).create(
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