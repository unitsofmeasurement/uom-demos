package tech.uom.demo.basic.format;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

import tech.units.indriya.format.EBNFUnitFormat;
import tech.units.indriya.format.SymbolMap;
import tech.units.indriya.unit.Units;

/**
 * Simple code to demonstrate use of aliases with the EBNFUnitFormat
 */
public class EBNFDemo {

    private static final String BUNDLE_NAME = "tech.units.indriya.format.messages"; //$NON-NLS-1$

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        // TODO code application logic here
        SymbolMap map = SymbolMap.of(ResourceBundle.getBundle(BUNDLE_NAME, Locale.ROOT));
        map.alias(Units.COULOMB.multiply(1.60217662e-19), "e");

        EBNFUnitFormat unitParser = EBNFUnitFormat.getInstance(map);

        PrintStream utfOut = new PrintStream(System.out, true, "UTF-8");
        utfOut.println("Dimension of e: " + unitParser.parse("e").getDimension());

    }

}