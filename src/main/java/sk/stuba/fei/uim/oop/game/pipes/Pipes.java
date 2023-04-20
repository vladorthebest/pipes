package sk.stuba.fei.uim.oop.game.pipes;

import lombok.Getter;
import sk.stuba.fei.uim.oop.game.pipes.board.GameBoard;
import sk.stuba.fei.uim.oop.game.pipes.menu.MenuPanel;

import java.awt.*;
import javax.swing.*;


public class Pipes extends JFrame {

    @Getter
    private MenuPanel menuPanel;
    @Getter
    private GameBoard gameBoard;

    public Pipes() {
        setTitle("Pipes");
        setSize(650, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        gameBoard = new GameBoard();
        menuPanel = new MenuPanel(this);

        add(gameBoard, BorderLayout.CENTER);
        add(menuPanel, BorderLayout.SOUTH);
        setResizable(false);
        setVisible(true);


    }
}