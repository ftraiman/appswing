package edu.innova.presentacion;

import edu.innova.exceptions.InnovaModelException;
import edu.innova.logica.Fabrica;
import edu.innova.logica.entidades.Categoria;
import edu.innova.logica.entidades.Paquete;
import edu.innova.persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Todos_Los_Paquetes extends javax.swing.JInternalFrame {

    ConexionDB cn = new ConexionDB();
    Connection con = cn.getConexion();
    Fabrica fabrica = new Fabrica();
//    private DefaultTableModel tablaEspectaculosModel = new DefaultTableModel();

    public Todos_Los_Paquetes() throws SQLException {
        initComponents();

        //Crear el modelo de la tabla
        DefaultTableModel tablaPaquetes = new DefaultTableModel();

        //Defino las columnas que quiero
        tablaPaquetes.addColumn("Nombre");
        tablaPaquetes.addColumn("Descripcion");
        tablaPaquetes.addColumn("Fecha Inicio");
        tablaPaquetes.addColumn("Fecha Fin");

        //Crear las filas para la tabla
        int n = fabrica.getPaqueteServicioImpl().getTodosLosPaquetes().size();
        String fila[] = new String[4];//Limite de dos porque solo mostramos el nombre y el apellido
        for (int i = 0; i < n; i++) {//Iterar hasta tener todas las filas
            //Obtengo los datos
            String nombre = fabrica.getPaqueteServicioImpl().getTodosLosPaquetes().get(i).getNombre();
            String desc = fabrica.getPaqueteServicioImpl().getTodosLosPaquetes().get(i).getDescripcion();

            fila[0] = nombre;
            fila[1] = desc;
            SimpleDateFormat dateform = new SimpleDateFormat("dd/MM/Y");
            fila[2] = dateform.format(fabrica.getPaqueteServicioImpl().getTodosLosPaquetes().get(i).getFechaInicio());
            fila[3] = dateform.format(fabrica.getPaqueteServicioImpl().getTodosLosPaquetes().get(i).getFechaFin());

            tablaPaquetes.addRow(fila);//Se agrega la fila al modelo de la tabla
        }
        this.TablaEspectaculos.setModel(tablaPaquetes);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEspectaculos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaEspectaculosDelPaquete = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaCategoria = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        setClosable(true);
        setTitle("Consulta de Paquete de Espectáculos");

        TablaEspectaculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaEspectaculos.setEnabled(false);
        TablaEspectaculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaEspectaculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaEspectaculos);

        TablaEspectaculosDelPaquete.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Artista", "Precio", "Categoria", "Estado"
            }
        ));
        TablaEspectaculosDelPaquete.setEnabled(false);
        TablaEspectaculosDelPaquete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaEspectaculosDelPaqueteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaEspectaculosDelPaquete);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Espectáculos del Paquete:");

        jLabel2.setText("Paquete de Espetaculos:");

        jButton1.setText("Registrar Paquete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Categorias del Paquete de Espectaculo:");

        TablaCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id ", "Nombre Categoria"
            }
        ));
        TablaCategoria.setEnabled(false);
        jScrollPane4.setViewportView(TablaCategoria);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TablaEspectaculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaEspectaculosMouseClicked

        int indiceSeleccionado = TablaEspectaculos.rowAtPoint(evt.getPoint());
        String nombrePaquete = String.valueOf(TablaEspectaculos.getValueAt(indiceSeleccionado, 0));
        Paquete paqueteSeleccionado = fabrica.getPaqueteServicioImpl().getTodosLosPaquetes().stream().filter(paquete -> nombrePaquete.equalsIgnoreCase(paquete.getNombre())).findFirst().get();

        DefaultTableModel tablaEspectaculosModel = new DefaultTableModel();
        tablaEspectaculosModel.addColumn("Id");
        tablaEspectaculosModel.addColumn("Nombre");
        tablaEspectaculosModel.addColumn("Artista");
        tablaEspectaculosModel.addColumn("Precio");
        tablaEspectaculosModel.addColumn("Categoria");
        tablaEspectaculosModel.addColumn("Estado");

        String fila[] = new String[6];
        paqueteSeleccionado.getEspectaculos().stream().forEach(espectaculo -> {
            fila[0] = espectaculo.getId().toString();
            fila[1] = espectaculo.getNombre();
            fila[2] = espectaculo.getArtista().toString();
            fila[3] = espectaculo.getCosto().toString();
            fila[4] = espectaculo.getIdCategoria().toString();
            fila[5] = espectaculo.getEstado();

            tablaEspectaculosModel.addRow(fila);
        });
        TablaEspectaculosDelPaquete.setModel(tablaEspectaculosModel);

    }//GEN-LAST:event_TablaEspectaculosMouseClicked

    private void TablaEspectaculosDelPaqueteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaEspectaculosDelPaqueteMouseClicked
        // TODO add your handling code here:
        try {
            //Obtener el indice de la tabla de espectadores
            int indiceEspectador = this.TablaEspectaculosDelPaquete.rowAtPoint(evt.getPoint());
            //Crear el modelo de la tabla y agregar sus columnas
            DefaultTableModel tabla = new DefaultTableModel();
            tabla.addColumn("Id de Categoria");
            tabla.addColumn("Nombre");
            //Obtener la id del espectador con el indice de la tabla
            Long id = Long.parseLong(String.valueOf(this.TablaEspectaculosDelPaquete.getValueAt(indiceEspectador, 0)));
            //Obtener de la fabrica la lista de funciones de ese espectador
            List<Categoria> categorias = fabrica.getEspectaculoControlador().getCategoriaPorIdEspectaculo(id);
            for (Categoria categoria : categorias) {
                //Rellenar la tabla con la informacion de la funcion
                String fila[] = new String[2];
                fila[0] = categoria.getId().toString();
                fila[1] = categoria.getNombre();
                tabla.addRow(fila);//Se agrega la fila al modelo de la tabla
            }
            //Setear el modelo de la tabla
            this.TablaCategoria.setModel(tabla);
        } catch (InnovaModelException x) {
            JOptionPane.showMessageDialog(rootPane, String.format("Este Espectaculo No posee Ningun Paquete Asociado!![%s]", x.getMessage()));
        } catch (SQLException ex) {
            Logger.getLogger(Todos_Los_Espectadores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TablaEspectaculosDelPaqueteMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Registrar_Paquete rp = new Registrar_Paquete();
        GUI_Proyecto.Panel.add(rp);
        rp.toFront();
        rp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaCategoria;
    private javax.swing.JTable TablaEspectaculos;
    private javax.swing.JTable TablaEspectaculosDelPaquete;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
