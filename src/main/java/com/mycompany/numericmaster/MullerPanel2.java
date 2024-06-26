package com.mycompany.numericmaster;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import org.mariuszgromada.math.mxparser.*;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class MullerPanel2 extends javax.swing.JPanel {

    // Declare pointer to previous panel
    private JPanel pointerToPreviousPanel;
    
    // Declare the variable holding the function
    Function function;
    
    // Declare default table model variable for the table of iterations
    DefaultTableModel iterationsDTM;
    
    // Declare variable for iteration count
    Integer numberOfIterations;
        
    public MullerPanel2() {
        initComponents();
        
        // Initialize pointer to previous panel
        pointerToPreviousPanel = null;
        
        // Intantiate default table model for the iterations
        iterationsDTM = (DefaultTableModel) iterationsTable.getModel();
        
        // initially set row count of the table to zero 
        iterationsDTM.setRowCount(0);
        
        // initialize the number of iterations
        numberOfIterations = 0;
    }
    
    // sets the pointer to previous panel
    public void setPointerToPreviousPanel(JPanel panel) {
        pointerToPreviousPanel = panel;
    }
    
    public void displayFunction(String functionByUser) {

        // parse the user input into a function
        function = new Function("f", functionByUser, "x");
        
        // display the function 
        functionDisplayLbl.setText(function.getFunctionExpressionString());
    }
    
    // get the root using muller's method
    public double mullersMethod(Double x0, Double x1, Double x2, Integer decimal) {
  
        if ((Objects.equals(x0, x1)) || (Objects.equals(x0, x2)) || (Objects.equals(x1, x2))) {
            return Double.NaN; // Return NaN if inputs are not distinct
        }
        
        double firstInput = x0, secondInput = x1, thirdInput = x2;
        double firstOutput = function.calculate(x0), secondOutput = function.calculate(x1), thirdOutput = function.calculate(x2);
        double slope1 = (secondOutput - firstOutput) / (secondInput - firstInput);
        double slope2 = (thirdOutput - secondOutput) / (thirdInput - secondInput);
        double difference = (slope2 - slope1) / (thirdInput - firstInput);
        double sVariable = slope2 + difference * (thirdInput - secondInput);
        double sqrTest = (sVariable) * (sVariable) - 4 * difference * thirdOutput; 
        
         if (sqrTest <0){
            JOptionPane.showMessageDialog(null, "Input another initial guess","", JOptionPane.ERROR_MESSAGE);
            return Double.NaN;
        }
         
         
        double newInput = x2 - 2 * thirdOutput / (sVariable + Math.sqrt(sqrTest));
        double newOutput = function.calculate(newInput);
        
        while (Math.round(Math.abs(newOutput) * Math.pow(10, decimal)) / Math.pow(10, decimal) > 0) {
            numberOfIterations++;
            iterationsDTM.insertRow(iterationsDTM.getRowCount(), new Object[] {
                numberOfIterations,
                newInput,
                newOutput
                
            });
            return mullersMethod(secondInput, thirdInput, newInput, decimal);
            
        }
        
        numberOfIterations++;
        iterationsDTM.insertRow(iterationsDTM.getRowCount(), new Object[] {
            numberOfIterations,
            newInput,
            newOutput
        });
        
        iterationsTable.setRowSelectionInterval(numberOfIterations-1, numberOfIterations-1);
        return newInput;
    }
    
    // create graph of the function and display its roots
    public JPanel createChartPanel(double x0, double x1, double x2, int decimal) {
        XYSeries series = new XYSeries(function.getFunctionExpressionString());
        double[] domain = linspace(x0 - 1, x2 + 1, 100);

        for (double x : domain) {
            series.add(x, function.calculate(x));
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        // Create a series for the roots
        XYSeries rootSeries = new XYSeries("Roots");
        double root = mullersMethod(x0, x1, x2, decimal);
        rootSeries.add(root, function.calculate(root));

        dataset.addSeries(rootSeries);

        JFreeChart chart = ChartFactory.createXYLineChart(
                String.format("Graph of f(x) = %s", function.getFunctionExpressionString()),
                "x",
                "f(x)",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        plot.setRenderer(renderer);

        renderer.setSeriesShapesVisible(0, false);
        
        // Customize the renderer for the root points
        renderer.setSeriesShapesVisible(1, true);
        renderer.setSeriesLinesVisible(1, false);
        renderer.setSeriesShape(1, new java.awt.geom.Ellipse2D.Double(-3, -3, 6, 6));
        renderer.setSeriesPaint(1, Color.BLACK);

        // Set the range of the axes
        plot.getDomainAxis().setRange(root -1, root + 1);
        plot.getRangeAxis().setRange(function.calculate(root)-5, function.calculate(root) + 5);

        // Add annotations for the root points
        for (int i = 0; i < rootSeries.getItemCount(); i++) {
            double x = rootSeries.getX(i).doubleValue();
            double y = rootSeries.getY(i).doubleValue();
            XYTextAnnotation annotation = new XYTextAnnotation(String.format("(%.2f, %.2f)", x, y), x, y);
            annotation.setFont(new Font("SansSerif", Font.PLAIN, 9));
            plot.addAnnotation(annotation);
        }

        return new ChartPanel(chart);
    }
    
    // Generates an array of linearly spaced numbers
    public static double[] linspace(double start, double end, int num) {
        double[] result = new double[num];
        double step = (end - start) / (num - 1);
        for (int i = 0; i < num; i++) {
            result[i] = start + (step * i);
        }
        return result;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootDisplayPanel = new javax.swing.JPanel();
        functionDisplayLbl = new javax.swing.JLabel();
        x0Input = new javax.swing.JTextField();
        x1Input = new javax.swing.JTextField();
        x2Input = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        getRootLblBtn = new javax.swing.JLabel();
        rootDisplay = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        decimalInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        graphTablePanel = new javax.swing.JPanel();
        graphPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        iterationsTable = new javax.swing.JTable();
        mullerPanel2BackLblBtn = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rootDisplayPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        functionDisplayLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        functionDisplayLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        functionDisplayLbl.setText("Display Function");
        rootDisplayPanel.add(functionDisplayLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 468, -1));
        rootDisplayPanel.add(x0Input, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 100, 30));
        rootDisplayPanel.add(x1Input, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 100, 30));
        rootDisplayPanel.add(x2Input, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 100, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("x0 :");
        rootDisplayPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 30, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("x1 :");
        jLabel2.setToolTipText("");
        rootDisplayPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 30, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("x2:");
        rootDisplayPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 30, -1));

        getRootLblBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getRootLblBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GenerateFunctionRootBtnenter.png"))); // NOI18N
        getRootLblBtn.setToolTipText("");
        getRootLblBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                getRootLblBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                getRootLblBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                getRootLblBtnMousePressed(evt);
            }
        });
        rootDisplayPanel.add(getRootLblBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 398, 60));

        rootDisplay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rootDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rootDisplay.setText("Root");
        rootDisplayPanel.add(rootDisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 398, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Accurate by how many decimals?");
        rootDisplayPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 240, -1));

        decimalInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decimalInputActionPerformed(evt);
            }
        });
        rootDisplayPanel.add(decimalInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 170, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MULLERS PANEL2.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        rootDisplayPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 720));

        add(rootDisplayPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 720));

        graphTablePanel.setBackground(new java.awt.Color(255, 255, 255));
        graphTablePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        graphPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        graphTablePanel.add(graphPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 788, 340));

        iterationsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No.", "x value", "y value"
            }
        ));
        jScrollPane1.setViewportView(iterationsTable);

        graphTablePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 353, 788, 263));

        mullerPanel2BackLblBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackBtn.png"))); // NOI18N
        mullerPanel2BackLblBtn.setText("Back");
        mullerPanel2BackLblBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mullerPanel2BackLblBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mullerPanel2BackLblBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mullerPanel2BackLblBtnMousePressed(evt);
            }
        });
        graphTablePanel.add(mullerPanel2BackLblBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 670, 130, -1));

        add(graphTablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 800, 720));
    }// </editor-fold>//GEN-END:initComponents

    private void getRootLblBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getRootLblBtnMousePressed
        if (!Exhandling.emptyFieldsCheck(x0Input.getText(), x1Input.getText(), x2Input.getText(), decimalInput.getText())){
            return;
        }
        if (!Exhandling.doubleCheck(x0Input.getText(), x1Input.getText(), x2Input.getText(), decimalInput.getText())){
            return;
        }
        // resets the contents of the table
        iterationsDTM.setRowCount(0);
        numberOfIterations = 0;

        // calculate the root 
        rootDisplay.setText(String.valueOf(mullersMethod(Double.valueOf(x0Input.getText()), 
                Double.valueOf(x1Input.getText()), 
                Double.valueOf(x2Input.getText()), 
                Integer.valueOf(decimalInput.getText()))));
        
        // generate the graph and display it 
        graphPanel.add(createChartPanel(Double.parseDouble(x0Input.getText()), 
                Double.parseDouble(x1Input.getText()), 
                Double.parseDouble(x2Input.getText()), 
                Integer.parseInt(decimalInput.getText())), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 788, 340));
    }//GEN-LAST:event_getRootLblBtnMousePressed

    private void mullerPanel2BackLblBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mullerPanel2BackLblBtnMousePressed
        
        // clear the input fields
        x0Input.setText("");
        x1Input.setText("");
        x2Input.setText("");
        decimalInput.setText("");
        
        // clears the display label
        functionDisplayLbl.setText("");
        rootDisplay.setText("");
        
        // clears the table and the graph
        graphPanel.removeAll();
        iterationsDTM.setRowCount(0);
        
        // hides this panel and show the previous panel
        setVisible(false);
        pointerToPreviousPanel.setVisible(true);
    }//GEN-LAST:event_mullerPanel2BackLblBtnMousePressed

    private void decimalInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decimalInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_decimalInputActionPerformed

    private void getRootLblBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getRootLblBtnMouseExited
        // TODO add your handling code here:
       getRootLblBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GenerateFunctionRootBtnenter.png"))); // NOI18N
    }//GEN-LAST:event_getRootLblBtnMouseExited

    private void getRootLblBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getRootLblBtnMouseEntered
        // TODO add your handling code here:
        getRootLblBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GenerateFunctionRootBtn.png"))); // NOI18N
    }//GEN-LAST:event_getRootLblBtnMouseEntered

    private void mullerPanel2BackLblBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mullerPanel2BackLblBtnMouseExited
        // TODO add your handling code here:
        mullerPanel2BackLblBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackBtn.png"))); // NOI18N
    }//GEN-LAST:event_mullerPanel2BackLblBtnMouseExited

    private void mullerPanel2BackLblBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mullerPanel2BackLblBtnMouseEntered
        // TODO add your handling code here:
        mullerPanel2BackLblBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackBtnenter.png"))); // NOI18N
    }//GEN-LAST:event_mullerPanel2BackLblBtnMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField decimalInput;
    private javax.swing.JLabel functionDisplayLbl;
    private javax.swing.JLabel getRootLblBtn;
    private javax.swing.JPanel graphPanel;
    private javax.swing.JPanel graphTablePanel;
    private javax.swing.JTable iterationsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mullerPanel2BackLblBtn;
    private javax.swing.JLabel rootDisplay;
    private javax.swing.JPanel rootDisplayPanel;
    private javax.swing.JTextField x0Input;
    private javax.swing.JTextField x1Input;
    private javax.swing.JTextField x2Input;
    // End of variables declaration//GEN-END:variables
}
