package tec.uom.demo.systems.historical;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Volume;

import tec.units.ri.quantity.Quantities;
import tec.units.ri.unit.Units;

public class HistoricalSystemsDemo {

	public static void main(String[] args) {
		Quantity<Length> mertfoelds = Quantities.getQuantity(10, Hungarian.MERTFOELD);
		System.out.println(mertfoelds);
		
		Quantity<Volume> eimer = Quantities.getQuantity(2, Hungarian.EIMER);
		System.out.println(eimer);
		Quantity<Volume> inLiter = eimer.to(Units.LITRE);
		System.out.println(inLiter);
	}
}
