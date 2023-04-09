package sk.stuba.fei.uim.oop.game.pipes.board;

import java.util.Random;

class Cell {
    boolean isVisited = false;
    Input input, output;
    int value;
    int i, j;
    Random random = new Random();
    public Cell(int i, int j){
        this.i = i;
        this.j = j;
        this.value = random.nextInt(100);
    }
    public Cell(int value){
        this.value = 100;
    }
    public int getValue() {
        return value;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
