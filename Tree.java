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

    public Tree() {
        green = Color.decode("#318252");
        trunk = new Rectangle(60, 300, 80, 225, Color.decode("#874c26"));
        c1 = new Cloud(-30, 318, 50, green);
        c2 = new Cloud(-58, 236, 50, green);
        c3 = new Cloud(26, 207, 50, green);
        c4 = new Cloud(113, 228, 50, green);
        c5 = new Cloud(142, 269, 50, green);
        c6 = new Cloud(88, 314, 50, green);
        c7 = new Cloud(36, 277, 50, green);
    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        trunk.draw(g2d);

        // Drawing the Leaves
        c1.draw(g2d);
        c2.draw(g2d);
        c3.draw(g2d);
        c4.draw(g2d);
        c5.draw(g2d);
        c6.draw(g2d);
        c7.draw(g2d);


        g2d.setTransform(reset);


    }


}
