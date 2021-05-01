/*
 * JBoss, Home of Professional Open Source
 * Copyright 2012, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the 
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.quickstarts.temperatureconverter.ejb;

import java.util.function.BinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tech.units.indriya.AbstractQuantity;
import tech.units.indriya.ComparableQuantity;
import tech.units.indriya.internal.function.Calculator;
import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.unit.Units;

import javax.measure.quantity.Temperature;
import javax.measure.Quantity;
import javax.measure.Unit;

/**
 * A domain object that can store a temperature and scale. Additionally, it can
 * parse a string to a temperature and scale.
 * 
 * @author Pete Muir
 * @author Bruce Wolfe
 * @author Werner Keil
 * @deprecated try to get rid of it in a follow-up version, factor parse method into TemperatureParser 
 */
public class TemperatureAmount extends AbstractQuantity<Temperature> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2441230969280534926L;

	private final double temperature;

	/*
	 * Create a regular expression to extract the temperature and scale (if passed).
	 */
	private static Pattern PATTERN = Pattern.compile("^([-+]?[0-9]*\\.?[0-9]+)([CF]?)");

	/**
	 * Parse a string, with an optional scale suffix. If no scale suffix is on the
	 * string, the defaultScale will be used.
	 * 
	 * @param temperature  the temperature to parse
	 * @param defaultScale the default scale to use
	 */
	public static Quantity<Temperature> parse(String temperature, Unit<Temperature> defaultScale) {

		Unit<Temperature> s;
		Number t;

		/**
		 * Extract temperature and scale
		 */
		Matcher matcher = PATTERN.matcher(temperature);

		// Extract the temperature
		if (matcher.find()) {
			t = Double.parseDouble(matcher.group());
		} else {
			throw new IllegalArgumentException("You must provide a valid temperature to convert- 'XX.XXX'");
		}

		// Use the scale included with the sourceTemperature OR the defaultScale
		// provided.
		if (matcher.find()) {
			try {
				s = valueOfAbbreviation(matcher.group());
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException("You must provide a valid temperature scale- 'C|F'");
			}
		} else {
			s = defaultScale;
		}
		return Quantities.getQuantity(t, s);
	}

	TemperatureAmount(Number value, Unit<Temperature> scale) {
		this(value.doubleValue(), scale);
	}

	TemperatureAmount(double temperature, Unit<Temperature> scale) {
		super(scale);
		// super(Double.valueOf(temperature), scale);
		this.temperature = temperature;
//        this.scale = scale;
	}

	private static Unit<Temperature> valueOfAbbreviation(String value) {
		if (value == null) {
			throw new IllegalArgumentException("value must not be null");
		} else if ("C".equals(value.toUpperCase())) {
			return Units.CELSIUS;
		} else if ("K".equals(value.toUpperCase())) {
			return Units.KELVIN;
//        } else if ("F".equals(value.toUpperCase())) {
//            return US.FAHRENHEIT;
		} else {
			throw new IllegalArgumentException(value + " not recognized as a valid scale");
		}
	}

	public double getTemperature() {
		return temperature;
	}

	@Override
	public ComparableQuantity<Temperature> add(Quantity<Temperature> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComparableQuantity<Temperature> subtract(Quantity<Temperature> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Number getValue() {
		return getTemperature();
	}

	private static <R extends Quantity<R>> Number quantityValue(Quantity<R> that) {
		return convertedQuantityValue(that, that.getUnit());
	}

	private static <R extends Quantity<R>> Number convertedQuantityValue(Quantity<R> that, Unit<R> unit) {
		return that.getUnit().getConverterTo(unit).convert(that.getValue());
	}

	/**
	 * @deprecated temporary solution
	 */
	private ComparableQuantity<?> applyMultiplicativeQuantityOperation(Quantity<?> that,
			BinaryOperator<Number> valueOperator, BinaryOperator<Unit<?>> unitOperator) {

		final Number thisValue = quantityValue(this);
		final Number thatValue = quantityValue(that);
		final Number result = valueOperator.apply(thisValue, thatValue);
		final Unit<?> resultUnit = unitOperator.apply(getUnit(), that.getUnit());
		return Quantities.getQuantity(result, resultUnit);
	}

	/**
	 * @deprecated temporary solution
	 */
	private ComparableQuantity<Temperature> applyMultiplicativeNumberOperation(Number that,
			BinaryOperator<Number> valueOperator) {
		final Number thisValue = this.getValue();
		final Number thatValue = that;
		final Number result = valueOperator.apply(thisValue, thatValue);
		return Quantities.getQuantity(result, getUnit());
	}

	/**
	 * @deprecated temporary solution
	 */
	@Override
	public ComparableQuantity<?> multiply(Quantity<?> that) {
		return applyMultiplicativeQuantityOperation(that, (a, b) -> Calculator.of(a).multiply(b).peek(),
				Unit::multiply);
	}

	/**
	 * @deprecated temporary solution
	 */
	@Override
	public ComparableQuantity<Temperature> multiply(Number that) {
		return applyMultiplicativeNumberOperation(that, (a, b) -> Calculator.of(a).multiply(b).peek());
	}

	/**
	 * @deprecated temporary solution
	 */
    @Override
    public ComparableQuantity<?> inverse() {
        final Number resultValueInThisUnit = Calculator
                .of(getValue())
                .reciprocal()
                .peek();
        return Quantities.getQuantity(resultValueInThisUnit, getUnit().inverse(), getScale());
    }

	/**
	 * @deprecated temporary solution
	 */
	@Override
	public Quantity<Temperature> negate() {
		return new TemperatureAmount(Calculator.of(temperature).negate().peek(), getUnit());
	}

	/**
	 * @deprecated temporary solution
	 */
	@Override
	public ComparableQuantity<Temperature> divide(Number that) {
		return applyMultiplicativeNumberOperation(that, (a, b) -> Calculator.of(a).divide(b).peek());
	}

	/**
	 * @deprecated temporary solution
	 */
	@Override
	public ComparableQuantity<?> divide(Quantity<?> that) {
		return applyMultiplicativeQuantityOperation(that, (a, b) -> Calculator.of(a).divide(b).peek(), Unit::divide);
	}
}