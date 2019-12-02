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
![Diagrama de clases](https://github.com/2019-2-PROYCVDS-WILDCAT/Proyecto_CVDS/blob/master/img/DClasesA.png)
### Diagrama de paquetes
![Diagrama de clases](https://github.com/2019-2-PROYCVDS-WILDCAT/Proyecto_CVDS/blob/master/img/DiagramaPaquetes.png)
### Descripción de la arquitectura y tecnologías utilizadas
### Enlace de la aplicación en Heroku

https://gestion-recursos-bibliotecaeci.herokuapp.com/

### Despliegue continuo

[![CircleCI](https://circleci.com/gh/2019-2-PROYCVDS-WILDCAT/Proyecto_CVDS.svg?style=svg)](https://circleci.com/gh/2019-2-PROYCVDS-WILDCAT/Proyecto_CVDS)

### Calidad del código
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/96529c2ddd674254b403a423975f8402)](https://www.codacy.com/manual/SimonMarinM/Proyecto_CVDS?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=2019-2-PROYCVDS-WILDCAT/Proyecto_CVDS&amp;utm_campaign=Badge_Grade)

#### Taiga
 
[Taiga backlog](https://tree.taiga.io/project/kyrielw-gestion-de-recursos-biblioteca/backlog)

## Descripción del proceso

### Sprint 1
Durante el desarrollo del Sprint 1 del proyecto de Gestión de Recursos de la Biblioteca tratamos de identificar las clases/entidades y relaciones básicas en la base de datos que eran requeridos en la primera fase del proyecto. Teniendo todos los requerimientos bien formalizados procedemos a hacer un diagrama de clases y un diagrama entidad relación, de esta manera nos sería más claro implementar el código necesario.

La primera sección de código fue relacionada a la base de datos inicial de usuarios, la cual contiene los correos electrónicos y las contraseñas de todas las personas registradas en la plataforma de la biblioteca. Con esto listo procedimos a completar la implementación de MyBatis, la cual establece una "conexión" entre nuestro código de Java y los diferentes elementos almacenados en la base de datos. En esta parte se experimentaron algunas dificultades ya que el cambio del motor de base de datos MySQL a PostgreSQL nos dio algunos inconvenientes principalmente a la hora de configurar la información de acceso a la base de datos.
Una vez que la parte lógica de MyBatis fue completada se empezó a trabajar en la implementación del framework ApacheShiro, el cual era vital para completar la tarea más importante, la pantalla de Login de los usuarios. Nuevamente, nos costó trabajo pasar por esta fase del proyecto, debido a que la documentación de ApacheShiro no nos quedó muy clara y no era muy abundante en internet, esta situación fue eventualmente superada tras una mejor lectura y comprensión del uso de este framework, finalmente a lo largo de las tareas "Consultar Recurso", "Cambiar estado de un recurso" y "Registrar un recurso", solo tuvimos que actualizar lo que ya estaba hecho para que soportara estas nuevas características, al principio creíamos que esto sería una tarea trivial, pero a lo largo del Sprint 1 nos costó mucho trabajo actualizar el Front end de la página mediante los scripts hechos en JS y los documentos de estilos CSS. En retrospectiva general este fue el problema más significativo en el proyecto y en su mayor parte fue provocado por la poca experiencia de todos los integrantes del grupo en el uso de JS y CSS.

### Sprint 1 - Backlog

![Sprint Backlog](https://github.com/2019-2-PROYCVDS-WILDCAT/Proyecto_CVDS/blob/master/img/sprint%201%20backlog.PNG)

### Sprint 1 - Burndown chart

![Sprint Burndown chart](https://github.com/2019-2-PROYCVDS-WILDCAT/Proyecto_CVDS/blob/master/img/sprint%201%20burndown%20chart.PNG)

### Sprint 2
El Sprint 2 fue enfocado principalmente en el desarrollo de todo lo relacionado a la reserva de un recurso, parte que enlaza elementos de la disponibilidad horaria, usuarios de la plataforma y recursos registrados. En este sprint no solo tuvimos que ampliar la base de datos para relacionar usuarios y recursos sino hacer grandes cambios en la interfaz gráfica de manera en que cada reserva pudiese ser vista de manera gráfica y agradable para el usuario.

El principio del sprint comenzó con una falla en la administración del tiempo del mismo, ya que no se consideró la cantidad de tiempo que tomaría hacer las correcciones pertinentes del anterior sprint (Sprint 1), las correcciones en los derechos de visualización de los recursos para usuarios no autenticados tomaron parte del tiempo que debió haber sido dedicado a el planeamiento del sprint y que finalmente dejo una gráfica imprecisa del Sprint Burndown, debido a que se pasaron varios días sin completar ninguna tarea.
Iniciando este Sprint, supimos que la parte que más tomaría tiempo seria la implementación grafica de un calendario que mostrara las reservas, por lo cual se empezó por la investigación de cómo se llegaría a este resultado, mientras tanto los encargados del backend del proyecto hacían los cambios pertinentes para poder representar correctamente una reserva regular (no recursiva), esta parte tuvo varios cambios surgidos de opiniones divididas de como serian representados los horarios de una reserva, debido a que anteriormente se tenía prevista una tabla dedicada únicamente a las franjas de los horarios (Ex. 7:00 AM a 8:30 AM), lo cual fue cambiado en este sprint por dos columnas que representan el inicio de una reserva y el final de la misma. Luego de que la reserva regular de un recurso y la interfaz gráfica fueron completadas se hicieron las pruebas de estas y se enlazaron todos los componentes de frontend con los componentes de backend. Luego, nos dispusimos a implementar la reserva recursiva, la cual planteo nuevos retos para su desarrollo, inicialmente se trato de hacer mediante triggers y funciones de PostgreSQL, pero durante este proceso nos dimos cuenta de que esta tarea era mucho mas sencilla mediante código en Java (método addReservaRecursiva en la clase MyBatisReservaDAO). Mas tarde esta nueva funcionalidad fue enlazada con la interfaz grafica y probada mediante GUnit.


### Sprint 2 - Backlog

![Sprint2 Backlog](https://github.com/2019-2-PROYCVDS-WILDCAT/Proyecto_CVDS/blob/master/img/Sprint%202%20Backlog.PNG)

### Sprint 2 - Burndown chart

![Sprint2 Burndown chart](https://github.com/2019-2-PROYCVDS-WILDCAT/Proyecto_CVDS/blob/master/img/Sprint%202%20Burndown%20chart.PNG)





