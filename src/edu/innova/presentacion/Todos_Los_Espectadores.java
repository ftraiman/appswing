package edu.innova.presentacion;

import edu.innova.logica.Fabrica;
import edu.innova.persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.SQLException;
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
        tabla.addColumn("Nombre"); tabla.addColumn("Apellido");
        
        //Crear las filas para la tabla
        int n = fabrica.getUsuarioControlador().getTodosLosEspectadores().size();
        String fila[] = new String[2];//Limite de dos porque solo mostramos el nombre y el apellido
        for(int i=0; i<n; i++){//Iterar hasta tener todas las filas
            //Obtengo los datos
            String nombre = fabrica.getUsuarioControlador().getTodosLosEspectadores().get(i).getNombre();
            String apellido = fabrica.getUsuarioControlador().getTodosLosEspectadores().get(i).getApellido();
            fila[0] = nombre;
            fila[1] = apellido;
            
            tabla.addRow(fila);//Se agrega la fila al modelo de la tabla
        }
        this.jTable_Espectador.setModel(tabla);
   
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Espectador = new javax.swing.JTable();

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
        jScrollPane1.setViewportView(jTable_Espectador);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Espectador;
    // End of variables declaration//GEN-END:variables
}
