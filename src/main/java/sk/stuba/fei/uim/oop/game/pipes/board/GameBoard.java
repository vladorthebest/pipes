package sk.stuba.fei.uim.oop.game.pipes.board;

import sk.stuba.fei.uim.oop.game.pipes.board.pipes.BasePipe;
import sk.stuba.fei.uim.oop.game.pipes.board.pipes.LinePipe;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class GameBoard extends JPanel {
    int sizeBoard = 8;
    private boolean[][] board = new boolean[sizeBoard][sizeBoard];
    Cell[][] maze;
    LinkedList<Cell> path;
    private GridLayout layout;
    private Random random = new Random();
    Maze mazeGenerator;

    public GameBoard(){
        mazeGenerator = new Maze(sizeBoard);
        layout = new GridLayout(sizeBoard, sizeBoard);
        this.setLayout(layout);
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
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze.length; j++) {
                    BasePipe pipe;
                    pipe = maze[i][j].getPipe();
                    this.remove(pipe);
                }
            }
        }
        mazeGenerator = new Maze(sizeBoard);
        this.maze = mazeGenerator.getMaze();
        this.path = mazeGenerator.getPath();

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                BasePipe pipe;
                pipe = maze[i][j].createPipe(50, 50);
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
