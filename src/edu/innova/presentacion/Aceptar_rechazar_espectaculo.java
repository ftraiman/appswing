package edu.innova.presentacion;

import edu.innova.logica.Fabrica;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class Aceptar_rechazar_espectaculo extends javax.swing.JInternalFrame {

    ConexionDB cn = new ConexionDB();
    Connection con = cn.getConexion();
    Fabrica fabrica = new Fabrica();
    
   
    public Aceptar_rechazar_espectaculo() throws SQLException {
        initComponents();
        
        cargarDatos();
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Espectaculos_Ingresados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Aceptar/Rechazar Espectaculo");

        Espectaculos_Ingresados.setModel(new javax.swing.table.DefaultTableModel(
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
        Espectaculos_Ingresados.setEnabled(false);
        Espectaculos_Ingresados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Espectaculos_IngresadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Espectaculos_Ingresados);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel1.setText("Hacer click en el Espectaculo a Aceptar/Rechazar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1106, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarDatos(){
        try {
            //Crear el modelo de la tabla
            DefaultTableModel tabla = new DefaultTableModel();
            //Defino las columnas que quiero
            tabla.addColumn("Id");
            tabla.addColumn("Nombre");
            tabla.addColumn("Costo");
            tabla.addColumn("URL");
            tabla.addColumn("Duracion");
            tabla.addColumn("Descripcion");
            tabla.addColumn("Fecha");
            tabla.addColumn("Artista");
            tabla.addColumn("Plataforma");
            tabla.addColumn("Espectadores Minimos");
            tabla.addColumn("Espectadores Maximos");
            tabla.addColumn("ID Categoria");
            tabla.addColumn("Estado");
            
            List<Espectaculo> espectaculos = fabrica.getEspectaculoControlador().getTodosLosEspectaculosIngresados();
            for (Espectaculo espectaculo : espectaculos) {
                String fila[] = new String[13];//Limite de dos porque solo mostramos el nombre y el apellido
                
                fila[0] = espectaculo.getId().toString();
                fila[1] = espectaculo.getNombre();
                fila[2] = espectaculo.getCosto().toString();
                fila[3] = espectaculo.getUrl();
                fila[4] = espectaculo.getDuracion().toString();
                fila[5] = espectaculo.getDescripcion();
                
                SimpleDateFormat dateform = new SimpleDateFormat("dd/MM/Y");
                fila[6] = dateform.format(espectaculo.getFechaRegistro());
                
                fila[7] = espectaculo.getArtista().toString();
                fila[8] = espectaculo.getPlataforma().toString();
                fila[9] = espectaculo.getEspectadoresMinimos().toString();
                fila[10] = espectaculo.getEspectadoresMaximos().toString();
                fila[11] = espectaculo.getIdCategoria().toString();
                fila[12] = espectaculo.getEstado();
                tabla.addRow(fila); //Se agrega la fila al modelo de la tabla
            }
            this.Espectaculos_Ingresados.setModel(tabla);
        } catch (SQLException ex) {
            Logger.getLogger(Aceptar_rechazar_espectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    private void Espectaculos_IngresadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Espectaculos_IngresadosMouseClicked
        try {
            int seleccionar = Espectaculos_Ingresados.rowAtPoint(evt.getPoint());
            Long id = Long.parseLong(String.valueOf(Espectaculos_Ingresados.getValueAt(seleccionar, 0)));
            
            fabrica.getEspectaculoControlador().aceptarEspectaculo(id);
            
            cargarDatos();
        } catch (SQLException ex) {
            Logger.getLogger(Aceptar_rechazar_espectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }//GEN-LAST:event_Espectaculos_IngresadosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Espectaculos_Ingresados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
