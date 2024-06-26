/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.numericmaster;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYShapeAnnotation;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.mariuszgromada.math.mxparser.Function;

/**
 *
 * @author User
 */
public class MidpointPanel2 extends javax.swing.JPanel {

    // Declare the variable holding the function
    Function function;
    
    // Declare pointer to previous panel
    JPanel pointerToPreviousPanel;
        
    public MidpointPanel2() {
        initComponents();
        
        // initialize pointer to previous panel
        pointerToPreviousPanel = null;
        
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

    // compute the area using midpoint rule
    public void midpointRule(Double lowerLimit, Double upperLimit, Integer segments) {
        double sumOfHeight = 0;
        double width = (upperLimit - lowerLimit) / segments;
        double midpoint = width / 2;

        for (int i = 0; i < segments; i++) {
            sumOfHeight += function.calculate(lowerLimit + midpoint + i * width);
        }

        double area = sumOfHeight * width;
        
        // display the area
        areaDisplay.setText(String.valueOf(area));
    }
    
    // Creates a JPanel containing a chart of the function and its rectangular approximation.
    public JPanel createChartPanel(double lowerLimit, double upperLimit, int segments) {
        XYSeries series = new XYSeries(function.getFunctionExpressionString());

        // Generate domain points
        double[] domain = linspace(lowerLimit - 1, upperLimit + 1, 100);
        
        // Add function values to series
        for (double x : domain) {
            series.add(x, function.calculate(x));
        }
        
        // Calculate width and midpoint
        double width = (upperLimit - lowerLimit) / segments;
        double midpoint = width / 2;
        double iteration = midpoint + lowerLimit;

        // Add rectangular approximation points to series
        for (int i = 0; i < segments; i++) {
            double y = function.calculate(iteration);
            series.add(iteration, y);

            iteration += width;
        }

        // Create dataset and chart
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

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

        // Customize plot and renderer
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);  // Hide lines
        renderer.setSeriesShapesVisible(0, false); // Show shapes only
        
        plot.setRenderer(renderer);

        // Add annotations for rectangular approximation
        iteration = midpoint + lowerLimit;        
        double base = lowerLimit;

        for (int i = 0; i < segments; i++) {
            double y = function.calculate(iteration);
            double x = iteration;

            Rectangle2D rect = new Rectangle2D.Double(x - width / 2, Math.min(0, y), width, Math.abs(y));
            plot.addAnnotation(new XYShapeAnnotation(rect, new BasicStroke(1.0f), Color.green, new Color(0, 255, 0, 100)));

            plot.addAnnotation(new XYTextAnnotation(String.format("%.2f", y*width), x, y / 2.0));
            iteration += width;
            base += width;
        }

        // Return the chart panel
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

        functionDisplayLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        upperLimitInput = new javax.swing.JTextField();
        lowerLimitInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        segmentsInput = new javax.swing.JTextField();
        areaDisplay = new javax.swing.JLabel();
        getAreaLblBtn = new javax.swing.JLabel();
        midpointPanel2BackLblBtn = new javax.swing.JLabel();
        graphPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        functionDisplayLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        functionDisplayLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        functionDisplayLbl.setText("Display Function");
        add(functionDisplayLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 60, 404, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Input Intervals:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 150, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Upper Limit:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 160, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Lower Limit:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 160, -1));
        add(upperLimitInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 172, 160, 30));
        add(lowerLimitInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 222, 160, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Input Segments:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 130, -1));

        segmentsInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                segmentsInputActionPerformed(evt);
            }
        });
        add(segmentsInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 326, -1));

        areaDisplay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        areaDisplay.setForeground(new java.awt.Color(255, 255, 255));
        areaDisplay.setText("Area");
        add(areaDisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 220, -1));

        getAreaLblBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GenerateFunctionAreaBtn.png"))); // NOI18N
        getAreaLblBtn.setText("Generate Area");
        getAreaLblBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                getAreaLblBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                getAreaLblBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                getAreaLblBtnMousePressed(evt);
            }
        });
        add(getAreaLblBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 190, -1));

        midpointPanel2BackLblBtn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        midpointPanel2BackLblBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackBtn.png"))); // NOI18N
        midpointPanel2BackLblBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                midpointPanel2BackLblBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                midpointPanel2BackLblBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                midpointPanel2BackLblBtnMousePressed(evt);
            }
        });
        add(midpointPanel2BackLblBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 660, 190, -1));

        graphPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(graphPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 840, 700));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MIDPOINT PANEL2.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jLabel5.setPreferredSize(new java.awt.Dimension(451, 680));
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 410, 720));
    }// </editor-fold>//GEN-END:initComponents

    private void getAreaLblBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getAreaLblBtnMousePressed
        if (!Exhandling.emptyFieldsCheck(upperLimitInput.getText(), lowerLimitInput.getText(), segmentsInput.getText())){
            return;
        }
        if (!Exhandling.doubleCheck(upperLimitInput.getText(), lowerLimitInput.getText(), segmentsInput.getText())){
            return;
        }
        // calculate the area based on the given input
        midpointRule(Double.valueOf(lowerLimitInput.getText()), 
                Double.valueOf(upperLimitInput.getText()), 
                Integer.valueOf(segmentsInput.getText()));
        
        // generate the graph and display it on the panel
        graphPanel.add(createChartPanel(Double.parseDouble(lowerLimitInput.getText()),
                Double.parseDouble(upperLimitInput.getText()), 
                Integer.parseInt(segmentsInput.getText())), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 700));
    }//GEN-LAST:event_getAreaLblBtnMousePressed

    private void midpointPanel2BackLblBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_midpointPanel2BackLblBtnMousePressed
        
        // clear the input fields
        upperLimitInput.setText("");
        lowerLimitInput.setText("");
        segmentsInput.setText("");
        
        // clears the display label
        functionDisplayLbl.setText("");
        areaDisplay.setText("");
        
        // clears the graph
        graphPanel.removeAll();

// hides this panel and show the previous panel
        setVisible(false);
        pointerToPreviousPanel.setVisible(true);
    }//GEN-LAST:event_midpointPanel2BackLblBtnMousePressed

    private void segmentsInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_segmentsInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_segmentsInputActionPerformed

    private void getAreaLblBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getAreaLblBtnMouseExited
        // TODO add your handling code here:
        getAreaLblBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GenerateFunctionAreaBtnenter.png"))); // NOI18N

    }//GEN-LAST:event_getAreaLblBtnMouseExited

    private void getAreaLblBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getAreaLblBtnMouseEntered
        // TODO add your handling code here:
        getAreaLblBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GenerateFunctionAreaBtn.png"))); // NOI18N
    }//GEN-LAST:event_getAreaLblBtnMouseEntered

    private void midpointPanel2BackLblBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_midpointPanel2BackLblBtnMouseExited
        // TODO add your handling code here:
        midpointPanel2BackLblBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackBtn.png"))); // NOI18N
    }//GEN-LAST:event_midpointPanel2BackLblBtnMouseExited

    private void midpointPanel2BackLblBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_midpointPanel2BackLblBtnMouseEntered
        // TODO add your handling code here:
        midpointPanel2BackLblBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackBtnenter.png"))); // NOI18N
    }//GEN-LAST:event_midpointPanel2BackLblBtnMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel areaDisplay;
    private javax.swing.JLabel functionDisplayLbl;
    private javax.swing.JLabel getAreaLblBtn;
    private javax.swing.JPanel graphPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField lowerLimitInput;
    private javax.swing.JLabel midpointPanel2BackLblBtn;
    private javax.swing.JTextField segmentsInput;
    private javax.swing.JTextField upperLimitInput;
    // End of variables declaration//GEN-END:variables
}
