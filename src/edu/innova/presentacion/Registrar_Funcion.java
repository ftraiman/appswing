package edu.innova.presentacion;

import edu.innova.exceptions.InnovaModelException;
import edu.innova.helpers.HelperFecha;
import edu.innova.logica.Fabrica;
import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Funcion;
import edu.innova.logica.entidades.Plataforma;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Registrar_Funcion extends javax.swing.JInternalFrame {

    private Fabrica fabrica = new Fabrica();

    private Plataforma plataformaSeleccionada;
    private Espectaculo espectaculoSeleccionado;
    private Set<Artista> artistasSeleccionados = new HashSet<>();
    private List<Artista> todosLosArtistas = new ArrayList<>();
    boolean primerRender = true;

    private DefaultListModel<Artista> artistaModel = new DefaultListModel<>();

    public Registrar_Funcion() {
        initComponents();
        List<Plataforma> plataformas = fabrica.getPlataformaControlador().getTodasLasPlataformas();
        fabrica.getUsuarioControlador().getTodosLosArtistas().forEach(artista -> cbArtistas.addItem(artista));

        plataformas.forEach(plataforma -> cbPlataforma.addItem(plataforma));
        lstArtistasInvitados.setModel(artistaModel);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSeleccionarPlataforma = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        spnDia = new javax.swing.JSpinner();
        spnMes = new javax.swing.JSpinner();
        spnAnio = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        spnHora = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        spnMinuto = new javax.swing.JSpinner();
        btnSalir = new javax.swing.JButton();
        cbPlataforma = new javax.swing.JComboBox<>();
        lblEspectaculo = new javax.swing.JLabel();
        cbEspectaculo = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        lblArtistasInvitados1 = new javax.swing.JLabel();
        cbArtistas = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstArtistasInvitados = new javax.swing.JList<>();
        jArtistasInvitados2 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Alta de Función a Espectáculo");

        lblSeleccionarPlataforma.setText("Seleccionar Plataforma");

        btnRegistrar.setText("Agregar Función");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        lblTitulo.setText("Datos de la Función:");

        jLabel2.setText("Dia");

        jLabel3.setText("Mes");

        jLabel4.setText("Año");

        spnDia.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        spnMes.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        spnAnio.setModel(new javax.swing.SpinnerNumberModel(2021, 2021, null, 1));

        jLabel5.setText("Nombre");

        jLabel6.setText("Hora");

        spnHora.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));

        jLabel7.setText("Minuto");

        spnMinuto.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        cbPlataforma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPlataformaActionPerformed(evt);
            }
        });

        lblEspectaculo.setText("Seleccionar Espectáculo");

        cbEspectaculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEspectaculoActionPerformed(evt);
            }
        });

        jLabel12.setText("Fecha de inicio");

        lblArtistasInvitados1.setText("Seleccionar Artistas invitados:");

        cbArtistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbArtistasActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lstArtistasInvitados);

        jArtistasInvitados2.setText("Artistas invitados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSeleccionarPlataforma)
                                    .addComponent(lblEspectaculo))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbEspectaculo, 0, 200, Short.MAX_VALUE)
                                    .addComponent(cbPlataforma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbArtistas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel5)
                            .addComponent(lblArtistasInvitados1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                        .addComponent(spnAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spnHora, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spnMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jArtistasInvitados2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSeleccionarPlataforma)
                    .addComponent(cbPlataforma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEspectaculo)
                    .addComponent(cbEspectaculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(spnDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(spnMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(spnAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel6)
                    .addComponent(spnHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(spnMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblArtistasInvitados1)
                    .addComponent(jArtistasInvitados2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbArtistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(27, 27, 27)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnSalir))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try {
            String nombre = this.txtNombre.getText();

            validarParametros();

            Date fechaInicio = extraerFecha(spnDia.getValue(), spnMes.getValue(), spnAnio.getValue(), spnHora.getValue(), spnMinuto.getValue());
            Long idEspectaculo = espectaculoSeleccionado.getId();
            Date fechaDeRegistro = new Date();
            List<Artista> artistasInvitados = new ArrayList<>(artistasSeleccionados);

            Funcion funcion = new Funcion(nombre, idEspectaculo, fechaInicio, fechaDeRegistro, artistasInvitados);

            fabrica.getFuncionControlador().altaFuncion(funcion, espectaculoSeleccionado);
            
            

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
        JOptionPane.showMessageDialog(rootPane, "La Función se agregó correctamente");
        this.dispose();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cbPlataformaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPlataformaActionPerformed
        plataformaSeleccionada = (Plataforma) cbPlataforma.getSelectedItem();
        List<Espectaculo> espectaculosParaPlataforma = fabrica.getEspectaculoControlador().getEspectaculosPorIdPlataforma(plataformaSeleccionada.getId());
        espectaculoSeleccionado = null;
        cbEspectaculo.removeAllItems();
//        cbEspectaculo.removeAll();
        espectaculosParaPlataforma.forEach(espectaculo -> cbEspectaculo.addItem(espectaculo));
    }//GEN-LAST:event_cbPlataformaActionPerformed

    private void cbEspectaculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEspectaculoActionPerformed
        espectaculoSeleccionado = (Espectaculo) cbEspectaculo.getSelectedItem();
    }//GEN-LAST:event_cbEspectaculoActionPerformed

    private void cbArtistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbArtistasActionPerformed
        if (!primerRender) {

            Artista artistaSeleccionado = (Artista) cbArtistas.getSelectedItem();
            if (artistasSeleccionados.contains(artistaSeleccionado)) {
                artistasSeleccionados.remove(artistaSeleccionado);
            } else {
                artistasSeleccionados.add(artistaSeleccionado);
            }
            artistaModel.removeAllElements();
            artistasSeleccionados.forEach(artista -> artistaModel.addElement(artista));
        }
        primerRender = false;
    }//GEN-LAST:event_cbArtistasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<Artista> cbArtistas;
    private javax.swing.JComboBox<Espectaculo> cbEspectaculo;
    private javax.swing.JComboBox<Plataforma> cbPlataforma;
    private javax.swing.JLabel jArtistasInvitados2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblArtistasInvitados1;
    private javax.swing.JLabel lblEspectaculo;
    private javax.swing.JLabel lblSeleccionarPlataforma;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<Artista> lstArtistasInvitados;
    private javax.swing.JSpinner spnAnio;
    private javax.swing.JSpinner spnDia;
    private javax.swing.JSpinner spnHora;
    private javax.swing.JSpinner spnMes;
    private javax.swing.JSpinner spnMinuto;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private Long getLongValue(String id) {
        try {
            return Long.valueOf(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("id"); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private Date extraerFecha(Object dia, Object mes, Object anio, Object hora, Object minuto) {
        return HelperFecha.parsearFecha(dia.toString(), mes.toString(), anio.toString(), hora.toString(), minuto.toString()
        );
    }

    private void validarParametros() {
        if (espectaculoSeleccionado == null) {
            throw new IllegalArgumentException("No hay seleccionado un Espectáculo");
        }

    }

}
