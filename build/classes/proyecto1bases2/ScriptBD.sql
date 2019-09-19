drop table agencia cascade constraints;
drop table banco cascade constraints;
drop table usuario cascade constraints;


CREATE TABLE agencia (
    id_agencia          INTEGER NOT NULL,
    nombre_agencia      VARCHAR2(4000) NOT NULL,
    direccion_agencia   VARCHAR2(4000) NOT NULL
);

ALTER TABLE agencia ADD CONSTRAINT agencia_pk PRIMARY KEY ( id_agencia );

CREATE TABLE banco (
    id_banco       INTEGER NOT NULL,
    nombre_banco   VARCHAR2(4000) NOT NULL
);

ALTER TABLE banco ADD CONSTRAINT banco_pk PRIMARY KEY ( id_banco );

CREATE TABLE usuario (
    id_usuario           INTEGER NOT NULL,
    nombre_usuario       VARCHAR2(4000) NOT NULL,
    contrasenia          VARCHAR2(4000) NOT NULL,
    nombre_completo      VARCHAR2(4000) NOT NULL,
    dpi                  VARCHAR2(4000) NOT NULL,
    correo               VARCHAR2(4000),
    foto                 VARCHAR2(4000),
    rol                  VARCHAR2(4000) NOT NULL,
    agencia_id_agencia   INTEGER
);