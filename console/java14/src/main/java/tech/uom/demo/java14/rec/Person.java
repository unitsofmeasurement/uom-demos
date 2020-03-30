package tech.uom.demo.java14.rec;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

public record Person (String firstName, String lastName, Quantity<Length> height, Quantity<Mass> mass) {
    public String getFirstName() {
        return firstName;
    }
}