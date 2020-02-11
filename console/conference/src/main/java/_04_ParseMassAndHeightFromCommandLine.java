import javax.measure.Quantity;

import tech.units.indriya.quantity.Quantities;

public class _04_ParseMassAndHeightFromCommandLine {

	public static void main(String[] args) {
		final Quantity<?> mass = Quantities.getQuantity(args[0]);
		System.out.println(mass);
		final Quantity<?> height = Quantities.getQuantity(args[1]);
		System.out.println(height);
		final Quantity<?> bmi = mass.divide(height).divide(height);
		System.out.println(bmi);
	}
}