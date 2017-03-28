/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv05;

import java.util.Collections;

/**
 *
 * @author maresj29
 */
public class Cv05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Contact c1 = new Contact("David Ngujen", "123456790", "Praha");
        Contact c2 = new Contact("Lazar Ferko", "123456789", "Cheb");
        Contact c3 = new Contact("Bohuslav Sabadin", "000222555", "Karlovy Vary");
        //Contact c4 = new Contact();
        ContactList cl = new ContactList();
        cl.addContact(c1);
        cl.addContact(c2);
        cl.addContact(c3);
        //cl.addContact(c4);
        System.out.println(cl);
        Collections.sort(cl.contacts);
        System.out.println(cl);
        Collections.sort(cl.contacts, cl);
        System.out.println(cl);
    }
    
}
