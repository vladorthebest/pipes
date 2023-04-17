package sk.stuba.fei.uim.oop.game.pipes.menu.buttons;

import sk.stuba.fei.uim.oop.game.pipes.Pipes;
import sk.stuba.fei.uim.oop.game.pipes.board.GameBoard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetMouseListener implements ActionListener {
    private GameBoard gameBoard;
    Slider size;
    Pipes game;
    public ResetMouseListener(GameBoard gameBoard, Slider value) {
        this.size = value;
        this.gameBoard = gameBoard;
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e)  {

        gameBoard.setSizeBoard(size.getValue());
    }


}