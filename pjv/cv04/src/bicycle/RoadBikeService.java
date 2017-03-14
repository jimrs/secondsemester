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
public class RoadBikeService extends BasicService {
    @Override
    void accept(Bicycle bike) {
        System.out.println("RBK fixing bycicle.");
    }
    
    @Override
    void accept(MountainBike bike) {
        System.out.println("RBK fixing mountain bike.");
    }
    
    @Override
    void accept(RoadBike bike) {
        System.out.println("RBK fixing road bike.");
    }
}
