/*
 *  Units of Measurement Demos for Java
 *  Copyright (c) 2015-2025, Werner Keil and others.
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
package tech.uom.demo.health;

import static javax.measure.MetricPrefix.MILLI;
import static tech.units.indriya.unit.Units.SIEVERT;
import static tech.units.indriya.unit.Units.YEAR;
import static tech.uom.domain.imaging.unit.Imaging.IMAGE;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.RadiationDoseEffective;

import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.quantity.QuantityRange;
import tech.units.indriya.spi.Range;

/**
 * Limit values in radiation protection
 * 
 * @author <a href="mailto:werner@uom.technology">Werner Keil</a>
 * @see <a
 *      href="https://www.bfs.de/EN/topics/ion/radiation-protection/limit-values/limit-values_node.html">BfS:
 *      Limit values in radiation protection</a>
 * @version 1.0, Feb 7, 2025
 */
public class RadiationProtectionLimitValues {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Unit<RadiationDoseEffective> mSv = MILLI(SIEVERT);
		final Unit<?> mSvPerYear = mSv.divide(YEAR);
		final Unit<?> mSvPerImage = mSv.divide(IMAGE);
		
		final Map <Object, String> importantLimitValues  = new LinkedHashMap<>();

		Quantity<?> annualMaximumDose = Quantities.getQuantity(0.01, mSvPerYear);
		importantLimitValues.put(annualMaximumDose, "Calculated order of magnitude of the annual maximum dose for the Germany population due to nuclear power plants in normal operation." + "\n" + "(These calculations are based on conservative assumptions regarding, among other things, location and diet so that the actual exposure values are lower.)");

		Range<?> xRayDoseRange = QuantityRange.of(Quantities.getQuantity(0.01, mSvPerImage), 
				Quantities.getQuantity(0.03, mSvPerImage));
		importantLimitValues.put(xRayDoseRange, "Typical dose range for an X-ray of the thorax");
		
		Quantity<?> limitValueForAnnualRadiation = Quantities.getQuantity(1, mSvPerYear);
		importantLimitValues.put(limitValueForAnnualRadiation, "Limit value (maximum permissible dose) for annual radiation exposure of members of the general public" + "\n" + "(e.g. resulting from the release of radioactive substances from nuclear facilities)");
				
		Range<?> headCTDoseRange = QuantityRange.of(Quantities.getQuantity(1, mSvPerImage), 
				Quantities.getQuantity(3, mSvPerImage));
		importantLimitValues.put(headCTDoseRange, "Typical dose range for a cranial CT (head CT)");
		
		
		System.out.println("Important limit values and typical dose values in comparison");
		importantLimitValues.forEach((key, value) -> {
		    System.out.println(key + " :: " + value);
		});
		System.out.println();
		
		final Map <Quantity<RadiationDoseEffective>, String> importantThresholds  = new LinkedHashMap<>();
		Quantity<RadiationDoseEffective> dose = Quantities.getQuantity(100, mSv);		
		importantThresholds.put(dose, "Lower estimate for the threshold for damage to the unborn child.");
		dose = Quantities.getQuantity(1000, mSv);
		importantThresholds.put(dose, "In the case of acute exposure, acute radiation effects (e.g. headache, nausea, vomiting) occur from this threshold upwards.");
		dose = Quantities.getQuantity(2000, mSv);
		importantThresholds.put(dose, "In the case of acute exposure, reddening of the skin occurs from this threshold upwards.");
		System.out.println("Important thresholds for deterministic radiation effects");
		importantThresholds.forEach((key, value) -> {
		    System.out.println(key + " :: " + value);
		});
		
	}
}
