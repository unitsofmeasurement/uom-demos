/*
 *  Units of Measurement Demos for Java
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
 * 3. Neither the name of JSR-385, Units of Measurement nor the names of their contributors may be used to endorse or promote products derived from this software without specific prior written permission.
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
package tech.uom.demo.energy;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.measure.Quantity;
import javax.measure.Quantity.Scale;
import javax.measure.Unit;
import javax.measure.quantity.Energy;
import javax.measure.quantity.Power;
import javax.measure.quantity.Temperature;
import javax.measure.quantity.Time;
import javax.measure.quantity.Volume;

import static javax.measure.MetricPrefix.KILO;
import static javax.measure.MetricPrefix.MILLI;

import tech.units.indriya.format.SimpleUnitFormat;
import tech.units.indriya.function.RationalNumber;
import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.unit.Units;

/**
 * 
 * @author Werner
 * @author Andi Huber
 * @see <a href="http://www.dagego.de/info_waermebedarf.html">Dageto
 *      Wärmebedarfsermittlung (DE)</a>
 * @version 0.9
 */
public class HeatRequirementDemo {

    public static void main(String[] args) {

        // When 1 cal of heat energy is transferred to one gram (1 g) of pure liquid water, 
        // the temperature of that sample of water is raised by one degree Celsius (1º C) 
        // or one degree Kelvin (1º K)
        //
        // One gram of pure liquid water has a volume of one centimeter cubed (1 cm3) or 
        // one milliliter (1 ml).

        // definitions
        final Unit<Energy> UNIT_KILO_WATT_HOUR = KILO(Units.WATT.multiply(Units.HOUR)).asType(Energy.class);
        final Unit<Energy> UNIT_CAL = Units.JOULE.multiply(RationalNumber.of(4184, 1000)); // as per definition
        final Unit<Volume> UNIT_MILLILITRE = MILLI(Units.LITRE);
        final Quantity<?> ENERGY_NEEDED_PER_MILLILITRE_AND_KELVIN =
                Quantities.getQuantity(1, UNIT_CAL.divide(Units.KELVIN).divide(UNIT_MILLILITRE));

        // customize formatting
        SimpleUnitFormat.getInstance().label(UNIT_KILO_WATT_HOUR, "kWh");

        // given
        final Quantity<Volume> givenVolume = Quantities.getQuantity(1000, Units.LITRE);
        final Quantity<Temperature> deltaT = Quantities.getQuantity(20, Units.CELSIUS, Scale.RELATIVE);

        // question (1)
        print("what_work_is_required_to_heat_water", givenVolume);

        // whats the energy requirement we need to put into given volume to heat it up a temperature amount of deltaT?
        final Quantity<Energy> energyRequirementToHeatUpGivenVolume = 
                ENERGY_NEEDED_PER_MILLILITRE_AND_KELVIN
                .multiply(givenVolume) // 1000 Litre
                .multiply(deltaT) // 20ºC
                .asType(Energy.class); 

        // convert to kWh
        final Quantity<Energy> kWh = energyRequirementToHeatUpGivenVolume
                .to(UNIT_KILO_WATT_HOUR);

        print("%s", kWh);

        // question (2)
        // how long does it take to heat up given volume of water (delta 20ºC),
        // if we put given power (9.5kW) into our heater?

        final Quantity<Power> givenPower = Quantities.getQuantity(9.5, KILO(Units.WATT));

        final Quantity<Time> timeRequired = kWh.divide(givenPower).asType(Time.class)
                .to(Units.HOUR);

        print("If_only_s_are_available_it_will_take_longer", givenPower);
        print("Namely", timeRequired);
    }

    // -- LOCALIZED PRINTING

    static ResourceBundle resourceBundle;

    private static void print(final String format, final Object ...args) {
        if(resourceBundle == null) {
            // using German locale 
            resourceBundle = ResourceBundle.getBundle("Labels", Locale.GERMAN);
        }
        try {
            System.out.println(String.format(resourceBundle.getString(format), args));    
        } catch (Exception e) {
            // fallback to simple printing
            System.out.println(String.format(format, args));
        }

    }

}
