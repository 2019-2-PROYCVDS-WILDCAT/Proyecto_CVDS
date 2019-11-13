/*select * from recursos;
create or replace function public.capacidad_automatica_recurso() returns trigger as $capacidad_automatica$
	begin			
		if new.tipo='Dispositivo multimedia' or new.tipo='Libro' then
			new.capacidad:=null;
		end if;
	end;
$capacidad_automatica$ language plpgsql;


create trigger automatizar_capacidad_recurso before insert on recursos
	for each row execute procedure capacidad_automatica_recurso();

drop trigger automatizar_capacidad_recurso on recursos;
insert into recursos values */



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


-- DROP TRIGGER bu_recursos_pk ON recursos;

create
    trigger bu_recursos_pk before insert
        on
        public.recursos for each row execute procedure bu_recursos_pk();