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

import static tech.units.indriya.unit.Units.CELSIUS;
import static tech.units.indriya.unit.Units.KELVIN;
//import static tec.uom.se.unit.US.FAHRENHEIT;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.measure.Quantity;
import javax.measure.quantity.Temperature;

/**
 * A simple SLSB EJB. The EJB does not use an interface.
 * 
 * @author Bruce Wolfe
 * @author Werner Keil
 */
@Stateless
public class TemperatureConvertEJB {

    /**
     * This method takes a temperature in Celsius or Fahrenheit and converts it to the other value.
     * 
     * @param source the temperature to convert from
     * @return the converted temperature.
     */
    public Quantity<Temperature> convert(TemperatureAmount source) {
        
        // Convert our Temperature
        if (source.getReference() == CELSIUS) { // Celsius to Fahrenheit (Kelvin)
            // Easter egg for Absolute Zero.
            if (source.getTemperature() < TemperatureAmount.ABSOLUTE_ZERO_C) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Below Absolute Zero!"));
            } else if (source.getTemperature() == TemperatureAmount.ABSOLUTE_ZERO_C) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Absolute Zero!"));
            }
            return source.to(KELVIN);
            //return new TemperatureAmount( (source.getTemperature() * 9 / 5) + 32, FAHRENHEIT);
        } else if (source.getReference() == KELVIN) { // Fahrenheit to Celsius
            // Easter egg for Absolute Zero.
            if (source.getTemperature() < TemperatureAmount.ABSOLUTE_ZERO_F) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Below Absolute Zero!"));
            } else if (source.getTemperature() == TemperatureAmount.ABSOLUTE_ZERO_F) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Absolute Zero!"));
            }
            return source.to(CELSIUS);
            //return new TemperatureAmount( (source.getTemperature() - 32) * 5 / 9, CELSIUS);
        } else { // Should never get here!
            throw new IllegalStateException("This is embarrassing - this error should NOT occur!");
        }
    }
}
