package tech.uom.demo.systems.ucum;

import javax.measure.IncommensurableException;
import javax.measure.UnconvertibleException;
import javax.measure.UnitConverter;
import javax.measure.spi.ServiceProvider;

import systems.uom.ucum.format.UCUMFormat;
import systems.uom.ucum.format.UCUMFormat.Variant;
import tech.units.indriya.format.EBNFUnitFormat;
import tech.units.indriya.function.AbstractConverter;
import tech.units.indriya.unit.TransformedUnit;

public class TemperatureConverterDemo {

	public static void main(String[] args) {
		//var format = ServiceProvider.current().getFormatService().getUnitFormat();
		var format = UCUMFormat.getInstance(Variant.CASE_SENSITIVE);
        var source =  format.parse("Cel/10"); 
        var dest = format.parse("Cel");
        AbstractConverter converter = null;
        try {
			converter = (AbstractConverter)source.getConverterToAny(dest);
		} catch (UnconvertibleException | IncommensurableException e) {
			e.printStackTrace();
		}
		if (converter != null) {
			var converted = converter.convert(10);
			System.out.println(converted);
		}
	}

}
