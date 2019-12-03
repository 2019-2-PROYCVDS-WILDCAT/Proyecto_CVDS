# Biblioteca ECI
## Proyecto final de CVDS (Ciclos de Vida Del Desarrollo de Software). Periodo 2019-2
## Escuela Colombiana de Ingeniería Julio Garavito

### Integrantes:
|   *TEAM*                      |        *ROL*                |
|-------------------------------|-----------------------------|
|`Julián Velasco`               |`Product Owner`              |
|`James Allan Weisnner`         |`Team Developer`             |
|`Simon Marin Mejia`            |`Team Developer`             |
|`Brayan Felipe Rojas`          |`Team Developer`             |
|`Sergio Alejandro Bohórquez`   |`Team Developer`             |



### Profesor:
* Julián Velasco (Product Owner)


## Descripción del producto
Gestión de Recursos-Biblioteca es un servicio que esta diseñado para facilitar toda la gestion a la hora de registrar, consultar y reservar, los diferentes recursos que estan disponibles , en la biblioteca de la Escuela Colombiana de Ingenieria, como lo son libros, Salas de estudio y dispositivos multimendia para diferentes tipos de usuarios que deseén hacer uso de los recursos ofrecidos. El manejo de sesiones para cada usuario es controlado con un login implementado con Apache Shiro que permite la autenticacion, autorizacion y gestion de sesiones. A su vez, manejamos tres tipos de usuarios. Comunidad, Administrador y una vista publica para cualquier usuario que quiera ver los recursos que posee la bliblioteca de la universidad. La comunidad contara con servicios para consultar y reservar cualquier recursos, siempre y cuando este disponible. Los administradores tendran la opcion de registrar, cambiar de estado (Disponible o Dañado), consultar y ver las reservas correspondientes a cualquier recurso. La vista disponible para el publico solo tiene la opcion de visualizar los recuros disponibles. 

Para detallar las funcionalidades en su totalidad desarrollamos el siguiente manual 
Ver [funcionalidades](manual.md)

## Arquitectura y diseño detallado

### Modelo E-R (Entidad-Relación)
![Modelo E-R](https://github.com/2019-2-PROYCVDS-WILDCAT/Proyecto_CVDS/blob/master/img/ModeloER3.png)
### Diagrama de clases de Entidades
![Diagrama de clases](https://github.com/2019-2-PROYCVDS-WILDCAT/Proyecto_CVDS/blob/master/img/DClasesA.png)
### Diagrama de paquetes
![Diagrama de clases](https://github.com/2019-2-PROYCVDS-WILDCAT/Proyecto_CVDS/blob/master/img/DiagramaPaquetes.png)

### Cobertura de pruebas
![eljuasjuas](/img/jacoco.PNG)
![eljuasjuas2](/img/jacoco1.PNG)

### Descripción de la arquitectura y tecnologías utilizadas

#### PrimeFaces

Cuenta con una gran cantidad de componentes que permiten la versatilidad a la hora de desarrollar una vista en una aplicacion web. PrimeFaces tambien permite una facil implementacion ya que es una biblioteca de componentes para JavaServer Faces con codigo abierto 

#### jQuery

Es una biblioteca de JavaScript que permite la manipulacion de documentos HTML, manejo de eventos, animaciones y ajax proporcionando una simple API que permite la facil navegacion de los usuarios por la aplicacion 

#### PostgreSQL
Es un sistema de gestion de base de datos general y relacional. Esta diseñado para porderse ejecutar desde distintas plataformas y poseé caracteristicas avanzadas como herencia de tablas, Transacciones anidada, entre mcuhas otras caracteristicas.

#### Bootstrap
Es un framework CSS que contiene plantillas para agregar componentes a la interfaz grafica y que sea mas amigable para el usuario que desee utilizar la aplicacion web 

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

### Sprint 3
Este sprint fue el sprint final en el desarrollo de la plataforma virtual para la biblioteca, fue enfocado en la extensión y mejora de las funcionalidades relacionadas a la reserva, en este fueron añadidas las Características de cancelar una reserva y hacer un reporte de ocupación de las reservas, entre otras funcionalidades como las de poder consultar el estado de una reserva y poder visualizarlas (siendo un usuario registrado o no registrado).
En este sprint se trató de pulir el proyecto de manera general, eliminar remanentes de métodos y clases que fueron descartadas, pero seguían en el código y la mejora de algunas pruebas que estaban poblando de manera innecesaria la base de datos principal. Pero los aspectos que más destacan son los de la cancelación de una reserva y el del reporte de ocupación (funcionalidad solamente disponible para los administradores del portal web). Por un lado la cancelación de la reserva no se deshace totalmente de una reserva sino que cambia su estado (columna que fue llamada "activa"), cuando una reserva deja de ser vigente su estado cambia de activa (true) a inactiva (false), lo cual permite no descartar toda la información de una reserva, que posteriormente puede ser útil para hacer diferentes análisis en el uso y la ocupación de los recursos, lo que nos lleva al siguiente avance principal hecho en este sprint, el reporte de ocupación. El reporte de ocupación es una funcionalidad destinada a los administradores del portal web de la biblioteca y brinda variada información estadística al administrador acerca del comportamiento de las reservas, acá se encontrará información como: Los recursos más usados, los recursos menos usados, horarios de mayor ocupación de recursos, horarios de menor ocupación de recursos, reservas recurrentes y reservas canceladas. Sin lugar a duda esta fue la característica que consumió más tiempo en el sprint, ya que la integración de graficas en la página web no fue tarea fácil.

En conclusión con el desarrollo del proyecto pudimos darnos cuenta que tan importante es la organización y la buena administración del tiempo para tener resultados favorables, establecer metas y calcular el tiempo que se tomara cumplirlas es un detalle que no debería ser pasado por alto en el desarrollo de un proyecto de esta magnitud, esto nos muestra que codificar de manera inquisitiva no siempre resuelve todos los problemas de un proyecto de desarrollo de software y que sin lugar nunca hay que subestimar el tiempo que tomara aprender a usar una herramienta. Esto fue evidenciado principalmente en el desarrollo del "Front end" de la plataforma, que durante todo el proyecto demostró ser la parte más desafiante, debido a que era un nuevo tópico para todos los integrantes del equipo. Finalmente, la culminación de este proyecto nos hizo utilizar y afianzar varias habilidades que han sido aprendidas durante toda la carrera, como el uso de bases de datos, la programación orientada a objetos, el desarrollo de pruebas al código, la escritura de archivos XML, entre otras.

### Sprint 3 - Backlog

![Sprint2 Backlog](https://github.com/2019-2-PROYCVDS-WILDCAT/Proyecto_CVDS/blob/master/img/Sprint%203%20Backlog.PNG)

### Sprint 3 - Burndown chart

![Sprint2 Backlog](/img/sprint3.png)




