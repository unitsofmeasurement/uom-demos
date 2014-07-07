/**
 *  Unit-API - Units of Measurement API for Java
 *  Copyright 2013-2014, Jean-Marie Dautelle, Werner Keil, V2COM and individual
 *  contributors by the @author tag.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.unitsofmeasurement.demo.types;

import static org.unitsofmeasurement.ri.AbstractQuantity.NONE;
import static org.unitsofmeasurement.demo.types.SaffirSimpsonHurricaneWindScale.Category.*;

import javax.measure.Quantity;
import javax.measure.function.Nameable;
import javax.measure.quantity.Speed;
import javax.measure.util.Range;

/**
 * @author Werner Keil
 * @version 0.5
 * @see <a
 *      href="http://en.wikipedia.org/wiki/Saffir%E2%80%93Simpson_hurricane_wind_scale">
 *      Wikipedia: Saffir–Simpson hurricane wind scale</a>
 */
public class SaffirSimpsonHurricaneWindScale extends Range<Quantity<Speed>>
		implements Nameable {

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

	public String getName() {
		return "Saffir–Simpson hurricane wind scale";
	}
}
