import java.awt.*;
import java.awt.geom.*;

public class Tree implements  DrawingObject{
    
    private Cloud c1;
    private Cloud c2;
    private Cloud c3;
    private Cloud c4;
    private Cloud c5;
    private Cloud c6;
    private Cloud c7;
    private Color green;
    private Rectangle trunk;
    private Line texture1;
    


    public Tree() {
        c1 = new Cloud(0, 0, 0, Color.decode("#318252"));
    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();


        // Drawing the Leaves
        c1.draw(g2d);


        //Drawing the Trunk
        Path2D.Double trunk = new Path2D.Double();
        trunk.moveTo(60, 345);
        trunk.curveTo(0,0, 0, 0, 0, 0);
        trunk.lineTo(0, 0);
        trunk.curveTo(0, 0, 0, 0, 0, 0);
        trunk.closePath();
        g2d.fill(trunk);


        g2d.setTransform(reset);


    }


}
