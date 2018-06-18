uom-demos
=========

Units of Measurement Demos

[![Circle CI](https://circleci.com/gh/unitsofmeasurement/uom-demos.svg?style=svg)](https://circleci.com/gh/unitsofmeasurement/uom-demos) 
[![License](http://img.shields.io/badge/license-BSD3-blue.svg)](http://opensource.org/licenses/BSD-3-Clause)

The project currently contains the following modules:

- [Console Demos](console)
  - [Basic Console Demos](console/basic)
  - [Java 8 Console Demos](console/java8)
  - [Java 10 Console Demos](console/java10)
- [System Specific demos](console/systems)
- [Device Specific demos](device)
  - [Hello Edison for Intel Edison IoT Devices](device/edison/hello)
  - [Sensor Web Demos for Intel Edison IoT Devices](device/edison/sensorweb)
  - [Device I/O for for Intel Edison IoT Devices](device/edison/dio) **TBD**
- [Domain Specific demos](domain)
- [JavaFX Demos](javafx)
 - [FXlib Demo Application](javafx/fxlib)
- [Java ME 8 Demos](javame) **Currently not Maven enabled, require Eclipse or NetBeans IDE**
  - [Java ME 8 Demo](javame/medemo)
- [Web Demos](web)
  - [Spark Sensor Web API Demo](web/sparkdemo)
  - [Improved JBoss Temperature Converter](web/temperature-converter)


[![Stories in Ready](https://badge.waffle.io/unitsofmeasurement/uom-demos.png?label=ready&title=Ready)](https://waffle.io/unitsofmeasurement/uom-demos)

[![Throughput Graph](https://graphs.waffle.io/unitsofmeasurement/uom-demos/throughput.svg)](https://waffle.io/unitsofmeasurement/uom-demos/metrics)

Launch Config for JBoss Developer Studio or Eclipse
-------------------------------------
If you use JBoss Developer Studio, Intel® IoT Developer Kit (for C/C++) or another Eclipse based solution, there are some launch configurations for your convenience under [src/etc](src/etc/).