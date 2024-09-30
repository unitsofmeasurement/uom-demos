package tech.uom.demo.impl.seshat;

import javax.measure.IncommensurableException;
import javax.measure.UnconvertibleException;
import javax.measure.UnitConverter;

import tech.uom.seshat.UnitServices;
import tech.uom.seshat.Units;

public class TemperatureConverterDemo {

	public static void main(String[] args) {
		var format = UnitServices.current().getFormatService().getUnitFormat();
		var celsius = Units.CELSIUS;
		UnitConverter celToK = celsius.getConverterTo(Units.KELVIN);
        var source =  format.parse("°C/10"); 
        var dest = format.parse("°C");
        UnitConverter converter = null;
        try {
			converter = source.getConverterToAny(dest);
		} catch (UnconvertibleException | IncommensurableException e) {
			e.printStackTrace();
		}
		if (converter != null) {
			var converted = converter.convert(10);
			System.out.println(converted);
		}
	}

}
