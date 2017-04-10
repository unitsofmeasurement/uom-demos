package tec.uom.demo.systems.ucum;

import javax.measure.Unit;
import javax.measure.format.UnitFormat;
import javax.measure.spi.ServiceProvider;

public class UCUMServiceDemo {

    public static void main(String[] args) {
	UnitFormat unitFormat = ServiceProvider.current().getUnitFormatService().getUnitFormat("UCUM");
	System.out.println(unitFormat);
	
	UnitFormat cs = ServiceProvider.current().getUnitFormatService().getUnitFormat("CS");
	System.out.println(cs);
	Unit<?> unit = cs.parse("m/s");
	System.out.println(unit);
    }
}
