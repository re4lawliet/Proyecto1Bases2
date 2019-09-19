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

CREATE TABLE usuario (
    id_usuario           INTEGER NOT NULL,
    nombre_usuario       VARCHAR2(4000) NOT NULL,
    contraseña           VARCHAR2(4000) NOT NULL,
    nombre_completo      VARCHAR2(4000) NOT NULL,
    dpi                  VARCHAR2(4000) NOT NULL,
    correo               VARCHAR2(4000),
    foto                 VARCHAR2(4000),
    rol                  VARCHAR2(4000) NOT NULL,
    agencia_id_agencia   INTEGER
);

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( id_usuario );

ALTER TABLE usuario
    ADD CONSTRAINT usuario_agencia_fk FOREIGN KEY ( agencia_id_agencia )
        REFERENCES agencia ( id_agencia );