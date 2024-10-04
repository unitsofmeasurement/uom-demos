package tech.uom.demo.java17.format;

import static javax.measure.Quantity.Scale.*;

import java.text.NumberFormat;

import javax.measure.IncommensurableException;
import javax.measure.UnconvertibleException;
import javax.measure.UnitConverter;
import javax.measure.spi.ServiceProvider;

import tech.units.indriya.AbstractUnit;
import tech.units.indriya.format.EBNFUnitFormat;
import tech.units.indriya.format.NumberDelimiterQuantityFormat;
import tech.units.indriya.quantity.Quantities;

public class TemperatureUnitConverterDemo {

	public static void main(String[] args) {
		//var format = ServiceProvider.current().getFormatService().getUnitFormat();
		var format = EBNFUnitFormat.getInstance();
		var format2 = NumberDelimiterQuantityFormat.getInstance(NumberFormat.getInstance(), format);
        var source =  format.parse("K/10");
        var intermediary = format.parse("K");
        var source2 =  format.parse("°C/10");
        var dest = format.parse("°C");
        UnitConverter converter = null;
        UnitConverter converter2 = null;
        UnitConverter converter3 = null;
        try {
			converter = source.getConverterToAny(intermediary);
			converter2 = dest.getConverterToAny(intermediary);
			converter3 = ((AbstractUnit<?>)source2).getConverterToAny(dest, RELATIVE);
		} catch (UnconvertibleException | IncommensurableException e) {
			e.printStackTrace();
		}
		if (converter != null) {
			var toK = converter2.convert(1);
			var converted = converter.convert(toK);
			System.out.println(converted);			
		}
		if (converter3 != null) {
			var converted = converter3.convert(10);
			System.out.println(converted);
		}
		
		var qs = Quantities.getQuantity(10, source, ABSOLUTE);
		System.out.println(format2.format(qs));
		//var qs2 = Quantities.getQuantity(10, source2, Scale.ABSOLUTE);
		//System.out.println(format2.format(qs2));
		var qs3 = Quantities.getQuantity(1, intermediary,  ABSOLUTE);
		var qs4 = qs.multiply(qs3);
		System.out.println(format2.format(qs4));
		//var qs5 = qs.to(dest);
	}

}
