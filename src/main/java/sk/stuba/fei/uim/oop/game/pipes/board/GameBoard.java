package sk.stuba.fei.uim.oop.game.pipes.board;

import sk.stuba.fei.uim.oop.game.pipes.board.maze.Cell;
import sk.stuba.fei.uim.oop.game.pipes.board.maze.Maze;
import sk.stuba.fei.uim.oop.game.pipes.board.pipes.BasePipe;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameBoard extends JPanel {
    private int sizeBoard;
    private Cell[][] maze;
    private GridLayout layout;
    private Random random;
    private Maze mazeGenerator;

    public GameBoard(){
        sizeBoard = 8;
        this.random = new Random();

        layout = new GridLayout(sizeBoard, sizeBoard);
        this.setLayout(layout);

        mazeGenerator = new Maze(sizeBoard);
        genereteNewMaze();


    }

    public void setSizeBoard(int sizeBoard) {
        this.sizeBoard = sizeBoard;
        layout = new GridLayout(sizeBoard, sizeBoard);
        this.setLayout(layout);
        genereteNewMaze();
    }


    public boolean checkMazeComplete(){
        return mazeGenerator.checkMazeComplete();
    }

    public void genereteNewMaze(){
        if(maze != null){
            for (Cell[] cells : maze) {
                for (int j = 0; j < maze.length; j++) {
                    BasePipe pipe;
                    pipe = cells[j].getPipe();
                    this.remove(pipe);
                }
            }
        }
        mazeGenerator = new Maze(sizeBoard);
        this.maze = mazeGenerator.getMaze();

        this.mazeGenerator.getStartCell().setStartPipe(50, 50);
        this.mazeGenerator.getFinishCell().setFinishPipe(50, 50);

        for (Cell[] cells : maze) {
            for (int j = 0; j < maze.length; j++) {
                BasePipe pipe;
                pipe = cells[j].createPipe(50, 50);
                pipe.setOpaque(true);
                this.add(pipe);
            }
        }
        randomlyRotated();
        this.revalidate();
        this.repaint();
    }


    private void randomlyRotated() {
        for( Cell[] row : maze ){
            for( Cell cell : row){
                int n = random.nextInt(4);
                for(int i=0; i<=n; i++){
                    cell.getPipe().rotateImage();
                }
            }
        }
    }
}
