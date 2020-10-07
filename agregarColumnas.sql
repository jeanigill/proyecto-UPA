ALTER TABLE producto ADD COLUMN url varchar;

ALTER TABLE categoria ADD COLUMN url varchar;

ALTER TABLE empresa ADD COLUMN telefono integer;
ALTER TABLE empresa ADD COLUMN email varchar;
ALTER TABLE empresa ADD COLUMN ciudad varchar;
ALTER TABLE empresa ADD COLUMN pais varchar;

ALTER TABLE producto ALTER COLUMN id_2  DROP  NOT null;

select * from producto p ;
select * from proveedor p ;
select * from categoria c ;
select * from empresa e ;