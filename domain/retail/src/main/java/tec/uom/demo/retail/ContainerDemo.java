/*
 * Units of Measurement Demos
 * Copyright © 2005-2018, Werner Keil and others.
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
 * 3. Neither the name of JSR-363, Unit-API nor the names of their contributors may be used to endorse or promote products
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
package tec.uom.demo.retail;

import static tec.uom.demo.retail.types.ContainerHeight.H0;
import static tec.uom.demo.retail.types.ContainerHeight.H2;
import static tec.uom.demo.retail.types.ContainerLength.L2;
import static tec.uom.demo.retail.types.ContainerLength.L4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.measure.Quantity;
import javax.measure.quantity.Length;

import tec.uom.demo.retail.types.Container;
import tech.units.indriya.function.QuantityStreams;
import tech.units.indriya.function.QuantitySummaryStatistics;
import tech.units.indriya.unit.Units;

public class ContainerDemo {

    public static void main(String[] args) {
        final Collection<Container> terminal = new ArrayList<>();
        Container container = new Container(L2, H0, "G0");
        terminal.add(container);
        container = new Container(L2, H2, "G1");
        terminal.add(container);
        container = new Container(L4, H2, "G0");
        terminal.add(container);

        List<Quantity<Length>> lengths = new ArrayList<>();
        for (Container cont : terminal) {
            System.out.println("ISO: " + cont.getCode());
            lengths.add(cont.getLength().getQuantity());
        }

        QuantitySummaryStatistics<Length> summary = lengths.stream().collect(QuantityStreams.summarizeQuantity(Units.METRE));
 
        System.out.println("Containers: " + summary.getCount());
        System.out.println("Average length: " + summary.getAverage());
        System.out.println("Max length: " + summary.getMax());
        System.out.println("Min length: " + summary.getMin());
        System.out.println("Total length: " +summary.getSum());
    }

}
