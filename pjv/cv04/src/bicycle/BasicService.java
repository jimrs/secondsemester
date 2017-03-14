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
public class BasicService {
    void accept(Bicycle bike) {
        System.out.println("Basically fixing bicycle.");
    }
    
    void accept(RoadBike bike) {
        System.out.println("Basically fixing road bike.");
    }
    
    void accept(MountainBike bike) {
        System.out.println("Basically fixing mountain bike.");
    }
}
