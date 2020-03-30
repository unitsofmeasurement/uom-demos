package tech.uom.demo.java14.rec;

import javax.measure.Quantity;

public record Range14<Q extends Quantity<Q>>(Quantity<Q> min, Quantity<Q> max) {
    public Range14(Quantity<Q> min, Quantity<Q> max) {
//        if (lo > hi)
//            throw new IllegalArgumentException(String.format("%d, %d", lo, hi));
        this.min = min;
        this.max = max;
    }
}