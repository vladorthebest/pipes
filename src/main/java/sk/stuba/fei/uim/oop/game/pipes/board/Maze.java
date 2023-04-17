package sk.stuba.fei.uim.oop.game.pipes.board;

import sk.stuba.fei.uim.oop.game.pipes.board.pipes.EmptyPipe;

import java.util.LinkedList;
import java.util.Random;

class Maze{
    Cell[][] maze;
    LinkedList<Cell> path = new LinkedList<>();
    int size;
    Random random = new Random();
    int startJ, startI, finishI, finishJ;



    public Maze(int size){
        if(size<3){
            System.out.println("Small size!!! (size can't be < 3)");
        }else {
            this.size = size;
        }

        generateNewMaze();

    }

    public void generateNewMaze() {
        maze = new Cell[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                maze[i][j] = new Cell(i, j);
            }
        }
        createStartFinish();

        path.add(maze[startI][startJ]);
        while (path.getLast().getI() != finishI || path.getLast().getJ() != finishJ){
            req(path.getLast().getI(), path.getLast().getJ());
        }

        pipeSetting();
    }

    private void pipeSetting(){
        for(int i=0; i<path.size()-1; i++){
            if (path.get(i).getI() > path.get(i+1).getI()){
                path.get(i).setOutput(Input.TOP);
                path.get(i+1).setInput(Input.BOTTOM);
            } else if (path.get(i).getI() < path.get(i+1).getI()) {
                path.get(i).setOutput(Input.BOTTOM);
                path.get(i+1).setInput(Input.TOP);
            } else if (path.get(i).getJ() > path.get(i+1).getJ()) {
                path.get(i).setOutput(Input.LEFT);
                path.get(i+1).setInput(Input.RIGHT);
            } else if (path.get(i).getJ() < path.get(i+1).getJ()) {
                path.get(i).setOutput(Input.RIGHT);
                path.get(i+1).setInput(Input.LEFT);
            }
        }

        for(int i=0; i<path.size(); i++) {

        }
    }

    private void createStartFinish(){
        startJ = random.nextInt(size-1);
        startI = 0;

        finishJ = random.nextInt(size-1);
        finishI = size-1;
    }

    public Cell[][] getMaze(){
        return maze;
    }

    public LinkedList<Cell> getPath() {
        return path;
    }

    public boolean req(int nowI, int nowJ){
        if(!path.contains(maze[nowI][nowJ]))
            path.add(maze[nowI][nowJ]);
        maze[nowI][nowJ].setVisited(true);
        LinkedList<Cell> neighbours = new LinkedList<>();

        if(nowI == finishI && nowJ == finishJ){
            return true;
        }

        if(nowI != 0){
            if(!maze[nowI-1][nowJ].isVisited() )
            neighbours.add(maze[nowI-1][nowJ]);
        }
        if(nowI != size-1){
            if(!maze[nowI+1][nowJ].isVisited() )
            neighbours.add(maze[nowI+1][nowJ]);
        }
        if(nowJ != 0){
            if(!maze[nowI][nowJ-1].isVisited() )
            neighbours.add(maze[nowI][nowJ-1]);
        }
        if(nowJ != size-1){
            if(!maze[nowI][nowJ+1].isVisited())
            neighbours.add(maze[nowI][nowJ+1]);
        }
        neighbours.sort((a, b) -> a.getValue() - b.getValue());
;
        if(neighbours.isEmpty()){
            path.removeLast();
        }else {
            req(neighbours.getFirst().getI(), neighbours.getFirst().getJ());
        }
        return true;
    }

    public boolean checkMazeComplete(){
        return checkCellComplete(path.getFirst(), path.getFirst().getPipe().getNowInput());

    }
    public boolean checkCellComplete(Cell cell, Input input){
        int i = cell.getI();
        int j = cell.getJ();

        if(i == finishI && j == finishJ){
            return true;
        }
        switch (input) {
            case TOP :
                if (i - 1 < 0) {
                    cell.getPipe().setRedIcon();
                    return false;
                } else {
                    i--;
                    if (maze[i][j].getPipe() instanceof EmptyPipe){
                        cell.getPipe().setRedIcon();
                        return false;
                    }
                    if (maze[i][j].getPipe().getNowInput() == Input.BOTTOM) {
                        cell.getPipe().setGreenIcon();
                        return checkCellComplete(maze[i][j], maze[i][j].getPipe().getNowOutput());

                    } else if (maze[i][j].getPipe().getNowOutput() == Input.BOTTOM) {
                        cell.getPipe().setGreenIcon();
                        return checkCellComplete(maze[i][j], maze[i][j].getPipe().getNowInput());
                    } else {
                        cell.getPipe().setRedIcon();
                        return false;
                    }
                }

            case LEFT:
                if (j - 1 < 0) {
                    cell.getPipe().setRedIcon();
                    return false;
                } else {
                    j--;
                    if (maze[i][j].getPipe() instanceof EmptyPipe){
                        cell.getPipe().setRedIcon();
                        return false;
                    }
                    if (maze[i][j].getPipe().getNowInput() == Input.RIGHT) {
                        cell.getPipe().setGreenIcon();
                        return checkCellComplete(maze[i][j], maze[i][j].getPipe().getNowOutput());

                    } else if (maze[i][j].getPipe().getNowOutput() == Input.RIGHT) {
                        cell.getPipe().setGreenIcon();
                        return checkCellComplete(maze[i][j], maze[i][j].getPipe().getNowInput());
                    } else {
                        cell.getPipe().setRedIcon();
                        return false;
                    }
                }
            case RIGHT:
                if (j + 1 > size - 1) {
                    cell.getPipe().setRedIcon();
                    return false;
                } else {
                    j++;
                    if (maze[i][j].getPipe() instanceof EmptyPipe){
                        cell.getPipe().setRedIcon();
                        return false;
                    }
                    if (maze[i][j].getPipe().getNowInput() == Input.LEFT) {
                        cell.getPipe().setGreenIcon();
                        return checkCellComplete(maze[i][j], maze[i][j].getPipe().getNowOutput());

                    } else if (maze[i][j].getPipe().getNowOutput() == Input.LEFT) {
                        cell.getPipe().setGreenIcon();
                        return checkCellComplete(maze[i][j], maze[i][j].getPipe().getNowInput());
                    } else {
                        cell.getPipe().setRedIcon();
                        return false;
                    }
                }

            case BOTTOM:
                if (i + 1 > size - 1) {
                    cell.getPipe().setRedIcon();
                    return false;
                } else {
                    i++;
                    if (maze[i][j].getPipe() instanceof EmptyPipe){
                        cell.getPipe().setRedIcon();
                        return false;
                    }
                    if (maze[i][j].getPipe().getNowInput() == Input.TOP) {
                        cell.getPipe().setGreenIcon();
                        return checkCellComplete(maze[i][j], maze[i][j].getPipe().getNowOutput());

                    } else if (maze[i][j].getPipe().getNowOutput() == Input.TOP) {
                        cell.getPipe().setGreenIcon();
                        return checkCellComplete(maze[i][j], maze[i][j].getPipe().getNowInput());
                    } else {
                        cell.getPipe().setRedIcon();
                        return false;
                    }
                }
        }

        return false;
    }

    private boolean checkInput(Cell cell, Input input){
        if (cell.getPipe() instanceof EmptyPipe){
            return false;
        }
        if (cell.getPipe().getNowInput() == input) {
            return true;
        } else if (cell.getPipe().getNowInput() == input) {
            return true;
        } else {
            return false;
        }
    }
}
