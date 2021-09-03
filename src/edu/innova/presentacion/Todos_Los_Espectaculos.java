package edu.innova.presentacion;

import edu.innova.logica.Fabrica;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Plataforma;
import edu.innova.persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Todos_Los_Espectaculos extends javax.swing.JInternalFrame {

    Fabrica fabrica = new Fabrica();

    public Todos_Los_Espectaculos() throws SQLException {
        initComponents();

        //Carga el combobox plataforma
        List<Plataforma> plataformas = fabrica.getPlataformaControlador().getTodasLasPlataformas();
        plataformas.forEach(plataforma -> cbPlataforma.addItem(plataforma));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Espectaculo = new javax.swing.JTable();
        cbPlataforma = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Todos Los Espectaculos");

        Tabla_Espectaculo.setModel(new javax.swing.table.DefaultTableModel(
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
        Tabla_Espectaculo.setEnabled(false);
        jScrollPane1.setViewportView(Tabla_Espectaculo);

        cbPlataforma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPlataformaActionPerformed(evt);
            }
        });

        jLabel1.setText("Selecciona una Plataforma");

        jLabel2.setText("Selecciona una Plataforma");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbPlataforma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbPlataforma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbPlataformaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPlataformaActionPerformed
        
        //Obtengo el item seleccionado del combobox
        Plataforma plataformaSeleccionada = (Plataforma) cbPlataforma.getSelectedItem();
        //Crear el modelo de la tabla Espectaculo
        DefaultTableModel tabla = new DefaultTableModel();
        //Defino las columnas que quiero
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
        
        //Hacemos una lista de Espectaculos por Id plataforma
        List<Espectaculo> espectaculos = fabrica.getEspectaculoControlador().getEspectaculosPorIdPlataforma(plataformaSeleccionada.getId());
        for (Espectaculo espectaculo : espectaculos) {
            String fila[] = new String[10];//Limite de dos porque solo mostramos el nombre y el apellido
            
            fila[0] = espectaculo.getNombre();
            fila[1] = espectaculo.getCosto().toString();
            fila[2] = espectaculo.getUrl();
            fila[3] = espectaculo.getDuracion().toString();
            fila[4] = espectaculo.getDescripcion();
            
            SimpleDateFormat dateform = new SimpleDateFormat("dd/MM/Y");
            fila[5] = dateform.format(espectaculo.getFechaRegistro());
            
            fila[6] = espectaculo.getArtista().toString();
            fila[7] = espectaculo.getPlataforma().toString();
            fila[8] = espectaculo.getEspectadoresMinimos().toString();
            fila[9] = espectaculo.getEspectadoresMaximos().toString();
            tabla.addRow(fila); //Se agrega la fila al modelo de la tabla
        }
        this.Tabla_Espectaculo.setModel(tabla);
    }//GEN-LAST:event_cbPlataformaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_Espectaculo;
    private javax.swing.JComboBox<Plataforma> cbPlataforma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
