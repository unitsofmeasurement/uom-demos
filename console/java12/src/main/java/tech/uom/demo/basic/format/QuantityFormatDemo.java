/*
 *  Units of Measurement Demos for Java
 *  Copyright (c) 2005-2024, Werner Keil and others.
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
 * 3. Neither the name of JSR-385, Units of Measurement nor the names of their contributors may be used to endorse or promote products
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
package tech.uom.demo.basic.format;

import tech.units.indriya.format.FormatBehavior;
import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.format.NumberDelimiterQuantityFormat;
import tech.units.indriya.format.SimpleUnitFormat;

import static javax.measure.MetricPrefix.KILO;
import static tech.units.indriya.unit.Units.VOLT;

import java.text.CompactNumberFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class QuantityFormatDemo {

    public static void main(String[] args) {
    	
        var quantFormat = NumberDelimiterQuantityFormat.getInstance(FormatBehavior.LOCALE_NEUTRAL);
        var vQuant = Quantities.getQuantity(10000, VOLT);
        System.out.println(quantFormat.format(vQuant));
        var vQuant2 = Quantities.getQuantity(10, KILO(VOLT));
        System.out.println(quantFormat.format(vQuant2));
        System.out.println(vQuant.isEquivalentTo(vQuant2));
    	
        quantFormat = new NumberDelimiterQuantityFormat.Builder()
                .setNumberFormat(NumberFormat.getCompactNumberInstance(Locale.ROOT, NumberFormat.Style.SHORT))
                .setUnitFormat(SimpleUnitFormat.getInstance()).build();
        vQuant = Quantities.getQuantity(10000, VOLT);
        System.out.println(quantFormat.format(vQuant));
        vQuant2 = Quantities.getQuantity(10, KILO(VOLT));
        System.out.println(quantFormat.format(vQuant2));
        System.out.println(vQuant.isEquivalentTo(vQuant2));
        
/*      This only works after Java 16 or by removing the module-info. 
        var symbols = DecimalFormatSymbols.getInstance(Locale.ROOT);
        String[] cnPatterns = new String [] {"", ""};
        var compactFormat = new CompactNumberFormat("",
                        symbols, cnPatterns);
        var quantFormat2 = NumberDelimiterQuantityFormat.getCompactInstance(compactFormat, SimpleUnitFormat.getInstance());
*/        
    }
}
