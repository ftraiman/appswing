package edu.innova.presentacion;

import edu.innova.logica.Fabrica;
import edu.innova.persistencia.ConexionDB;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;


public class Todos_Los_Paquetes extends javax.swing.JInternalFrame {

    ConexionDB cn = new ConexionDB();
    Connection con = cn.getConexion();
    Fabrica fabrica = new Fabrica();
    
    public Todos_Los_Paquetes() {
        initComponents();
        
     //Crear el modelo de la tabla
        DefaultTableModel tabla = new DefaultTableModel();
        //Defino las columnas que quiero
        tabla.addColumn("Nombre");  
        tabla.addColumn("Descripcion"); 
        tabla.addColumn("Fecha Inicio");
        tabla.addColumn("Fecha Fin");

        /*
        //Crear las filas para la tabla
        int n = fabrica.getPaqueteServicioImpl().size();
        String fila[] = new String[10];//Limite de dos porque solo mostramos el nombre y el apellido
        for(int i=0; i<n; i++){//Iterar hasta tener todas las filas
            //Obtengo los datos
            String nombre = fabrica.getEspectaculoServicioImpl().getTodosLosEspectaculos().get(i).getNombre();
            String costo = fabrica.getEspectaculoServicioImpl().getTodosLosEspectaculos().get(i).getCosto().toString();
            String URL = fabrica.getEspectaculoServicioImpl().getTodosLosEspectaculos().get(i).getUrl();
            String Duracion = fabrica.getEspectaculoServicioImpl().getTodosLosEspectaculos().get(i).getDuracion().toString();
            

            fila[0] = nombre;
            fila[1] = costo;
            fila[2] = URL;
            fila[3] = Duracion;
          
            
            tabla.addRow(fila);//Se agrega la fila al modelo de la tabla
        }
        this.Tabla_Espectaculo.setModel(tabla);    
     */   
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEspectaculos = new javax.swing.JTable();

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
        jScrollPane1.setViewportView(TablaEspectaculos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaEspectaculos;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
