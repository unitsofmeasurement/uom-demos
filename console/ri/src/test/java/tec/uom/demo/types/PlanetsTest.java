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

import static tec.uom.ri.util.OutputHelper.println;
import static org.junit.Assert.*;

import org.junit.Test;

import tec.uom.demo.types.DwarfPlanet;
import tec.uom.demo.types.Planet;


/**
 * @author Werner Keil
 * @version 1.1
 */
public class PlanetsTest {

	@Test
	public void testPlanets() {
		Planet[] planets = Planet.values();
		assertNotNull(planets);
		println("Planets");
		for (Planet planet : planets) {
			println(planet);
		}
		assertEquals(8, planets.length);
	}

	@Test
	public void testDwarfPlanets() {
		DwarfPlanet[] dwarfPlanets = DwarfPlanet.values();
		assertNotNull(dwarfPlanets);
		println("Dwarf Planets");
		for (DwarfPlanet planet : dwarfPlanets) {
			println(planet);
		}
		assertEquals(5, dwarfPlanets.length);
	}
}
