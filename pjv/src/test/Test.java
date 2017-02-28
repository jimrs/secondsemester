/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author jakub
 */
public class Test {

    private static int[] getRangeBoundaries(Scanner reader) {
        System.out.println("Enter first number of interval:");
        int n1 = reader.nextInt();
        System.out.println("Enter second number of interval:");
        int n2 = reader.nextInt();
        int[] result = {n1, n2};
        return result;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("How many ranges do you want to generate?");
        int rangeCount = reader.nextInt();
        for (int i = 0; i < rangeCount; ++i) {
            System.out.println(String.format("Range %s:", i + 1));
            int[] input = getRangeBoundaries(reader);
            RangeCreator t = new RangeCreator(input[0], input[1]);
            int[] range = t.getRange();
            System.out.println(Arrays.toString(range));
        }
    }
}
