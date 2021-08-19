package edu.innova.presentacion;

import edu.innova.logica.Fabrica;
import edu.innova.persistencia.ConexionDB;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


public class Todos_Los_Espectaculos extends javax.swing.JInternalFrame {

    ConexionDB cn = new ConexionDB();
    Connection con = cn.getConexion();
    Fabrica fabrica = new Fabrica();

    public Todos_Los_Espectaculos() throws SQLException {
        initComponents();
      
        //Crear el modelo de la tabla
        DefaultTableModel tabla = new DefaultTableModel();
        //Defino las columnas que quiero
        tabla.addColumn("Nombre");  
        tabla.addColumn("Costo"); 
        tabla.addColumn("URL");
        tabla.addColumn("Duracion");
        tabla.addColumn("Descripcion");
        tabla.addColumn("Fecha");
        tabla.addColumn("IdArtista");
        tabla.addColumn("idPlataforma");
        tabla.addColumn("Espectadores Minimos");
        tabla.addColumn("Espectadores Maximos");
        
        //Crear las filas para la tabla
        int n = fabrica.getEspectaculoServicioImpl().getTodosLosEspectaculos().size();
        String fila[] = new String[10];//Limite de dos porque solo mostramos el nombre y el apellido
        for(int i=0; i<n; i++){//Iterar hasta tener todas las filas
            //Obtengo los datos
            String nombre = fabrica.getEspectaculoServicioImpl().getTodosLosEspectaculos().get(i).getNombre();
            String costo = fabrica.getEspectaculoServicioImpl().getTodosLosEspectaculos().get(i).getCosto().toString();
            String URL = fabrica.getEspectaculoServicioImpl().getTodosLosEspectaculos().get(i).getUrl();
            String Duracion = fabrica.getEspectaculoServicioImpl().getTodosLosEspectaculos().get(i).getDuracion().toString();
            String Desc = fabrica.getEspectaculoServicioImpl().getTodosLosEspectaculos().get(i).getDescripcion();
            String Fecha = fabrica.getEspectaculoServicioImpl().getTodosLosEspectaculos().get(i).getFechaRegistro().toString();
            String Artista = fabrica.getEspectaculoServicioImpl().getTodosLosEspectaculos().get(i).getArtista().toString();
            String Plataforma = fabrica.getEspectaculoServicioImpl().getTodosLosEspectaculos().get(i).getPlataforma().toString();
            String EspMin = fabrica.getEspectaculoServicioImpl().getTodosLosEspectaculos().get(i).getEspectadoresMinimos().toString();
            String EspMax = fabrica.getEspectaculoServicioImpl().getTodosLosEspectaculos().get(i).getEspectadoresMaximos().toString();

            fila[0] = nombre;
            fila[1] = costo;
            fila[2] = URL;
            fila[3] = Duracion;
            fila[4] = Desc;
            fila[5] = Fecha;
            fila[6] = Artista;
            fila[7] = Plataforma;
            fila[8] = EspMin;
            fila[9] = EspMax;
            
            tabla.addRow(fila);//Se agrega la fila al modelo de la tabla
        }
        this.Tabla_Espectaculo.setModel(tabla);
        }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Espectaculo = new javax.swing.JTable();

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
        jScrollPane1.setViewportView(Tabla_Espectaculo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_Espectaculo;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
