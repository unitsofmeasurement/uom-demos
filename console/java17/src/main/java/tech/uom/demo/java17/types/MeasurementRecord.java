package tech.uom.demo.java17.types;

import java.time.Instant;
import java.util.Objects;

import javax.measure.Quantity;

import tech.units.indriya.spi.Measurement;
import tech.uom.lib.common.util.NaturalQuantityComparator;

public record MeasurementRecord<Q extends Quantity<Q>>(Quantity<Q> quantity, Instant instant) 
  implements Measurement<Q>, Comparable<Measurement<Q>> {

	@Override
	public Quantity<Q> getQuantity() {
		return quantity;
	}

	@Override
	public int compareTo(Measurement<Q> that) {
		return Objects.compare(this.quantity(), that.getQuantity(), new NaturalQuantityComparator<Q>()) +
		this.instant().compareTo(that.getInstant());
	}

	@Override
	public long getTimestamp() {
		return instant.toEpochMilli();
	}

	@Override
	public Instant getInstant() {
		return instant;
	}	
}
