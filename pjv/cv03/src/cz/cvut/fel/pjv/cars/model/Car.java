/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fel.pjv.cars.model;

import java.util.UUID;

/**
 *
 * @author maresj29
 */
public class Car {

    String manufacturer, modelName;
    int year;
    UUID vinCode;
    static int numberOfCars = 0;
    Engine engine;

    public Car(String manufacturer, String modelName, int year, String engine) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.year = year;
        this.vinCode = UUID.randomUUID();
        this.engine = new Engine(engine);
        numberOfCars++;
    }

    @Override
    public String toString() {
        return manufacturer + " " + modelName + " year " + year + " engine " + engine.toString() + " VIN: " + vinCode + ".";
    }

    public static int getNumberOfExistingCars() {
        return numberOfCars;
    }

    public boolean equals(Car car) {
        return this.vinCode == car.vinCode;
    }
}

class Engine {

    String type;

    public Engine(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

    public boolean equals(Engine engine) {
        return this.type == engine.type;
    }
}
