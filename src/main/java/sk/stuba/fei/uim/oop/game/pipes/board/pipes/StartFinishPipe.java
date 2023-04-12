package sk.stuba.fei.uim.oop.game.pipes.board.pipes;

import sk.stuba.fei.uim.oop.game.pipes.board.Input;

public class StartFinishPipe extends BasePipe {

    {
        this.path = "temp//StartFinishPipe.png";
        this.pathDark = "temp//StartFinishPipe_dark.png";
        this.nowInput = Input.BOTTOM;
    }

    public StartFinishPipe(int cellWidth, int cellHeight) {
        super(cellWidth, cellHeight);
        this.setImg();
    }

    public StartFinishPipe() {
        super();
    }
}