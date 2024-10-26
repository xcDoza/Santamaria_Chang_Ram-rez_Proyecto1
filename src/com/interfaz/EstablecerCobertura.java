/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.interfaz;

import com.sucursales.AlmacenRed;
import javax.swing.JOptionPane;

/**
 *
 * @author xc2do
 */
public class EstablecerCobertura extends javax.swing.JFrame {

    /**
     * Creates new form EstablecerCobertura
     */
    public EstablecerCobertura() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        T = new javax.swing.JTextField();
        CambiarT = new javax.swing.JLabel();
        rangoactual = new javax.swing.JLabel();
        Retroceder = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(T, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 90, -1));

        CambiarT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CambiarT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CambiarTMouseClicked(evt);
            }
        });
        jPanel1.add(CambiarT, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 90, 30));

        rangoactual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rangoactual.setText("Rango actual: 3");
        rangoactual.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(rangoactual, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 90, -1));

        Retroceder.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        Retroceder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Retroceder.setText("Menu");
        Retroceder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Retroceder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RetrocederMouseClicked(evt);
            }
        });
        jPanel1.add(Retroceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 266, 70, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/EstablecerCobertura.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void RetrocederMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RetrocederMouseClicked
        Menu menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RetrocederMouseClicked

    private void CambiarTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CambiarTMouseClicked
        try {
            int nuevoValorT = Integer.parseInt(T.getText());
            AlmacenRed.setT(nuevoValorT);
            rangoactual.setText("Rango actual: " + nuevoValorT);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_CambiarTMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EstablecerCobertura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstablecerCobertura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstablecerCobertura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstablecerCobertura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EstablecerCobertura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CambiarT;
    private javax.swing.JLabel Retroceder;
    private javax.swing.JTextField T;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel rangoactual;
    // End of variables declaration//GEN-END:variables
}
