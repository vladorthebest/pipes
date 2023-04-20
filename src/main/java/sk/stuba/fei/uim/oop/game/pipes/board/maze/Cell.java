package sk.stuba.fei.uim.oop.game.pipes.board.maze;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.game.pipes.board.pipes.*;

import java.util.Random;

public class Cell {
    @Getter @Setter
    private boolean isVisited;
    @Setter
    private Input input, output;
    @Getter
    private int value;
    @Getter
    private int i, j;
    @Getter
    private BasePipe pipe;

    public Cell(int i, int j){
        Random random = new Random();
        isVisited = false;
        this.i = i;
        this.j = j;
        this.value = random.nextInt(100);
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

        return pipe;
    }

    public void setStartPipe(int cellWidth, int cellHeight){
        this.pipe = new StartPipe(cellWidth, cellHeight, this);
    }

    public void setFinishPipe(int cellWidth, int cellHeight){
        this.pipe = new FinishPipe(cellWidth, cellHeight, this);
    }


}
