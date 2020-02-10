import javax.measure.Quantity;
import javax.measure.Unit;


import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.unit.AlternateUnit;
import tech.units.indriya.unit.Units;

public class _06_DefineBmiUnit {

	public static void main(String[] args) {
		final Quantity<?> mass = Quantities.getQuantity("88 kg");
		System.out.println(mass);
		final Quantity<?> height = Quantities.getQuantity("1.88 m");
		System.out.println(height);
		final Quantity<Bmi> bmi = mass.divide(height).divide(height).asType(Bmi.class);
		System.out.println(bmi);
		final Unit<Bmi> bmi_unit = new AlternateUnit<Bmi>(Units.KILOGRAM.divide(Units.METRE.pow(2)), "Ƀ");
		System.out.println(bmi.to(bmi_unit));
	}

	public interface Bmi extends Quantity<Bmi> {
	}
}