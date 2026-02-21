import java.awt.*;

public class Moon implements DrawingObject{

    private Circle outer;
    private Circle inner;
    
    public Moon() {
        outer = new Circle(487, 42, 144, Color.decode("#f8d84f"));
        inner = new Circle(527, 44, 122, Color.decode("#0C1445")); //CHANGE TO COLOR OF NIGHT SKY
    }

    @Override
    public void draw(Graphics2D g2d) {
        outer.draw(g2d);
        inner.draw(g2d);
    }
}
