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
package tech.uom.demo.retail.types;

import static systems.uom.common.USCustomary.FOOT;
import static systems.uom.common.USCustomary.INCH;

import javax.measure.Quantity;
import javax.measure.quantity.Length;

import tech.uom.lib.common.function.Coded;
import tech.uom.lib.common.function.Nameable;
import tech.uom.lib.common.function.QuantitySupplier;
import tech.units.indriya.quantity.Quantities;

public enum ContainerHeight implements QuantitySupplier<Length>, Nameable, Coded<String> {
    H0("8 Foot Container Height", "0", Quantities.getQuantity(8, FOOT)), 
    H2("8 Foot 6 Inch Container Height", "2", H0.getQuantity().add(Quantities.getQuantity(6, INCH)));

    private final String name;
    private final String code;
    private final Quantity<Length> quantity;

    private ContainerHeight(final String name, final String code, final Quantity<Length> q) {
        this.code = code;
        this.name = name;
        this.quantity = q;
    }

    @Override
    public Quantity<Length> getQuantity() {
        return quantity;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name;
    }
}
