import java.awt.*;
import java.awt.geom.*;

public class Pentagon implements DrawingObject{

    private double xCoor;
    private double yCoor;
    private Color color;
    private double size;

    public Pentagon(double x, double y, Color c, double s) {
        // Note that X and Y are coordinates for the center of the pentagon
        xCoor = x;
        yCoor = y;
        color = c;
        size = s;
    }

    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        Path2D.Double pentagon = new Path2D.Double();
        pentagon.moveTo(xCoor*size, (yCoor+4)*size);
        pentagon.lineTo((xCoor+3.80422606518)*size, (yCoor+1.2360679775)*size);
        pentagon.lineTo((xCoor+2.35114100917)*size, (yCoor-3.2360679775)*size);
        pentagon.lineTo((xCoor-2.35114100917)*size, (yCoor-3.2360679775)*size);
        pentagon.lineTo((xCoor-3.80422606518)*size, (yCoor+1.2360679775)*size);
        pentagon.closePath();
        g2d.setColor(color);
        g2d.fill(pentagon);

        g2d.setTransform(reset);

    }



}