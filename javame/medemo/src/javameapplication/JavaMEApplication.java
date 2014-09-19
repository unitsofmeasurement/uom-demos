/**
 *  Unit-API - Units of Measurement API for Java
 *  Copyright 2013-2014, Jean-Marie Dautelle, Werner Keil, V2COM and individual
 *  contributors by the @author tag.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
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
/*
import tec.uom.impl.enums.quantity.TemperatureAmount;
import tec.uom.impl.enums.quantity.TimeAmount;
import tec.uom.impl.enums.unit.TimeUnit;
import tec.uom.impl.enums.unit.TemperatureUnit;
*/

import org.unitsofmeasurement.impl.enums.quantity.TimeQuantity;
import org.unitsofmeasurement.impl.enums.unit.TemperatureUnit;
import org.unitsofmeasurement.impl.enums.unit.TimeUnit;
import org.unitsofmeasurement.impl.enums.quantity.TemperatureQuantity;

//import tec.units.ri.quantity.QuantityFactory;
//import tec.units.ri.util.SI;

/**
 *
 * @author Werner
 */
public class JavaMEApplication extends MIDlet {
    
   // private Display display;
    private String appName = "MEDemo";
    private boolean firstTime;

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
        //quantity = new AreaQuantity(10d, AreaUnit.sqmetre);
        
        quantity = new TimeQuantity(10d, TimeUnit.MINUTE);
        //quantity = new TimeAmount(10d, TimeUnit.MINUTE);
        
        Quantity<Temperature> temp = new TemperatureQuantity(10d,
        //Quantity<Temperature> temp = new TemperatureAmount(10d, 
                TemperatureUnit.CELSIUS);
        System.out.println();
        System.out.println();
        System.out.println("Hello ME"); 
        System.out.println();
        System.out.println(quantity);
        System.out.println(temp);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

}
