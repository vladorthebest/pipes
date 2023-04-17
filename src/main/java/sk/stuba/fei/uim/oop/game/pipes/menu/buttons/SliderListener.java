package sk.stuba.fei.uim.oop.game.pipes.menu.buttons;

import sk.stuba.fei.uim.oop.game.pipes.board.GameBoard;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderListener implements ChangeListener {
    private GameBoard gameBoard;
    public SliderListener(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        if (!source.getValueIsAdjusting()) {
            int value = source.getValue();
            gameBoard.setSizeBoard(value);
        }
    }
}
