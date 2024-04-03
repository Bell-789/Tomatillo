package Forms;

import dto.AutomovilDTO;
import dto.PersonaDTO;
import excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import negocio.AutomovilesNegocio;
import negocio.PersonasNegocio;
import recursos.TipoAutomovil;
import validaciones.Validadores;

/**
 *
 * @author Bell
 */
public class JAgregarCarroForm extends javax.swing.JFrame {

    private PersonaDTO personaDTO;
    private AutomovilDTO automovilDTO;
    private Validadores validadores;
    private PersonasNegocio perNeg;
    private AutomovilesNegocio autoNeg;
    private TipoAutomovil tipo;

    /**
     * Creates new form JAgregarCarroForm
     */
    public JAgregarCarroForm() {
        initComponents();
        this.validadores = new Validadores();
        this.perNeg = new PersonasNegocio();
        this.autoNeg = new AutomovilesNegocio();
        this.personaDTO = new PersonaDTO();
        this.automovilDTO = new AutomovilDTO();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtLineaCarro = new javax.swing.JTextField();
        TxtNumeroSerie = new javax.swing.JTextField();
        TxtMarcaCarro = new javax.swing.JTextField();
        TxtModeloCarro = new javax.swing.JTextField();
        TxtColorCarro = new javax.swing.JTextField();
        BtnRegistrarCarro = new javax.swing.JToggleButton();
        botonRegresar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        TxtRfc = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 174, 92));

        jPanel2.setBackground(new java.awt.Color(18, 234, 207));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Registro de carro");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(77, 77, 77))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 0, 20)); // NOI18N
        jLabel2.setText("Modelo del carro");

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 0, 20)); // NOI18N
        jLabel3.setText("Numero de serie");

        jLabel4.setFont(new java.awt.Font("Lucida Sans", 0, 20)); // NOI18N
        jLabel4.setText("Color del carro");

        jLabel5.setFont(new java.awt.Font("Lucida Sans", 0, 20)); // NOI18N
        jLabel5.setText("Marca de carro");

        jLabel6.setFont(new java.awt.Font("Lucida Sans", 0, 20)); // NOI18N
        jLabel6.setText("Linea del carro");

        TxtLineaCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtLineaCarroActionPerformed(evt);
            }
        });

        TxtMarcaCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtMarcaCarroActionPerformed(evt);
            }
        });

        TxtModeloCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtModeloCarroActionPerformed(evt);
            }
        });

        BtnRegistrarCarro.setBackground(new java.awt.Color(175, 244, 198));
        BtnRegistrarCarro.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        BtnRegistrarCarro.setText("Registrar");
        BtnRegistrarCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarCarroActionPerformed(evt);
            }
        });

        botonRegresar.setBackground(new java.awt.Color(117, 117, 117));
        botonRegresar.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        botonRegresar.setText(">");
        botonRegresar.setBorder(null);
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lucida Sans", 0, 20)); // NOI18N
        jLabel7.setText("RFC");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BtnRegistrarCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TxtColorCarro)
                                    .addComponent(TxtLineaCarro, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                    .addComponent(TxtMarcaCarro, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                    .addComponent(TxtModeloCarro))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonRegresar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TxtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TxtMarcaCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtModeloCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(TxtLineaCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtColorCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(BtnRegistrarCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
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

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        JPlacaMenu m = new JPlacaMenu();
        m.setVisible(true);

        dispose();
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void TxtMarcaCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtMarcaCarroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtMarcaCarroActionPerformed

    private void BtnRegistrarCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarCarroActionPerformed
        try {
            buscar();
            carro();
        } catch (PersistenciaException ex) {
            Logger.getLogger(JAgregarCarroForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnRegistrarCarroActionPerformed

    private void TxtLineaCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtLineaCarroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtLineaCarroActionPerformed

    private void TxtModeloCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtModeloCarroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtModeloCarroActionPerformed

    private void buscar() throws PersistenciaException {
        personaDTO = new PersonaDTO(TxtRfc.getText());
        String RFCb = TxtRfc.getText();
        if (RFCb.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor, ingrese el RFC para continuar",
                    "Error: Campo vacío",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        if (!validadores.validaRfc(RFCb)) {
            JOptionPane.showMessageDialog(
                    this,
                    "RFC inválido. Verifica que el RFC sea \n el correcto e ingréselo nuevamente",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);;
            return;
        }
        personaDTO = perNeg.consultarPersonaPorRfc(personaDTO);
    }

    private void carro() throws PersistenciaException {
        if (TxtLineaCarro.getText().isBlank() || TxtColorCarro.getText().isBlank() || TxtMarcaCarro.getText().isBlank() || TxtModeloCarro.getText().isBlank() || TxtNumeroSerie.getText().isBlank() || TxtRfc.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Complete los campos solicitados");
        } else {
            automovilDTO.setColor(TxtColorCarro.getText());
            automovilDTO.setLinea(TxtLineaCarro.getText());
            automovilDTO.setMarca(TxtMarcaCarro.getText());
            automovilDTO.setModelo(TxtModeloCarro.getText());
            automovilDTO.setNumSerie(TxtNumeroSerie.getText());
            automovilDTO.setTipo(tipo.Nuevo);
            automovilDTO.setPersona(personaDTO);

            autoNeg.registraraCarro(automovilDTO);
            ValidacionExitosa ca = new ValidacionExitosa();
            ca.show();
            dispose();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BtnRegistrarCarro;
    public javax.swing.JTextField TxtColorCarro;
    public javax.swing.JTextField TxtLineaCarro;
    public javax.swing.JTextField TxtMarcaCarro;
    public javax.swing.JTextField TxtModeloCarro;
    public javax.swing.JTextField TxtNumeroSerie;
    private javax.swing.JTextField TxtRfc;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
