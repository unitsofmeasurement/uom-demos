package tech.uom.demo.web.vaadindemo;

import lombok.Data;

@Data
public class ConversionRequest {
    String fromUnit;
    String fromValue;
    String toUnit;
    String toValue;
}
