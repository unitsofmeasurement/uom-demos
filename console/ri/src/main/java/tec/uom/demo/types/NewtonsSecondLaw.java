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
package tec.uom.demo.types;

import tec.units.ri.quantity.AccelerationAmount;
import tec.units.ri.quantity.ForceAmount;
import tec.units.ri.quantity.MassAmount;
import tec.units.ri.util.SI;

/**
 *
 * @author Chris Senior
 * @author Werner Keil
 *
 */
public class NewtonsSecondLaw {

	public static final ForceAmount calculateForce(MassAmount m, AccelerationAmount a) {
		double m_kg = m.doubleValue(SI.KILOGRAM);
		double a_si = a.doubleValue(SI.METRES_PER_SQUARE_SECOND);

		return new ForceAmount(m_kg * a_si, SI.NEWTON);
	}
}
