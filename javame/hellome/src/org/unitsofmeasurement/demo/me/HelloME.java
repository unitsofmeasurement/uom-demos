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
package org.unitsofmeasurement.demo.me;

import static org.unitsofmeasurement.impl.enums.unit.TemperatureUnit.*;

import javax.measure.quantity.Temperature;
import javax.microedition.midlet.MIDlet;
import org.unitsofmeasurement.impl.enums.quantity.TemperatureQuantity;


/**
 * @author Werner Keil
 */
public class HelloME extends MIDlet {
    
    public void startApp() {
        
        Temperature t =  new TemperatureQuantity(23.5, CELSIUS);
        System.out.println("Temperature: " + t);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
