package sk.stuba.fei.uim.oop.game.pipes.menu.buttons;

import sk.stuba.fei.uim.oop.game.pipes.board.GameBoard;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
    private GameBoard gameBoard;
    public KeyListener(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if(gameBoard.checkMazeComplete())
                gameBoard.genereteNewMaze();
        }
    }
}
