/*
 *  Unit-API - Units of Measurement API for Java
 *  Copyright (c) 2005-2015, Jean-Marie Dautelle, Werner Keil, V2COM.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-363, Unit-API nor the names of their contributors may be used to endorse or promote products derived from this software without specific prior written permission.
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
package tec.uom.demo.types;

import static tec.uom.demo.types.SaffirSimpsonHurricaneWindScale.Category.*;
import static tec.units.ri.AbstractQuantity.NONE;

import javax.measure.Quantity;
import javax.measure.quantity.Speed;

import tec.units.ri.function.Nameable;
import tec.units.ri.quantity.QuantityRange;

/**
 * @author Werner Keil
 * @version 0.7.1, Aug 16, 2015
 * @see <a
 *      href="http://en.wikipedia.org/wiki/Saffir%E2%80%93Simpson_hurricane_wind_scale">
 *      Wikipedia: Saffir–Simpson hurricane wind scale</a>
 */
public class SaffirSimpsonHurricaneWindScale extends QuantityRange<Speed> implements Nameable {

	/**
	 * The storm category
	 */
	public static enum Category {
		UNKNOWN, TROPICAL_DEPRESSION, TROPICAL_STORM, ONE, TWO, THREE, FOUR, FIVE
	}

	private final Category category;

	public Category getCategory() {
		return category;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see Range
	 */
	protected SaffirSimpsonHurricaneWindScale(Quantity<Speed> min,
			Quantity<Speed> max, Category level) {
		super(min, max);
		this.category = level;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see Range
	 */
	protected SaffirSimpsonHurricaneWindScale(Quantity<Speed> min,
			Quantity<Speed> max) {
		this(min, max, UNKNOWN);
	}

	/**
	 * Returns an {@code SaffirSimpsonHurricaneWindScale} with the specified
	 * values.
	 *
	 * @param min
	 *            The minimum value for the wind scale.
	 * @param max
	 *            The maximum value for the wind scale.
	 * @return an {@code SaffirSimpsonHurricaneWindScale} with the values
	 *         present
	 */
	public static final SaffirSimpsonHurricaneWindScale of(Quantity<Speed> min,
			Quantity<Speed> max) {
		return new SaffirSimpsonHurricaneWindScale(min, max);
	}

	/**
	 * Returns an {@code SaffirSimpsonHurricaneWindScale} with the specified
	 * values.
	 *
	 * @param min
	 *            The minimum value for the wind scale.
	 * @param max
	 *            The maximum value for the wind scale.
	 * @param cat
	 *            The {@link Category} of the wind scale.
	 * @return an {@code SaffirSimpsonHurricaneWindScale} with the values
	 *         present
	 */
	public static final SaffirSimpsonHurricaneWindScale of(Quantity<Speed> min,
			Quantity<Speed> max, Category cat) {
		return new SaffirSimpsonHurricaneWindScale(min, max, cat);
	}

	@Override
	public boolean hasMinimum() {
		return getMinimum() != null
				&& !NONE.equals(getMinimum())
				&& !(getMinimum().getUnit() == null || getMinimum().getValue() == null);
	}

	@Override
	public boolean hasMaximum() {
		return getMaximum() != null
				&& !NONE.equals(getMaximum())
				&& !(getMaximum().getUnit() == null || getMaximum().getValue() == null);
	}

	@Override
	public String toString() {
		return getName() + " [category=" + category + ", minimum="
				+ getMinimum() + ", maximum=" + getMaximum() + "]";
	}

	@Override
    	public String getName() {
		return "Saffir–Simpson hurricane wind scale";
	}
}
