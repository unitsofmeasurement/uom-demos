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
package tec.uom.demo.me;

import static tec.uom.impl.enums.unit.TemperatureUnit.*;

import javax.measure.Quantity;
import javax.measure.quantity.Temperature;
import javax.measure.quantity.Time;
import javax.microedition.midlet.MIDlet;
//import org.unitsofmeasurement.impl.enums.quantity.TimeQuantity;
//import org.unitsofmeasurement.impl.enums.unit.TimeUnit;
import tec.uom.impl.enums.quantity.TemperatureAmount;


/**
 * @author Werner Keil
 */
public class HelloME extends MIDlet {
    
    public void startApp() {
       Temperature t =  new TemperatureAmount(23.5, CELSIUS);
       System.out.println("Temperature: " + t);
       //Quantity<Time> quantity = new TimeQuantity(10d, TimeUnit.MINUTE);
       //System.out.println("Time: " + quantity);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
