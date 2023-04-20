package sk.stuba.fei.uim.oop.game.pipes.board.pipes;

import sk.stuba.fei.uim.oop.game.pipes.board.maze.Cell;

public class EmptyPipe extends BasePipe {

    {
        this.path = "EmptyPipe.png";
        this.pathDark = "EmptyPipe_dark.png";
        this.pathGreen = "EmptyPipe.png";
        this.pathRed = "EmptyPipe.png";
    }

    public EmptyPipe(int cellWidth, int cellHeight, Cell cell) {
        super(cellWidth, cellHeight, cell);
        setImg();
    }


}
