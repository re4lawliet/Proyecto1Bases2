/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1bases2;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlosmonterroso
 */
public class DepositoMonetario extends javax.swing.JFrame {
	
	
	ResultSet datosUsuario;
	ResultSet datosCuenta;

	/**
	 * Creates new form DepositoMonetario
	 */
	public DepositoMonetario() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CajaCantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        CajaNumero = new javax.swing.JTextField();
        CajaNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        BotonDeposito = new javax.swing.JButton();
        BotonAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Deposito Monetario;");

        jLabel2.setText("Cantidad a Depositar:");

        CajaCantidad.setText("0");

        jLabel3.setText("No. Cuenta: ");

        jLabel4.setText("Cuenta A Nombre De:");

        BotonDeposito.setText("Realizar Deposito");
        BotonDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonDepositoActionPerformed(evt);
            }
        });

        BotonAtras.setText("Cancelar");
        BotonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BotonDeposito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(BotonAtras)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CajaNombre)
                                    .addComponent(CajaCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(CajaNumero))))))
                .addGap(146, 146, 146))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(BotonAtras))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CajaCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CajaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(BotonDeposito)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAtrasActionPerformed
        // TODO add your handling code here:
		
		Inicio.menu_rp.setVisible(true);
		this.dispose();
    }//GEN-LAST:event_BotonAtrasActionPerformed

    private void BotonDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonDepositoActionPerformed
        // Realizar Deposito
		Validaciones v = new Validaciones();
		//Obteniendo Datos
		String Usuario = Inicio.Session;
		String Cantidad=CajaCantidad.getText();
		String NumeroCuenta=CajaNumero.getText();
		String NombreDe=CajaNombre.getText();
		Date objDate = new Date(); // Sistema actual La fecha y la hora se asignan a objDate 
		String FechaHora=objDate.toString();
		String TipoTransaccion="Deposito Monetario";
		String Terminal=Inicio.Terminal;
		Boolean esCorrecto=true;
		
		
		if(v.esNumero(Cantidad)){//----------------------------CANTIDAD
		}else{
			JOptionPane.showMessageDialog(null, "La CAntidad es Invalida","ERROR",JOptionPane.ERROR_MESSAGE);
			esCorrecto=false;
		}
		if(v.esNumero(NumeroCuenta)){//----------------------------CUENTA
			
			//revisar que la cuenta Exista
			BaseDeDatos db = new BaseDeDatos();
			String consulta = "SELECT * FROM CUENTA WHERE ID_CUENTA="+NumeroCuenta;
			Boolean banderaCuenta=false;
			try{
				Connection conn = db.conexion();
				if (conn != null) {
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(consulta);
					//datosCuenta=stmt.executeQuery(consulta);
					while(rs.next()){
						if(rs.getString("ID_CUENTA").equals(NumeroCuenta)){
							banderaCuenta=true;
							break;
						}
					}
				} else {
						System.out.println("NO HAY CONEXION");
						JOptionPane.showMessageDialog(null, "No hay Conexion","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				
				if(banderaCuenta){
					//Esta Bien La Cuenta revisar si esta activa
					boolean banderaEstadoCuenta=false;
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(consulta);
					//datosCuenta=stmt.executeQuery(consulta);
					while(rs.next()){
						if(rs.getString("ESTADO").equals("1")){
							banderaEstadoCuenta=true;
							break;
						}
					}
					
					if(banderaEstadoCuenta){
						//esta bien todo
					}else{
						JOptionPane.showMessageDialog(null, "El estado de la cuenta es Cancelada o Bloqueada ","ERROR",JOptionPane.ERROR_MESSAGE);
						esCorrecto=false;
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "El Numero de Cuenta No Existe en la BD","ERROR",JOptionPane.ERROR_MESSAGE);
					esCorrecto=false;
				}
				
			}catch(Exception e){  
				JOptionPane.showMessageDialog(rootPane, "Numero de Cuenta Invalido No Existe Ese numero de Cuenta");
			}	 
			
		}else{
			JOptionPane.showMessageDialog(null, "El Numero de Cuenta Debe Ser Numerico","ERROR",JOptionPane.ERROR_MESSAGE);
			esCorrecto=false;
		}
		if(v.esAlfanumerico(NombreDe)){//----------------------------Nombre de Cuenta
		
			//nombre de la cuenta sea Correcto
			BaseDeDatos db = new BaseDeDatos();
			String consulta = "SELECT u.NOMBRE_COMPLETO, u.ID_USUARIO FROM CUENTA c, USUARIO u WHERE c.ID_CUENTA="+NumeroCuenta+" AND u.ID_USUARIO=c.ID_USUARIO";
			Boolean banderaNombre=false;
			try{
				Connection conn = db.conexion();
				if (conn != null) {
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(consulta);
					//datosUsuario=stmt.executeQuery(consulta);
					while(rs.next()){
						
						String nom=rs.getString("NOMBRE_COMPLETO").toLowerCase();
						if(nom.equals(NombreDe.toLowerCase())){
							banderaNombre=true;
							break;
						}
					}
				} else {
						System.out.println("NO HAY CONEXION");
						JOptionPane.showMessageDialog(null, "No hay Conexion","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				
				if(banderaNombre){
					//Esta Bien el nombre
				}else{
					JOptionPane.showMessageDialog(null, "El Titular de La Cuenta es Invalido="+NombreDe+" ","ERROR",JOptionPane.ERROR_MESSAGE);
					esCorrecto=false;
				}
				
			}catch(Exception e){  
				JOptionPane.showMessageDialog(null, "CathcEl Titular de La Cuenta es Invalido="+NombreDe+" ","ERROR",JOptionPane.ERROR_MESSAGE);
			}	 
		}else{
			JOptionPane.showMessageDialog(null, "El Nombre de Cuenta Invalido ej: Juan Perez","ERROR",JOptionPane.ERROR_MESSAGE);
			esCorrecto=false;
		}
		
		if(esCorrecto){
			JOptionPane.showMessageDialog(rootPane, "CORRECTO TRANSACCION");
			try{
				
				//-----------------------------------------Obteniendo Datos de La Cuenta
				BaseDeDatos db1 = new BaseDeDatos();
				String consulta1 = "SELECT * FROM CUENTA WHERE ID_CUENTA="+NumeroCuenta;
				Connection connn = db1.conexion();
				if (connn != null) {
					Statement stmt = connn.createStatement();
					datosCuenta= stmt.executeQuery(consulta1);
				}else{
					System.out.println("NO HAY CONEXION");
					JOptionPane.showMessageDialog(null, "No Hay Conexion","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				
				
				String saldo="";
				String idCuenta="";
				String idAgencia="";
				String idUsuario="";
				while(datosCuenta.next()){
					saldo=datosCuenta.getString("SALDO");
					idCuenta=datosCuenta.getString("ID_CUENTA");
					idAgencia=datosCuenta.getString("ID_AGENCIA");
					idUsuario=datosCuenta.getString("ID_USUARIO");
				}
				int s=Integer.parseInt(saldo);
				int cant=Integer.parseInt(Cantidad);
				int sF=s+cant;
				
				//-----------------------------------------Insertando en Transaccion
				BaseDeDatos bd = new BaseDeDatos();
				Connection conn = bd.conexion();
				if (conn != null) {
					String query = "INSERT INTO TRANSACCION (FECHA, TIPO_TRANSACCION, TERMINAL, SALDO_INICIAL, VALOR, SALDO_FINAL, ID_AGENCIA, ID_USUARIO, ID_CUENTA)"
								+ "VALUES('"+FechaHora+"','"+TipoTransaccion+"','"+Terminal+"','"+saldo+"','"+Cantidad+"','"+sF+"','"+idAgencia+"','"+idUsuario+"',"+idCuenta+")";
					System.out.println(query);
					Statement stmt = conn.createStatement();
					int count = stmt.executeUpdate(query);
					System.out.println(count + "filas fueron afectadas en TRANSACCION");
					
					
				}else{
					System.out.println("NO HAY CONEXION");
					JOptionPane.showMessageDialog(null, "No Hay Conexion","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				
				//llenar combobox1 de DPI de clientes
				BaseDeDatos db = new BaseDeDatos();
				String consulta = "UPDATE cuenta SET SALDO = '"+sF+"' where id_cuenta = "+idCuenta;
				
				try{
					Connection conn2 = db.conexion();
					Statement stmt = conn2.createStatement();
					System.out.println(consulta);
					int count = stmt.executeUpdate(consulta);
					System.out.println(count + "filas fueron afectadas Cuenta");
					JOptionPane.showMessageDialog(rootPane, "Se Genero Deposito a Cuenta"+idCuenta);
					Inicio.menu_rp.setVisible(true);
					this.dispose();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null,"Error En Transaccion de SALDO\nExcepcion: "+e,"ERROR", JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException e) {
					System.err.format("SQL Error : %s\n%s", e.getSQLState(), e.getMessage());
					JOptionPane.showMessageDialog(null, "SQL ERROR","ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		
    }//GEN-LAST:event_BotonDepositoActionPerformed
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(DepositoMonetario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(DepositoMonetario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(DepositoMonetario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(DepositoMonetario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new DepositoMonetario().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAtras;
    private javax.swing.JButton BotonDeposito;
    private javax.swing.JTextField CajaCantidad;
    private javax.swing.JTextField CajaNombre;
    private javax.swing.JTextField CajaNumero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
