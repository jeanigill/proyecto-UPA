--- CARGA DE PROVEEDOR --- 

select * from proveedor;

insert into proveedor (ci, nombre, direccion, representante, email, contratado ) values
(0128389,'Frutika', 'Avda. Aviadores del Chaco 3230 casi Chacoré – Barrio San Jorge – Asunción.', 'Frutika S.A', 'frutika@frutika.com.py', true),
(0128388,'Yerba Mate Kurupi','Tte. Victor Valdez esq Salvador Bogado', 'Santa margarita', 'yerbamate@snagem.com', true),
(0128382,'Ochi', 'Avda. Aviadores del Chaco 3230 ', 'S.A', 'ochi@embu.com.py', true),
(0128382,'Nutri Huevos', 'Barrio San Jorge – Asunción.', 'Nutri huevo S.A', 'Nutri@huevos.com.py', true);

ALTER TABLE proveedor ADD COLUMN url varchar;

select * from proveedor;

update proveedor set url='http://www.nutrihuevos.com.py/application/files/4115/4944/8208/nutriHuevos-full.png'
  where id=4;

update proveedor url values 
('http://frutikaonline.com/wp-content/uploads/2016/02/logo.png'),
('http://www.santamargarita.com.py/0/images/logo-kurupi.png'),
('https://www.ochsi.com.py/images/logo-footer.png'),
('http://www.nutrihuevos.com.py/application/files/4115/4944/8208/nutriHuevos-full.png');

ALTER TABLE producto ADD COLUMN url varchar;

ALTER TABLE categoria ADD COLUMN url varchar;

ALTER TABLE empresa ADD COLUMN telefono integer;
ALTER TABLE empresa ADD COLUMN email varchar;
ALTER TABLE empresa ADD COLUMN ciudad varchar;
ALTER TABLE empresa ADD COLUMN pais varchar;