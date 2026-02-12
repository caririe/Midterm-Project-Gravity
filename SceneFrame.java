import javax.swing.*;

public class SceneFrame {

    private int width;
    private int height;
    private JFrame frame;
    

    public SceneFrame() {

    }

    public void setUpGUI() {
        frame.setTitle("Midterm Project - Doromal - Lee");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // what this does is that it automatically resizes the components
        frame.setVisible(true);
    }

}
