/**
The Pentagon class is one of the two composite shapes created. It was created using a Path2D object, wherin the distance of the vertices of a Pentagon were manually computed to get the values that will be multipled to the desired size. It will be used to create the center pentagon for the SoccerBall object.
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

public class Pentagon implements DrawingObject{

    private double xCoor;
    private double yCoor;
    private Color color;
    private double size;

    public Pentagon(double x, double y, double s, Color c) {
        // Note that X and Y are coordinates for the center of the pentagon
        xCoor = x;
        yCoor = y;
        color = c;
        size = s;
    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        Path2D.Double pentagon = new Path2D.Double();
        pentagon.moveTo(xCoor, yCoor-(4*size));
        pentagon.lineTo(xCoor-(3.80422606518*size), yCoor-(1.2360679775*size));
        pentagon.lineTo(xCoor-(2.35114100917*size), yCoor+(3.2360679775*size));
        pentagon.lineTo(xCoor+(2.35114100917*size), yCoor+(3.2360679775*size));
        pentagon.lineTo(xCoor+(3.80422606518*size), yCoor-(1.2360679775*size));
        pentagon.closePath();
        g2d.setColor(color);
        g2d.fill(pentagon);

        
        g2d.setTransform(reset);

    }

    public double getX() {
        return xCoor;
    }

    public double getY() {
        return yCoor;
    }



}