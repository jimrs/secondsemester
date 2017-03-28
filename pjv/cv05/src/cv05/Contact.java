/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv05;
import java.util.Scanner;

/**
 *
 * @author maresj29
 */
public class Contact implements Comparable {
    private String jmeno;
    private String telefon;
    private String adresa;
    
    public Contact() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Name:");
            this.jmeno = sc.nextLine();
            System.out.println("Phone:");
            this.telefon = sc.nextLine();
            System.out.println("Address:");
            this.adresa = sc.nextLine();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Contact(String jmeno, String telefon, String adresa) {
        if (!jmeno.matches("[A-Z]{1}[a-z]+[\\s]{1}[A-Z]{1}[a-z]+")) {
            throw new IllegalArgumentException("Wrong name!");
        }
        if (!telefon.matches("[0-9]{9}")) {
            throw new IllegalArgumentException("Wrong phone!");
        }
        if (!adresa.matches("[A-Z]{1}.+")) {
            throw new IllegalArgumentException("Wrong address!");
        }
        this.jmeno = jmeno;
        this.telefon = telefon;
        this.adresa = adresa;       
    }
    
    @Override
    public String toString() {
        return "("+jmeno+", "+telefon+", "+adresa+")";
    }
    
    @Override
    public int compareTo(Object o) {
        Contact c = (Contact)o;
        
        if (this.telefon.compareTo(c.telefon) == 0)
            return 0;
        if (this.telefon.compareTo(c.telefon) < 0)
            return -1;
        else
            return 1;
    }
}
