package sk.stuba.fei.uim.oop.game.pipes.menu;

import sk.stuba.fei.uim.oop.game.pipes.Pipes;
import sk.stuba.fei.uim.oop.game.pipes.board.pipes.MouseListener;
import sk.stuba.fei.uim.oop.game.pipes.menu.buttons.Listener;
import sk.stuba.fei.uim.oop.game.pipes.menu.buttons.StartButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel{
    private StartButton startButton, resetButton;
    private JLabel scoreLabel;
    private Listener listener;
    private Pipes game;
    private int score = 0;
    public  MenuPanel(Pipes game) {
        this.game = game;
        listener = new Listener(game.getGameBoard());
        startButton = new StartButton("Check");
        startButton.addActionListener(new Listener(game.getGameBoard()));
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
