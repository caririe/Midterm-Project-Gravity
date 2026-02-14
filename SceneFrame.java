import java.awt.*;
import javax.swing.*;

public class SceneFrame {

    private int width;
    private int height;
    private JFrame frame;
    private SceneCanvas sceneCanvas;
    

    public SceneFrame(int w, int h) {
        width = w;
        height = h;
        frame = new JFrame();
        sceneCanvas = new SceneCanvas(w,h);
    }

    public void setUpGUI() {
        Container contentPane = frame.getContentPane();
        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(800, 600));
        contentPane.add(mainPanel);
        mainPanel.add(sceneCanvas);
        frame.setTitle("Midterm Project - Doromal - Lee");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
