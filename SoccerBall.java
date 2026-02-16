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

    public SoccerBall(double x, double y) {
        // Note that X and Y are coordinates for the center of the ball
        xCoor = x;
        yCoor = y;
        circle = new Circle(xCoor - 25, yCoor - 25, 50, Color.WHITE);
        pentagon = new Pentagon(xCoor, yCoor, 2.3, Color.BLACK); // adjust/check size
        line1 = new Line(xCoor, yCoor, xCoor, yCoor-20, 1, Color.BLACK);
        line2 = new Line(xCoor, yCoor, xCoor+17, yCoor-5, 1, Color.BLACK);
        line3 = new Line(xCoor, yCoor, xCoor+10, yCoor+15, 1, Color.BLACK);
        line4 = new Line(xCoor, yCoor, xCoor-10, yCoor+15, 1, Color.BLACK);
        line5 = new Line(xCoor, yCoor, xCoor-17, yCoor-5, 1, Color.BLACK);
        triangle1 = new Triangle(xCoor, yCoor-15, x-7, y-23, x+7, y-23, Color.BLACK);
    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

       circle.draw(g2d);
       pentagon.draw(g2d);
       line1.draw(g2d);
       line2.draw(g2d);
       line3.draw(g2d);
       line4.draw(g2d);
       line5.draw(g2d);
       triangle1.draw(g2d);

       Ellipse2D.Double el1 = new Ellipse2D.Double(xCoor-7, yCoor-25, 14, 4);
       g2d.setColor(Color.BLACK);
       g2d.fill(el1);

       // Make more elegant later using loop
       for (int i = 0; i < 4; i++) {
            g2d.rotate(Math.toRadians(72), xCoor, yCoor);
            triangle1.draw(g2d);
            g2d.fill(el1);
       }

        g2d.setTransform(reset);
    }


}