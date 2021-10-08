package edu.innova.presentacion;

import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.exceptions.InnovaModelException;
import edu.innova.helpers.HelperFecha;
import edu.innova.helpers.HelperStrings;
import edu.innova.logica.Fabrica;
import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Categoria;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Plataforma;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

//Prueba
public class Registrar_Espectaculos extends javax.swing.JInternalFrame {

    private Fabrica fabrica = new Fabrica();
    
    private Categoria categoriaSeleccionado;

    public Registrar_Espectaculos() throws SQLException {
        initComponents();

        try {

            List<Categoria> categorias = fabrica.getEspectaculoControlador().getTodasLasCategorias();
            categorias.forEach(categoria -> SelecciondeCategoria.addItem(categoria));

            //Carga la plataforma en un jList
            cargarPlataforma();

            //Carga los artistas en un jList
            cargarArtista();

        } catch (BaseDeDatosException ex) {
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
        Aceptar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        spi_dia = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        spi_mes = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        spi_año = new javax.swing.JSpinner();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        SelecciondeCategoria = new javax.swing.JComboBox<>();

        setClosable(true);
        setResizable(true);
        setTitle("Registrar Espectaculos");

        listPlataforma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listPlataformaMouseClicked(evt);
            }
        });
        listPlataforma.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listPlataformaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listPlataforma);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel1.setText("Plataforma Registradas");

        jLabel2.setText("Nombre Plataforma:");

        jLabel3.setText("Descripcion:");

        jLabel4.setText("URL:");

        txtNombre.setEditable(false);
        txtNombre.setEnabled(false);

        txtDesc.setEditable(false);
        txtDesc.setEnabled(false);

        txtURL.setEditable(false);
        txtURL.setEnabled(false);

        jLabel5.setText("ID:");

        txtId.setText("id");

        jLabel6.setText("Nombre Artista: ");

        txtNombreA.setEditable(false);
        txtNombreA.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel7.setText("Artistas Registrados");

        jLabel8.setText("ID Artista:");

        txtIda.setText("id");

        listArtista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listArtistaMouseClicked(evt);
            }
        });
        listArtista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listArtistaValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listArtista);

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel9.setText("Ingresar Datos Espectaculo");

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

        spi_dia.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        jLabel16.setText("Dia");

        spi_mes.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        jLabel17.setText("Mes");

        spi_año.setModel(new javax.swing.SpinnerNumberModel(2021, 2021, null, 1));

        jLabel18.setText("Año");

        jLabel19.setText("Minutos");

        jButton1.setText("Ver Espectaculos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel20.setText("Selecionar Categoria:");

        SelecciondeCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelecciondeCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(Costo, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel13)
                                                    .addComponent(jLabel12)
                                                    .addComponent(jLabel14)
                                                    .addComponent(jLabel10))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(35, 35, 35)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(EspMin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(EspMax, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtURL)
                                                .addComponent(txtDesc)
                                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel11))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spi_dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Duracion))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spi_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spi_año, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel19)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel20))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtIda)
                                        .addComponent(txtNombreA, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SelecciondeCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(104, 104, 104)
                                    .addComponent(jLabel7))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(Aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(txtIda)
                    .addComponent(txtId))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(SelecciondeCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(spi_dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16)
                                .addComponent(jLabel15)
                                .addComponent(spi_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17)
                                .addComponent(spi_año, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18))
                            .addGap(19, 19, 19)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(Duracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Costo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(EspMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(EspMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cancelar)
                    .addComponent(Aceptar)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listPlataformaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listPlataformaValueChanged
        // Al seleccionarse un Espectador del JList, se cargan en la pantalla sus datos
        //Plataforma plata = listPlataforma.getSelectedValue();
        //this.txtId.setText(String.valueOf(plata.getId()));
        //this.txtNombre.setText(plata.getNombre());
        //this.txtDesc.setText(plata.getDescripcion());
        //this.txtURL.setText(plata.getUrl());
    }//GEN-LAST:event_listPlataformaValueChanged

    private void listArtistaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listArtistaValueChanged
        //Artista a = listArtista.getSelectedValue();
        //this.txtIda.setText(String.valueOf(a.getId()));
        //this.txtNombreA.setText(a.getNombre());
    }//GEN-LAST:event_listArtistaValueChanged

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        try {
            //VALIDA SI HAY PARAMATROS EN EL CB DE CATEGORIA
            validarParametrosCategoria();

            //Verifica que los campos no esten vacios (Lo hago aca para ser mas practico)
            //HelperStrings.stringNoVacio(this.txtIda.getText(), "ID Artista");
            //HelperStrings.stringNoVacio(this.txtId.getText(), "ID Plataforma");
            HelperStrings.stringNoVacio(this.Duracion.getText(), "Duracion");
            HelperStrings.stringNoVacio(this.EspMin.getText(), "Espectadores Minimos");
            HelperStrings.stringNoVacio(this.EspMax.getText(), "Espectadores Maximos");
            HelperStrings.stringNoVacio(this.Costo.getText(), "Descuento");

            //transforma la ID de string a Long
            Long idArtista = HelperStrings.getLongValue(this.txtIda.getText(), "IdArtista");
            Long idPlataforma = HelperStrings.getLongValue(this.txtId.getText(), "IdPlataforma");

            //Datos basicos
            String nombre = this.Nombre.getText();
            String descripcion = txtDesc.getText();
            String url = txtURL.getText();

            //transforma de String a Integer
            Integer duracion = HelperStrings.getIntValue(this.Duracion.getText(), "duracion");
            Integer espectadoresMinimos = HelperStrings.getIntValue(this.EspMin.getText(), "espectadores mínimos");
            Integer espectadoresMaximos = HelperStrings.getIntValue(this.EspMax.getText(), "espectadores máximos");
            validarCantidadEspectadores();

            //transforma de String a BigDecimal
            BigDecimal costo = HelperStrings.getBigDecimalValue(this.Costo.getText());

            //Datos Fecha
            String fdia = this.spi_dia.getValue().toString();
            String fmes = this.spi_mes.getValue().toString();
            String fanio = this.spi_año.getValue().toString();
            Date fecha = HelperFecha.parsearFecha(fdia, fmes, fanio); //Convertimos la fecha para aa/mm/dd

            Categoria CategoriaID = (Categoria) SelecciondeCategoria.getSelectedItem();
            Long idc = CategoriaID.getId();

            //Creamos el objeto espectaculo
            Espectaculo espectaculo = new Espectaculo(nombre, descripcion, duracion, espectadoresMinimos, espectadoresMaximos, url, costo, fecha, idc, "Ingresado", "imagen");

            //Y mandamos al controlador a verificar datos
            fabrica.getEspectaculoControlador().altaEspectaculo(idArtista, idPlataforma, espectaculo);

            //Limpiar Espectaculo
            this.Nombre.setText("");
            this.Duracion.setText("");
            this.EspMin.setText("");
            this.EspMax.setText("");
            this.Costo.setText("");

            //Limpiar Fecha
            this.spi_dia.setValue(1);
            this.spi_mes.setValue(1);
            this.spi_año.setValue(2021);

            //Limpiar Listas
            this.listArtista.clearSelection();
            this.listPlataforma.clearSelection();
            this.txtId.setText("");
            this.txtNombre.setText("");
            this.txtDesc.setText("");
            this.txtURL.setText("");

        } catch (IllegalArgumentException | InnovaModelException e) {
            JOptionPane.showMessageDialog(rootPane, String.format("%s", e.getMessage()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, String.format("Error inesperado", ex.getMessage()));
        }
    }//GEN-LAST:event_AceptarActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed

        //Limpiar Espectaculo
        this.Nombre.setText("");
        this.Duracion.setText("");
        this.EspMin.setText("");
        this.EspMax.setText("");
        this.Costo.setText("");

        //Limpiar Fecha
        this.spi_dia.setValue(1);
        this.spi_mes.setValue(1);
        this.spi_año.setValue(2021);

        //Limpiar Listas
        this.listArtista.clearSelection();
        this.listPlataforma.clearSelection();
        this.txtId.setText("");
        this.txtNombre.setText("");
        this.txtDesc.setText("");
        this.txtURL.setText("");
        this.txtIda.setText("");
        this.txtNombreA.setText("");

    }//GEN-LAST:event_CancelarActionPerformed

    private void DuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DuracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DuracionActionPerformed

    private void listArtistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listArtistaMouseClicked
        // TODO add your handling code here:
        Artista a = listArtista.getSelectedValue();
        this.txtIda.setText(String.valueOf(a.getId()));
        this.txtNombreA.setText(a.getNombre());
    }//GEN-LAST:event_listArtistaMouseClicked

    private void listPlataformaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listPlataformaMouseClicked
        // TODO add your handling code here:
        Plataforma plata = listPlataforma.getSelectedValue();
        this.txtId.setText(String.valueOf(plata.getId()));
        this.txtNombre.setText(plata.getNombre());
        this.txtDesc.setText(plata.getDescripcion());
        this.txtURL.setText(plata.getUrl());
    }//GEN-LAST:event_listPlataformaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Todos_Los_Espectaculos te = new Todos_Los_Espectaculos();
            GUI_Proyecto.Panel.add(te);
            te.toFront();
            te.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Modificar_Artista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SelecciondeCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelecciondeCategoriaActionPerformed
        //AL SELECCIONAR UNA CATEGORIA SE ASIGNA ESE VALOR A categoriaSeleccionada
        categoriaSeleccionado = (Categoria) SelecciondeCategoria.getSelectedItem();
    }//GEN-LAST:event_SelecciondeCategoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JButton Cancelar;
    private javax.swing.JTextField Costo;
    private javax.swing.JTextField Duracion;
    private javax.swing.JTextField EspMax;
    private javax.swing.JTextField EspMin;
    private javax.swing.JTextField Nombre;
    private javax.swing.JComboBox<Categoria> SelecciondeCategoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JSpinner spi_año;
    private javax.swing.JSpinner spi_dia;
    private javax.swing.JSpinner spi_mes;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JLabel txtId;
    private javax.swing.JLabel txtIda;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreA;
    private javax.swing.JTextField txtURL;
    // End of variables declaration//GEN-END:variables

    private void cargarPlataforma() {
        // Obtengo de PlataformaServicio las plataformas
        List<Plataforma> plat = fabrica.getPlataformaServicioImpl().getTodasLasPlataformas();

        // Creo un DefaultListModel que almacena los objetos Plataforma
        DefaultListModel<Plataforma> modelPlataforma = new DefaultListModel<>();

        // Le cargo al JList el modelPlataforma
        listPlataforma.setModel(modelPlataforma);

        // Relleno el modelPlataforma con todas las plataformas obtenidos del PlataformaServicio
        plat.forEach(e -> modelPlataforma.addElement(e));
    }

    private void cargarArtista() {
        // Obtengo del ArtistaServicio las plataformas
        List<Artista> art = fabrica.getUsuarioControlador().getTodosLosArtistas();

        // Creo un DefaultListModel que almacena los objetos Artista
        DefaultListModel<Artista> modelArtista = new DefaultListModel<>();

        // Le cargo al JList el modelArtista
        listArtista.setModel(modelArtista);

        // Relleno el modelArtista con todos los artistas obtenidos del ArtistaServicio
        art.forEach(e -> modelArtista.addElement(e));
    }

    private void validarCantidadEspectadores() {
        Integer espectadoresMinimos = HelperStrings.getIntValue(this.EspMin.getText(), "espectadores mínimos");
        Integer espectadoresMaximos = HelperStrings.getIntValue(this.EspMax.getText(), "espectadores máximos");

        //Verificar que los espMin no sea mayor a espMax
        if (espectadoresMinimos > espectadoresMaximos) {
            throw new InnovaModelException("Los Espectadores Minimos no puede superar a los Espectadores Maximos");
        }

    }

    //=============== VERIFICA SI SE SELECCIONO UNA CATEGORIA ================//
    private void validarParametrosCategoria() {
        if (categoriaSeleccionado == null) {
            throw new IllegalArgumentException("No hay seleccionado una CATEGORIA");
        }
    }
    //=============== VERIFICA SI SE SELECCIONO UNA CATEGORIA ================//
}
