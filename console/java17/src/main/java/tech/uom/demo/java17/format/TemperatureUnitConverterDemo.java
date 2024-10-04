package tech.uom.demo.java17.format;

import static javax.measure.Quantity.Scale.*;

import javax.measure.IncommensurableException;
import javax.measure.UnitConverter;

import tech.units.indriya.AbstractUnit;
import tech.units.indriya.format.EBNFUnitFormat;

public class TemperatureUnitConverterDemo {

	public static void main(String[] args) {
		//var format = ServiceProvider.current().getFormatService().getUnitFormat();
		var format = EBNFUnitFormat.getInstance();
        var source =  format.parse("K/10");
        var dest = format.parse("K");
        var source2 =  format.parse("°C/10");
        var dest2 = format.parse("°C");
        UnitConverter converter = null;
        UnitConverter converter2 = null;
        try {
			converter = source.getConverterToAny(dest);
			converter2 = ((AbstractUnit<?>)source2).getConverterToAny(dest2, RELATIVE);
		} catch (IncommensurableException e) {
			e.printStackTrace();
		}
		if (converter != null) {
			var converted = converter.convert(10);
			System.out.println(converted);			
		}
		if (converter2 != null) {
			var converted2 = converter2.convert(10);
			System.out.println(converted2);
		}		
	}
}
