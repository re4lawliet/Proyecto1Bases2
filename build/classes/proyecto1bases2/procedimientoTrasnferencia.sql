create or replace PROCEDURE  p_transferencia_fondos(cantidad number, id_origen number,id_destino number, mensaje OUT varchar2)
IS
  --cursor o_datos (id_origen number) is select ID_CUENTA,SALDO FROM CUENTA WHERE id_cuenta = id_origen for update of SALDO;
   --cursor d_datos(id_destino number) is Select ID_CUENTA,SALDO FROM CUENTA WHERE id_cuenta = id_destino for update of SALDO;
   o_datos CUENTA%rowtype;
   d_datos CUENTA%rowtype;
begin
   SAVEPOINT init;
    SELECT * into o_datos 
        FROM CUENTA WHERE id_cuenta = id_origen for update of SALDO;
      SELECT * into d_datos  
         FROM CUENTA WHERE id_cuenta = id_destino for update of SALDO;
     mensaje := '';
      
        IF id_origen != id_destino THEN
            IF o_datos.saldo >= cantidad THEN
                --CREAR TRANSACCION ORIGEN
                INSERT INTO TRANSACCION (FECHA, TIPO_TRANSACCION, TERMINAL, SALDO_INICIAL, VALOR, SALDO_FINAL, ID_AGENCIA, ID_USUARIO, ID_CUENTA)  VALUES('1-5-2019','Transferencia',1,o_datos.saldo,cantidad,o_datos.saldo-cantidad, 23,1,o_datos.id_cuenta);
                --CREAR TRANSACCION DESTINO
               INSERT INTO TRANSACCION (FECHA, TIPO_TRANSACCION, TERMINAL, SALDO_INICIAL, VALOR, SALDO_FINAL, ID_AGENCIA, ID_USUARIO, ID_CUENTA)  VALUES('1-5-2019','Transferencia',1,d_datos.saldo,cantidad,d_datos.saldo+cantidad, 23,1,d_datos.id_cuenta);
                --UPDATE SALDO CUENTA ORIGEN
                UPDATE CUENTA SET SALDO = o_datos.saldo-cantidad WHERE id_cuenta = id_origen;
                --UPDATE SALDO CUENTA DESTINO
                UPDATE CUENTA SET SALDO = d_datos.saldo-cantidad WHERE id_cuenta = id_destino;
                  commit;
                mensaje := 'Ok';
            ELSE 
                mensaje := 'Saldo Insuficiente';
            END IF;    
        ELSE 
            mensaje := 'Error las cuentas tienen que ser distintas';
        END IF;    
      
EXCEPTION
    WHEN OTHERS THEN  mensaje := 'Se produjo un error';
    ROLLBACK to init;
END;


create or replace PROCEDURE  p_pago_cheque_mismo_banco()
IS
  --cursor o_datos (id_origen number) is select ID_CUENTA,SALDO FROM CUENTA WHERE id_cuenta = id_origen for update of SALDO;
   --cursor d_datos(id_destino number) is Select ID_CUENTA,SALDO FROM CUENTA WHERE id_cuenta = id_destino for update of SALDO;
   o_datos CUENTA%rowtype;
   d_datos CUENTA%rowtype;
begin
   SAVEPOINT init;
    SELECT * into o_datos 
        FROM CUENTA WHERE id_cuenta = id_origen for update of SALDO;
      SELECT * into d_datos  
         FROM CUENTA WHERE id_cuenta = id_destino for update of SALDO;
     mensaje := '';
      
        IF id_origen != id_destino THEN
            IF o_datos.saldo >= cantidad THEN
                --CREAR TRANSACCION ORIGEN
                INSERT INTO TRANSACCION (FECHA, TIPO_TRANSACCION, TERMINAL, SALDO_INICIAL, VALOR, SALDO_FINAL, ID_AGENCIA, ID_USUARIO, ID_CUENTA)  VALUES('1-5-2019','Transferencia',1,o_datos.saldo,cantidad,o_datos.saldo-cantidad, 23,1,o_datos.id_cuenta);
                --CREAR TRANSACCION DESTINO
               INSERT INTO TRANSACCION (FECHA, TIPO_TRANSACCION, TERMINAL, SALDO_INICIAL, VALOR, SALDO_FINAL, ID_AGENCIA, ID_USUARIO, ID_CUENTA)  VALUES('1-5-2019','Transferencia',1,d_datos.saldo,cantidad,d_datos.saldo+cantidad, 23,1,d_datos.id_cuenta);
                --UPDATE SALDO CUENTA ORIGEN
                UPDATE CUENTA SET SALDO = o_datos.saldo-cantidad WHERE id_cuenta = id_origen;
                --UPDATE SALDO CUENTA DESTINO
                UPDATE CUENTA SET SALDO = d_datos.saldo-cantidad WHERE id_cuenta = id_destino;
                  commit;
                mensaje := 'Ok';
            ELSE 
                mensaje := 'Saldo Insuficiente';
            END IF;    
        ELSE 
            mensaje := 'Error las cuentas tienen que ser distintas';
        END IF;    
      
EXCEPTION
    WHEN OTHERS THEN  mensaje := 'Se produjo un error';
    ROLLBACK to init;
END;