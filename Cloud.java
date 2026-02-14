import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class Cloud implements DrawingObject{

    private Color color;
    private double xCoor;
    private double yCoor; 
    private Circle el1;
    private Circle el2;
    private Circle el3;
    private Circle el4;
    private double size;

    public Cloud(double x, double y, double s, Color c) {
        color = c;
        xCoor = x;
        yCoor = y;
        size = s;
        el1 = new Circle(xCoor, yCoor, size, color);
        el2 = new Circle(xCoor+size*0.3, yCoor-size*0.3, size, color);
        el3 = new Circle(xCoor+size*0.6, yCoor, size, color);
        el4 = new Circle(xCoor+size*0.3, yCoor+size*0.3, size, color);
    }


    @Override
    public void draw(Graphics2D g2d) {
        el1.draw(g2d);
        el2.draw(g2d);
        el3.draw(g2d);
        el4.draw(g2d);
    }
}