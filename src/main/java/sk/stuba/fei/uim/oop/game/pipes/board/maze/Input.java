package sk.stuba.fei.uim.oop.game.pipes.board.maze;

public enum Input {
    TOP, RIGHT, BOTTOM, LEFT;

    public Input rotate() {
        int currentIndex = this.ordinal();
        int nextIndex = (currentIndex + 1) % values().length;
        return values()[nextIndex];
    }

    public Input mirror() {
        int currentIndex = this.ordinal();
        int nextIndex = (currentIndex + 2) % values().length;
        return values()[nextIndex];
    }
}