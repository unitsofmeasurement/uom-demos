/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javameapplication;

import java.util.Iterator;
import javax.measure.Measurement;
import javax.measure.Quantity;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Temperature;
import javax.microedition.midlet.MIDlet;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordStore;
import org.unitsofmeasurement.impl.enums.quantity.TemperatureQuantity;
//import tec.uom.impl.enums.quantity.TimeAmount;
//import tec.uom.impl.enums.unit.TimeUnit;
import org.unitsofmeasurement.impl.enums.quantity.TimeQuantity;
import org.unitsofmeasurement.impl.enums.unit.TemperatureUnit;
import org.unitsofmeasurement.impl.enums.unit.TimeUnit;
//import tec.units.ri.quantity.QuantityFactory;
//import tec.units.ri.util.SI;

/**
 *
 * @author Werner
 */
public class JavaMEApplication extends MIDlet {
    
   // private Display display;
    private String appName = "ConvertMe";
    private boolean firstTime;

    private UnitCollection[] collection;

    private Measurement measure;
    private Quantity quantity;
    private byte[] saveBuf;     // buffer for saved data
    private int saveBufIndex = 0;
    private int saveBufLength = 10;
    private RecordStore store;  // record store, null if not open
    
    public void startApp() {
        /*
        Iterator<Display> disps = Display.getDisplays(false);
        while(disps.hasNext()) {
            Display d = disps.next();
            if (display == null) display = d;
        } */
        
        //measure = ShirtSizeEnum.L;
        //quantity = QuantityFactory.getInstance(Mass.class).create(10, SI.KILOGRAM);
        quantity = new TimeQuantity(10d, TimeUnit.MINUTE);
        //quantity = new AreaQuantity(10d, AreaUnit.sqmetre);
        Quantity<Temperature> temp = new TemperatureQuantity(10d, 
                TemperatureUnit.CELSIUS);
        System.out.println();
        System.out.println();
        System.out.println("Hello");
        System.out.println();
        System.out.println(quantity);
        System.out.println(temp);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

}
