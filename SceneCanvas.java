import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.geom.*;

public class SceneCanvas extends JComponent{

    private ArrayList<DrawingObject> listDrawingObject;

    public SceneCanvas() {
        setPreferredSize(new Dimension(800, 600));
        listDrawingObject = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Color backgroundColor = new Color.decode("#000000");
        Color panelColor = new Color.decode("#ffffff");

        RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        g2d.setRenderingHint(null, rh);

        Rectangle2D.Double background = new Rectangle2D.Double(0, 0, width, height);
        Rectangle2D.Double panel = new Rectangle2D.Double(0, 0, width, height);

        // Draw the objects 
        
    }

    
}
