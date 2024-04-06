package Forms;

import dto.AutomovilDTO;
import dto.PlacaDTO;
import excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import negocio.ConsultasNegocio;

/**
 *
 * @author Bell
 */
public class JModuloPlacaForm extends javax.swing.JFrame {

    private AutomovilDTO dto;
    private ConsultasNegocio co;

    /**
     * Creates new form JModuloPlacaForm
     */
    public JModuloPlacaForm() {
        initComponents();
        this.dto = new AutomovilDTO();
        this.co = new ConsultasNegocio();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        botonRegresar1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        TxtNumSerie = new javax.swing.JTextField();
        BtnBuscarPlaca = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 174, 92));

        jPanel2.setBackground(new java.awt.Color(18, 234, 207));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Módulo de Placas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        botonRegresar1.setBackground(new java.awt.Color(117, 117, 117));
        botonRegresar1.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        botonRegresar1.setText(">");
        botonRegresar1.setBorder(null);
        botonRegresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresar1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 0, 20)); // NOI18N
        jLabel3.setText("Numero de serie del Automovil");

        TxtNumSerie.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        TxtNumSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNumSerieActionPerformed(evt);
            }
        });

        BtnBuscarPlaca.setBackground(new java.awt.Color(175, 244, 198));
        BtnBuscarPlaca.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        BtnBuscarPlaca.setText("Buscar");
        BtnBuscarPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarPlacaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(botonRegresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtNumSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BtnBuscarPlaca)
                .addGap(201, 201, 201))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonRegresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(TxtNumSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(BtnBuscarPlaca)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresar1ActionPerformed
        JPlacaMenu m = new JPlacaMenu();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_botonRegresar1ActionPerformed

    private void BtnBuscarPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarPlacaActionPerformed
        if (TxtNumSerie.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Campo vacio!");
        } else {
            try {
                regresarPlaca();
            } catch (PersistenciaException ex) {
                Logger.getLogger(JModuloPlacaForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_BtnBuscarPlacaActionPerformed

    private void TxtNumSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNumSerieActionPerformed
        //
    }//GEN-LAST:event_TxtNumSerieActionPerformed

    private void regresarPlaca() throws PersistenciaException {
        dto.setNumSerie(TxtNumSerie.getText());

        JHistorialPlacasAntiguas old = new JHistorialPlacasAntiguas(dto);
        old.setVisible(true);

        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BtnBuscarPlaca;
    public javax.swing.JTextField TxtNumSerie;
    private javax.swing.JButton botonRegresar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
