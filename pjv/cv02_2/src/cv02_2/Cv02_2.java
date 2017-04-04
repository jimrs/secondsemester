/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv02_2;
import java.util.Scanner;

/**
 *
 * @author maresj29
 */
public class Cv02_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //circle(5);
        //System.out.println(day(8));
        readNumbers();
    }
    
    static void circle(int r) {
        double obvod = 2 * Math.PI * r;
        double obsah = Math.PI * (r*r);
        
        System.out.printf("Obvod je: %.3fcm\n", obvod);
        System.out.printf("Obsah je: %.3fcm\n", obsah);
    }
    
    static String day(int daynum) {
        String daystring = null;
        
        switch (daynum) {
            case 1: return "Monday";
            case 2: return "Tuesday";
            case 3: return "Wednesday";
            case 4: return "Thursday";
            case 5: return "Friday";
            case 6: return "Saturday";
            case 7: return "Sunday";
        }
        
        return daystring;
    }
    
    static void readNumbers() {
        Scanner sc = new Scanner(System.in);
        int input;
        float average = 0;
        int n = 0;
        
        while (true) {
            input = sc.nextInt();
            n++;
            
            if (input == 0) {
                if (average == 0) {
                    System.out.println("Unable to find average");
                    return;
                }    
                System.out.println(average);
                return;
            }         
            average -= average/n;
            average += input/n;          
        }
    }
}
