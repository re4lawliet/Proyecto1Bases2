/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Cheques;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import proyecto1bases2.BaseDeDatos;

/**
 *
 * @author hp
 */
public class Compensacion implements Runnable {
    
    private ArrayList<BancosCheques> Bancos;
    private int IdBanco;
    private int lote;
   public Compensacion(int IdBanco)
   {
       this.IdBanco = IdBanco;
       this.lote = 0;
   }
     
     @Override
    public void run() {
    try{
        FileWriter Archivo = null;
        PrintWriter escribir = null;
        Archivo = new FileWriter("GENERADOS/OUT_"+String.valueOf(this.IdBanco)+"_"+String.valueOf(lote)+".txt");
        escribir = new PrintWriter(Archivo);
        String sql = "SELECT * FROM CHEQUEC WHERE ESTADO = 0 AND BANCO ="+this.IdBanco;
                BaseDeDatos db = new BaseDeDatos();
                Connection con = db.conexion();
            if (con != null) {
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                    
                    CrearCompensaBanco(rs, escribir);
                    con.close();
            } else {
                    System.out.println("NO HAY CONEXION");
            }
             Archivo.close();
             System.out.println("Termino sin errores");
        }catch(IOException | SQLException e){  
            System.out.println("SQL ERROR " + e.getMessage());
        } 
    
    }
   /**
    * Metodo que escribe la compensacion de cada banco
    * @param i Id del banco en el que vamos a trabajar
    * @param rs  Cursor ocn los resultados 
    */
   private void CrearCompensaBanco(ResultSet rs , PrintWriter escribir)
   {
    try
    {  
        escribir.println("BANCO|REFERENCIA|CUENTA|NO_CHEQUE|MONTO");
        while(rs.next()){
         try{   
            Object[] datarow = {
            rs.getString("REFERENCIA"),
            rs.getString("BANCO"),
            rs.getString("CUENTA"),
            rs.getString("NOCHEQUE"),
            rs.getString("MONTO")
            };
            if ( CambiarEstado(Integer.valueOf(datarow[0].toString())) )
            {
                String cadenaEscribir  = "";
                cadenaEscribir += datarow[1].toString() +"|";
                cadenaEscribir += datarow[0].toString() +"|";
                cadenaEscribir += datarow[2].toString() +"|";
                cadenaEscribir += datarow[3].toString() +"|";
                cadenaEscribir += datarow[4].toString() ;
                escribir.println(cadenaEscribir);
            }
           }catch(SQLException e)
           {
               System.err.println("Error en compensa" + e.getMessage());
           }
        }
       
    }catch(SQLException e)
    {
        System.err.println("Error en compensa" + e.getMessage());
    }
    
   }
   
    private Boolean CambiarEstado(int referencia) throws SQLException {
        BaseDeDatos db = new BaseDeDatos();
        Connection con = db.conexion();
        if (con != null) {
            //preparando llamada
            CallableStatement cst = con.prepareCall("{call  pago_cheque_CambioProcesando(?,?)}");
            //agregando parametros(indice_parametro,valor)
            cst.setInt(1,referencia);
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            cst.execute();
            String mensaje = cst.getString(2);
            con.close();
            if(mensaje != null)
                return mensaje.equals("OK") ;      
        }
        return false;
    }


}

/*
        BaseDeDatos db = new BaseDeDatos();
        String[] columnNames = {"ID","NOMBRE","DIRECCION","BANCO"};
        Object[][] dataVacia = {};
        DefaultTableModel modelo = new DefaultTableModel(dataVacia, columnNames);
        String consulta = "SELECT * FROM AGENCIA,BANCO WHERE BANCO.ID_BANCO = AGENCIA.ID_BANCO";
        try{
            Connection conn = db.conexion();
            if (conn != null) {
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(consulta);
                    while(rs.next()){
                        Object[] newRowData = {rs.getString("ID_AGENCIA"),rs.getString("NOMBRE_AGENCIA"),rs.getString("DIRECCION_AGENCIA"),rs.getString("NOMBRE_BANCO")};
                        modelo.addRow(newRowData);
                    }
            } else {
                    System.out.println("NO HAY CONEXION");
            }
        }catch(Exception e){  
            JOptionPane.showMessageDialog(null,"Error al llenar tabla de Agencia\nClase: Principal -> 2721\nExcepcion: "+e,"ERROR", JOptionPane.ERROR_MESSAGE);
        } 
*/
