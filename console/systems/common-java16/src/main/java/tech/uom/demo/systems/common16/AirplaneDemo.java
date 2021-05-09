/*
 *  Units of Measurement Console Demos
 *  Copyright (c) 2005-2021, Werner Keil and others.
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
package tech.uom.demo.systems.common16;

import static systems.uom.common.USCustomary.MILE_PER_HOUR;
import static systems.uom.common.USCustomary.MILE;
import static tech.units.indriya.unit.Units.HOUR;
import static tech.units.indriya.unit.Units.KILOMETRE_PER_HOUR;

import java.time.Duration;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Time;

import tech.units.indriya.AbstractQuantity;
import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.quantity.time.TemporalQuantity;
import tech.units.indriya.quantity.time.TimeQuantities;
import tech.uom.demo.systems.common16.types.Airplane;

/**
 * This is a simple example for an In-Flight Infotainment (IFI) system showing the plane's cruising speed or time to destination.
 * 
 * @author Werner Keil
 * @see <a href="https://en.wikipedia.org/wiki/In-flight_entertainment">Wikipedia: In-flight entertainment</a>
 */
public class AirplaneDemo {

    public static void main(String[] args) {
        final String model;
        double dist;
        if (args != null && args.length > 0) {
            dist = Double.parseDouble(args[0]);
            if (args.length > 1) {
                model = args[1];
            } else {
                model = "A380";
            }
        } else { // default fallback
            dist = 6089d;
            model = "A380";
        }
        // TODO make distance parseable as a quantity like "6089 mi" or similar
        var distance = Quantities.getQuantity(dist, MILE);
        var airplane = new Airplane(model);
        var airplaneSpeed = airplane.getSpeed();
        System.out.println(airplane + " flying " + airplaneSpeed);
        System.out.println(airplane + " flying " + airplaneSpeed.to(MILE_PER_HOUR));
        var timeToDest = distance.divide(airplaneSpeed).asType(Time.class);

        var tuqToDest = TimeQuantities.toTemporalSeconds(timeToDest);
        System.out.println("TTD: " + timeToDest.to(HOUR));
        System.out.println("TTD (Duration): " + Duration.from(tuqToDest.getTemporalAmount()));
    }
}