/*
 *  Units of Measurement Demos for Java
 *  Copyright (c) 2005-2015, Jean-Marie Dautelle, Werner Keil, V2COM.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 *    and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the names of JSR-363, Units of Measurement nor the names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
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
package medemo;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Temperature;
import javax.measure.quantity.Time;
import javax.microedition.midlet.MIDlet;

import tech.units.indriya.unit.Units;
import tec.uom.lib.common.function.Nameable;
import tech.units.indriya.quantity.Quantities;

/**
 * @author Werner Keil
 * @version 0.7, April 18, 2016
 */
public class Medemo extends MIDlet implements Nameable {
	private final String appName = "ME Demo";
	private Quantity<Time> time;
	private Double d;
	
	@Override
	public void startApp() {
		d = Double.valueOf(10d);
		//quantity = new TimeAmount(10d, TimeUnit.MINUTE);
                time = Quantities.getQuantity(d, Units.MINUTE);
		Quantity<Temperature> temp = 
                        //new TemperatureAmount(10d, TemperatureUnit.CELSIUS);
                        Quantities.getQuantity(d, Units.CELSIUS);
//        UnitFormat asciiFmt = SimpleUnitFormat.getInstance(SimpleUnitFormat.Flavor.ASCII);            
//		String celAscii = asciiFmt.format(Units.CELSIUS);
		
		Unit<Length> dist = 
                        //DistanceUnit.METRE;
                        Units.METRE;
		Quantity<Length> len = Quantities.getQuantity(d, dist);
        Quantity<Mass> mass = Quantities.getQuantity(90, Units.KILOGRAM);
		System.out.println();
		System.out.println("Hello " + appName);
		System.out.println();
		System.out.println(time);
		System.out.println(temp);
//		System.out.println(celAscii);
		System.out.println(len);
		System.out.println(mass);
		Quantity<Mass> inGram = mass.to(Units.GRAM);
		System.out.println(inGram);
	}

	@Override
	public void destroyApp(boolean unconditional) {
		time = null;
		d = null;
	}

	@Override
	public String getName() {
		return appName;
	}
}
