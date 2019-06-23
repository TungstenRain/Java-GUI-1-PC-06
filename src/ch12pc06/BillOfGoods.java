package ch12pc06;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Frank
 * 
 * Outer class
 */
public class BillOfGoods extends JFrame {
    //fields
    private final int width = 450;
    private final int height = 450;
    private JPanel panel;
    private JLabel lblPartsAndLabor, lblHours, lblTotal;
    private JCheckBox chkOil, chkLube, chkRadiator, chkTransmission, chkInspection, chkMuffler, chkRotation;
    private JButton btnCalculate;
    private JTextField txtHours, txtTotal;
    
    //constructor
    public BillOfGoods() {
        this.setTitle("Joe's Automotive");
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        this.add(panel);
        this.setVisible(true);
    }
    
    //methods
    private void buildPanel() {
        panel = new JPanel();
        chkOil = new JCheckBox("Oil Change - $26.00", false);
        chkLube = new JCheckBox("Lube Job - $18.00", false);
        chkRadiator = new JCheckBox("Radiator Flush - $30.00", false);
        chkTransmission = new JCheckBox("Transmission Flush - $80.00", false);
        chkInspection = new JCheckBox("Inspection - $15.00", false);
        chkMuffler = new JCheckBox("Muffler Replacement - $100.00", false);
        chkRotation = new JCheckBox("Tire Rotation - $20.00", false);
        
        lblPartsAndLabor = new JLabel("Parts and Labor $20 per hour.");
        lblHours = new JLabel("Hours worked.");
        lblTotal = new JLabel("The total cost is: ");
        txtHours = new JTextField(15);
        txtTotal = new JTextField(15);
        btnCalculate = new JButton("Calculate bill.");
        
        btnCalculate.addActionListener(new btnCalculateListener());
        
        //add to panel
        
        panel.add(chkOil);
        panel.add(chkLube);
        panel.add(chkRadiator);
        panel.add(chkTransmission);
        panel.add(chkInspection);
        panel.add(chkMuffler);
        panel.add(chkRotation);
        panel.add(lblPartsAndLabor);
        panel.add(lblHours);
        panel.add(txtHours);
        panel.add(btnCalculate);
        panel.add(lblTotal);
        panel.add(txtTotal);
    }
    
    //inner class
    private class btnCalculateListener implements ActionListener {
        private final double payRate = 20.0;
        
        @Override
        public void actionPerformed (ActionEvent e) {
            double sum = 0.0;
            double hours, pay;
            
            if (chkOil.isSelected())
                sum += 26;
            if (chkLube.isSelected())
                sum += 18;
            if (chkRadiator.isSelected())
                sum += 30;
            if (chkTransmission.isSelected())
                sum += 80;
            if (chkInspection.isSelected())
                sum += 15;
            if (chkMuffler.isSelected())
                sum += 100;
            if (chkRotation.isSelected())
                sum += 20;
            
            if (!txtHours.getText().equals("")) {
                hours = Double.parseDouble(txtHours.getText());
                pay = hours * payRate;
                sum += pay;
            }
            
            txtTotal.setText(Double.toString(sum));
        }
    }
}
