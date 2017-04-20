package cz.cvut.fel.pjv.bankaccount;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Shop {

    List<Person> customers;
    double[] bills;

    public Shop(List<Person> customers, double[] bills) {
        this.customers = customers;
        this.bills = bills;
    }

    public void makeCustomersPayBills() throws InterruptedException {
        //for (Person customer : customers) {
            for (double payment : bills) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            for (Person customer : customers) {
                                //for (double payment : bills) {
                                    customer.removeAmountFromBankAccount(payment);
                                //}
                            }
                        } catch (InterruptedException ex) {
                            ex.getStackTrace();
                        }
                    }
                });
                thread.start();
            }
        //}
    }

}
