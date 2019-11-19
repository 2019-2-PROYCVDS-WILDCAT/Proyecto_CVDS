
CREATE OR REPLACE FUNCTION SumaFechaDia (fechaInicio timestamp, fechaFin timestamp,id_rec int) 
   RETURNS boolean AS $$  
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
$$ LANGUAGE plpgsql;
   
select SumaFechaDia ('2018-11-19 01:05:00','2018-11-24 01:05:00',1);

CREATE OR REPLACE FUNCTION SumaFechaSemana(fechaInicio timestamp, fechaFin timestamp,id_rec int) 
   RETURNS boolean AS $$   
   declare
   numeroColum int;
   flag boolean;
BEGIN

   LOOP 
      EXIT WHEN fechaInicio > fechaFin and not flag; 
      fechaInicio:=fechaInicio  + ( interval '1 week');
      select count(*)  into numeroColum from reservas where id_recurso=id_rec and fechaInicio between fecha_inicio_reserva and fecha_fin_reserva;
      select 0=numerocolum into flag;
   END LOOP ; 
   RETURN flag ;
END ; 
$$ LANGUAGE plpgsql;

select SumaFechaSemana ('2018-11-19 04:05:00','2018-11-26 04:05:00',1);

CREATE OR REPLACE FUNCTION SumaFechaMes(fechaInicio timestamp, fechaFin timestamp,id_rec int ) 
   RETURNS boolean AS $$   
   declare 
   flag boolean;
  numeroColum int;
 fechaAux timestamp;
BEGIN
	flag := true;
	fechaAux:=fechaInicio;
   LOOP 
      EXIT WHEN fechaInicio > fechaFin and not flag; 
      fechaInicio:=fechaInicio  + ( interval '1 month');
      select count(*)  into numeroColum from reservas where id_recurso=id_rec and fechaInicio between fecha_inicio_reserva and fecha_fin_reserva;
      select 0=numerocolum into flag;
   END LOOP ; 
  if flag then
  	loop 
  		fechaAux
  	end loop;
  
  end if;
   RETURN flag ;
END ; 
$$ LANGUAGE plpgsql;

select SumaFechaMes ('2018-11-19 00:05:00','2019-11-19 04:05:00',1);

select (select count(*) from reservas where id_recurso=1 and '2019-08-08 20:01:10' between fecha_inicio_reserva and fecha_fin_reserva)=0;
drop function SumaFechaMes;

