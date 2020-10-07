
CREATE SEQUENCE public.empresa_id_seq;

CREATE TABLE public.empresa (
                id INTEGER NOT NULL DEFAULT nextval('public.empresa_id_seq'),
                RUC VARCHAR NOT NULL,
                nombre VARCHAR NOT NULL,
                CONSTRAINT empresa_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.empresa_id_seq OWNED BY public.empresa.id;

CREATE SEQUENCE public.categoria_id_seq;

CREATE TABLE public.categoria (
                id INTEGER NOT NULL DEFAULT nextval('public.categoria_id_seq'),
                nombre VARCHAR NOT NULL,
                CONSTRAINT categoria_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.categoria_id_seq OWNED BY public.categoria.id;

CREATE SEQUENCE public.proveedor_id_seq;

CREATE TABLE public.proveedor (
                id INTEGER NOT NULL DEFAULT nextval('public.proveedor_id_seq'),
                CI VARCHAR NOT NULL,
                nombre VARCHAR NOT NULL,
                direccion VARCHAR NOT NULL,
                representante VARCHAR NOT NULL,
                email VARCHAR NOT NULL,
                contratado BOOLEAN NOT NULL,
                CONSTRAINT proveedor_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.proveedor_id_seq OWNED BY public.proveedor.id;

CREATE SEQUENCE public.producto_id_seq;

CREATE TABLE public.producto (
                id INTEGER NOT NULL DEFAULT nextval('public.producto_id_seq'),
                codigo VARCHAR NOT NULL,
                nombre VARCHAR NOT NULL,
                precio_unitario NUMERIC NOT NULL,
                descripcion VARCHAR NOT NULL,
                favorito BOOLEAN NOT NULL,
                oferta BOOLEAN NOT NULL,
                cantidad_stock INTEGER NOT NULL,
                id_categoria INTEGER NOT NULL,
                id_1 INTEGER NOT NULL,
                id_2 INTEGER NOT NULL,
                CONSTRAINT producto_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.producto_id_seq OWNED BY public.producto.id;

ALTER TABLE public.producto ADD CONSTRAINT empresa_producto_fk
FOREIGN KEY (id_2)
REFERENCES public.empresa (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.producto ADD CONSTRAINT categoria_producto_fk
FOREIGN KEY (id_categoria)
REFERENCES public.categoria (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.producto ADD CONSTRAINT proveedor_producto_fk
FOREIGN KEY (id_1)
REFERENCES public.proveedor (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;