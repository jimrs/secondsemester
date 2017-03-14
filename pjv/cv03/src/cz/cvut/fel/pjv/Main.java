/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fel.pjv;

import cz.cvut.fel.pjv.cars.model.Car;

/**
 *
 * @author maresj29
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Car car1 = new Car("Volkswagen", "Polo", 2010, "AKK");
        System.out.println(car1);
        System.out.println("Počet aut: " + Car.getNumberOfExistingCars());
        Car car2 = new Car("Chevrolet", "Corvette", 1980, "LS7");
        System.out.println(car2);
        System.out.println("Počet aut: " + Car.getNumberOfExistingCars());
        
        if (car1 == car1)
            System.out.println("Car1 = Car1");
        else
            System.out.println("Car1 =/= Car1");
        
        System.out.println("Car1 hash: " + car1.hashCode());
        System.out.println("Car2 hash: " + car2.hashCode());
    }
    
}
