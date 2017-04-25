package cz.cvut.fel.pjv.bankaccount;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Work {

    private List<Person> employees;
    private double[] payments;
    ArrayList<Thread> threads;

    public Work(List<Person> employees, double[] payments) {
        this.employees = employees;
        this.payments = payments;
        this.threads = new ArrayList<Thread>();
    }

    public void payPayments() throws InterruptedException {
        for (Person employee : employees) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (double payment : payments) {
                            employee.addAmountToBankAccount(payment);
                        }
                    } catch (InterruptedException ex) {
                        ex.getStackTrace();
                    }
                }
            });
            thread.start();
            threads.add(thread);
        }
        
        for (Thread thread : threads) {
            thread.join();
        }
    }

}
