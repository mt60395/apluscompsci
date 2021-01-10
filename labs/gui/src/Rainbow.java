import javax.swing.*;
import java.awt.*;

public class Rainbow extends JFrame {
    public Rainbow() {
        setSize(250, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new Arcs());
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (.5 * (screensize.width - getWidth())), (int) (.5 * (screensize.height - getHeight())), getWidth(), getHeight());
    }

    public static void main(String[] args) {
        new Rainbow();
    }

    private class Arcs extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Color[] c = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, new Color(48, 28, 75), new Color(90, 41, 91), Color.WHITE};
            // I just picked close colors.
            for (int i = 0; i < c.length; i++) {
                g.setColor(c[i]);
                int w = getWidth();
                int h = getHeight();
                g.fillArc(i * (w / 18), i * (h / 18), w - i * (w / 9), h - i * (h / 9), 0, 180);
                // I put random numbers that look sort of right.
            }
        }
    }
}
