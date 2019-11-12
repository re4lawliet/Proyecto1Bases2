/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1bases2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlosmonterroso
 */
public class Inicio extends javax.swing.JFrame {
	
	public static MenuAdmin menu;
	public static MenuReceptorPagador menu_rp;
        public static MenuAuditor menu_au;
	public static MenuGerente menu_ge;
	public static String Session="";
	public static String Terminal="TerminaNo:";

	/**
	 * Creates new form Inicio
	 */
	public Inicio() {
		initComponents();
		this.UserCaja.setText("");
		this.PassCaja.setText("");
		
		Random r = new Random();
		int valorDado = r.nextInt(100);
		Terminal+=valorDado;
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        UserCaja = new java.awt.TextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        PassCaja = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Bienvenido al Sistema :D");

        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        UserCaja.setText("textField2");
        UserCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserCajaActionPerformed(evt);
            }
        });

        jLabel2.setText("Usurio:");

        jLabel3.setText("Contraseña:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(UserCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(PassCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(UserCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PassCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UserCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserCajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserCajaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Boton de Login
	String user=this.UserCaja.getText();
	String pass=this.PassCaja.getText();
	
	if(user.equals("admin")  && pass.equals("admin")){
		Session="admin";
		menu = new MenuAdmin();
		menu.setLocationRelativeTo(null);
		menu.setVisible(true);
		this.dispose();
	}else if(!user.equals("admin")  && !pass.equals("admin")){
		
		BaseDeDatos db = new BaseDeDatos();
		String[] columnNames = {"ID","USUARIO","NOMBRE","DPI","CORREO","ROL","AGENCIA"};
		Object[][] dataVacia = {};
		DefaultTableModel modelo = new DefaultTableModel(dataVacia, columnNames);
		String consulta = "SELECT * FROM USUARIO";
		Boolean banderaLog1=false;
                Boolean Auditor = false;
		Boolean Gerencia = false;
		try{
			Connection conn = db.conexion();
			if (conn != null) {
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(consulta);
					while(rs.next()){
						if(rs.getString("NOMBRE_USUARIO").equals(user)&&rs.getString("CONTRASENIA").equals(pass)&&rs.getString("ROL").equals("Receptor/Pagador")){
							banderaLog1=true;
							break;
						}else if(rs.getString("NOMBRE_USUARIO").equals(user)&&rs.getString("CONTRASENIA").equals(pass)&&rs.getString("ROL").equals("Auditor")){
							Auditor=true;
							break;
                                                }else if(rs.getString("NOMBRE_USUARIO").equals(user)&&rs.getString("CONTRASENIA").equals(pass)&&rs.getString("ROL").equals("Gerente de Agencia")){
							Gerencia=true;
							break;					}
						}
			} else {
					System.out.println("NO HAY CONEXION");
			}
			
			if(banderaLog1){//Lanza Receptor Pagador
				Session=user;
				menu_rp = new MenuReceptorPagador();
				menu_rp.setLocationRelativeTo(null);
				menu_rp.setVisible(true);
				this.dispose();
				
			}else if(Auditor){
                            Session=user;
				menu_au = new MenuAuditor();
				menu_au.setLocationRelativeTo(null);
				menu_au.setVisible(true);
				this.dispose();
			}else if(Gerencia){
				Session=user;
				menu_ge = new MenuGerente();
				menu_ge.setLocationRelativeTo(null);
				menu_ge.setVisible(true);
				this.dispose();
                        }else{
				JOptionPane.showMessageDialog(rootPane, "Usuario o Contraseña invalidos");
			}
			
		}catch(Exception e){  
			JOptionPane.showMessageDialog(rootPane, "Usuario o Contraseña invalidos");
		} 
        	
		
	}else{
		JOptionPane.showMessageDialog(rootPane, "Usuario o Contraseña invalidos");
	}
		
    }//GEN-LAST:event_jButton1ActionPerformed

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
			java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Inicio().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPasswordField PassCaja;
    public static java.awt.TextField UserCaja;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
