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

import static javax.measure.MetricPrefix.*;
import static tech.units.indriya.unit.Units.*;

import java.util.Objects;

import javax.measure.Unit;
import javax.measure.quantity.Length;
import javax.measure.quantity.Volume;

import tech.units.indriya.AbstractSystemOfUnits;
import tech.units.indriya.format.SimpleUnitFormat;

/**
 * <p>
 * This class contains units from the Historical Hungarian system.
 * </p>
 * <p>
 * 
 * @noextend This class is not intended to be extended by clients.
 * 
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.3, $Date: 2020-02-11 $
 * @see <a href="http://en.wikipedia.org/wiki/Hungarian_units_of_measurement">Wikipedia: Hungarian units of measurement</a>
 */
public final class Hungarian extends AbstractSystemOfUnits {
    /**
     * Default constructor (prevents this class from being instantiated).
     */
    private Hungarian() {
    }

    /**
     * The singleton instance of {@code Health}.
     */
    private static final Hungarian INSTANCE = new Hungarian();

    @Override
    public String getName() {
        return "Hungarian units of measurement";
    }

    // TODO can remove after upgrade to Indriya 2
    @Override
    public Unit<?> getUnit(String string) {
        Objects.requireNonNull(string);
        return this.getUnits().stream().filter((u) -> string.equals(u.toString())).findAny().orElse(null);
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
     * A unit of length equal to <code>8.3536 km</code> (standard name <code>mtf</code>).
     */
    public static final Unit<Length> MERTFOELD = addUnit(KILO(METRE).multiply(8.3536));

    /**
     * A unit of volume equal to <code>54.30 l</code> (standard name <code>e</code>). While a bit larger, the eimer would roughly be comparable to a
     * "pitcher" of beer or a similar drink.
     */
    public static final Unit<Volume> EIMER = addUnit(LITRE.multiply(54.30));

    // //////////////////////////////////////////////////////////////////////////
    // Label adjustments for Hungarian system
    static {
        SimpleUnitFormat.getInstance().label(MERTFOELD, "mtf");
        SimpleUnitFormat.getInstance().label(EIMER, "e");
    }
}
