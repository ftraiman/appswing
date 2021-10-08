package edu.innova.presentacion;

import edu.innova.exceptions.InnovaModelException;
import edu.innova.helpers.HelperFecha;
import edu.innova.logica.Fabrica;
import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Funcion;
import edu.innova.logica.entidades.Plataforma;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Registrar_espectador_a_Funcion extends javax.swing.JInternalFrame {

    private Fabrica fabrica = new Fabrica();

    private Plataforma plataformaSeleccionada;
    private Espectaculo espectaculoSeleccionado;
    private Funcion funcionSeleccionada;
    private Espectador espectadorSeleccionado;

    private Set<Funcion> funcionesCanjeables = new HashSet<>();
    private Set<Funcion> funcionesParaCanjear = new HashSet<>();
    private DefaultListModel<Funcion> funcionesCanjeablesModel = new DefaultListModel<>();
    private DefaultListModel<Funcion> funcionesParaCanjearModel = new DefaultListModel<>();

    private DefaultListModel<Artista> artistaModel = new DefaultListModel<>();

    public Registrar_espectador_a_Funcion() {
        initComponents();
        List<Plataforma> plataformas = fabrica.getPlataformaControlador().getTodasLasPlataformas();
        fabrica.getUsuarioControlador().getTodosLosEspectadores().forEach(espectador -> cbEspectadores.addItem(espectador));

        plataformas.forEach(plataforma -> cbPlataforma.addItem(plataforma));
        lstArtistasInvitados.setModel(artistaModel);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        lblSeleccionarPlataforma = new javax.swing.JLabel();
        btnEspectadorAFuncion = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        cbPlataforma = new javax.swing.JComboBox<>();
        lblEspectaculo = new javax.swing.JLabel();
        cbEspectaculo = new javax.swing.JComboBox<>();
        cbFunciones = new javax.swing.JComboBox<>();
        lblSeleccionarFuncion = new javax.swing.JLabel();
        lblSeleccionarEspectador = new javax.swing.JLabel();
        cbEspectadores = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbArtista = new javax.swing.JLabel();
        lbPrecio = new javax.swing.JLabel();
        lbDuracion = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        taDescripcion = new javax.swing.JTextArea();
        panel1 = new java.awt.Panel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbNombreFuncion = new javax.swing.JLabel();
        lbFechaFuncion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstArtistasInvitados = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstFuncionesParaCanjear = new javax.swing.JList<>();
        lblSeleccionarEspectador1 = new javax.swing.JLabel();
        lblSeleccionarEspectador2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstFuncionesCanjeables = new javax.swing.JList<>();
        lblSeleccionarEspectador3 = new javax.swing.JLabel();
        btnCanjearFuncion = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        setClosable(true);
        setTitle("Registro a Función a Espectáculo");

        lblSeleccionarPlataforma.setText("Seleccionar Plataforma");

        btnEspectadorAFuncion.setText("Agregar Espectador a Función");
        btnEspectadorAFuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEspectadorAFuncionActionPerformed(evt);
            }
        });

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

        cbFunciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFuncionesActionPerformed(evt);
            }
        });

        lblSeleccionarFuncion.setText("Seleccionar Función");

        lblSeleccionarEspectador.setText("Seleccionar Espectador");

        cbEspectadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEspectadoresActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(220, 220));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Espectáculo");

        jLabel8.setText("Nombre");

        jLabel9.setText("Artista");

        jLabel10.setText("Precio");

        jLabel11.setText("Duracion");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Descripcion");

        taDescripcion.setEditable(false);
        taDescripcion.setColumns(20);
        taDescripcion.setRows(5);
        jScrollPane4.setViewportView(taDescripcion);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                .addGap(51, 51, 51))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbArtista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbDuracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lbArtista))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lbPrecio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lbDuracion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Función");
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel16.setText("Nombre");

        jLabel17.setText("Fecha");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Artistas Invitados");

        jScrollPane1.setViewportView(lstArtistasInvitados);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(lbFechaFuncion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(lbNombreFuncion, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                .addGap(51, 51, 51))))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNombreFuncion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbFechaFuncion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lstFuncionesParaCanjear.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstFuncionesParaCanjearValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstFuncionesParaCanjear);

        lblSeleccionarEspectador1.setText("Funciones canjeables");

        lblSeleccionarEspectador2.setText(">");

        lstFuncionesCanjeables.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstFuncionesCanjeablesValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lstFuncionesCanjeables);

        lblSeleccionarEspectador3.setText("Funciones para canjear");

        btnCanjearFuncion.setText("Canjear Función");
        btnCanjearFuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanjearFuncionActionPerformed(evt);
            }
        });

        jButton1.setText("Ver Espectador a Funcion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSeleccionarPlataforma)
                            .addComponent(lblEspectaculo)
                            .addComponent(lblSeleccionarFuncion)
                            .addComponent(lblSeleccionarEspectador))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbEspectaculo, 0, 326, Short.MAX_VALUE)
                            .addComponent(cbFunciones, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbPlataforma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbEspectadores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEspectadorAFuncion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(lblSeleccionarEspectador2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(lblSeleccionarEspectador1)))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(lblSeleccionarEspectador3)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(btnCanjearFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSeleccionarPlataforma)
                            .addComponent(cbPlataforma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEspectaculo)
                            .addComponent(cbEspectaculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbFunciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSeleccionarFuncion))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSeleccionarEspectador)
                            .addComponent(cbEspectadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(btnEspectadorAFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSeleccionarEspectador3)
                    .addComponent(lblSeleccionarEspectador1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblSeleccionarEspectador2)
                        .addGap(81, 81, 81)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCanjearFuncion)
                    .addComponent(btnSalir)
                    .addComponent(jButton1))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Alta de Espectador a Función");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEspectadorAFuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEspectadorAFuncionActionPerformed
        try {

            validarParametros();
            //Mandar al controlador
            fabrica.getFuncionControlador().altaEspectadorAFuncion(funcionSeleccionada, espectadorSeleccionado, new Date(), espectaculoSeleccionado.getCosto());

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
        JOptionPane.showMessageDialog(rootPane, "El Espectador se agregó correctamente a la Función");
    }//GEN-LAST:event_btnEspectadorAFuncionActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cbPlataformaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPlataformaActionPerformed
        plataformaSeleccionada = (Plataforma) cbPlataforma.getSelectedItem();
        limpiarPanelEspectaculo();
        limpiarPanelFuncion();
        List<Espectaculo> espectaculosParaPlataforma = fabrica.getEspectaculoControlador().getEspectaculosPorIdPlataforma(plataformaSeleccionada.getId());
        espectaculoSeleccionado = null;
        cbFunciones.removeAllItems();
        cbEspectaculo.removeAllItems();
        espectaculosParaPlataforma.forEach(espectaculo -> cbEspectaculo.addItem(espectaculo));
    }//GEN-LAST:event_cbPlataformaActionPerformed

    private void cbEspectaculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEspectaculoActionPerformed
        espectaculoSeleccionado = (Espectaculo) cbEspectaculo.getSelectedItem();
        cbFunciones.removeAllItems();
        if (espectaculoSeleccionado != null) {
            lbNombre.setText(espectaculoSeleccionado.getNombre());
            lbArtista.setText(String.format("%s %s", espectaculoSeleccionado.getArtista().getNombre(), espectaculoSeleccionado.getArtista().getApellido()));
            lbPrecio.setText(String.format("$ %s", espectaculoSeleccionado.getCosto()));
            lbDuracion.setText(String.format("%s minutos", espectaculoSeleccionado.getDuracion()));
            taDescripcion.setText(espectaculoSeleccionado.getDescripcion());
            espectaculoSeleccionado.getFunciones().stream()
                    .filter(funcion -> HelperFecha.validarFechaPosteriorALaActualSinThrow(funcion.getFechaInicio())).collect(Collectors.toList())
                    .forEach(funcion -> cbFunciones.addItem(funcion));
        }
    }//GEN-LAST:event_cbEspectaculoActionPerformed

    private void cbFuncionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFuncionesActionPerformed
        artistaModel.clear();
        funcionSeleccionada = (Funcion) cbFunciones.getSelectedItem();
        if (funcionSeleccionada != null) {
            lbNombreFuncion.setText(funcionSeleccionada.getNombre());
            if (funcionSeleccionada.getFechaInicio() != null) {
                lbFechaFuncion.setText(HelperFecha.fechaToString(funcionSeleccionada.getFechaInicio(), "dd/MM/yyyy hh:mm"));
            }
            if (funcionSeleccionada.getArtistasInvitados() != null && funcionSeleccionada.getArtistasInvitados().size() > 0) {
                artistaModel.clear();
                funcionSeleccionada.getArtistasInvitados().forEach(artista -> artistaModel.addElement(artista));
                lstArtistasInvitados.setModel(artistaModel);
                lstFuncionesCanjeables.setModel(funcionesCanjeablesModel);
            }
        }
    }//GEN-LAST:event_cbFuncionesActionPerformed

    private void cbEspectadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEspectadoresActionPerformed
        funcionesCanjeablesModel.clear();
        espectadorSeleccionado = (Espectador) cbEspectadores.getSelectedItem();
        funcionesCanjeables = new HashSet<>(fabrica.getFuncionControlador().getFuncionesPorIdEspectador(espectadorSeleccionado));
        if (funcionesCanjeables != null && funcionesCanjeables.size() > 0) {
            funcionesCanjeables.forEach(funcion -> funcionesCanjeablesModel.addElement(funcion));
        }
    }//GEN-LAST:event_cbEspectadoresActionPerformed

    private void lstFuncionesCanjeablesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstFuncionesCanjeablesValueChanged
        Funcion funcionSeleccionada = lstFuncionesCanjeables.getSelectedValue();
        if (funcionSeleccionada != null) {
            funcionesParaCanjear.add(funcionSeleccionada);
            funcionesParaCanjearModel.removeAllElements();
            funcionesParaCanjear.forEach(funcion -> funcionesParaCanjearModel.addElement(funcion));
            lstFuncionesParaCanjear.setModel(funcionesParaCanjearModel);
           
        }
    }//GEN-LAST:event_lstFuncionesCanjeablesValueChanged

    private void lstFuncionesParaCanjearValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstFuncionesParaCanjearValueChanged
        Funcion funcionSeleccionada = lstFuncionesParaCanjear.getSelectedValue();
        if (funcionSeleccionada != null)  {
            funcionesParaCanjear.remove(funcionSeleccionada);
            funcionesParaCanjearModel.removeAllElements();
            funcionesParaCanjear.forEach(funcion -> funcionesParaCanjearModel.addElement(funcion));
            lstFuncionesParaCanjear.setModel(funcionesParaCanjearModel);
        }
            
    }//GEN-LAST:event_lstFuncionesParaCanjearValueChanged

    private void btnCanjearFuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanjearFuncionActionPerformed
        try {
            fabrica.getFuncionControlador().canjearFunciones(espectadorSeleccionado, funcionSeleccionada, funcionesParaCanjear);
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
        JOptionPane.showMessageDialog(rootPane, "El canje ocurrió correctamente");
        
    }//GEN-LAST:event_btnCanjearFuncionActionPerformed

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
    private javax.swing.JButton btnCanjearFuncion;
    private javax.swing.JButton btnEspectadorAFuncion;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<Espectaculo> cbEspectaculo;
    private javax.swing.JComboBox<Espectador> cbEspectadores;
    private javax.swing.JComboBox<Funcion> cbFunciones;
    private javax.swing.JComboBox<Plataforma> cbPlataforma;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbArtista;
    private javax.swing.JLabel lbDuracion;
    private javax.swing.JLabel lbFechaFuncion;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbNombreFuncion;
    private javax.swing.JLabel lbPrecio;
    private javax.swing.JLabel lblEspectaculo;
    private javax.swing.JLabel lblSeleccionarEspectador;
    private javax.swing.JLabel lblSeleccionarEspectador1;
    private javax.swing.JLabel lblSeleccionarEspectador2;
    private javax.swing.JLabel lblSeleccionarEspectador3;
    private javax.swing.JLabel lblSeleccionarFuncion;
    private javax.swing.JLabel lblSeleccionarPlataforma;
    private javax.swing.JList<Artista> lstArtistasInvitados;
    private javax.swing.JList<Funcion> lstFuncionesCanjeables;
    private javax.swing.JList<Funcion> lstFuncionesParaCanjear;
    private java.awt.Panel panel1;
    private javax.swing.JTextArea taDescripcion;
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
            throw new IllegalArgumentException("No hay un Espectáculo seleccionado");
        }
        if (funcionSeleccionada == null) {
            throw new IllegalArgumentException("No hay una Función seleccionada");
        }
        if (espectadorSeleccionado == null) {
            throw new IllegalArgumentException("No hay Espectador seleccionado");
        }

    }

    private void limpiarPanelEspectaculo() {
        lbNombre.setText(null);
        lbArtista.setText(null);
        lbPrecio.setText(null);
        lbDuracion.setText(null);
        taDescripcion.setText(null);
    }

    private void limpiarPanelFuncion() {
        lbNombreFuncion.setText(null);
        lbFechaFuncion.setText(null);
        artistaModel.clear();
    }

}
