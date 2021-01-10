import javax.swing.*;
import java.awt.*;

public class Drawing extends JFrame {
    public Drawing() {
        setTitle("Drawing");
        setSize(new Dimension(300, 300));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new DrawingPanel());

        //centers the frame
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (.5 * (screensize.width - getWidth())), (int) (.5 * (screensize.height - getHeight())), getWidth(), getHeight());
    }

    public static void main(String[] args) {
        new Drawing();
    }

    private class DrawingPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int w = getWidth();
            int h = getHeight();

            // your code goes here
            for (int i = 1; i < w / 10; i++) {
                int a = i * (h / 10);
                int b = w - a;
                g.drawLine(0, 0, b, a);
            }
            for (int i = 1; i < w / 10; i++) {
                int a = i * ( h / 10);
                int b = w - a;
                g.drawLine(w, h, b, a);
            }
            for (int i = 1; i < w / 10; i++) {
                int a = i * (h / 10);
                int b = w - a;
                g.drawLine(w, 0, a, a);
            }
            for (int i = 1; i < w / 10; i++) {
                int a = i * (h / 10);
                int b = w - a;
                g.drawLine(0, h, a, a);
            }
        }
    }
}
