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
public class ContactList {
    ArrayList<Contact> contacts;
    
    public ContactList() {
        contacts = new ArrayList();
    }
    
    public void addContact(Contact c) {
        contacts.add(c);
    }
    
    @Override
    public String toString() {
        String ret = contacts.toString();
        return ret;
    }
}
