import java.awt.*;
import java.awt.geom.*;

public class Sun implements DrawingObject {

    private Circle core;
    private Triangle ray;
    private double xCoor;
    private double yCoor;
    private double centerX;
    private double centerY;
    private double angle;
    private Color coreColor;
    private Color rayColor;
    private double size;
    
    public Sun(double x, double y, double s, Color cc, Color rc) {
        xCoor = x;
        yCoor = y;
        size = s;
        centerX = x+size/2;
        centerY = y+size/2;
        rayColor = rc;
        coreColor = cc;
        angle = Math.toRadians(360/8);

        core = new Circle(xCoor, yCoor, size, coreColor);
        ray = new Triangle(
            centerX - size*0.25,centerY-size*0.47,
            centerX + size*0.25,centerY-size*0.47,
            centerX, centerY - size*0.75,
            rayColor);
    }

    public void draw(Graphics2D g2d) {
        core.draw(g2d);

        AffineTransform reset = g2d.getTransform();

        ray.draw(g2d);
        g2d.rotate(angle, centerX, centerY);
        ray.draw(g2d);
        g2d.rotate(angle, centerX, centerY);
        ray.draw(g2d);
        g2d.rotate(angle, centerX, centerY);
        ray.draw(g2d);
        g2d.rotate(angle, centerX, centerY);
        ray.draw(g2d);
        g2d.rotate(angle, centerX, centerY);
        ray.draw(g2d);
        g2d.rotate(angle, centerX, centerY);
        ray.draw(g2d);
        g2d.rotate(angle, centerX, centerY);
        ray.draw(g2d);

        g2d.setTransform(reset);
        

    }

}