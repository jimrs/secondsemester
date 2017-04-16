package maresj29.engine;

import java.util.Random;

public class Dice {
    private int sides;
    private Random random;
    
    public Dice() {
        sides = 10;
        random = new Random();
    }
    
    public Dice(int num) {
        sides = num;
        random = new Random();
    }
    
    public int getSides() {
        return sides;
    }
    
    public void setSides(int num) {
        sides = num;
    }
    
    @Override
    public String toString() {
        return String.format("Dice of %s sides.", sides);
    }
    
    public int throwDice() {
        return random.nextInt(sides) + 1;
    }
    
    public String throwString() {
        return String.format("Dice throw of %s sides yields the number %s.", 
                sides, throwDice());
    }
}
