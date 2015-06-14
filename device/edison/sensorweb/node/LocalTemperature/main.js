/*jslint node:true,vars:true,bitwise:true,unparam:true */

/*jshint unused:true */

/*
The Local Temperature Node.js sample application distributed within Intel® XDK IoT Edition under the IoT with Node.js Projects project creation option showcases how to read analog data from a Grover Starter Kit Plus – IoT Intel® Edition Temperature Sensor, start a web server and communicate wirelessly using WebSockets.

MRAA - Low Level Skeleton Library for Communication on GNU/Linux platforms
Library in C/C++ to interface with Galileo & other Intel platforms, in a structured and sane API with port nanmes/numbering that match boards & with bindings to javascript & python.

Steps for installing MRAA & UPM Library on Intel IoT Platform with IoTDevKit Linux* image
Using a ssh client: 
1. echo "src maa-upm http://iotdk.intel.com/repos/1.1/intelgalactic" > /etc/opkg/intel-iotdk.conf
2. opkg update
3. opkg upgrade

Article: https://software.intel.com/en-us/html5/articles/iot-local-temperature-nodejs-and-html5-samples
*/

var B = 3975;
var mraa = require("mraa");

var mco = require("mco");
var MetricSystem = mco.MetricSystem;
var UsCustomarySystem = mco.UsCustomarySystem;

//var mqtt    = require('mqtt');
//var client  = mqtt.connect('mqtt://192.168.50.76:1883');
      
//GROVE Kit A0 Connector --> Aio(0)
var myAnalogPin = new mraa.Aio(0);

/*
Function: startSensorWatch(socket)
Parameters: socket - client communication channel
Description: Read Temperature Sensor and send temperature in degrees of Fahrenheit every 4 seconds
*/
function startSensorWatch(socket) {
    'use strict';
        
    setInterval(function () {
        var a = myAnalogPin.read();
        //console.log("Analog Pin (A0) Output: " + a);
        //console.log("Checking....");
        
        var resistance = (1023 - a) * 10000 / a; //get the resistance of the sensor;
        //console.log("Resistance: "+resistance);
        var celsius_temperature = 1 / (Math.log(resistance / 10000) / B + 1 / 298.15) - 273.15;//convert to temperature via datasheet ;
        var celsius = new mco.UnitValue(celsius_temperature, MetricSystem.CELSIUS);
        console.log("Celsius Temperature "+celsius); 
        var fahrenheit =  mco.UnitTransformer.transform(celsius, UsCustomarySystem.FAHRENHEIT);
        var fahrenheit_temperature = fahrenheit.getValue();
        console.log("Fahrenheit Temperature: " + fahrenheit);
        socket.emit("message", fahrenheit_temperature);
    }, 4000);
}

console.log("Sample Reading Grove Kit Temperature Sensor");

//Create Socket.io server
var http = require('http');
var app = http.createServer(function (req, res) {
    'use strict';
    res.writeHead(200, {'Content-Type': 'text/plain'});
    res.end('<h1>Hello world from Intel IoT platform!</h1>');
}).listen(1337);
var io = require('socket.io')(app);

//Attach a 'connection' event handler to the server
io.on('connection', function (socket) {
    'use strict';
    console.log('a user connected');
    //Emits an event along with a message
    socket.emit('connected', 'Welcome');

    //Start watching Sensors connected to Galileo board
    startSensorWatch(socket);

    //Attach a 'disconnect' event handler to the socket
    socket.on('disconnect', function () {
        console.log('user disconnected');
    });
});