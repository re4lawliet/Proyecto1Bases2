/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1bases2;

import javax.swing.JOptionPane;

/**
 *
 * @author carlosmonterroso
 */
public class ABC_Usuario extends javax.swing.JFrame {

	/**
	 * Creates new form ABC_Usuario
	 */
	public ABC_Usuario() {
		initComponents();
		LabelTipoCuenta.setVisible(false);
		ComboBoxTipoCuenta.setVisible(false);
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        CajaUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        CajaNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CajaPass = new javax.swing.JPasswordField();
        CajaConfirmePass = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        CajaDPI = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        CajaCorreo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        BotonSubirFoto = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        BotonSubirFirma = new javax.swing.JButton();
        BotonCrearUsuario = new javax.swing.JButton();
        ComboBoxTipoCuenta = new javax.swing.JComboBox<>();
        LabelTipoCuenta = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ComboBoxRol = new javax.swing.JComboBox<>();
        CajaBuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        BotonAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ABC USUARIO");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Usuario: \"Seleccione un nombre de Usuario\"");

        jLabel3.setText("Nombre Completo:");

        jLabel4.setText("Escriba una Contraseña:");

        jLabel5.setText("Confirme su contraseña:");

        jLabel6.setText("Numero de DPI:");

        jLabel7.setText("Correo Electronico:");

        jLabel8.setText("Foto de Usuario: Seleccione una Foto de su Compu:");

        BotonSubirFoto.setText("Subir");

        jLabel9.setText("Firma: Seleccione una foto de Su Firma:");

        BotonSubirFirma.setText("Subir");

        BotonCrearUsuario.setText("Crear Usuario");
        BotonCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCrearUsuarioActionPerformed(evt);
            }
        });

        ComboBoxTipoCuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        LabelTipoCuenta.setText("Seleccione la agencia asociada");

        jLabel11.setText("Seleccione el Rol de Este Usuario:");

        ComboBoxRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Cliente", "Receptor/Pagador", "Gerente de Agencia" }));
        ComboBoxRol.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboBoxRolItemStateChanged(evt);
            }
        });

        jButton1.setText("Buscar");

        BotonAtras.setText("Atras");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CajaUsuario)
                                .addComponent(jLabel3)
                                .addComponent(CajaNombre)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(CajaPass)
                                .addComponent(CajaConfirmePass)
                                .addComponent(jLabel6)
                                .addComponent(CajaDPI)
                                .addComponent(jLabel7)
                                .addComponent(CajaCorreo))
                            .addComponent(jLabel8)
                            .addComponent(BotonSubirFoto)
                            .addComponent(jLabel9)
                            .addComponent(BotonSubirFirma)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(BotonCrearUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LabelTipoCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComboBoxTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ComboBoxRol, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotonAtras)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)
                        .addComponent(BotonAtras)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CajaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CajaPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CajaConfirmePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CajaDPI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CajaCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonSubirFoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonSubirFirma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addGap(7, 7, 7)
                        .addComponent(ComboBoxRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelTipoCuenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBoxTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonCrearUsuario)
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAtrasActionPerformed
        
		Inicio.menu.setVisible(true);
		this.dispose();
    }//GEN-LAST:event_BotonAtrasActionPerformed

    private void ComboBoxRolItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBoxRolItemStateChanged
		switch (ComboBoxRol.getSelectedIndex()) {
			case 0: //sin tipo
				JOptionPane.showMessageDialog(null, "Seleccione un rol");
				LabelTipoCuenta.setVisible(false);
				ComboBoxTipoCuenta.setVisible(false);
				break;
			case 1://tipo cliente
				LabelTipoCuenta.setVisible(false);
				ComboBoxTipoCuenta.setVisible(false);
				break;
			case 2://receptor pagador
				LabelTipoCuenta.setVisible(true);
				ComboBoxTipoCuenta.setVisible(true);
				break;
			case 3://Gerente de agencia
				LabelTipoCuenta.setVisible(true);
				ComboBoxTipoCuenta.setVisible(true);
				break;
			default:
				break;
		}
    }//GEN-LAST:event_ComboBoxRolItemStateChanged

    private void BotonCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCrearUsuarioActionPerformed
        // BOTON PARA CREAR USUARIO
		try{
			Validaciones v = new Validaciones();
			//Obteniendo Datos
			String Usuario = CajaUsuario.getText();
			String Pass=CajaPass.getText();
			String ConfirmPass=CajaConfirmePass.getText();
			String Nombre=CajaNombre.getText();
			String DPI=CajaDPI.getText();
			String Correo=CajaCorreo.getText();
			
			Boolean esCorrecto=true;
			//Validando Datos
			if(v.esIdentificador(Usuario)){//----------------------------USUARIO
			}else{
				JOptionPane.showMessageDialog(null, "Nombre de Usuario invalido","ERROR",JOptionPane.ERROR_MESSAGE);
				esCorrecto=false;
			}
			if(v.esIdentificador(Pass)&&v.entraEnLimite(Pass, 8)){//--------PASS
			}else{
				JOptionPane.showMessageDialog(null, "Contraseña Invalida Debe usar letras y numeros","ERROR",JOptionPane.ERROR_MESSAGE);
				esCorrecto=false;
			}
			if(ConfirmPass.equals(Pass)){//-----------------------------Confirm PASS
			}else{
				JOptionPane.showMessageDialog(null, "Contraseñas no coinciden","ERROR",JOptionPane.ERROR_MESSAGE);
				esCorrecto=false;
			}
			if(v.esAlfanumerico(Nombre)){//-----------------------------NOMBRE	
			}else{
				JOptionPane.showMessageDialog(null, "Nombre Invalido","ERROR",JOptionPane.ERROR_MESSAGE);
				esCorrecto=false;
			}
			if(v.esNumero(DPI)){//-------------------------------------DPI	
			}else{
				JOptionPane.showMessageDialog(null, "DPI debe ser solo numeros sin espacio","ERROR",JOptionPane.ERROR_MESSAGE);
				esCorrecto=false;
			}
			if(v.esCorreo(Correo)){//-----------------------------------CORREO
			}else{
				JOptionPane.showMessageDialog(null, "Correo Invalido","ERROR",JOptionPane.ERROR_MESSAGE);
				esCorrecto=false;
			}
			
			//*********************************
			//***Si TODO SALE BIEN ***********
			//*********************************
			if(esCorrecto){
			
			}
			
   
		}catch(Exception e){
			JOptionPane.showMessageDialog(rootPane, "Error al Crear Usuario: Status: "+e);
		}
    }//GEN-LAST:event_BotonCrearUsuarioActionPerformed

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
			java.util.logging.Logger.getLogger(ABC_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ABC_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ABC_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ABC_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ABC_Usuario().setVisible(true);
			}
		});
	}
	
	

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAtras;
    private javax.swing.JButton BotonCrearUsuario;
    private javax.swing.JButton BotonSubirFirma;
    private javax.swing.JButton BotonSubirFoto;
    private javax.swing.JTextField CajaBuscar;
    private javax.swing.JPasswordField CajaConfirmePass;
    private javax.swing.JTextField CajaCorreo;
    private javax.swing.JTextField CajaDPI;
    private javax.swing.JTextField CajaNombre;
    private javax.swing.JPasswordField CajaPass;
    private javax.swing.JTextField CajaUsuario;
    private javax.swing.JComboBox<String> ComboBoxRol;
    private javax.swing.JComboBox<String> ComboBoxTipoCuenta;
    private javax.swing.JLabel LabelTipoCuenta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
