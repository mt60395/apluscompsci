import javax.swing.*;
import java.awt.*;

public class Spiral extends JFrame {
    public Spiral() {
        setSize(400, 450);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new Lines());
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (.5 * (screensize.width - getWidth())), (int) (.5 * (screensize.height - getHeight())), getWidth(), getHeight());
    }

    public static void main(String[] args) {
        new Spiral();
    }

    private class Lines extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            int y = 10; // decrement
            int x = 10;
            int w = getWidth();
            int h = getHeight();
            for (int i = 0; i < 6; i++) {
                g.drawLine(w - x, h - y, w - x, y + 32);
                y += 32;
                g.drawLine(w - x, y, x, y);
                g.drawLine(x, y, x, h - y);
                g.drawLine(x, h - y, w - x - 32, h - y);
                x += 32;
            }
            g.drawLine(w - x, h - y, w - x, y + 32);
        }
    }
}
