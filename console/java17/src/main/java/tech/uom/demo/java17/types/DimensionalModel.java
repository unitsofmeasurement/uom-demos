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
package tech.uom.demo.java17.types;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Map;

import javax.measure.Dimension;
import javax.measure.UnitConverter;

import tech.uom.demo.java17.unit.SimpleDimension;

/**
 * <p> This class represents the physical model used for dimensional analysis.</p>
 *
* <p> In principle, dimensions of physical quantities could be defined as "fundamental"
 *     (such as momentum or energy or electric current) making such quantities
 *     uncommensurate (not comparable). Modern physics has cast doubt on 
 *     the very existence of incompatible fundamental dimensions of physical quantities.
 *     For example, most physicists do not recognize temperature, 
 *     {@link QuantityDimension#TEMPERATURE Θ}, as a fundamental dimension since it 
 *     essentially expresses the energy per particle per degree of freedom, 
 *     which can be expressed in terms of energy (or mass, length, and time).
 *     To support, such model the method {@link #getConverter} may 
 *     returns a non-null value for distinct dimensions.</p> 
 *     
  * <p> The default model is {@link StandardModel Standard}. Applications may
 *     use one of the predefined model or create their own.
 *     [code]
 *     DimensionalModel relativistic = new DimensionalModel() {
 *         public Dimension getFundamentalDimension(QuantityDimension dimension) {
 *             if (dimension.equals(QuantityDimension.LENGTH)) return QuantityDimension.TIME; // Consider length derived from time.
 *                 return super.getDimension(dimension); // Returns product of fundamental dimension.
 *             }
 *             public UnitConverter getDimensionalTransform(QuantityDimension dimension) {
 *                 if (dimension.equals(QuantityDimension.LENGTH)) return new RationalConverter(1, 299792458); // Converter (1/C) from LENGTH SI unit (m) to TIME SI unit (s).
 *                 return super.getDimensionalTransform(dimension);
 *             }
 *     };
 *     LocalContext.enter();
 *     try {
 *         DimensionalModel.setCurrent(relativistic); // Current thread use the relativistic model.
 *         SI.KILOGRAM.getConverterToAny(SI.JOULE); // Allowed.
 *         ...
 *     } finally {
 *         LocalContext.exit();
 *     }
 *     [/code]</p>
 *     
 * @see <a href="http://en.wikipedia.org/wiki/Dimensional_analysis">Wikipedia: Dimensional Analysis</a>
 * @author  <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.2, $Date$
 */
public abstract class DimensionalModel {

    /**
     * Holds the current model.
     */
    private static Reference<DimensionalModel> Current = new WeakReference<DimensionalModel>(new StandardModel());

    /**
     * Returns the physics model used by the current thread
     * (by default an instance of {@link StandardModel}).
     *
     * @return the getCurrent physical model.
     * @see LocalContext
     */
    public static DimensionalModel current() {
        return DimensionalModel.Current.get();
    }

//    /**
//     * Sets the current physics model (local to the current thread when executing
//     * within a {@link LocalContext}).
//     *
//     * @param  model the context-local physics model.
//     * @see    #getCurrent
//     */
//    public static void setCurrent(DimensionalModel model) {
//        DimensionalModel.Current. .Current set(model);
//    }

    /**
     * Default constructor (allows for derivation).
     */
    protected DimensionalModel() {
    }

    /**
     * Returns the fundamental dimension for the one specified.
     * If the specified dimension is a dimensional product, the dimensional
     * product of its fundamental dimensions is returned.
     * Physical quantities are considered commensurate only if their
     * fundamental dimensions are equals using the current physics model.
     *
     * @param dimension the dimension for which the fundamental dimension is returned.
     * @return <code>this</code> or a rational product of fundamental dimension.
     */
    public Dimension getFundamentalDimension(Dimension dimension) {
        Map<? extends Dimension, Integer> dimensions = dimension.getBaseDimensions();
        if (dimensions == null) return dimension; // Fundamental dimension.
        // Dimensional Product.
        Dimension fundamentalProduct = SimpleDimension.INSTANCE;
        for (Map.Entry<? extends Dimension, Integer> e : dimensions.entrySet()) {
             fundamentalProduct = fundamentalProduct.multiply(this.getFundamentalDimension(e.getKey())).pow(e.getValue());
        }
        return fundamentalProduct;
    }

    /**
     * Returns the dimensional transform of the specified dimension.
     * If the specified dimension is a fundamental dimension or
     * a product of fundamental dimensions the identity converter is
     * returned; otherwise the converter from the system unit (SI) of
     * the specified dimension to the system unit (SI) of its fundamental
     * dimension is returned.
     *
     * @param dimension the dimension for which the dimensional transform is returned.
     * @return the dimensional transform (identity for fundamental dimensions).
     */
    public UnitConverter getDimensionalTransform(Dimension dimension) {
        Map<? extends Dimension, Integer> dimensions = dimension.getBaseDimensions();
        if (dimensions == null) return AbstractConverter.IDENTITY; // Fundamental dimension.
        // Dimensional Product.
        UnitConverter toFundamental = AbstractConverter.IDENTITY;
        for (Map.Entry<? extends Dimension, Integer> e : dimensions.entrySet()) {
            UnitConverter cvtr = this.getDimensionalTransform(e.getKey());
            if (!(cvtr.isLinear()))
                throw new UnsupportedOperationException("Non-linear dimensional transform");
            int pow = e.getValue();
            if (pow < 0) { // Negative power.
                pow = -pow;
                cvtr = cvtr.inverse();
            }
            for (int j = 0; j < pow; j++) {
                toFundamental = toFundamental.concatenate(cvtr);
            }
        }
        return toFundamental;
    }

}
