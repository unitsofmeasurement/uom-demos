/*
 *  Units of Measurement Demos for Java
 *  Copyright (c) 2005-2023, Werner Keil and others.
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
package tech.uom.demo.java17.quantity;

import static javax.measure.Quantity.Scale.*;

import javax.measure.Quantity;
import javax.measure.UnconvertibleException;
import javax.measure.Unit;
import javax.measure.UnitConverter;
import javax.measure.quantity.Temperature;

import tech.uom.demo.java17.unit.TemperatureUnit;
import tech.uom.lib.common.function.QuantityConverter;

/**
 * @author Werner Keil
 * @version 1.3, $Date: 2023-08-22 $
 */
public record TemperatureQuantity(double scalar, double value, TemperatureUnit unit) implements 
Quantity<Temperature>, QuantityConverter<Temperature>, Comparable<Quantity<Temperature>> {
    
    public TemperatureQuantity(Number val, TemperatureUnit u) {
    	this(0d, val.doubleValue(), u);
    }
    
	public Quantity<Temperature> multiply(Number that) {
		return new TemperatureQuantity(value * that.doubleValue(), unit);
	}
	
	public Quantity<?> multiply(Quantity<?> that) {
		return new TemperatureQuantity(value * that.getValue().doubleValue(), unit);
	}
    
	public Quantity<?> divide(Quantity<?> that) {
		return divide(that.getValue());
	}

	public Quantity<Temperature> subtract(Quantity<Temperature> that) {
    	final TemperatureQuantity dn = new TemperatureQuantity(
                this.value- that.getValue().doubleValue(), this.unit);
        return dn;
	}

	public Number getValue() {
		 return value;
	}

	public Unit<Temperature> getUnit() {
		 return unit;
	}

	public Quantity<Temperature> inverse() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Quantity<Temperature> to(Unit<Temperature> unit) {
        if (this.unit.equals(unit)) {
            return this;
        }
        if (unit instanceof TemperatureUnit) {
        	return convert((TemperatureUnit)unit);
        } else {
        	throw new ArithmeticException("Cannot convert " + this.unit + " to " + unit);
        }
	}

    protected TemperatureQuantity convert(TemperatureUnit newUnit) {
        return new TemperatureQuantity(value /  
                newUnit.getFactor(), newUnit);
    }
    
	@Override
	public Quantity<Temperature> negate() {
		return new TemperatureQuantity(-value, unit);
	}

	@Override
	public Quantity<Temperature> add(Quantity<Temperature> addend) {
        final TemperatureQuantity dn = new TemperatureQuantity(Double.valueOf(
                this.value + addend.getValue().doubleValue()),
        		this.unit);
        return dn;
	}

	@Override
	public Quantity<Temperature> divide(Number divisor) {
		return new TemperatureQuantity(value / divisor.doubleValue(), unit);
	}
	
	@Override
	public boolean isEquivalentTo(Quantity<Temperature> that) {
		return this.compareTo(that) == 0;
	}
		
	public int compareTo(Quantity<Temperature> o) {
		return 0;
	}

	@Override
	public <T extends Quantity<T>> Quantity<T> asType(Class<T> type) throws ClassCastException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scale getScale() {
		return (TemperatureUnit.KELVIN.equals(unit) ? 
                ABSOLUTE : RELATIVE);
	}
	

    protected boolean eq(TemperatureQuantity dq) {
         return dq!=null && dq.getValue().equals(getValue()) && 
                 dq.getUnit().equals(getUnit()) &&
                 (dq.scalar() == scalar());
    }

    boolean ne(TemperatureQuantity d1) {
        return ne((TemperatureQuantity) d1);
    }

    boolean gt(TemperatureQuantity d1) {
        return gt((TemperatureQuantity) d1);
    }

    boolean lt(TemperatureQuantity d1) {
        return lt((TemperatureQuantity) d1);
    }

    boolean ge(TemperatureQuantity d1) {
        return ge((TemperatureQuantity)d1);
    }

    boolean le(TemperatureQuantity d1) {
        return le((TemperatureQuantity) d1);
    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Quantity#doubleValue(javax.measure.Unit)
	 */
	protected double doubleValue(Unit<Temperature> unit) {
		Unit<Temperature> myUnit = getUnit();
		try {
			UnitConverter converter = unit.getConverterTo(myUnit);
			return converter.convert(getValue().doubleValue());
		} catch (UnconvertibleException e) {
			throw e;
		}
	}    
}
