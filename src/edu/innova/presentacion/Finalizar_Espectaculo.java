package edu.innova.presentacion;

import edu.innova.logica.Fabrica;
import edu.innova.logica.entidades.Espectaculo;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class Finalizar_Espectaculo extends javax.swing.JInternalFrame {

    Fabrica fabrica = new Fabrica();

    public Finalizar_Espectaculo() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtEspectaculo = new javax.swing.JTextField();
        btnVerificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLabel1.setText("Ingrese el nombre del espectaculo:");

        btnVerificar.setText("Verificar");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Descripción", "Duración", "Costo", "Link del espectaculo"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtEspectaculo, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnVerificar)))
                        .addGap(0, 467, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEspectaculo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        // TODO add your handling code here:
        String nombre = this.txtEspectaculo.getText();
        cargarDatos(nombre);
    }//GEN-LAST:event_btnVerificarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        //Colocamos aceptar/rechazar espectaculo
        int seleccionar = jTable1.rowAtPoint(evt.getPoint());
        Long id = Long.parseLong(String.valueOf(jTable1.getValueAt(seleccionar, 0)));

        int i = JOptionPane.showConfirmDialog(null, "¿Desea finalizar este espectaculo?", "Finalizar Espectaculo", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) { //Si confirma el alta
            fabrica.getEspectaculoControlador().finalizarEspectaculo(id);
            JOptionPane.showMessageDialog(null, "Espectaculo finalizado correctamente");
        } else { //Si no agrega muestra
            JOptionPane.showMessageDialog(null, "El espectaculo no a sido finalizado");
        }
        
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtEspectaculo;
    // End of variables declaration//GEN-END:variables

    public void cargarDatos(String nombre) {
        //Crear el modelo de la tabla
        DefaultTableModel tabla = new DefaultTableModel();

        //Defino las columnas que quiero
        tabla.addColumn("Id del espectaculo");
        tabla.addColumn("Nombre");
        tabla.addColumn("Descripción");
        tabla.addColumn("Duración");
        tabla.addColumn("Costo");
        tabla.addColumn("Link del espectaculo");

        List<Espectaculo> espectaculos = fabrica.getEspectaculoControlador().getTodosLosEspectaculosAceptadosPorNombre(nombre);
        for (Espectaculo espectaculo : espectaculos) {
            String fila[] = new String[6];//Limite de dos porque solo mostramos el nombre y el apellido
            fila[0] = espectaculo.getId().toString();
            fila[1] = espectaculo.getNombre();
            fila[2] = espectaculo.getDescripcion();
            fila[3] = espectaculo.getDuracion().toString();
            fila[4] = espectaculo.getCosto().toString();
            fila[5] = espectaculo.getUrl();

            tabla.addRow(fila); //Se agrega la fila al modelo de la tabla
        }
        this.jTable1.setModel(tabla);

    }

}
