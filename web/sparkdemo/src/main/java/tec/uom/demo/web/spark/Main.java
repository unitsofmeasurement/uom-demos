package tec.uom.demo.web.spark;

public class Main {
	public static void main(String[] args) {
		new MeasurementController(new MeasurementService());
	}
}
