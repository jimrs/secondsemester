package cz.cvut.fel.pjv.bounce;

import java.util.logging.Level;
import java.util.logging.Logger;

// NEBO ma byt private static? a v run dat to co potrebuju
class MyThread extends Thread {
    @Override
            public void run() {
            }
}

public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        Model model = new Model();
        View view = new View(model);
        model.addObserver(view);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 200; i++) {
                    model.setxPosition(i);
                    model.setyPosition(i);
                    model.setRadius(i);
                    model.notifyObservers(view);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        thread.start();

        // NEBO
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 200; i++) {
                    model.setxPosition(i);
                    model.setyPosition(i);
                    model.setRadius(i);
                    model.notifyObservers(view);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        thread2.start();
        
        // 3rd option
        MyThread thread3 = new MyThread();
        thread3.start();
    }
}
