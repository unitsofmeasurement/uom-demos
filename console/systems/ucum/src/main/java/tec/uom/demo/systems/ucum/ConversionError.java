package tec.uom.demo.systems.ucum;

import javax.measure.Unit;
import javax.measure.format.UnitFormat;

import systems.uom.ucum.format.UCUMFormat;
import systems.uom.ucum.format.UCUMFormat.Variant;

public class ConversionError {

    public static void main(String[] args) {

      UnitFormat ucumFormat = UCUMFormat.getInstance(Variant.CASE_SENSITIVE);
      UnitFormat ucumFormat2 = UCUMFormat.getInstance(Variant.PRINT);
      Unit<?> glomerular = ucumFormat.parse("mL/min/((173/100).m2)");
       System.out.println(glomerular);
       System.out.println(ucumFormat.format(glomerular));
       System.out.println(ucumFormat2.format(glomerular));
      ucumFormat.parse(ucumFormat.format(glomerular));
    }
  }
