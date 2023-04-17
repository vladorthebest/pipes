package sk.stuba.fei.uim.oop.game.pipes.menu.buttons;

import sk.stuba.fei.uim.oop.game.pipes.board.GameBoard;

import java.awt.event.*;

public class MouseListener implements ActionListener {
    private GameBoard gameBoard;
    public MouseListener(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    @Override
    public void actionPerformed(ActionEvent e)  {
        if (e.getSource() instanceof StartButton){
            if(gameBoard.checkMazeComplete())
                gameBoard.genereteNewMaze();
        } else if (e.getSource() instanceof ResetButton) {
            gameBoard.setSizeBoard(10);
        }
    }


}
