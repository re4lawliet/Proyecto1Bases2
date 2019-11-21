/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1bases2;

/**
 *
 * @author carlosmonterroso
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.Cheques.*;

public class Proyecto1Bases2 {
	
	public static Inicio i;
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		//Test Conexion
 
            int banderaConexion=0;
            BaseDeDatos bd = new BaseDeDatos();



            if (bd.ProbarConexion()) {
                    System.out.println("Conectado a la Base de Datos :D");
                    banderaConexion=1;
            } else {
                    System.out.println("Fallo la Conexion :(");
            }


            if(banderaConexion==1){		
                    JOptionPane.showMessageDialog(null, "Bienvenido :D");
                    Inicio i = new Inicio();
		    i.setLocationRelativeTo(null);
                    i.setVisible(true);	
            }else{
                    JOptionPane.showMessageDialog(null, "Error en la Conexion a la Base de Datos");
            }
		
	}
	
}
