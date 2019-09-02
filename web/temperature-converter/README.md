temperature-converter: Stateless Session EJB
=================================================
Author: Bruce Wolfe, Werner Keil
Level: Beginner
Technologies: CDI, JSF, SLSB EJB, JSR 385
Summary: Demonstrates a stateless session bean 

[![License](http://img.shields.io/badge/license-Apache2-red.svg)](http://opensource.org/licenses/apache-2.0)

What is it?
-----------
**Based on quickstarts to demonstrate Java EE and a few additional technologies from the JBoss stack.**

The `temperature-converter` example demonstrates the use of an *EJB 3.1 Stateless Session Bean* (SLSB) and *CDI*, accessed using a *JSF*, converting temperatures via **JSR 385**, deployed to a compatible **Java EE 8** container like Wildfly.

These are the steps that occur:

1. The user interface is a JSF page that asks for a temperature and a scale (Kelvin or Celsius).
2. When you click on `Convert`, the temperature string is passed to the TemperatureConverter controller (managed) bean.
3. The managed bean then invokes the `convert()` method of the injected TemperatureConvertEJB (notice the field annotated with @Inject).
4. The response from TemperatureConvertEJB is stored in the `temperature` field of the managed bean.
5. The managed bean is annotated as @SessionScoped, so the same managed bean instance is used for the entire session.


System requirements
-------------------

All you need to build this project is Java 8.0 or above, running [Indriya](https://github.com/unitsofmeasurement/indriya) and Maven 3.0 or better.

The application this project produces is designed to be run on Wildfly 13 or higher. 

 
Configure Maven
---------------

If you have not yet done so, you must [Configure Maven](../README.md#mavenconfiguration) before testing the quickstarts.


Start Wildfly with the Web Profile
-------------------------

1. Open a command line and navigate to the root of the JBoss server directory.
2. The following shows the command line to start the server with the web profile:

        For Linux:   JBOSS_HOME/bin/standalone.sh
        For Windows: JBOSS_HOME\bin\standalone.bat


Build and Deploy the Quickstart
-------------------------

_NOTE: The following build command assumes you have configured your Maven user settings. If you have not, you must include Maven setting arguments on the command line. See [Build and Deploy the Quickstarts](../README.md#buildanddeploy) for complete instructions and additional options._

1. Make sure you have started the JBoss Server as described above.
2. Open a command line and navigate to the root directory of this quickstart.
3. Type this command to build and deploy the archive:

        mvn clean package jboss-as:deploy // older JBoss installations
        
      or
      
        mvn clean package jboss-as:deploy // WildFly installations

4. This will deploy `target/temperature-converter.war` to the running instance of the server.
 

Access the application 
---------------------

The application will be running at the following URL: <http://localhost:8080/temperature-converter/>.

You will be presented with a simple form for temperature conversion.

1. Optionally, Select a scale: Celsius or Kelvin.
2. Enter a temperature.
3. Press the `Convert` button to see the results.


Undeploy the Archive
--------------------

1. Make sure you have started the JBoss Server as described above.
2. Open a command line and navigate to the root directory of this quickstart.
3. When you are finished testing, type this command to undeploy the archive:

        mvn package jboss-as:undeploy


        
Run the Quickstart in JBoss Developer Studio or Eclipse
-------------------------------------
You can also start the server and deploy the quickstarts from Eclipse using JBoss tools. For more information, see [Use JBoss Developer Studio or Eclipse to Run the Quickstarts](../README.md/#useeclipse) 


Debug the Application
------------------------------------

If you want to debug the source code or look at the Javadocs of any library in the project, run either of the following commands to pull them into your local repository. The IDE should then detect them.

      mvn dependency:sources
      mvn dependency:resolve -Dclassifier=javadoc
