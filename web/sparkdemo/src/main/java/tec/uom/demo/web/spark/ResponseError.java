package tec.uom.demo.web.spark;

import javax.measure.MeasurementException;

public class ResponseError extends MeasurementException {

    /**
     * 
     */
    private static final long serialVersionUID = -2150895368739236890L;
    private String message;

    public ResponseError(String message, String... args) {
	this.message = String.format(message, args);
    }

    public ResponseError(Exception e) {
	super(e);
	this.message = e.getMessage();
    }

    public String getMessage() {
	return this.message;
    }
}
