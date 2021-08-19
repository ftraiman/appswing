package edu.innova.presentacion;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUI_Proyecto extends javax.swing.JFrame {

    public GUI_Proyecto() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        Panel = new javax.swing.JDesktopPane();
        Menu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Registro = new javax.swing.JMenu();
        Cliente = new javax.swing.JMenu();
        Artista = new javax.swing.JMenuItem();
        Espectador = new javax.swing.JMenuItem();
        Espectaculo = new javax.swing.JMenu();
        EspectaculoC = new javax.swing.JMenuItem();
        Plataforma = new javax.swing.JMenu();
        Plataforma1 = new javax.swing.JMenuItem();
        Paquete = new javax.swing.JMenu();
        Crear_Paquete = new javax.swing.JMenuItem();
        Agregar_Espectaculo = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        AgregarFE = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu_Usuarios = new javax.swing.JMenu();
        jMenuItem_Espectador = new javax.swing.JMenuItem();
        jMenuItem_Artistas = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuModificarArtista = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 957, Short.MAX_VALUE)
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );

        jMenu1.setText("Inicio");
        Menu.add(jMenu1);

        Registro.setText("Registro");

        Cliente.setText("Cliente");

        Artista.setText("Artista");
        Artista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArtistaActionPerformed(evt);
            }
        });
        Cliente.add(Artista);

        Espectador.setText("Espectador");
        Espectador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EspectadorActionPerformed(evt);
            }
        });
        Cliente.add(Espectador);

        Registro.add(Cliente);

        Espectaculo.setText("Espectaculo");

        EspectaculoC.setText("Crear Espectaculo");
        EspectaculoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EspectaculoCActionPerformed(evt);
            }
        });
        Espectaculo.add(EspectaculoC);

        Registro.add(Espectaculo);

        Plataforma.setText("Plataforma");

        Plataforma1.setText("Crear Plataforma");
        Plataforma1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Plataforma1ActionPerformed(evt);
            }
        });
        Plataforma.add(Plataforma1);

        Registro.add(Plataforma);

        Paquete.setText("Paquete");

        Crear_Paquete.setText("Crear Paquete");
        Crear_Paquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Crear_PaqueteActionPerformed(evt);
            }
        });
        Paquete.add(Crear_Paquete);

        Agregar_Espectaculo.setText("Asignar Espectaculo");
        Agregar_Espectaculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Agregar_EspectaculoActionPerformed(evt);
            }
        });
        Paquete.add(Agregar_Espectaculo);

        Registro.add(Paquete);

        jMenu5.setText("Funcion");

        AgregarFE.setText("Alta Funcion a Espectaculo");
        AgregarFE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarFEActionPerformed(evt);
            }
        });
        jMenu5.add(AgregarFE);

        jMenuItem5.setText(" Registro a Función de Espectáculo");
        jMenu5.add(jMenuItem5);

        Registro.add(jMenu5);

        Menu.add(Registro);

        jMenu3.setText("Consultas");

        jMenu_Usuarios.setText("Consultar Usuarios");

        jMenuItem_Espectador.setText("Espectador");
        jMenuItem_Espectador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_EspectadorActionPerformed(evt);
            }
        });
        jMenu_Usuarios.add(jMenuItem_Espectador);

        jMenuItem_Artistas.setText("Artistas");
        jMenuItem_Artistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ArtistasActionPerformed(evt);
            }
        });
        jMenu_Usuarios.add(jMenuItem_Artistas);

        jMenu3.add(jMenu_Usuarios);

        jMenu4.setText("Consultar Espectaculo");

        jMenuItem2.setText("Espectaculo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenu3.add(jMenu4);

        jMenu6.setText("Consultar Paquetes");

        jMenuItem3.setText("Paquete de Espectaculos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem3);

        jMenu3.add(jMenu6);

        Menu.add(jMenu3);

        jMenu2.setText("Modificar");

        jMenuModificarArtista.setText("Artista");
        jMenuModificarArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuModificarArtistaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuModificarArtista);

        jMenuItem4.setText("Espectador");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        Menu.add(jMenu2);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden

    }//GEN-LAST:event_formComponentHidden

    private void EspectadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EspectadorActionPerformed
        Registrar_Espectador re = new Registrar_Espectador();
        this.Panel.add(re);
        re.show();
    }//GEN-LAST:event_EspectadorActionPerformed

    private void ArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArtistaActionPerformed
        Registrar_Artista ra = new Registrar_Artista();
        this.Panel.add(ra);
        ra.show();
    }//GEN-LAST:event_ArtistaActionPerformed

    private void jMenuItem_EspectadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_EspectadorActionPerformed
        try {
            Todos_Los_Espectadores te = new Todos_Los_Espectadores();
            this.Panel.add(te);
            te.show();
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuItem_EspectadorActionPerformed

    private void jMenuItem_ArtistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ArtistasActionPerformed
        try {
            Todos_Los_Artistas ta = new Todos_Los_Artistas();
            this.Panel.add(ta);
            ta.show();
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem_ArtistasActionPerformed

    private void EspectaculoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EspectaculoCActionPerformed
        Registrar_Espectaculos re = new Registrar_Espectaculos();
        this.Panel.add(re);
        re.show();
    }//GEN-LAST:event_EspectaculoCActionPerformed

     private void jMenuModificarArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuModificarArtistaActionPerformed
        Modificar_Artista ma = new Modificar_Artista();
        this.Panel.add(ma);
        ma.show();
    }//GEN-LAST:event_jMenuModificarArtistaActionPerformed

    private void Plataforma1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Plataforma1ActionPerformed
        Registrar_Plataforma rp = new Registrar_Plataforma();
        this.Panel.add(rp);
        rp.show();
    }//GEN-LAST:event_Plataforma1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
        try {
            Todos_Los_Espectaculos te;
            te = new Todos_Los_Espectaculos();
            this.Panel.add(te);
            te.show();
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void Crear_PaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Crear_PaqueteActionPerformed
        Registrar_Paquete rp = new Registrar_Paquete();
        this.Panel.add(rp);
        rp.show();
    }//GEN-LAST:event_Crear_PaqueteActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Modificar_Espectador me = new Modificar_Espectador();
        this.Panel.add(me);
        me.show();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void Agregar_EspectaculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Agregar_EspectaculoActionPerformed
        Registrar_Espectaculo_en_Paquete rep = new Registrar_Espectaculo_en_Paquete();
        this.Panel.add(rep);
        rep.show();
    }//GEN-LAST:event_Agregar_EspectaculoActionPerformed

    private void AgregarFEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarFEActionPerformed
        Registrar_Funcion fe = new  Registrar_Funcion();
        this.Panel.add(fe);
        fe.show();
    }//GEN-LAST:event_AgregarFEActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Todos_Los_Paquetes tp;
        try {
            tp = new  Todos_Los_Paquetes();
            this.Panel.add(tp);
            tp.show();
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Proyecto().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AgregarFE;
    private javax.swing.JMenuItem Agregar_Espectaculo;
    private javax.swing.JMenuItem Artista;
    private javax.swing.JMenu Cliente;
    private javax.swing.JMenuItem Crear_Paquete;
    private javax.swing.JMenu Espectaculo;
    private javax.swing.JMenuItem EspectaculoC;
    private javax.swing.JMenuItem Espectador;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JDesktopPane Panel;
    private javax.swing.JMenu Paquete;
    private javax.swing.JMenu Plataforma;
    private javax.swing.JMenuItem Plataforma1;
    private javax.swing.JMenu Registro;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem_Artistas;
    private javax.swing.JMenuItem jMenuItem_Espectador;
    private javax.swing.JMenuItem jMenuModificarArtista;
    private javax.swing.JMenu jMenu_Usuarios;
    // End of variables declaration//GEN-END:variables
}
