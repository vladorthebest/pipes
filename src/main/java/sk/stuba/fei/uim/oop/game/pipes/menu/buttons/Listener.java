package sk.stuba.fei.uim.oop.game.pipes.menu.buttons;

import sk.stuba.fei.uim.oop.game.pipes.Pipes;
import sk.stuba.fei.uim.oop.game.pipes.board.GameBoard;
import sk.stuba.fei.uim.oop.game.pipes.board.pipes.BasePipe;
import sk.stuba.fei.uim.oop.game.pipes.menu.MenuPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Listener implements ActionListener {
    private GameBoard gameBoard;
    public Listener(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    @Override
    public void actionPerformed(ActionEvent e)  {
        if(gameBoard.checkMazeComplete())
            gameBoard.genereteNewMaze();


    }

}
