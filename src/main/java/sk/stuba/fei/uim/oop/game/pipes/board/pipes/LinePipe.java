package sk.stuba.fei.uim.oop.game.pipes.board.pipes;

import sk.stuba.fei.uim.oop.game.pipes.board.Input;

public class LinePipe extends BasePipe {

    {
        this.path = "temp//LinePipe.png";
        this.pathDark = "temp//LinePipe_dark.png";
        this.nowInput = Input.TOP;
        this.nowOutput = Input.BOTTOM;
    }

    public LinePipe(int cellWidth, int cellHeight) {
        super(cellWidth, cellHeight);
        this.setImg();
    }

    public LinePipe() {
        super();
    }

}
