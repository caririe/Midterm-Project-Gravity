import java.awt.*;
import java.awt.geom.*;

public class SoccerBall implements DrawingObject{

    private double xCoor;
    private double yCoor;
    private Pentagon pentagon;
    private Line line1;
    private Line line2;
    private Line line3;
    private Line line4;
    private Line line5;
    private Triangle triangle1;
    private Triangle triangle2;
    private Triangle triangle3;
    private Triangle triangle4;
    private Triangle triangle5;

    public SoccerBall(double x, double y) {
        // Note that X and Y are coordinates for the center of the ball
        xCoor = x;
        yCoor = y;
        pentagon = new Pentagon(x, y, Color.BLACK, 30); // adjust/check size

    }

    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();












        g2d.setTransform(reset);
    }



    


}