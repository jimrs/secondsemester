/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maresj29.engine;

/**
 *
 * @author HarryPotter
 */
public class Monster extends Creature {
    public Monster(String name, int hp, int atk, int def, int lvl, Dice dice) {
        super(name, hp, atk, def, lvl, dice);
    }
}
