package sk.stuba.fei.uim.oop.game.pipes.board.pipes;

import sk.stuba.fei.uim.oop.game.pipes.board.maze.Cell;
import sk.stuba.fei.uim.oop.game.pipes.board.maze.Input;

public class LinePipe extends BasePipe {

    {
        this.path = "LinePipe.png";
        this.pathDark = "LinePipe_dark.png";
        this.pathGreen = "LinePipe_correct.png";
        this.pathRed = "LinePipe_incorrect.png";
        this.nowInput = Input.TOP;
        this.nowOutput = Input.BOTTOM;
    }

    public LinePipe(int cellWidth, int cellHeight, Cell cell) {
        super(cellWidth, cellHeight, cell);
        this.setImg();
    }

}
