package sk.stuba.fei.uim.oop.game.pipes.board.pipes;

import sk.stuba.fei.uim.oop.game.pipes.board.Cell;
import sk.stuba.fei.uim.oop.game.pipes.board.Input;

public class StartFinishPipe extends BasePipe {

    {
        this.path = "temp//StartFinishPipe.png";
        this.pathDark = "temp//StartFinishPipe_dark.png";
        this.nowInput = Input.BOTTOM;
        this.nowOutput = null;
    }

    public StartFinishPipe(int cellWidth, int cellHeight, Cell cell) {
        super(cellWidth, cellHeight, cell);
        this.setImg();
    }

}