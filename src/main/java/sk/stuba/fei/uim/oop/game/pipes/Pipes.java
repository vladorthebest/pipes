package sk.stuba.fei.uim.oop.game.pipes;

import sk.stuba.fei.uim.oop.game.pipes.board.GameBoard;
import sk.stuba.fei.uim.oop.game.pipes.menu.MenuPanel;

import java.awt.*;
import javax.swing.*;


public class Pipes extends JFrame{

    private static final long serialVersionUID = 1L;

    private JPanel boardPanel, buttonsPanel;
    private JButton startButton, resetButton;
    private JLabel scoreLabel;
    private Timer timer;

    private int currentPipeX, currentPipeY;

    private MenuPanel menuPanel;
    private GameBoard gameBoard;

    public Pipes() {
        setTitle("Pipes");
        setSize(600, 600);
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

    //    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == startButton) {
//            startGame();
//        } else if (e.getSource() == resetButton) {
//            resetGame();
//        } else if (e.getSource() == timer) {
//            movePipe();
//        }
//    }

//    private void startGame() {
//        score = 0;
//        scoreLabel.setText("Score: " + score);
//
//        currentPipeX = 0;
//        currentPipeY = 2;
//        board[currentPipeX][currentPipeY] = true;
//
//        drawBoard();
//
//        timer = new Timer(1000, this);
//        timer.start();
//
//        startButton.setEnabled(false);
//        resetButton.setEnabled(true);
//    }

//    private void resetGame() {
//        timer.stop();
//        for (int i = 0; i < 6; i++) {
//            for (int j = 0; j < 6; j++) {
//                board[i][j] = false;
//            }
//        }
//        drawBoard();
//        startButton.setEnabled(true);
//        resetButton.setEnabled(false);
//    }

//    private void movePipe() {
//        if (currentPipeX == 5) {
//            gameOver();
//            return;
//        }
//
//        int[] nextPipeCoords = getNextPipeCoords();
//        if (nextPipeCoords[0] == -1) {
//            gameOver();
//            return;
//        }
//
//        int nextPipeX = nextPipeCoords[0];
//        int nextPipeY = nextPipeCoords[1];
//
//        if (nextPipeX == 5 && nextPipeY == 2) {
//            score++;
//            scoreLabel.setText("Score: " + score);
//            resetPipe();
//        } else {
//            board[currentPipeX][currentPipeY] = false;
//            currentPipeX = nextPipeX;
//            currentPipeY = nextPipeY;
//            board[currentPipeX][currentPipeY] = true;
//            drawBoard();
//        }
//    }

//    private int[] getNextPipeCoords() {
//        int[] coords = {-1, -1};
//        for (int i = currentPipeY - 1; i <= currentPipeY + 1; i++) {
//            if (i < 0 || i >= 6) {
//                continue;
//            }
//            if (pipes[currentPipeX][i - currentPipeY + 1] == 1 && !board[currentPipeX][i]) {
//                coords[0] = currentPipeX;
//                coords[1] = i;
//                return coords;
//            }
//        }
//        return coords;
//    }

//    private void resetPipe() {
//        currentPipeX = 0;
//        currentPipeY = 2;
//        board[currentPipeX][currentPipeY] = true;
//    }
//
//    private void gameOver() {
//        timer.stop();
//        JOptionPane.showMessageDialog(this, "Game Over!\nYour score is " + score);
//        resetGame();
//    }
//

}