# SHECucumberAutomation
**Author:**
Kunduz Sagynova SDET

**Project Title :**
 SHE Cucumber Automation 

**Installation guide:** 
This is a maven project. so It's assumed that the host running this code have Java and maven installed and JAVA_HOME already set. 
Here is the guide for maven installation just in case : https://maven.apache.org/install.html

Project get all dependencies from maven repository. So no additional installation needed.

**Below are the dependencies are being used for this project :** 
Bonigarcia WebdriverManager,
Selenium-Java,
Cucumber-Junit,
Cucumber-Java


**Build Plugins:**
Build plugins are added inPOM.XML for Cucumber HTML Reports
Once you run your test Cucumber HTML report will generate on the Target folder.

**Credentials :** 
SHE URL, Username, Password  to externalize the data a configuration reader utility are created to read configuration.properties. 
Due to sensitive nature of the keys, user is expected to provide his/her own credentials. 

**Build and run your project :** 
This is maven project and tests are written in Cucumber BDD with Gerkin language . So we can use maven command line commands (mvn clean test) to run the project as as well as
with CukesRunner class.

Framework can be built with using TestNg but preferred to Cucumber BDD use Junit.
It is created basic Page Object Model design pattern but it can improve if needed.
