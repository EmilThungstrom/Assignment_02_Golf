import gameMechanics.GameHandler;

import javax.swing.*;

public class App {

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        GameHandler gameHandler = new GameHandler();
        gameHandler.initialize();
    }
}
