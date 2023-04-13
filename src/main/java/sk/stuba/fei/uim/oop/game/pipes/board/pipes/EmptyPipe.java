package sk.stuba.fei.uim.oop.game.pipes.board.pipes;

import sk.stuba.fei.uim.oop.game.pipes.board.Cell;

public class EmptyPipe extends BasePipe {

    {
        this.path = "temp//EmptyPipe.png";
        this.pathDark = "temp//EmptyPipe_dark.png";
    }

    public EmptyPipe(int cellWidth, int cellHeight, Cell cell) {
        super(cellWidth, cellHeight, cell);
        setImg();
    }


}
