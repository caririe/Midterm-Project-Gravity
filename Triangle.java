import java.awt.*;
import java.awt.geom.*;

public class Triangle {
    private double x1;
    private double x2;
    private double x3;
    private double y1;
    private double y2;
    private double y3;
    private Color color;

    public Triangle(double xStart, double yStart, double xMiddle, double yMiddle, double xEnd, double yEnd, int c) {
        x1 = xStart;
        y1 = yStart;
        x2 = xMiddle;
        y2 = yMiddle;
        x3 = xEnd;
        y3 = yEnd;
        color = new Color(c);
        // check how u want to format color
    }

    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        Path2D.Double triangle = new Path2D.Double();
        triangle.moveTo(x1, y1);
        triangle.lineTo(x2, y2);
        triangle.lineTo(x3, y3);
        triangle.closePath();
        g2d.setColor(color);
        g2d.fill(triangle);

        g2d.setTransform(reset);

    }
    
}
