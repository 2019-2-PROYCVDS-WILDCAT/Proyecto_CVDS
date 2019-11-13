create table if not exists Tipo_Usuario(
	id integer not null,
	tipo varchar(20)
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
