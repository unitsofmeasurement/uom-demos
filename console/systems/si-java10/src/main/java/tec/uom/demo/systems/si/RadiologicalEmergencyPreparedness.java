package tec.uom.demo.systems.si;

import static si.uom.NonSI.ROENTGEN;
import static javax.measure.MetricPrefix.MILLI;

import java.util.HashMap;
import java.util.Map;

import javax.measure.Quantity;

import si.uom.quantity.IonizingRadiation;
import tech.units.indriya.quantity.Quantities;

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
