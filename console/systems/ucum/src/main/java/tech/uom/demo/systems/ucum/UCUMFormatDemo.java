package tech.uom.demo.systems.ucum;

import static systems.uom.ucum.UCUM.*;

import javax.measure.Unit;
import javax.measure.UnitConverter;
import javax.measure.format.UnitFormat;
import javax.measure.quantity.Pressure;
import javax.measure.quantity.Volume;
import javax.measure.spi.ServiceProvider;

import tech.units.indriya.format.SimpleUnitFormat;
import tech.units.indriya.format.EBNFUnitFormat;
import javax.measure.MetricPrefix;
import tech.units.indriya.unit.Units;

public class UCUMFormatDemo {

    public static void main(String[] args) {
	final UnitFormat ucumFormatCI = ServiceProvider.current().getUnitFormatService().getUnitFormat("CI");
	final Unit<Volume> microliter = MetricPrefix.MICRO(Units.LITRE);
	System.out.println(ucumFormatCI.format(microliter)); // prints "nst"!
	UnitConverter conv = microliter.getConverterTo(STERE);
	System.out.println(conv);
	UnitConverter conv2 = microliter.getConverterTo(Units.CUBIC_METRE);
	System.out.println(conv);
	
	final Unit<?> microliter2 = ucumFormatCI.parse("uL");
	System.out.println(ucumFormatCI.format(microliter2));
	
	final UnitFormat ucumFormatCS = ServiceProvider.current().getUnitFormatService().getUnitFormat("CS");
	final Unit<?> microliter3 = ucumFormatCS.parse("ul");
	System.out.println(ucumFormatCS.format(microliter3));
	
	final Unit<?> invKelvin = ucumFormatCI.parse("1/K");
	System.out.println(invKelvin);
	System.out.println();
	 
	final UnitFormat ebnf = EBNFUnitFormat.getInstance();
	final UnitFormat ucumFormatPrint = ServiceProvider.current().getUnitFormatService().getUnitFormat("Print");

    //Unit<Force> lbf = Units.NEWTON.multiply(4.4482216152605); // pound-force
    //Unit<Area> sqin = USCustomary.INCH.pow(2).asType(Area.class); // square inch
    Unit<Pressure> psi = POUND_FORCE.divide(SQUARE_INCH_INTERNATIONAL).asType(Pressure.class); // pound-force per square inch
    System.out.println("Pounds per square inch: " + psi);
    SimpleUnitFormat.getInstance().label(psi, "psi");
    System.out.println("Pounds per square inch: " + psi);
    System.out.println("Square psi: " + psi.pow(2));
    System.out.println("Square psi (EBNF): " + ebnf.format(psi.pow(2)));
    System.out.println("Square psi (UCUM): " + ucumFormatPrint.format(psi.pow(2)));
    System.out.println("Square psi (UCUM CS): " + ucumFormatCS.format(psi.pow(2)));
    Unit u1 = SimpleUnitFormat.getInstance().parse("psi^2");
    System.out.println("Square psi parsed: " + u1);
    u1 = SimpleUnitFormat.getInstance().parse("psi²");
    System.out.println("Square psi parsed (Unicode): " + u1);
    //u1 = SimpleUnitFormat.getInstance().parse("lb²·(m/s²)*9.80665²/c(cm*254.0)^4");
    u1 = ebnf.parse("psi^2");
    System.out.println("Square psi parsed (EBNF): " + u1);
    u1 = ebnf.parse("g_n²·lb_av²/in_i⁴");
    System.out.println("Square psi parsed (EBNF 2): " + u1);
    u1 = ucumFormatCS.parse("[g]2.[lb_av]2/[in_i]4");
    System.out.println("Square psi parsed (UCUM CS): " + u1);
    System.out.println();

    Unit<Pressure> another_psi = Units.NEWTON.multiply(6895).divide(Units.SQUARE_METRE).asType(Pressure.class);
    System.out.println("Pounds per square inch: " + another_psi);
    SimpleUnitFormat.getInstance().label(another_psi, "psi");
    System.out.println("Pounds per square inch: " + another_psi);
    System.out.println("Square psi: " + another_psi.pow(2));
    System.out.println("Square psi (EBNF): " + ebnf.format(another_psi.pow(2)));
    System.out.println("Square psi (UCUM): " + ucumFormatPrint.format(another_psi.pow(2)));    
    }
}
