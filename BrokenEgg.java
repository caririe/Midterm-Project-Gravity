import java.awt.*;
import java.awt.geom.*;

public class BrokenEgg implements DrawingObject{

    private double xCoor;
    private double yCoor;
    private Line line1;
    private Line line2;
    private Line line3;
    private Line line4;
    private Line line5;


    public BrokenEgg(double x, double y) {
        xCoor = x;
        yCoor = y;
        line1 = new Line(xCoor+5, yCoor+38, xCoor+13, yCoor+26, 2, Color.decode("#81583d"));
        line2 = new Line(xCoor+13, yCoor+26, xCoor+21, yCoor+38, 2, Color.decode("#81583d"));
        line3 = new Line(xCoor+21, yCoor+38, xCoor+29, yCoor+26, 2, Color.decode("#81583d"));
        line4 = new Line(xCoor+29, yCoor+26, xCoor+37, yCoor+38, 2, Color.decode("#81583d"));
        line5 = new Line(xCoor+37, yCoor+38, xCoor+45, yCoor+26, 2, Color.decode("#81583d"));
        
    }

    @Override
    public void draw(Graphics2D g2d) {

        AffineTransform reset = g2d.getTransform();

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

        g2d.setTransform(reset);

        line1.draw(g2d);
        line2.draw(g2d);
        line3.draw(g2d);
        line4.draw(g2d);
        line5.draw(g2d);
    }

    }