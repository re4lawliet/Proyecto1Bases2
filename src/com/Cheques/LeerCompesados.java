/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Cheques;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import proyecto1bases2.BaseDeDatos;

/**
 *
 * @author hp
 */
public class LeerCompesados {

    
    private ArrayList<BancosCheques> Bancos;
    private int IdBanco;
    private File archivo;
   public LeerCompesados(File Archivo)
   {
     this.archivo = Archivo;
   }
     
     
    public void leer() {
        try {
             FileReader fr = new FileReader(this.archivo);
             BufferedReader br = new BufferedReader(fr);
             br.readLine();
             String linea = "";
             while((linea = br.readLine()) != null)
             {                 
                 String[] arr = linea.replace('|',',').split(",");
   
                 if(arr != null)
                 { 
                    int referencia = Integer.valueOf(arr[1]);
                    String valor = arr[5];
                     System.out.print(valor);
                    if(valor.equals("OK"))
                    {
                       CambiarEstado(referencia);
                    }else
                    {
                        CambiarEstadoMalo(referencia);
                    }
                 }
             }

             fr.close();
           }
           catch(Exception e) {
             System.out.println("Excepcion leyendo fichero  " + e);
           }
    }

   
    private Boolean CambiarEstado(int referencia) throws SQLException {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        BaseDeDatos db = new BaseDeDatos();
        Connection con = db.conexion();
        if (con != null) {
            //preparando llamada
            CallableStatement cst = con.prepareCall("{call  pago_cheque_Aceptado(?,?)}");
            //agregando parametros(indice_parametro,valor)
            cst.setInt(1,referencia);
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            cst.execute();
            String mensaje = cst.getString(2);
            System.out.print(mensaje);
            con.close();
            
            if(mensaje != null)
                return mensaje.equals("OK") ;      
        }
        return false;
    }
       private Boolean CambiarEstadoMalo(int referencia) throws SQLException {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        BaseDeDatos db = new BaseDeDatos();
        Connection con = db.conexion();
        if (con != null) {
            //preparando llamada
            CallableStatement cst = con.prepareCall("{call  pago_cheque_NoAceptado(?,?)}");
            //agregando parametros(indice_parametro,valor)
            cst.setInt(1,referencia);
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            cst.execute();
            String mensaje = cst.getString(2);
            System.out.print(mensaje);
            con.close();
            
            if(mensaje != null)
                return mensaje.equals("OK") ;      
        }
        return false;
    }


}