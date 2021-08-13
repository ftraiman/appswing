package edu.innova.presentacion;

import edu.innova.helpers.HelperFecha;
import edu.innova.logica.Fabrica;
import edu.innova.logica.entidades.Espectador;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Modificar_Espectador extends javax.swing.JInternalFrame {

    private Fabrica fabrica = new Fabrica();

    public Modificar_Espectador() {
        initComponents();
        try {
            List<Espectador> espectadores = fabrica.getEspectadorServicioImpl().getTodosLosEspectadores();
            DefaultListModel<Espectador> modelEspectadores = new DefaultListModel<>();
            listEspectadores.setModel(modelEspectadores);
            espectadores.forEach(e -> modelEspectadores.addElement(e));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, String.format("Error SQL [%s]", ex.getMessage()));
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listEspectadores = new javax.swing.JList<>();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblNickname = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtNickname = new javax.swing.JTextField();
        btnActualizarEspectador = new javax.swing.JButton();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        spnDia = new javax.swing.JSpinner();
        spnMes = new javax.swing.JSpinner();
        spnAnio = new javax.swing.JSpinner();
        lblNombre1 = new javax.swing.JLabel();
        txtId = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Modificar Espectador");

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Espectadores Registrados");
        lblTitulo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        listEspectadores.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listEspectadoresValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listEspectadores);

        lblNombre.setText("Nombre");

        lblApellido.setText("Apellido");

        lblNickname.setText("Nickname");

        txtNickname.setEditable(false);

        btnActualizarEspectador.setText("Actualizar Espectador");
        btnActualizarEspectador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarEspectadorActionPerformed(evt);
            }
        });

        lblEmail.setText("Email");

        txtEmail.setEditable(false);

        jLabel1.setText("Fecha Nacimiento");

        jLabel2.setText("Dia");

        jLabel3.setText("Mes");

        jLabel4.setText("Año");

        spnDia.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        spnMes.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        spnAnio.setModel(new javax.swing.SpinnerNumberModel(1900, 1900, null, 1));

        lblNombre1.setText("Id");

        txtId.setText("Id");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnActualizarEspectador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblApellido)
                                    .addComponent(lblNickname)
                                    .addComponent(lblNombre)
                                    .addComponent(lblEmail))
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNickname, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(43, 43, 43)
                                        .addComponent(lblNombre1)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtId))
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(5, 5, 5)
                                .addComponent(spnDia, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(275, 275, 275)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNombre1)
                        .addComponent(txtId))
                    .addComponent(lblNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNickname))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail)))
                    .addComponent(lblApellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(spnDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnActualizarEspectador)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listEspectadoresValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listEspectadoresValueChanged
        Espectador espectadorSeleccionado = listEspectadores.getSelectedValue();
        this.txtId.setText(String.valueOf(espectadorSeleccionado.getId()));
        this.txtNombre.setText(espectadorSeleccionado.getNombre());
        this.txtApellido.setText(espectadorSeleccionado.getApellido());
        this.txtNickname.setText(espectadorSeleccionado.getNickname());
        this.txtEmail.setText(espectadorSeleccionado.getEmail());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(espectadorSeleccionado.getFechaNacimiento());
        this.spnDia.setValue(calendar.get(Calendar.DAY_OF_MONTH));
        this.spnMes.setValue(calendar.get(Calendar.MONTH));
        this.spnAnio.setValue(calendar.get(Calendar.YEAR));

    }//GEN-LAST:event_listEspectadoresValueChanged

    private void btnActualizarEspectadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEspectadorActionPerformed
        Long id = Long.valueOf(this.txtId.getText());
        String nombre = this.txtNombre.getText();
        String apellido = this.txtApellido.getText();
        String nickname = this.txtNickname.getText();
        String email = this.txtEmail.getText();

        String dia = this.spnDia.getValue().toString();
        String mes = this.spnMes.getValue().toString();
        String anio = this.spnAnio.getValue().toString();

        try {
            Date fechaNacimiento = HelperFecha.parsearFecha(dia, mes, anio);
            Espectador espectador = new Espectador(id, nickname, nombre, apellido, email, fechaNacimiento);
            fabrica.getEspectadorServicioImpl().modificarUsuario(espectador);

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(rootPane, String.format("Error argumento inválido [%s]", e.getMessage()));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, String.format("Error SQL [%s]", e.getMessage()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, String.format("Error no esperado [%s]", e.getMessage()));
        }
        JOptionPane.showMessageDialog(rootPane, "El Espectador fue modificado correctamente");
        this.dispose();
    }//GEN-LAST:event_btnActualizarEspectadorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarEspectador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNickname;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<Espectador> listEspectadores;
    private javax.swing.JSpinner spnAnio;
    private javax.swing.JSpinner spnDia;
    private javax.swing.JSpinner spnMes;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JLabel txtId;
    private javax.swing.JTextField txtNickname;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

}
