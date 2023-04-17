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

        this.add(scoreLabel);


    }

    private void createButtons(){
        checkButton = new CheckButton();
        checkButton.addActionListener(new MouseListener(game));
        checkButton.addKeyListener(keyListener);

        resetButton = new ResetButton();
        resetButton.addActionListener(new MouseListener(game));
        resetButton.addKeyListener(keyListener);

        this.add(checkButton);
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
    }

    public void setScore(int score){
        this.score = score;
        updateTextLabel();
    }

    private void setSize(){
        this.game.getGameBoard().setSizeBoard(slider.getValue());
    }

    public void nextLevel() {
        this.score++;
        updateTextLabel();
        game.getGameBoard().genereteNewMaze();
    }

    private void updateTextLabel() {
        scoreLabel.setText("Level: " + score);
    }

    public void startGame(){
        checkButton.setEnabled(false);
        resetButton.setEnabled(true);
    }
}
