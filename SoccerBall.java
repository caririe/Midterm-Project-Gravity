/**
The SoccerBall class uses a Pentagon object and several Lines, Elipses, and Triangles to create a SoccerBall. It uses the rotate method and simply rotates the line, triangle, and ellipse object by 72 degrees in order to fill the Soccer Ball.
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

public class SoccerBall implements DrawingObject{

    private double xCoor;
    private double yCoor;
    private Pentagon pentagon;
    private Circle circle;
    private Line line1;
    private Line line2;
    private Line line3;
    private Line line4;
    private Line line5;
    private Triangle triangle1;
    public double velocity = 0;

    public SoccerBall(double x, double y) {
        // Note that X and Y are coordinates for the center of the ball
        xCoor = x;
        yCoor = y;
        circle = new Circle(xCoor - 25, yCoor - 25, 50, Color.WHITE);
        pentagon = new Pentagon(xCoor, yCoor, 2.3, Color.BLACK);
        line1 = new Line(xCoor, yCoor, xCoor, yCoor-20, 1, Color.BLACK);
        // line2 = new Line(xCoor, yCoor, xCoor+17, yCoor-5, 1, Color.BLACK);
        // line3 = new Line(xCoor, yCoor, xCoor+10, yCoor+15, 1, Color.BLACK);
        // line4 = new Line(xCoor, yCoor, xCoor-10, yCoor+15, 1, Color.BLACK);
        // line5 = new Line(xCoor, yCoor, xCoor-17, yCoor-5, 1, Color.BLACK);
        triangle1 = new Triangle(xCoor, yCoor-15, x-7, y-23, x+7, y-23, Color.BLACK);
    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

       circle.draw(g2d);
       pentagon.draw(g2d);
       line1.draw(g2d);
       triangle1.draw(g2d);

       Ellipse2D.Double el1 = new Ellipse2D.Double(xCoor-7, yCoor-25, 14, 4);
       g2d.setColor(Color.BLACK);
       g2d.fill(el1);

       // Make more elegant later using loop
       for (int i = 0; i < 4; i++) {
            g2d.rotate(Math.toRadians(72), xCoor, yCoor);
            triangle1.draw(g2d);
            line1.draw(g2d);
            g2d.fill(el1);
       }

        g2d.setTransform(reset);
    }

    public void fall(double n) {
        velocity += n;
        yCoor += velocity;
        xCoor += 2;

        if (yCoor >= 500) {
            yCoor = 500; // https://stackoverflow.com/questions/609002/bouncing-ball-in-java
            velocity *= -0.88;
            
            if (Math.abs(velocity) < 0.5) {
                velocity = 0;
                yCoor = 500; // https://stackoverflow.com/questions/609002/bouncing-ball-in-java
            }
        }

        circle = new Circle(xCoor - 25, yCoor - 25, 50, Color.WHITE);
        pentagon = new Pentagon(xCoor, yCoor, 2.3, Color.BLACK);
        line1 = new Line(xCoor, yCoor, xCoor, yCoor-20, 1, Color.BLACK);
        // line2 = new Line(xCoor, yCoor, xCoor+17, yCoor-5, 1, Color.BLACK);
        // line3 = new Line(xCoor, yCoor, xCoor+10, yCoor+15, 1, Color.BLACK);
        // line4 = new Line(xCoor, yCoor, xCoor-10, yCoor+15, 1, Color.BLACK);
        // line5 = new Line(xCoor, yCoor, xCoor-17, yCoor-5, 1, Color.BLACK);
        triangle1 = new Triangle(xCoor, yCoor-15, xCoor-7, yCoor-23, xCoor+7, yCoor-23, Color.BLACK);
    }


}