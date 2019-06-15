# Units of Measurement (JSR-385) Spring Boot demo

This is a small demo to demonstrate unit and prefix conversion using the RI of JSR-385 in a Spring Boot application.

# Usage (using HTTPie)

```bash
http POST http://localhost:7070/conversion value=80 prefix=KILO unit=g targetPrefix=MILLI targetUnit=g
```

*value* is the value to convert

*prefix* and *targetPrefix* are valid String representation values from [javax.measure.MetricPrefix](http://unitsofmeasurement.github.io/unit-api/site/apidocs/index.html?javax/measure/MetricPrefix.html)

*unit* and *targetUnit* are valid String representation values from [tech.units.indriya.unit.Units](https://github.com/unitsofmeasurement/indriya/blob/master/src/main/java/tech/units/indriya/unit/Units.java)

Source and target units/prefixes should be compatible (e.g. can't convert from grams to meters) or it will result in a bad request.

The response will look similar to the output below:

```json
{
    "input": {
        "prefix": "KILO",
        "targetPrefix": "MILLI",
        "targetUnit": "g",
        "unit": "g",
        "value": 80
    },
    "targetValue": 80000000.0
}
```

### Original reference
The original repository that was created during our [Adopt-a-JSR Day](https://www.meetup.com/Utrecht-Java-User-Group/events/261238917/) can be found [here](https://github.com/NLxAROSA/uom-sb-demo).

### Contributors
[<img alt="NLxAROSA" src="https://avatars1.githubusercontent.com/u/2574658?s=200&v=4">](https://github.com/NLxAROSA) |[<img alt="koaben" src="https://avatars0.githubusercontent.com/u/964063?s=200&v=4">](https://github.com/koaben)
|:---:|:---:|
[NLxAROSA](https://github.com/NLxAROSA)| [koaben](https://github.com/koaben)|