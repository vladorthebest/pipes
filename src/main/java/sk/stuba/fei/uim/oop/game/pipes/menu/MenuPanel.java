package sk.stuba.fei.uim.oop.game.pipes.menu;

import sk.stuba.fei.uim.oop.game.pipes.Pipes;
import sk.stuba.fei.uim.oop.game.pipes.menu.buttons.KeyListener;
import sk.stuba.fei.uim.oop.game.pipes.menu.buttons.MouseListener;
import sk.stuba.fei.uim.oop.game.pipes.menu.buttons.StartButton;

import javax.swing.*;

public class MenuPanel extends JPanel{
    private StartButton startButton, resetButton;
    private JLabel scoreLabel;
    private MouseListener mouseListener;
    private KeyListener keyListener;
    private Pipes game;
    private int score = 0;
    public  MenuPanel(Pipes game) {
        this.game = game;
        mouseListener = new MouseListener(game.getGameBoard());
        keyListener = new KeyListener(game.getGameBoard());
        startButton = new StartButton("Check");
        startButton.addActionListener(mouseListener);
        startButton.addKeyListener(keyListener);
        this.add(startButton);

    }

    public void setScore(int score){
        this.score = score;
        updateTextLabel();
    }
    private void updateTextLabel() {
        scoreLabel.setText("Score: " + this.score);
    }

    public void startGame(){
        startButton.setEnabled(false);
        resetButton.setEnabled(true);
    }
}
