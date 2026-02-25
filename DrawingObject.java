/**
The DrawingObject interface is implemented by all of the objects that will be drawn in this program. It serves as a blueprint or contract that the other classes must follow to ensure that they all implement the draw() method. It contains only one method since not all DrawingObjects are required to move or be animated.
@author Carrie Mae M. Lee (253240) and Reysheil Anne B. Doromal (252022)
@version Febuary 21, 2026
I have not discussed the Java language code in my program
with anyone other than my instructor or the teaching assistants
assigned to this course.
I have not used Java language code obtained from another student,
or any other unauthorized source, either modified or unmodified.
If any Java language code or documentation used in my program
was obtained from another source, such as a textbook or website,
that has been clearly noted with a proper citation in the comments
of my program.
*/

import java.awt.*;

public interface DrawingObject {
    public void draw(Graphics2D g2d);
    public double getX();
    public double getY();
} 