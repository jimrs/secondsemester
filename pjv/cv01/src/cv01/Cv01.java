/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv01;

import java.util.Scanner;

/**
 *
 * @author maresj29
 */
public class Cv01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("yo");
        
        // nekde v programu - POZOR, scanner vytvarime pouze jednou!
        Scanner sc = new Scanner(System.in);
        System.out.println("Vlozte cele cislo:");
        int cislo = sc.nextInt();
        System.out.println("Vlozte desetinne cislo:");
        float d = sc.nextFloat();
        System.out.println("Vlozte slovo:");
        String s = sc.next();
        System.out.println("Vlozte radek:");
        String r = sc.nextLine();
        System.out.println(r);
        
        
        System.out.println("Vlozte sve jmeno:");
        String jmeno = sc.nextLine();
        System.out.println("Ahoj, " + jmeno);
    }
    
}
