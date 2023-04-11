package sk.stuba.fei.uim.oop.game.pipes.board.pipes;

public class AnglePipe extends BasePipe {

    {
        this.path = "temp//AnglePipe.png";
    }

    public AnglePipe(int cellWidth, int cellHeight) {
        super(cellWidth, cellHeight);
        this.setImg();
    }

    public AnglePipe() {
        super();
    }

}
