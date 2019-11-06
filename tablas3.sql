select *
from Usuarios u
WHERE u.email = 'hawaii50@mail.com';

select * from reservas;
select * 
from reservas res,recursos rec,disponibilidad d,horarios h,usuarios u
where h.id = d.horarios_id and d.recursos_id = rec.id and rec.id = res.id_recurso and res.id_usuario = u.email


create table tipo_usuario(id int,tipo varchar(32));
alter table tipo_usuario add primary key (id);
insert into tipo_usuario values(1,'comunidad');
insert into tipo_usuario values(2,'administrador');
alter table usuarios add constraint fk_usuarios_tipo_usuario
foreign key(tipo_usuario_id) references tipo_usuario(id);