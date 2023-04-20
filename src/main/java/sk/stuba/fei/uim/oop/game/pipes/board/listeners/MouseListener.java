package sk.stuba.fei.uim.oop.game.pipes.board.listeners;

import sk.stuba.fei.uim.oop.game.pipes.board.pipes.BasePipe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter {
    private BasePipe basePipe;
    public MouseListener(BasePipe basePipe) {
        this.basePipe = basePipe;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        basePipe.rotateImage();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        basePipe.setDarkIcon();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        basePipe.setCommonIcon();
    }
}
