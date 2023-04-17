package sk.stuba.fei.uim.oop.game.pipes.menu.listeners;

import sk.stuba.fei.uim.oop.game.pipes.Pipes;
import sk.stuba.fei.uim.oop.game.pipes.board.GameBoard;
import sk.stuba.fei.uim.oop.game.pipes.menu.buttons.ResetButton;
import sk.stuba.fei.uim.oop.game.pipes.menu.buttons.CheckButton;

import java.awt.event.*;

public class MouseListener implements ActionListener {
    private GameBoard gameBoard;
    private Pipes game;
    public MouseListener(Pipes game) {
        this.game = game;
        this.gameBoard = game.getGameBoard();
    }

    @Override
    public void actionPerformed(ActionEvent e)  {
        if (e.getSource() instanceof CheckButton){
            if(gameBoard.checkMazeComplete())
                game.getMenuPanel().nextLevel();
        } else if (e.getSource() instanceof ResetButton) {
            gameBoard.genereteNewMaze();
        }
        game.getMenuPanel().requestFocusInWindow();
    }


}
