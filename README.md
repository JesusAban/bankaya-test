# Bankaya Pokemon Api Test

This test consist on consume the api [https://pokeapi.co/docs/v2](https://pokeapi.co/docs/v2)

## Pre-requirements

This test using the following Environment variables:

```
${DB_HOST} #Mysql host completed, example: jdbc:mysql://my_db:my_port/my_schema
${DB_USER_NAME} #User that will use the BD
${DB_PASSWORD} #User's Password that will use the DB
```
Also, we required:

+ Java 17
+ Maven
+ Mysql
+ The IDE of your preference

## Task completed

- [x] Api REST to consume (using param Pokemon's name):
  - [x] abilities
  - [x] base_experience
  - [x] held_items
  - [x] id
  - [x] name
  - [x] location_area_encounters
- [x] Save on Database
  - [x] ip de origin
  - [x] fecha de request
  - [x] método que se ejecuta
  - [x] Variables opcionales:
    - [x] tiempo duración de la petición
    - [x] request
    - [x] response
- [ ] Parte del entregable como requerido:
  - [ ] analisis con sonarqube
  - [x] pruebas unitarias
  - [ ] cucumber
- [ ] Adicionales:
  - [ ] dockerizar el proyecto
  - [x] swagger
  - [x] patrones de diseño alterno a MVC
- [x] Agregados por mi
  - [x] BD migrations (Liquibase)

> I tried to implement Docker but, I got some issues between MySQL and the API I added those file on the root folder

> I tried to include Sonarqube but, I'm using a virtual machine to build this API to avoid have more control con Docker, and my machine was broken several times trying to run Sonarqube and IntelliJ IDEA at the same time :weary:

## Execution

To run this application you need to consult [Pre-requirements](##Pre-requirements)
1. After that, you need execute this script:
``` bash
mvn clean compile package
```
2. Wait to all dependencies will be downloaded and the jar file will be generated.
3. Once previous step will be completed, you need to execute the following command:
``` bash
java -jar target/pokemon-test-1.0.0.jar
```
4. To validate if all is running well, you can check it directly on [Swagger](http://localhost:8080/swagger-ui/index.html)
