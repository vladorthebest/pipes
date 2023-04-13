package sk.stuba.fei.uim.oop.game.pipes.board.pipes;

import sk.stuba.fei.uim.oop.game.pipes.board.Cell;
import sk.stuba.fei.uim.oop.game.pipes.board.Input;

public class LinePipe extends BasePipe {

    {
        this.path = "temp//LinePipe.png";
        this.pathDark = "temp//LinePipe_dark.png";
        this.pathGreen = "temp//LinePipe_correct.png";
        this.pathRed = "temp//LinePipe_incorrect.png";
        this.nowInput = Input.TOP;
        this.nowOutput = Input.BOTTOM;
    }

    public LinePipe(int cellWidth, int cellHeight, Cell cell) {
        super(cellWidth, cellHeight, cell);
        this.setImg();
    }

}
