ALTER TABLE recursos
ADD CONSTRAINT  CK_recursos_tipo
CHECK(tipo ='Libro' or tipo='Sala de estudio' or tipo='Dispositivo multimedia' );

ALTER TABLE recursos
ADD CONSTRAINT  CK_recursos_estado
CHECK(estado='Disponible' or estado='Prestado' or estado='Dañado' );