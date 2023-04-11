package sk.stuba.fei.uim.oop.game.pipes.board.pipes;

public class LinePipe extends BasePipe {

    {
        this.path = "temp//LinePipe.png";
    }

    public LinePipe(int cellWidth, int cellHeight) {
        super(cellWidth, cellHeight);
        this.setImg();
    }

    public LinePipe() {
        super();
    }

}