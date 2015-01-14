/**
 *  Unit-API - Units of Measurement API for Java
 *  Copyright 2013-2015, Jean-Marie Dautelle, Werner Keil, V2COM and individual
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
package tec.uom.demo.health;

import static tec.uom.demo.health.BMIRange.Category.*;
import static tec.units.ri.AbstractQuantity.NONE;

import javax.measure.Quantity;

import tec.units.ri.function.Nameable;
import tec.units.ri.util.Range;

/**
 * @author Werner Keil
 * @version 0.2
 * @see <a href="http://en.wikipedia.org/wiki/Body_Mass_index"> Wikipedia:
 *      BMI</a>
 */
public class BMIRange extends Range<Quantity<?>> implements Nameable {

	/**
	 * The category
	 */
	public static enum Category {
		/* ?, lt15, 15-16, 16-18.5, 18.5-25, 25-30, 30-35, 35-40, over 40 */
		UNKNOWN, VERY_SEVERELY_UNDERWEIGHT, SEVERELY_UNDERWEIGHT, UNDERWEIGHT, NORMAL, OVERWEIGHT, OBESE_CLASS_I, OBESE_CLASS_II, OBESE_CLASS_III
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
	protected BMIRange(Quantity<?> min, Quantity<?> max, Category level) {
		super(min, max);
		this.category = level;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Range
	 */
	protected BMIRange(Quantity<?> min, Quantity<?> max) {
		this(min, max, UNKNOWN);
	}

	/**
	 * Returns an {@code BMIRange} with the specified values.
	 *
	 * @param min
	 *            The minimum value for the BMI.
	 * @param max
	 *            The maximum value for the BMI.
	 * @return an {@code BMIRange} with the values present
	 */
	public static final BMIRange of(Quantity<?> min, Quantity<?> max) {
		if (min.getValue().doubleValue() <= 15) {
			return new BMIRange(min, max, Category.VERY_SEVERELY_UNDERWEIGHT);
		} else if (min.getValue().doubleValue() == 15
				&& max.getValue().doubleValue() == 16) {
			return new BMIRange(min, max, Category.SEVERELY_UNDERWEIGHT);
		} else if (min.getValue().doubleValue() == 16
				&& max.getValue().doubleValue() == 18.5) {
			return new BMIRange(min, max, Category.UNDERWEIGHT);
		} else if (min.getValue().doubleValue() == 18.5
				&& max.getValue().doubleValue() == 25) {
			return new BMIRange(min, max, Category.NORMAL);
		} else if (min.getValue().doubleValue() == 25
				&& max.getValue().doubleValue() == 30) {
			return new BMIRange(min, max, Category.OVERWEIGHT);
		} else if (min.getValue().doubleValue() == 30
				&& max.getValue().doubleValue() == 35) {
			return new BMIRange(min, max, Category.OBESE_CLASS_I);
		} else if (min.getValue().doubleValue() == 35
				&& max.getValue().doubleValue() == 40) {
			return new BMIRange(min, max, Category.OBESE_CLASS_II);
		} else if (min.getValue().doubleValue() >= 40) {
			return new BMIRange(min, max, Category.OBESE_CLASS_III);
		}
		return new BMIRange(min, max);
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
		return getClass().getSimpleName();
	}

	@Override
	public boolean contains(Quantity<?> q) {
		if (q.getUnit().equals(getMinimum().getUnit())) {
			// TODO better null checks
			if (q.getValue().doubleValue() >= getMinimum().getValue().doubleValue() &&
					q.getValue().doubleValue() <= getMaximum().getValue().doubleValue()) {
				return true;
			}
		}
		return false;
	}
}
