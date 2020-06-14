/*
 *  Units of Measurement Console Demos
 *  Copyright (c) 2005-2020, Werner Keil and others.
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
package tech.uom.demo.systems.ucum;

import static systems.uom.ucum.UCUM.*;

import javax.measure.quantity.Pressure;
import javax.measure.spi.ServiceProvider;

import tech.units.indriya.format.SimpleUnitFormat;
import tech.units.indriya.format.EBNFUnitFormat;
import javax.measure.MetricPrefix;
import tech.units.indriya.unit.Units;

public class UCUMFormatDemo {

    public static void main(String[] args) {
        final var ucumFormatCI = ServiceProvider.current().getUnitFormatService().getUnitFormat("CI");
        final var microliter = MetricPrefix.MICRO(Units.LITRE);
        System.out.println(ucumFormatCI.format(microliter)); // prints "nst"!
        var conv = microliter.getConverterTo(STERE);
        System.out.println(conv);
        var conv2 = microliter.getConverterTo(Units.CUBIC_METRE);
        System.out.println(conv2);

        final var microliter2 = ucumFormatCI.parse("uL");
        System.out.println(ucumFormatCI.format(microliter2));

        final var ucumFormatCS = ServiceProvider.current().getUnitFormatService().getUnitFormat("CS");
        final var microliter3 = ucumFormatCS.parse("ul");
        System.out.println(ucumFormatCS.format(microliter3));

        final var invKelvin = ucumFormatCI.parse("1/K");
        System.out.println(invKelvin);
        System.out.println();

        final var ebnf = EBNFUnitFormat.getInstance();
        final var ucumFormatPrint = ServiceProvider.current().getUnitFormatService().getUnitFormat("Print");

        //Unit<Force> lbf = Units.NEWTON.multiply(4.4482216152605); // pound-force
        //Unit<Area> sqin = USCustomary.INCH.pow(2).asType(Area.class); // square inch
        var psi = POUND_FORCE.divide(SQUARE_INCH_INTERNATIONAL).asType(Pressure.class); // pound-force per square inch
        System.out.println("Pounds per square inch: " + psi);
        SimpleUnitFormat.getInstance().label(psi, "psi");
        System.out.println("Pounds per square inch: " + psi);
        System.out.println("Square psi: " + psi.pow(2));
        System.out.println("Square psi (EBNF): " + ebnf.format(psi.pow(2)));
        System.out.println("Square psi (UCUM): " + ucumFormatPrint.format(psi.pow(2)));
        System.out.println("Square psi (UCUM CS): " + ucumFormatCS.format(psi.pow(2)));
        var u1 = SimpleUnitFormat.getInstance().parse("psi^2");
        System.out.println("Square psi parsed: " + u1);
        u1 = SimpleUnitFormat.getInstance().parse("psi²");
        System.out.println("Square psi parsed (Unicode): " + u1);
        /*
        u1 = SimpleUnitFormat.getInstance().parse("lb²·(m/s²)*9.80665²/c(cm*254.0)^4");
        u1 = ebnf.parse("psi^2");
        System.out.println("Square psi parsed (EBNF): " + u1);
        u1 = ebnf.parse("g_n²·lb_av²/in_i⁴");
        System.out.println("Square psi parsed (EBNF 2): " + u1);
        */

        u1 = ucumFormatCS.parse("[g]2.[lb_av]2/[in_i]4");
        System.out.println("Square psi parsed (UCUM CS): " + u1);
        System.out.println();

        var anotherPsi = Units.NEWTON.multiply(6895).divide(Units.SQUARE_METRE).asType(Pressure.class);
        System.out.println("Pounds per square inch: " + anotherPsi);
        SimpleUnitFormat.getInstance().label(anotherPsi, "psi");
        System.out.println("Pounds per square inch: " + anotherPsi);
        System.out.println("Square psi: " + anotherPsi.pow(2));
        System.out.println("Square psi (EBNF): " + ebnf.format(anotherPsi.pow(2)));
        System.out.println("Square psi (UCUM): " + ucumFormatPrint.format(anotherPsi.pow(2)));
    }
}
