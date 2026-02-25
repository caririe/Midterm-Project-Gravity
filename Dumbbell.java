/**
The Dumbbell class creates a Dumbell object, which is 
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

public class Dumbbell implements DrawingObject{

    private double xCoor;
    private double yCoor;
    private double size;
    private Color color;
    private Circle body;
    private Path2D.Double handle;
    private float thickness;
    private double velocity = 0;

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

    public void fall(double n){
        velocity += n;
        yCoor += velocity;

        if (yCoor >= 475) { 
            yCoor = 475;
            velocity = 0;
        }
        body = new Circle(xCoor, yCoor, size, color);
        handle = new Path2D.Double();
        handle.moveTo(xCoor + size*0.2, yCoor + size*0.2);
        handle.curveTo(xCoor+size*0.3, yCoor - size*0.5, xCoor+size*0.7, yCoor - size*0.5, xCoor+size*0.8, yCoor+size*0.2);
    }  
    
    public double getX() {
        return xCoor;
    }

    public double getY() {
        return yCoor;
    }

}


/* 

public class Dumbbell implements DrawingObject{

    private double xCoor;
    private double yCoor;
    private Color color;
    private Circle body;
    private Path2D.Double handle;
    private float thickness;
    private double velocity = 0;

    public Dumbbell(double x, double y) {
        xCoor = x;
        yCoor = y;
        body = new Circle(xCoor, yCoor, xCoor + 40, color);
    }

    @Override
    public void draw (Graphics2D g2d) {
        body.draw(g2d);
        Path2D.Double handle = new Path2D.Double();
        handle.moveTo(x + size*0.2, y + size*0.2);
        handle.curveTo(x+size*0.3, y - size*0.5, x+size*0.7, y - size*0.5, x+size*0.8, y+size*0.2);
        Ellipse2D.Double labelArea = new Ellipse2D.Double(12, 25, 26, 20);
        g2d.setColor(Color.decode("#7D7F7C"));


        g2d.setColor(Color.decode("#575555"));
        g2d.fill(labelArea);
        g2d.drawString("10kg", Double.intValue(17+xCoor), Double.intValue(17+xCoor));
        g2d.draw(handle);
    }

    public void fall(double n){
        velocity += n;
        yCoor += velocity;

        if (yCoor >= 475) { 
            yCoor = 475;
            velocity = 0;
        }
        body = new Circle(xCoor, yCoor, size, color);
        handle = new Path2D.Double();
        handle.moveTo(xCoor + size*0.2, yCoor + size*0.2);
        handle.curveTo(xCoor+size*0.3, yCoor - size*0.5, xCoor+size*0.7, yCoor - size*0.5, xCoor+size*0.8, yCoor+size*0.2);
    }   

    public double getX() {
        return xCoor;
    }

    public double getY() {
        return yCoor;
    }

}

*/