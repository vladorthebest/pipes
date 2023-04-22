package sk.stuba.fei.uim.oop.game.pipes.menu.listeners;

import sk.stuba.fei.uim.oop.game.pipes.Pipes;
import sk.stuba.fei.uim.oop.game.pipes.board.GameBoard;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderListener implements ChangeListener {
    private GameBoard gameBoard;
    private Pipes game;

    public SliderListener(Pipes game) {
        this.game = game;
        this.gameBoard = game.getGameBoard();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        if (!source.getValueIsAdjusting()) {
            int value = source.getValue();
            gameBoard.setSizeBoard(value);
            game.getMenuPanel().resetLevel();
        }
        game.getMenuPanel().requestFocusInWindow();
    }
}
