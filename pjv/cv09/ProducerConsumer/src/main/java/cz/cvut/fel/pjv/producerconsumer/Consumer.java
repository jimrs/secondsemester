package cz.cvut.fel.pjv.producerconsumer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer extends Thread {

    private final Stack stack;

    public Consumer(Stack stack, String name) {
        setName(name);
        this.stack = stack;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                String word = stack.pop();
                System.out.println(getName() + " :" + word);
            }
        } catch (StackEmptyException ex) {
            System.out.println(getName() + " stack is empty, finishing.");
        }
    }

}
