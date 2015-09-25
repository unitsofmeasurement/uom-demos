/**
 *  Unit-API - Units of Measurement API for Java
 *  Copyright (c) 2005-2014, Jean-Marie Dautelle, Werner Keil, V2COM.
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
 * 3. Neither the name of JSR-363 nor the names of its contributors may be used to endorse or promote products
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
package tec.uom.demo.types.iso;

import static tec.uom.impl.enums.unit.Constants.*;
import tec.uom.impl.enums.AbstractQuantityFactory;
import tec.uom.impl.enums.DescriptiveEnum;
import tec.uom.impl.enums.function.DoubleFactorSupplier;
import tec.uom.impl.enums.quantity.SimpleDimension;

import java.util.HashMap;
import java.util.Map;

import javax.measure.Dimension;
import javax.measure.IncommensurableException;
import javax.measure.Quantity;
import javax.measure.UnconvertibleException;
import javax.measure.Unit;
import javax.measure.UnitConverter;
import javax.measure.quantity.Information;

/**
 * Implements a measure of information. The metric system unit for this quantity is "bit".
 * @author  <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.7.1 ($Revision: 444 $), $Date: 2014-03-18 23:55:19 +0100 (Di, 18 Mär 2014) $
 */
public enum BitUnit implements Unit<Information>, DoubleFactorSupplier, DescriptiveEnum<BitUnit> {
	
    BIT(BIT_NAME, 1.0), // reference Unit
    Byte(BYTE_NAME, BYTE_FACTOR),
	kb(KB_NAME, 1.0e3),
    Mb(MB_NAME, 1.0e6),
    Gb(GB_NAME, 1.0e9),
    Tb(TB_NAME, 1.012),
    Pb(PB_NAME, 1.015),
    Eb(EB_NAME, 1.018),
    KB(KBYTE_NAME, BYTE_FACTOR * 1.0e3),
    MB(MBYTE_NAME, BYTE_FACTOR * 1.0e6),
    GB(GBYTE_NAME, BYTE_FACTOR * 1.0e9),
    TB(TBYTE_NAME, BYTE_FACTOR * 1.0e12),
    PB(PBYTE_NAME, BYTE_FACTOR * 1.0e15),
    EB(EBYTE_NAME, BYTE_FACTOR * 1.0e18);

    private final String description;
    private final double multFactor;

    private BitUnit(String name, double multF) {
        this.description = name;
        this.multFactor = multF;
    }

    
    public String getSymbol() {
        return name();
    }

    
    public String getDescription() {
        return description;
    }

    
    public double getFactor() {
        return multFactor;
    }

    
	public Unit<Information> getSystemUnit() {
		return BIT;
    }

	
	public String getName() {
		return name();
	}
	
    public static BitUnit getByName(String symbol) {
        if (kb.name().equals(symbol)) {
            return kb;
        } else if (Mb.name().equals(symbol)) {
            return Mb;
        } else if (Gb.name().equals(symbol)) {
            return Gb;
        } else if (Tb.name().equals(symbol)) {
            return Tb;
        }
        return BIT;
    }

    
    public Map<Unit<?>, Integer> getProductUnits() {
        Map<Unit<?>, Integer> prodUnits = new HashMap<Unit<?>, Integer>();
        prodUnits.put(kb, Integer.valueOf(3));
        prodUnits.put(Mb, Integer.valueOf(6));
        prodUnits.put(Gb, Integer.valueOf(9));
        prodUnits.put(Tb, Integer.valueOf(12));
        prodUnits.put(Byte, Integer.valueOf((int)BYTE_FACTOR));
        prodUnits.put(KB, Integer.valueOf(3 * (int)BYTE_FACTOR));
        prodUnits.put(MB, Integer.valueOf(6 * (int)BYTE_FACTOR));
        prodUnits.put(GB, Integer.valueOf(9 * (int)BYTE_FACTOR));
        prodUnits.put(TB, Integer.valueOf(12 * (int)BYTE_FACTOR));
        return prodUnits;
    }

    
    public Unit<Information> shift(double offset) {
        return this;
    }

    
    public Unit<Information> alternate(String symbol) {
        return this;
    }

    @SuppressWarnings("unchecked")
	
    public <T extends Quantity<T>> Unit<T> asType(Class<T> type)
            throws ClassCastException {
        Unit<T> metricUnit = AbstractQuantityFactory.getInstance(type).getMetricUnit();
        if ((metricUnit == null) || metricUnit.isCompatible(this))
         return (Unit<T>) this;
          throw new ClassCastException("The unit: " + this //$NON-NLS-1$
              + " is not of parameterized type " + type); //$NON-NLS-1$
    }

    
    public Unit<Information> divide(double divisor) {
        return this;
    }

    
    public Unit<?> divide(Unit<?> that) {
        return this;
    }

    
    public UnitConverter getConverterTo(Unit<Information> that)
            throws UnconvertibleException {
        // currently unused
        return null;
    }

    
    public UnitConverter getConverterToAny(Unit<?> that)
            throws IncommensurableException, UnconvertibleException {
        // currently unused
        return null;
    }

    
    public Dimension getDimension() {
        return SimpleDimension.INSTANCE;
    }

    
    public Unit<?> inverse() {
        return this;
    }

    
    public boolean isCompatible(Unit<?> that) {
        if (that instanceof BitUnit) return true;
        return false;
    }

    
    public Unit<Information> multiply(double factor) {
        return this;
    }

    
    public Unit<?> multiply(Unit<?> that) {
    	if (!(that instanceof BitUnit)) {
    		throw new UnconvertibleException("Incompatible unit");
    	}
//        return new BitUnit(this.getSymbol(), this.longName(), 
//        		this.getMultFactor() * ((BitUnit)that).getMultFactor());
    	return this;
    }

    
    public Unit<?> pow(int n) {
        return this;
    }

    
    public Unit<?> root(int n) {
        return this;
    }

    
    public Unit<Information> transform(UnitConverter operation) {
        return this;
    }

    
    public DescriptiveEnum<BitUnit>[] iValues() {
		return BitUnit.values();
	}
}
