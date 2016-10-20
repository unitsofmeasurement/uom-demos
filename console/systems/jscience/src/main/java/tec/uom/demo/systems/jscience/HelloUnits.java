package tec.uom.demo.systems.jscience;

import javax.measure.Measurable;
import javax.measure.Measure;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.unit.NonSI;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;


/**
 * @author Werner Keil
 * This is a back-port of UOMo HelloUnits to prove similar behavior, 
 * especially for Bugzilla item 338334  
 */
public class HelloUnits {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		Measure length = Measure.valueOf(10, SI.METRE);
//		LengthAmount length = new LengthAmount(10, SI.KILOGRAM); // this won't work ;-)
		
		System.out.println(length);
		Unit<Length> lenUnit =  length.getUnit();
		System.out.println(lenUnit);
		
		System.out.println(length.doubleValue(NonSI.FOOT)); 
//		System.out.println(length.doubleValue(USCustomary.POUND)); // this won't work either.
//		UnitConverter footConverter = lenUnit.getConverterTo(NonSI.INCH);
		System.out.print(((Measurable<Length>)length).doubleValue(NonSI.INCH));
		System.out.println(" " + NonSI.FOOT);
		
		Measurable<Mass> mass = Measure.valueOf(1000, SI.GRAM);
		Measurable<Mass> mass2 = Measure.valueOf(1, SI.KILOGRAM);
		System.out.println(mass.equals(mass2));
	}
}