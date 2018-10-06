/*
 *  Units of Measurement Console Demos
 *  Copyright (c) 2005-2018, Jean-Marie Dautelle, Werner Keil and others.
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
package tech.uom.demo.systems.common;

import javax.measure.Unit;
import javax.measure.format.UnitFormat;
import javax.measure.quantity.*;
import systems.uom.common.USCustomary;
import tech.units.indriya.format.SimpleUnitFormat;
import tech.units.indriya.format.EBNFUnitFormat;
import tech.units.indriya.unit.Units;

public class CommonFormatDemo {
	public static void main(String... args) {
		UnitFormat ebnf = EBNFUnitFormat.getInstance();
	    SimpleUnitFormat.getInstance().alias(USCustomary.MILE, "mile");
	    
	    Unit u = SimpleUnitFormat.getInstance().parse("mile");
	    System.out.println(u);
	    Unit v = SimpleUnitFormat.getInstance().parse("mi");
	    System.out.println(v);
	    System.out.println();

	    Unit<Force> lbf = Units.NEWTON.multiply(4.4482216152605); // pound-force
	    Unit<Area> sqin = USCustomary.INCH.pow(2).asType(Area.class); // square inch
	    Unit<Pressure> psi = lbf.divide(sqin).asType(Pressure.class); // pound-force per square inch
	    System.out.println("Pounds per square inch: " + psi);
	    SimpleUnitFormat.getInstance().label(psi, "psi");
	    System.out.println("Pounds per square inch: " + psi);
	    System.out.println("Square psi: " + psi.pow(2));
	    System.out.println("Square psi (EBNF): " + ebnf.format(psi.pow(2)));
	    Unit u1 = SimpleUnitFormat.getInstance().parse("psi^2");
	    System.out.println("Square psi parsed: " + u1);
	    u1 = SimpleUnitFormat.getInstance().parse("psi²");
	    System.out.println("Square psi parsed (Unicode): " + u1);
	    //u1 = ebnf.parse("psi^2");
	    System.out.println();

	    Unit<Pressure> another_psi = Units.NEWTON.multiply(6895).divide(Units.SQUARE_METRE).asType(Pressure.class);
	    System.out.println("Pounds per square inch: " + another_psi);
	    SimpleUnitFormat.getInstance().label(another_psi, "psi");
	    System.out.println("Pounds per square inch: " + another_psi);
	    System.out.println("Square psi: " + another_psi.pow(2));
	    System.out.println("Square psi (EBNF): " + ebnf.format(another_psi.pow(2)));
	}
}
