package edu.innova.presentacion;

import edu.innova.exceptions.InnovaModelException;
import static edu.innova.logica.Constantes.ID_FUNCION;
import edu.innova.logica.Fabrica;
import edu.innova.logica.dtos.UsuarioDTO;
import edu.innova.logica.entidades.Espectador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Espectadores_Para_Sorteo extends javax.swing.JInternalFrame {

    Fabrica fabrica = new Fabrica();
    private static String idUsuario;

    public Espectadores_Para_Sorteo() {

        initComponents();
        cargarDatosEspectadores();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEspectadoresSorteo = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaGanadores = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_premio = new javax.swing.JLabel();
        lbl_cantidadPremio = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Espectadores para el sorteo");

        tablaEspectadoresSorteo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido"
            }
        ));
        jScrollPane1.setViewportView(tablaEspectadoresSorteo);

        tablaGanadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido"
            }
        ));
        jScrollPane2.setViewportView(tablaGanadores);

        jLabel1.setText("Espectadores que participaran en el sorteo");

        jLabel2.setText("Ganadores del sorteo");

        jLabel3.setText("Premios del sorteo");

        jButton1.setText("Sortear premios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Premio: ");

        jLabel5.setText("Cantidad de premios:");

        lbl_premio.setText("- - -");

        lbl_cantidadPremio.setText("- - -");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_premio))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_cantidadPremio)))
                        .addGap(119, 119, 119)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lbl_premio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lbl_cantidadPremio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            
            //Inserta los ganadores en la tabla ganadores en la BD
            int cantRow = this.tablaGanadores.getRowCount();
            for (int i = 0; i < cantRow; i++) {
                Long id = Long.parseLong(String.valueOf(tablaGanadores.getValueAt(i, 0)));
                fabrica.getUsuarioControlador().altaGanadores(id, ID_FUNCION, this.lbl_premio.getText());
            }

            //Carga los datos de quien gano
            int cant = Integer.parseInt(this.lbl_cantidadPremio.getText());
            cargarDatosGanadores(cant);

            //Carga true la tabla del sorteo
            fabrica.getFuncionControlador().entregaDePremios(ID_FUNCION);
        } catch (InnovaModelException x) {
            JOptionPane.showMessageDialog(rootPane, String.format("[%s]", x.getMessage()));
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lbl_cantidadPremio;
    public javax.swing.JLabel lbl_premio;
    private javax.swing.JTable tablaEspectadoresSorteo;
    private javax.swing.JTable tablaGanadores;
    // End of variables declaration//GEN-END:variables
    public void cargarDatosEspectadores() {
        //Crear el modelo de la tabla
        DefaultTableModel tabla = new DefaultTableModel();

        //Defino las columnas que quiero
        tabla.addColumn("Nombre");
        tabla.addColumn("Apellido");

        List<Espectador> espectadores = fabrica.getUsuarioControlador().getEspectadoresPorIdFuncion(ID_FUNCION);
        for (Espectador espectador : espectadores) {
            String fila[] = new String[2];//Limite de dos porque solo mostramos el nombre y el apellido
            fila[0] = espectador.getNombre();
            fila[1] = espectador.getApellido();
            tabla.addRow(fila); //Se agrega la fila al modelo de la tabla
        }
        this.tablaEspectadoresSorteo.setModel(tabla);
    }

    public void cargarDatosGanadores(int cant) {
        //Crear el modelo de la tabla
        DefaultTableModel tabla = new DefaultTableModel();

        //Defino las columnas que quiero
        tabla.addColumn("Id");
        tabla.addColumn("Nombre");
        tabla.addColumn("Apellido");

        List<UsuarioDTO> espectadores = fabrica.getUsuarioControlador().usuariosDelSorteo(ID_FUNCION, cant);
        for (UsuarioDTO espectador : espectadores) {
            String fila[] = new String[3];//Limite de dos porque solo mostramos el nombre y el apellido
            fila[0] = espectador.getId().toString();
            fila[1] = espectador.getNombre();
            fila[2] = espectador.getApellido();
            tabla.addRow(fila); //Se agrega la fila al modelo de la tabla
        }
        this.tablaGanadores.setModel(tabla);
    }

}
