/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
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
package org.jboss.as.quickstarts.temperatureconverter.controller;

import java.util.Set;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

import tech.units.indriya.AbstractUnit;
import tech.units.indriya.unit.UnitDimension;
import tech.units.indriya.unit.Units;

import javax.measure.quantity.Temperature;
import javax.measure.Unit;

/**
 * A JSF converter that can handle the {@link Temperature} reference unit.
 * 
 * @author Pete Muir
 * @author Werner Keil
 * 
 */
@Named
public class ScaleConverter implements Converter {
	Unit<?>[] temps = new Unit<?>[]{ Units.CELSIUS, Units.KELVIN }; // TODO use .FAHRENHEIT again, to
	
    @SuppressWarnings("unchecked")
	public Unit<?>[] getReferences() {
        return ((Set<? extends Unit<Temperature>>) Units.getInstance().getUnits(UnitDimension.TEMPERATURE)).toArray(temps);
    } // TODO other unit systems like US?

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent cmp, String value) {
        if ("on".equals(value)) {
        	return Units.CELSIUS;
        }
    	return AbstractUnit.parse(value);
    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent cmp, Object value) {
        if (value instanceof AbstractUnit<?>) {
            return ((AbstractUnit<?>) value).getName();
        } else {
            throw new IllegalStateException();
        }
    }
}
