import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.unit.Units;

public class _02_DivideMassTwiceByHeight {

	public static void main(String[] args) {
		final Quantity<Mass> mass = Quantities.getQuantity(88, Units.KILOGRAM);
		System.out.println(mass);
		final Quantity<Length> height = Quantities.getQuantity(1.88, Units.METRE);
		System.out.println(height);
		final Quantity<?> bmi1 = mass.divide(height).divide(height);
		System.out.println(bmi1);
		final Quantity<?> bmi2 = mass.divide(height.multiply(height));
		System.out.println(bmi2);
	}
}