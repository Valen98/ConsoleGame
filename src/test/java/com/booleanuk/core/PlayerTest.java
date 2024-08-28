package com.booleanuk.core;

import com.booleanuk.Game;
import com.booleanuk.Model.Element.Fire;
import com.booleanuk.Model.Entity.Enemy;
import Goblin;
import com.booleanuk.Model.Entity.Player;
import com.booleanuk.Model.Item.Shield;
import com.booleanuk.Model.Item.Weapon.Dagger;
import com.booleanuk.Model.Item.Weapon.Weapon;
import com.booleanuk.Model.Item.WoodenShield;
import com.booleanuk.Model.Item.potion.HealthPotion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    Player player;
    Enemy enemy1;
    Game game;

    public PlayerTest() {
        player = new Player("Lynx");

        this.game = new Game(player);
        this.enemy1 = new Goblin(new Fire(), 1);

        Weapon dagger = new Dagger("CoolDagger", 1, 10, 15, 0.1f, 1.5f, 0.1f);
        this.game.addItemToEntity(this.player, dagger);
        //player.addItemToInventory(dagger);

        player.setWeapon(dagger);

    }

    @Test
    public void createPlayerTest() {
        Assertions.assertEquals("Lynx", player.getName());
        Assertions.assertEquals(68, player.getHP());

        Assertions.assertEquals("Goblin", enemy1.getName());

    }

    @Test
    public void givePlayerWeaponTest() {
        Assertions.assertEquals("CoolDagger", player.getWeapon().getName());
    }

    @Test
    public void givePlayerPotionTest() {
        HealthPotion hp = new HealthPotion();
        this.player.addItemToInventory(hp);

        Assertions.assertTrue(this.player.getInventory().getItems().contains(hp));
        Assertions.assertTrue(this.player.useHealthPotion());

        Assertions.assertFalse(this.player.getInventory().getItems().contains(hp));
        Assertions.assertFalse(this.player.useHealthPotion());
    }

    @Test
    public void givePlayerShieldTest() {
        Shield shield = new WoodenShield();
        this.player.setShield(shield);

        Assertions.assertNull(this.player.getShield());

        this.game.addItemToEntity(this.player, shield);
        this.player.setShield(shield);

        Assertions.assertEquals(this.player.getShield().getId(), shield.getId());
    }

    @Test
    public void attackEnemyTest() {
        float beforeAttack = enemy1.getHP();
        enemy1.getAttacked(player.getWeapon());

        Assertions.assertNotEquals(beforeAttack, enemy1.getHP());
    }

    @Test
    public void attackEnemyWithShieldTest() {
        Weapon dagger2 = new Dagger("CoolDagger", 1, 10, 15, 0.1f, 1.5f, 0.1f);
        this.game.addItemToEntity(this.enemy1, dagger2);

        Shield shield = new WoodenShield();
        this.game.addItemToEntity(this.player, shield);
        this.player.setShield(shield);

        this.enemy1.setWeapon(dagger2);

        this.player.getShield().setBlockChance(0f);

        Assertions.assertNotEquals(0, this.player.getAttacked(enemy1.getWeapon()));

        this.player.getShield().setBlockChance(1f);

        Assertions.assertEquals(0, this.player.getAttacked(enemy1.getWeapon()));
    }

}
