# David's Automated BDD Testing - Vueling Flight Search

#### Fundamentos de pruebas 23/24
#### Entregable 1 Serenity BDD
#### David Hernández Cárdenas - [david.hc@students.salle.url.edu](david.hc@students.salle.url.edu)

---

Este README proporciona instrucciones acerca de la ejecución del `FlightSearchTest` sobre el website de [Vueling.com](https://www.vueling.com/).

## Herramientas Utilizadas

- Java
- Selenium WebDriver
- Cucumber
- Serenity BDD
- Gherkin
- Gradle
- JUnit

## Patrones Utilizados
- Page Object Model
- Facade
- Builder

## Dependencias técnicas

- Java Development Kit (JDK) instalado en su máquina (versión 21).
- Gradle instalado en su máquina.
- IDE IntelliJ IDEA instalado en su máquina.

## Pasos para ejecutar la prueba

1. Abrir el proyecto en IntelliJ IDEA.

2. Sincronizar el proyecto con Gradle.
    - Hacer clic en el botón "Sync Project with Gradle Files" en la esquina superior derecha de la ventana.
    - O bien, ir a `View > Tool Windows > Gradle` y hacer clic en el botón "Sync" en la esquina superior izquierda de la ventana.
    - O bien, ejecutar el comando `gradle build` en la terminal.

<img width="1434" alt="GradleSync" src="https://github-production-user-asset-6210df.s3.amazonaws.com/22640061/304192530-619b6083-5d4e-49c1-89a6-47ddf1e8548d.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAVCODYLSA53PQK4ZA%2F20240212%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20240212T190158Z&X-Amz-Expires=300&X-Amz-Signature=a4d2081eda5eb08000ab19cf56bf160b168de81c29ac8ec4db0186cc4f22063a&X-Amz-SignedHeaders=host&actor_id=22640061&key_id=0&repo_id=754375056">

3. Ejecutar la prueba desde el archivo `FlightSearchTest.java`.
    - Hacer clic derecho sobre el archivo `FlightSearchTest.java` y seleccionar la opción "Run 'FlightSearchTest'".
    - O bien, hacer clic en el botón verde de reproducción en la esquina superior derecha de la ventana.
    - O bien, ejecutar el comando `gradle test` en la terminal.

<img width="1432" alt="TestExecution" src="https://github-production-user-asset-6210df.s3.amazonaws.com/22640061/304192631-7962aa11-9749-4804-957b-6837c75e3c4d.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAVCODYLSA53PQK4ZA%2F20240212%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20240212T190027Z&X-Amz-Expires=300&X-Amz-Signature=d6a294fb81722463f281dc8c05feadf630ac500996262cbe0668ef741ea58199&X-Amz-SignedHeaders=host&actor_id=22640061&key_id=0&repo_id=754375056">

4. Verificar el reporte generado en el fichero `target/site/serenity/index.html`.

<img width="1213" alt="Report1" src="https://github-production-user-asset-6210df.s3.amazonaws.com/22640061/304192680-eff63126-5e40-4257-bf83-7f9e4465de0e.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAVCODYLSA53PQK4ZA%2F20240212%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20240212T190223Z&X-Amz-Expires=300&X-Amz-Signature=4721e0d7d8c021467f2c06837a08803f41b4d57f329df0cadfe1626651cf797d&X-Amz-SignedHeaders=host&actor_id=22640061&key_id=0&repo_id=754375056">
<img width="1215" alt="Report2" src="https://github-production-user-asset-6210df.s3.amazonaws.com/22640061/304192705-7a717635-07f3-4652-8e23-a4f53674fd05.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAVCODYLSA53PQK4ZA%2F20240212%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20240212T190235Z&X-Amz-Expires=300&X-Amz-Signature=4890069f7dd9904afa586df847fc209f246e82d41b86b47d146185e39d059afc&X-Amz-SignedHeaders=host&actor_id=22640061&key_id=0&repo_id=754375056">

5. Verificar el video de la ejecución de la prueba:

<video src='https://github-production-user-asset-6210df.s3.amazonaws.com/22640061/304192842-539c72ed-4356-4fa2-a21a-88a391a69a05.mp4?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAVCODYLSA53PQK4ZA%2F20240212%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20240212T190257Z&X-Amz-Expires=300&X-Amz-Signature=1ffc49473c1cd0ab12d98fa049a0b49623a95adca2c05017fb443132ac379416&X-Amz-SignedHeaders=host&actor_id=22640061&key_id=0&repo_id=754375056' width=180/>
