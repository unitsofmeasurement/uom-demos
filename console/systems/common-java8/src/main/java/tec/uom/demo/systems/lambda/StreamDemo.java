package tec.uom.demo.systems.lambda;

import java.util.Set;
import java.util.stream.Stream;

import javax.measure.Unit;

import tec.uom.se.unit.Units;

public class StreamDemo {

	public static void main(String[] args) {
		Set<Unit<?>> units = (Set<Unit<?>>) Units.getInstance().getUnits();
		Stream<String> names = units.stream().map(Unit::getSymbol);
		names.forEach( System.out::println );
	}

}
