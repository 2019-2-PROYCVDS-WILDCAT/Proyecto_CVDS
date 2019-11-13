---CHECKS---
ALTER TABLE public.recursos ADD CONSTRAINT ck_recursos_estado CHECK ((((estado)::text = 'Disponible'::text) OR ((estado)::text = 'Prestado'::text) OR ((estado)::text = 'Dañado'::text)));
ALTER TABLE public.recursos ADD CONSTRAINT ck_recursos_tipo CHECK ((((tipo)::text = 'Libro'::text) OR ((tipo)::text = 'Sala de estudio'::text) OR ((tipo)::text = 'Dispositivo multimedia'::text)));
alter table public.recursos add constraint ck_recursos_capacidad check(recursos.capacidad >=0);