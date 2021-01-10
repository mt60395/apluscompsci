import javax.swing.*;
import java.awt.*;

public class Drawing2 extends JFrame {
    public Drawing2() {
        setTitle("Drawing2");
        setSize(new Dimension(300, 300));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new DrawingPanel2());

        //centers the frame
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (.5 * (screensize.width - getWidth())), (int) (.5 * (screensize.height - getHeight())), getWidth(), getHeight());
    }

    public static void main(String[] args) {
        new Drawing2();
    }

    private class DrawingPanel2 extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int w = getWidth();
            int h = getHeight();

            for (int i = 0; i < w / 25; i++) {
                g.drawLine(0, i * (h / 20), i * (w / 20), h);
            }
            for (int i = 0; i < w / 25; i++) {
                g.drawLine(i * (w / 20), 0, w, i * (h / 20));
            }
            for (int i = 0; i < w / 25; i++) {
                g.drawLine(w - i * (w / 20), 0, 0, i * (h / 20));
            }
            for (int i = 0; i < w / 25; i++) {
                g.drawLine(i * (w / 20), h, w, h - i * (h / 20));
            }
        }
    }
}
