/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicycle;

/**
 *
 * @author maresj29
 */
public class Bicycle {
    private int cadence;
    private int gear;
    private int speed;

    public Bicycle(int cadence, int speed, int gear) {
        this.cadence = cadence;       
        this.speed = speed;
        this.gear = gear;
    }
    
    public void printDescription() {
            System.out.println("Bike is in gear "+gear+" with a cadence of "+cadence+" and travelling at a speed of "+speed+".");
    }
    
    public void visit(BasicService bs) {
        bs.accept(this);
    }
}
