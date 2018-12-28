package gui;

import gameMechanics.GameHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGui extends JFrame {

    private GameHandler gameHandler;
    private JButton swing;
    private JTextField distanceLeft;
    private JPanel rootPanel;
    private JComboBox comboBoxVelocity;
    private JComboBox comboBoxAngle;

    public GameGui(GameHandler gameHandler)
    {
        add(rootPanel);

        setTitle("Calculator");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.gameHandler = gameHandler;
        distanceLeft.setText(Double.toString(gameHandler.getCordinates()[0]));

        swing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gameHandler.hitBall(Double.valueOf((String) comboBoxVelocity.getSelectedItem()), Double.valueOf((String) comboBoxAngle.getSelectedItem()));
                distanceLeft.setText(Double.toString(gameHandler.getCordinates()[0]));
            }
        });
    }
    public void showVictoryDialog(){
        JOptionPane.showMessageDialog(rootPanel,"VICTORY!");
    }
    public void showDefeatDialog(){
        JOptionPane.showMessageDialog(rootPanel,"DEFEAT!");
    }
}
