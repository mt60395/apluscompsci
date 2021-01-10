import javax.swing.*;
import java.awt.*;

public class RandomShapes extends JFrame {
    public RandomShapes() {
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new Shapes());
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (.5 * (screensize.width - getWidth())), (int) (.5 * (screensize.height - getHeight())), getWidth(), getHeight());
    }

    public static void main(String[] args) {
        new RandomShapes();
    }

    private class Shapes extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int i = 0; i < 10; i++) {
                Color[] colors = {Color.black, Color.blue, Color.cyan, Color.gray, Color.green, Color.lightGray, Color.magenta, Color.orange, Color.pink, Color.red, Color.white, Color.yellow};
                Color c = colors[(int) (Math.random() * 10)];
                g.setColor(c);

                int x = ((int) (Math.random() * getWidth()));
                int y = ((int) (Math.random() * getHeight()));

                int sizeX = ((int) (Math.random() * getWidth() / 2));
                int sizeY = ((int) (Math.random() * getHeight() / 2));

                if ((int) (Math.random() * 2) == 0) {
                    g.fillOval(x, y, sizeX, sizeY);
                }
                else {
                    g.fillRect(x, y, sizeX, sizeY);
                }
            }
        }
    }
}
