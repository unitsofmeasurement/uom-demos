/**
 * Copyright (c) 2014 Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
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
