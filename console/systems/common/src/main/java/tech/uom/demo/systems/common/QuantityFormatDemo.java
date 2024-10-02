package tech.uom.demo.systems.common;

import javax.measure.Quantity;
import javax.measure.spi.ServiceProvider;

import systems.uom.common.USCustomary;
import tech.units.indriya.format.EBNFUnitFormat;
import tech.units.indriya.format.SimpleUnitFormat;

public class QuantityFormatDemo {

	public static void main(String[] args) {
        SimpleUnitFormat.getInstance().alias(USCustomary.MILE, "mile");
        EBNFUnitFormat.getInstance().label(USCustomary.MILE, "mi");
        EBNFUnitFormat.getInstance().alias(USCustomary.MILE, "mile");
        Quantity<?> q1 = ServiceProvider.current().getFormatService().getQuantityFormat().parse("3 km");
        Quantity<?> q2 = ServiceProvider.current().getFormatService().getQuantityFormat().parse("3 mi");
        Quantity<?> q3 = ServiceProvider.current().getFormatService().getQuantityFormat().parse("3 mile");
        //Quantity<?> q4 = ServiceProvider.current().getFormatService().getQuantityFormat().parse("3 2/km"); // Exception
        Quantity<?> q5 = ServiceProvider.current().getFormatService().getQuantityFormat("EBNF").parse("3 1/km");
        Quantity<?> q6 = ServiceProvider.current().getFormatService().getQuantityFormat("EBNF").parse("3 1/mi"); // Exception
        Quantity<?> q7 = ServiceProvider.current().getFormatService().getQuantityFormat("EBNF").parse("3 1/mile"); // Exception
        Quantity<?> q8 = ServiceProvider.current().getFormatService().getQuantityFormat("EBNF").parse("3 mile");
	}

}
