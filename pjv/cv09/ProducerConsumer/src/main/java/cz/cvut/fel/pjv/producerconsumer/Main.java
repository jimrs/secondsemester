package cz.cvut.fel.pjv.producerconsumer;

import java.io.File;
import java.io.FilenameFilter;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static final AtomicInteger wordCount = new AtomicInteger(0);
    public static final AtomicInteger poppedCount = new AtomicInteger(0);

    public static void main(String[] args) {
        for (int c = 0; c < 100; c++) {

            Stack stack = new Magazine();

            //inicialize producers
            Producent[] producentArray = inicializeProducers(stack);

            //inicialize consuments
            Consumer[] consumentsArray = inicializeConsuments(stack);

            waitForProducents(producentArray);

            waitForConsuments(stack);

            //Interrupt consumers
            for (int i = 0; i < consumentsArray.length; i++) {
                consumentsArray[i].interrupt();
            }
        }
        System.out.println(wordCount.get() + " / " + poppedCount.get());
    }

    private static Producent[] inicializeProducers(Stack stack) {
        File[] files = new File(".").listFiles(txtFilter);
        Producent[] producentArray = new Producent[files.length];
        for (int i = 0; i < producentArray.length; i++) {
            Producent producent = new Producent(files[i], stack);
            producentArray[i] = producent;
            producent.start();
        }
        return producentArray;
    }

    private static Consumer[] inicializeConsuments(Stack stack) {
        int countOfConsuments = 2;
        Consumer[] consumentsArray = new Consumer[countOfConsuments];
        for (int i = 0; i < consumentsArray.length; i++) {
            Consumer consument = new Consumer(stack, "cosument_" + i);
            consumentsArray[i] = consument;
            consument.start();
        }
        return consumentsArray;
    }

    private static void waitForProducents(Producent[] producents) {
        for (int i = 0; i < producents.length; i++) {
            try {
                producents[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void waitForConsuments(Stack stack) {
        while (!stack.isEmpty()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static FilenameFilter txtFilter = new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(".txt");
        }
    };

}
