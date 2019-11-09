# Biblioteca ECI
## Proyecto final de CVDS (Ciclos de Vida Del Desarrollo de Software). Periodo 2019-2
## Escuela Colombiana de Ingeniería Julio Garavito

### Integrantes:
* Brayan Felipe Rojas
* Simon Marin Mejia
* James Allan Weisnner
* Sergio Alejandro Bohórquez 

### Profesor:
* Julián Velasco


## Descripción del producto

## Arquitectura y diseño detallado

### Modelo E-R (Entidad-Relación)
![Modelo E-R](https://github.com/2019-2-PROYCVDS-WILDCAT/Proyecto_CVDS/blob/master/img/ModeloER3.png)
### Diagrama de clases de Entidades
![Diagrama de clases](https://github.com/2019-2-PROYCVDS-WILDCAT/Proyecto_CVDS/blob/master/img/DClases.png)
### Diagrama de paquetes
![Diagrama de clases](https://github.com/2019-2-PROYCVDS-WILDCAT/Proyecto_CVDS/blob/master/img/DiagramaPaquetes.png)
### Descripción de la arquitectura y tecnologías utilizadas
### Enlace de la aplicación en Heroku

https://gestion-recursos-bibliotecaeci.herokuapp.com/

### Despliegue continuo

[![CircleCI](https://circleci.com/gh/2019-2-PROYCVDS-WILDCAT/Proyecto_CVDS.svg?style=svg)](https://circleci.com/gh/2019-2-PROYCVDS-WILDCAT/Proyecto_CVDS)

### Calidad del código
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/96529c2ddd674254b403a423975f8402)](https://www.codacy.com/manual/SimonMarinM/Proyecto_CVDS?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=2019-2-PROYCVDS-WILDCAT/Proyecto_CVDS&amp;utm_campaign=Badge_Grade)

## Descripción del proceso

### Sprint 1
Durante el desarrollo del Sprint 1 del proyecto de Gestión de Recursos de la Biblioteca tratamos de identificar las clases/entidades y relaciones básicas en la base de datos que eran requeridos en la primera fase del proyecto. Teniendo todos los requerimientos bien formalizados procedemos a hacer un diagrama de clases y un diagrama entidad relación, de esta manera nos sería más claro implementar el código necesario.

La primera sección de código fue relacionada a la base de datos inicial de usuarios, la cual contiene los correos electrónicos y las contraseñas de todas las personas registradas en la plataforma de la biblioteca. Con esto listo procedimos a completar la implementación de MyBatis, la cual establece una "conexión" entre nuestro código de Java y los diferentes elementos almacenados en la base de datos. En esta parte se experimentaron algunas dificultades ya que el cambio del motor de base de datos MySQL a PostgreSQL nos dio algunos inconvenientes principalmente a la hora de configurar la información de acceso a la base de datos.
Una vez que la parte lógica de MyBatis fue completada se empezó a trabajar en la implementación del framework ApacheShiro, el cual era vital para completar la tarea más importante, la pantalla de Login de los usuarios. Nuevamente, nos costó trabajo pasar por esta fase del proyecto, debido a que la documentación de ApacheShiro no nos quedó muy clara y no era muy abundante en internet, esta situación fue eventualmente superada tras una mejor lectura y comprensión del uso de este framework, finalmente a lo largo de las tareas "Consultar Recurso", "Cambiar estado de un recurso" y "Registrar un recurso", solo tuvimos que actualizar lo que ya estaba hecho para que soportara estas nuevas características, al principio creíamos que esto sería una tarea trivial, pero a lo largo del Sprint 1 nos costó mucho trabajo actualizar el Front end de la página mediante los scripts hechos en JS y los documentos de estilos CSS. En retrospectiva general este fue el problema más significativo en el proyecto y en su mayor parte fue provocado por la poca experiencia de todos los integrantes del grupo en el uso de JS y CSS.

### Sprint 1 - Backlog

![Sprint Backlog](https://github.com/2019-2-PROYCVDS-WILDCAT/Proyecto_CVDS/blob/master/img/sprint%201%20backlog.PNG)

### Sprint 1 - Burndown chart

![Sprint Burndown chart](https://github.com/2019-2-PROYCVDS-WILDCAT/Proyecto_CVDS/blob/master/img/sprint%201%20burndown%20chart.PNG)
