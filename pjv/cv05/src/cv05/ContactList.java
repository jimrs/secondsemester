/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv05;
import java.util.*;
/**
 *
 * @author maresj29
 */
public class ContactList implements Comparator {
    ArrayList<Contact> contacts;
    
    public ContactList() {
        contacts = new ArrayList<>();
    }
    
    public void addContact(Contact c) {
        contacts.add(c);
    }
    
    @Override
    public String toString() {
        String ret = contacts.toString();
        return ret;
    }
    
    @Override
    public int compare(Object o1, Object o2) {
        Contact c1 = (Contact)o1;
        Contact c2 = (Contact)o2;
        
        return c1.adresa.compareTo(c2.adresa);
    }
}
