/*
 *  Units of Measurement Console Demos
 *  Copyright (c) 2005-2023, Werner Keil and others.
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

import static javax.measure.spi.FormatService.FormatType.UNIT_FORMAT;

import javax.measure.spi.ServiceProvider;

import tech.units.indriya.format.SimpleUnitFormat;
import tech.units.indriya.unit.Units;

public class UCUMServiceDemo {

    public static void main(String[] args) {
        ServiceProvider.available().forEach(p -> System.out.println(p.getClass().getSimpleName()));
        
        System.out.println();
        System.out.println(String.format("Current provider: %s", ServiceProvider.current()));
        
        ServiceProvider.current().getFormatService().
          getAvailableFormatNames(UNIT_FORMAT).forEach(System.out::println);
        
    	var unitFormat = ServiceProvider.current().getFormatService().getUnitFormat("UCUM");
    	System.out.println(unitFormat);
    	
    	var cs = ServiceProvider.current().getFormatService().getUnitFormat("CS");
    	System.out.println(cs);
    	var unit = cs.parse("m/s");
    	System.out.println(unit);
    	
    	ServiceProvider defaultProvider = null;
        for (ServiceProvider provider : ServiceProvider.available()) {
            if ("DefaultServiceProvider".equals(provider.getClass().getSimpleName())) {
                defaultProvider = provider;
                break;
            }
        }
        System.out.println(defaultProvider);
        
        final var f = SimpleUnitFormat.getInstance();
        System.out.println("Square m: " + f.parse("m^2"));
        var squareM = Units.SQUARE_METRE;
        System.out.println(squareM);
        
        var providers = ServiceProvider.available();
        var ucumProvider = providers.get(0);
        var ucumFormatService = ucumProvider.getFormatService();
        var ucumFormatter = ucumFormatService.getUnitFormat("CS");
        System.out.println("m3 dimension =" + ucumFormatter.parse("m3").getDimension());        
        System.out.println("ft3 (wrong) dimension =" + ucumFormatter.parse("ft3").getDimension());
        System.out.println("ft3 dimension =" + ucumFormatter.parse("[cft_i]").getDimension());
    }
}
