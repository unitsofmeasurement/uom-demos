/*
    Copyright (c) 2009-2013 Dmitry Brant <me@dmitrybrant.com>
    
    This software is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.
  
    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
  
    You should have received a copy of the GNU General Public License along
    with this program; if not, write the Free Software Foundation, Inc., 51
    Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.

 */
package javameapplication;

/**
 *
 * @author Dmitry Brant
 */
public class UnitCollection {

    public String name;
    public SingleUnit[] items;
    public String imageName;

    public UnitCollection(String collectionName, String imgName, SingleUnit[] collectionItems){
        name = collectionName;
        items = collectionItems;
        imageName = imgName;
    }

    public static UnitCollection[] GetUnitCollection(){
        UnitCollection[] collection = new UnitCollection[10];
        int colIndex = 0;

        collection[colIndex++] = new UnitCollection("Distance", "/distance.png",
                new SingleUnit[] {
                    new SingleUnit("angstrom (Å)", 1.0e+10, 0.0),
                    new SingleUnit("astr. unit (AU)", 6.6844919786e-12, 0.0),
                    new SingleUnit("centimeter (cm)", 100.0, 0.0),
                    new SingleUnit("dekameter (dm)", 0.1, 0.0),
                    new SingleUnit("foot (ft)", 3.280839895013123, 0.0),
                    new SingleUnit("furlong", 4.9709695378986712e-3, 0.0),
                    new SingleUnit("hectometer (hm)", 0.01, 0.0),
                    new SingleUnit("inch (in)", 39.37007874015748, 0.0),
                    new SingleUnit("kilometer (km)", 0.001, 0.0),
                    new SingleUnit("light year (ly)", 1.0570008340246154637e-16, 0.0),
                    new SingleUnit("meter (m)", 1.0, 0.0),
                    new SingleUnit("micrometer (µm)", 1.0e+6, 0.0),
                    new SingleUnit("mile (mi)", 6.2137119223733397e-4, 0.0),
                    new SingleUnit("millimeter (mm)", 1000.0, 0.0),
                    new SingleUnit("nanometer (nm)", 1.0e+9, 0.0),
                    new SingleUnit("nautical mile", 5.399554642178303e-4, 0.0),
                    new SingleUnit("parsec (pc)", 3.2407786545502059e-17, 0.0),
                    new SingleUnit("yard (yd)", 1.0936132983377078, 0.0),

                } );

        collection[colIndex++] = new UnitCollection("Area", "/square.png",
                new SingleUnit[] {
                    new SingleUnit("acre", 2.4710538146716534e-4, 0.0),
                    new SingleUnit("centimeter²", 10000.0, 0.0),
                    new SingleUnit("foot²", 10.7639104167097223, 0.0),
                    new SingleUnit("hectare", 1.0e-4, 0.0),
                    new SingleUnit("inch²", 1550.0031000062, 0.0),
                    new SingleUnit("kilometer²", 1.0e-6, 0.0),
                    new SingleUnit("meter²", 1.0, 0.0),
                    new SingleUnit("mile²", 3.86102158542445847e-7, 0.0),
                    new SingleUnit("millimeter²", 1.0e+6, 0.0),
                    new SingleUnit("yard²", 1.19599004630108026, 0.0),

                } );

        collection[colIndex++] = new UnitCollection("Volume", "/cube.png",
                new SingleUnit[] {
                    new SingleUnit("centimeter³", 1000.0, 0.0),
                    new SingleUnit("cup", 4.22675283773037465, 0.0),
                    new SingleUnit("dram", 270.51218161474397756, 0.0),
                    new SingleUnit("foot³", 0.0353146667214886, 0.0),
                    new SingleUnit("gallon", 0.264172052358148416, 0.0),
                    new SingleUnit("inch³", 61.023744094732284, 0.0),
                    new SingleUnit("liter", 1.0, 0.0),
                    new SingleUnit("milliliter", 1000.0, 0.0),
                    new SingleUnit("ounce", 33.81402270184299719, 0.0),
                    new SingleUnit("pint", 2.11337641886518732, 0.0),
                    new SingleUnit("quart", 1.05668820943259366, 0.0),
                    new SingleUnit("tablespoon", 67.62804540368599439, 0.0),
                    new SingleUnit("teaspoon", 202.88413621105798317, 0.0),
                    new SingleUnit("yard³", 0.0013079506193144, 0.0),

                } );


        collection[colIndex++] = new UnitCollection("Mass", "/mass.png",
                new SingleUnit[] {
                    new SingleUnit("carat", 5000.0, 0.0),
                    new SingleUnit("grain (gr)", 15432.4, 0.0),
                    new SingleUnit("gram (g)", 1000.0, 0.0),
                    new SingleUnit("kilogram (kg)", 1.0, 0.0),
                    new SingleUnit("megagram (Mg)", 0.001, 0.0),
                    new SingleUnit("metric ton (t)", 0.001, 0.0),
                    new SingleUnit("microgram (µg)", 1.0e+9, 0.0),
                    new SingleUnit("milligram (mg)", 1.0e+6, 0.0),
                    new SingleUnit("ounce (oz)", 35.2739619806867227, 0.0),
                    new SingleUnit("pound (lb)", 2.20462262379292017, 0.0),
                    new SingleUnit("stone", 0.157473044556637155, 0.0),
                    new SingleUnit("ton (tn)", 0.00110231131189646, 0.0),

                } );

        collection[colIndex++] = new UnitCollection("Temperature", "/temperature.png",
                new SingleUnit[] {
                    new SingleUnit("celsius (°C)", 1.0, 0.0),
                    new SingleUnit("fahrenheit (°F)", 1.8, 32.0),
                    new SingleUnit("kelvin (K)", 1.0, 273.15),
                    new SingleUnit("rankine (°Ra)", 1.8, 491.67),
                    new SingleUnit("réaumur (°R)", 0.8, 0.0),
                } );


        collection[colIndex++] = new UnitCollection("Angle", "/angle.png",
                new SingleUnit[] {
                    new SingleUnit("degree (°)", 1.0, 0.0),
                    new SingleUnit("grad", 1.11111111111111111, 0.0),
                    new SingleUnit("radian", 0.017453292519943296, 0.0),
                    new SingleUnit("revolution", 2.777777777777777e-3, 0.0),
                    new SingleUnit("minute (')", 60.0, 0.0),
                    new SingleUnit("second (\")", 3600.0, 0.0),

                } );

        collection[colIndex++] = new UnitCollection("Speed", "/speed.png",
                new SingleUnit[] {
                    new SingleUnit("kilometer/sec", 1.0, 0.0),
                    new SingleUnit("kilometer/min", 60.0, 0.0),
                    new SingleUnit("kilometer/hour", 3600.0, 0.0),
                    new SingleUnit("meter/sec", 1000.0, 0.0),
                    new SingleUnit("meter/min", 60000.0, 0.0),
                    new SingleUnit("meter/hour", 3.6e+6, 0.0),
                    new SingleUnit("light speed (c)", 3.3356409519815205e-6, 0.0),
                    new SingleUnit("knot", 1943.84449244060475, 0.0),
                    new SingleUnit("mach", 3.016955289, 0.0),
                    new SingleUnit("foot/sec", 3280.839895013123, 0.0),
                    new SingleUnit("foot/min", 196850.39370078738, 0.0),
                    new SingleUnit("foot/hour", 11811023.622047243, 0.0),
                    new SingleUnit("mile/sec", 0.6213711922373339, 0.0),
                    new SingleUnit("mile/min", 37.282271534240034, 0.0),
                    new SingleUnit("mile/hour", 2236.936292054402, 0.0),

                } );

        collection[colIndex++] = new UnitCollection("Acceleration", "/acceleration.png",
                new SingleUnit[] {
                    new SingleUnit("centimeter/sec²", 100.0, 0.0),
                    new SingleUnit("foot/sec²", 3.280839895013123, 0.0),
                    new SingleUnit("meter/sec²", 1.0, 0.0),
                    new SingleUnit("millimeter/sec²", 1000.0, 0.0),
                    new SingleUnit("surface gravity (g)", 0.101971621297793, 0.0),

                } );

        collection[colIndex++] = new UnitCollection("Power", "/power.png",
                new SingleUnit[] {
                    new SingleUnit("kilowatt", 1.0, 0.0),
                    new SingleUnit("BTU/hour", 3415.179027, 0.0),
                    new SingleUnit("BTU/minute", 56.91965045, 0.0),
                    new SingleUnit("BTU/second", 0.9486608408, 0.0),
                    new SingleUnit("calorie/sec", 239.0585106, 0.0),
                    new SingleUnit("horsepower", 1.34102209, 0.0),
                    new SingleUnit("megawatt", 0.001, 0.0),
                    new SingleUnit("lb-ft/min", 44253.72896, 0.0),
                    new SingleUnit("lb-ft/sec", 737.5621493, 0.0),
                    new SingleUnit("watt", 1000.0, 0.0),

                } );


        collection[colIndex++] = new UnitCollection("Data", "/data.png",
                new SingleUnit[] {
                    new SingleUnit("bit", 8192.0, 0.0),
                    new SingleUnit("byte", 1024.0, 0.0),
                    new SingleUnit("nibble", 2048.0, 0.0),
                    new SingleUnit("kilobyte (KB)", 1.0, 0.0),
                    new SingleUnit("megabyte (MB)", 9.765625e-4, 0.0),
                    new SingleUnit("gigabyte (GB)", 9.5367431640625e-7, 0.0),
                    new SingleUnit("terabyte (TB)", 9.313225746154785e-10, 0.0),
                    new SingleUnit("petabyte (PB)", 9.09494701772928238e-13, 0.0),
                    new SingleUnit("exabyte (EB)", 8.88178419700125232e-16, 0.0),
                    new SingleUnit("kilobit", 8.0, 0.0),
                    new SingleUnit("megabit", 0.0078125, 0.0),
                    new SingleUnit("gigabit", 7.62939453125e-6, 0.0),

                } );


        return collection;
    }
}
