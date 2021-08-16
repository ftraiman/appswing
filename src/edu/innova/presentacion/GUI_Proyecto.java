package edu.innova.presentacion;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

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
        jMenu3 = new javax.swing.JMenu();
        jMenu_Usuarios = new javax.swing.JMenu();
        jMenuItem_Espectador = new javax.swing.JMenuItem();
        jMenuItem_Artistas = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuModificarArtista = new javax.swing.JMenuItem();

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
            .addGap(0, 451, Short.MAX_VALUE)
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
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

        Menu.add(Registro);

        jMenu3.setText("Consultas");

        jMenu_Usuarios.setText("Consultar usuarios");

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

        Menu.add(jMenu3);

        jMenu2.setText("Modificar");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Espectador");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jCheckBoxMenuItem1);

        jMenuModificarArtista.setText("Artista");
        jMenuModificarArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuModificarArtistaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuModificarArtista);

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
            .addComponent(Panel)
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

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        Modificar_Espectador me = new Modificar_Espectador();
        this.Panel.add(me);
        me.show();
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

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

    private void jMenuModificarArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuModificarArtistaActionPerformed
        Modificar_Artista ma = new Modificar_Artista();
        this.Panel.add(ma);
        ma.show();
    }//GEN-LAST:event_jMenuModificarArtistaActionPerformed

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
    private javax.swing.JMenuItem Artista;
    private javax.swing.JMenu Cliente;
    private javax.swing.JMenuItem Espectador;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JDesktopPane Panel;
    private javax.swing.JMenu Registro;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem_Artistas;
    private javax.swing.JMenuItem jMenuItem_Espectador;
    private javax.swing.JMenu jMenu_Usuarios;
    private javax.swing.JMenuItem jMenuModificarArtista;
    // End of variables declaration//GEN-END:variables
}
