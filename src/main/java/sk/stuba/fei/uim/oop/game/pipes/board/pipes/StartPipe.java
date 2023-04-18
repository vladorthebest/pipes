package sk.stuba.fei.uim.oop.game.pipes.board.pipes;

import sk.stuba.fei.uim.oop.game.pipes.board.Cell;
import sk.stuba.fei.uim.oop.game.pipes.board.Input;

public class StartPipe extends BasePipe {

    {
        this.path = "StartPipe.png";
        this.pathDark = "StartPipe_dark.png";
        this.pathGreen = "StartFinishPipe_correct.png";
        this.pathRed = "StartFinishPipe_incorrect.png";
        this.nowInput = Input.BOTTOM;
        this.nowOutput = null;
    }

    public StartPipe(int cellWidth, int cellHeight, Cell cell) {
        super(cellWidth, cellHeight, cell);
        this.setImg();
    }

}