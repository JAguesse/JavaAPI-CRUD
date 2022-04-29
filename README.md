# JavaAPI-CRUD

Execution order: 

# My SQL 
execute:  <br /> 
- 01-create-user.sql <br /> 
I use the JPA annotation so the @entity from java will be created automaticaly. <br/ >

If you want to check the table use this script : <br /> 
- 02-database-python-api-rest.sql <br /> 

Configuration:

spring.jpa.hibernate.ddl-auto=update <br />
spring.datasource.url=jdbc:mysql://localhost:3306/restaurant <br />
spring.datasource.username=javaapirest <br />
spring.datasource.password=javaapirest <br />
spring.datasource.driver-class-name =com.mysql.jdbc.Driver <br />
#spring.jpa.show-sql: true'  <br /> 

# Java 
run the project from an IDE <br /> 

# Commande
Use Postman  <br /> 
./Restaurant - API.postman_collection.json.json (File ==> Import...) <br /> 

# API resource routes

Menu : <br />
- @GetMapping("/restaurants/{idResto}/menus") : findAllFromIdRestaurant <br />
- @GetMapping("/menus/{idMenu}") : findById <br />
- @PostMapping("restaurants/{idResto}/menus") : create <br />
- @PutMapping("menus/{idMenu}") : update <br />
- @PatchMapping("menus/{idMenu}") : partialUpdate <br />
- @DeleteMapping("restaurants/{idResto}/menus/{idMenu}") : delete <br /> <br />

Restaurant : <br />

- @RequestMapping("/restaurants")  <br />
- @GetMapping : findAll  <br />
- @GetMapping("/{id}") : findById  <br />
- @PostMapping() : create  <br />
- @PutMapping("/{id}") : update  <br />
- @PatchMapping("/{id}") : partialUpdate  <br />
- @DeleteMapping("/{id}") : deleteById  <br />

 <br />

For more information see the postman file (./Restaurant - API.postman_collection.json) <br />


# Informations
IDE: IntelliJ - Community <br /> 
Version: 2021.3.3 <br /> 
Library USE: <br /> 
- Spring Data JPA <br /> 
- Rest Repository <br /> 
- MySQL Driver <br /> 
- Lombok <br /> 