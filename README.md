# Proyecto de Prueba con Selenium, Java y Maven.
### Proyecto de pruebas automatizadas utilizando Selenium WebDriver con Java y gestionado con Maven. 
<sub> Puede servir como base para iniciar un framework de automatización de pruebas.</sub>

**Tecnologias utilizadas:**
* Java Development Kit (JDK) v17.0.7
* Selenium WebDriver v3.141.59
* Cucumber v7.9.0
* Reportes: Allure v2.20.0
* Maven
* IDE: IntelliJ
* SO: Windows 10

**Estructura del Proyecto:**
El proyecto sigue la estructura POM estándar de un proyecto Maven

* src/main/java: Contiene las clases principales del proyecto.
* src/test/java: Contiene los steps escritos en Java con Selenium WebDriver.
* src/test/resources: Contiene el feature de cucumber que realiza todo el flujo del test.
* pom.xml: Archivo de configuración de Maven que define las dependencias y la configuración del proyecto.

**Descargar dependencias Maven:**
``mvn clean install``

**Ejecutar test:**
``mvn test``

