/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m3.UF6.Avaluables.Activitat7Grafic;

import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Alumne
 */
public class Interfaz extends javax.swing.JFrame {
       //Variables
	int chivato = 0;
	int origenFila = -1;
	int origenColumna = -1;
	int destiFila = -1;
	int destiColumna = -1;
        Fitxa fitxa, fitxaDesti;
	boolean mValid, tornBlanc;
    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        //Inicialitzem tauler
        omplirTaulerAjedrez();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablaAjedrez = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        bReiniciar = new javax.swing.JButton();
        juguen_color = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaAjedrez.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaAjedrez.setPreferredSize(new java.awt.Dimension(600, 200));
        tablaAjedrez.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAjedrezMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 24)); // NOI18N
        jLabel1.setText("El juego del Ajedrez");

        bReiniciar.setText("Reiniciar partida");
        bReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReiniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(juguen_color)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bReiniciar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tablaAjedrez, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(jLabel1))))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(tablaAjedrez, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bReiniciar)
                    .addComponent(juguen_color))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        if (tablaAjedrez.getColumnModel().getColumnCount() > 0) {
            tablaAjedrez.getColumnModel().getColumn(0).setResizable(false);
            tablaAjedrez.getColumnModel().getColumn(1).setResizable(false);
            tablaAjedrez.getColumnModel().getColumn(2).setResizable(false);
            tablaAjedrez.getColumnModel().getColumn(3).setResizable(false);
            tablaAjedrez.getColumnModel().getColumn(4).setResizable(false);
            tablaAjedrez.getColumnModel().getColumn(5).setResizable(false);
            tablaAjedrez.getColumnModel().getColumn(6).setResizable(false);
            tablaAjedrez.getColumnModel().getColumn(7).setResizable(false);
        }

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaAjedrezMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAjedrezMouseClicked
        int columna = obtenirColumnaClicada();
        int fila = obtenirFilaClicada(); 
        
    }//GEN-LAST:event_tablaAjedrezMouseClicked

    private void bReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReiniciarActionPerformed
        //Ho omplim de nou.
        omplirTaulerAjedrez();
    }//GEN-LAST:event_bReiniciarActionPerformed
    
    private void omplirTaulerAjedrez() {
        tornBlanc = true;
        DefaultTableModel model = new DefaultTableModel();
        Object fitxesBlanques[] = {"T", "C", "A", "Q", "K", "A", "C", "T"};
        Object peoBlanques[] = {"P", "P", "P", "P", "P", "P", "P", "P"};
        Object filaBuit[] =     {"·", "·", "·", "·", "·", "·", "·", "·"}; 
        Object fitxesNegres[] = {"t", "c", "a", "q", "k", "a", "c", "t"};
        Object peoNegres[] = {"p", "p", "p", "p", "p", "p", "p", "p",};
        
        //Creem les columnes.
        for (int i = 0; i < 8; i++) {
            model.addColumn("");
        }
        model.addRow(fitxesNegres);
        model.addRow(peoNegres);
        model.addRow(filaBuit);
        model.addRow(filaBuit);
        model.addRow(filaBuit);
        model.addRow(filaBuit);
        model.addRow(peoBlanques);
        model.addRow(fitxesBlanques);

        tablaAjedrez.setModel(model);
        tablaAjedrez.setDefaultEditor(Object.class, null);
        origenFila = -1;
        origenColumna = -1;
        destiFila = -1;
        destiColumna = -1;
    }
    
    public int obtenirFilaClicada(){
        return tablaAjedrez.getSelectedRow();
    }
    
    public int obtenirColumnaClicada(){
    return tablaAjedrez.getSelectedColumn(); 
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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bReiniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel juguen_color;
    private javax.swing.JTable tablaAjedrez;
    // End of variables declaration//GEN-END:variables

}
