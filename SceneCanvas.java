import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.geom.*;

public class SceneCanvas extends JComponent {

    private ArrayList<DrawingObject> listDrawingObject;
    private int width;
    private int height;

    public SceneCanvas(int w, int h) {
        width = w;
        height = h;
        setPreferredSize(new Dimension(w, h));
        listDrawingObject = new ArrayList<>();

        // add to the objects to the list of drawing objects 
        listDrawingObject.add(new Sun(516, 60, 100, Color.decode("#F8D84F"),Color.decode("#F9BE38")));
        listDrawingObject.add(new Cloud(50, 108, 58, Color.decode("#FFFFFF")));
        listDrawingObject.add(new House(455, 445, 80, Color.decode("#F5F5DC"), Color.decode("#DED1B6")));
        listDrawingObject.add(new Dumbbell(736, 275, 50, Color.decode("#7D7F7C")));
    }

    // test

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;


        RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        g2d.setRenderingHints(rh);

        //SCENE AREA
        Rectangle2D.Double sceneArea = new Rectangle2D.Double(0, 0, 650, 600);
        g2d.setColor(Color.decode("#bdd7ff"));
        g2d.fill(sceneArea);

        Ellipse2D.Double plains = new Ellipse2D.Double();
        Circle mountain1 = new Circle(150, 380, 800, Color.decode("#63AD43"));
        mountain1.draw(g2d);

        Circle mountain2 = new Circle(-200, 400, 800, Color.decode("#63AD43"));
        mountain2.draw(g2d);

        Rectangle2D.Double road = new Rectangle2D.Double(0, 525, 650, 65);
        g2d.setColor(Color.decode("#a3a3a3"));
        g2d.fill(road);


        // MENU
        Rectangle2D.Double menuArea = new Rectangle2D.Double(650, 0, 150, 600); // check if resizable
        g2d.setColor(Color.decode("#ffffff"));
        g2d.fill(menuArea);

        Rectangle2D.Double menuBarHeading = new Rectangle2D.Double(650, 0, 150, 50); // check if resizable
        g2d.setColor(Color.decode("#a9a9a9"));
        g2d.fill(menuBarHeading);

        Square leftButton = new Square(669, 97, 30, Color.GRAY);
        Square rightButton = new Square(756, 97, 30, Color.GRAY);
        leftButton.draw(g2d);
        rightButton.draw(g2d);

        Rectangle2D.Double fallButton = new Rectangle2D.Double(665,343,122,37);
        g2d.setColor(Color.RED);
        g2d.fill(fallButton);

        Rectangle2D.Double windButton = new Rectangle2D.Double(665,434,122,37);
        g2d.setColor(Color.RED);
        g2d.fill(windButton);

        Rectangle2D.Double leavesButton = new Rectangle2D.Double(665,491,122,37);
        g2d.setColor(Color.GRAY);
        g2d.fill(leavesButton);

        Rectangle2D.Double timeButton = new Rectangle2D.Double(665,547,122,37);
        g2d.setColor(Color.BLUE);
        g2d.fill(timeButton);

        
        // Loop to Create the Objects
        for (DrawingObject i : listDrawingObject) {
            i.draw(g2d);
        }

        // Draw the objects 
        
    }
    
}
