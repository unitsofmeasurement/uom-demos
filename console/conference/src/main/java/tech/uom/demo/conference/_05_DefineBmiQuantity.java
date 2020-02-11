package tech.uom.demo.conference;
import javax.measure.Quantity;

import tech.units.indriya.quantity.Quantities;

public class _05_DefineBmiQuantity {

	public static void main(String[] args) {
		final Quantity<?> mass = Quantities.getQuantity("88 kg");
		System.out.println(mass);
		final Quantity<?> height = Quantities.getQuantity("1.88 m");
		System.out.println(height);
		final Quantity<Bmi> bmi = mass.divide(height).divide(height).asType(Bmi.class);
		System.out.println(bmi);
	}

	public interface Bmi extends Quantity<Bmi> {
	}
}