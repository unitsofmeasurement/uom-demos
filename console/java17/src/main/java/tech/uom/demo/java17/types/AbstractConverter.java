/*
 * Units of Measurement Enum Implementation
 * Copyright © 2005-2021, Werner Keil and others.
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
 * 3. Neither the name of JSR-385, Unit-API nor the names of their contributors may be used to endorse or promote products
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
package tech.uom.demo.java17.types;

import java.util.ArrayList;
import java.util.List;

import javax.measure.UnitConverter;

/**
 * <p> The base class for our {@link UnitConverter} physics implementations.</p>
 *
 * @author  <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.7.1, $Date: 2014-09-07 $
 */
public abstract class AbstractConverter implements UnitConverter {
	
    /**
	 * 
	 */
	//private static final long serialVersionUID = 5790242858468427131L;

	/**
     * The ratio of the circumference of a circle to its diameter.
     **/
    protected static final double PI = 3.1415926535897932384626433832795;
    
    /**
     * Holds identity converter.
     */
    public static final AbstractConverter IDENTITY = new Identity();

    /**
     * Default constructor.
     */
    protected AbstractConverter() {
    }

    /**
     * Concatenates this physics converter with another physics converter.
     * The resulting converter is equivalent to first converting by the
     * specified converter (right converter), and then converting by
     * this converter (left converter).
     *
     * @param that the other converter.
     * @return the concatenation of this converter with that converter.
     */
    public AbstractConverter concatenate(AbstractConverter that) {
        return (that == IDENTITY) ? this : new Pair(this, that);
    }

    public boolean isIdentity() {
        return false;
    }

    @Override
    public abstract boolean equals(Object cvtr);

    @Override
    public abstract int hashCode();

    public abstract AbstractConverter inverse();

    public UnitConverter concatenate(UnitConverter converter) {
        return (converter == IDENTITY) ? this : new Pair(this, converter);
    }

    public List<? extends UnitConverter> getConversionSteps() {
        List<AbstractConverter> converters = new ArrayList<AbstractConverter>();
        converters.add(this);
        return converters;
    }

    public Number convert(Number value) {
        return convert(Double.valueOf(value.doubleValue()));
    }

    public abstract double convert(double value);
    		    
    /**
     * This class represents the identity converter (singleton).
     */
    private static final class Identity extends AbstractConverter {

        @Override
        public boolean isIdentity() {
            return true;
        }

        @Override
        public Identity inverse() {
            return this;
        }

        @Override
        public double convert(double value) {
            return value;
        }


        @Override
        public UnitConverter concatenate(UnitConverter converter) {
            return converter;
        }

        @Override
        public boolean equals(Object cvtr) {
            return (cvtr instanceof Identity) ? true : false;
        }

        @Override
        public int hashCode() {
            return 0;
        }

        public boolean isLinear() {
            return true;
        }
    }

    /**
     * This class represents converters made up of two or more separate
     * converters (in matrix notation <code>[pair] = [left] x [right]</code>).
     */
    private static final class Pair extends AbstractConverter {

        /**
         * Holds the first converter.
         */
        private UnitConverter left;

        /**
         * Holds the second converter.
         */
        private UnitConverter right;

        /**
         * Creates a converter pair from the combined
         * transformation of the specified converters.
         *
         * @param  left the left converter.
         * @param  right the right converter.
         */
        public Pair(UnitConverter left, UnitConverter right) {
            this.left = left;
            this.right = right;
        }

        public boolean isLinear() {
            return left.isLinear() && right.isLinear();
        }

        @Override
        public boolean isIdentity() {
            return false;
        }

        @Override
        public List<UnitConverter> getConversionSteps() {
            final List<UnitConverter> steps = new ArrayList<UnitConverter>();
            List<? extends UnitConverter> leftCompound = left.getConversionSteps();
            List<? extends UnitConverter> rightCompound = right.getConversionSteps();
            steps.addAll(leftCompound);
            steps.addAll(rightCompound);
            return steps;
        }

        @Override
        public Pair inverse() {
            return new Pair(right.inverse(), left.inverse());
        }

        @Override
        public double convert(double value) {
            return left.convert(right.convert(value));
        }

        @Override
        public boolean equals(Object cvtr) {
            if (this == cvtr) return true;
            if (!(cvtr instanceof Pair)) return false;
            Pair that = (Pair) cvtr;
            return (this.left.equals(that.left)) && (this.right.equals(that.right));
        }

        @Override
        public int hashCode() {
            return left.hashCode() + right.hashCode();
        }

    }

}
