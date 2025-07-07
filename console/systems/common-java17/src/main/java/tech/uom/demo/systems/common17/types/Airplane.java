/*
 *  Units of Measurement Console Demos
 *  Copyright (c) 2005-2025, Werner Keil and others.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-385, Unit-API nor the names of their contributors may be used to endorse or promote products derived from this software without specific prior written permission.
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
package tech.uom.demo.systems.common17.types;

import static tech.units.indriya.unit.Units.KILOMETRE_PER_HOUR;

import javax.measure.Quantity;
import javax.measure.quantity.Speed;

import tech.units.indriya.AbstractQuantity;
import tech.units.indriya.quantity.Quantities;

/**
 * This is a demonstrator for the Java 17 {@link Record} preview and the new <code>switch</code> expression.
 * @author Werner Keil
 *
 */
public record Airplane( String model) {

    public final Quantity<Speed> getSpeed() {
    	return switch (model) {        	
    		case "A350" ->  Quantities.getQuantity(910, KILOMETRE_PER_HOUR); // Airbus A 350 Cruise speed    
    		case "A380" ->  Quantities.getQuantity(945, KILOMETRE_PER_HOUR); // Airbus A 380 Cruise speed
            case "B747" -> Quantities.getQuantity(933, KILOMETRE_PER_HOUR); // Jumbo Cruise speed
            case "B777" -> Quantities.getQuantity(892, KILOMETRE_PER_HOUR);
            // Boeing 777 Cruise speed, see https://en.wikipedia.org/wiki/Boeing_777#Specifications
            case "B787" -> Quantities.getQuantity(903, KILOMETRE_PER_HOUR);
            // Boeing 787 Cruise speed, see https://en.wikipedia.org/wiki/Boeing_787_Dreamliner#Specifications
            default -> AbstractQuantity.NONE.asType(Speed.class);
        };
    }
}
