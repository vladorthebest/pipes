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
    private int score = 0;

    private Slider slider;

    public  MenuPanel(Pipes game) {
        this.game = game;
        mouseListener = new MouseListener(game.getGameBoard());
        keyListener = new KeyListener(game.getGameBoard());
        startButton = new StartButton("Check");
        startButton.addActionListener(mouseListener);
        startButton.addKeyListener(keyListener);
        this.slider = new Slider();
        this.add(slider);
        this.slider.addChangeListener(new SliderListener(game.getGameBoard()));
        ResetMouseListener resetMouseListener = new ResetMouseListener(game.getGameBoard(), slider);
        resetButton = new ResetButton("Reset");
        resetButton.addActionListener(mouseListener);
        resetButton.addKeyListener(keyListener);

        this.add(startButton);
        this.add(resetButton);

        System.out.println(slider.getValue());

    }

    public void setScore(int score){
        this.score = score;
        updateTextLabel();
    }

    private void setSize(){
        this.game.getGameBoard().setSizeBoard(slider.getValue());
    }


    private void updateTextLabel() {
        scoreLabel.setText("Score: " + this.score);
    }

    public void startGame(){
        startButton.setEnabled(false);
        resetButton.setEnabled(true);
    }
}
