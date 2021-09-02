package edu.innova.presentacion;

import edu.innova.exceptions.InnovaModelException;
import edu.innova.logica.Fabrica;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Funcion;
import edu.innova.persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.SQLException;
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
        //Crear el modelo de la tabla
        DefaultTableModel tabla = new DefaultTableModel();
        //Defino las columnas que quiero
        tabla.addColumn("Id del Espectador"); 
        tabla.addColumn("Nombre");
        tabla.addColumn("Apellido"); 
        tabla.addColumn("Nickname");
        tabla.addColumn("Email"); 
        tabla.addColumn("Fecha de nacimiento");	
        
        //Crear las filas para la tabla
        int n = fabrica.getUsuarioControlador().getTodosLosEspectadores().size();
        String fila[] = new String[6];//Limite de dos porque solo mostramos el nombre y el apellido
        for(int i=0; i<n; i++){//Iterar hasta tener todas las filas
            //Obtengo los datos
            fila[0] = fabrica.getUsuarioControlador().getTodosLosEspectadores().get(i).getId().toString();
            fila[1] = fabrica.getUsuarioControlador().getTodosLosEspectadores().get(i).getNombre();
            fila[2] = fabrica.getUsuarioControlador().getTodosLosEspectadores().get(i).getApellido();
            fila[3] = fabrica.getUsuarioControlador().getTodosLosEspectadores().get(i).getNickname();
            fila[4] = fabrica.getUsuarioControlador().getTodosLosEspectadores().get(i).getEmail();
            fila[5] = fabrica.getUsuarioControlador().getTodosLosEspectadores().get(i).getFechaNacimiento().toString();
            
            tabla.addRow(fila);//Se agrega la fila al modelo de la tabla
        }
        this.jTable_Espectador.setModel(tabla);
   
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Espectador = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_funciones_registradas = new javax.swing.JTable();
        lb_funciones_registradas = new javax.swing.JLabel();
        lb_espectadores = new javax.swing.JLabel();

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

        table_funciones_registradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id de Funcion", "Nombre", "Fecha de Registro", "Fecha de Inicio", "Id de Especulo"
            }
        ));
        jScrollPane2.setViewportView(table_funciones_registradas);

        lb_funciones_registradas.setText("Funciones registradas:");

        lb_espectadores.setText("Espectadores:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_funciones_registradas)
                            .addComponent(lb_espectadores))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lb_espectadores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(lb_funciones_registradas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Evento MauseClick 
    private void jTable_EspectadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_EspectadorMouseClicked
        try {
            //Obtiene el indice de la tabla
            int indiceEspectador = jTable_Espectador.rowAtPoint(evt.getPoint());

            //Crear el modelo de la tabla
            DefaultTableModel tabla = new DefaultTableModel();
            
            //Cargar las columnas
            tabla.addColumn("Id de Funcion");
            tabla.addColumn("Nombre");
            tabla.addColumn("Fecha de Registro");
            tabla.addColumn("Fecha de Inicio");
            tabla.addColumn("Id de Especulo");            
            
            Long id = Long.parseLong(String.valueOf(jTable_Espectador.getValueAt(indiceEspectador, 0)));

            List<Funcion> funciones = fabrica.getFuncionServicioImpl().getFuncionPorIdUsuario(id);
            for (Funcion funcion : funciones) {
                String fila[] = new String[5];//Limite de dos porque solo mostramos el nombre y el apellido

                fila[0] = funcion.getId().toString();
                fila[1] = funcion.getNombre();
                fila[2] = funcion.getFechaRegistro().toString();
                fila[3] = funcion.getFechaInicio().toString();
                fila[4] = funcion.getIdEspectaculo().toString();                

                tabla.addRow(fila);//Se agrega la fila al modelo de la tabla

            }

            this.table_funciones_registradas.setModel(tabla);

        } catch (InnovaModelException x) {
            JOptionPane.showMessageDialog(rootPane, String.format("Este Artista No Posee Espectaculos!![%s]", x.getMessage()));
        } catch (SQLException ex) {
            Logger.getLogger(Todos_Los_Espectadores.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }//GEN-LAST:event_jTable_EspectadorMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_Espectador;
    private javax.swing.JLabel lb_espectadores;
    private javax.swing.JLabel lb_funciones_registradas;
    private javax.swing.JTable table_funciones_registradas;
    // End of variables declaration//GEN-END:variables
}
