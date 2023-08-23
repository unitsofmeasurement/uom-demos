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

import java.util.Objects;

import javax.measure.Quantity;

/**
 * A Quantity Range is a pair of {@link Quantity} items that represent a range
 * of values.
 * <p>
 * Range limits MUST be presented in the same scale and have the same unit as
 * measured data values.<br>
 * Subclasses of QuantityRange should be <code>final</code> and immutable.
 * 
 * @param <Q> The value of the range.
 * 
 * @author <a href="mailto:werner@units.tech">Werner Keil</a>
 * @version 1.0, Aug 23, 2023
 */
public record QuantityRange<Q extends Quantity<Q>>(Quantity<Q> minimum, Quantity<Q> maximum) {    
	public boolean contains(final Quantity<Q> q) {
		Objects.requireNonNull(q);
		return q.getValue() != null && q.getUnit() != null && 
				q.getUnit().equals(minimum.getUnit()) && 
				q.getUnit().equals(maximum.getUnit()) && 
				minimum.getValue().doubleValue() < q.getValue().doubleValue() &&
				maximum.getValue().doubleValue() > q.getValue().doubleValue();
	}
}