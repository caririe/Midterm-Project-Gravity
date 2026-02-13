import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class Cloud implements DrawingObject{

    private ArrayList<Circle> clouds;
    private Color color;
    private double xCoor;
    private double yCoor; 

    public Cloud(Color c) {
        color = c;
    }


    @Override
    public void draw(Graphics2D g2d) {
        
    }



    
    
}