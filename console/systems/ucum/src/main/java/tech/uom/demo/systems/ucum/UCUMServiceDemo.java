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

import static javax.measure.spi.FormatService.FormatType.UNIT_FORMAT;

import java.util.List;

import javax.measure.Unit;
import javax.measure.format.UnitFormat;
import javax.measure.spi.ServiceProvider;
import javax.measure.spi.FormatService;

/**
 * UCUM Service Demo
 * @author Werner
 * @version 1.0
 */
public class UCUMServiceDemo {

    public static void main(String[] args) {
        for (ServiceProvider provider : ServiceProvider.available()) {
            System.out.println(String.valueOf(provider.getClass().getSimpleName()));
        }
        
        System.out.println();
        System.out.println(ServiceProvider.current());
        
        for (String formatName : ServiceProvider.current().getFormatService().getAvailableFormatNames(UNIT_FORMAT)) {
            System.out.println(formatName);
        }
        
    	UnitFormat unitFormat = ServiceProvider.current().getFormatService().getUnitFormat("UCUM");
    	System.out.println("Format: " + unitFormat);
    	
    	UnitFormat cs = ServiceProvider.current().getFormatService().getUnitFormat("CS");
    	System.out.println("Format 2: " + cs);
    	Unit<?> unit = cs.parse("m/s");
    	System.out.println(unit);
    	
    	unitFormat = ServiceProvider.current().getFormatService().getUnitFormat("UCUM", "CI");
    	System.out.println("Format: " + unitFormat);
    	
    	//System.out.println("Square m (EBNF): " + ebnf.parse("m^2"));
    	ServiceProvider defaultProvider = ServiceProvider.current();
        for (ServiceProvider provider : ServiceProvider.available()) {
            if ("DefaultServiceProvider".equals(provider.getClass().getSimpleName())) {
                defaultProvider = provider;
                break;
            }
        }
        final UnitFormat f = defaultProvider.getFormatService().getUnitFormat();
        System.out.println("Square m: " + f.parse("m^2"));
        
        List<ServiceProvider> providers = ServiceProvider.available();
        ServiceProvider ucumProvider = providers.get(0);
        FormatService ucumFormatService = ucumProvider.getFormatService();
        UnitFormat ucumFormatter = ucumFormatService.getUnitFormat("CS");
        System.out.println("m3 dimension =" + ucumFormatter.parse("m3").getDimension());        
        System.out.println("ft3 (wrong) dimension =" + ucumFormatter.parse("ft3").getDimension());
        System.out.println("ft3 dimension =" + ucumFormatter.parse("[cft_i]").getDimension());        
    }
}
