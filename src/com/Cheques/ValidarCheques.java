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
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import proyecto1bases2.BaseDeDatos;

/**
 *
 * @author hp
 */
public class ValidarCheques {

    
    private ArrayList<BancosCheques> Bancos;
    private int IdBanco;
    private File archivo;
   public ValidarCheques(File Archivo)
   {
     this.archivo = Archivo;
   }
     
     
    public void leer() {
        
        try {
            FileWriter ArchivoE = null;
              PrintWriter escribir = null;
             ArchivoE = new FileWriter("GENERADOS/"+this.archivo.getName().replace("OUT", "IN"));
            escribir = new PrintWriter(ArchivoE);
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

                    Boolean isOk = CambiarEstado(arr[2],arr[3],arr[4]);
                    if(isOk)
                    {
                        escribir.println(linea+"|OK");
                    }
                    else
                    {
                         escribir.println(linea+"|01");
                    }
                 }
             }

             fr.close();
             ArchivoE.close();
           }
           catch(Exception e) {
             System.out.println("Excepcion leyendo fichero  " + e);
           }
    }

   
    private Boolean CambiarEstado(String cuenta,String cheque,String cantidad) throws SQLException {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YY");
         try{
        BaseDeDatos db = new BaseDeDatos();
        Connection con = db.conexion();
        if (con != null) {
                String fecha = "21/11/19";
                String dpiR = "0000";
                String nombreR = "Banco Chilero";
                String idAgencia = "23"  ;
                String idUsuario = "1";
               

                    
                    if (con != null) {
                        //preparando llamada
                        CallableStatement cst = con.prepareCall("{call  pago_cheque_validar(?,?,?,?,?,?,?,?,?,?)}");
                        //agregando parametros(indice_parametro,valor)
                        cst.setInt(1,Integer.valueOf(cuenta));
                        cst.setInt(2,Integer.valueOf(cheque));
                        cst.setString(3,String.valueOf(fecha));
                        cst.setDouble(4, Double.valueOf(cantidad));
                        cst.setString(5,String.valueOf(dpiR));
                        cst.setString(6,String.valueOf(nombreR));
                        cst.setString(7,String.valueOf(fecha));
                        cst.setString(8,String.valueOf(idAgencia));
                        cst.setString(9,String.valueOf(idUsuario));
                        cst.registerOutParameter(10, java.sql.Types.VARCHAR);
                        cst.execute();
                        String mensaje = cst.getString(10);
                         
                        System.out.println(mensaje);
                        con.close();
                        if(mensaje != null)
                             return mensaje.equals("OK") ; 
                       
                    }else{
                            System.out.println("NO HAY CONEXION");
                    }
                 }

                }catch(SQLException e) {
                    System.err.format("SQL Error : %s\n%s", e.getSQLState(), e.getMessage());
                }    
        
        return false;
    }



}