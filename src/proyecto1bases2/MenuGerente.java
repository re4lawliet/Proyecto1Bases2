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
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.jfree.chart.plot.PlotOrientation;

/**
 *
 * @author carlosmonterroso
 */
public class MenuGerente extends javax.swing.JFrame {

	/**
	 * Creates new form MenuGerente
	 */
	public MenuGerente() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Reporte1 = new javax.swing.JButton();
        Reporte2 = new javax.swing.JButton();
        Reporte3 = new javax.swing.JButton();
        Reporte4 = new javax.swing.JButton();
        Reporte5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Menu Gerente:");

        jButton1.setText("Cerrar Session");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Reporte1.setText("Grafica Saldos Por Agencia");
        Reporte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reporte1ActionPerformed(evt);
            }
        });

        Reporte2.setText("Grafica De Saldos");
        Reporte2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reporte2ActionPerformed(evt);
            }
        });

        Reporte3.setText("Clientes Con Mayores Depositos en Agencia");
        Reporte3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reporte3ActionPerformed(evt);
            }
        });

        Reporte4.setText("Clientes Con Mayor pago de Cheques");
        Reporte4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reporte4ActionPerformed(evt);
            }
        });

        Reporte5.setText("Clientes que nunca an Depositado en Agencia");
        Reporte5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reporte5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Reporte1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Reporte2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Reporte3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Reporte4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Reporte5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 32, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addGap(29, 29, 29)
                .addComponent(Reporte1)
                .addGap(18, 18, 18)
                .addComponent(Reporte2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Reporte3)
                .addGap(18, 18, 18)
                .addComponent(Reporte4)
                .addGap(18, 18, 18)
                .addComponent(Reporte5)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
		this.setVisible(false);
		Proyecto1Bases2.i = new Inicio();
		Proyecto1Bases2.i.setLocationRelativeTo(null);
		Proyecto1Bases2.i.setVisible(true);
		Inicio.UserCaja.setText("");
		Inicio.PassCaja.setText("");
		Inicio.Session="";
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Reporte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reporte1ActionPerformed
        // TODO add your handling code here:
		
		/*
		SELECT SUM(c.SALDO), a.NOMBRE_AGENCIA  
		from CUENTA c, AGENCIA a
		WHERE c.ID_AGENCIA=a.ID_AGENCIA
		GROUP BY c.ID_AGENCIA, a.NOMBRE_AGENCIA;
		*/
		DefaultPieDataset dataset = new DefaultPieDataset();
		BaseDeDatos db = new BaseDeDatos();
		Vector model = new Vector();
		String consulta = "SELECT SUM(c.SALDO), a.NOMBRE_AGENCIA "
				+ "from CUENTA c, AGENCIA a "
				+ "WHERE c.ID_AGENCIA=a.ID_AGENCIA "
				+ "GROUP BY c.ID_AGENCIA, a.NOMBRE_AGENCIA";
		
		try{
			
			Connection conn = db.conexion();
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(consulta);
			double total=0;
			
			//SACANDO EL TOTAL
			while(res.next()){
				
				String s=res.getString("SUM(C.SALDO)");
				double s1=Double.parseDouble(s);
				total+=s1;
			}
			//HACIENDO EL PORCENTAJE
			Connection conn2 = db.conexion();
			Statement stmt2 = conn2.createStatement();
			ResultSet res2 = stmt2.executeQuery(consulta);
			while(res2.next()){
				
				String s=res2.getString("SUM(C.SALDO)");
				double s1=Double.parseDouble(s);
				String a=res2.getString("NOMBRE_AGENCIA");
				
				double porcentaje=(s1*100)/(total);
				
				String Cadena=a+": "+s1+" Q, "+porcentaje+ " %";
				
				dataset.setValue(Cadena, porcentaje);
			}
			
		
		}catch(Exception e){
				JOptionPane.showMessageDialog(null,"Error EN Grafica de CUENTAS\nExcepcion: "+e,"ERROR", JOptionPane.ERROR_MESSAGE);
            
		}
		
		
		JFreeChart grafica = ChartFactory.createPieChart3D(
		"Grafica De Saldos Por Agencia (PIE)", // El nombre de la gráfica
		dataset, // El arreglo de datos
		true, // Indica si lleva leyenda
		true, // Indica si lleva tooltips
		false); // Indica si son URls
		
		ChartFrame frame = new ChartFrame("Grafica de Saldos Por Agencia", grafica);
		frame.pack();
		frame.setVisible(true);
				
    }//GEN-LAST:event_Reporte1ActionPerformed

    private void Reporte2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reporte2ActionPerformed
        // 
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		BaseDeDatos db = new BaseDeDatos();
		Vector model = new Vector();
		String consulta = "SELECT SUM(c.SALDO), SUM(c.SALDOC), a.NOMBRE_AGENCIA "
				+ "from CUENTA c, AGENCIA a "
				+ "WHERE c.ID_AGENCIA=a.ID_AGENCIA "
				+ "GROUP BY c.ID_AGENCIA, a.NOMBRE_AGENCIA";
		
		try{
			
			Connection conn = db.conexion();
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(consulta);
			double total=0;
			
			//SACANDO EL TOTAL
			while(res.next()){
				
				String s=res.getString("SUM(C.SALDO)");
				double s1=Double.parseDouble(s);
				total+=s1;
			}
			//HACIENDO EL PORCENTAJE
			Connection conn2 = db.conexion();
			Statement stmt2 = conn2.createStatement();
			ResultSet res2 = stmt2.executeQuery(consulta);
			while(res2.next()){
				
				String s=res2.getString("SUM(C.SALDO)");
				double s1=Double.parseDouble(s);
				
				String sr=res2.getString("SUM(C.SALDOC)");
				double sres=Double.parseDouble(sr);
				
				String a=res2.getString("NOMBRE_AGENCIA");
				
				double porcentaje=(s1*100)/(total);
				
				String Cadena=a+": "+s1+" Q, "+porcentaje+ " %";
				
				dataset.setValue(s1, "Disponible", a);
				dataset.setValue(sres, "Reserva", a);
				dataset.setValue(s1+sres, "Real", a);
			}
			
		
		}catch(Exception e){
				JOptionPane.showMessageDialog(null,"Error EN Grafica de CUENTAS\nExcepcion: "+e,"ERROR", JOptionPane.ERROR_MESSAGE);
            
		}
		
		JFreeChart chart = ChartFactory.createBarChart(
		"Grafica de barras SALDOS", // El titulo de la gráfica
		"Mes", // Etiqueta de categoria
		"Valor", // Etiqueta de valores
		dataset, // Datos
		PlotOrientation.VERTICAL, // orientacion
		true, // Incluye Leyenda
		true, // Incluye tooltips
		false // URLs?
		);
		
		
		ChartFrame frame = new ChartFrame("Grafica de Saldos", chart);
		frame.pack();
		frame.setVisible(true);
		
		
    }//GEN-LAST:event_Reporte2ActionPerformed

    private void Reporte3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reporte3ActionPerformed
        // TODO add your handling code here:
		/*
		select u.NOMBRE_USUARIO, count(*), t.TIPO_TRANSACCION, a.NOMBRE_AGENCIA
		from TRANSACCION t, USUARIO u, AGENCIA a
		where t.ID_USUARIO=u.ID_USUARIO
		and a.ID_AGENCIA=t.ID_AGENCIA
		and t.TIPO_TRANSACCION='Deposito Monetario'
		group by u.NOMBRE_USUARIO, t.TIPO_TRANSACCION, a.NOMBRE_AGENCIA;
		*/
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		BaseDeDatos db = new BaseDeDatos();
		Vector model = new Vector();
		String consulta = "select c.NOMBRE, count(*), t.TIPO_TRANSACCION, a.NOMBRE_AGENCIA \n" +
"		from TRANSACCION t, USUARIO u, AGENCIA a, CUENTA c \n" +
"		where t.ID_CUENTA=c.ID_CUENTA \n" +
"		and a.ID_AGENCIA=t.ID_AGENCIA \n" +
"		and t.TIPO_TRANSACCION='Deposito Monetario' \n" +
"		group by c.NOMBRE, t.TIPO_TRANSACCION, a.NOMBRE_AGENCIA";
		
		try{
			
			Connection conn = db.conexion();
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(consulta);
			double total=0;
			
			//HACIENDO EL PORCENTAJE
			Connection conn2 = db.conexion();
			Statement stmt2 = conn2.createStatement();
			ResultSet res2 = stmt2.executeQuery(consulta);
			while(res2.next()){
				
				String s=res2.getString("COUNT(*)");
				double s1=Double.parseDouble(s);
				String a=res2.getString("NOMBRE_AGENCIA");
				String u=res2.getString("NOMBRE");
				
				dataset.setValue(s1, u, a);
			}
			
		
		}catch(Exception e){
				JOptionPane.showMessageDialog(null,"Error EN Grafica de Depositos\nExcepcion: "+e,"ERROR", JOptionPane.ERROR_MESSAGE);
            
		}
		
		JFreeChart chart = ChartFactory.createBarChart(
		"Grafica de los clientes de cada agencia que tienen la\n" +
"mayor cantidad de depósitos hechos", // El titulo de la gráfica
		"Mes", // Etiqueta de categoria
		"Valor", // Etiqueta de valores
		dataset, // Datos
		PlotOrientation.VERTICAL, // orientacion
		true, // Incluye Leyenda
		true, // Incluye tooltips
		false // URLs?
		);
		
		
		ChartFrame frame = new ChartFrame("Grafica de clientes Depositos", chart);
		frame.pack();
		frame.setVisible(true);
		
    }//GEN-LAST:event_Reporte3ActionPerformed

    private void Reporte5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reporte5ActionPerformed
        // TODO add your handling code here:
		
		Reporte5 r= new Reporte5();
		r.setVisible(true);
		
    }//GEN-LAST:event_Reporte5ActionPerformed

    private void Reporte4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reporte4ActionPerformed
        // TODO add your handling code here:
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		BaseDeDatos db = new BaseDeDatos();
		Vector model = new Vector();
		String consulta = "select c.NOMBRE, count(*), t.TIPO_TRANSACCION, a.NOMBRE_AGENCIA \n" +
"		from TRANSACCION t, USUARIO u, AGENCIA a, CUENTA c \n" +
"		where t.ID_CUENTA=c.ID_CUENTA \n" +
"		and a.ID_AGENCIA=t.ID_AGENCIA \n" +
"		and t.TIPO_TRANSACCION='Compensa' \n" +
"		group by c.NOMBRE, t.TIPO_TRANSACCION, a.NOMBRE_AGENCIA";
		
		try{
			
			Connection conn = db.conexion();
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(consulta);
			double total=0;
			
			//HACIENDO EL PORCENTAJE
			Connection conn2 = db.conexion();
			Statement stmt2 = conn2.createStatement();
			ResultSet res2 = stmt2.executeQuery(consulta);
			while(res2.next()){
				
				String s=res2.getString("COUNT(*)");
				double s1=Double.parseDouble(s);
				String a=res2.getString("NOMBRE_AGENCIA");
				String u=res2.getString("NOMBRE");
				
				dataset.setValue(s1, u, a);
			}
			
		
		}catch(Exception e){
				JOptionPane.showMessageDialog(null,"Error EN Grafica de Depositos\nExcepcion: "+e,"ERROR", JOptionPane.ERROR_MESSAGE);
            
		}
		
		JFreeChart chart = ChartFactory.createBarChart(
		"Grafica de los clientes de cada agencia que tienen la\n" +
"mayor cantidad de depósitos hechos", // El titulo de la gráfica
		"Mes", // Etiqueta de categoria
		"Valor", // Etiqueta de valores
		dataset, // Datos
		PlotOrientation.VERTICAL, // orientacion
		true, // Incluye Leyenda
		true, // Incluye tooltips
		false // URLs?
		);
		
		
		ChartFrame frame = new ChartFrame("Grafica de clientes Depositos", chart);
		frame.pack();
		frame.setVisible(true);
    }//GEN-LAST:event_Reporte4ActionPerformed

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
			java.util.logging.Logger.getLogger(MenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MenuGerente().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Reporte1;
    private javax.swing.JButton Reporte2;
    private javax.swing.JButton Reporte3;
    private javax.swing.JButton Reporte4;
    private javax.swing.JButton Reporte5;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
