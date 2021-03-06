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
    foto                 VARCHAR2(8000),
    firma                VARCHAR2(8000),
    rol                  VARCHAR2(4000) NOT NULL,
    agencia_id_agencia   INTEGER
);

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( id_usuario );

ALTER TABLE usuario
    ADD CONSTRAINT usuario_agencia_fk FOREIGN KEY ( agencia_id_agencia )
        REFERENCES agencia ( id_agencia );


CREATE TABLE cuenta (
    id_cuenta           INTEGER NOT NULL,
    codigo              VARCHAR2(4000) NOT NULL,
    nombre              VARCHAR2(4000) NOT NULL,
    saldo               VARCHAR2(4000) NOT NULL,
    estado              VARCHAR2(4000) NOT NULL, --Estado 0=cancelada, 1=activa, 2=bloqueada
    tipo_cuenta         VARCHAR2(4000),
    id_agencia          INTEGER NOT NULL,
    id_usuario          INTEGER NOT NULL
);

ALTER TABLE cuenta ADD CONSTRAINT cuenta_pk PRIMARY KEY ( id_cuenta );

ALTER TABLE cuenta
    ADD CONSTRAINT cuenta_agencia_fk FOREIGN KEY ( id_agencia )
        REFERENCES agencia ( id_agencia );

ALTER TABLE cuenta
    ADD CONSTRAINT cuenta_usuario_fk FOREIGN KEY ( id_usuario )
        REFERENCES usuario ( id_usuario );


-- CREATE TABLE chequera (
--     id_chequera         INTEGER NOT NULL,
--     id_cuenta           INTEGER NOT NULL,
--     inicia              INTEGER NOT NULL,
--     termina             INTEGER NOT NULL,
--     tamanio             INTEGER NOT NULL
-- );
-- 
-- ALTER TABLE chequera ADD CONSTRAINT chequera_pk PRIMARY KEY ( id_chequera );
-- 
-- ALTER TABLE chequera
--     ADD CONSTRAINT chequera_cuenta_fk FOREIGN KEY ( id_cuenta )
--         REFERENCES cuenta ( id_cuenta );


CREATE TABLE cheque (
    id_cuenta           INTEGER NOT NULL,
    num_cheque          VARCHAR2(4000) NOT NULL,
    fecha               VARCHAR2(4000) NOT NULL,
    dpi_receptor        VARCHAR2(4000) NOT NULL, 
    nombre_receptor     VARCHAR2(4000) NOT NULL, 
    monto               VARCHAR2(4000),
    estado              INTEGER NOT NULL    --Estado 0=sin usar, 1=usado, 2=robado, 3=extraviado
);

ALTER TABLE cheque
    ADD CONSTRAINT cheque_cuenta_fk FOREIGN KEY ( id_cuenta )
        REFERENCES cuenta ( id_cuenta );

-- ALTER TABLE cheque
--     ADD CONSTRAINT cheque_chequera_fk FOREIGN KEY ( id_chequera )
--         REFERENCES chequera ( id_chequera );


CREATE TABLE transaccion (
    id_transaccion           INTEGER NOT NULL,
    fecha		     VARCHAR2(4000) NOT NULL,
    tipo_transaccion         VARCHAR2(4000) NOT NULL, --transferencia=1 , deposito=2
    terminal                 VARCHAR2(4000) NOT NULL,

    saldo_inicial            VARCHAR2(4000) NOT NULL,
    valor                    VARCHAR2(4000) NOT NULL,
    saldo_final              VARCHAR2(4000),

    id_agencia              INTEGER NOT NULL,
    id_usuario              INTEGER NOT NULL,
    id_cuenta               INTEGER NOT NULL
);

ALTER TABLE transaccion ADD CONSTRAINT transaccion_pk PRIMARY KEY ( id_transaccion );

ALTER TABLE transaccion
    ADD CONSTRAINT transaccion_agencia_fk FOREIGN KEY ( id_agencia )
        REFERENCES agencia ( id_agencia );

ALTER TABLE transaccion
    ADD CONSTRAINT transaccion_usuario_fk FOREIGN KEY ( id_usuario )
        REFERENCES usuario ( id_usuario );

ALTER TABLE transaccion
    ADD CONSTRAINT transaccion_cuenta_fk FOREIGN KEY ( id_cuenta )
        REFERENCES cuenta ( id_cuenta );


expdp system/oracle schemas=SYSTEM dumpfile=test.dmp
cd /u01/app/oracle/admin/XE/dpdump

sqlplus sys as sysdba


CREATE USER CARLOS2 IDENTIFIED BY 123456 DEFAULT TABLESPACE USERS TEMPORARY TABLESPACE TEMP;
GRANT SYSDBA TO CARLOS2;
GRANT CONNECT, RESOURCE TO CARLOS2;
DISCONN
CONN CARLOS2 as sysdba
CREATE OR REPLACE DIRECTORY MY_BACKUP AS '/home';
SELECT DIRECTORY_NAME FROM DBA_DIRECTORIES;





EXPDP CARLOS2/123456 DUMPFILE=MY_BACKUP1.DMP LOGFILE=MY_BACKUP1.LOG DIRECTORY=MY_BACKUP FULL=Y
expdp CARLOS2/123456 schemas=SYSTEM dumpfile=test.dmp