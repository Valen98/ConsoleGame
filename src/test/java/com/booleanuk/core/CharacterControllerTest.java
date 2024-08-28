package com.booleanuk.core;

import com.booleanuk.Model.Element.Fire;
import com.booleanuk.Model.Entity.CharacterController;
import com.booleanuk.Model.Entity.Entity;
import com.booleanuk.Model.Entity.Goblin;
import com.booleanuk.Model.Entity.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CharacterControllerTest {

    @Test
    public void createCharacter(){
        Entity player = new Player("Cool");
        Entity goblin = new Goblin(new Fire(), 1);

        CharacterController characterController = new CharacterController();

        characterController.addCharacter(player);
        characterController.addCharacter(goblin);

        Assertions.assertEquals(2, characterController.getCharacterList().size());

        //Check if the object exist in characterController.
        Assertions.assertEquals(player, characterController.getCharacterList().get(player.getId()));
    }


}
