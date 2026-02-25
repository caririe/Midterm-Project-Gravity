import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;;

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
    private Rectangle2D.Double appleArea = new Rectangle2D.Double(666,264,50,60);
    private Rectangle2D.Double eggArea = new Rectangle2D.Double(736,192,50,50);
    private Rectangle2D.Double leftButton = new Rectangle2D.Double(669,97,30,30);
    private Rectangle2D.Double rightButton = new Rectangle2D.Double(756,97,30,30);
    private double gravity;
    private Font buttonFont;
    private Font labelFont;

    public SceneCanvas(int w, int h) {
        width = w;
        height = h;
        setPreferredSize(new Dimension(w, h));
        listDrawingObject = new ArrayList<>();
        listFallingObject = new ArrayList<>();
        sceneArea = new Rectangle(0, 0, 650, 600, Color.decode("#bdd7ff")); 
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
                boolean allFallen = true;
                for (int i = listFallingObject.size() - 1; i >=0; i--) {
                    DrawingObject o = listFallingObject.get(i);
                    if (o instanceof Dumbbell) {
                        ((Dumbbell) o).fall(0.1*gravity);
                    }
                    else if (o instanceof SoccerBall) {
                        ((SoccerBall) o).fall(0.1*gravity);
                    }
                    else if (o instanceof Apple ) {
                        ((Apple) o).fall(0.1*gravity);
                    }
                    else if (o instanceof Egg ) {
                        ((Egg) o).fall(0.1*gravity); 
                        if (((Egg) o).getY() >= 500) {
                            listFallingObject.set(i, new BrokenEgg(o.getX(), o.getY()));
                        }
                    }
                    if (o.getY() < 500) {
                        allFallen = false;
                    }
                }
                if (allFallen) {
                    fallingTimer.stop();
                }
                repaint();
            }
                
        });
        

        // add to the objects to the list of drawing objects 
        for (int i = 0; i < 7; i++) {
            listDrawingObject.add(new Cloud(Math.random()*650, Math.random()*340 + 20, 58, new Color (255, 255, 255, 180)));
        }
        listDrawingObject.add(new Sun(516, 60, 100, Color.decode("#F8D84F"),Color.decode("#F9BE38")));
        listDrawingObject.add(new House(455, 445, 80, Color.decode("#F5F5DC"), Color.decode("#DED1B6")));
        listDrawingObject.add(new Dumbbell(736, 275, 50, Color.decode("#7D7F7C")));
        listDrawingObject.add(new SoccerBall(691, 215));
        listDrawingObject.add(new Tree());
        listDrawingObject.add(new Apple(666, 275));
        listDrawingObject.add(new Egg(735, 179));
        // listDrawingObject.add(new BrokenEgg(400, 300));
    }


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
        Rectangle road = new Rectangle(0, 525, 650, 75, Color.decode("#a3a3a3"));
        Rectangle roadLine1 = new Rectangle(50, 560, 100, 10, Color.decode("#f8d84f"));
        Rectangle roadLine2 = new Rectangle(203, 560, 100, 10, Color.decode("#f8d84f"));
        Rectangle roadLine3 = new Rectangle(357, 560, 100, 10, Color.decode("#f8d84f"));
        Rectangle roadLine4 = new Rectangle(516, 560, 100, 10, Color.decode("#f8d84f"));
        
        
        sceneArea.draw(g2d);
        mountain1.draw(g2d);
        mountain2.draw(g2d);
        road.draw(g2d);
        roadLine1.draw(g2d);
        roadLine2.draw(g2d);
        roadLine3.draw(g2d);
        roadLine4.draw(g2d);


        for (DrawingObject i : listDrawingObject) {
            if (i instanceof Cloud) {
                i.draw(g2d);
            }
        }

        for (DrawingObject i : listFallingObject) {
            i.draw(g2d);
        }


        
        // MENU
        Rectangle2D.Double menuArea = new Rectangle2D.Double(650, 0, 150, 600); 
        g2d.setColor(Color.decode("#ffffff"));
        g2d.fill(menuArea);

        Rectangle2D.Double menuBarHeading = new Rectangle2D.Double(650, 0, 150, 50); 
        g2d.setColor(Color.decode("#e1bb15"));
        g2d.fill(menuBarHeading);

        Square leftButton = new Square(669, 97, 30, Color.GRAY);
        Square rightButton = new Square(756, 97, 30, Color.GRAY);
        leftButton.draw(g2d);
        rightButton.draw(g2d);

        
        g2d.setColor(Color.decode("#9d1800"));
        g2d.fill(fallButton);
        
        g2d.setColor(Color.decode("#08234b"));
        g2d.fill(windButton);

        Rectangle2D.Double leavesButton = new Rectangle2D.Double(665,491,122,37);
        g2d.setColor(Color.decode("#045211"));
        g2d.fill(leavesButton);

        
        g2d.setColor(Color.decode("#420754"));
        g2d.fill(timeButton);


        g2d.setColor(Color.WHITE);
        buttonFont = new Font("Arial", Font.BOLD, 20);
        g2d.setFont(buttonFont);
        g2d.drawString("-", 680, 118);
        g2d.drawString("+", 765, 119);
        g2d.drawString("FALL", 703, 368);
        g2d.drawString("WIND", 700, 460);
        g2d.drawString("LEAVES", 690, 517);
        g2d.drawString("TIME", 703, 574);
        g2d.drawString("MENU", 695, 35);
        g2d.setColor(Color.BLACK);
        g2d.drawString(String.format("%.1f", gravity), 712, 119);

        g2d.setColor(Color.BLACK);
        labelFont = new Font("Arial", Font.PLAIN, 18);
        g2d.setFont(labelFont);
        g2d.drawString("Gravity Level", 675, 78);
        g2d.drawString("Object Selection", 660, 160);
        g2d.drawString("Scene Setting", 667, 415);
        
        

        for (DrawingObject i : listDrawingObject) {
            if (!(i instanceof Cloud)) {
                i.draw(g2d);
            }
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
                Object removeSun = null;
                for (DrawingObject i : listDrawingObject) {
                    if (i instanceof Sun) {
                        removeSun = i;
                    }
                }
                listDrawingObject.remove(removeSun);
                listDrawingObject.add(new Moon());
                for (DrawingObject i : listDrawingObject) {
                    if (i instanceof Cloud) {
                        ((Cloud) i).changeColor(new Color (92, 84, 164, 180));
                    }
                }
                dayTime = false;
                System.out.println("You have turned it on.");
            }
            else {
                sceneArea.changeColor(Color.decode("#bdd7ff"));
                Object removeMoon = null;
                for (DrawingObject i : listDrawingObject) {
                    if (i instanceof Moon) {
                        removeMoon = i;
                    }
                }
                listDrawingObject.remove(removeMoon);
                listDrawingObject.add(new Sun(516, 60, 100, Color.decode("#F8D84F"),Color.decode("#F9BE38")));
                for (DrawingObject i : listDrawingObject) {
                    if (i instanceof Cloud) {
                        ((Cloud) i).changeColor(new Color (255, 255, 255, 180));
                    }
                }
                dayTime = true;
                System.out.println("You have turned it off.");
            }
            repaint();
        }
        else if (soccerBallArea.contains(me.getX(), me.getY())) {
            listFallingObject.add(new SoccerBall(Math.random()*600, -50));
            System.out.println("Added a soccerball.");
            repaint();
        }

        else if (dumbbellArea.contains(me.getX(), me.getY())) {
            listFallingObject.add(new Dumbbell(200, -50, 50, Color.GRAY));
            System.out.println("Added a dumbbell.");
            repaint();
        }

        else if (eggArea.contains(me.getX(), me.getY())) {
            listFallingObject.add(new Egg(200, -50));
            System.out.println("Added an egg.");
            repaint();
        }

        else if (appleArea.contains(me.getX(), me.getY())) {
            listFallingObject.add(new Apple(300, -50));
            System.out.println("Added an apple.");
            repaint();
        }
        else if (fallButton.contains(me.getX(), me.getY())) {
            fallingTimer.start();
            repaint();
        }
        else if (leftButton.contains(me.getX(), me.getY())) {
            if (gravity > 2 && gravity < 12) { gravity -= 0.1;}
            
            repaint();
        }

        else if (rightButton.contains(me.getX(), me.getY())) {
            if (gravity > 2 && gravity < 12) { gravity += 0.1;}
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

    public void resetFalling() {
        fallingTimer.stop();
        listFallingObject.clear();
        repaint();
    }
    
}

// https://youtu.be/tHNWIWxRDDA?si=LfyXm-aHgHUYGrYd
// https://youtu.be/0cATENiMsBE?si=tJrkpFH-Zqgjt7pB
// https://youtu.be/0cATENiMsBE?si=ZtyxEfYmZCoNTVxa
// https://youtu.be/jptf1Wd_omw?si=dln4I3_OGvlfPUgi
// https://youtu.be/0cATENiMsBE?si=T33_OPIZlyOza4kQ
// https://medium.com/javarevisited/filtering-a-java-collection-by-type-7c1d611d0d95
// https://stackoverflow.com/questions/4634107/is-there-any-way-to-add-a-mouselistener-to-a-graphic-object
// https://stackoverflow.com/questions/4286982/how-do-you-generate-a-random-number-within-a-given-limit-using-the-actionscript
// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://stackoverflow.com/questions/58240025/how-to-draw-any-text-using-drawstring-in-java

