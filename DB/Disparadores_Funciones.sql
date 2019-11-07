create  trigger BU_Recursos_pk  
before insert on recursos
for each row
execute procedure BU_Recursos_pk();

create function public.BU_Recursos_pk()
	returns trigger
	language 'plpgsql'
as $BODY$
declare x INTEGER;
begin
	select max(id)+1 into x from recursos;
	new.id:=x;
	new.estado:='Disponible';
	return new;
end;
$BODY$