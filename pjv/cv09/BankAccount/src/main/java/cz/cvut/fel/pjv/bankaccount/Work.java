package cz.cvut.fel.pjv.bankaccount;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Work {

    private List<Person> employees;
    private double[] payments;

    public Work(List<Person> employees, double[] payments) {
        this.employees = employees;
        this.payments = payments;
    }

    public void payPayments() throws InterruptedException {
        //for (Person employee : employees) {
            for (double payment : payments) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            for (Person employee : employees) {
                                //for (double payment : payments) {
                                    employee.addAmountToBankAccount(payment);
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