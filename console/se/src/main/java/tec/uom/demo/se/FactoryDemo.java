package tec.uom.demo.se;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.spi.Bootstrap;
import javax.measure.spi.QuantityFactory;

import tec.uom.se.spi.QuantityFactoryService;
import tec.uom.se.internal.quantity.OldProxyQuantityFactory;
//import tec.uom.se.quantity.ProxyQuantityFactory;
import tec.uom.se.unit.Units;

public class FactoryDemo {
	public static void main(String... args) {
		OldProxyQuantityFactory<Length> lenFactory = OldProxyQuantityFactory.getInstance(Length.class);
		Length len = lenFactory.create(10, Units.METRE);
		
		System.out.println(len);
//		Quantity<Length> len2 = len.multiply(2);
//		System.out.println(len2);
		QuantityFactoryService service = Bootstrap.getService(QuantityFactoryService.class);
		
		QuantityFactory<Mass> massFactory = service.getQuantityFactory(Mass.class);
		Quantity<Mass> mass = massFactory.create(50, Units.KILOGRAM);
		System.out.println(mass);
	}
}
