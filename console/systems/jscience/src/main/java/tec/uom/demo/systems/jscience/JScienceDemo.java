package tec.uom.demo.systems.jscience;

import javax.measure.Measurable;
import javax.measure.quantity.*;
import static javax.measure.unit.SI.*;

import javax.measure.DecimalMeasure;

import static javax.measure.unit.NonSI.*;

public class JScienceDemo {
  public static void main(String[] args) {
    // Conversion between units.
    System.out.println(KILO(METER).getConverterTo(MILE).convert(10.0));
    // Retrieval of the system unit (identifies the measurement type).
    System.out.println(REVOLUTION.divide(MINUTE).getStandardUnit());
    // Dimension checking (allows/disallows conversions)
    System.out.println(ELECTRON_VOLT.isCompatible(WATT.times(HOUR)));
    // Retrieval of the unit dimension (depends upon the current model).
    System.out.println(ELECTRON_VOLT.getDimension());
    
    Measurable<Length> m = DecimalMeasure.valueOf(10, MILE);
    System.out.println(m);
  }
}
