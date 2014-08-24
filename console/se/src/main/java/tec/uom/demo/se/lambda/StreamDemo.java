package tec.uom.demo.se.lambda;

import java.util.Set;
import java.util.stream.Stream;

import javax.measure.Unit;

import tec.uom.se.util.SI;

public class StreamDemo {

	public static void main(String[] args) {
		Set<Unit<?>> units = SI.getInstance().getUnits();
		Stream<String> names = units.stream().map(Unit::getSymbol);
		names.forEach( System.out::println );
	}

}
