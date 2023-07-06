# Vitro Prueba Tecnica 
### Proyecto de pruebas automatizadas utilizando Selenium WebDriver con Java y gestionado con Maven. 
<sub> Puede servir como base para iniciar un framework de automatización de pruebas.</sub>

**Tecnologias utilizadas:**
* JDK 17
* Selenium WebDriver v4.9.0
* Cucumber v7.12.0
* Reports: Allure v2.22.0
* Building Tool: Maven
* IDE: IntelliJ

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

**Generar reporte:**
``mvn allure:serve``

