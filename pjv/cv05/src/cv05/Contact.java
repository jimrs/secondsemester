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
    public String jmeno;
    public String telefon;
    public String adresa;
    
    public Contact() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Name:");
            if (!(this.jmeno = sc.nextLine()).matches("[A-Z]{1}[a-z]+[\\s]{1}[A-Z]{1}[a-z]+")) {
                throw new IllegalArgumentException("Wrong name!");
            }
            System.out.println("Phone:");
            if (!(this.telefon = sc.nextLine()).matches("[0-9]{9}")) {
                throw new IllegalArgumentException("Wrong phone!");
            }
            System.out.println("[A-Z]{1}.+");
            if (!(this.adresa = sc.nextLine()).matches("[A-Z]{1}[a-z]+[\\s]{1}[A-Z]{1}[a-z]+")) {
                throw new IllegalArgumentException("Wrong address!");
            }
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
        return this.telefon.compareTo(c.telefon);
    }
}
