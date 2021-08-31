package edu.innova.presentacion;

import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.logica.Fabrica;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Paquete;
import edu.innova.logica.entidades.Plataforma;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Registrar_Espectaculo_en_Paquete extends javax.swing.JInternalFrame {

    private Fabrica fabrica = new Fabrica();

    public Registrar_Espectaculo_en_Paquete() {
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
            List<Paquete> pack;
            try {
                pack = fabrica.getPaqueteServicioImpl().getTodosLosPaquetes();
                // Creo un DefaultListModel que almacena los objetos Plataforma
                DefaultListModel<Paquete> modelPaquete = new DefaultListModel<>();
                // Le cargo al JList el modelEspectadores
                listPaquete.setModel(modelPaquete);
                // Relleno el modelEspectadores con todos los espectadores obtenidos del EspectadorServicio
                pack.forEach(e -> modelPaquete.addElement(e));
            } catch (SQLException ex) {
                Logger.getLogger(Registrar_Espectaculo_en_Paquete.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (BaseDeDatosException ex) {
            JOptionPane.showMessageDialog(rootPane, String.format("Error SQL [%s]", ex.getMessage()));
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listPaquete = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listPlataforma = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableEspectaculos = new javax.swing.JTable();

        setClosable(true);
        setTitle("Agregar Espectaculo a Paquete");

        jScrollPane1.setViewportView(listPaquete);

        jLabel1.setText("Paquetes Registrados:");

        jLabel2.setText("Plataformas Registradas:");

        listPlataforma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listPlataformaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listPlataforma);

        tableEspectaculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Costo", "URL", "Duracion", "Descripcion", "Fecha", "Plataforma(id)", "Espectadores Minimos", "Espectadores Maximos"
            }
        ));
        tableEspectaculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEspectaculosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableEspectaculos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 190, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Este metodo se utiliza para cargar la informacion en la tala
    //(Basicamente es lo mismo que antes solo que en un metodo a parte para poder utilizarlo en varias partes)
    private void cargarTabla() {
        int indiceTablaPlataforma = listPlataforma.getSelectedIndex();
        int indiceTablaPaquetes = listPaquete.getSelectedIndex();

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

        Long idPaquete = Long.parseLong(String.valueOf(listPaquete.getModel().getElementAt(indiceTablaPaquetes).getId()));
        Long idPlataforma = Long.parseLong(String.valueOf(listPlataforma.getModel().getElementAt(indiceTablaPlataforma).getId()));
        
        List<Espectaculo> espectaculos = fabrica.getPaqueteServicioImpl().getEspectaculosNOPaquete(idPaquete, idPlataforma);
        System.out.println(espectaculos);
        for (Espectaculo espectaculo : espectaculos) {
            String fila[] = new String[10];//Limite de dos porque solo mostramos el nombre y el apellido

            fila[0] = espectaculo.getId().toString();
            fila[1] = espectaculo.getNombre();
            fila[2] = espectaculo.getCosto().toString();
            fila[3] = espectaculo.getUrl();
            fila[4] = espectaculo.getDuracion().toString();
            fila[5] = espectaculo.getDescripcion();
            fila[6] = espectaculo.getFechaRegistro().toString();
            fila[7] = espectaculo.getPlataforma().toString();
            fila[8] = espectaculo.getEspectadoresMinimos().toString();
            fila[9] = espectaculo.getEspectadoresMaximos().toString();

            tabla.addRow(fila);//Se agrega la fila al modelo de la tabla
        }
        this.tableEspectaculos.setModel(tabla);
    }


    private void listPlataformaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listPlataformaMouseClicked
        cargarTabla();//Llamar al metodo
    }//GEN-LAST:event_listPlataformaMouseClicked

    private void tableEspectaculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEspectaculosMouseClicked

        int seleccionar = tableEspectaculos.rowAtPoint(evt.getPoint());
        int indiceTablaPaquetes = listPaquete.getSelectedIndex();
        Long id = Long.parseLong(String.valueOf(tableEspectaculos.getValueAt(seleccionar, 0)));
        Long idPaquete = Long.parseLong(String.valueOf(listPaquete.getModel().getElementAt(indiceTablaPaquetes).getId()));

        fabrica.getPaqueteControlador().altaPaqueteEspectaculo(idPaquete, id);

        cargarTabla();//Llamar al metodo

    }//GEN-LAST:event_tableEspectaculosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<Paquete> listPaquete;
    private javax.swing.JList<Plataforma> listPlataforma;
    private javax.swing.JTable tableEspectaculos;
    // End of variables declaration//GEN-END:variables
}
