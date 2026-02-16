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
    private Circle el5;
    private Circle el6;
    private Circle el7;
    private double size;

    public Cloud(double x, double y, double s, Color c) {
        color = c;
        xCoor = x;
        yCoor = y;
        size = s;
        el1 = new Circle(xCoor, yCoor, size, color);
        el2 = new Circle(xCoor+size*0.5, yCoor-size*0.46, size*1.18, color);
        el3 = new Circle(xCoor+size*1.29, yCoor-size*0.65, size*1.29, color);
        el4 = new Circle(xCoor+size*1.93, yCoor-size*0.27, size*1.29, color);
        el5 = new Circle(xCoor+size*2.08, yCoor+size*0.06, size*1.29, color);
        el6 = new Circle(xCoor+size*1.29, yCoor+size*0.31, size*1.29, color);
        el7 = new Circle(xCoor+size*0.77, yCoor+size*0.27, size*1.29, color);
    }

    public double getX() {
        return xCoor;
    }

    public void move(double n){
        xCoor += n;
        if (xCoor > 650) {
            xCoor = -200;
        }

        el1 = new Circle(xCoor, yCoor, size, color);
        el2 = new Circle(xCoor+size*0.5, yCoor-size*0.46, size*1.18, color);
        el3 = new Circle(xCoor+size*1.29, yCoor-size*0.65, size*1.29, color);
        el4 = new Circle(xCoor+size*1.93, yCoor-size*0.27, size*1.29, color);
        el5 = new Circle(xCoor+size*2.08, yCoor+size*0.06, size*1.29, color);
        el6 = new Circle(xCoor+size*1.29, yCoor+size*0.31, size*1.29, color);
        el7 = new Circle(xCoor+size*0.77, yCoor+size*0.27, size*1.29, color);
    }

    @Override
    public void draw(Graphics2D g2d) {
        el1.draw(g2d);
        el2.draw(g2d);
        el3.draw(g2d);
        el4.draw(g2d);
        el5.draw(g2d);
        el6.draw(g2d);
        el7.draw(g2d);
    }
}