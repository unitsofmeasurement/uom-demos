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
package space.uom.demo.planet;

import javax.measure.Unit;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import tech.units.indriya.AbstractQuantity;
import tech.units.indriya.quantity.DefaultQuantityFactory;

class SolarSystem {
    // universal gravitational constant  (m3 kg-1 s-2)
    static final double G = 6.67300E-11;
    
    @SuppressWarnings("unchecked")
	static AbstractQuantity<Mass> newMass(double value, Unit<Mass> unit) {
        return (AbstractQuantity<Mass>) DefaultQuantityFactory.getInstance(Mass.class).create(value, unit);
    }

    @SuppressWarnings("unchecked")
	static AbstractQuantity<Length> newLength(double value, Unit<Length> unit) {
        return (AbstractQuantity<Length>) DefaultQuantityFactory.getInstance(Length.class).create(value, unit);
    }
}
