package tec.uom.demo.se;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import tec.uom.se.ComparableQuantity;
import tec.uom.se.quantity.Quantities;
import tec.uom.se.unit.Units;

public class SerialDemo {
	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		byte[] serialized = serialize(Quantities.getQuantity(1, Units.JOULE));
		Object obj = deserialize(serialized);
		ComparableQuantity<?> quantity = (ComparableQuantity<?>) obj;
		System.out.println(quantity);
	}

	public static Object deserialize(byte[] serialized) throws IOException,
			ClassNotFoundException {
		ByteArrayInputStream bis = new ByteArrayInputStream(serialized);
		ObjectInputStream ois = new ObjectInputStream(bis);
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}

	public static byte[] serialize(ComparableQuantity<?> quantity)
			throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(quantity);
		bos.close();
		return bos.toByteArray();
	}
}
