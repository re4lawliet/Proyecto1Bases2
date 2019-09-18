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


public class Proyecto1Bases2 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		//Test Conexion
		
		JOptionPane.showMessageDialog(null, "Bienvenido :D");
		Inicio i = new Inicio();
		i.setVisible(true);
			
			
		int banderaConexion=0;
		/*
		try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@192.168.1.12:1521:XE", "bases2", "123456")) {

		if (conn != null) {
			System.out.println("Conectado a la Base de Datos :D");
			banderaConexion=1;
		} else {
			System.out.println("Fallo la Conexion :(");
		}

		} catch (SQLException e) {
			System.err.format("SQL Error : %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(banderaConexion==1){		
			JOptionPane.showMessageDialog(null, "Bienvenido :D");
			Inicio i = new Inicio();
			i.setVisible(true);	
		}else{
			JOptionPane.showMessageDialog(null, "Error en la Conexion a la Base de Datos");
		}
		*/
	}
	
}
