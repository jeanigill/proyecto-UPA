--Productos
insert into producto (codigo, nombre, precio_unitario, descripcion, favorito, oferta, cantidad_stock, id_categoria, id_1, id_2, url) values
('authogar00','COCINA DE JUGUETE - AUTHOGAR', 50000, 'Para niños de 8 a 12 años.', false, false, 10, 12, 1, 1, 'https://i.pinimg.com/originals/a4/ee/b1/a4eeb1af248f986d9face8e5007b661e.jpg'),
('bimboartesano00','PANIFICADO BIMBO - ARTESANO', 20000, 'Pan tipo Artesano - Panchas.', false, false, 15, 3, 3, 1, 'https://maxiconsumo.com/pub/media/catalog/product/cache/8721ae71a8b276de5ff5b8923d829701/3/4/34350.jpg'),
('repollo01','REPOLLO', 15000, 'Repollos frescos - De la granja a tu casa.', false, false, 8, 6, 2, 1, 'https://hydroenv.com.mx/catalogo/images/00/hortalizas/Hortalizas_hibridas/hortalizas_OP/col.jpg'),
('podiumperros02', 'PODIUM - ALIMENTO PARA PERROS', 30000, 'Alimento para perros - 1kg.', false, false, 5, 10, 4, 1, 'https://sofiaalpaso.com/site/wp-content/uploads/2018/12/Alimento-Canino-Adulto-Raza-Mediana-Grande-23.jpg');

--Empresa
insert into empresa (ruc, nombre, telefono, email, ciudad, pais ) values
('1234567-8', 'Das Kaufhaus', 0983123751, 'daskaufhaus@gmail.com', 'Asunción', 'Paraguay');
