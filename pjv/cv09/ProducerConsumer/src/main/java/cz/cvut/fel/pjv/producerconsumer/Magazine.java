/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fel.pjv.producerconsumer;

import java.util.LinkedList;

/**
 *
 * @author maresj29
 */
public class Magazine implements Stack {
    private LinkedList<String> items;
    
    public Magazine() {
        items = new LinkedList<String>();
    }

    @Override
    public void add(String word) {
        items.push(word);
    }

    @Override
    public String pop() throws StackEmptyException {
        if (!isEmpty())
            return items.pop();
        else
            throw new StackEmptyException();
    }

    @Override
    public boolean isEmpty() {
        String e = items.peek();
        if (e == null)
            return true;
        else
            return false;
    }
    
}
