/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv07_vlastni;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author maresj29
 */
public class Gui extends JFrame {
    private JLabel label;
    private int result;
    private JButton plus;
    private JButton reset;
    private JButton input;
    private JButton exit;
    private JPanel panel1;
    private JPanel panel2;
    
    public Gui() {
        super("Window title");
        FlowLayout lay = new FlowLayout();
        setLayout(lay);
        
        panel1 = new JPanel();
        add(panel1);
        
        panel2 = new JPanel();
        add(panel2);
        
        result = 0;
        label = new JLabel(Integer.toString(result));
        panel2.add(label);
        
        plus = new JButton("Increase");
        panel1.add(plus);
        plus.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    result++;
                    label.setText(Integer.toString(result));
                }
            });
        
        input = new JButton("Input number");
        panel1.add(input);
        input.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String tmp = JOptionPane.showInputDialog("Insert a positive integer:");
                    try {
                        result = Integer.parseInt(tmp);
                    } catch (NumberFormatException err) {
                        JOptionPane.showMessageDialog(null, "Wrong input!", "FATAL ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    label.setText(Integer.toString(result));
                }
            });
        
        reset = new JButton("Reset");
        panel1.add(reset);
        reset.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    result = 0;
                    label.setText(Integer.toString(result));
                    JOptionPane.showMessageDialog(null, "Counter has been reset!", "Message", JOptionPane.WARNING_MESSAGE);
                }
            });
        
        exit = new JButton("Exit");
        panel1.add(exit);
        exit.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
        
    }
}
