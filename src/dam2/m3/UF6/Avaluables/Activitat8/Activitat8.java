/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m3.UF6.Avaluables.Activitat8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Alumne
 */
public class Activitat8 extends javax.swing.JFrame {
    String[] arrayPanells = new String[] {"X","W","X","W","W","0","0","0","0","0","0","0","0","0","0","0"};
    int i = 0;
    List<String> strList = Arrays.asList(arrayPanells);
    /**
     * Creates new form Activitat8
     */
    public Activitat8() {
        initComponents();
        table.setEnabled(false);
        Collections.shuffle(strList);
        arrayPanells = strList.toArray(new String[strList.size()]);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        labelRecord = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfPunts = new javax.swing.JTextField();
        bSortir = new javax.swing.JButton();
        bReiniciar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Rècord: ");

        labelRecord.setText("0");

        jLabel3.setText("Punts:");

        tfPunts.setEditable(false);
        tfPunts.setText("0");

        bSortir.setText("Sortir");
        bSortir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSortirActionPerformed(evt);
            }
        });

        bReiniciar.setText("Començar");
        bReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReiniciarActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"?", "?", "?", "?"},
                {"?", "?", "?", "?"},
                {"?", "?", "?", "?"},
                {"?", "?", "?", "?"}
            },
            new String [] {
                "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(60);
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bSortir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bReiniciar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelRecord))
                    .addComponent(jLabel3)
                    .addComponent(tfPunts, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(labelRecord))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPunts, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bSortir)
                            .addComponent(bReiniciar)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
    if (table.isEnabled()== true) {
        
        if (table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()) == ("?")) {
        table.setValueAt(arrayPanells[i], table.getSelectedRow(), table.getSelectedColumn());
    i++;
        if (table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()) == ("0")) {
            String myString = tfPunts.getText();
            int punts = Integer.parseInt(myString);
            punts = punts + 1;
            tfPunts.setText(String.valueOf(punts));
            String myString2 = labelRecord.getText();
            int puntsRecord = Integer.parseInt(myString2);
                if (puntsRecord < punts) {
                labelRecord.setText(tfPunts.getText());
                }
        } else if (table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()) == ("W")) {
            String myString = tfPunts.getText();
            int punts = Integer.parseInt(myString);
            punts = punts*2;
            tfPunts.setText(String.valueOf(punts));
            String myString2 = labelRecord.getText();
            int puntsRecord = Integer.parseInt(myString2);
            if (puntsRecord < punts) {
                labelRecord.setText(tfPunts.getText());
              }
        } else {
            jocAcabat();
        }
    } else {
        mostraError();
    }
    } else {
        JOptionPane.showMessageDialog(null, "Comença la partida primer! ", "Start game", 
        JOptionPane.ERROR_MESSAGE); 
    }
    }//GEN-LAST:event_tableMouseClicked

    private void bSortirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSortirActionPerformed
        JOptionPane.showMessageDialog(null, "Quina pena! Has perdut, has fet " + tfPunts.getText() + " punt", "Game Over", 
        JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }//GEN-LAST:event_bSortirActionPerformed

    private void bReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReiniciarActionPerformed
    i=0;
    tfPunts.setText("0");
    bReiniciar.setText("Reinicia pantalla");
    table.setEnabled(true);
    arrayPanells = new String[] {"X","W","X","W","W","0","0","0","0","0","0","0","0","0","0","0"};
    strList = Arrays.asList(arrayPanells);
    Collections.shuffle(strList);
    arrayPanells = strList.toArray(new String[strList.size()]);
    for (int i = 0; i<table.getRowCount(); i++) {
        table.setValueAt("?", 0, i);
        table.setValueAt("?", 1, i);
        table.setValueAt("?", 2, i);
        table.setValueAt("?", 3, i);
        
    }
    }//GEN-LAST:event_bReiniciarActionPerformed
    
    private boolean esBuit() {
     return arrayPanells.equals("X");
    }
    
    private void mostraError() {
        JOptionPane.showMessageDialog(null, "Error, no pitjis un panel revelat", "Error Act8", 
                JOptionPane.ERROR_MESSAGE);
    }
    
    private void jocAcabat() {
        String myString = tfPunts.getText();
        int punts = Integer.parseInt(myString);
        String myString2 = labelRecord.getText();
        int puntsRecord = Integer.parseInt(myString2);
        if (puntsRecord < punts) {
        labelRecord.setText(tfPunts.getText());
        }
        JOptionPane.showMessageDialog(null, "Quina pena! Has perdut, has fet " + tfPunts.getText() + " punt", "Game Over", 
                JOptionPane.ERROR_MESSAGE);
                table.setEnabled(false);
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
            java.util.logging.Logger.getLogger(Activitat8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Activitat8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Activitat8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Activitat8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Activitat8().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bReiniciar;
    private javax.swing.JButton bSortir;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelRecord;
    private javax.swing.JTable table;
    private javax.swing.JTextField tfPunts;
    // End of variables declaration//GEN-END:variables
}
