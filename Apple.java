/**
This class creates an instance of an Apple object, which is one of the four objects that will be dropped in the simulation. The Apple was created using Path2D objects and an ellipse.
@author Carrie Mae M. Lee (253240) and Reysheil Anne B. Doromal (252022)
@version Febuary 21, 2026
I have not discussed the Java language code in my program
with anyone other than my instructor or the teaching assistants
assigned to this course.
I have not used Java language code obtained from another student,
or any other unauthorized source, either modified or unmodified.
If any Java language code or documentation used in my program
was obtained from another source, such as a textbook or website,
that has been clearly noted with a proper citation in the comments
of my program.
*/

import java.awt.*;
import java.awt.geom.*;

public class Apple implements DrawingObject{

    private double xCoor;
    private double yCoor;
    private double velocity;
    private double angle;

    public Apple(double x, double y) {
        xCoor = x;
        yCoor = y;
        velocity = 0;
        angle = 0;
        // Note that xCoor and yCoor is the CENTER
    }


    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        g2d.rotate(Math.toRadians(angle), xCoor + 25, yCoor + 25);

        Path2D.Double stem = new Path2D.Double();
        stem.moveTo(xCoor+25, yCoor+12);
        stem.curveTo(xCoor+25.6, yCoor+5, xCoor+24.3, yCoor+4.5, xCoor+20, yCoor);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // CITE SOURCE
        g2d.setColor(Color.decode("#874c26"));
        g2d.draw(stem);

        
        Path2D.Double apple = new Path2D.Double();
        apple.moveTo(xCoor+25, yCoor+12);
        apple.curveTo(xCoor+50, yCoor, xCoor+55.2, yCoor+45.5, xCoor+25, yCoor+48.1);
        apple.curveTo(xCoor-5.4, yCoor+45.5, xCoor, yCoor, xCoor+25, yCoor+12);
        apple.closePath();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.decode("#f21818"));
        g2d.fill(apple);


        Ellipse2D.Double leaf = new Ellipse2D.Double(xCoor+25, yCoor+12, 15, 6);
        g2d.rotate(Math.toRadians(-45), xCoor+25, yCoor+12);
        g2d.setColor(Color.decode("#318252"));
        g2d.fill(leaf);
        g2d.rotate(Math.toRadians(45), xCoor+25, yCoor+12);

        g2d.setTransform(reset);
    }

    public void fall(double n) {
        velocity += n;
        yCoor += velocity;
        xCoor += 2;
        angle += velocity * 0.5;

        if (yCoor >= 475) {
            yCoor = 475; // https://stackoverflow.com/questions/609002/bouncing-ball-in-java
            
        }

    }
}