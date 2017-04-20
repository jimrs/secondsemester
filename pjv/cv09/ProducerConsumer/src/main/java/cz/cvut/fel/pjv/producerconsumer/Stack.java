package cz.cvut.fel.pjv.producerconsumer;

public interface Stack {

    public void add(String word);

    public String pop() throws StackEmptyException;

    public boolean isEmpty();
}
