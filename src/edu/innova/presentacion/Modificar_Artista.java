package edu.innova.presentacion;

import edu.innova.exceptions.InnovaModelException;
import edu.innova.helpers.HelperFecha;
import edu.innova.logica.Fabrica;
import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectador;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Modificar_Artista extends javax.swing.JInternalFrame {

    private Fabrica fabrica = new Fabrica();

    public Modificar_Artista() {
        initComponents();
        try {
            // Obtengo del EspectadorServicio todos los espectadores
            List<Artista> artistas = fabrica.getUsuarioControlador().getTodosLosArtistas();
            // Creo un DefaultListModel que almacena los objetos Espectador
            DefaultListModel<Artista> modelArtistas = new DefaultListModel<>();
            // Le cargo al JList el modelEspectadores
            listArtistas.setModel(modelArtistas);
            // Relleno el modelEspectadores con todos los espectadores obtenidos del EspectadorServicio
            artistas.forEach(e -> modelArtistas.addElement(e));
        } catch (InnovaModelException ex) {
            JOptionPane.showMessageDialog(rootPane, String.format(ex.getMessage()));
            this.dispose();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listArtistas = new javax.swing.JList<>();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblNickname = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtNickname = new javax.swing.JTextField();
        btnActualizarArtista = new javax.swing.JButton();
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
        lblApellido1 = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        lblLink = new javax.swing.JLabel();
        txtLinkUsuario = new javax.swing.JTextField();
        textAreaDescripcion = new java.awt.TextArea();
        textAreaBiografia = new java.awt.TextArea();
        label1 = new java.awt.Label();
        label3 = new java.awt.Label();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Modificar Artista");

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Artistas Registrados");
        lblTitulo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        listArtistas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listArtistasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listArtistas);

        lblNombre.setText("Nombre");

        lblApellido.setText("Apellido");

        lblNickname.setText("Nickname");

        txtNickname.setEditable(false);

        btnActualizarArtista.setText("Actualizar Espectador");
        btnActualizarArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarArtistaActionPerformed(evt);
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

        lblApellido1.setText("Nacimiento");

        lblLink.setText("Link");

        label1.setText("Descripción");

        label3.setText("Biografía");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(lblLink)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLinkUsuario))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textAreaBiografia, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAreaDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(58, 128, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLinkUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLink))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textAreaDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textAreaBiografia, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblNombre)
                                            .addComponent(lblApellido))
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                            .addComponent(txtNombre)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblApellido1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(spnDia, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(spnMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(spnAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblEmail)
                                            .addComponent(lblNombre1))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(txtId))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNickname)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNickname, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 259, Short.MAX_VALUE))
                            .addComponent(btnActualizarArtista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblApellido)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblApellido1)
                            .addComponent(jLabel2)
                            .addComponent(spnDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(spnMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(spnAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNickname)
                            .addComponent(txtNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre1)
                            .addComponent(txtId)))
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btnActualizarArtista)
                .addGap(111, 111, 111))
        );

        lblTitulo.getAccessibleContext().setAccessibleName("Artistas Registrados");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listArtistasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listArtistasValueChanged
        // Al seleccionarse un Espectador del JList, se cargan en la pantalla sus datos 
        Artista artistaSeleccionado = listArtistas.getSelectedValue();
        this.txtId.setText(String.valueOf(artistaSeleccionado.getId()));
        this.txtNombre.setText(artistaSeleccionado.getNombre());
        this.txtApellido.setText(artistaSeleccionado.getApellido());
        this.txtNickname.setText(artistaSeleccionado.getNickname());
        this.txtEmail.setText(artistaSeleccionado.getEmail());
        this.textAreaBiografia.setText(artistaSeleccionado.getBiografia());
        this.textAreaDescripcion.setText(artistaSeleccionado.getDescripcion());
        this.txtLinkUsuario.setText(artistaSeleccionado.getLinkUsuario());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(artistaSeleccionado.getFechaNacimiento());
        this.spnDia.setValue(calendar.get(Calendar.DAY_OF_MONTH));
        this.spnMes.setValue(calendar.get(Calendar.MONTH));
        this.spnAnio.setValue(calendar.get(Calendar.YEAR));

    }//GEN-LAST:event_listArtistasValueChanged

    private void btnActualizarArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarArtistaActionPerformed
        // Al presionar el boton actualizar, obtengo todos los datos del Usuario
        try {
            Long id = getLongValue(this.txtId.getText());
            String nombre = this.txtNombre.getText();
            String apellido = this.txtApellido.getText();
            String nickname = this.txtNickname.getText();
            String email = this.txtEmail.getText();
            String descripcion = this.textAreaDescripcion.getText();
            String biografia = this.textAreaBiografia.getText();
            String linkUsuario = this.txtLinkUsuario.getText();

            String dia = this.spnDia.getValue().toString();
            String mes = this.spnMes.getValue().toString();
            String anio = this.spnAnio.getValue().toString();

            // Parseo de fecha por los parametros anio, mes y dia. Si no es valido entonces lanza eexception IllegalArgumentException
            Date fechaNacimiento = HelperFecha.parsearFecha(dia, mes, anio);
            // Se carga el objeto para ser actualizado
            Artista artista = new Artista(descripcion, biografia, linkUsuario, id, nombre, apellido, fechaNacimiento);
            // Se llama EspectadorServicio al metodo modificarUsuario que hace el update 
            fabrica.getUsuarioControlador().modificarUsuario(artista);

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
        JOptionPane.showMessageDialog(rootPane, "El Artista fue modificado correctamente");
        this.dispose();
    }//GEN-LAST:event_btnActualizarArtistaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarArtista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private java.awt.Label label3;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblApellido1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblLink;
    private javax.swing.JLabel lblNickname;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<Artista> listArtistas;
    private java.awt.Panel panel1;
    private javax.swing.JSpinner spnAnio;
    private javax.swing.JSpinner spnDia;
    private javax.swing.JSpinner spnMes;
    private java.awt.TextArea textAreaBiografia;
    private java.awt.TextArea textAreaDescripcion;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JLabel txtId;
    private javax.swing.JTextField txtLinkUsuario;
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
