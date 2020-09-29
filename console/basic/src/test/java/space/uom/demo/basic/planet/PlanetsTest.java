/*
 *  Unit-API - Units of Measurement API for Java
 *  Copyright 2013-2019, Jean-Marie Dautelle, Werner Keil and individual
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
package space.uom.demo.basic.planet;

import static org.junit.jupiter.api.Assertions.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import tech.uom.demo.basic.planet.Celestial;
import tech.uom.demo.basic.planet.DwarfPlanet;
import tech.uom.demo.basic.planet.Planet;

/**
 * @author Werner Keil
 * @version 1.4
 */
public class PlanetsTest {
	static final Logger logger = Logger.getLogger(PlanetsTest.class.getName());

	@Test
	public void testPlanets() {
		Celestial[] planets = Planet.values();
		assertNotNull(planets);
		logger.log(Level.INFO, "Planets");
		for (Celestial planet : planets) {
			logger.log(Level.INFO, String.valueOf(planet));
		}
		assertEquals(8, planets.length);
	}

	@Test
	public void testDwarfPlanets() {
		Celestial[] dwarfPlanets = DwarfPlanet.values();
		assertNotNull(dwarfPlanets);
		logger.log(Level.INFO, "Dwarf Planets");
		for (Celestial planet : dwarfPlanets) {
			logger.log(Level.INFO, String.valueOf(planet));
		}
		assertEquals(5, dwarfPlanets.length);
	}
}
