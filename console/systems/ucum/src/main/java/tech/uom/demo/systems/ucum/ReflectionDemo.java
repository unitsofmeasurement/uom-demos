/*
 *  Units of Measurement Console Demos
 *  Copyright (c) 2005-2017, Werner Keil and others.
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
package tech.uom.demo.systems.ucum;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Volume;

import tec.units.indriya.unit.Units;
import systems.uom.ucum.UCUM;
import tec.units.indriya.unit.BaseUnit;

public class ReflectionDemo {
	public static void reflect(final Unit<?> aUnit) {
//	public static <U extends Unit<Q>, Q extends Quantity<Q>> void reflect(final U aUnit) {
		// Here I'd like to get the Class-Object 'Length'
		System.out.print("aUnit: ");
//		System.out.println(aUnit.getClass().getGenericInterfaces().length);
		System.out.println(aUnit.getClass().getGenericSuperclass().getClass().getName());
//		System.out.println(aUnit.getClass().getGenericSuperclass().getClass().getGenericInterfaces().length);
		final Type i  = aUnit.getClass().getGenericSuperclass().getClass().getGenericInterfaces()[0];
		System.out.println("I: " + i);
		System.out.println("A: " + i.getClass().getAnnotatedInterfaces()[0].getType());
		final ParameterizedType p = (ParameterizedType) aUnit.getClass().getGenericSuperclass();
		System.out.println("T: " + p.getTypeName());
//		System.out.println("R: " + p.getRawType());
		final Type at = p.getActualTypeArguments()[0];
		System.out.println("TN: " + at.getTypeName());
		System.out.println("U: " + aUnit);

//		System.out.print("anotherUnit: ");
//		final Unit<Volume> anotherUnit = aUnit.multiply(aUnit).asType(Volume.class);
//		System.out.println(anotherUnit.getClass().getGenericSuperclass());
//		System.out.println(((ParameterizedType) anotherUnit.getClass()
//				.getGenericSuperclass()).getActualTypeArguments()[0]);
//		// System.out.println(((ParameterizedType) anotherUnit.getClass()
//		// .getGenericSuperclass()).getActualTypeArguments().length);
//		System.out.println(anotherUnit);
	}

	public static void main(String... args) {
		reflect(new BaseUnit<Length>("m"));
//		Unit<Length> len = new BaseUnit<Length>("m");
		Unit<Length> len = Units.METRE;
		reflect(len.multiply(len)); // this works under SE 8u20
		reflect(len.multiply(len).asType(Area.class));  // this won't compile under SE 8u20
		
		for (Unit<?> u : Units.getInstance().getUnits()) {
			reflect(u);
		}
		
//		for (Unit<?> u : UCUM.getInstance().getUnits()) {
//			reflect(u);
//		}
	}
}
