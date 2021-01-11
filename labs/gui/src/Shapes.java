import javax.swing.*;
import java.awt.*;

public class Shapes extends JFrame {
    String shape = "";
    public Shapes() {
        setSize(100, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if (ask.a().equals("2")) shape = "Oval";
        add(new SquaresOvals());

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (.5 * (screensize.width - getWidth())), (int) (.5 * (screensize.height - getHeight())), getWidth(), getHeight());
    }

    public static void main(String[] args) {
        new Shapes();
    }

    private static class ask extends JOptionPane {
        public static String a() {
            return JOptionPane.showInputDialog("Enter 1 to draw rectangles\nEnter 2 to draw ovals");
        }
    }

    private class SquaresOvals extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int i = 0; i < 10; i++) {
                int x = i * 10;
                if (shape.equals("")) {
                    g.drawRect(x + 10, x + 10, x + 40, x + 40);
                }
                else {
                    g.drawOval(x + 10, x + 10, x + 40, x + 40);
                }
            }
        }
    }
}
