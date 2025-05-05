/*
 * Units of Measurement Demos Java
 * Copyright (c) 2005-2020, Werner Keil and others.
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
package tech.uom.demo.java17;

import tech.uom.demo.java17.quantity.QuantityRange;
import tech.uom.demo.java17.types.Person;

import static tech.units.indriya.quantity.Quantities.getQuantity;
import static tech.units.indriya.unit.Units.KILOGRAM;
import static tech.units.indriya.unit.Units.METRE;

import javax.measure.quantity.Mass;

/**
 * @version 0.7
 * @author werner
 */
public class PersonDemo {

    public static void main(String[] args) {
        var height = getQuantity(1.8, METRE);
    	var person1 = new Person("John", "Doe", height, getQuantity(80, KILOGRAM));
        System.out.println(person1);
        System.out.println(person1.getFullName());
        var min = getQuantity(50, KILOGRAM);
        var max = getQuantity(100, KILOGRAM);
        var range = new QuantityRange<Mass>(min, max, null);
        System.out.println(range);
        if (range.contains(person1.mass())) {
        	System.out.println("mass within range.");
        } else {
        	System.out.println("mass not within range.");
        }
        var range2 = tech.units.indriya.quantity.QuantityRange.of(min, max);
        System.out.println(range2);
    }
}
