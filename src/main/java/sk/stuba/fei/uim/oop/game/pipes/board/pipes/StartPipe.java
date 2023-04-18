package sk.stuba.fei.uim.oop.game.pipes.board.pipes;

import sk.stuba.fei.uim.oop.game.pipes.board.Cell;
import sk.stuba.fei.uim.oop.game.pipes.board.Input;

public class StartPipe extends BasePipe {

    {
        this.path = "temp//StartPipe.png";
        this.pathDark = "temp//StartPipe_dark.png";
        this.pathGreen = "temp//StartFinishPipe_correct.png";
        this.pathRed = "temp//StartFinishPipe_incorrect.png";
        this.nowInput = Input.BOTTOM;
        this.nowOutput = null;
    }

    public StartPipe(int cellWidth, int cellHeight, Cell cell) {
        super(cellWidth, cellHeight, cell);
        this.setImg();
    }

}