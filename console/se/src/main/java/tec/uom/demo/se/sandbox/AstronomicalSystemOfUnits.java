/**
 *  Unit-API - Units of Measurement API for Java
 *  Copyright (c) 2005-2015, Jean-Marie Dautelle, Werner Keil, V2COM.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 *    and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-363, Unit-API nor the names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
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
package tec.uom.demo.se.sandbox;


import java.util.HashMap;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Volume;
import javax.measure.quantity.VolumetricDensity;

import tec.uom.se.AbstractSystemOfUnits;
import tec.uom.se.AbstractUnit;
import tec.uom.se.function.MultiplyConverter;
import tec.uom.se.spi.SI;
import tec.uom.se.spi.SIPrefix;
import tec.uom.se.unit.ProductUnit;
import tec.uom.se.unit.TransformedUnit;

/**
 * test bed derived from https://github.com/jughyd/uom-astronomy/blob/master/uom-astronomy-api/src/main/java/tec/uom/astronomy/solarsystem/units/AstronomicalSystemOfUnits.java
 * @author Werner
 *
 */
class AstronomicalSystemOfUnits extends AbstractSystemOfUnits {

	/**
	 * The singleton instance.
	 */
	private static final AstronomicalSystemOfUnits INSTANCE = new AstronomicalSystemOfUnits();

	/**
	 * Holds the mapping quantity to unit.
	 */
	private final HashMap<Class<? extends Quantity>, AbstractUnit> quantityToUnit = new HashMap<Class<? extends Quantity>, AbstractUnit>();

	/**
	 * Default constructor (prevents this class from being instantiated).
	 */
	private AstronomicalSystemOfUnits() {
	}

	/**
	 * Returns the singleton instance of this class.
	 *
	 * @return the metric system instance.
	 */
	public static AstronomicalSystemOfUnits getInstance() {
		return INSTANCE;
	}

	/**
	 * A mass unit accepted for use with SI units (standard name <code>UA</code>
	 * ). The solar mass (M☉) is a standard unit of mass in astronomy that is
	 * used to indicate the masses of other stars, as well as clusters, nebulae
	 * and galaxies. It is equal to the mass of the Sun, about two nonillion
	 * kilograms:
	 */

	public static final TransformedUnit<Mass> SOLAR_MASS = new TransformedUnit<Mass>(
			"M☉", SI.KILOGRAM, new MultiplyConverter(
					1.9891 * (Math.pow(10, 30))));

	/**
	 * A length unit accepted for use with SI units (standard name
	 * <code>UA</code>). The astronomical unit is a unit of length. Its value is
	 * such that, when used to describe the motion of bodies in the solar
	 * system, the heliocentric gravitation constant is (0.017 202 098 95)2
	 * ua3·d-2. The value must be obtained by experiment, and is therefore not
	 * known exactly. public static final Unit<Length> ASTRONOMIC_UNIT =
	 * addUnit(SI.ASTRONOMICAL_UNIT);
	 */
	public static final TransformedUnit<Length> ASTRONOMICAL_UNIT = new TransformedUnit<Length>(
			"AU", SI.METRE, new MultiplyConverter(149597871000.0));

	public static final ProductUnit<VolumetricDensity> GRAM_PER_CUBIC_CENTIMETRE = addUnit(
			new ProductUnit<VolumetricDensity>(SI.GRAM.divide((SIPrefix
					.CENTI(SI.METRE)).pow(3))), VolumetricDensity.class);

	/**
	 * The SI unit for area quantities (standard name <code>m2</code>).
	 */
	public static final ProductUnit<Area> SQUARE_KILOMETRE = addUnit(
			new ProductUnit<Area>(SIPrefix.KILO(SI.METRE).multiply(
					SIPrefix.KILO(SI.METRE))), Area.class);

	/**
	 * The SI unit for volume quantities (standard name <code>m3</code>).
	 */
	public static final ProductUnit<Volume> CUBIC_KILOMETRE = addUnit(
			new ProductUnit<Volume>(SQUARE_KILOMETRE.multiply(SIPrefix
					.KILO(SI.METRE))), Volume.class);

	// ///////////////////
	// Collection View //
	// ///////////////////

	@Override
	public String getName() {
		return "ASTRONOMICALSYSTEMOFUNITS";
	}

	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Override public <Q extends Quantity<Q>> AbstractUnit<Q> getUnit(Class<Q>
	 * quantityType) { return quantityToUnit.get(quantityType); }
	 */

	/**
	 * Adds a new unit not mapped to any specified quantity type.
	 *
	 * @param unit
	 *            the unit being added.
	 * @return <code>unit</code>.
	 */

	private static <U extends Unit<Q>, Q extends Quantity<Q>> U addUnit(U unit) {
		INSTANCE.units.add(unit);
		return unit;
	}

	/**
	 * Adds a new unit and maps it to the specified quantity type.
	 *
	 * @param unit
	 *            the unit being added.
	 * @param type
	 *            the quantity type.
	 * @return <code>unit</code>.
	 */
	private static <U extends AbstractUnit<?>> U addUnit(U unit,
			Class<? extends Quantity<?>> type) {
		INSTANCE.units.add(unit);
		INSTANCE.quantityToUnit.put(type, unit);
		return unit;
	}

}
