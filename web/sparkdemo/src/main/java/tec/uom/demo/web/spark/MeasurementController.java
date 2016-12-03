package tec.uom.demo.web.spark;

import static spark.Spark.*;
import static tec.uom.demo.web.spark.JsonUtil.*;

public class MeasurementController {
    private static final String ENDPOINT = "sensors";

    public MeasurementController(final MeasurementService measurementservice) {

	get(String.format("/%s", ENDPOINT), (req, res) -> measurementservice.getAllMeasurements(), json());

	get(String.format("/%s/:id", ENDPOINT), (req, res) -> {
	    String id = req.params(":id");
	    Measurement user = measurementservice.getMeasurement(id);
	    if (user != null) {
		return user;
	    }
	    res.status(400);
	    return new ResponseError("No sensor with id '%s' found", id);
	}, json());

	post(String.format("/%s", ENDPOINT), (req, res) -> measurementservice.createMeasurement(req.queryParams("name"),
		req.queryParams("value"), req.queryParams("unit")), json());

	put(String.format("/%s/:id", ENDPOINT), (req, res) -> measurementservice.updateMeasurement(req.params(":id"),
		req.queryParams("name"), req.queryParams("value"), req.queryParams("unit")), json());

	after((req, res) -> {
	    res.type("application/json");
	});

	exception(IllegalArgumentException.class, (e, req, res) -> {
	    res.status(400);
	    res.body(toJson(new ResponseError(e)));
	});
    }
}