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
public class TestBikes {
    public static void main(String[] args) {
        Bicycle bike01, bike02, bike03;
 
        bike01 = new Bicycle(20, 10, 1);
        bike02 = new MountainBike(20, 10, 5, "Dual");
        bike03 = new RoadBike(40, 20, 8, 23);
 
        bike01.printDescription();
        bike02.printDescription();
        bike03.printDescription();
        
        BasicService bs = new BasicService();
        bike01.visit(bs);
        bike02.visit(bs);
        bike03.visit(bs);
        
        MountainBikeService ms = new MountainBikeService();
        bike01.visit(ms);
        bike02.visit(ms);
        bike03.visit(ms);
        
        RoadBikeService rs = new RoadBikeService();
        bike01.visit(rs);
        bike02.visit(rs);
        bike03.visit(rs);
    }
}
