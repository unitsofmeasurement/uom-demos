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

package org.jboss.as.quickstarts.temperatureconverter.controller;

import java.util.Set;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

import tec.uom.ri.AbstractUnit;
import tec.uom.ri.util.SI;
import tec.uom.ri.model.QuantityDimension;
import tec.uom.ri.util.US;
import javax.measure.quantity.Temperature;
import javax.measure.Unit;

/**
 * A JSF converter that can handle the {@link Temperature} unit.
 * 
 * @author Pete Muir
 * @author Werner Keil
 * 
 */
@Named
public class ScaleConverter implements Converter {
	Unit<?>[] temps = new Unit<?>[]{ SI.CELSIUS, US.FAHRENHEIT };
	
    @SuppressWarnings("unchecked")
	public Unit<?>[] getScales() {
        return ((Set<? extends Unit<Temperature>>) US.getInstance().getUnits(QuantityDimension.TEMPERATURE)).toArray(temps);
    }

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent cmp, String value) {
        if ("on".equals(value)) {
        	return SI.CELSIUS;
        }
    	return AbstractUnit.of(value);
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