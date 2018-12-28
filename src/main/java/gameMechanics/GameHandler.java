package gameMechanics;

import gui.GameGui;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Random;

public class GameHandler {

    private static GravityMechanics gravityMechanics = new GravityMechanics();
    private GameGui gameGui;

    //positions using the 2d spherical coordinate system
    private double[] ballPos;
    private double[] holePos;

    private int maxSwings;
    private int swings;

    public void initialize() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        setupPlay();

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        SwingUtilities.invokeLater(() -> {
            gameGui = new GameGui(this);
            gameGui.setVisible(true);
        });
    }
    public void test() {
        setupPlay();
    }
    public void hitBall(double velocity, double degrees) {
        DecimalFormat df = new DecimalFormat("#.##");

        if(ballPos[0] > 0)
            ballPos[0] = Double.valueOf(df.format(ballPos[0] - gravityMechanics.distance(velocity, degrees)));
        else
            ballPos[0] = Double.valueOf(df.format(ballPos[0] + gravityMechanics.distance(velocity, degrees)));

        swings++;
        checkWinLose();
    }
    public double[] getCordinates(){
        return ballPos;
    }

    private void checkWinLose(){
        if (swings > maxSwings) {
            gameGui.showDefeatDialog();
            setupPlay();
        }
        else if(ballPos[0] >= -0.1 && ballPos[0] <= 0.1) {
            gameGui.showVictoryDialog();
            setupPlay();
        }
    }
    private void setupPlay(){
        swings = 0;
        maxSwings = 5;

        Random rand = new Random();

        ballPos = new double[] {rand.nextInt(900) + 101, 0};
        holePos = new double[] {0, 0};
    }
}
