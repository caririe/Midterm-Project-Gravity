import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.geom.*;

public class SceneCanvas extends JComponent{

    private ArrayList<DrawingObject> listDrawingObject;
    private int width;
    private int height;

    public SceneCanvas(int w, int h) {
        width = w;
        height = h;
        setPreferredSize(new Dimension(800, 600));
        listDrawingObject = new ArrayList<>();
        // add to the objects to the list of drawing objects 
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Color mainFrameColor = Color.decode("#000000");
        Color menuFrameColor = Color.decode("#ffffff");
        

        RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        g2d.setRenderingHints(rh);

        Rectangle2D.Double mainFrame = new Rectangle2D.Double(0, 0, 600, 600); // check if resizable
            g2d.setColor(mainFrameColor);
            g2d.fill(background);

        Rectangle2D.Double panelFrame = new Rectangle2D.Double(0, 0, 600, 600); // check if resizable
            g2d.setColor(mainFrameColor);
            g2d.fill(background);
          
        
        for (DrawingObject i : listDrawingObject) {
            i.draw(g2d);
        }

        // Draw the objects 
        
    }

    
}
