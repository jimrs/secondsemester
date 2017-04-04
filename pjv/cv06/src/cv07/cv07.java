/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv07;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author maresj29
 */
public class cv07 {
    static int num = 0;
    
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("TopLevelDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//        JMenuBar greenMenuBar = new JMenuBar();
//        greenMenuBar.setOpaque(true);
//        greenMenuBar.setBackground(Color.green);
//        greenMenuBar.setPreferredSize(new Dimension(200, 20));
//        greenMenuBar.add(new JMenu("File"))
//                .add(new JMenuItem("new"))
//                .addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("new file");
//            }
//        });
//        
//        frame.setJMenuBar(greenMenuBar);
//
//        
//        JPanel panel = new JPanel();
//        
//        JButton button = new JButton("action");       
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                num++;
//                System.out.println(num);
//            }
//        });
//        
//        panel.add(button);
//        
//        frame.getContentPane().add(panel, BorderLayout.NORTH);

        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JLabel label = new JLabel("meme");
        
        button2.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String input = JOptionPane.showInputDialog("Insert text:");
               label.setText(input);
          }
       });
        
        frame.getContentPane().add(label, BorderLayout.CENTER);
        //frame.getContentPane().add(button2, BorderLayout.LINE_END);
        //frame.getContentPane().add(button3, BorderLayout.LINE_START);
        
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(button2);
        panel.add(button3);
        frame.getContentPane().add(panel, BorderLayout.PAGE_START);

        // display window
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500,300);
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });     //takto se implementuje anonymni trida
    }
}
