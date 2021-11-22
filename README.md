# Prueba técnica Atmira : Spring Boot

## Description

Exponer un endpoint que recibe un numero entre 1 y 7 y devuelve un listado en formato json con el top 3 de asteroides más grandes con potencial de riesgo de impacto en el planeta TIerra entre el día de hoy y la fecha obtenida de sumar a la fecha de hoy el número de días introducido como parámetro.

## Requirements

- Java 11
- Spring Boot 2
- Maven
- JUnit

## Services

### nasa-api
GET

    curl -X GET "http://localhost:8081/asteroid?days=3"  -H 'Accept: application/json'