import javax.measure.Dimension;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.unit.AlternateUnit;
import tech.units.indriya.unit.UnitDimension;
import tech.units.indriya.unit.Units;

public class _07_DetectMassAndHeight {

	public static void main(String[] args) {
		final Quantity<?> first = Quantities.getQuantity("188 cm");
		System.out.println(first);
		final Quantity<?> second = Quantities.getQuantity("90 kg");
		System.out.println(second);
		Quantity<Mass> mass = null;
		Quantity<Length> height = null;
		final Dimension firstDimension = first.getUnit().getDimension();
		final Dimension secondDimension = second.getUnit().getDimension();
		if (firstDimension.equals(UnitDimension.MASS)) {
			mass = first.asType(Mass.class);
			if (secondDimension.equals(UnitDimension.LENGTH)) {
				height = second.asType(Length.class);
			} else {
				System.out.println(
						"Arguments muss be a mass and a length – first argument was a mass, so the second argument should have been a length");
			}
		} else if (firstDimension.equals(UnitDimension.LENGTH)) {
			height = first.asType(Length.class);
			if (secondDimension.equals(UnitDimension.MASS)) {
				mass = second.asType(Mass.class);
			} else {
				System.out.println(
						"Arguments muss be a mass and a length – first argument was a length, so the second argument should have been a mass");
			}
		} else {
			System.out
					.println("Arguments muss be a mass and a length – first argument was neither a mass nor a length");
		}
		final Quantity<Bmi> bmi = mass.divide(height).divide(height).asType(Bmi.class);
		System.out.println(bmi);
		final Unit<Bmi> bmi_unit = new AlternateUnit<Bmi>(Units.KILOGRAM.divide(Units.METRE.pow(2)), "Ƀ");
		System.out.println(bmi.to(bmi_unit));
	}

	public interface Bmi extends Quantity<Bmi> {
	}
}