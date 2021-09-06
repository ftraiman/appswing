package edu.innova.presentacion;

import edu.innova.logica.Fabrica;
import edu.innova.logica.entidades.Paquete;
import edu.innova.persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEspectaculos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaEspectaculosDelPaquete = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

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
                "Nombre", "Artista", "Precio"
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TablaEspectaculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaEspectaculosMouseClicked
        try {

            int indiceSeleccionado = TablaEspectaculos.rowAtPoint(evt.getPoint());
            String nombrePaquete = String.valueOf(TablaEspectaculos.getValueAt(indiceSeleccionado, 0));
            Paquete paqueteSeleccionado = fabrica.getPaqueteServicioImpl().getTodosLosPaquetes().stream().filter(paquete -> nombrePaquete.equalsIgnoreCase(paquete.getNombre())).findFirst().get();

            DefaultTableModel tablaEspectaculosModel = new DefaultTableModel();
            tablaEspectaculosModel.addColumn("Nombre");
            tablaEspectaculosModel.addColumn("Artista");
            tablaEspectaculosModel.addColumn("Precio");

            String fila[] = new String[3];
            paqueteSeleccionado.getEspectaculos().stream().forEach(espectaculo -> {
                fila[0] = espectaculo.getNombre();
                fila[1] = espectaculo.getArtista().toString();
                fila[2] = espectaculo.getCosto().toString();
                tablaEspectaculosModel.addRow(fila);
            });
            TablaEspectaculosDelPaquete.setModel(tablaEspectaculosModel);

        } catch (SQLException ex) {
            Logger.getLogger(Todos_Los_Paquetes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TablaEspectaculosMouseClicked

    private void TablaEspectaculosDelPaqueteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaEspectaculosDelPaqueteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaEspectaculosDelPaqueteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaEspectaculos;
    private javax.swing.JTable TablaEspectaculosDelPaquete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

}
