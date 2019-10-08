drop table cuenta cascade constraints;
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

ALTER TABLE usuario
    ADD CONSTRAINT usuario_agencia_fk FOREIGN KEY ( agencia_id_agencia )
        REFERENCES agencia ( id_agencia );


CREATE TABLE cuenta (
    id_cuenta           INTEGER NOT NULL,
    codigo              VARCHAR2(4000) NOT NULL,
    nombre              VARCHAR2(4000) NOT NULL,
    saldo               VARCHAR2(4000) NOT NULL,
    estado              VARCHAR2(4000) NOT NULL,
    tipo_cuenta         VARCHAR2(4000),
    id_agencia          INTEGER NOT NULL
    id_usuario          INTEGER NOT NULL
);

ALTER TABLE cuenta
    ADD CONSTRAINT cuenta_agencia_fk FOREIGN KEY ( id_agencia )
        REFERENCES agencia ( id_agencia );

ALTER TABLE cuenta
    ADD CONSTRAINT cuenta_usuario_fk FOREIGN KEY ( id_usuario )
        REFERENCES usuario ( id_usuario );