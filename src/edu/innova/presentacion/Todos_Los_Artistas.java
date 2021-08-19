package edu.innova.presentacion;

import edu.innova.logica.Fabrica;
import edu.innova.persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Todos_Los_Artistas extends javax.swing.JInternalFrame {

    
    ConexionDB cn = new ConexionDB();
    Connection con = cn.getConexion();
    Fabrica fabrica = new Fabrica();
    
    public Todos_Los_Artistas() throws SQLException {
        initComponents();
        
         //Crear el modelo de la tabla
        DefaultTableModel tabla = new DefaultTableModel();
        //Defino las columnas que quiero
        tabla.addColumn("ID"); 
        tabla.addColumn("Nombre"); 
        tabla.addColumn("Apellido");
        tabla.addColumn("Nickname");
        tabla.addColumn("fechaNacimiento");
        tabla.addColumn("E-mail");
        tabla.addColumn("Biografia");
        tabla.addColumn("Descripcion");
        tabla.addColumn("Link");
        
        //Crear las filas para la tabla
        int n = fabrica.getUsuarioControlador().getTodosLosArtistas().size();
        String fila[] = new String[9];//Limite de dos porque solo mostramos el nombre y el apellido
        for(int i=0; i<n; i++){//Iterar hasta tener todas las filas
            //Obtengo los datos
             String id = fabrica.getUsuarioControlador().getTodosLosArtistas().get(i).getId().toString();
            String nombre = fabrica.getUsuarioControlador().getTodosLosArtistas().get(i).getNombre();
            String apellido = fabrica.getUsuarioControlador().getTodosLosArtistas().get(i).getApellido();
            String nickname = fabrica.getUsuarioControlador().getTodosLosArtistas().get(i).getNickname();
            String fechaNacimiento = fabrica.getUsuarioControlador().getTodosLosArtistas().get(i).getFechaNacimiento().toString();
            String email = fabrica.getUsuarioControlador().getTodosLosArtistas().get(i).getEmail();
            String bio = fabrica.getUsuarioControlador().getTodosLosArtistas().get(i).getBiografia();
            String desc = fabrica.getUsuarioControlador().getTodosLosArtistas().get(i).getDescripcion();
            String link = fabrica.getUsuarioControlador().getTodosLosArtistas().get(i).getLinkUsuario();
            fila[0] = id;
            fila[1] = nombre;
            fila[2] = apellido;
            fila[3] = nickname;
            fila[4] = fechaNacimiento;
            fila[5] = email;
            fila[6] = bio;
            fila[7] = desc;
            fila[8] = link;
            tabla.addRow(fila);//Se agrega la fila al modelo de la tabla
        }
        this.DatosArtistas.setModel(tabla);
         
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        DatosArtistas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        DatosEspectaculos = new javax.swing.JTable();

        setClosable(true);
        setTitle("Todos Los Artistas");

        DatosArtistas.setModel(new javax.swing.table.DefaultTableModel(
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
        DatosArtistas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DatosArtistasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DatosArtistas);

        DatosEspectaculos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(DatosEspectaculos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DatosArtistasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DatosArtistasMouseClicked
         try {
            int seleccionar = DatosArtistas.rowAtPoint(evt.getPoint());
            
            
            DefaultTableModel tabla = new DefaultTableModel();
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
            
            int n = fabrica.getEspectaculoServicioImpl().getTodosLosEspectaculos().size();
            String fila[] = new String[9];//Limite de dos porque solo mostramos el nombre y el apellido
            for(int i=0; i<n; i++){//Iterar hasta tener todas las filas
                //Obtengo los datos
                Long id = Long.parseLong(String.valueOf(DatosArtistas.getValueAt(seleccionar, 0)));
                String nombre = fabrica.getEspectaculoServicioImpl().getEspectaculoPorIdA(id).getNombre();
                String costo = fabrica.getEspectaculoServicioImpl().getEspectaculoPorIdA(id).getCosto().toString();
                String URL = fabrica.getEspectaculoServicioImpl().getEspectaculoPorIdA(id).getUrl();
                String Duracion = fabrica.getEspectaculoServicioImpl().getEspectaculoPorIdA(id).getDuracion().toString();
                String Desc = fabrica.getEspectaculoServicioImpl().getEspectaculoPorIdA(id).getDescripcion();
                String Fecha = fabrica.getEspectaculoServicioImpl().getEspectaculoPorIdA(id).getFechaRegistro().toString();
                String Plataforma = fabrica.getEspectaculoServicioImpl().getEspectaculoPorIdA(id).getPlataforma().toString();
                String EspMin = fabrica.getEspectaculoServicioImpl().getEspectaculoPorIdA(id).getEspectadoresMinimos().toString();
                String EspMax = fabrica.getEspectaculoServicioImpl().getEspectaculoPorIdA(id).getEspectadoresMaximos().toString();
                
                fila[0] = nombre;
                fila[1] = costo;
                fila[2] = URL;
                fila[3] = Duracion;
                fila[4] = Desc;
                fila[5] = Fecha;
                fila[6] = Plataforma;
                fila[7] = EspMin;
                fila[8] = EspMax;
                
                tabla.addRow(fila);//Se agrega la fila al modelo de la tabla
            }
            this.DatosEspectaculos.setModel(tabla);
        } catch (SQLException ex) {
            //Logger.getLogger(Todos_Los_Artistas.class.getName()).log(Level.SEVERE, null, ex); 
            JOptionPane.showMessageDialog(rootPane, String.format("Este Artista No Posee Espectaculos!![%s]", ex.getMessage()));
        }    
    }//GEN-LAST:event_DatosArtistasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DatosArtistas;
    private javax.swing.JTable DatosEspectaculos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
