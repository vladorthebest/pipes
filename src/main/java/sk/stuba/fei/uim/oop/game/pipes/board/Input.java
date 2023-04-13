package sk.stuba.fei.uim.oop.game.pipes.board;

public enum Input {
    TOP, RIGHT, BOTTOM, LEFT;

    public Input rotate() {
        // получаем индекс текущего элемента
        int currentIndex = this.ordinal();
        // вычисляем индекс следующего элемента
        int nextIndex = (currentIndex + 1) % values().length;
        // возвращаем следующий элемент
        return values()[nextIndex];
    }
}