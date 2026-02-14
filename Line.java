import java.awt.*;
import java.awt.geom.*;

public class Line implements DrawingObject{

    private double xStartCoor;
    private double yStartCoor;
    private double xEndCoor;
    private double yEndCoor;
    private float thickness;
    private Color color;

    public Line(double xStart, double yStart, double xEnd, double yEnd, float t, Color c) {
        xStartCoor = xStart;
        yStartCoor = yStart;
        xEndCoor = xEnd;
        yEndCoor = yEnd;
        thickness = t;
        color = c;
        // check how u want to format color
    }

    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();
        
        Line2D.Double line = new Line2D.Double(xStartCoor, yStartCoor, xEndCoor, yEndCoor);
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(thickness));
        g2d.fill(line);

        g2d.setTransform(reset);
        // not sure if we with rendering hits here

    }
    
}
