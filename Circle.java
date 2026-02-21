/**
The Circle class is one of the three required classes that will be used to create a circle from an Ellipse2D object that has the same width and height. This class is used frequently in other classes such as the Sun, SoccerBall, and Cloud classes. 
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

public class Circle implements DrawingObject{

    private double xCoor;
    private double yCoor;
    private double size;
    private Color color;

    public Circle(double x, double y, double s, Color c) {
        xCoor = x;
        yCoor = y;
        size = s;
        color = c;
        // check how u want to format color
    }

    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        Ellipse2D.Double circle = new Ellipse2D.Double(xCoor, yCoor, size, size);
        g2d.setColor(color);
        g2d.fill(circle);

        g2d.setTransform(reset);

    }

    public void changeColor(Color c) {
        color = c;
    }


    

    
}
