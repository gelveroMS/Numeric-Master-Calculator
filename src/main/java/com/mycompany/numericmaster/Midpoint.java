package com.mycompany.numericmaster;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Midpoint extends javax.swing.JPanel {

    // Declare pointer to previous panel
    JPanel pointerToPreviousPanel;
    
    // Declare its second panel
    MidpointPanel2 midpointPanel2;
    
    public Midpoint() {
        initComponents();
        
        // Initialize pointer to previous panel
        pointerToPreviousPanel = null;
        
        // Instantiate its second panel and hide it for now
        midpointPanel2 = new MidpointPanel2();
        midpointPanel2.setVisible(false);
        
        // add the second panel to this panel
        add(midpointPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));
        
        // connects this panel to its second panel
        midpointPanel2.setPointerToPreviousPanel(userInputPanel);
        
    }
    
    
    public void redisplayLabelOnMouseExit(JTextField inputField, String label) {
        // redisplay labels upon mouse exit
        if (inputField.getText().equals("")) {
            inputField.setText(label);
            inputField.setCaretPosition(0);
        }
    }

    public void displayOnFunctionInput(JLabel operator) {
        
        if(operator.getText().equals("^")) {
            functionInput.setText(functionInput.getText() + operator.getText() + "()");
            functionInput.setCaretPosition(functionInput.getText().length()-1);
        }
        else if(operator.getText().equals("x^(a)")) {
            functionInput.setText(functionInput.getText() + "x^()");
            functionInput.setCaretPosition(functionInput.getText().length()-1);
        }
        else if (!operator.getText().equals("^")){
            functionInput.setText(functionInput.getText() + operator.getText());
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userInputPanel = new javax.swing.JPanel();
        midpointBackLblBtn = new javax.swing.JLabel();
        generateFunctionLbl = new javax.swing.JLabel();
        clearInputFields = new javax.swing.JLabel();
        functionInput = new javax.swing.JTextField();
        plusLblBtn = new javax.swing.JLabel();
        minusLblBtn = new javax.swing.JLabel();
        multiplyLblBtn = new javax.swing.JLabel();
        divideLblBtn = new javax.swing.JLabel();
        exponentLblBtn = new javax.swing.JLabel();
        openingParenthesesLblBtn = new javax.swing.JLabel();
        closingParenthesesLblBtn = new javax.swing.JLabel();
        xRaisedToLblBtn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userInputPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        midpointBackLblBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackBtn.png"))); // NOI18N
        midpointBackLblBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                midpointBackLblBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                midpointBackLblBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                midpointBackLblBtnMousePressed(evt);
            }
        });
        userInputPanel.add(midpointBackLblBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 650, -1, -1));

        generateFunctionLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GenerateFunctionBtnenter.png"))); // NOI18N
        generateFunctionLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                generateFunctionLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                generateFunctionLblMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                generateFunctionLblMousePressed(evt);
            }
        });
        userInputPanel.add(generateFunctionLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 230, 40));

        clearInputFields.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ClearBtn.png"))); // NOI18N
        clearInputFields.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearInputFieldsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearInputFieldsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                clearInputFieldsMousePressed(evt);
            }
        });
        userInputPanel.add(clearInputFields, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, -1, -1));

        functionInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userInputPanel.add(functionInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 320, 50));

        plusLblBtn.setFont(new java.awt.Font("Swis721 Lt BT", 1, 18)); // NOI18N
        plusLblBtn.setForeground(new java.awt.Color(0, 102, 0));
        plusLblBtn.setText("+");
        plusLblBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                plusLblBtnMousePressed(evt);
            }
        });
        userInputPanel.add(plusLblBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, -1, -1));

        minusLblBtn.setFont(new java.awt.Font("Swis721 Lt BT", 1, 24)); // NOI18N
        minusLblBtn.setForeground(new java.awt.Color(0, 102, 0));
        minusLblBtn.setText("-");
        minusLblBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                minusLblBtnMousePressed(evt);
            }
        });
        minusLblBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                minusLblBtnKeyPressed(evt);
            }
        });
        userInputPanel.add(minusLblBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 20, -1));

        multiplyLblBtn.setFont(new java.awt.Font("Swis721 Lt BT", 1, 18)); // NOI18N
        multiplyLblBtn.setForeground(new java.awt.Color(0, 102, 0));
        multiplyLblBtn.setText("*");
        multiplyLblBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                multiplyLblBtnMousePressed(evt);
            }
        });
        multiplyLblBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                multiplyLblBtnKeyPressed(evt);
            }
        });
        userInputPanel.add(multiplyLblBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, -1, -1));

        divideLblBtn.setFont(new java.awt.Font("Swis721 Lt BT", 1, 18)); // NOI18N
        divideLblBtn.setForeground(new java.awt.Color(0, 102, 0));
        divideLblBtn.setText("/");
        divideLblBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                divideLblBtnMousePressed(evt);
            }
        });
        divideLblBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                divideLblBtnKeyPressed(evt);
            }
        });
        userInputPanel.add(divideLblBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 20, -1));

        exponentLblBtn.setFont(new java.awt.Font("Swis721 Lt BT", 1, 18)); // NOI18N
        exponentLblBtn.setForeground(new java.awt.Color(0, 102, 0));
        exponentLblBtn.setText("^");
        exponentLblBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exponentLblBtnMousePressed(evt);
            }
        });
        exponentLblBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                exponentLblBtnKeyPressed(evt);
            }
        });
        userInputPanel.add(exponentLblBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, -1, -1));

        openingParenthesesLblBtn.setFont(new java.awt.Font("Swis721 Lt BT", 1, 18)); // NOI18N
        openingParenthesesLblBtn.setForeground(new java.awt.Color(0, 102, 0));
        openingParenthesesLblBtn.setText("(");
        openingParenthesesLblBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                openingParenthesesLblBtnMousePressed(evt);
            }
        });
        openingParenthesesLblBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                openingParenthesesLblBtnKeyPressed(evt);
            }
        });
        userInputPanel.add(openingParenthesesLblBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 10, -1));

        closingParenthesesLblBtn.setFont(new java.awt.Font("Swis721 Lt BT", 1, 18)); // NOI18N
        closingParenthesesLblBtn.setForeground(new java.awt.Color(0, 102, 0));
        closingParenthesesLblBtn.setText(")");
        closingParenthesesLblBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                closingParenthesesLblBtnMousePressed(evt);
            }
        });
        userInputPanel.add(closingParenthesesLblBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 20, -1));

        xRaisedToLblBtn.setFont(new java.awt.Font("Swis721 Lt BT", 1, 18)); // NOI18N
        xRaisedToLblBtn.setForeground(new java.awt.Color(0, 102, 0));
        xRaisedToLblBtn.setText("x^(a)");
        xRaisedToLblBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                xRaisedToLblBtnMousePressed(evt);
            }
        });
        userInputPanel.add(xRaisedToLblBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MIDPOINT METHOD CALCULATOR.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        userInputPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        add(userInputPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 800));
    }// </editor-fold>//GEN-END:initComponents

    // sets pointer to previous panel
    public void setPointerToPreviousPanel(MethodSelection panel) {
        pointerToPreviousPanel = panel;
    }
    
    private void midpointBackLblBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_midpointBackLblBtnMousePressed
        // hides this panel and show the method selection panel
        setVisible(false);
        pointerToPreviousPanel.setVisible(true);
    }//GEN-LAST:event_midpointBackLblBtnMousePressed

    private void generateFunctionLblMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generateFunctionLblMousePressed
        if (!Exhandling.emptyFieldsCheck(functionInput.getText())){
            return;
        }
        if (!Exhandling.adjacentLetters(functionInput.getText())){
            return;
        }
        if (!Exhandling.oneTypeOfLetter(functionInput.getText())){
            return;
        }

        if (!Exhandling.spaceCheck(functionInput.getText())){
            return;
        }
      
        if (!Exhandling.checkEquation(functionInput.getText())){
            return;
        }
       

        // hides this panel and show the second panel
        userInputPanel.setVisible(false);
        midpointPanel2.setVisible(true);
        
        // parse the user input into a function
        midpointPanel2.displayFunction(functionInput.getText());
        
        //clear the input field
        functionInput.setText("");
    }//GEN-LAST:event_generateFunctionLblMousePressed

    private void clearInputFieldsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearInputFieldsMousePressed

       functionInput.setText("");
    }//GEN-LAST:event_clearInputFieldsMousePressed

    private void plusLblBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plusLblBtnMousePressed
        // display the specific operator on the input field
        displayOnFunctionInput(plusLblBtn);
    }//GEN-LAST:event_plusLblBtnMousePressed

    private void minusLblBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minusLblBtnMousePressed
        // display the specific operator on the input field
        displayOnFunctionInput(minusLblBtn);
    }//GEN-LAST:event_minusLblBtnMousePressed

    private void minusLblBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_minusLblBtnKeyPressed

    }//GEN-LAST:event_minusLblBtnKeyPressed

    private void multiplyLblBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_multiplyLblBtnMousePressed
        // display the specific operator on the input field
        displayOnFunctionInput(multiplyLblBtn);
    }//GEN-LAST:event_multiplyLblBtnMousePressed

    private void multiplyLblBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_multiplyLblBtnKeyPressed

    }//GEN-LAST:event_multiplyLblBtnKeyPressed

    private void divideLblBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_divideLblBtnMousePressed
        // display the specific operator on the input field
        displayOnFunctionInput(divideLblBtn);
    }//GEN-LAST:event_divideLblBtnMousePressed

    private void divideLblBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_divideLblBtnKeyPressed

    }//GEN-LAST:event_divideLblBtnKeyPressed

    private void exponentLblBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exponentLblBtnMousePressed
        // display the specific operator on the input field
        displayOnFunctionInput(exponentLblBtn);
    }//GEN-LAST:event_exponentLblBtnMousePressed

    private void exponentLblBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_exponentLblBtnKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_exponentLblBtnKeyPressed

    private void openingParenthesesLblBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openingParenthesesLblBtnMousePressed
        // display the specific operator on the input field
        displayOnFunctionInput(openingParenthesesLblBtn);
    }//GEN-LAST:event_openingParenthesesLblBtnMousePressed

    private void openingParenthesesLblBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_openingParenthesesLblBtnKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_openingParenthesesLblBtnKeyPressed

    private void closingParenthesesLblBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closingParenthesesLblBtnMousePressed
        // display the specific operator on the input field
        displayOnFunctionInput(closingParenthesesLblBtn);
    }//GEN-LAST:event_closingParenthesesLblBtnMousePressed

    private void xRaisedToLblBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xRaisedToLblBtnMousePressed
        // display the specific operator on the input field
        displayOnFunctionInput(xRaisedToLblBtn);
    }//GEN-LAST:event_xRaisedToLblBtnMousePressed

    private void generateFunctionLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generateFunctionLblMouseExited
        // TODO add your handling code here:
        generateFunctionLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GenerateFunctionBtn.png"))); // NOI18N
    }//GEN-LAST:event_generateFunctionLblMouseExited

    private void generateFunctionLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generateFunctionLblMouseEntered
        // TODO add your handling code here:
        generateFunctionLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GenerateFunctionBtnenter.png"))); // NOI18N
    }//GEN-LAST:event_generateFunctionLblMouseEntered

    private void clearInputFieldsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearInputFieldsMouseExited
        // TODO add your handling code here:
        clearInputFields.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ClearBtn.png"))); // NOI18N
    }//GEN-LAST:event_clearInputFieldsMouseExited

    private void clearInputFieldsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearInputFieldsMouseEntered
        // TODO add your handling code here:
        clearInputFields.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ClearBtnenter.png"))); // NOI18N
    }//GEN-LAST:event_clearInputFieldsMouseEntered

    private void midpointBackLblBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_midpointBackLblBtnMouseExited
        // TODO add your handling code here:
        midpointBackLblBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackBtn.png"))); // NOI18N
    }//GEN-LAST:event_midpointBackLblBtnMouseExited

    private void midpointBackLblBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_midpointBackLblBtnMouseEntered
        // TODO add your handling code here:
        midpointBackLblBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackBtnenter.png"))); // NOI18N
    }//GEN-LAST:event_midpointBackLblBtnMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clearInputFields;
    private javax.swing.JLabel closingParenthesesLblBtn;
    private javax.swing.JLabel divideLblBtn;
    private javax.swing.JLabel exponentLblBtn;
    private javax.swing.JTextField functionInput;
    private javax.swing.JLabel generateFunctionLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel midpointBackLblBtn;
    private javax.swing.JLabel minusLblBtn;
    private javax.swing.JLabel multiplyLblBtn;
    private javax.swing.JLabel openingParenthesesLblBtn;
    private javax.swing.JLabel plusLblBtn;
    private javax.swing.JPanel userInputPanel;
    private javax.swing.JLabel xRaisedToLblBtn;
    // End of variables declaration//GEN-END:variables
}
