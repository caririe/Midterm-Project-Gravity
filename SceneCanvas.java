import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.event.*;;

public class SceneCanvas extends JComponent implements MouseListener{

    private ArrayList<DrawingObject> listDrawingObject;
    private ArrayList<DrawingObject> listFallingObject;
    private DrawingObject falling;
    private int width;
    private int height;
    private javax.swing.Timer cloudTimer;
    private javax.swing.Timer fallingTimer;
    private boolean wind = false;
    private Rectangle sceneArea;
    private boolean dayTime = true;
    private Rectangle2D.Double windButton = new Rectangle2D.Double(665,434,122,37);
    private Rectangle2D.Double timeButton = new Rectangle2D.Double(665,547,122,37);
    private Rectangle2D.Double fallButton = new Rectangle2D.Double(665,343,122,37);
    private Rectangle2D.Double soccerBallArea = new Rectangle2D.Double(666,190,50,50);
    private Rectangle2D.Double dumbbellArea = new Rectangle2D.Double(736,275,50,50);
    private double gravity;

    public SceneCanvas(int w, int h) {
        width = w;
        height = h;
        setPreferredSize(new Dimension(w, h));
        listDrawingObject = new ArrayList<>();
        listFallingObject = new ArrayList<>();
        this.addMouseListener(this);
        gravity = 9.8;
        cloudTimer = new javax.swing.Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                for (DrawingObject o : listDrawingObject) {
                    if (o instanceof Cloud) {
                        ((Cloud) o).move(1);
                    }
                }
                repaint();
            }
        });

        fallingTimer = new javax.swing.Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                for (DrawingObject o : listFallingObject) {
                    if (o instanceof Dumbbell) {
                        ((Dumbbell) o).fall(0.1*gravity);
                    }
                    else if (o instanceof SoccerBall) {
                        ((SoccerBall) o).fall(0.1*gravity);
                    }
                }
                repaint();
            }
        });
        sceneArea = new Rectangle(0, 0, 650, 600, Color.decode("#bdd7ff")); 

        // add to the objects to the list of drawing objects 
        listDrawingObject.add(new Cloud(50, 108, 58, Color.decode("#FFFFFF")));
        listDrawingObject.add(new Cloud(250, 120, 58, Color.decode("#FFFFFF")));
        listDrawingObject.add(new Cloud(450, 97, 58, Color.decode("#FFFFFF")));
        listDrawingObject.add(new Sun(516, 60, 100, Color.decode("#F8D84F"),Color.decode("#F9BE38")));
        listDrawingObject.add(new House(455, 445, 80, Color.decode("#F5F5DC"), Color.decode("#DED1B6")));
        listDrawingObject.add(new Dumbbell(736, 275, 50, Color.decode("#7D7F7C")));
        listDrawingObject.add(new SoccerBall(691, 215));
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
        Circle mountain1 = new Circle(150, 380, 800, Color.decode("#63AD43"));
        Circle mountain2 = new Circle(-200, 400, 800, Color.decode("#63AD43"));
        Rectangle road = new Rectangle(0, 525, 650, 65, Color.decode("#a3a3a3"));
        
        sceneArea.draw(g2d);
        mountain1.draw(g2d);
        mountain2.draw(g2d);
        road.draw(g2d);

        for (DrawingObject i : listDrawingObject) {
            if (i instanceof Cloud) {
                i.draw(g2d);
            }
        }
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

        
        g2d.setColor(Color.RED);
        g2d.fill(fallButton);
        
        g2d.setColor(Color.RED);
        g2d.fill(windButton);

        Rectangle2D.Double leavesButton = new Rectangle2D.Double(665,491,122,37);
        g2d.setColor(Color.GRAY);
        g2d.fill(leavesButton);

        
        g2d.setColor(Color.BLUE);
        g2d.fill(timeButton);

        for (DrawingObject i : listDrawingObject) {
            if (!(i instanceof Cloud)) {
                i.draw(g2d);
            }
        }

        for (DrawingObject i : listFallingObject) {
            i.draw(g2d);
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (windButton.contains(me.getX(), me.getY())){
            if (wind == false) {
                cloudTimer.start();
                wind = true;
                System.out.println("You have turned it on.");
            }
            else {
                cloudTimer.stop(); 
                wind = false;
                System.out.println("You have turned it off.");
            }
            repaint();
        }
        else if (timeButton.contains(me.getX(), me.getY())) {
            if (dayTime) {
                sceneArea.changeColor(Color.decode("#0C1445"));
                for (DrawingObject i : listDrawingObject) {
                    if (i instanceof Cloud) {
                        ((Cloud) i).changeColor(Color.decode("#5C54A4"));
                    }
                }
                dayTime = false;
                System.out.println("You have turned it on.");
            }
            else {
                sceneArea.changeColor(Color.decode("#bdd7ff"));
                for (DrawingObject i : listDrawingObject) {
                    if (i instanceof Cloud) {
                        ((Cloud) i).changeColor(Color.decode("#FFFFFF"));
                    }
                }
                dayTime = true;
                System.out.println("You have turned it off.");
            }
            repaint();
        }
        else if (soccerBallArea.contains(me.getX(), me.getY())) {
            listFallingObject.add(new SoccerBall(250, -50));
            System.out.println("Added a soccerball.");
            repaint();
        }

        else if (dumbbellArea.contains(me.getX(), me.getY())) {
            listFallingObject.add(new Dumbbell(200, -50, 50, Color.GRAY));
            System.out.println("Added a dumbbell.");
            repaint();
        }
        else if (fallButton.contains(me.getX(), me.getY())) {
            fallingTimer.start();
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }
    
}

// https://youtu.be/tHNWIWxRDDA?si=LfyXm-aHgHUYGrYd
// https://youtu.be/0cATENiMsBE?si=tJrkpFH-Zqgjt7pB
// https://youtu.be/0cATENiMsBE?si=ZtyxEfYmZCoNTVxa
// https://youtu.be/jptf1Wd_omw?si=dln4I3_OGvlfPUgi
// https://youtu.be/0cATENiMsBE?si=T33_OPIZlyOza4kQ
// https://medium.com/javarevisited/filtering-a-java-collection-by-type-7c1d611d0d95
// https://stackoverflow.com/questions/4634107/is-there-any-way-to-add-a-mouselistener-to-a-graphic-object

