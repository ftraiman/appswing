package edu.innova.presentacion;

import static edu.innova.logica.Constantes.ID_FUNCION;
import edu.innova.logica.Fabrica;
import edu.innova.logica.dtos.UsuarioDTO;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Espectador;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Listar_Ganadores extends javax.swing.JInternalFrame {

    Fabrica fabrica = new Fabrica();

    public Listar_Ganadores() {
        initComponents();

        //System.out.println(ID_FUNCION);
        cargarGanadores(ID_FUNCION);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setTitle("Lista de ganadores");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    public void cargarGanadores(Long idFuncion) {
        //Crear el modelo de la tabla
        DefaultTableModel tabla = new DefaultTableModel();

        //Defino las columnas que quiero
        tabla.addColumn("Nombre");
        tabla.addColumn("Apellido");
        tabla.addColumn("Fecha del sorteo");

        List<UsuarioDTO> espectadores = fabrica.getUsuarioControlador().getGanadores(idFuncion);
        for (UsuarioDTO espectador : espectadores) {
            String fila[] = new String[3];//Limite de dos porque solo mostramos el nombre y el apellido
            fila[0] = espectador.getNombre();
            fila[1] = espectador.getApellido();
            SimpleDateFormat dateform = new SimpleDateFormat("dd/MM/Y");
            fila[2] = dateform.format(espectador.getFechaSorteo());

            tabla.addRow(fila); //Se agrega la fila al modelo de la tabla
        }
        this.jTable1.setModel(tabla);

    }

}
