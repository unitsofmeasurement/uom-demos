/**
 * Copyright (c) 2013-2014 Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.demo.types;

import static org.unitsofmeasurement.impl.AbstractMeasurement.NONE;
import static org.unitsofmeasurement.demo.types.SaffirSimpsonHurricaneWindScale.Category.*;

import javax.measure.Measurement;
import javax.measure.MeasurementRange;
import javax.measure.function.Nameable;
import javax.measure.quantity.Speed;

import org.unitsofmeasurement.impl.AbstractMeasurement;

/**
 * @author Werner Keil
 * @version 0.4
 * @see <a href="http://en.wikipedia.org/wiki/Saffir%E2%80%93Simpson_hurricane_wind_scale"> Wikipedia:
 *      Saffir–Simpson hurricane wind scale</a>
 */
public class SaffirSimpsonHurricaneWindScale extends MeasurementRange<Measurement<Speed, Number>>
	implements Nameable {

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
	 * @see
	 * MeasurementRange
	 */
	protected SaffirSimpsonHurricaneWindScale(Measurement<Speed, Number> min,
			Measurement<Speed, Number> max, Category level) {
		super(min, max);
		this.category = level;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * MeasurementRange
	 */
	protected SaffirSimpsonHurricaneWindScale(Measurement<Speed, Number> min,
			Measurement<Speed, Number> max) {
		this(min, max, UNKNOWN);
	}
	
    /**
     * Returns an {@code SaffirSimpsonHurricaneWindScale} with the specified values.
     *
     * @param min The minimum value for the wind scale.
     * @param max The maximum value for the wind scale.
     * @return an {@code SaffirSimpsonHurricaneWindScale} with the values present
     */
	public static final SaffirSimpsonHurricaneWindScale of(AbstractMeasurement<Speed> min, 
			AbstractMeasurement<Speed> max) {
		return new SaffirSimpsonHurricaneWindScale(min, max);
	}
	
    /**
     * Returns an {@code SaffirSimpsonHurricaneWindScale} with the specified values.
     *
     * @param min The minimum value for the wind scale.
     * @param max The maximum value for the wind scale.
     * @param cat The {@link Category} of the wind scale.
     * @return an {@code SaffirSimpsonHurricaneWindScale} with the values present
     */
	public static final SaffirSimpsonHurricaneWindScale of(AbstractMeasurement<Speed> min, 
			AbstractMeasurement<Speed> max, Category cat) {
		return new SaffirSimpsonHurricaneWindScale(min, max, cat);
	}
	
	public boolean hasMinimum() {
		return getMinimum() != null && !NONE.equals(getMinimum()) && 
				!(getMinimum().getUnit() == null || getMinimum().getValue() == null);
	}

	public boolean hasMaximum() {
		return getMaximum() != null && !NONE.equals(getMaximum()) &&
				!(getMaximum().getUnit() == null || getMaximum().getValue() == null) ;
	}
	
	@Override
	public String toString() {
		return getName() + " [category=" + category + ", minimum=" + getMinimum()
				+ ", maximum=" + getMaximum() + "]";
	}

	@Override
	public String getName() {
		return "Saffir–Simpson hurricane wind scale";
	}
}
