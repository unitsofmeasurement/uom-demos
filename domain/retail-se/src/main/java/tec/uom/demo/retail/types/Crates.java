/*
 * Units of Measurement Demos
 * Copyright © 2005-2016, Jean-Marie Dautelle, Werner Keil, V2COM.
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
package tec.uom.demo.retail.types;

import java.util.Map;

import javax.measure.Dimension;
import javax.measure.IncommensurableException;
import javax.measure.Quantity;
import javax.measure.UnconvertibleException;
import javax.measure.Unit;
import javax.measure.UnitConverter;

import tec.uom.domain.retail.Crate;
import tec.uom.lib.common.function.ValueSupplier;

public enum Crates implements Unit<Crate>, ValueSupplier<Integer> {
    DOZEN("Dozen", "d", 12), // reference Unit
    SIXPACK("Half a Dozen", "hd", 6);

    private final String symbol;
    private final String name;
    private final Integer value;

    private Crates(final String name, final String symbol, Integer val) {
	this.symbol = symbol;
	this.name = name;
	this.value = val;
    }

    @Override
    public Integer getValue() {
	return value;
    }

    @Override
    public String getSymbol() {
	return symbol;
    }

    @Override
    public String getName() {
	return name;
    }

    @Override
    public Dimension getDimension() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Unit<Crate> getSystemUnit() {
	return DOZEN;
    }

    @Override
    public Map<? extends Unit<?>, Integer> getBaseUnits() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public boolean isCompatible(Unit<?> that) {
	return this.equals(that);
    }

    @Override
    public <T extends Quantity<T>> Unit<T> asType(Class<T> type)
	    throws ClassCastException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public UnitConverter getConverterTo(Unit<Crate> that)
	    throws UnconvertibleException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public UnitConverter getConverterToAny(Unit<?> that)
	    throws IncommensurableException, UnconvertibleException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Unit<Crate> alternate(String symbol) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Unit<Crate> shift(double offset) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Unit<Crate> multiply(double multiplier) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Unit<?> multiply(Unit<?> multiplier) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Unit<?> inverse() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Unit<Crate> divide(double divisor) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Unit<?> divide(Unit<?> divisor) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Unit<?> root(int n) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Unit<?> pow(int n) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Unit<Crate> transform(UnitConverter converter) {
	// TODO Auto-generated method stub
	return null;
    }

    public Map getProductUnits() {
	throw new UnsupportedOperationException("Use getBaseUnits() instead");
    }
}
