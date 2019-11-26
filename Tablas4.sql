CREATE TABLE public.disponibilidad (
	id int4 NOT NULL,
	idrecurso int4 NOT NULL,
	fechainicio time NOT NULL,
	fechafin time NOT NULL,
	CONSTRAINT ck_disponibilidad_fechaini_fechafin CHECK ((fechainicio <= fechafin)),
	CONSTRAINT disponibilidad_pkey PRIMARY KEY (id),
	CONSTRAINT fk_disponibilidad_recursos FOREIGN KEY (idrecurso) REFERENCES recursos(id)
);

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

   CREATE TABLE public.reservas (
	id int4 NOT NULL,
	id_usuario varchar(200) NULL,
	id_recurso int4 NULL,
	fecha_inicio_reserva timestamp NULL,
	fecha_fin_reserva timestamp NULL,
	fecha_solicitud date NULL,
	tipo varchar NULL,
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

CREATE TABLE public.tipo_usuario (
	id int4 NOT NULL,
	tipo varchar(32) NULL,
	CONSTRAINT tipo_usuario_pkey PRIMARY KEY (id)
);


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
