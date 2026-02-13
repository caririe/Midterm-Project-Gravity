import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class Sun implements DrawingObject {

    private Circle core;
    private Triangle ray1;
    private Triangle ray2;
    private Triangle ray3;
    private Triangle ray4;
    private Triangle ray5;
    private Triangle ray6;
    private Triangle ray7;
    private Triangle ray8;
    private double xCoor;
    private double yCoor;
    private double angle;
    
    public Sun(double x, double y, double size, int color) {
        core = new Circle(x-size/2, y-size/2, size, color);
        angle = Math.toRadians(360/8);
        ray1 = new Triangle(x,y,x+size*0.2,y,x+size*0.1,y+size*0.2,color);

    }


    public void draw(Graphics2D g2d) {
        core.draw(g2d);
        ray1.draw(g2d);
    }

}