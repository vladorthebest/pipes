package sk.stuba.fei.uim.oop.game.pipes.menu.buttons;

import javax.swing.*;

public class Slider extends JSlider {
    public Slider(){
        super(JSlider.HORIZONTAL, 8, 12, 8);
        this.setMajorTickSpacing(1);
        this.setPaintTicks(true);
        this.setPaintLabels(true);
    }


}
