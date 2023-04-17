package sk.stuba.fei.uim.oop.game.pipes.menu.listeners;

import sk.stuba.fei.uim.oop.game.pipes.Pipes;
import sk.stuba.fei.uim.oop.game.pipes.board.GameBoard;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
    private GameBoard gameBoard;
    private Pipes game;

    public KeyListener(Pipes game) {
        this.gameBoard = game.getGameBoard();
        this.game = game;

    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if(gameBoard.checkMazeComplete())
                game.getMenuPanel().nextLevel();
        }
        if (e.getKeyCode() == KeyEvent.VK_R){
            game.getGameBoard().genereteNewMaze();
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
            game.dispose();
            System.exit(0);
        }

    }
}
