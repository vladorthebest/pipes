package sk.stuba.fei.uim.oop.game.pipes;

import sk.stuba.fei.uim.oop.game.pipes.board.GameBoard;
import sk.stuba.fei.uim.oop.game.pipes.menu.MenuPanel;
import sk.stuba.fei.uim.oop.game.pipes.menu.listeners.KeyListener;

import java.awt.*;
import javax.swing.*;


public class Pipes extends JFrame {

    private MenuPanel menuPanel;
    private GameBoard gameBoard;

    public Pipes() {
        setTitle("Pipes");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameBoard = new GameBoard();
        menuPanel = new MenuPanel(this);

        add(gameBoard, BorderLayout.CENTER);
        add(menuPanel, BorderLayout.SOUTH);
        setResizable(false);
        setVisible(true);


    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public MenuPanel getMenuPanel() {
        return menuPanel;
    }
}