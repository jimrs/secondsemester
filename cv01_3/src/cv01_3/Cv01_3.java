/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv01_3;

import java.util.Scanner;

/**
 *
 * @author maresj29
 */
public class Cv01_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Cv01_3 test = new Cv01_3();     //instance tridy
        //test.ukol1();                   //kdyz k ukol1 pridam static
                                        //lze pak psat primo ukol1();
                                        
        //Solution sol = new Solution();  //objektove
        //sol.doShit();
        
        int[] pole = fillArray(2, 4);
        
        for (int i = 0; i < pole.length; i++) {
            int j = pole[i];
            System.out.println(j);
        }
    }
    
    public void ukol1() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Vlozte prvni cislo:");
        int no1 = sc.nextInt();
        System.out.println("Vlozte druhe cislo:");
        int no2 = sc.nextInt();
        
        int soucet = no1 + no2;
        int rozdil = no1 - no2;
        int soucin = no1 * no2;
        float podil = (float) no1 / no2;
        
        System.out.println("Soucet: " + soucet);
        System.out.println("Rozdil: " + rozdil);
        System.out.println("Soucin: " + soucin);
        System.out.println("Podil: " + podil);
        
    }
    
    public static int[] fillArray(int a, int b) {
        int[] pole;
        pole = new int[b];
        
        for (int i = 0; a <= b; i++) {
            pole[i] = a++;
        }
        
        return pole;
    }
}
