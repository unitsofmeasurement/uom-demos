/*
 *  Units of Measurement Demos for Java
 *  Copyright (c) 2005-2020, Jean-Marie Dautelle, Werner Keil and others.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-385, Unit-API nor the names of their contributors may be used to endorse or promote products derived from this software without specific prior written permission.
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
package tech.uom.demo.systems.historical;

import static tech.units.indriya.unit.Units.*;

import javax.measure.Unit;
import javax.measure.quantity.Length;
import javax.measure.quantity.Volume;

import tech.units.indriya.AbstractSystemOfUnits;
import tech.units.indriya.format.SimpleUnitFormat;

/**
 * <p>
 * This class contains units from the Historical Swiss units of measurement system.
 * </p>
 * <p>
 * 
 * @noextend This class is not intended to be extended by clients.
 * 
 * @author <a href="mailto:werner@uom.technology">Werner Keil</a>
 * @version 0.1, $Date: 2021-04-09 $
 * @see <a href="https://en.wikipedia.org/wiki/Swiss_units_of_measurement">Wikipedia: Swiss units of measurement</a>
 */
public final class Swiss extends AbstractSystemOfUnits {
    /**
     * Default constructor (prevents this class from being instantiated).
     */
    private Swiss() {
    }

    /**
     * The singleton instance of {@code Swiss}.
     */
    private static final Swiss INSTANCE = new Swiss();

    @Override
    public String getName() {
        return "Swiss units of measurement";
    }

    /**
     * Adds a new unit not mapped to any specified quantity type.
     *
     * @param unit
     *            the unit being added.
     * @return <code>unit</code>.
     */
    private static <U extends Unit<?>> U addUnit(U unit) {
        INSTANCE.units.add(unit);
        return unit;
    }

    /**
     * A unit of length equal to <code>0.3 m</code> (standard name <code>pied</code>).
     * One pied (1 fuss) was equal to 0.30 m, according to the fixed value defined during the transition to the metric system.
     */
    public static final Unit<Length> PIED = addUnit(METRE.multiply(0.3));
    
    /**
     * A unit of length equal to <code>1/144 pied</code> (standard name <code>ligne</code>).
     */
    public static final Unit<Length> LIGNE = addUnit(PIED.divide(144));
    
    /**
     * A unit of volume equal to <code>1.5 l</code> (standard name <code>pot</code>). 
     * 1 pot = 1.5 l (1.585 quarts).[3] Pot was the bulk of 3 livres weight of pure water at the temperature of 4° Celsius. Pot was equal to 1/18 pied3 and was subdivided into 1/2, 1/4 and 1/8
     */
    public static final Unit<Volume> POT = addUnit(LITRE.multiply(1.5));
    
    /**
     * A unit of volume equal to <code>25 pot</code> (standard name <code>sct</code>).
     */
    public static final Unit<Volume> SCTIER = addUnit(POT.multiply(25));

    // //////////////////////////////////////////////////////////////////////////
    // Label adjustments for unit system
    static {
        SimpleUnitFormat.getInstance().label(PIED, "pied");
        SimpleUnitFormat.getInstance().label(POT, "pot");
        SimpleUnitFormat.getInstance().label(SCTIER, "sct");
        SimpleUnitFormat.getInstance().label(LIGNE, "ligne");
        SimpleUnitFormat.getInstance().alias(LIGNE, "linie");    }
}
