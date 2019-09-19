package proyecto1bases2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class BaseDeDatos {
	
	
	public Boolean ProbarConexion(){
		
		try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@34.70.191.184:49161:xe", "system", "oracle")) {

		if (conn != null) {
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
