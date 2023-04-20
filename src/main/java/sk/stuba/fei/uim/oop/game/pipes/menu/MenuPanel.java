package sk.stuba.fei.uim.oop.game.pipes.menu;

import sk.stuba.fei.uim.oop.game.pipes.Pipes;
import sk.stuba.fei.uim.oop.game.pipes.menu.buttons.*;
import sk.stuba.fei.uim.oop.game.pipes.menu.listeners.KeyListener;
import sk.stuba.fei.uim.oop.game.pipes.menu.listeners.MouseListener;
import sk.stuba.fei.uim.oop.game.pipes.menu.listeners.SliderListener;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel{
    private JLabel scoreLabel;
    private Pipes game;
    private int score;

    public  MenuPanel(Pipes game) {
        this.score = 1;
        this.game = game;

        createButtons();
        createSlider();
        createLevelLabel();

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));

        this.setFocusable(true);
        this.requestFocusInWindow();

        KeyListener keyListener = new KeyListener(game);
        this.addKeyListener(keyListener);
    }

    private void createButtons(){
        MouseListener mouseListener = new MouseListener(game);

        CheckButton checkButton = new CheckButton();
        checkButton.addActionListener(mouseListener);
        this.add(checkButton);

        ResetButton resetButton = new ResetButton();
        resetButton.addActionListener(mouseListener);
        this.add(resetButton);
    }

    private void createSlider() {
        Slider slider = new Slider();
        this.add(slider);
        slider.addChangeListener(new SliderListener(game));
    }

    private void createLevelLabel(){
        this.scoreLabel = new JLabel();
        updateTextLabel();
        this.add(scoreLabel);
    }

    public void nextLevel() {
        this.score++;
        updateTextLabel();
        game.getGameBoard().genereteNewMaze();
    }

    private void updateTextLabel() {
        scoreLabel.setText("Level: " + score);
    }

}
