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
package space.uom.demo.planet;

import static tec.units.ri.internal.format.OutputHelper.println;
import static org.junit.Assert.*;

import org.junit.Test;

import space.uom.demo.planet.DwarfPlanet;
import space.uom.demo.planet.Planet;

/**
 * @author Werner Keil
 * @version 1.2
 */
public class PlanetsTest {

	@Test
	public void testPlanets() {
		Celestial[] planets = Planet.values();
		assertNotNull(planets);
		println("Planets");
		for (Celestial planet : planets) {
			println(planet);
		}
		assertEquals(8, planets.length);
	}

	@Test
	public void testDwarfPlanets() {
		Celestial[] dwarfPlanets = DwarfPlanet.values();
		assertNotNull(dwarfPlanets);
		println("Dwarf Planets");
		for (Celestial planet : dwarfPlanets) {
			println(planet);
		}
		assertEquals(5, dwarfPlanets.length);
	}
}
