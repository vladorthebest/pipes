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
        System.out.println(maze[0][startJ].getValue()+ "  "+ maze[size-1][finishJ].getValue());

        for(int i =0; i<maze.length; i++){
            for(int j =0; j<maze.length; j++){
                System.out.print(maze[i][j].getValue() +"  ");
            }
            System.out.println();
        }
        path.add(maze[0][startJ]);
//        req(path.getLast().i, path.getLast().j);
        while (path.getLast().i != size-1 || path.getLast().j != finishJ){
          req(path.getLast().i, path.getLast().j);
        }

        for(Cell cell:path){
            System.out.print(cell.getValue() + "  ");
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
            req(neighbours.getFirst().i, neighbours.getFirst().j);
        }
        return true;
    }
    public static void main(String[] args) {
        Maze maze = new Maze(8);

    }
}
