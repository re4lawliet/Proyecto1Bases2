package proyecto1bases2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class BaseDeDatos {
	
	
	public Boolean ProbarConexion(){
		
		try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@192.168.1.12:1521:XE", "bases2", "123456")) {

		if (conn != null) {
			System.out.println("Conectado a la Base de Datos :D");
			return true;
		} else {
			System.out.println("Fallo la Conexion :(");
			return false;
		}

		} catch (SQLException e) {
			System.err.format("SQL Error : %s\n%s", e.getSQLState(), e.getMessage());
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	
	}
	
	
}
