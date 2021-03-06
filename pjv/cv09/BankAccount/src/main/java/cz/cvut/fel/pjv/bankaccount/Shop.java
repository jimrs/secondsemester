package cz.cvut.fel.pjv.bankaccount;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Shop {

    List<Person> customers;
    double[] bills;
    ArrayList<Thread> threads;

    public Shop(List<Person> customers, double[] bills) {
        this.customers = customers;
        this.bills = bills;
        this.threads = new ArrayList<Thread>();
    }

    public void makeCustomersPayBills() throws InterruptedException {
        for (Person customer : customers) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (double payment : bills) {
                            customer.removeAmountFromBankAccount(payment);
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
