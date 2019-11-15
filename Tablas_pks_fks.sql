----CRUD USUARIOS---
create table if not exists tipo_usuario(
	id int not null,
	tipo varchar(32) not null
);

create table if not exists Usuarios(
	nombre varchar(100) not null,
	apellido varchar(100) not null,
	email varchar(200) not null,
	password varchar(32) not null,
	Tipo_Usuario_id integer not null
);

ALTER TABLE Tipo_Usuario add PRIMARY KEY (id);
ALTER TABLE Usuarios add PRIMARY KEY (email);

Alter table usuarios add constraint fk_usuarios_tipo_usuarios
foreign key (tipo_usuario_id) 
references tipo_usuario(id)
;







---CRUD RECURSOS----
CREATE TABLE if not exists recursos (
   id int  NOT NULL,
   estado varchar(100)  NOT NULL,
   nombre varchar(100)  NOT NULL,
   ubicacion varchar(100)  NOT NULL,
   tipo varchar(100)  NOT NULL,
   capacidad int  NOT NULL
);

create table if not exists disponibilidad(
	id int not null,
	idRecurso int not null,
	fechaInicio date not null,
	fechaFin date not null
);






---CRUD Reservas----

create table if not exists reservas(
	id int,
	id_usuario varchar(200), 
	id_recurso int, 
	estado bool, 
	fecha_inicio_reserva date,
	fecha_fin_reserva date 
);

alter table reservas add primary key (id);
alter table recursos add primary key (id);
alter table horarios add primary key (id);
alter table disponibilidad add primary key (id);

ALTER TABLE reservas add CONSTRAINT fk_reservas_recursos 
FOREIGN KEY (id_recurso) REFERENCES recursos(id);


ALTER TABLE reservas add CONSTRAINT fk_reservas_usuarios 
FOREIGN KEY (id_usuario) REFERENCES usuarios(email);

ALTER TABLE disponibilidad add CONSTRAINT fk_disponibilidad_recursos 
FOREIGN KEY (idRecurso) REFERENCES recursos(id);





