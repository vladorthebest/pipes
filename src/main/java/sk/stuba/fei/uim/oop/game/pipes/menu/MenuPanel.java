package sk.stuba.fei.uim.oop.game.pipes.menu;

import sk.stuba.fei.uim.oop.game.pipes.Pipes;
import sk.stuba.fei.uim.oop.game.pipes.menu.buttons.*;
import sk.stuba.fei.uim.oop.game.pipes.menu.listeners.KeyListener;
import sk.stuba.fei.uim.oop.game.pipes.menu.listeners.MouseListener;
import sk.stuba.fei.uim.oop.game.pipes.menu.listeners.SliderListener;

import javax.swing.*;

public class MenuPanel extends JPanel{
    private CheckButton checkButton;
    private ResetButton resetButton;
    private JLabel scoreLabel;
    private MouseListener mouseListener;
    private KeyListener keyListener;
    private Pipes game;
    private int score = 1;

    private Slider slider;

    public  MenuPanel(Pipes game) {
        this.game = game;

        createButtons();
        createSlider();
        createLevelLabel();

        this.setFocusable(true);
        this.requestFocusInWindow();

        keyListener = new KeyListener(game);
        this.addKeyListener(keyListener);
    }

    private void createButtons(){
        mouseListener = new MouseListener(game);

        checkButton = new CheckButton();
        checkButton.addActionListener(mouseListener);
        this.add(checkButton);

        resetButton = new ResetButton();
        resetButton.addActionListener(mouseListener);
        this.add(resetButton);
    }

    private void createSlider() {
        this.slider = new Slider();
        this.add(slider);
        this.slider.addChangeListener(new SliderListener(game));
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
