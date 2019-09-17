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


public class Proyecto1Bases2 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		//Test Conexion
		
		try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@192.168.1.12:1521:XE", "bases2", "123456")) {

		if (conn != null) {
			System.out.println("Connected to the database! :D");
		} else {
			System.out.println("Failed to make connection!");
		}

		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
