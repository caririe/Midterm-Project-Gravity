import java.awt.*;
import java.awt.geom.*;

public class House implements DrawingObject{

    private Square leftWall;
    private Square rightWall;
    private Triangle floorUp;
    private Color wallColor;
    private Color roofColor;
    private double size;
    private double xCoor;
    private double yCoor;
    private Rectangle2D door;
    private Path2D roof;
    private Line separator;

    public House(double x, double y, double size, Color lw, Color rw) {
        xCoor = x;
        yCoor = y;
        this.size = size;
        leftWall = new Square(x, y, size, lw);
        floorUp = new Triangle(
            x, y,
            x + size, y,
            x + size/2, y-size,
            lw);
        rightWall = new Square(x+size, y, size, rw);
        door = new Rectangle2D.Double(x+size*0.4, y+size*0.5, size/5, size/2);
        roof = new Path2D.Double();
        roof.moveTo(x, y);
        roof.lineTo(x-size*0.1, y);
        roof.lineTo(x+size*0.47, y-size*1.1);
        roof.lineTo(x+size*1.6, y-size*1.1);
        roof.lineTo(x+size*2.1, y);
        roof.lineTo(x+size, y);
        roof.lineTo(x + size/2, y-size);
        roof.closePath();

    }
    @Override
    public void draw(Graphics2D g2d) {
        leftWall.draw(g2d);
        rightWall.draw(g2d);
        floorUp.draw(g2d);
        g2d.setColor(Color.decode("#4C3228"));
        g2d.fill(door);
        g2d.setColor(Color.RED);
        g2d.fill(roof);
    }
}
