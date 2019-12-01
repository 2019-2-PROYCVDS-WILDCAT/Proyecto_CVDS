-- DROP SCHEMA public;



CREATE SCHEMA public AUTHORIZATION dgzsgodijyfsjh;



COMMENT ON SCHEMA public IS 'standard public schema';



-------------
--------------------TABLAS, PK's, FK's, CHECKS, TRIGGERS-----------------------------------
-- Drop table


-- DROP TABLE public.disponibilidad;



CREATE TABLE public.disponibilidad (
	id int4 NOT NULL,
	idrecurso int4 NOT NULL,
	fechainicio time NOT NULL,
	fechafin time NOT NULL,
	CONSTRAINT ck_disponibilidad_fechaini_fechafin CHECK ((fechainicio <= fechafin)),
	CONSTRAINT disponibilidad_pkey PRIMARY KEY (id),
	CONSTRAINT fk_disponibilidad_recursos FOREIGN KEY (idrecurso) REFERENCES recursos(id)
);



-- Permissions


ALTER TABLE public.disponibilidad OWNER TO dgzsgodijyfsjh;


GRANT ALL ON TABLE public.disponibilidad TO dgzsgodijyfsjh;



-- Drop table

-- DROP TABLE public.recursos;


CREATE TABLE public.recursos (
	id int4 NOT NULL,
	estado varchar(100) NOT NULL,
	nombre varchar(100) NOT NULL,
	ubicacion varchar(100) NOT NULL,
	tipo varchar(100) NOT NULL,
	capacidad int4 NOT NULL,
	horainicio time NULL,
	horafin time NULL,
	CONSTRAINT ck_recursos_capacidad CHECK ((capacidad >= 0)),
	CONSTRAINT ck_recursos_estado CHECK ((((estado)::text = 'Disponible'::text) OR ((estado)::text = 'Prestado'::text) OR ((estado)::text = 'Dañado'::text))),
	CONSTRAINT ck_recursos_horaini_horafin CHECK ((horainicio <= horafin)),
	CONSTRAINT ck_recursos_tipo CHECK ((((tipo)::text = 'Libro'::text) OR ((tipo)::text = 'Sala de estudio'::text) OR ((tipo)::text = 'Dispositivo multimedia'::text))),
	CONSTRAINT recursos_pkey PRIMARY KEY (id)
);



-- Table Triggers


-- DROP TRIGGER bu_recursos_pk ON public.recursos;


create trigger bu_recursos_pk before
insert
    on
    public.recursos for each row execute procedure bu_recursos_pk();


-- DROP TRIGGER automatizar_capacidad_recurso ON public.recursos;


create trigger automatizar_capacidad_recurso before
insert
    on
    public.recursos for each row execute procedure capacidad_automatica_recurso();



-- Permissions



ALTER TABLE public.recursos OWNER TO dgzsgodijyfsjh;
GRANT ALL ON TABLE public.recursos TO dgzsgodijyfsjh;




-- Drop table


-- DROP TABLE public.reservas;


CREATE TABLE public.reservas (
	id int4 NOT NULL,
	id_usuario varchar(200) NULL,
	id_recurso int4 NULL,
	fecha_inicio_reserva timestamp NULL,
	fecha_fin_reserva timestamp NULL,
	fecha_solicitud date NULL,
	tipo varchar NULL,
	activa bool NULL,
	CONSTRAINT ck_reservas_fechaini_fechafin CHECK ((fecha_inicio_reserva <= fecha_fin_reserva)),
	CONSTRAINT reservas_pkey PRIMARY KEY (id),
	CONSTRAINT fk_reservas_recursos FOREIGN KEY (id_recurso) REFERENCES recursos(id),
	CONSTRAINT fk_reservas_usuarios FOREIGN KEY (id_usuario) REFERENCES usuarios(email)
);



-- Table Triggers


-- DROP TRIGGER automatizar_reservas ON public.reservas;



create trigger automatizar_reservas before
insert
    on
    public.reservas for each row execute procedure automatizar_id_fecha_reservas();


-- Permissions



ALTER TABLE public.reservas OWNER TO dgzsgodijyfsjh;
GRANT ALL ON TABLE public.reservas TO dgzsgodijyfsjh;





-- Drop table


-- DROP TABLE public.tipo_usuario;



CREATE TABLE public.tipo_usuario (
	id int4 NOT NULL,
	tipo varchar(32) NULL,
	CONSTRAINT tipo_usuario_pkey PRIMARY KEY (id)
);


-- Permissions


ALTER TABLE public.tipo_usuario OWNER TO dgzsgodijyfsjh;
GRANT ALL ON TABLE public.tipo_usuario TO dgzsgodijyfsjh;




-- Drop table

-- DROP TABLE public.usuarios;



CREATE TABLE public.usuarios (
	nombre varchar(100) NOT NULL,
	apellido varchar(100) NOT NULL,
	email varchar(200) NOT NULL,
	contraseña varchar(32) NOT NULL,
	tipo_usuario_id int4 NOT NULL,
	CONSTRAINT usuarios_pkey PRIMARY KEY (email),
	CONSTRAINT fk_usuarios_tipo_usuario FOREIGN KEY (tipo_usuario_id) REFERENCES tipo_usuario(id)
);



-- Permissions



ALTER TABLE public.usuarios OWNER TO dgzsgodijyfsjh;
GRANT ALL ON TABLE public.usuarios TO dgzsgodijyfsjh;




---------------------FUNCIONES---------------------
CREATE OR REPLACE FUNCTION public.automatizar_id_fecha_reservas()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
declare x INTEGER;
declare z DATE;
declare y varchar;
	
	begin	
		select distinct(recursos.tipo) into y from reservas,recursos where reservas.id_recurso = recursos.id and reservas.id_recurso = new.id_recurso;						
		
		if (new.fecha_fin_reserva-new.fecha_inicio_reserva) > '2 hours' and y in ('Dispositivo multimedia','Sala de estudio') then
			raise 'Tiempo de reserva excedido';
		end if;
		select current_date into z;
		select max(id)+1 into x from reservas;
		if x is null then
			x:=1;
		end if;
		new.id:=x;
		new.fecha_solicitud:=z;
		return new;
		
	end;
$function$
;


----------
CREATE OR REPLACE FUNCTION public.bu_recursos_pk()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
declare x INTEGER;
begin
	select max(id)+1 into x from recursos;
	new.id:=x;
	new.estado:='Disponible';
	return new;
end;
$function$
;



-------------------
CREATE OR REPLACE FUNCTION public.capacidad_automatica_recurso()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
	begin			
		if new.tipo='Dispositivo multimedia' or new.tipo='Libro' then
			new.capacidad:=0;
			return new;
		end if;
	end;
$function$
;


---------------------------------------

CREATE OR REPLACE FUNCTION public.sumafechadia(fechainicio timestamp without time zone, fechafin timestamp without time zone)
 RETURNS timestamp without time zone
 LANGUAGE plpgsql
AS $function$   
BEGIN

   LOOP 
      EXIT WHEN fechaInicio > fechaFin ; 
      fechaInicio:=fechaInicio  + ( interval '1 day');
   END LOOP ; 
   RETURN fechaInicio ;
END ; 
$function$
;




------------------------------------
CREATE OR REPLACE FUNCTION public.sumafechadia(fechainicio timestamp without time zone, fechafin timestamp without time zone, id_rec integer)
 RETURNS boolean
 LANGUAGE plpgsql
AS $function$  
   declare 
   flag boolean;
  numeroColum int;
  
BEGIN

   LOOP 
      EXIT WHEN fechaInicio > fechaFin and not flag; 
      fechaInicio:=fechaInicio  + ( interval '1 day');
      select count(*)  into numeroColum from reservas where id_recurso=id_rec and fechaInicio between fecha_inicio_reserva and fecha_fin_reserva;
      select 0=numerocolum into flag;
   END LOOP ; 
   RETURN flag ;
END ; 
$function$
;




--------------------------------------
CREATE OR REPLACE FUNCTION public.sumafechames(fechainicio timestamp without time zone, fechafin timestamp without time zone, id_rec integer)
 RETURNS boolean
 LANGUAGE plpgsql
AS $function$   
   declare 
   flag boolean;
  numeroColum int;
BEGIN
	flag := true;
   LOOP 
      EXIT WHEN fechaInicio > fechaFin and not flag; 
      fechaInicio:=fechaInicio  + ( interval '1 month');
      select count(*)  into numeroColum from reservas where id_recurso=id_rec and fechaInicio between fecha_inicio_reserva and fecha_fin_reserva;
      select 0=numerocolum into flag;


   END LOOP ; 
   RETURN flag ;
END ; 
$function$
;




-------------------------------------

CREATE OR REPLACE FUNCTION public.sumafechasemana()
 RETURNS boolean
 LANGUAGE plpgsql
AS $function$   
   declare
   numeroColum int;
   flag boolean;
   fechaAux date;
begin
   flag:=true;
   if new.tipo='recurrente' then
	   fechaAux:=new.fecha_inicio_reserva;
	   LOOP 
	      EXIT WHEN fechaAux > new.fecha_fin_reserva or not flag; 
	      select count(*)  into numeroColum from reservas where id_recurso=new.id_recurso and fechaAux between fecha_inicio_reserva and fecha_fin_reserva;
	      select 0=numerocolum into flag;
	      fechaAux:=fechaAux  + ( interval '1 week');
	      
	   END LOOP ; 
   end if;
   RETURN flag ;  
END ; 
$function$
;









--------------------------------------

CREATE OR REPLACE FUNCTION public.sumafechasemana(fechainicio timestamp without time zone, fechafin timestamp without time zone)
 RETURNS timestamp without time zone
 LANGUAGE plpgsql
AS $function$   
BEGIN

   LOOP 
      EXIT WHEN fechaInicio >= fechaFin ; 
      fechaInicio:=fechaInicio  + ( interval '1 week');
   END LOOP ; 
   RETURN fechaInicio ;
END ; 
$function$
;




----------------------------------------------------
CREATE OR REPLACE FUNCTION public.sumafechasemana(fechainicio timestamp without time zone, fechafin timestamp without time zone, id_rec integer)
 RETURNS boolean
 LANGUAGE plpgsql
AS $function$   
   declare
   numeroColum int;
   flag boolean;
BEGIN
   flag:=true;
   LOOP 
      EXIT WHEN fechaInicio > fechaFin or not flag;       
      select count(*)  into numeroColum from reservas where id_recurso=id_rec and fechaInicio between fecha_inicio_reserva and fecha_fin_reserva;
      select 0=numerocolum into flag;
      fechaInicio:=fechaInicio  + ( interval '1 week');
   END LOOP ; 
   RETURN flag ;
END ; 
$function$
;



-----------------------------------------VISTAS-----------------------------------------------------------------


create or replace view recursos_mas_usados as
select id_recurso recurso,count(id_recurso) numero_usos
from reservas
group by id_recurso
order by numero_usos desc;


----------------------


create or replace view recursos_menos_usados as
select id_recurso recurso,count(id_recurso) numero_usos
from reservas
group by id_recurso
order by numero_usos asc;



----------------------------------

create or replace view reservas_recurrentes as
select *
from reservas
where tipo='Recurrente'
order by fecha_solicitud;


-----------------------------------

create or replace view reservas_canceladas as
select *
from reservas
where not activa
order by fecha_solicitud;

------------------------------------

create or replace view vista_horarios as
select reservas.id,reservas.id_recurso,reservas.id_usuario,tipo,activa,
	to_char(fecha_inicio_reserva,'YYYY-MM-DD hh:mi:ss')::time horaInicio,
	to_char(fecha_fin_reserva, 'YYYY-MM-DD hh:mi:ss')::time horaFin
from reservas 

--------------------------------------------

create or replace view vista_cantidad_ocupacion as

select '7:00-8:30' Franja,
SUM(case when horaInicio>=cast('7:00:00' as TIME) and horaFin < cast('8:30:00' as time) then 1 else 0 end) 
cantidad_reservas from vista_horarios

union all

select '8:30-10:00' Franja,
SUM(case when horaInicio>=cast('8:30:00' as TIME) and horaFin < cast('10:00:00' as time) then 1 else 0 end) cantidad_reservas 
from vista_horarios

union all

select '10:00-11:30' Franja,
SUM(case when horaInicio>=cast('10:00:00' as TIME) and horaFin < cast('11:30:00' as time) then 1 else 0 end) cantidad_reservas 
from vista_horarios

union all

select '11:30-13:00' Franja,
SUM(case when horaInicio>=cast('11:30:00' as TIME) and horaFin < cast('13:00:00' as time) then 1 else 0 end) cantidad_reservas 
from vista_horarios 

union all

select '13:00-14:30' Franja,
SUM(case when horaInicio>=cast('13:00:00' as TIME) and horaFin < cast('14:30:00' as time) then 1 else 0 end) cantidad_reservas 
from vista_horarios 

union all

select '14:30-16:00' Franja,
SUM(case when horaInicio>=cast('14:30:00' as TIME) and horaFin < cast('16:00:00' as time) then 1 else 0 end) cantidad_reservas
from vista_horarios

union all

select '16:00-17:30' Franja,
SUM(case when horaInicio>=cast('16:00:00' as TIME) and horaFin < cast('17:30:00' as time) then 1 else 0 end) cantidad_reservas 
from vista_horarios 

union all

select '17:30-19:00' Franja,
SUM(case when horaInicio>=cast('17:30:00' as TIME) and horaFin < cast('19:00:00' as time) then 1 else 0 end) cantidad_reservas 
from vista_horarios 

select * from vista_cantidad_ocupacion


































