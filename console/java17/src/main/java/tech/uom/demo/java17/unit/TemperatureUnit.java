/*
 *  Units of Measurement Demos for Java
 *  Copyright (c) 2005-2023, Werner Keil and others.
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
 * 3. Neither the name of JSR-385, Units of Measurement nor the names of their contributors may be used to endorse or promote products
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
package tech.uom.demo.java17.unit;

import static tech.uom.demo.java17.unit.Constants.DEG;

import tech.uom.demo.java17.types.AbstractConverter;
import tech.uom.demo.java17.types.DimensionalModel;
import tech.uom.lib.common.function.DescriptionSupplier;
import tech.uom.lib.common.function.DoubleFactorSupplier;

import java.util.HashMap;
import java.util.Map;

import javax.measure.Dimension;
import javax.measure.IncommensurableException;
import javax.measure.Prefix;
import javax.measure.Quantity;
import javax.measure.UnconvertibleException;
import javax.measure.Unit;
import javax.measure.UnitConverter;
import javax.measure.quantity.Temperature;

/**
 * @author Werner Keil
 * @version 1.0, $Date: 2020-10-03 $
 */
public enum TemperatureUnit implements Unit<Temperature>, DoubleFactorSupplier, DescriptionSupplier {
		
	/** Kelvin, commonly used in scientific endeavors. */
	KELVIN(1d, 0d, null, 273.15d, 373.15d, "K", "William Thomson, 1st Baron Kelvin"),

	/** Rankine, used in scientific endeavors. */
	RANKINE(5 / 9, 0d, KELVIN, 491.67d, 671.641d, DEG + "R", "William John Macquorn Rankine"),

	/** Celsius, used by most of the world's population. */
	CELSIUS(0d, 273.15d, KELVIN, 0d, 100d, DEG + "C", "Anders Celsius"),

	/** Fahrenheit, commonly used in the United States. */
	FAHRENHEIT(0d, 459.67d, RANKINE, 32d, 212d, DEG + "F", "Daniel Gabriel Fahrenheit");

	/** Units by which this temperature scale is expressed. */
	private final String description;

	private final double multFactor;

	/** Freezing point of water for each temperature scale. */
	private final double freezingPoint;

	/** Boiling point of water for each temperature scale. */
	private final double boilingPoint;

	/** Name of person that this temperature scale is named for. */
	private final String namedFor;

	private final TemperatureUnit relativeTo;

	/**
	 * Constructor for TemperatureUnit that accepts key characteristics of each
	 * temperature scale.
	 *
	 * @param newFreezingPoint
	 *            Freezing point for this temperature scale.
	 * @param newBoilingPoint
	 *            Boiling point for this temperature scale.
	 * @param newUnits
	 *            Unit symbol for this temperature scale.
	 * @param newNamedFor
	 *            Name of person after which temperature scale was named.
	 */
	private TemperatureUnit(double newMult, double shift, final TemperatureUnit rel, double newFreezingPoint,
			double newBoilingPoint, final String newSymbol, final String newNamedFor) {
		this.multFactor = newMult;
		this.relativeTo = rel;
		this.freezingPoint = newFreezingPoint;
		this.boilingPoint = newBoilingPoint;
		this.description = newSymbol;
		this.namedFor = newNamedFor;
	}

	public String getSymbol() {
		return description;
	}

	public double getFactor() {
		return multFactor;
	}

	public String getName() {
		return namedFor;
	}

	public Unit<Temperature> getSystemUnit() {
		return KELVIN;
	}

	public Map<? extends Unit<Temperature>, Integer> getBaseUnits() {
		Map<Unit<Temperature>, Integer> prodUnits = new HashMap<Unit<Temperature>, Integer>();
		prodUnits.put(KELVIN, Integer.valueOf(2));
		return prodUnits;
	}

	public static TemperatureUnit getBySymbol(String symbol) {
		if (CELSIUS.name().equals(symbol)) {
			return CELSIUS;
		}
		if (FAHRENHEIT.name().equals(symbol)) {
			return FAHRENHEIT;
		}
		return KELVIN;
	}

	public UnitConverter getConverterTo(Unit<Temperature> that) throws UnconvertibleException {
		if ((this == that) || this.equals(that))
			return AbstractConverter.IDENTITY; // Shortcut.
		Unit<Temperature> thisSystemUnit = this.getSystemUnit();
		Unit<Temperature> thatSystemUnit = that.getSystemUnit();
		if (!thisSystemUnit.equals(thatSystemUnit))
			try {
				return getConverterToAny(that);
			} catch (IncommensurableException e) {
				throw new UnconvertibleException(e);
			}
		return that.getConverterTo(thatSystemUnit);
	}

	public UnitConverter getConverterToAny(Unit<?> that) throws IncommensurableException, UnconvertibleException {
		if (!isCompatible(that))
			throw new IncommensurableException(this + " is not compatible with " + that);
		DimensionalModel model = DimensionalModel.current();
		return model.getDimensionalTransform(this.getSystemUnit().getDimension()); // .concatenate(this.getConverterToSI());
	}

	public Unit<Temperature> alternate(String s) {
		return this;
	}

	public Dimension getDimension() {
		return SimpleDimension.INSTANCE;
	}

	public Unit<?> inverse() {
		return this;
	}

	public Unit<Temperature> divide(double v) {
		return null; // To change body of implemented methods use File |
		// Settings | File TemplateBuilder.
	}

	public Unit<?> divide(Unit<?> unit) {
		return null; // To change body of implemented methods use File |
		// Settings | File TemplateBuilder.
	}

	public boolean isCompatible(Unit<?> that) {
		if (that instanceof TemperatureUnit)
			return true;
		return false;
	}

	@SuppressWarnings({ "unchecked" })
	public final <T extends Quantity<T>> Unit<T> asType(Class<T> type) {
		Unit<T> metricUnit = (Unit<T>) getSystemUnit();
		if ((metricUnit == null) || metricUnit.isCompatible(this))
			return (Unit<T>) this;
		throw new ClassCastException("The unit: " + this //$NON-NLS-1$
				+ " is not of parameterized type " + type); //$NON-NLS-1$
	}

	public Unit<Temperature> multiply(double factor) {
		return this;
	}

	public Unit<?> multiply(Unit<?> that) {
		return this;
	}

	public Unit<?> pow(int n) {
		return this;
	}

	public Unit<?> root(int n) {
		return this;
	}

	public Unit<Temperature> transform(UnitConverter operation) {
		return this;
	}

	public Unit<Temperature> shift(double v) {
		return this;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public Unit<Temperature> prefix(Prefix prefix) {
		return this.multiply(Math.pow(prefix.getValue().doubleValue(), prefix.getExponent()));
	}
	
	@Override
	public Unit<Temperature> shift(Number offset) {
		return this;
	}

	@Override
	public Unit<Temperature> multiply(Number multiplier) {
		return this;
	}

	@Override
	public Unit<Temperature> divide(Number divisor) {
		return this;
	}

	@Override
	public boolean isEquivalentTo(Unit<Temperature> that) {
		return equals(that);
	}
}