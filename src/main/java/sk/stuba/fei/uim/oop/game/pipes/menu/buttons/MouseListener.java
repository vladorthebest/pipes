package sk.stuba.fei.uim.oop.game.pipes.menu.buttons;

import sk.stuba.fei.uim.oop.game.pipes.Pipes;
import sk.stuba.fei.uim.oop.game.pipes.board.GameBoard;

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
        if (e.getSource() instanceof StartButton){
            if(gameBoard.checkMazeComplete())
                game.getMenuPanel().nextLevel();
        } else if (e.getSource() instanceof ResetButton) {
            gameBoard.setSizeBoard(10);
        }
    }


}
