drop table dian_subir;

CREATE TABLE dian_subir (
    tipo_doc          VARCHAR(60)  DEFAULT '',
    fch_emision       TIMESTAMP ,
    nit_emisor        VARCHAR(20)  DEFAULT '',
    nomb_emisor       VARCHAR(130) DEFAULT '',
    nit_recep         VARCHAR(20)  DEFAULT '',
    nomb_recep        VARCHAR(130) DEFAULT '',
	iva numeric(18, 2) default 0,
	total numeric(18, 2) default 0,
    empresa           VARCHAR(20)  DEFAULT '',
    id                BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY
);