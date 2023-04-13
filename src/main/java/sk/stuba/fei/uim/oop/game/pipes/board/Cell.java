package sk.stuba.fei.uim.oop.game.pipes.board;

import sk.stuba.fei.uim.oop.game.pipes.board.pipes.*;

import java.util.Random;

public class Cell {
    private boolean isVisited = false;
    private Input input, output;
    private Input nowInput, nowOutput;

    private int value;
    private int i, j;
    private TypePipe typePipe;
    private BasePipe pipe;
    private int cellWidth, cellHeight;
    Random random = new Random();
    public Cell(int i, int j){
        this.i = i;
        this.j = j;
        this.value = random.nextInt(100);
    }

    public void setNowInput(Input nowInput) {
        this.nowInput = nowInput;
    }

    public void setNowOutput(Input nowOutput) {
        this.nowOutput = nowOutput;
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

    public Input getInput(){
        return this.input;
    }

    public Input getOutput() {
        return output;
    }

    public BasePipe createPipe(int cellWidth, int cellHeight){
        if(this.input == null && this.output == null){
            this.pipe = new EmptyPipe(cellWidth, cellHeight, this);
            return pipe;
        }

        if(this.input == null || this.output == null){
            this.pipe = new StartFinishPipe(cellWidth, cellHeight, this);
            updateNowInputs();
            return pipe;
        }
        if(
                ((this.input == Input.TOP || this.input == Input.BOTTOM) &&   (this.output == Input.TOP || this.output == Input.BOTTOM)) ||
                        ((this.input == Input.RIGHT || this.input == Input.LEFT) &&   (this.output == Input.RIGHT || this.output == Input.LEFT))
        ) {
            this.pipe = new LinePipe(cellWidth, cellHeight, this);
        } else {
            this.pipe = new AnglePipe(cellWidth, cellHeight, this);
        }
        updateNowInputs();

        return pipe;
    }

    public void updateNowInputs(){
        nowInput = this.pipe.getNowInput();
        nowOutput = this.pipe.getNowOutput();
    }

    public boolean isComplete(){
        return ((input == nowInput && output == nowOutput) || (output == nowInput && input == nowOutput));
    }

    public BasePipe getPipe() {
        return pipe;
    }
}
