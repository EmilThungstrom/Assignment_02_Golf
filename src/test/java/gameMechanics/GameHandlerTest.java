package gameMechanics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameHandlerTest {

    @Test
    void hitBall() {
        GameHandler gameHandler = new GameHandler();
        gameHandler.test();
        double startPos = gameHandler.getCordinates()[0];

        gameHandler.hitBall(10, 45);
        Assertions.assertTrue(startPos > gameHandler.getCordinates()[0]);
    }
}