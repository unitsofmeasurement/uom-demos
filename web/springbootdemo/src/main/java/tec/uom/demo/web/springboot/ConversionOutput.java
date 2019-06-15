package tec.uom.demo.web.springboot;
/**
 * ConversionOutput
 */
public class ConversionOutput {

    private ConversionInput input;
    private Number targetValue;

    public ConversionInput getInput() {
        return input;
    }

    public void setInput(ConversionInput input) {
        this.input = input;
    }

    public Number getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(Number targetValue) {
        this.targetValue = targetValue;
    }
    
    

}