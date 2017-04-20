package maresj29.engine;

public class Creature {
    private String name;
    private int hp;
    private int hpm;
    private int attack;
    private int defense;
    private int level;
    private Dice dice;
    private String status;

    public Creature(String name, int hp, int atk, int def, int lvl, Dice dice) {
        this.name = name;
        hpm = hp;
        this.hp = hp;
        attack = atk;
        defense = def;
        level = lvl;
        this.dice = dice;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getHpm() {
        return hpm;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public Dice getDice() {
        return dice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
  
    public void setHpm(int hpm) {
        this.hpm = hpm;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isAlive() {
        return getHp() > 0;
    }

    private void setStatus(String status) {
        this.status = status;
    }
    
    public String getStatus() {
        return status;
    }

    public void takeDamage(int dmg) {
        String msg;
        dmg -= (defense + dice.throwDice());
        if (dmg > 0) {
            setHp( (hp - dmg));
            msg = String.format("%s takes %s damage!", name, dmg);
        } else {
            msg = String.format("%s takes no damage!", name);
        }
        if (!isAlive()) {
            setHp(0);
            msg = String.format("%s is dead!", name);
        }
        setStatus(msg);
    }

    public void dealDamage(Creature enemy) {
        int dmg = attack + dice.throwDice();
        setStatus(String.format("%s attacks for %s damage!", name, dmg));
        enemy.takeDamage(dmg);
    }
}
