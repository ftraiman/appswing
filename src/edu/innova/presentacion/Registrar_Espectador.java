package edu.innova.presentacion;

import edu.innova.exceptions.InnovaModelException;
import edu.innova.helpers.HelperFecha;
import edu.innova.logica.Fabrica;
import edu.innova.logica.entidades.Espectador;
import java.util.Date;
import javax.swing.JOptionPane;

public class Registrar_Espectador extends javax.swing.JInternalFrame {

    public Registrar_Espectador() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Nombretxt = new javax.swing.JTextField();
        Apellidotxt = new javax.swing.JTextField();
        Nicknametxt = new javax.swing.JTextField();
        Correotxt = new javax.swing.JTextField();
        SelecionarImagen = new javax.swing.JButton();
        Aceptar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Dia = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        Mes = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        Año = new javax.swing.JSpinner();

        setClosable(true);
        setTitle("Registrar Espectador");

        jLabel1.setText("Nombre:");

        jLabel2.setText("Apellido:");

        jLabel3.setText("NickName:");

        jLabel4.setText("Correo Electronico:");

        jLabel5.setText("Fecha de nacimiento:");

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("Ingrese los Datos de Espectador:");

        Nombretxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombretxtActionPerformed(evt);
            }
        });

        SelecionarImagen.setText("Selecionar Imagen");

        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        jLabel6.setText("Día:");

        Dia.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        jLabel7.setText("Mes:");

        Mes.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        jLabel8.setText("Año:");

        Año.setModel(new javax.swing.SpinnerNumberModel(1900, 1900, 2021, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jLabel6)
                                        .addGap(4, 4, 4)
                                        .addComponent(Dia, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Mes, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Año, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Correotxt)
                                    .addComponent(Nicknametxt)
                                    .addComponent(Apellidotxt)
                                    .addComponent(Nombretxt)))
                            .addComponent(SelecionarImagen)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Aceptar)
                        .addGap(18, 18, 18)
                        .addComponent(Cancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Nombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Apellidotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Nicknametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Correotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(Dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(Mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(Año, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(SelecionarImagen)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Aceptar)
                    .addComponent(Cancelar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed

        try {
            Fabrica fabrica = new Fabrica();

            //Datos de Espectador
            String nombre = this.Nombretxt.getText();
            String apellido = this.Apellidotxt.getText();
            String nickname = this.Nicknametxt.getText();
            String email = this.Correotxt.getText();

            //Datos Fecha
            String fdia = this.Dia.getValue().toString();
            String fmes = this.Mes.getValue().toString();
            String fanio = this.Año.getValue().toString();

            //Convertimos la fecha para aa/mm/dd
            Date fecha = HelperFecha.parsearFecha(fdia, fmes, fanio);

            Espectador espectador = new Espectador("", nickname, nombre, apellido, email, fecha);
            fabrica.getUsuarioControladorImpl().altaUsuario(espectador);

            this.Nombretxt.setText("");
            this.Apellidotxt.setText("");
            this.Nicknametxt.setText("");
            this.Correotxt.setText("");
            this.Dia.setValue(1);
            this.Mes.setValue(1);
            this.Año.setValue(1900);

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(rootPane, String.format("Error argumento inválido [%s]", e.getMessage()));
            return;
        } catch (InnovaModelException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, String.format("Error desconocido [%s]", e.getMessage()));
            return;
        }
        //this.dispose(); //Limpia todos los Campos de la ventana
    }//GEN-LAST:event_AceptarActionPerformed

    private void NombretxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombretxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombretxtActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        //this.dispose();
        this.Nombretxt.setText("");
        this.Apellidotxt.setText("");
        this.Nicknametxt.setText("");
        this.Correotxt.setText("");
        this.Dia.setValue(1);
        this.Mes.setValue(1);
        this.Año.setValue(1900);
    }//GEN-LAST:event_CancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JTextField Apellidotxt;
    private javax.swing.JSpinner Año;
    private javax.swing.JButton Cancelar;
    private javax.swing.JTextField Correotxt;
    private javax.swing.JSpinner Dia;
    private javax.swing.JSpinner Mes;
    private javax.swing.JTextField Nicknametxt;
    private javax.swing.JTextField Nombretxt;
    private javax.swing.JButton SelecionarImagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables

}
