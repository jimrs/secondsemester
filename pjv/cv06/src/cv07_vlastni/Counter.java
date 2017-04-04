/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv07_vlastni;

import javax.swing.JFrame;

/**
 *
 * @author maresj29
 */
public class Counter {
    public static void main(String[] args) {
        Gui window = new Gui();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setSize(500, 75);
        //window.pack();  //dynamicky meni velikost okna podle prvku
        window.setLocationRelativeTo(null);     //okno se zobrazi uprostred obrazovky      
    }
}
