package edu.innova.presentacion;

import edu.innova.exceptions.InnovaModelException;
import static edu.innova.logica.Constantes.ID_FUNCION;
import edu.innova.logica.Fabrica;
import edu.innova.logica.dtos.EspectaculoDTO;
import edu.innova.logica.dtos.FuncionDTO;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Funcion;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author henry
 */
public final class Sorteo_Espectadores extends javax.swing.JInternalFrame {

    Fabrica fabrica = new Fabrica();
    public static String cantidadPremios;
    public static String premio;

    public Sorteo_Espectadores() {
        initComponents();
        cargarDatosEspectaculos();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEspectaculos = new javax.swing.JTable();
        lblEspectaculos = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaFuncionesAsiciadas = new javax.swing.JTable();
        lblFuncinesAsiciadas = new javax.swing.JLabel();
        lbl_Realizado = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_IdFuncion = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_FechaInicio = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_FechaRegistro = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_Sorteo = new javax.swing.JLabel();
        btnRealizarSorteo = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_CantidadPremios = new javax.swing.JLabel();
        lbl_Premio = new javax.swing.JLabel();
        btnMostrarGanadores = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Realizar sorteo para los espectadores");

        tablaEspectaculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tablaEspectaculos.setEnabled(false);
        tablaEspectaculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEspectaculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEspectaculos);

        lblEspectaculos.setText("Seleccionar espectaculo");

        tablaFuncionesAsiciadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre de función"
            }
        ));
        tablaFuncionesAsiciadas.setEnabled(false);
        tablaFuncionesAsiciadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaFuncionesAsiciadasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaFuncionesAsiciadas);

        lblFuncinesAsiciadas.setText("Funciones asiciadas");

        lbl_Realizado.setText("- - -");

        jLabel4.setText("Se realizo la función?:");

        lbl_IdFuncion.setText("- - -");

        jLabel2.setText("Id de la función:");

        lbl_FechaInicio.setText("- - -");

        jLabel3.setText("Fecha de inicio:");

        jLabel1.setText("Fecha de registro:");

        lbl_FechaRegistro.setText("- - -");

        jLabel5.setText("Se realizo sorteo?:");

        lbl_Sorteo.setText("- - -");

        btnRealizarSorteo.setText("Realizar sorteo");
        btnRealizarSorteo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarSorteoActionPerformed(evt);
            }
        });

        jLabel6.setText("Premio:");

        jLabel7.setText("Cantidad de premios");

        lbl_CantidadPremios.setText("- - -");

        lbl_Premio.setText("- - -");

        btnMostrarGanadores.setText("Mostrar ganadores");
        btnMostrarGanadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarGanadoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEspectaculos)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMostrarGanadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                    .addComponent(lblFuncinesAsiciadas)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_IdFuncion)
                            .addComponent(lbl_Sorteo)
                            .addComponent(lbl_Realizado)
                            .addComponent(lbl_FechaRegistro)
                            .addComponent(lbl_FechaInicio)
                            .addComponent(lbl_Premio)
                            .addComponent(lbl_CantidadPremios)))
                    .addComponent(btnRealizarSorteo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEspectaculos)
                    .addComponent(lblFuncinesAsiciadas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lbl_FechaRegistro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lbl_FechaInicio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lbl_IdFuncion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lbl_Realizado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lbl_Sorteo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lbl_Premio))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbl_CantidadPremios))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRealizarSorteo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMostrarGanadores)
                .addGap(98, 98, 98))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaEspectaculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEspectaculosMouseClicked
        try {
            int seleccionar = tablaEspectaculos.rowAtPoint(evt.getPoint());

            Long id = Long.parseLong(String.valueOf(tablaEspectaculos.getValueAt(seleccionar, 0)));
            EspectaculoDTO esp = fabrica.getEspectaculoControlador().getEspectaculoPorIdDTO(id);

            this.lbl_Premio.setText(esp.getDescripcionPremios());
            this.lbl_CantidadPremios.setText(esp.getCantidadPremios().toString());

            cargarDatosFunciones(id);
            cantidadPremios = esp.getCantidadPremios().toString();
            premio = esp.getDescripcionPremios();

        } catch (InnovaModelException x) {
            JOptionPane.showMessageDialog(rootPane, String.format("Este Espectaculo NO Posee Funciones!![%s]", x.getMessage()));
        }
    }//GEN-LAST:event_tablaEspectaculosMouseClicked

    private void tablaFuncionesAsiciadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaFuncionesAsiciadasMouseClicked
        int seleccionar = this.tablaFuncionesAsiciadas.rowAtPoint(evt.getPoint());
        Long id = Long.parseLong(String.valueOf(tablaFuncionesAsiciadas.getValueAt(seleccionar, 0)));

        FuncionDTO funcion = fabrica.getFuncionControlador().getFuncionDTOPorId(id);

        ID_FUNCION = funcion.getId();

        this.lbl_IdFuncion.setText(funcion.getId().toString());
        SimpleDateFormat dateform = new SimpleDateFormat("dd/MM/Y");
        this.lbl_FechaInicio.setText(dateform.format(funcion.getFechaInicio()));
        this.lbl_FechaRegistro.setText(dateform.format(funcion.getFechaRegistro()));
        //Si la fecha actual es mayor a la del inicio de la funcion
        if (funcion.getFechaInicio().compareTo(new Date()) < 0) {
            this.lbl_Realizado.setText("Si");
        } else {
            this.lbl_Realizado.setText("No");
        }
        //Si se realizo un sorteo o no
        if (funcion.getSorteo()) {
            this.lbl_Sorteo.setText("Si");
        } else {
            this.lbl_Sorteo.setText("No");
        }
    }//GEN-LAST:event_tablaFuncionesAsiciadasMouseClicked

    private void btnRealizarSorteoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarSorteoActionPerformed
        // TODO add your handling code here:
        if (this.lbl_Realizado.getText().equals("Si") && this.lbl_Sorteo.getText().equals("No")) {
            Espectadores_Para_Sorteo se = new Espectadores_Para_Sorteo();

            se.lbl_cantidadPremio.setText(cantidadPremios);
            se.lbl_premio.setText(premio);

            GUI_Proyecto.Panel.add(se);
            se.show();
            //System.out.println(ID_FUNCION);
        } else {
            JOptionPane.showMessageDialog(null, "No se puede realizar un sorteo en esta función");
        }


    }//GEN-LAST:event_btnRealizarSorteoActionPerformed

    private void btnMostrarGanadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarGanadoresActionPerformed
        // TODO add your handling code here:
        if (this.lbl_Sorteo.getText().equals("Si")) {
            Listar_Ganadores la = new Listar_Ganadores();

            GUI_Proyecto.Panel.add(la);
            la.show();
        } else {
            JOptionPane.showMessageDialog(null, "No hay ganadores");
        }
        
    }//GEN-LAST:event_btnMostrarGanadoresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMostrarGanadores;
    private javax.swing.JButton btnRealizarSorteo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEspectaculos;
    private javax.swing.JLabel lblFuncinesAsiciadas;
    private javax.swing.JLabel lbl_CantidadPremios;
    private javax.swing.JLabel lbl_FechaInicio;
    private javax.swing.JLabel lbl_FechaRegistro;
    public javax.swing.JLabel lbl_IdFuncion;
    private javax.swing.JLabel lbl_Premio;
    private javax.swing.JLabel lbl_Realizado;
    private javax.swing.JLabel lbl_Sorteo;
    private javax.swing.JTable tablaEspectaculos;
    private javax.swing.JTable tablaFuncionesAsiciadas;
    // End of variables declaration//GEN-END:variables

    public void cargarDatosEspectaculos() {
        //Crear el modelo de la tabla
        DefaultTableModel tabla = new DefaultTableModel();

        //Defino las columnas que quiero
        tabla.addColumn("Id espectaculo");
        tabla.addColumn("Nombre del espectaculo");

        List<Espectaculo> espectaculos = fabrica.getEspectaculoControlador().getTodosLosEspectaculosAceptados();
        for (Espectaculo espectaculo : espectaculos) {
            String fila[] = new String[2];//Limite de dos porque solo mostramos el nombre y el apellido
            fila[0] = espectaculo.getId().toString();
            fila[1] = espectaculo.getNombre();
            tabla.addRow(fila); //Se agrega la fila al modelo de la tabla
        }
        this.tablaEspectaculos.setModel(tabla);
    }

    public void cargarDatosFunciones(Long idEspectaculo) {
        //Crear el modelo de la tabla
        DefaultTableModel tabla = new DefaultTableModel();

        //Defino las columnas que quiero
        tabla.addColumn("id de función");
        tabla.addColumn("Nombre de función");

        List<Funcion> funciones = fabrica.getFuncionControlador().getTodosLasFuncionesPorIdEspectaculo(idEspectaculo);
        for (Funcion funcion : funciones) {
            String fila[] = new String[2];//Limite de dos porque solo mostramos el nombre y el apellido
            fila[0] = funcion.getId().toString();
            fila[1] = funcion.getNombre();

            tabla.addRow(fila); //Se agrega la fila al modelo de la tabla
        }
        this.tablaFuncionesAsiciadas.setModel(tabla);
    }

}
