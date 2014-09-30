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

package medemo;

import javax.measure.Quantity;
import javax.measure.quantity.Temperature;
import javax.microedition.midlet.MIDlet;

import tec.uom.impl.enums.quantity.TemperatureAmount;
import tec.uom.impl.enums.quantity.TimeAmount;
import tec.uom.impl.enums.unit.TimeUnit;
import tec.uom.impl.enums.unit.TemperatureUnit;

/*
import org.unitsofmeasurement.impl.enums.quantity.TimeQuantity;
import org.unitsofmeasurement.impl.enums.unit.TemperatureUnit;
import org.unitsofmeasurement.impl.enums.unit.TimeUnit;
import org.unitsofmeasurement.impl.enums.quantity.TemperatureQuantity;
*/
/**
 * ME Demo using JSR 363
 * @author Werner
 */
public class JavaMEApplication extends MIDlet {
    private final String appName = "MEDemo";
    private Quantity quantity;
  
    public void startApp() {
        quantity = new TimeAmount(10d, TimeUnit.MINUTE);
        //quantity = new TimeQuantity(10d, TimeUnit.MINUTE);
        
        Quantity<Temperature> temp = new TemperatureAmount(10d,
        //Quantity<Temperature> temp = new TemperatureQuantity(10d,
                TemperatureUnit.CELSIUS);

        System.out.println();
        System.out.println("Hello " + appName); 
        System.out.println();
        System.out.println(quantity);
        System.out.println(temp);
    }
    
    public void pauseApp() {
    }
   
    public void destroyApp(boolean unconditional) {
    }
}
