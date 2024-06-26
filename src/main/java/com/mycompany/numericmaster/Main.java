package com.mycompany.numericmaster;

public class Main extends javax.swing.JFrame {

   
    // Declare the instances of other panels
    MethodSelection methodSelectionPanel;
    Muller mullerPanel;
    Cramer cramerPanel;
    Midpoint midpointPanel;
    
    public Main() {
        initComponents();
        
        // Creates instances of other panels
        methodSelectionPanel = new MethodSelection();
        mullerPanel = new Muller();
        cramerPanel = new Cramer();
        midpointPanel = new Midpoint();
        
        // show the method selection panel but hide the other panels
        methodSelectionPanel.setVisible(true);
        mullerPanel.setVisible(false);
        cramerPanel.setVisible(false);
        midpointPanel.setVisible(false);
        
        // adds the other panels to the frame
        mainPanel.add(methodSelectionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));
        mainPanel.add(mullerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));
        mainPanel.add(cramerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));
        mainPanel.add(midpointPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));
        
        // connects the method selection panel to the other panels
        methodSelectionPanel.setPointerToMullerPanel(mullerPanel);
        methodSelectionPanel.setPointerToCramerPanel(cramerPanel);
        methodSelectionPanel.setPointerToMidpointPanel(midpointPanel);
        
        // connects the other panels to the method selection panel
        mullerPanel.setPointerToPreviousPanel(methodSelectionPanel);
        cramerPanel.setPointerToPreviousPanel(methodSelectionPanel);
        midpointPanel.setPointerToPreviousPanel(methodSelectionPanel);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
