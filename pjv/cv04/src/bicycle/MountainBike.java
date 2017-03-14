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
public class MountainBike extends Bicycle {
    String suspension;

    public MountainBike(int cadence, int speed, int gear, String suspension) {
        super(cadence, speed, gear);
        this.suspension = suspension;
    }

    @Override
    public void printDescription() {
        super.printDescription();
        System.out.println("Suspension is : "+suspension);
    }
    
    @Override
    public void visit(BasicService bs) {
        bs.accept(this);
    }
}
