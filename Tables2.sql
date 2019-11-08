select * from usuarios; 
create table reservas(
	id int,
	id_usuario varchar(200), 
	id_recurso int, 
	estado bool, 
	fecha_inicio_reserva date,
	fecha_fin_reserva date 
);
CREATE TABLE recursos (
   id int  NOT NULL,
   estado varchar(100)  NOT NULL,
   nombre varchar(100)  NOT NULL,
   ubicacion varchar(100)  NOT NULL,
   tipo varchar(100)  NOT NULL,
   capacidad int  NOT NULL
);
CREATE TABLE Horarios (
   id int  NOT NULL,
   fran char(11)  NOT NULL
);
CREATE TABLE Disponibilidad (
   Recursos_id int  NOT NULL,
   Horarios_id int  NOT NULL
);


alter table reservas add primary key (id);
alter table recursos add primary key (id);
alter table horarios add primary key (id);
alter table disponibilidad add primary key (Recursos_id,Horarios_id);

ALTER TABLE reservas add CONSTRAINT fk_reservas_recursos 
FOREIGN KEY (id_recurso) REFERENCES recursos(id);


ALTER TABLE reservas add CONSTRAINT fk_reservas_usuarios 
FOREIGN KEY (id_usuario) REFERENCES usuarios(email);

ALTER TABLE disponibilidad add CONSTRAINT fk_disponibilidad_recursos 
FOREIGN KEY (recursos_id) REFERENCES recursos(id);


ALTER TABLE disponibilidad add CONSTRAINT fk_disponibilidad_horarios
FOREIGN KEY (horarios_id) REFERENCES horarios(id);

insert into recursos values (1,'disponible','locaina','Bosa-C','Libro',0);
insert into reservas values (1,'hawaii50@mail.com',1,true,'2017-03-14', '2017-04-30');
insert into horarios values(1,'07:00');
insert into horarios values(2,'08:30');
insert into disponibilidad values(1,1);
insert into disponibilidad values(1,2);
