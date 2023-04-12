package sk.stuba.fei.uim.oop.game.pipes.board.pipes;

import sk.stuba.fei.uim.oop.game.pipes.board.Input;

public class AnglePipe extends BasePipe {

    {
        this.path = "temp//AnglePipe.png";
        this.pathDark = "temp//AnglePipe_dark.png";
        this.nowInput = Input.TOP;
        this.nowOutput = Input.RIGHT;
    }

    public AnglePipe(int cellWidth, int cellHeight) {
        super(cellWidth, cellHeight);
        this.setImg();
    }

    public AnglePipe() {
        super();
    }

}
