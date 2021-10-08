package edu.innova.presentacion;

import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.exceptions.InnovaModelException;
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

            //Carga las plataformas en el jlist
            cargarPlataforma();

            //Carga los paquetes en el jlist
            cargarPaquete();

        } catch (BaseDeDatosException ex) {
            JOptionPane.showMessageDialog(rootPane, String.format("Error SQL [%s]", ex.getMessage()));
        } catch (InnovaModelException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (SQLException ex) {
            Logger.getLogger(Registrar_Espectaculo_en_Paquete.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listPaquete = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listPlataforma = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableEspectaculos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Agregar Espectaculo a Paquete");

        jScrollPane1.setViewportView(listPaquete);

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

        jLabel1.setText("Paquete:");

        jLabel2.setText("Plataforma:");

        jLabel3.setText("Selecionar Un Espectaculo para Insertar:");

        jButton1.setText("Registrar Paquete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jButton1)
                            .addComponent(jLabel3))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(523, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Este metodo se utiliza para cargar la informacion en la tabla
    //(Basicamente es lo mismo que antes solo que en un metodo a parte para poder utilizarlo en varias partes)
    private void cargarTabla() {

        //Carga los datos de la tabla Espectaculo (las columnas)
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

        //Verifica que se haya seleccionado el paquete
        if (listPaquete.getSelectedValue() == null) {
            throw new InnovaModelException("Debe primero seleccionar un paquete!");
        }

        //Obtiene la IdPaquete e IdPlataforma de la lista que seleccione
        Long idPaquete = listPaquete.getSelectedValue().getId();
        Long idPlataforma = listPlataforma.getSelectedValue().getId();

        //Obtiene los espectaculos que no estan en ese paquete seleccionado (Desde el Controlador)
        List<Espectaculo> espectaculos = fabrica.getPaqueteControlador().getEspectaculoNOPaquete(idPlataforma, idPaquete);
        //System.out.println(espectaculos);

        //Rellena la tabla con la lista de espectaculo
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
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    private void listPlataformaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listPlataformaMouseClicked
        try {
            cargarTabla();
        } catch (BaseDeDatosException ex) {
            JOptionPane.showMessageDialog(rootPane, String.format("Error: ", ex.getMessage()));
        } catch (InnovaModelException e) {
            JOptionPane.showMessageDialog(rootPane, String.format("%s", e.getMessage()));
            this.listPlataforma.clearSelection();
        }
    }//GEN-LAST:event_listPlataformaMouseClicked

    private void tableEspectaculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEspectaculosMouseClicked

        int seleccionar = tableEspectaculos.rowAtPoint(evt.getPoint());
        int indiceTablaPaquetes = listPaquete.getSelectedIndex();
        Long id = Long.parseLong(String.valueOf(tableEspectaculos.getValueAt(seleccionar, 0)));
        Long idPaquete = Long.parseLong(String.valueOf(listPaquete.getModel().getElementAt(indiceTablaPaquetes).getId()));

        //========== CONFIRMAR EL REGISTRO DEL PAQUETE-ESPECTACULO ===========//
        int i = JOptionPane.showConfirmDialog(null, "Desea Registrar este Espectaculo al Paquete??", "Confirmar Espectaculo al Paquete", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) { //Si confirma el alta
            fabrica.getPaqueteControlador().altaPaqueteEspectaculo(idPaquete, id);
            JOptionPane.showMessageDialog(null, "El Espectaculo fue ingresado correctamente al Paquete");
        } else { //Si no agrega muestra
            JOptionPane.showMessageDialog(null, "No se Agrego el Espectaculo al Paquete");
        }

        cargarTabla();//Llamar al metodo
        this.listPlataforma.clearSelection();
        this.listPaquete.clearSelection();
        //========== CONFIRMAR EL REGISTRO DEL PAQUETE-ESPECTACULO ===========//

    }//GEN-LAST:event_tableEspectaculosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Registrar_Paquete rp = new Registrar_Paquete();
        GUI_Proyecto.Panel.add(rp);
        rp.toFront();
        rp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<Paquete> listPaquete;
    private javax.swing.JList<Plataforma> listPlataforma;
    private javax.swing.JTable tableEspectaculos;
    // End of variables declaration//GEN-END:variables

    private void cargarPaquete() throws SQLException {
        // Obtengo de PlataformaServicio las plataformas
        List<Paquete> pack = fabrica.getPaqueteControlador().getTodosLosPaquetes();

        // Creo un DefaultListModel que almacena los objetos Plataforma
        DefaultListModel<Paquete> modelPaquete = new DefaultListModel<>();

        // Le cargo al JList el modelEspectadores
        listPaquete.setModel(modelPaquete);

        // Relleno el modelEspectadores con todos los espectadores obtenidos del EspectadorServicio
        pack.forEach(e -> modelPaquete.addElement(e));
    }

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

}
