package sk.stuba.fei.uim.oop.game.pipes.board.maze;

import sk.stuba.fei.uim.oop.game.pipes.board.pipes.*;

import java.util.Random;

public class Cell {
    private boolean isVisited;
    private Input input, output;

    private int value;
    private int i, j;
    private BasePipe pipe;

    public Cell(int i, int j){
        Random random = new Random();
        isVisited = false;
        this.i = i;
        this.j = j;
        this.value = random.nextInt(100);
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


    public void setInput(Input input) {
        this.input = input;
    }

    public void setOutput(Input output) {
        this.output = output;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }


    public BasePipe createPipe(int cellWidth, int cellHeight){
        if (pipe != null){
            return pipe;
        }
        if(this.input == null && this.output == null){
            this.pipe = new EmptyPipe(cellWidth, cellHeight, this);
            return pipe;
        }

        if( this.input == this.output.mirror()) {
            this.pipe = new LinePipe(cellWidth, cellHeight, this);
        } else {
            this.pipe = new AnglePipe(cellWidth, cellHeight, this);
        }
        updateNowInputs();

        return pipe;
    }

    public void setStartPipe(int cellWidth, int cellHeight){
        this.pipe = new StartPipe(cellWidth, cellHeight, this);
        updateNowInputs();
    }

    public void setFinishPipe(int cellWidth, int cellHeight){
        this.pipe = new FinishPipe(cellWidth, cellHeight, this);
        updateNowInputs();
    }


    public void updateNowInputs(){
    }

    public BasePipe getPipe() {
        return pipe;
    }
}
