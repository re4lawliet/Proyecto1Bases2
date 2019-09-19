
-- *****************************************************************************************
-- ************************        Banco             *************************************
-- *****************************************************************************************
DROP SEQUENCE seq_banco_idbanco;
CREATE SEQUENCE seq_banco_idbanco --nombre de la secuencia
START WITH 1 --la secuencia empieza por 1
INCREMENT BY 1 --se incrementa de uno en uno
NOMAXVALUE; --no tiene valor maximo

--CREATE OR REPLACE TRIGGER trig_banco_seq
--BEFORE INSERT ON banco FOR EACH ROW
--BEGIN
--	SELECT seq_banco_idbanco.nextval 
--	INTO :new.id_banco FROM dual;
--END;

DELIMITER @@
CREATE OR REPLACE TRIGGER SYSTEM.trig_banco_seq
BEFORE INSERT ON banco FOR EACH ROW
BEGIN
	SELECT seq_banco_idbanco.nextval 
	INTO :new.id_banco 
	FROM dual;
END; @@
DELIMITER;

-- *****************************************************************************************
-- ************************        Agencia             *************************************
-- *****************************************************************************************
DROP SEQUENCE seq_agencia_idagencia;
CREATE SEQUENCE seq_agencia_idagencia --nombre de la secuencia
START WITH 1 --la secuencia empieza por 1
INCREMENT BY 1 --se incrementa de uno en uno
NOMAXVALUE; --no tiene valor maximo

--CREATE OR REPLACE TRIGGER trig_agencia_seq
--BEFORE INSERT ON agencia FOR EACH ROW
--BEGIN
--	SELECT seq_agencia_idagencia.nextval 
--	INTO :new.id_agencia FROM dual;
--END;

DELIMITER @@
CREATE OR REPLACE TRIGGER SYSTEM.trig_agencia_seq
BEFORE INSERT ON agencia FOR EACH ROW
BEGIN
	SELECT seq_agencia_idagencia.nextval 
	INTO :new.id_agencia 
	FROM dual;
END; @@
DELIMITER; 


-- *****************************************************************************************
-- ************************        Usuario             *************************************
-- *****************************************************************************************
DROP SEQUENCE seq_usuario_idusuario;
CREATE SEQUENCE seq_usuario_idusuario --nombre de la secuencia
START WITH 1 --la secuencia empieza por 1
INCREMENT BY 1 --se incrementa de uno en uno
NOMAXVALUE; --no tiene valor maximo


DELIMITER @@
CREATE OR REPLACE TRIGGER SYSTEM.trig_usuario_seq
BEFORE INSERT ON usuario FOR EACH ROW
BEGIN
	SELECT seq_usuario_idusuario.nextval 
	INTO :new.id_usuario
	FROM dual;
END; @@
DELIMITER; 

