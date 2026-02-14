import java.awt.*;
import java.awt.geom.*;

public class Square implements DrawingObject {

    private double xCoor;
    private double yCoor;
    private double size;
    private Color color;

    public Square(double x, double y, double s, Color c) {
        xCoor = x;
        yCoor = y;
        size = s;
        color = c;
    }

    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        Rectangle2D.Double square = new Rectangle2D.Double(xCoor, yCoor, size, size);
        g2d.setColor(color);
        g2d.fill(square);

        g2d.setTransform(reset);

    }
    
}
