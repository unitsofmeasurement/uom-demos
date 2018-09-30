package tech.uom.demo.systems.ucum;

import javax.measure.Unit;
import javax.measure.format.UnitFormat;
import javax.measure.spi.ServiceProvider;

public class UCUMServiceDemo {

    public static void main(String[] args) {
        for (ServiceProvider provider : ServiceProvider.available()) {
            System.out.println(String.valueOf(provider.getClass().getSimpleName()));
        }
        
        System.out.println();
        System.out.println(ServiceProvider.current());
        
        for (String formatName : ServiceProvider.current().getUnitFormatService().getAvailableFormatNames()) {
            System.out.println(formatName);
        }
        
    	UnitFormat unitFormat = ServiceProvider.current().getUnitFormatService().getUnitFormat("UCUM");
    	System.out.println(unitFormat);
    	
    	UnitFormat cs = ServiceProvider.current().getUnitFormatService().getUnitFormat("CS");
    	System.out.println(cs);
    	Unit<?> unit = cs.parse("m/s");
    	System.out.println(unit);
    	
        //System.out.println("Square m (EBNF): " + ebnf.parse("m^2"));
    	ServiceProvider defaultProvider = ServiceProvider.current();
        for (ServiceProvider provider : ServiceProvider.available()) {
            if ("DefaultServiceProvider".equals(provider.getClass().getSimpleName())) {
                defaultProvider = provider;
                break;
            }
        }
        final UnitFormat f = defaultProvider.getUnitFormatService().getUnitFormat();
        System.out.println("Square m: " + f.parse("m^2"));
    }
}
