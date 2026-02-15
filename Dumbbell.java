import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Dumbbell implements DrawingObject{

    private double xCoor;
    private double yCoor;
    private double size;
    private Color color;
    private Circle body;
    private Path2D.Double handle;
    private float thickness;

    public Dumbbell(double x, double y, double s, Color c) {
        color = c;
        xCoor = x;
        yCoor = y;
        size = s;
        body = new Circle(xCoor, yCoor, size, color);
        handle = new Path2D.Double();
        handle.moveTo(x + size*0.2, y + size*0.2);
        handle.curveTo(x+size*0.3, y - size*0.5, x+size*0.7, y - size*0.5, x+size*0.8, y+size*0.2);
    }

    @Override
    public void draw (Graphics2D g2d) {
        body.draw(g2d);
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(2));
        g2d.draw(handle);

    }

}