package edu.innova.presentacion;

import edu.innova.exceptions.InnovaModelException;
import edu.innova.helpers.HelperFecha;
import edu.innova.logica.Fabrica;
import edu.innova.logica.entidades.Espectador;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Modificar_Espectador extends javax.swing.JInternalFrame {

    private Fabrica fabrica = new Fabrica();

    public Modificar_Espectador() {
        initComponents();
        try {
            // Obtengo del EspectadorServicio todos los espectadores
            List<Espectador> espectadores = fabrica.getUsuarioControlador().getTodosLosEspectadores();
            // Creo un DefaultListModel que almacena los objetos Espectador
            DefaultListModel<Espectador> modelEspectadores = new DefaultListModel<>();
            // Le cargo al JList el modelEspectadores
            listEspectador.setModel(modelEspectadores);
            // Relleno el modelEspectadores con todos los espectadores obtenidos del EspectadorServicio
            espectadores.forEach(e -> modelEspectadores.addElement(e));
        } catch (InnovaModelException ex) {
            JOptionPane.showMessageDialog(rootPane, String.format(ex.getMessage()));
            this.dispose();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listEspectador = new javax.swing.JList<>();
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
        btn_Cancelar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Modificar Espectador");
        setPreferredSize(new java.awt.Dimension(700, 500));

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Espectadores Registrados");
        lblTitulo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        listEspectador.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listEspectadorValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listEspectador);

        lblNombre.setText("Nombre");

        lblApellido.setText("Apellido");

        lblNickname.setText("Nickname");

        txtNickname.setEditable(false);
        txtNickname.setEnabled(false);

        btnActualizarEspectador.setText("Actualizar");
        btnActualizarEspectador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarEspectadorActionPerformed(evt);
            }
        });

        lblEmail.setText("Email");

        txtEmail.setEditable(false);
        txtEmail.setEnabled(false);

        jLabel1.setText("Fecha Nacimiento");

        jLabel2.setText("Dia");

        jLabel3.setText("Mes");

        jLabel4.setText("Año");

        spnDia.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        spnMes.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        spnAnio.setModel(new javax.swing.SpinnerNumberModel(2021, 2021, null, 1));

        lblNombre1.setText("ID");

        txtId.setText("Id");

        btn_Cancelar.setText("Cancelar");
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });

        jButton1.setText("Ver Espectadores");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addComponent(lblNombre1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblApellido)
                            .addComponent(lblNickname))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNickname, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(txtId)
                            .addComponent(txtEmail)))
                    .addComponent(lblEmail)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
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
                        .addComponent(spnAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnActualizarEspectador, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre1)
                    .addComponent(txtId))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNickname)
                    .addComponent(txtNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spnAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(spnDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spnMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizarEspectador)
                    .addComponent(btn_Cancelar)
                    .addComponent(jButton1))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listEspectadorValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listEspectadorValueChanged
        // Al seleccionarse un Espectador del JList, se cargan en la pantalla sus datos 
        Espectador espectadorSeleccionado = listEspectador.getSelectedValue();
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

    }//GEN-LAST:event_listEspectadorValueChanged

    private void btnActualizarEspectadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEspectadorActionPerformed
        // Al presionar el boton actualizar, obtengo todos los datos del Usuario
        try {

            Long id = getLongValue(this.txtId.getText());
            String nombre = this.txtNombre.getText();
            String apellido = this.txtApellido.getText();
            String nickname = this.txtNickname.getText();
            String email = this.txtEmail.getText();

            String dia = this.spnDia.getValue().toString();
            String mes = this.spnMes.getValue().toString();
            String anio = this.spnAnio.getValue().toString();

            // Parseo de fecha por los parametros anio, mes y dia. Si no es valido entonces lanza eexception IllegalArgumentException
            Date fechaNacimiento = HelperFecha.parsearFecha(dia, mes, anio);
            // Se carga el objeto para ser actualizado
            Espectador espectador = new Espectador(id, nombre, apellido, fechaNacimiento);
            // Se llama EspectadorServicio al metodo modificarUsuario que hace el update 
            fabrica.getUsuarioControlador().modificarUsuario(espectador);

            this.txtId.setText("");
            this.txtNombre.setText("");
            this.txtApellido.setText("");
            this.txtNickname.setText("");
            this.txtEmail.setText("");

            this.spnDia.setValue(1);
            this.spnMes.setValue(1);
            this.spnAnio.setValue(2021);

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(rootPane, String.format("Error argumento inválido [%s]", e.getMessage()));
            return;
        } catch (InnovaModelException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, String.format("Error desconocido [%s]", e.getMessage()));
            return;
        }
        JOptionPane.showMessageDialog(rootPane, "El Espectador fue modificado correctamente");
        //this.dispose();
    }//GEN-LAST:event_btnActualizarEspectadorActionPerformed

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        //this.dispose();
        this.txtId.setText("");
        this.txtNombre.setText("");
        this.txtApellido.setText("");
        this.txtNickname.setText("");
        this.txtEmail.setText("");

        this.spnDia.setValue(1);
        this.spnMes.setValue(1);
        this.spnAnio.setValue(2021);
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Todos_Los_Espectadores te = new Todos_Los_Espectadores();
            GUI_Proyecto.Panel.add(te);
            te.toFront();
            te.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Modificar_Artista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarEspectador;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JList<Espectador> listEspectador;
    private javax.swing.JSpinner spnAnio;
    private javax.swing.JSpinner spnDia;
    private javax.swing.JSpinner spnMes;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JLabel txtId;
    private javax.swing.JTextField txtNickname;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private Long getLongValue(String id) {
        try {
            return Long.valueOf(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("id"); //To change body of generated methods, choose Tools | Templates.
        }
    }

}
