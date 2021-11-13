package edu.innova.presentacion;

import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.exceptions.InnovaModelException;
import edu.innova.logica.Fabrica;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Funcion;
import edu.innova.logica.entidades.Plataforma;
import edu.innova.persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Todas_Las_Funciones_Espectaculos extends javax.swing.JInternalFrame {

    ConexionDB cn = new ConexionDB();
    Connection con = cn.getConexion();
    Fabrica fabrica = new Fabrica();

    public Todas_Las_Funciones_Espectaculos() throws SQLException {
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        datosFuncion = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        listPlataforma = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        DatosEspectaculos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Consultar Funciones de Espectaculos");

        datosFuncion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Espectaculo(id)", "Nombre", "Fecha Inicio", "Fecha Registro"
            }
        ));
        datosFuncion.setEnabled(false);
        jScrollPane1.setViewportView(datosFuncion);

        listPlataforma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listPlataformaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listPlataforma);

        jLabel1.setText("PLATAFORMA de los ESPECTACULOS:");

        DatosEspectaculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Costo", "URL", "Duracion", "Descripcion", "Fecha", "Plataforma(id)", "Espectadores Minimos", "Espectadores Maximos"
            }
        ));
        DatosEspectaculos.setEnabled(false);
        DatosEspectaculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DatosEspectaculosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(DatosEspectaculos);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel2.setText("Lista de Espectaculos Relacionados:");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel3.setText("Funciones Relacioandas a Los Espectaculos:");

        jButton1.setText("Registrar Plataforma");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Registrar Funcion");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listPlataformaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listPlataformaMouseClicked

        int seleccionar = listPlataforma.getSelectedIndex();

        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("ID");
        tabla.addColumn("Nombre");
        tabla.addColumn("Costo");
        tabla.addColumn("URL");
        tabla.addColumn("Duracion");
        tabla.addColumn("Descripcion");
        tabla.addColumn("Fecha");
        tabla.addColumn("Plataforma(id)");
        tabla.addColumn("Espectadores Minimos");
        tabla.addColumn("Espectadores Maximos");

        Long id = Long.parseLong(String.valueOf(listPlataforma.getModel().getElementAt(seleccionar).getId()));

        List<Espectaculo> espectaculos = fabrica.getEspectaculoServicioImpl().getTodosLosEspectaculosPorPlataforma(id);
        for (Espectaculo espectaculo : espectaculos) {
            String fila[] = new String[10];//Limite de dos porque solo mostramos el nombre y el apellido

            fila[0] = espectaculo.getId().toString();
            fila[1] = espectaculo.getNombre();
            fila[2] = espectaculo.getCosto().toString();
            fila[3] = espectaculo.getUrl();
            fila[4] = espectaculo.getDuracion().toString();
            fila[5] = espectaculo.getDescripcion();
            SimpleDateFormat dateform = new SimpleDateFormat("dd/MM/Y");
            fila[6] = dateform.format(espectaculo.getFechaRegistro());
            fila[7] = espectaculo.getPlataforma().toString();
            fila[8] = espectaculo.getEspectadoresMinimos().toString();
            fila[9] = espectaculo.getEspectadoresMaximos().toString();

            tabla.addRow(fila);//Se agrega la fila al modelo de la tabla
        }
        this.DatosEspectaculos.setModel(tabla);

    }//GEN-LAST:event_listPlataformaMouseClicked

    private void DatosEspectaculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DatosEspectaculosMouseClicked
        try {
            int seleccionar = DatosEspectaculos.rowAtPoint(evt.getPoint());

            DefaultTableModel tabla = new DefaultTableModel();
            tabla.addColumn("Espectaculo(id)");
            tabla.addColumn("Nombre");
            tabla.addColumn("Fecha Inicio");
            tabla.addColumn("Fecha Registro");

            Long id = Long.parseLong(String.valueOf(DatosEspectaculos.getValueAt(seleccionar, 0)));

            List<Funcion> funciones = fabrica.getFuncionServicioImpl().getTodosLasFuncionesPorIdEspectaculo(id);
            for (Funcion funcion : funciones) {
                String fila[] = new String[4];//Limite de dos porque solo mostramos el nombre y el apellido

                fila[0] = funcion.getIdEspectaculo().toString();
                fila[1] = funcion.getNombre();
                SimpleDateFormat dateform = new SimpleDateFormat("dd/MM/Y");
                fila[2] = dateform.format(funcion.getFechaInicio());
                fila[3] = dateform.format(funcion.getFechaRegistro());

                tabla.addRow(fila);//Se agrega la fila al modelo de la tabla
            }

            this.datosFuncion.setModel(tabla);

        } catch (InnovaModelException x) {
            JOptionPane.showMessageDialog(rootPane, String.format("Este Espectaculo NO Posee Funciones!![%s]", x.getMessage()));
        }
    }//GEN-LAST:event_DatosEspectaculosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Registrar_Plataforma rp = new Registrar_Plataforma();
            GUI_Proyecto.Panel.add(rp);
            rp.toFront();
            rp.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Registrar_Funcion rf = new Registrar_Funcion();
            GUI_Proyecto.Panel.add(rf);
            rf.toFront();
            rf.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DatosEspectaculos;
    private javax.swing.JTable datosFuncion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<Plataforma> listPlataforma;
    // End of variables declaration//GEN-END:variables
}
