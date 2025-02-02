/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.interfaz;

import com.sucursales.AlmacenRed;
import com.sucursales.Estacion;
import com.sucursales.Grafo;
import com.sucursales.Linea;
import com.sucursales.Lista;
import com.sucursales.Nodo;
import com.sucursales.NodoGrafo;
import com.sucursales.Recorrido;
import com.sucursales.RedDeTransporte;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
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
        jLabel4 = new javax.swing.JLabel();
        recorridoactual = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        DFS = new javax.swing.JButton();
        BFS = new javax.swing.JButton();
        QuitarSucursal = new javax.swing.JButton();
        ColocarSucursalSugerida = new javax.swing.JButton();
        ColocarSucursal1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Sucursales = new javax.swing.JTextArea();
        EstacionesSugeridas = new javax.swing.JComboBox<>();
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
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 120, 40));

        jLabel2.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("S\nU\nC\nU\nR\nS\nA\nL\nE\nS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 250, -1));

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel4.setText("Recorrido Actual:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 410, 150, -1));

        recorridoactual.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jPanel1.add(recorridoactual, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, -1, -1));

        jLabel5.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel5.setText("Estaciones:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel6.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel6.setText("Estaciones Sugeridas:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, -1, -1));

        DFS.setBackground(new java.awt.Color(255, 204, 102));
        DFS.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        DFS.setText("DFS");
        DFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DFSActionPerformed(evt);
            }
        });
        jPanel1.add(DFS, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 430, 150, 60));

        BFS.setBackground(new java.awt.Color(255, 204, 102));
        BFS.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        BFS.setText("BFS");
        BFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BFSActionPerformed(evt);
            }
        });
        jPanel1.add(BFS, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, 150, 60));

        QuitarSucursal.setBackground(new java.awt.Color(255, 51, 51));
        QuitarSucursal.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        QuitarSucursal.setForeground(new java.awt.Color(51, 51, 51));
        QuitarSucursal.setText("Quitar Sucursal");
        QuitarSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitarSucursalActionPerformed(evt);
            }
        });
        jPanel1.add(QuitarSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 330, 50));

        ColocarSucursalSugerida.setBackground(new java.awt.Color(0, 153, 51));
        ColocarSucursalSugerida.setFont(new java.awt.Font("Roboto Medium", 0, 10)); // NOI18N
        ColocarSucursalSugerida.setForeground(new java.awt.Color(51, 51, 51));
        ColocarSucursalSugerida.setText("Colocar Sucursal Sugerida");
        ColocarSucursalSugerida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColocarSucursalSugeridaActionPerformed(evt);
            }
        });
        jPanel1.add(ColocarSucursalSugerida, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 160, 50));

        ColocarSucursal1.setBackground(new java.awt.Color(0, 153, 51));
        ColocarSucursal1.setFont(new java.awt.Font("Roboto Medium", 0, 10)); // NOI18N
        ColocarSucursal1.setForeground(new java.awt.Color(51, 51, 51));
        ColocarSucursal1.setText("Colocar Sucursal");
        ColocarSucursal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColocarSucursal1ActionPerformed(evt);
            }
        });
        jPanel1.add(ColocarSucursal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 150, 50));

        Sucursales.setEditable(false);
        Sucursales.setBackground(new java.awt.Color(255, 255, 153));
        Sucursales.setColumns(20);
        Sucursales.setRows(5);
        jScrollPane1.setViewportView(Sucursales);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 310, 170));

        EstacionesSugeridas.setBackground(new java.awt.Color(255, 255, 153));
        EstacionesSugeridas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sugerencias*" }));
        EstacionesSugeridas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstacionesSugeridasActionPerformed(evt);
            }
        });
        jPanel1.add(EstacionesSugeridas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 160, 30));

        Estaciones.setBackground(new java.awt.Color(255, 255, 153));
        Estaciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Estaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstacionesActionPerformed(evt);
            }
        });
        jPanel1.add(Estaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 150, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/ColocarSucursalDef.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

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
        Grafo grafo = AlmacenRed.getRedDeTransporte().getGrafo(); //con esto obtenemos el grafo directamente desde AlmacenRed
        NodoGrafo nodo = grafo.obtenerNodoPorNombre(estacionSeleccionada);

        if (nodo != null) {
            nodo.establecerSucursal(true);//se crea una sucursal
            actualizarTextoSucursales(grafo);
            JOptionPane.showMessageDialog(this, "Sucursal colocada en " + estacionSeleccionada, "Sucursal Colocada", JOptionPane.INFORMATION_MESSAGE);

            //se actualiza la cobertura 
            Recorrido recorrido = new Recorrido();
            recorrido.determinarCoberturaComercial(grafo); //determinar cobertura en el grafo de datos
            //revisar la cobertura total
            if (recorrido.revisarCoberturaTotal(grafo)) {
                JOptionPane.showMessageDialog(this, "¡Cobertura total alcanzada!", "Cobertura Total", JOptionPane.INFORMATION_MESSAGE);
            } else {
                //actualizar el JComboBox con sugerencias
                actualizarSugerencias(EstacionesSugeridas, grafo);
            }
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

    private void EstacionesSugeridasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstacionesSugeridasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EstacionesSugeridasActionPerformed

    private void ColocarSucursalSugeridaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColocarSucursalSugeridaActionPerformed
        String estacionSugerida = (String) EstacionesSugeridas.getSelectedItem();
        Grafo grafo = AlmacenRed.getRedDeTransporte().getGrafo(); // Obtiene el grafo de datos
        NodoGrafo nodo = grafo.obtenerNodoPorNombre(estacionSugerida);

        if (nodo != null) {
            nodo.establecerSucursal(true); // Marcar como sucursal
            actualizarTextoSucursales(grafo);
            JOptionPane.showMessageDialog(this, "Sucursal sugerida colocada en " + estacionSugerida, "Sucursal Colocada", JOptionPane.INFORMATION_MESSAGE);

            Recorrido recorrido = new Recorrido();
            recorrido.determinarCoberturaComercial(grafo);

            //revisar la cobertura total
            if (recorrido.revisarCoberturaTotal(grafo)) {
                JOptionPane.showMessageDialog(this, "¡Cobertura total alcanzada!", "Cobertura Total", JOptionPane.INFORMATION_MESSAGE);
            } else {
                //actualizar el combobox con sugerencias
                actualizarSugerencias(EstacionesSugeridas, grafo);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró la estación " + estacionSugerida, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ColocarSucursalSugeridaActionPerformed

    private void BFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BFSActionPerformed
        AlmacenRed.setTipoRecorrido("BFS");
        recorridoactual.setText("BFS");
    }//GEN-LAST:event_BFSActionPerformed

    private void DFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DFSActionPerformed
        AlmacenRed.setTipoRecorrido("DFS");
        recorridoactual.setText("DFS");
    }//GEN-LAST:event_DFSActionPerformed

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

    private void actualizarSugerencias(JComboBox<String> comboBoxSugerencias, Grafo grafo) {
        Recorrido recorrido = new Recorrido();
        Lista<String> sugerencias = recorrido.sugerirNuevasSucursales(grafo);

        //limpiar el JComboBox y agregar nuevas sugerencias
        comboBoxSugerencias.removeAllItems();
        for (Nodo<String> nodo = sugerencias.getHead(); nodo != null; nodo = nodo.getNext()) {
            String estacionSugerida = nodo.getElement();
            comboBoxSugerencias.addItem(estacionSugerida);
        }
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
    private javax.swing.JButton BFS;
    private javax.swing.JButton ColocarSucursal1;
    private javax.swing.JButton ColocarSucursalSugerida;
    private javax.swing.JButton DFS;
    private javax.swing.JComboBox<String> Estaciones;
    private javax.swing.JComboBox<String> EstacionesSugeridas;
    private javax.swing.JButton QuitarSucursal;
    private javax.swing.JTextArea Sucursales;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel recorridoactual;
    // End of variables declaration//GEN-END:variables
}
