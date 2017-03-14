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
public class MountainBikeService extends BasicService {
    @Override
    void accept(Bicycle bike) {
        System.out.println("MTB fixing bycicle.");
    }
    
    @Override
    void accept(MountainBike bike) {
        System.out.println("MTB fixing mountain bike.");
    }
    
    @Override
    void accept(RoadBike bike) {
        System.out.println("MTB fixing road bike.");
    }
}
