/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.interfaz;

import com.sucursales.AlmacenRed;
import com.sucursales.Estacion;
import com.sucursales.Grafo;
import com.sucursales.Linea;
import com.sucursales.Nodo;
import com.sucursales.NodoGrafo;
import com.sucursales.Recorrido;
import com.sucursales.RedDeTransporte;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author xc2do
 */
public class ColocarSucursal extends javax.swing.JFrame {

    /**
     * Creates new form ColocarSucursal
     */
    public ColocarSucursal() {
        initComponents();
        cargarEstaciones();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        QuitarSucursal = new javax.swing.JButton();
        ColocarSucursal1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Sucursales = new javax.swing.JTextArea();
        Estaciones = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Menu");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 110, 30));

        jLabel2.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sucursales");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 240, -1));

        QuitarSucursal.setBackground(new java.awt.Color(255, 51, 51));
        QuitarSucursal.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        QuitarSucursal.setForeground(new java.awt.Color(51, 51, 51));
        QuitarSucursal.setText("Quitar Sucursal");
        QuitarSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitarSucursalActionPerformed(evt);
            }
        });
        jPanel1.add(QuitarSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 200, 50));

        ColocarSucursal1.setBackground(new java.awt.Color(0, 153, 51));
        ColocarSucursal1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        ColocarSucursal1.setForeground(new java.awt.Color(51, 51, 51));
        ColocarSucursal1.setText("Colocar Sucursal");
        ColocarSucursal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColocarSucursal1ActionPerformed(evt);
            }
        });
        jPanel1.add(ColocarSucursal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 200, 50));

        Sucursales.setEditable(false);
        Sucursales.setBackground(new java.awt.Color(255, 255, 153));
        Sucursales.setColumns(20);
        Sucursales.setRows(5);
        jScrollPane1.setViewportView(Sucursales);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 240, 170));

        Estaciones.setBackground(new java.awt.Color(255, 255, 153));
        Estaciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Estaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstacionesActionPerformed(evt);
            }
        });
        jPanel1.add(Estaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 200, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/ColocarSucursal.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 400));

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

    private void ColocarSucursal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColocarSucursal1ActionPerformed
        String estacionSeleccionada = (String) Estaciones.getSelectedItem();
        Grafo grafo = AlmacenRed.getRedDeTransporte().getGrafo(); // Obtiene el grafo directamente desde AlmacenRed
        NodoGrafo nodo = grafo.obtenerNodoPorNombre(estacionSeleccionada);

        if (nodo != null) {
            nodo.establecerSucursal(true);
            actualizarTextoSucursales(grafo);
            JOptionPane.showMessageDialog(this, "Sucursal colocada en " + estacionSeleccionada, "Sucursal Colocada", JOptionPane.INFORMATION_MESSAGE);
            Recorrido recorrer = new Recorrido();
            recorrer.realizarDFS(nodo, 3);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró la estación " + estacionSeleccionada, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ColocarSucursal1ActionPerformed

    private void EstacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstacionesActionPerformed

    }//GEN-LAST:event_EstacionesActionPerformed

    private void QuitarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitarSucursalActionPerformed
        String estacionSeleccionada = (String) Estaciones.getSelectedItem();
        Grafo grafo = AlmacenRed.getRedDeTransporte().getGrafo(); // Obtiene el grafo directamente desde AlmacenRed
        NodoGrafo nodo = grafo.obtenerNodoPorNombre(estacionSeleccionada);
        if (nodo != null) {
            nodo.establecerSucursal(false);
            actualizarTextoSucursales(grafo);
            JOptionPane.showMessageDialog(this, "Sucursal quitada en " + estacionSeleccionada, "Sucursal Quitada", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró la estación " + estacionSeleccionada, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_QuitarSucursalActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        Menu menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void cargarEstaciones() {
        RedDeTransporte red = AlmacenRed.getRedDeTransporte(); // Accedemos directamente a la red de transporte

        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();

        for (Nodo<Linea> nodoLinea = red.getLineas().getHead(); nodoLinea != null; nodoLinea = nodoLinea.getNext()) {
            Linea linea = nodoLinea.getElement();
            for (Nodo<Estacion> nodoEstacion = linea.getEstaciones().getHead(); nodoEstacion != null; nodoEstacion = nodoEstacion.getNext()) {
                Estacion estacion = nodoEstacion.getElement();
                modelo.addElement(estacion.getNombre()); // Añadimos cada estación al modelo del ComboBox
            }
        }
        Estaciones.setModel(modelo);
    }

    private void actualizarTextoSucursales(Grafo grafo) {
        StringBuilder sucursalesTexto = new StringBuilder();
        for (Nodo<NodoGrafo> nodo = grafo.getNodos().getHead(); nodo != null; nodo = nodo.getNext()) {
            NodoGrafo nodoGrafo = nodo.getElement();
            if (nodoGrafo.esSucursal()) {
                sucursalesTexto.append(nodoGrafo.getNombre()).append("\n");
            }
        }
        Sucursales.setText(sucursalesTexto.toString());
    }

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
            java.util.logging.Logger.getLogger(ColocarSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ColocarSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ColocarSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ColocarSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ColocarSucursal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ColocarSucursal1;
    private javax.swing.JComboBox<String> Estaciones;
    private javax.swing.JButton QuitarSucursal;
    private javax.swing.JTextArea Sucursales;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
