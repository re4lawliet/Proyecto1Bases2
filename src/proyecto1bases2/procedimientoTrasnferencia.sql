--PROCEDIMIENTO PARA HACER TRANSFERENCIA
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





--PROCEDIMIENTO PARA HACER UN COBRO DE CHEQUE SI EL COBRADOR QUIERE EL DINERO EN EFECTIVO

CREATE OR REPLACE PROCEDURE pago_cheque_efectivo(noCuenta IN INTEGER, noCheque IN INTEGER, fechaCheque IN VARCHAR2, montoCheque IN NUMBER, dpiReceptor IN VARCHAR2, nombreReceptor IN VARCHAR2, fechaTransaccion IN VARCHAR2, agencia IN INTEGER, usuario IN INTEGER, mensaje OUT varchar2)
IS
    o_cuenta CUENTA%rowtype;
    o_cheque CHEQUE%rowtype;
BEGIN
    --CHECK POINT
    SAVEPOINT init;
    --GUARDAR TABLA EN CURSOR(objeto) o_datos
    SELECT * into o_cuenta 
    FROM CUENTA WHERE id_cuenta = noCuenta for update of SALDO; --for [READ ONLY | FETCH ONLY | UPDATE] [ OF Simple-column-Name [ , Simple-column-Name]* ]
    --GUARDAR TABLA EN CURSOR(objeto) o_cheque
    SELECT * into o_cheque
    FROM CHEQUE WHERE id_cuenta = noCuenta AND num_cheque = noCheque for update of fecha, dpi_receptor, nombre_receptor, monto, estado;
    
    --si la cuenta esta activa
    IF (o_cuenta.estado = 1) THEN
        --si la cuenta tiene saldo
        IF (o_cuenta.saldo >= montoCheque) THEN
            --si el cheque esta disponible
            IF (o_cheque.estado = 0) THEN
                --CREAR TRASACCION DE DESCUENTO EN LA CUENTA
                INSERT INTO TRANSACCION (FECHA, TIPO_TRANSACCION, TERMINAL, SALDO_INICIAL, VALOR, SALDO_FINAL, ID_AGENCIA, ID_USUARIO, ID_CUENTA)  VALUES(fechaTransaccion,'Transferencia',1,o_cuenta.saldo,montoCheque,o_cuenta.saldo-montoCheque, agencia,usuario,o_cuenta.id_cuenta);
                --ACTUALIZAR EL SALDO DE LA CUENTA
                UPDATE CUENTA SET SALDO = o_cuenta.saldo-montoCheque WHERE id_cuenta = noCuenta;
                --ACTUALIZAR EL CHEQUE QUE YA NO SIRVE                                                                     
                UPDATE CHEQUE SET fecha = fechaCheque, dpi_receptor=dpiReceptor, nombre_receptor = nombreReceptor, monto = montoCheque, estado = 1 WHERE id_cuenta = noCuenta AND num_cheque = noCheque;
                commit;
                mensaje := 'Ok';
            ELSE
                mensaje := 'Este cheque ya fue usado o esta reportado';
            END IF;
        ELSE
            mensaje := 'La cuenta no tiene saldo suficiente';
        END IF; 
    ELSE
        mensaje := 'La cuenta esta Bloqueada o Cancelada';
    END IF;
EXCEPTION
    WHEN OTHERS THEN  mensaje := 'Se produjo un error';
    ROLLBACK to init;
END; 











--PROCEDIMIENTO PARA HACER UN COBRO DE CHEQUE SI EL COBRADOR QUIERE EL DINERO DEPOSITADO EN SU CUENTA

CREATE OR REPLACE PROCEDURE pago_cheque_deposito(noCuenta IN INTEGER, noCheque IN INTEGER, fechaCheque IN VARCHAR2, montoCheque IN VARCHAR2, dpiReceptor IN VARCHAR2, nombreReceptor IN VARCHAR2, fechaTransaccion IN VARCHAR2, agencia IN INTEGER, usuario IN INTEGER, noCuentaReceptor IN INTEGER, mensaje OUT varchar2)
IS
    o_cuenta CUENTA%rowtype;
    o_cuentaR CUENTA%rowtype;
    o_cheque CHEQUE%rowtype;
BEGIN
    --CHECK POINT
    SAVEPOINT init;
    --GUARDAR TABLA EN CURSOR(objeto) o_cuenta
    SELECT * into o_cuenta 
    FROM CUENTA WHERE id_cuenta = noCuenta for update of SALDO; --for [READ ONLY | FETCH ONLY | UPDATE] [ OF Simple-column-Name [ , Simple-column-Name]* ]
    --GUARDAR TABLA EN CURSOR(objeto) o_cheque
    SELECT * into o_cuentaR 
    FROM CUENTA WHERE id_cuenta = noCuentaReceptor for update of SALDO;
    
    SELECT * into o_cheque
    FROM CHEQUE WHERE id_cuenta = noCuenta AND num_cheque = noCheque for update of fecha, dpi_receptor, nombre_receptor, monto, estado;
    --GUARDAR TABLA EN CURSOR(objeto) o_cuentaR
    --si la cuenta esta activa
    IF (o_cuenta.estado = 1 and o_cuentaR.estado = 1) THEN
        --si la cuenta tiene saldo
        IF (o_cuenta.saldo >= montoCheque) THEN
            --si el cheque esta disponible
            IF (o_cheque.estado = 0) THEN
                --CREAR TRASACCION DE DESCUENTO EN LA CUENTA
                INSERT INTO TRANSACCION (FECHA, TIPO_TRANSACCION, TERMINAL, SALDO_INICIAL, VALOR, SALDO_FINAL, ID_AGENCIA, ID_USUARIO, ID_CUENTA)  VALUES(fechaTransaccion,'Transferencia',1,o_cuenta.saldo,montoCheque,o_cuenta.saldo-montoCheque, agencia,usuario,o_cuenta.id_cuenta);
                --CREAR TRANSACCION DE ACREDITACION A LA CUENTA DESTINO
                INSERT INTO TRANSACCION (FECHA, TIPO_TRANSACCION, TERMINAL, SALDO_INICIAL, VALOR, SALDO_FINAL, ID_AGENCIA, ID_USUARIO, ID_CUENTA)  VALUES(fechaTransaccion,'Transferencia',1,o_cuentaR.saldo,montoCheque,o_cuentaR.saldo+montoCheque, agencia,usuario,o_cuentaR.id_cuenta);
                --ACTUALIZAR EL SALDO DE LA CUENTA ORIGEN
                UPDATE CUENTA SET SALDO = o_cuenta.saldo-montoCheque WHERE id_cuenta = noCuenta;
                --ACTUALIZAR EL SALDO DE LA CUENTA DESTINO
                UPDATE CUENTA SET SALDO = o_cuentaR.saldo+montoCheque WHERE id_cuenta = noCuentaReceptor;
                --ACTUALIZAR EL CHEQUE QUE YA NO SIRVE                                                                     
                UPDATE CHEQUE SET fecha = fechaCheque, dpi_receptor=dpiReceptor, nombre_receptor = nombreReceptor, monto = montoCheque, estado = 1 WHERE id_cuenta = noCuenta AND num_cheque = noCheque;
                commit;
                mensaje := 'Ok';
            ELSE
                mensaje := 'Este cheque ya fue usado o esta reportado';
            END IF;
        ELSE
            mensaje := 'La cuenta no tiene saldo suficiente';
        END IF; 
    ELSE
        mensaje := 'La cuenta esta Bloqueada o Cancelada';
    END IF;
EXCEPTION
    WHEN OTHERS THEN  mensaje := 'Se produjo un error';
    ROLLBACK to init;
END; 