/*
 *  Units of Measurement Demos for Java
 *  Copyright (c) 2015-2020, Werner Keil and others.
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
package tech.uom.demo.systems.historical;

import static systems.uom.ucum.UCUM.ROENTGEN;
import static javax.measure.MetricPrefix.MILLI;

import java.util.HashMap;
import java.util.Map;

import javax.measure.Quantity;

import si.uom.quantity.IonizingRadiation;
import tech.units.indriya.quantity.Quantities;

/**
 * @author <a href="mailto:werner@uom.technology">Werner Keil</a>
 * 
 * @see <a
 *      href="http://www.nema.ne.gov/technological/dose-limits.html">NEMA:
 *      Radiological Emergency Preparedness</a>
 * @version 1.0, Feb 7, 2025
 */
//TODO consider moving this to Health demos
public class RadiologicalEmergencyPreparedness {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Map <Quantity<IonizingRadiation>, String> repMap = new HashMap<>();
		Quantity<IonizingRadiation> ira = Quantities.getQuantity(500, MILLI(ROENTGEN));
		
		repMap.put(ira, String.format("Call supervisor for further instructions. Dosimeter reading up to and including %s allowed for emergency Worker assignments.", ira));
		ira = Quantities.getQuantity(1, ROENTGEN);
		repMap.put(ira, "Turn-back dose for Emergency Workers with no means of communication with supervisor. Dose allowed for assignments involving protection of valuable property.");
		ira = Quantities.getQuantity(2.5, ROENTGEN);
		repMap.put(ira, "Dose allowed for assignments involving LIFESAVING protection of large populations.");
		
		for (Quantity<IonizingRadiation> dosimeterLimit : repMap.keySet()) {			
			System.out.println(dosimeterLimit + " :: " + repMap.get(dosimeterLimit));
		}
	}
}
