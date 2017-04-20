package cz.cvut.fel.pjv.producerconsumer;

/**
 *
 * @author jakub
 */
public class StackEmptyException extends Exception {

    public StackEmptyException() {
    }

    public StackEmptyException(String message) {
        super(message);
    }

    public StackEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}
