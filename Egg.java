import java.awt.*;
import java.awt.geom.*;

public class Egg implements DrawingObject{

    private double xCoor;
    private double yCoor;
    private double velocity;

    public Egg(double x, double y) {
        xCoor = x;
        yCoor = y;
    }

    @Override
    public void draw(Graphics2D g2d) {

        Ellipse2D.Double bottom = new Ellipse2D.Double(xCoor+7, yCoor+32, 40, 29);
        Ellipse2D.Double top = new Ellipse2D.Double(xCoor+13, yCoor+2, 28, 35);
        g2d.setColor(Color.decode("#f4aa7e"));
        g2d.fill(top);
        g2d.fill(bottom);


        Ellipse2D.Double right = new Ellipse2D.Double(xCoor+17, yCoor+3, 31, 55);
        Ellipse2D.Double left = new Ellipse2D.Double(xCoor+5, yCoor+3, 31, 55);
        g2d.rotate(Math.toRadians(-12), xCoor+33, yCoor+30);
        g2d.fill(right);
        g2d.rotate(Math.toRadians(12), xCoor+33, yCoor+30);
        g2d.rotate(Math.toRadians(12), xCoor+21, yCoor+30);
        g2d.fill(left);
        g2d.rotate(Math.toRadians(-12), xCoor+21, yCoor+30);

        

        Ellipse2D.Double highlight = new Ellipse2D.Double(xCoor+13, yCoor+11, 5, 20);
        g2d.setColor(Color.decode("#facaac"));
        g2d.rotate(Math.toRadians(20), xCoor+15, yCoor+21);
        g2d.fill(highlight);
        g2d.rotate(Math.toRadians(-20), xCoor+15, yCoor+21);

    }

    public double getX() {
        return xCoor;
    }

    public double getY() {
        return yCoor;
    }

    public void fall(double n) {
        velocity += n;
        yCoor += velocity;

        if (yCoor >= 500) {
            yCoor = 500;
            velocity = 0;
        }

    }
}