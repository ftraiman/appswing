package edu.innova.presentacion;

import edu.innova.exceptions.InnovaModelException;
import edu.innova.logica.Fabrica;
import edu.innova.logica.entidades.Funcion;
import edu.innova.persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Todos_Los_Espectadores extends javax.swing.JInternalFrame {

    ConexionDB cn = new ConexionDB();
    Connection con = cn.getConexion();
    Fabrica fabrica = new Fabrica();

    public Todos_Los_Espectadores() throws SQLException {
        initComponents();
        //Crear el modelo de la tabla y agregar sus columnas
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("Id de espectador");
        tabla.addColumn("Nombre");
        tabla.addColumn("Apellido");
        tabla.addColumn("Nickname");
        tabla.addColumn("E-mail");
        tabla.addColumn("Fecha de nacimiento");
        //Obtiene la cantidad de espectadores
        int n = fabrica.getUsuarioControlador().getTodosLosEspectadores().size();
        String fila[] = new String[6];
        for (int i = 0; i < n; i++) {//Rellenar la tabla con la informacion del espectador
            fila[0] = fabrica.getUsuarioControlador().getTodosLosEspectadores().get(i).getId().toString();
            fila[1] = fabrica.getUsuarioControlador().getTodosLosEspectadores().get(i).getNombre();
            fila[2] = fabrica.getUsuarioControlador().getTodosLosEspectadores().get(i).getApellido();
            fila[3] = fabrica.getUsuarioControlador().getTodosLosEspectadores().get(i).getNickname();
            fila[4] = fabrica.getUsuarioControlador().getTodosLosEspectadores().get(i).getEmail();

            SimpleDateFormat dateform = new SimpleDateFormat("dd/MM/Y");
            fila[5] = dateform.format(fabrica.getUsuarioControlador().getTodosLosEspectadores().get(i).getFechaNacimiento());
            tabla.addRow(fila);//Se agrega la fila al modelo de la tabla
        }
        //Setear el modelo en la tabla de espectadores
        this.jTable_Espectador.setModel(tabla);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Espectador = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableFuncion = new javax.swing.JTable();
        lbFuncion = new javax.swing.JLabel();
        lbEspectador = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Todos los Espectadores");

        jTable_Espectador.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_Espectador.setEnabled(false);
        jTable_Espectador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_EspectadorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Espectador);

        tableFuncion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id de funcion", "Nombre", "Fecha de registro", "Fecha de inicio", "Id de espectaculo"
            }
        ));
        tableFuncion.setEnabled(false);
        jScrollPane2.setViewportView(tableFuncion);

        lbFuncion.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        lbFuncion.setText("Funciones del espectador: ");

        lbEspectador.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        lbEspectador.setText("Espectadores:");

        jButton1.setText("Registrar Espectador");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modificar Espectador");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Registrar Funcion a Espectador");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbFuncion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbEspectador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbEspectador))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbFuncion)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable_EspectadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_EspectadorMouseClicked
        // TODO add your handling code here:
        try {
            //Obtener el indice de la tabla de espectadores
            int indiceEspectador = this.jTable_Espectador.rowAtPoint(evt.getPoint());
            //Crear el modelo de la tabla y agregar sus columnas
            DefaultTableModel tabla = new DefaultTableModel();
            tabla.addColumn("Id de funcion");
            tabla.addColumn("Nombre");
            tabla.addColumn("Fecha de registro");
            tabla.addColumn("Fecha de inicio");
            tabla.addColumn("Id de espectaculo");
            //Obtener la id del espectador con el indice de la tabla
            Long id = Long.parseLong(String.valueOf(this.jTable_Espectador.getValueAt(indiceEspectador, 0)));
            //Obtener de la fabrica la lista de funciones de ese espectador
            List<Funcion> funciones = fabrica.getFuncionServicioImpl().getTodosLasFuncionesPorIdUsuario(id);
            for (Funcion funcion : funciones) {
                //Rellenar la tabla con la informacion de la funcion
                String fila[] = new String[5];
                fila[0] = funcion.getId().toString();
                fila[1] = funcion.getNombre();
                SimpleDateFormat dateform = new SimpleDateFormat("dd/MM/Y");
                fila[2] = dateform.format(funcion.getFechaRegistro());
                fila[3] = dateform.format(funcion.getFechaInicio());
                fila[4] = funcion.getIdEspectaculo().toString();
                tabla.addRow(fila);//Se agrega la fila al modelo de la tabla
            }
            //Setear el modelo de la tabla
            this.tableFuncion.setModel(tabla);
        } catch (InnovaModelException x) {
            JOptionPane.showMessageDialog(rootPane, String.format("Este Artista No Posee Espectaculos!![%s]", x.getMessage()));
        } catch (SQLException ex) {
            Logger.getLogger(Todos_Los_Espectadores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable_EspectadorMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Registrar_Espectador re = new Registrar_Espectador();
        GUI_Proyecto.Panel.add(re);
        re.toFront();
        re.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Modificar_Espectador me = new Modificar_Espectador();
        GUI_Proyecto.Panel.add(me);
        me.toFront();
        me.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Registrar_espectador_a_Funcion ref = new Registrar_espectador_a_Funcion();
        GUI_Proyecto.Panel.add(ref);
        ref.toFront();
        ref.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_Espectador;
    private javax.swing.JLabel lbEspectador;
    private javax.swing.JLabel lbFuncion;
    private javax.swing.JTable tableFuncion;
    // End of variables declaration//GEN-END:variables
}
