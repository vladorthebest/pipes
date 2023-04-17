package sk.stuba.fei.uim.oop.game.pipes.menu;

import sk.stuba.fei.uim.oop.game.pipes.Pipes;
import sk.stuba.fei.uim.oop.game.pipes.menu.buttons.*;

import javax.swing.*;

public class MenuPanel extends JPanel{
    private StartButton startButton;
    private ResetButton resetButton;
    private JLabel scoreLabel;
    private MouseListener mouseListener;
    private KeyListener keyListener;
    private Pipes game;
    private int score = 1;

    private Slider slider;

    public  MenuPanel(Pipes game) {
        this.game = game;
        this.scoreLabel = new JLabel();

        mouseListener = new MouseListener(game);
        keyListener = new KeyListener(game);

        startButton = new StartButton("Check");
        startButton.addActionListener(mouseListener);
//        startButton.addKeyListener(keyListener);
        this.addKeyListener(keyListener);
        this.slider = new Slider();
        this.add(slider);
        this.slider.addChangeListener(new SliderListener(game.getGameBoard()));

        resetButton = new ResetButton("Reset");
        resetButton.addActionListener(mouseListener);
//        resetButton.addKeyListener(keyListener);
        this.setFocusable(true);
        this.add(startButton);
        this.add(resetButton);
        this.add(scoreLabel);
        updateTextLabel();
        System.out.println(slider.getValue());

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
        startButton.setEnabled(false);
        resetButton.setEnabled(true);
    }
}
