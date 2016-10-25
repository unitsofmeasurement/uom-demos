/*
 *  Units of Measurement Demos for Java
 *  Copyright (c) 2005-2016, Jean-Marie Dautelle, Werner Keil, V2COM.
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
package tec.uom.demo.systems.common;

import static tec.units.ri.unit.MetricPrefix.KILO;
import static tec.units.ri.unit.Units.HOUR;
import static tec.units.ri.unit.Units.KILOMETRES_PER_HOUR;
import static tec.units.ri.unit.Units.METRE;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Time;

import systems.uom.common.USCustomary;
import tec.units.ri.AbstractQuantity;
import tec.units.ri.quantity.Quantities;

/**
 * This is a simple example for an In-Flight Infotainment (IFI) system showing
 * the plane's cruising speed or time to destination.
 * 
 * @author Werner Keil
 * @see <a href=
 *      "https://en.wikipedia.org/wiki/In-flight_entertainment">Wikipedia:
 *      In-flight entertainment</a>
 */
public class AirplaneDemo {

    public static void main(String[] args) {
	final String model;
	final double dist;
	if (args != null && args.length > 0) {
	    dist = Double.parseDouble(args[0]);
	    if (args.length > 1) {
		model = args[1];
	    } else {
		model = "A380";
	    }
	} else {
	    dist = 6089d;
	    model = "A380";
	}

	Quantity<Length> distance = Quantities.getQuantity(dist, KILO(METRE));
	Airplane airplane = new Airplane(model);
	System.out.println(airplane + " flying " + distance);
	Quantity<Speed> airplaneSpeed = airplane.getSpeed();
	System.out.println(airplane + " flying at " + airplaneSpeed);
	System.out.println(airplane + " flying at " + airplaneSpeed.to(USCustomary.MILE_PER_HOUR));
	// Quantity<Time> eta = (Quantity<Time>)distance.divide(airplaneSpeed);
	Quantity<Time> timeToDest = distance.divide(airplaneSpeed).asType(Time.class);
	System.out.println("TTD: " + timeToDest.to(HOUR));
	// System.out.println("ETA: " + eta.to(Units.HOUR)); // XXX ETA could be
	// done based on current time
    }

    private static class Airplane {
	private final String id;

	private Airplane(String id) {
	    this.id = id;
	}

	final Quantity<Speed> getSpeed() {
	    switch (id) {
	    case "A380":
		return Quantities.getQuantity(945, KILOMETRES_PER_HOUR);
	    // Airbus A 380 Cruise speed
	    case "B777":
		return Quantities.getQuantity(892, KILOMETRES_PER_HOUR);
	    // Boeing 777 Cruise speed, see
	    // https://en.wikipedia.org/wiki/Boeing_777#Specifications
	    default:
		return AbstractQuantity.NONE.asType(Speed.class);
	    }
	}

	@Override
	public String toString() {
	    return "Airplane [" + id + "]";
	}
    }
}