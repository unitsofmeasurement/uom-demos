/*
 *  Unit-API - Units of Measurement API for Java
 *  Copyright (c) 2005-2016, Jean-Marie Dautelle, Werner Keil, V2COM.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-363, Unit-API nor the names of their contributors may be used to endorse or promote products derived from this software without specific prior written permission.
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
package tec.uom.demo.types;

import static systems.uom.common.Imperial.PINT;
import static tec.units.ri.unit.Units.LITRE;

import javax.measure.Unit;
import javax.measure.quantity.Volume;

import tec.units.ri.AbstractSystemOfUnits;
import tec.units.ri.format.SimpleUnitFormat;

/**
 * <p>
 * This class contains units of beer measurement.
 * </p>
 * <p>
 * 
 * @noextend This class is not intended to be extended by clients.
 * 
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.1, $Date: 2016-04-17 $
 * @see <a href="http://www.bier-entdecken.de/chubel/">Ich hätte gern ein Chübel</a>
 * @see <a href="https://en.wikipedia.org/wiki/Ma%C3%9F">Wikipedia:
 *      Maß</a>
 */
public final class BeerUnits extends AbstractSystemOfUnits {
	/**
	 * Default constructor (prevents this class from being instantiated).
	 */
	private BeerUnits() {
	}

	/**
	 * The singleton instance of {@code Health}.
	 */
	private static final BeerUnits INSTANCE = new BeerUnits();

	@Override
	public String getName() {
		return "Beer units of measurement";
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
	 * Ein Schoppen – zuerst ein niederdeutsches Wort, das ins Französische
	 * entlehnt und von dort ins Oberdeutsche rückentlehnt worden und verwandt
	 * mit schöpfen ist – ist ursprünglich ein Gefäß für Flüssigkeiten, später
	 * ein Hohl- bzw. Raummaß für Getränke..
	 * 
	 * @see <a href="https://de.wikipedia.org/wiki/Schoppen">Wikipedia:
	 *      Schoppen</a>
	 */
	public static final Unit<Volume> SCHOPPEN_BAYERN = addUnit(LITRE.multiply(0.50));

	/**
	 * Ein Maßkrug ist ein Bierkrug, der das Volumen einer Maß fasst. Auf
	 * Bairisch und Schwäbisch heißt sie die Mass ([mas], mit kurzem a wie in
	 * massig), in anderen Gegenden das Maß ([maːs], mit langem a wie in
	 * Maßband). „Eine Maß“ entsprach ursprünglich 1,069 Liter und wurde mit dem
	 * metrischen System zu genau einem Liter.
	 * 
	 * @see <a href="https://de.wikipedia.org/wiki/Ma%C3%9Fkrug">Wikipedia:
	 *      Maßkrug</a>
	 */
	public static final Unit<Volume> MASS_HISTORIC = addUnit(PINT.multiply(1.881));

	// //////////////////////////////////////////////////////////////////////////
	// Label adjustments for Beer system
	static {
		SimpleUnitFormat.getInstance().label(SCHOPPEN_BAYERN, "sch");
		SimpleUnitFormat.getInstance().label(MASS_HISTORIC, "mas");
	}
}
