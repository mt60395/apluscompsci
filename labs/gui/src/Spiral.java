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
            int y = 0; // decrement
            int x = 10;
            for (int i = 0; i < 6; i++) {
                g.drawLine(400 - x, 450 - y, 400 - x, y + 32);
                y += 32;
                g.drawLine(400 - x, y, x, y);
                g.drawLine(x, y, x, 450 - y);
                g.drawLine(x, 450 - y, 400 - x - 32, 450 - y);
                x += 32;
            }
            g.drawLine(400 - x, 450 - y, 400 - x, y + 32);
        }
    }
}
