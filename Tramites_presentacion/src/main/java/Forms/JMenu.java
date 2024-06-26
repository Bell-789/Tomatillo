package Forms;

import javax.swing.JOptionPane;
import negocio.PersonasNegocio;

/**
 *
 * @author Chris, bell y katt
 */
public class JMenu extends javax.swing.JFrame {

    PersonasNegocio perNeg;

    /**
     * Creates new form JMenu
     */
    public JMenu() {
        initComponents();
        this.perNeg = new PersonasNegocio();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        azul = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        botonReporte = new javax.swing.JButton();
        botonLicencia = new javax.swing.JButton();
        botonConsultas = new javax.swing.JButton();
        botonPlacas = new javax.swing.JButton();
        botonInsertarPersonas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondo.setBackground(new java.awt.Color(20, 174, 92));

        azul.setBackground(new java.awt.Color(18, 234, 207));
        azul.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        titulo.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        titulo.setText("Departamento de ");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Autotransporte Federal");

        javax.swing.GroupLayout azulLayout = new javax.swing.GroupLayout(azul);
        azul.setLayout(azulLayout);
        azulLayout.setHorizontalGroup(
            azulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(azulLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(azulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, azulLayout.createSequentialGroup()
                        .addComponent(titulo)
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, azulLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(49, 49, 49))))
        );
        azulLayout.setVerticalGroup(
            azulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(azulLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        botonReporte.setBackground(new java.awt.Color(175, 244, 198));
        botonReporte.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        botonReporte.setText("Reporte de Tramites");
        botonReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReporteActionPerformed(evt);
            }
        });

        botonLicencia.setBackground(new java.awt.Color(175, 244, 198));
        botonLicencia.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        botonLicencia.setText("Módulo de Licencias");
        botonLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLicenciaActionPerformed(evt);
            }
        });

        botonConsultas.setBackground(new java.awt.Color(175, 244, 198));
        botonConsultas.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        botonConsultas.setText("Módulo de Consultas");
        botonConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultasActionPerformed(evt);
            }
        });

        botonPlacas.setBackground(new java.awt.Color(175, 244, 198));
        botonPlacas.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        botonPlacas.setText("Módulo de Placas");
        botonPlacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPlacasActionPerformed(evt);
            }
        });

        botonInsertarPersonas.setBackground(new java.awt.Color(175, 244, 198));
        botonInsertarPersonas.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        botonInsertarPersonas.setText("Insertar Personas");
        botonInsertarPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInsertarPersonasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(azul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonPlacas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonLicencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonConsultas, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))))
                .addGap(57, 57, 57))
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(botonInsertarPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(azul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonPlacas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botonInsertarPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReporteActionPerformed
        JReporteTramite po = new JReporteTramite();
        po.setVisible(true);
        dispose();
    }//GEN-LAST:event_botonReporteActionPerformed

    private void botonLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLicenciaActionPerformed
        JLicenciaForm jLicenciaForm = new JLicenciaForm(this);

        jLicenciaForm.setVisible(true);
        dispose();
    }//GEN-LAST:event_botonLicenciaActionPerformed

    private void botonPlacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPlacasActionPerformed
        JPlacaMenu pm = new JPlacaMenu();
        pm.setVisible(true);
        
        dispose();
    }//GEN-LAST:event_botonPlacasActionPerformed

    private void botonConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultasActionPerformed
        JConsultas co = new JConsultas();
        co.setVisible(true);
        
        dispose();
    }//GEN-LAST:event_botonConsultasActionPerformed

    private void botonInsertarPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInsertarPersonasActionPerformed
        if (perNeg.hayRegistros()) {
            JOptionPane.showMessageDialog(null, "Ya se han agregado las personas previamente", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            perNeg.insertarPersonas();
        }
    }//GEN-LAST:event_botonInsertarPersonasActionPerformed

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
            java.util.logging.Logger.getLogger(JMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel azul;
    private javax.swing.JButton botonConsultas;
    private javax.swing.JButton botonInsertarPersonas;
    private javax.swing.JButton botonLicencia;
    private javax.swing.JButton botonPlacas;
    private javax.swing.JButton botonReporte;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
