package sk.stuba.fei.uim.oop.game.pipes.board;

import sk.stuba.fei.uim.oop.game.pipes.board.pipes.BasePipe;
import sk.stuba.fei.uim.oop.game.pipes.board.pipes.LinePipe;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class GameBoard extends JPanel {
    int sizeBoard = 8;
    private boolean[][] board = new boolean[sizeBoard][sizeBoard];
    Cell[][] maze;
    LinkedList<Cell> path;
    private GridLayout layout;

    public GameBoard(){
        layout = new GridLayout(sizeBoard, sizeBoard);
        this.setLayout(layout);
        genereteNewMaze();

    }


    public boolean checkMazeComplete(){
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                if (!maze[i][j].isComplete())
                    return false;
            }
        }

        return true;
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


        Maze mazeGenerator = new Maze(sizeBoard);
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
        this.revalidate();
        this.repaint();
    }

}
