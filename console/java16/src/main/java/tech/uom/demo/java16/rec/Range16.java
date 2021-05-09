package tech.uom.demo.java16.rec;

import javax.measure.Quantity;

public record Range16<Q extends Quantity<Q>>(Quantity<Q> min, Quantity<Q> max) {
    public Range16(Quantity<Q> min, Quantity<Q> max) {
//        if (lo > hi)
//            throw new IllegalArgumentException(String.format("%d, %d", lo, hi));
        this.min = min;
        this.max = max;
    }
}