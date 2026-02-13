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

    public SceneCanvas getCanvas(){
        return sceneCanvas;
    }
        

    public void setUpGUI() {
        frame.setTitle("Midterm Project - Doromal - Lee");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        
        // what this does is that it automatically resizes the components
        frame.setVisible(true);
    }

}
