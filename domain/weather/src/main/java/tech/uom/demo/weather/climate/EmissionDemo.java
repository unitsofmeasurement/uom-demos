package tech.uom.demo.weather.climate;

import static tech.units.indriya.unit.Units.*;

import javax.measure.MetricPrefix;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Energy;

import tech.units.indriya.AbstractUnit;
import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.unit.AlternateUnit;
import tech.units.indriya.unit.ProductUnit;

public class EmissionDemo {
	  private static interface Emission extends Quantity<Emission> {} // gas i.e CO2
	  private static interface EmissionMass extends Quantity<EmissionMass> {} // mass of given gas
	  private static interface EmissionRatio extends Quantity<EmissionRatio> {} // mass ratio for given energy

	  // energy
	  public static final Unit<Energy> WH = new ProductUnit<>(WATT.multiply(HOUR));
	  public static final Unit<Energy> KWH = MetricPrefix.KILO(WH);
	  public static final Unit<Energy> MWH = MetricPrefix.MEGA(WH);

	  // emission
	  public static final Unit<Emission> CO2 = new AlternateUnit<>(AbstractUnit.ONE, "CO₂");

	  public static void main(String[] args) {
	    Unit<EmissionMass> massUnit = new AlternateUnit<>(KILOGRAM.multiply(CO2), "kg·CO₂").asType(EmissionMass.class);
	    System.out.println("Emission mass unit " + massUnit);
	    Quantity<EmissionMass> massQty = Quantities.getQuantity(1, massUnit);
	    System.out.println("Emission mass prime " + massQty);

	    Unit<EmissionRatio> emissionRateUnit = massUnit.divide(WH).asType(EmissionRatio.class);
	    System.out.println("Emission rate " + emissionRateUnit);
	    Quantity<EmissionRatio> emissionRateQty = Quantities.getQuantity(0.0008, emissionRateUnit);
	    System.out.println("Emission rate prime " + emissionRateQty);

	    Quantity<Energy> one_MWh = Quantities.getQuantity(1000000, WH);
	    System.out.println("Emission from " + one_MWh + ": " + one_MWh.multiply(emissionRateQty));
	    Quantity<Energy> one_kWh = Quantities.getQuantity(1000, WH);
	    System.out.println("Emission from " + one_kWh + ": " + one_kWh.multiply(emissionRateQty));
	    Quantity<Energy> oneWH = Quantities.getQuantity(1, WH);
	    System.out.println("Emission from " + oneWH + ": " + oneWH.multiply(emissionRateQty));
	    
	    Quantity<Energy> true_one_MWh = Quantities.getQuantity(1, MWH);
	    System.out.println("Emission from " + true_one_MWh + ": " + true_one_MWh.multiply(emissionRateQty));
	    System.out.println("MWh Equivalent? " + true_one_MWh.isEquivalentTo(one_MWh));
	    System.out.println("Emission from " + true_one_MWh + ": " + true_one_MWh.to(WH).multiply(emissionRateQty));
	    
	/* output
	Emission mass unit kg·CO₂
	Emission mass prime 1 kg·CO₂
	Emission rate kg·CO₂/(W·h)
	Emission rate prime 8.0E-4 kg·CO₂/(W·h)
	Emission from 1000000 W·h: 800 kg·CO₂
	Emission from 1000 W·h: 0.80000 kg·CO₂
	Emission from 1 W·h: 0.00080 kg·CO₂
	Emission from 1 M(W·h): 0.00080 M(W·h)·kg·CO₂/(W·h)
	MWh Equivalent? true
	Emission from 1 M(W·h): 800 kg·CO₂
	*/
	  }
}
