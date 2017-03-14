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
public class RoadBike extends Bicycle {
    int tireWidth;
    
    public RoadBike(int cadence, int speed, int gear, int tireWidth) {
        super(cadence, speed, gear);
        this.tireWidth = tireWidth;
    }

    @Override
    public void printDescription() {
        super.printDescription(); 
        System.out.println("Tire width is: "+tireWidth);
    }
    
    @Override
    public void visit(BasicService bs) {
        bs.accept(this);
    }
}
