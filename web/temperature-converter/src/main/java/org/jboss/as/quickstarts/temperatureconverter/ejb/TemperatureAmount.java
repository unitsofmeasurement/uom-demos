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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tec.units.ri.quantity.NumberQuantity;
import tec.units.ri.util.SI;
import tec.units.ri.util.US;

import javax.measure.quantity.Temperature;
import javax.measure.Unit;

/**
 * A domain object that can store a temperature and scale. Additionally, it can parse a string to a temperature and scale.
 * 
 * @author Pete Muir
 * @author Bruce Wolfe
 * @author Werner Keil
 * 
 */
public class TemperatureAmount extends NumberQuantity<Temperature>{

    static final double ABSOLUTE_ZERO_C = -273.150;
    static final double ABSOLUTE_ZERO_F = -459.670;

    /*
     * Create a regular expression to extract the temperature and scale (if passed).
     */
    private static Pattern PATTERN = Pattern.compile("^([-+]?[0-9]*\\.?[0-9]+)([CF]?)");

    /**
     * Parse a string, with an optional scale suffix. If no scale suffix is on the string, the defaultScale will be used.
     * 
     * @param temperature the temperature to parse
     * @param defaultScale the default scale to use
     */
    public static TemperatureAmount parse(String temperature, Unit<Temperature> defaultScale) {
        double t;
        Unit<Temperature> s;

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

        // Use the scale included with the sourceTemperature OR the defaultScale provided.
        if (matcher.find()) {
            try {
                s = valueOfAbbreviation(matcher.group());
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("You must provide a valid temperature scale- 'C|F'");
            }
        } else {
            s = defaultScale;
        }
        return new TemperatureAmount(t, s);
    }

    public TemperatureAmount(double temperature, Unit<Temperature> scale) {
        super(Double.valueOf(temperature), scale);
//    	this.temperature = temperature;
//        this.scale = scale;
    }

    public  Unit<Temperature> getScale() {
        return getUnit();
    }

    private static Unit<Temperature> valueOfAbbreviation(String value) {
        if (value == null) {
            throw new IllegalArgumentException("value must not be null");
        } else if ("C".equals(value.toUpperCase())) {
            return SI.CELSIUS;
        } else if ("F".equals(value.toUpperCase())) {
            return US.FAHRENHEIT;
        } else {
            throw new IllegalArgumentException(value + " not recognized as a valid scale");
        }
    }
    
    public double getTemperature() {
        return getValue().doubleValue();
    }

//    @Override
//    public String toString() {
//        return new DecimalFormat("###.00").format(value()) + " " + String.valueOf(unit());
//    }

}
