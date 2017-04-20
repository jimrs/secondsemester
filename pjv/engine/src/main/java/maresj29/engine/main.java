package maresj29.engine;

public class main {
    public static void main(String[] args) {
        Dice dice = new Dice();
        Player playa = new Player("Player", "warrior", dice);
        Monster monsta = new Monster("Orc", 100, 5, 5, 1, dice);
        
        playa.dealDamage(monsta);
        System.out.println(playa.getStatus());
        System.out.println(monsta.getStatus());
        
    }
    
}
