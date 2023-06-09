package sk.stuba.fei.uim.oop.game.pipes.board.pipes;

import sk.stuba.fei.uim.oop.game.pipes.board.maze.Cell;
import sk.stuba.fei.uim.oop.game.pipes.board.maze.Input;
import sk.stuba.fei.uim.oop.game.pipes.board.listeners.MouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.net.URL;

public abstract class BasePipe extends JLabel {
    protected ImageIcon icon;
    protected String path, pathDark, pathGreen, pathRed;
    private int cellWidth, cellHeight;
    private int rotationAngle;
    protected Input nowInput, nowOutput;
    private Cell cell;


    protected BasePipe(int cellWidth, int cellHeight, Cell cell) {
        this.rotationAngle = 0;
        this.cell = cell;
        this.cellHeight = cellHeight;
        this.cellWidth = cellWidth;
        this.addMouseListener(new MouseListener(this));
    }

    protected void setImg() {

        this.icon = new ImageIcon(new ImageIcon(getUrlImg(path)).getImage().getScaledInstance(cellWidth, cellHeight, Image.SCALE_SMOOTH));
        this.setIcon(icon);
        this.setBackground(Color.WHITE);
    }

    private URL getUrlImg(String path) {
        return getClass().getClassLoader().getResource(path);
    }

    private Image rotate(Image image, double degrees) {
        int width = image.getWidth(null);
        int height = image.getHeight(null);

        // Создаем объект AffineTransform для поворота изображения
        AffineTransform transform = new AffineTransform();
        transform.rotate(Math.toRadians(degrees), width/2, height/2);

        // Создаем новый BufferedImage с повернутым изображением
        BufferedImage rotatedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotatedImage.createGraphics();
        g2d.setTransform(transform);
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();

        return rotatedImage;
    }

    private void rotateInputs(){

        if(nowOutput != null)
            nowOutput = nowOutput.rotate();

        if(nowInput != null)
            nowInput = nowInput.rotate();
    }

    public void rotateImage() {
        Image originalImage = icon.getImage();

        rotationAngle += 90; // увеличиваем угол поворота на 90 градусов

        Image rotatedImage = rotate(originalImage,  rotationAngle);

        ImageIcon rotatedIcon = new ImageIcon(rotatedImage.getScaledInstance(cellWidth, cellHeight, Image.SCALE_SMOOTH));

        this.setIcon(rotatedIcon);
        rotateInputs();
    }

    private void setAngle() {
        Image originalImage = icon.getImage();

        Image rotatedImage = rotate(originalImage,  rotationAngle);

        ImageIcon rotatedIcon = new ImageIcon(rotatedImage.getScaledInstance(cellWidth, cellHeight, Image.SCALE_SMOOTH));

        this.setIcon(rotatedIcon);
    }

    public void setDarkIcon(){
        this.icon = new ImageIcon(new ImageIcon(getUrlImg(pathDark)).getImage().getScaledInstance(cellWidth, cellHeight, Image.SCALE_SMOOTH));
        this.setIcon(icon);
        setAngle();
    }

    public void setCommonIcon(){
        this.icon = new ImageIcon(new ImageIcon(getUrlImg(path)).getImage().getScaledInstance(cellWidth, cellHeight, Image.SCALE_SMOOTH));
        this.setIcon(icon);
        setAngle();
    }

    public Input getNowOutput() {
        return nowOutput;
    }

    public Input getNowInput() {
        return nowInput;
    }

    public void setGreenIcon(){
        this.icon = new ImageIcon(new ImageIcon(getUrlImg(pathGreen)).getImage().getScaledInstance(cellWidth, cellHeight, Image.SCALE_SMOOTH));
        this.setIcon(icon);
        setAngle();
    }

    public void setRedIcon(){
        this.icon = new ImageIcon(new ImageIcon(getUrlImg(pathRed)).getImage().getScaledInstance(cellWidth, cellHeight, Image.SCALE_SMOOTH));
        this.setIcon(icon);
        setAngle();
    }
}
