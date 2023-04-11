package sk.stuba.fei.uim.oop.game.pipes.board;

import java.util.LinkedList;
import java.util.Random;

class Maze{
    Cell[][] maze;
    LinkedList<Cell> path = new LinkedList<>();
    int size = 8;
    Random random = new Random();
    int startJ;
    int finishJ;

    public LinkedList<Cell> getPath() {
        return path;
    }

    public Maze(int size){
        if(size<3){
            System.out.println("Small size!!! (size can't be < 3)");
        }else {
            this.size = size;
        }


        maze = new Cell[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                maze[i][j] = new Cell(i, j);
            }
        }
        createStartFinish();

        path.add(maze[0][startJ]);
//        req(path.getLast().i, path.getLast().j);
        while (path.getLast().getI() != size-1 || path.getLast().getJ() != finishJ){
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
            System.out.println(path.get(i).getOutput() + "  " + path.get(i+1).getInput());
        }

        for(int i=0; i<path.size(); i++) {

        }
    }

    private void createStartFinish(){
        startJ = random.nextInt(size-1);
        finishJ = random.nextInt(size-1);
    }

    public Cell[][] getMaze(){
        return maze;
    }


    public boolean req(int nowI, int nowJ){
        if(!path.contains(maze[nowI][nowJ]))
            path.add(maze[nowI][nowJ]);
        maze[nowI][nowJ].setVisited(true);
        LinkedList<Cell> neighbours = new LinkedList<>();

        if(nowI == size-1 && nowJ == finishJ){
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
//        for(Cell cell:neighbours){
//            System.out.print(cell.getValue() + "  ");
//        }
//        System.out.println();
        if(neighbours.isEmpty()){
            path.removeLast();
//            req(path.getLast().i, path.getLast().j);
        }else {
            req(neighbours.getFirst().getI(), neighbours.getFirst().getJ());
        }
        return true;
    }


    public static void main(String[] args) {
        Maze maze = new Maze(8);

    }
}
