package edu.innova.presentacion;

import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.exceptions.InnovaModelException;
import edu.innova.helpers.HelperStrings;
import edu.innova.logica.Fabrica;
import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Plataforma;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Registrar_Espectaculos extends javax.swing.JInternalFrame {

    private Fabrica fabrica = new Fabrica();

    public Registrar_Espectaculos() {
        initComponents();

        try {
            // Obtengo del Plataforma Servicio las plataformas
            List<Plataforma> plat = fabrica.getPlataformaServicioImpl().getTodasLasPlataformas();
            // Creo un DefaultListModel que almacena los objetos Plataforma
            DefaultListModel<Plataforma> modelPlataforma = new DefaultListModel<>();
            // Le cargo al JList el modelEspectadores
            listPlataforma.setModel(modelPlataforma);
            // Relleno el modelEspectadores con todos los espectadores obtenidos del EspectadorServicio
            plat.forEach(e -> modelPlataforma.addElement(e));
        } catch (BaseDeDatosException ex) {
            JOptionPane.showMessageDialog(rootPane, String.format("Error SQL [%s]", ex.getMessage()));
        }

        try {
            // Obtengo del Plataforma Servicio las plataformas
            List<Artista> plat = fabrica.getUsuarioControlador().getTodosLosArtistas();
            // Creo un DefaultListModel que almacena los objetos Plataforma
            DefaultListModel<Artista> modelArtista = new DefaultListModel<>();
            // Le cargo al JList el modelEspectadores
            listArtista.setModel(modelArtista);
            // Relleno el modelEspectadores con todos los espectadores obtenidos del EspectadorServicio
            plat.forEach(e -> modelArtista.addElement(e));
        } catch (InnovaModelException ex) {
            JOptionPane.showMessageDialog(rootPane, String.format("Error SQL [%s]", ex.getMessage()));
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listPlataforma = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDesc = new javax.swing.JTextField();
        txtURL = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtId = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombreA = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtIda = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listArtista = new javax.swing.JList<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Nombre = new javax.swing.JTextField();
        Duracion = new javax.swing.JTextField();
        EspMin = new javax.swing.JTextField();
        EspMax = new javax.swing.JTextField();
        Costo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        Fecha = new javax.swing.JTextField();
        Aceptar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registrar Espectaculos");

        listPlataforma.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listPlataformaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listPlataforma);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel1.setText("Plataforma Registradas:");

        jLabel2.setText("Nombre Plataforma:");

        jLabel3.setText("Descripcion:");

        jLabel4.setText("URL:");

        txtNombre.setEditable(false);

        txtDesc.setEditable(false);

        txtURL.setEditable(false);

        jLabel5.setText("ID:");

        txtId.setText("id");

        jLabel6.setText("Nombre Artista: ");

        txtNombreA.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel7.setText("Artistas Registrados:");

        jLabel8.setText("ID Artista:");

        txtIda.setText("id");

        listArtista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listArtistaValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listArtista);

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel9.setText("Ingresar Datos Espectaculo:");

        jLabel10.setText("Nombre: ");

        jLabel11.setText("Duración:");

        jLabel12.setText("Espectadores MIN: ");

        jLabel13.setText("Espectadores MAX: ");

        jLabel14.setText("Costo:");

        Duracion.setToolTipText("En Minutos");
        Duracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DuracionActionPerformed(evt);
            }
        });

        jLabel15.setText("Fecha:");

        Fecha.setToolTipText("  Formato: (dd/mm/aa)");
        Fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FechaActionPerformed(evt);
            }
        });

        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Aceptar)
                        .addGap(18, 18, 18)
                        .addComponent(Cancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Nombre)
                                    .addComponent(Duracion)
                                    .addComponent(EspMin)
                                    .addComponent(EspMax)
                                    .addComponent(Costo)
                                    .addComponent(Fecha, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtURL)
                                    .addComponent(txtDesc)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtIda))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNombreA, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtId))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jLabel1)
                                .addGap(225, 225, 225)
                                .addComponent(jLabel7)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtId)
                    .addComponent(jLabel8)
                    .addComponent(txtIda))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(60, 60, 60)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Aceptar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(Duracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancelar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(EspMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(EspMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(Costo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listPlataformaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listPlataformaValueChanged
        // Al seleccionarse un Espectador del JList, se cargan en la pantalla sus datos
        Plataforma plata = listPlataforma.getSelectedValue();
        this.txtId.setText(String.valueOf(plata.getId()));
        this.txtNombre.setText(plata.getNombre());
        this.txtDesc.setText(plata.getDescripcion());
        this.txtURL.setText(plata.getUrl());

    }//GEN-LAST:event_listPlataformaValueChanged

    private void listArtistaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listArtistaValueChanged
        Artista a = listArtista.getSelectedValue();
        this.txtIda.setText(String.valueOf(a.getId()));
        this.txtNombreA.setText(a.getNombre());
    }//GEN-LAST:event_listArtistaValueChanged

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed

        try {
            Long idArtista = HelperStrings.getLongValue(this.txtIda.getText());
            Long idPlataforma = HelperStrings.getLongValue(this.txtId.getText());
            String nombre = this.Nombre.getText();
            Integer duracion = HelperStrings.getIntValue(this.Duracion.getText(), "duracion");
            Integer espectadoresMinimos = HelperStrings.getIntValue(this.EspMin.getText(), "espectadores mínimos");
            Integer espectadoresMaximos = HelperStrings.getIntValue(this.EspMax.getText(), "espectadores máximos");
            BigDecimal costo = HelperStrings.getBigDecimalValue(this.Costo.getText());

            String descripcion = txtDesc.getText();
            String url = txtURL.getText();

            //Al pedo?
            String fecha = this.Fecha.getText();

            Espectaculo espectaculo = new Espectaculo(nombre, descripcion, duracion, espectadoresMinimos, espectadoresMaximos, url, costo, new Date());
            
            this.txtIda.setText("");
            this.txtId.setText("");
            this.Nombre.setText("");
            this.Duracion.setText("");
            this.EspMin.setText("");
            this.EspMax.setText("");
            this.Costo.setText("");
            this.Fecha.setText("");

            int i = JOptionPane.showConfirmDialog(null, "¿Desea Registrar este Espectaculo?", "Confirmar Alta Espectaculo", JOptionPane.YES_NO_OPTION);

            if (i == JOptionPane.YES_OPTION) {
                fabrica.getEspectaculoControlador().altaEspectaculo(idArtista, idPlataforma, espectaculo);
                JOptionPane.showMessageDialog(null, "Se agrego correctamente el Espectáculo");
            } else {
                JOptionPane.showMessageDialog(null, "No se Agrego el Espectaculo");
                this.dispose();
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(rootPane, String.format("Error argumento inválido [%s]", e.getMessage()));
        } catch (InnovaModelException ex) {
            JOptionPane.showMessageDialog(rootPane, String.format("Error de capa lógica [%s]", ex.getMessage()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, String.format("Error inesperado", ex.getMessage()));
        }
    }//GEN-LAST:event_AceptarActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelarActionPerformed

    private void FechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaActionPerformed

    private void DuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DuracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DuracionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JButton Cancelar;
    private javax.swing.JTextField Costo;
    private javax.swing.JTextField Duracion;
    private javax.swing.JTextField EspMax;
    private javax.swing.JTextField EspMin;
    private javax.swing.JTextField Fecha;
    private javax.swing.JTextField Nombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Artista> listArtista;
    private javax.swing.JList<Plataforma> listPlataforma;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JLabel txtId;
    private javax.swing.JLabel txtIda;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreA;
    private javax.swing.JTextField txtURL;
    // End of variables declaration//GEN-END:variables

    private void validarFecha(String fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
