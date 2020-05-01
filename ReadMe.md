# SALEM

## Description du projet

Site web pour Associton à but non lucratif

## Contexte

## Convention code http entre Client et Server

| Designation  | code | valeur |
| :------------| :--- | :----- |
| Succès |  HttpStatus.OK | "200 OK"|
| Create | HttpStatus.CREATED | "201 CREATED" |
| Server Error  | HttpStatus.INTERNAL_SERVER_ERROR |"500 INTERNAL_SERVER_ERROR" |
| Not found | HttpStatus.FOUND | "404 NOT_FOUND" |
| Bad request | HttpStatus.BAD_REQUEST | "400 BAD_REQUEST" |
| Found | HttpStatus.FOUND | "302 FOUND" |


## Convention taille des variables pour DonRequestDTO

| Designation  | Taille min| Taille max | Null | Autre contrainte |
| :------------| :--- | :----- | :----- | :----- |
| firstName | 1 | 30 | Nom | - | 
| lasttName | 1 | 30 | Nom | - |
| email | 1 | 30 | Non | email |
| RoadNumber | 0 | 255 | Oui | - |
| town | 0 | 30 | Oui | - |
| zipCode | 0 | 10 | Oui | - |
| phoneNumber | 0 | 20 | Oui | - |
| king | 0 | 200 | Oui | - |
| comment | 0 | 100 | Oui | - |
