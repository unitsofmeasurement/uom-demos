package tec.uom.demo.systems.si;

import static tec.units.ri.unit.Units.*;
import static tec.units.ri.unit.MetricPrefix.MILLI;
import static si.uom.SI.*;
import static si.uom.NonSI.ROENTGEN;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Angle;
import javax.measure.quantity.Mass;

import si.uom.NonSI;
import si.uom.SI;
import tec.units.ri.AbstractQuantity;
import tec.units.ri.quantity.NumberQuantity;
import tec.units.ri.quantity.Quantities;

import java.util.HashMap;
import java.util.Map;

import javax.measure.Quantity;
import si.uom.quantity.IonizingRadiation;

/**
 * @author <a href="mailto:uomo@catmedia.us">Werner Keil</a>
 * 
 * @see <a
 *      href="http://www.nema.ne.gov/technological/dose-limits.html">NEMA:
 *      Radiological Emergency Preparedness</a>
 */
public class RadiologicalEmergencyPreparedness {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map <Quantity<IonizingRadiation>, String> repMap = new HashMap<Quantity<IonizingRadiation>, String>();
		Quantity<IonizingRadiation> ira = Quantities.getQuantity(500, MILLI(ROENTGEN));
		
		repMap.put(ira, String.format("Call supervisor for further instructions. Dosimeter reading up to and including %s allowed for emergency Worker assignments.", ira));
		ira = Quantities.getQuantity(1, ROENTGEN);
		repMap.put(ira, "Turn-back dose for Emergency Workers with no means of communication with supervisor. Dose allowed for assignments involving protection of valuable property.");
		ira = Quantities.getQuantity(2.5, ROENTGEN);
		repMap.put(ira, "Dose allowed for assignments involving LIFESAVING protection of large populations.");
		
		for (Quantity<IonizingRadiation> dosimeterLimit : repMap.keySet()) {			
			System.out.println(dosimeterLimit + " :: " + repMap.get(dosimeterLimit));
		}
		
	}

}