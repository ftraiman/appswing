package edu.innova.presentacion;

import edu.innova.exceptions.InnovaModelException;
import edu.innova.logica.Fabrica;
import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
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

         List<Artista> artistas = fabrica.getUsuarioControladorImpl().getTodosLosArtistas();
            for (Artista artista : artistas) {
                String fila[] = new String[9];//Limite de dos porque solo mostramos el nombre y el apellido
                
            fila[0] = artista.getId().toString();
            fila[1] = artista.getNombre();
            fila[2] = artista.getApellido();
            fila[3] = artista.getNickname();
            fila[4] = artista.getFechaNacimiento().toString();
            fila[5] = artista.getEmail();
            fila[6] = artista.getBiografia();
            fila[7] = artista.getDescripcion();
            fila[8] = artista.getLinkUsuario();
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
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
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
        DatosArtistas.setEnabled(false);
        DatosArtistas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DatosArtistasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DatosArtistas);

        DatosEspectaculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Costo", "URL", "Duracion", "Descripcion", "Fecha", "Plataforma(id)", "Espectadores MIN", "Espectadores MAX"
            }
        ));
        DatosEspectaculos.setToolTipText("");
        DatosEspectaculos.setEnabled(false);
        jScrollPane2.setViewportView(DatosEspectaculos);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        jLabel1.setText("Espectaculos Relacionado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 921, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
            tabla.addColumn("Plataforma(id)");
            tabla.addColumn("Espectadores Minimos");
            tabla.addColumn("Espectadores Maximos");

            Long id = Long.parseLong(String.valueOf(DatosArtistas.getValueAt(seleccionar, 0)));

            List<Espectaculo> espectaculos = fabrica.getEspectaculoServicioImpl().getEspectaculosPorIdArtista(id);
            for (Espectaculo espectaculo : espectaculos) {
                String fila[] = new String[9];//Limite de dos porque solo mostramos el nombre y el apellido

                fila[0] = espectaculo.getNombre();
                fila[1] = espectaculo.getCosto().toString();
                fila[2] = espectaculo.getUrl();
                fila[3] = espectaculo.getDuracion().toString();
                fila[4] = espectaculo.getDescripcion();
                fila[5] = espectaculo.getFechaRegistro().toString();
                fila[6] = espectaculo.getPlataforma().toString();
                fila[7] = espectaculo.getEspectadoresMinimos().toString();
                fila[8] = espectaculo.getEspectadoresMaximos().toString();

                tabla.addRow(fila);//Se agrega la fila al modelo de la tabla

            }

            this.DatosEspectaculos.setModel(tabla);

        } catch (InnovaModelException x) {
            JOptionPane.showMessageDialog(rootPane, String.format("Este Artista No Posee Espectaculos!![%s]", x.getMessage()));
        }
    }//GEN-LAST:event_DatosArtistasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DatosArtistas;
    private javax.swing.JTable DatosEspectaculos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
