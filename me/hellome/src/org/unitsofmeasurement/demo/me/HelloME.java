/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.unitsofmeasurement.demo.me;

import javax.measure.quantity.Temperature;
import javax.microedition.midlet.MIDlet;
import org.unitsofmeasurement.impl.enums.quantity.TemperatureQuantity;
import org.unitsofmeasurement.impl.enums.unit.TemperatureUnit;

/**
 *
 * @author Werner Keil
 */
public class HelloME extends MIDlet {
    
    public void startApp() {
        
        Temperature t =  new TemperatureQuantity(23.5, TemperatureUnit.CELSIUS);
        //System.out.println("Hello Java ME");
        System.out.println("Temperature: " + t);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
