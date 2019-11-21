/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1bases2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import com.sun.org.apache.xpath.internal.axes.ChildIterator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author carlosmonterroso
 */
public class MenuDba extends javax.swing.JFrame {
	JFileChooser RealizarBackupMySQL=new JFileChooser();
	/**
	 * Creates new form MenuDba
	 */
	public MenuDba() {
		initComponents();
		llenarCombo();
	}
	
	public void llenarCombo(){
		BaseDeDatos db = new BaseDeDatos();
		Vector model = new Vector();
		String consulta = "SELECT * FROM DBA_USERS";

	try{
            Connection conn = db.conexion();
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(consulta);
            while(res.next()){
                model.addElement(res.getObject(1)); 
            }
            jComboBox1.setModel(new DefaultComboBoxModel(model));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al llenar lista de Bases de Datos\nExcepcion: "+e,"ERROR", JOptionPane.ERROR_MESSAGE);
        } 
	
	}
	
	
	void GenerarBackupMySQL(String DataBase){
        int resp;
        Calendar c=Calendar.getInstance();
        String fecha=String.valueOf(c.get(Calendar.DATE));
        fecha=fecha+"-"+String.valueOf(c.get(Calendar.MONTH));
	fecha=fecha+"-"+String.valueOf(c.get(Calendar.YEAR));
     
        resp=RealizarBackupMySQL.showSaveDialog(this);//JFileChooser de nombre RealizarBackupMySQL
        if (resp==JFileChooser.APPROVE_OPTION) {//Si el usuario presiona aceptar; se genera el Backup
            try{
                Runtime runtime = Runtime.getRuntime();
                File backupFile = new File(String.valueOf(RealizarBackupMySQL.getSelectedFile().toString())
                        +"_"+fecha+".sql");
                FileWriter fw = new FileWriter(backupFile);
                Process child = runtime.exec("C:\\Archivos de programa\\MySQL\\MySQL Server 5.5\\bin\\mysqldump --opt --password=2311046 --user=root "
                        + "--databases "+DataBase+"-R"); 
                InputStreamReader irs = new InputStreamReader(child.getInputStream());
                BufferedReader br = new BufferedReader(irs);

                String line;
                while( (line=br.readLine()) != null ) {
                    fw.write(line + "\n");
                }
                fw.close();
                irs.close();
                br.close();

                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error no se genero el archivo por el siguiente motivo:"+e.getMessage(), "Verificar",JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(null, "Archivogenerado","Verificar",JOptionPane.INFORMATION_MESSAGE);
        } else if (resp==JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null,"Ha sido cancelada la generacion del Backup");
        }
    }

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("MEnu de DBA");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Backup");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(233, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
			java.util.logging.Logger.getLogger(MenuDba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MenuDba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MenuDba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MenuDba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MenuDba().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}