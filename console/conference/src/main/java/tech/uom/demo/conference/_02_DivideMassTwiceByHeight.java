/*
 *  Units of Measurement Conference Demos for Java
 *  Copyright (c) 2019-2020, Werner Keil, Filip Van Laenen and others.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of Units of Measurement nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
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
package tech.uom.demo.conference;
import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.unit.Units;

public class _02_DivideMassTwiceByHeight {

	public static void main(String[] args) {
		final Quantity<Mass> mass = Quantities.getQuantity(88, Units.KILOGRAM);
		System.out.println(mass);
		final Quantity<Length> height = Quantities.getQuantity(1.88, Units.METRE);
		System.out.println(height);
		final Quantity<?> bmi1 = mass.divide(height).divide(height);
		System.out.println(bmi1);
		final Quantity<?> bmi2 = mass.divide(height.multiply(height));
		System.out.println(bmi2);
	}
}