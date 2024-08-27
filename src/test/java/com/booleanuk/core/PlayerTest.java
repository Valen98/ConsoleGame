package com.booleanuk.core;

import com.booleanuk.Model.Element.Fire;
import com.booleanuk.Model.Entity.Enemy;
import com.booleanuk.Model.Entity.Goblin;
import com.booleanuk.Model.Entity.Player;
import com.booleanuk.Model.Item.Weapon.Dagger;
import com.booleanuk.Model.Item.Weapon.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    Player player;
    Enemy enemy1;

    public PlayerTest() {
        player = new Player("Lynx");
        this.enemy1 = new Goblin(new Fire(), 1);
        Weapon dagger = new Dagger("CoolDagger", 1, 10, 15, 0.1f, 1.5f, 0.1f);
        player.addItemToInventory(dagger);

        player.setWeapon(dagger);

    }

    @Test
    public void createPlayerTest(){
        Assertions.assertEquals("Lynx", player.getName());
        Assertions.assertEquals(68, player.getHP());

        Assertions.assertEquals("Goblin", enemy1.getName());

    }

    @Test
    public void givePlayerWeaponTest(){
        Assertions.assertEquals("CoolDagger", player.getWeapon().getName());
    }

    @Test
    public void givePlayerPotionTest() {

    }

    @Test
    public void givePlayerShieldTest() {

    }

    @Test
    public void attackEnemyTest() {
        float beforeAttack = enemy1.getHP();
        enemy1.getAttacked(player.getWeapon());

        Assertions.assertNotEquals(beforeAttack, enemy1.getHP());
    }
}
