package edu.innova.presentacion;

import edu.innova.exceptions.InnovaModelException;
import edu.innova.logica.Fabrica;
import edu.innova.logica.entidades.Categoria;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Funcion;
import edu.innova.logica.entidades.Paquete;
import edu.innova.logica.entidades.Plataforma;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Todos_Los_Espectaculos extends javax.swing.JInternalFrame {

    Fabrica fabrica = new Fabrica();

    public Todos_Los_Espectaculos() throws SQLException {
        initComponents();

        //Carga el combobox plataforma
        List<Plataforma> plataformas = fabrica.getPlataformaControlador().getTodasLasPlataformas();
        plataformas.forEach(plataforma -> cbPlataforma.addItem(plataforma));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Espectaculo = new javax.swing.JTable();
        cbPlataforma = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TFuncion = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TPaquete = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaCategoria = new javax.swing.JTable();

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
        Tabla_Espectaculo.setEnabled(false);
        Tabla_Espectaculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_EspectaculoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Espectaculo);

        cbPlataforma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPlataformaActionPerformed(evt);
            }
        });

        jLabel1.setText("Selecciona una Plataforma:");

        jLabel2.setText("Espectaculos relacionados con la Plataforma:");

        jLabel3.setText("Funciones Asociadas:");

        jLabel4.setText("Paquetes Asociados:");

        TFuncion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id de funcion", "Nombre", "Fecha de Registro", "Fecha de Inicio", "id de espectaculo"
            }
        ));
        TFuncion.setEnabled(false);
        jScrollPane2.setViewportView(TFuncion);

        TPaquete.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Paquete", "Nombre", "Descripcion", "Fecha de Inicio", "Fecha Fin"
            }
        ));
        TPaquete.setEnabled(false);
        jScrollPane3.setViewportView(TPaquete);

        jButton1.setText("Registrar Espectaculos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Categorias Asociadas:");

        TablaCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre Categoria"
            }
        ));
        TablaCategoria.setEnabled(false);
        jScrollPane4.setViewportView(TablaCategoria);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 925, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbPlataforma, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(80, 80, 80))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbPlataforma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbPlataformaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPlataformaActionPerformed

        //Obtengo el item seleccionado del combobox
        Plataforma plataformaSeleccionada = (Plataforma) cbPlataforma.getSelectedItem();
        //Crear el modelo de la tabla Espectaculo
        DefaultTableModel tabla = new DefaultTableModel();
        //Defino las columnas que quiero
        tabla.addColumn("Id");
        tabla.addColumn("Nombre");
        tabla.addColumn("Costo");
        tabla.addColumn("URL");
        tabla.addColumn("Duracion");
        tabla.addColumn("Descripcion");
        tabla.addColumn("Fecha");
        tabla.addColumn("Artista");
        tabla.addColumn("Plataforma");
        tabla.addColumn("Espectadores Minimos");
        tabla.addColumn("Espectadores Maximos");
        tabla.addColumn("Categoria");
        tabla.addColumn("Estado");
        tabla.addColumn("Descripción del premio");
        tabla.addColumn("Cantidad de premios");

        //Hacemos una lista de Espectaculos por Id plataforma
        List<Espectaculo> espectaculos = fabrica.getEspectaculoControlador().getEspectaculosPorIdPlataforma(plataformaSeleccionada.getId());
        for (Espectaculo espectaculo : espectaculos) {
            String fila[] = new String[15];//Limite de dos porque solo mostramos el nombre y el apellido

            fila[0] = espectaculo.getId().toString();
            fila[1] = espectaculo.getNombre();
            fila[2] = espectaculo.getCosto().toString();
            fila[3] = espectaculo.getUrl();
            fila[4] = espectaculo.getDuracion().toString();
            fila[5] = espectaculo.getDescripcion();

            SimpleDateFormat dateform = new SimpleDateFormat("dd/MM/Y");
            fila[6] = dateform.format(espectaculo.getFechaRegistro());

            fila[7] = espectaculo.getArtista().toString();
            fila[8] = espectaculo.getPlataforma().toString();
            fila[9] = espectaculo.getEspectadoresMinimos().toString();
            fila[10] = espectaculo.getEspectadoresMaximos().toString();
            fila[11] = espectaculo.getIdCategoria().toString();
            fila[12] = espectaculo.getEstado();
            
            tabla.addRow(fila); //Se agrega la fila al modelo de la tabla
        }
        this.Tabla_Espectaculo.setModel(tabla);
    }//GEN-LAST:event_cbPlataformaActionPerformed

    private void Tabla_EspectaculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_EspectaculoMouseClicked

        // TODO add your handling code here:
        try {
            //Obtener el indice de la tabla de espectadores
            int indiceEspectador = this.Tabla_Espectaculo.rowAtPoint(evt.getPoint());
            //Crear el modelo de la tabla y agregar sus columnas
            DefaultTableModel tabla = new DefaultTableModel();
            tabla.addColumn("Id de funcion");
            tabla.addColumn("Nombre");
            tabla.addColumn("Fecha de registro");
            tabla.addColumn("Fecha de inicio");
            tabla.addColumn("Id de espectaculo");
            //Obtener la id del espectador con el indice de la tabla
            Long id = Long.parseLong(String.valueOf(this.Tabla_Espectaculo.getValueAt(indiceEspectador, 0)));
            //Obtener de la fabrica la lista de funciones de ese espectador
            List<Funcion> funciones = fabrica.getFuncionServicioImpl().getTodosLasFuncionesPorIdEspectaculo(id);
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
            this.TFuncion.setModel(tabla);
        } catch (InnovaModelException x) {
            JOptionPane.showMessageDialog(rootPane, String.format("Este Espectaculo No posee Funcion Asociada!![%s]", x.getMessage()));
        }

        // TODO add your handling code here:
        try {
            //Obtener el indice de la tabla de espectadores
            int indiceEspectador = this.Tabla_Espectaculo.rowAtPoint(evt.getPoint());
            //Crear el modelo de la tabla y agregar sus columnas
            DefaultTableModel tabla = new DefaultTableModel();
            tabla.addColumn("Id de Paquete");
            tabla.addColumn("Nombre");
            tabla.addColumn("Descripcion");
            tabla.addColumn("Fecha de inicio");
            tabla.addColumn("Fecha de fin");
            //Obtener la id del espectador con el indice de la tabla
            Long id = Long.parseLong(String.valueOf(this.Tabla_Espectaculo.getValueAt(indiceEspectador, 0)));
            //Obtener de la fabrica la lista de funciones de ese espectador
            List<Paquete> paquetes = fabrica.getPaqueteServicioImpl().getPaquetePorIdEspectaculo(id);
            for (Paquete paquete : paquetes) {
                //Rellenar la tabla con la informacion de la funcion
                String fila[] = new String[5];
                fila[0] = paquete.getId().toString();
                fila[1] = paquete.getNombre();
                fila[2] = paquete.getDescripcion();
                SimpleDateFormat dateform = new SimpleDateFormat("dd/MM/Y");
                fila[3] = dateform.format(paquete.getFechaInicio());
                fila[4] = dateform.format(paquete.getFechaFin());
                tabla.addRow(fila);//Se agrega la fila al modelo de la tabla
            }
            //Setear el modelo de la tabla
            this.TPaquete.setModel(tabla);
        } catch (InnovaModelException x) {
            JOptionPane.showMessageDialog(rootPane, String.format("Este Espectaculo No posee Ningun Paquete Asociado!![%s]", x.getMessage()));
        }

        // TODO add your handling code here:
        try {
            //Obtener el indice de la tabla de espectadores
            int indiceEspectador = this.Tabla_Espectaculo.rowAtPoint(evt.getPoint());
            //Crear el modelo de la tabla y agregar sus columnas
            DefaultTableModel tabla = new DefaultTableModel();
            tabla.addColumn("Id de Categoria");
            tabla.addColumn("Nombre");
            //Obtener la id del espectador con el indice de la tabla
            Long id = Long.parseLong(String.valueOf(this.Tabla_Espectaculo.getValueAt(indiceEspectador, 0)));
            //Obtener de la fabrica la lista de funciones de ese espectador
            List<Categoria> categorias = fabrica.getEspectaculoControlador().getCategoriaPorIdEspectaculo(id);
            for (Categoria categoria : categorias) {
                //Rellenar la tabla con la informacion de la funcion
                String fila[] = new String[2];
                fila[0] = categoria.getId().toString();
                fila[1] = categoria.getNombre();
                tabla.addRow(fila);//Se agrega la fila al modelo de la tabla
            }
            //Setear el modelo de la tabla
            this.TablaCategoria.setModel(tabla);
        } catch (InnovaModelException x) {
            JOptionPane.showMessageDialog(rootPane, String.format("Este Espectaculo No posee Ningun Paquete Asociado!![%s]", x.getMessage()));
        } catch (SQLException ex) {
            Logger.getLogger(Todos_Los_Espectadores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Tabla_EspectaculoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Registrar_Espectaculos re = new Registrar_Espectaculos();
            GUI_Proyecto.Panel.add(re);
            re.toFront();
            re.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Todos_Los_Espectaculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TFuncion;
    private javax.swing.JTable TPaquete;
    private javax.swing.JTable TablaCategoria;
    private javax.swing.JTable Tabla_Espectaculo;
    private javax.swing.JComboBox<Plataforma> cbPlataforma;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables

}
