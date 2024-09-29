package tech.uom.demo.java17;

import javax.measure.IncommensurableException;
import javax.measure.UnconvertibleException;
import javax.measure.UnitConverter;
import javax.measure.spi.ServiceProvider;

public class TemperatureConverterDemo {

	public static void main(String[] args) {
		var format = ServiceProvider.current().getFormatService().getUnitFormat();
				
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
