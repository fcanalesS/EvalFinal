#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Ingreso de una agenda de de hora para una mascota
Scenario: Verificacion de ingrese de una agenda de hora para una mascota
Given Abrir Chrome agenda
When Ingresa Username "test1" y Password "test123" agenda
When Elige menu Ingreso Agenda agenda
Then Llena los datos de la agenda con idMascota "8", Rut "1-2", nombreMascota "Mascota", hora "10.45" y fecha "2023-05-01" agenda

