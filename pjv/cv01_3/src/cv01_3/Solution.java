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
public class Solution {
    private int[] getInput() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Vlozte prvni cislo:");
        int no1 = sc.nextInt();
        System.out.println("Vlozte druhe cislo:");
        int no2 = sc.nextInt();
        
        int[] result = {no1, no2};
        return result;
    }
    
    private void printShit(int no1, int no2) {
        int soucet = no1 + no2;
        int rozdil = no1 - no2;
        int soucin = no1 * no2;
        float podil = (float) no1 / no2;
        
        System.out.println("Soucet: " + soucet);
        System.out.println("Rozdil: " + rozdil);
        System.out.println("Soucin: " + soucin);
        System.out.println("Podil: " + podil);
    }
    
    public void doShit() {
        int[] input = getInput();
        printShit(input[0], input[1]);
    }
}
