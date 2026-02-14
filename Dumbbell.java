import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Dumbbell implements DrawingObject{

    private double xCoor;
    private double yCoor;
    private double size;
    private Color color;
    private Circle body;
    private Line handle;
    private float thickness;

    public Dumbbell(double x, double y, double s, Color c, float t) {
        color = c;
        xCoor = x;
        yCoor = y;
        size = s;
        body = new Circle(xCoor, yCoor, size, color);
        handle = new Line(xCoor + size*0.2, yCoor + size*0.2, xCoor + size*0.8, yCoor + size*0.2, thickness, color);
    }

    @Override
    public void draw (Graphics2D g2d) {
        body.draw(g2d);
        handle.draw(g2d);

    }

}