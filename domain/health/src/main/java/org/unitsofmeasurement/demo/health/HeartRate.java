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
package org.unitsofmeasurement.demo.health;

import javax.measure.Quantity;

/**
 * Heart rate refers to the speed of the heartbeat, 
 * specifically the number of heartbeats per unit of time. 
 * The heart rate is typically expressed as beats per minute (bpm). 
 * The heart rate can vary according to the body's physical needs, 
 * including the need to absorb oxygen and excrete carbon dioxide.
 *
 * @author <a href="mailto:uomo@catmedia.us">Werner Keil</a>
 * @version 1.0
 */
public interface HeartRate extends Quantity<HeartRate> {

}