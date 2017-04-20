package maresj29.engine;

public class Player extends Creature {
    private final String role;
    private int experience;
    private int mp;
    private int mpm;
    
    public Player(String name, String role, Dice dice) {
        super(name, 100, 10, 5, 1, dice);
        this.role = role;
        experience = 0;
        
        if (role.equalsIgnoreCase("warrior")) {
            super.setHp(150);
            super.setHpm(150);
            mp = 50;
            mpm = 50;
            super.setAttack(10);
            super.setDefense(10);
        } else if (role.equalsIgnoreCase("mage")) {
            super.setHp(50);
            super.setHpm(50);
            mp = 150;
            mpm = 150;
            super.setAttack(5);
            super.setDefense(2);
        } else {
            mp = 100;
            mpm = 100;
        }     
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
    
    public int getMp() {
        return mp;
    }
    
    public int getMpm() {
        return mpm;
    }
     
    public void setMp(int mp) {
        this.mp = mp;
    }

    public void setMpm(int mpm) {
        this.mpm = mpm;
    }
}
