import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

public class PaintEditor extends JFrame {
    private static int brushSize; // thickness of the lines. it's an index that represents the brush size in a list
    private static ArrayList<DrawingPath> paths; // contains all the lines drawn
    private static Color primaryColor; // primary color, deals with left click
    private static Color secondaryColor; // secondary color, deals with right click
    private static DrawingPanel drawPanel; // drawing panel

    public PaintEditor() {
        super("Blackboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(635, 550);
        setResizable(false);
        setLayout(new BorderLayout());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height - getHeight())), getWidth(), getHeight()); // spawns in the middle

        primaryColor = Color.BLACK;
        secondaryColor = Color.WHITE;
        brushSize = 1;
        paths = new ArrayList<>();

        JPanel holder = new JPanel(); // allows for the drawing panel to be confined properly?
        drawPanel = new DrawingPanel();
        holder.add(drawPanel);
        add(holder, BorderLayout.CENTER);

        JPanel misc = new JPanel(); // panel that holds settings for the lines drawn
        misc.setPreferredSize(new Dimension(110, 500));
        misc.setLayout(new FlowLayout());

        misc.add(createColors());
        misc.add(createBrushes());
        misc.add(addClear());
        add(misc, BorderLayout.EAST);

        setVisible(true); // go after everything
    }

    public static void main(String[] args) {
        new PaintEditor();
    }

    /**
     * createColors creates the label that shows primary/secondary colors and the palette to pick and choose colors from.
     * Left click to choose a primary color from the palette, right click to choose a secondary color from the palette.
     * @return JPanel with display and palette to be added to the miscellaneous JPanel
     */
    private JPanel createColors() {
        JPanel colorPanels = new JPanel(); // contains both JPanels
        colorPanels.setLayout(new FlowLayout());
        colorPanels.setPreferredSize(new Dimension(100, 260));

        // create labels of current primary and secondary colors
        JLabel primary = new JLabel();
        primary.setPreferredSize(new Dimension(40, 40));
        primary.setBackground(primaryColor);
        primary.setOpaque(true); // required

        JLabel secondary = new JLabel();
        secondary.setPreferredSize(new Dimension(40, 40));
        secondary.setBackground(secondaryColor);
        secondary.setOpaque(true);

        JPanel display = new JPanel();
        display.setPreferredSize(new Dimension(100, 50));
        display.setLayout(new FlowLayout());
        display.add(primary);
        display.add(secondary);

        colorPanels.add(display);

        // create palette
        ButtonGroup group = new ButtonGroup();
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder("Colors"));
        panel.setLayout(new GridLayout(5, 2));

        // list of available colors. create buttons from all of them
        final Color[] colors = new Color[]{Color.BLACK, Color.DARK_GRAY, Color.GRAY, Color.BLUE, Color.GREEN, Color.CYAN, Color.RED, Color.MAGENTA, Color.YELLOW, Color.WHITE};
        for (Color c : colors) {
            JButton button = new JButton();
            button.setBackground(c);
            button.setPreferredSize(new Dimension(35, 35));
            group.add(button);
            panel.add(button);
            button.addMouseListener(new MouseAdapter() { // use the buttons on the color palette to change colors
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON1) { // set primary color with left click
                        primaryColor = c;
                        primary.setBackground(c);
                    }
                    else { // set secondary color with right click
                        secondaryColor = c;
                        secondary.setBackground(c);
                    }
                }
            });
        }
        colorPanels.add(panel);
        return colorPanels;
    }

    /**
     * Creates options for choosing the brush size.
     * @return JPanel with brush options to be added to the miscellaneous JPanel
     */
    private JPanel createBrushes() {
        ButtonGroup group = new ButtonGroup();
        JRadioButton[] radioButtons = new JRadioButton[4]; // added so indexes (brushSize) can be used for scrolling with the mouse
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder("Brush"));
        panel.setLayout(new GridLayout(4, 1));
        String[] sizes = new String[]{"Small", "Medium", "Large", "Stupendous"}; // sizes to create radio buttons from
        for (int i = 1; i <= sizes.length; i++) { // start at 1 to use as a factor in multiplication (size of brush)
            JRadioButton button = new JRadioButton(sizes[i - 1]);
            group.add(button); // only allow one size to be chosen at once
            radioButtons[i - 1] = button;
            panel.add(button);
            if (i == 1) {
                button.setSelected(true); // small is selected by default
            }
            final int finalI = i; // requires to be assigned so it can work in mouseClicked
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    brushSize = finalI;
                }
            });
        }
        panel.addMouseWheelListener(new MouseAdapter() { // scroll through brush sizes
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int delta = e.getWheelRotation();
                if (delta < 0 && brushSize > 1) { // scroll up, go backwards. Do not go less than 1.
                    brushSize--;
                }
                else if (delta > 0 && brushSize < 4) { // scroll down, go forwards. Do not go more than 4.
                    brushSize++;
                }
                radioButtons[brushSize - 1].setSelected(true); // brushSize starts at 1, but lists are at 0
            }
        });
        return panel;
    }

    /**
     * This adds the clear drawing button.
     * @return JButton to be added to the miscellaneous JPanel
     */
    private JButton addClear() {
        JButton clear = new JButton("Clear");
        clear.addActionListener(a -> {
            paths.clear(); // clear all lines
            drawPanel.index = 0; // the next line will be at index 0
            repaint(); // clear drawings now
        });
        return clear;
    }

    /**
     * The DrawingPanel class has the drawing functionality.
     */
    private static class DrawingPanel extends JPanel {
        private int index; // used to know if the mouse dragging it needs a new line or is just updating an existing one

        public DrawingPanel() {
            setPreferredSize(new Dimension(500, 500)); // super necessary
            index = 0;
            addMouseFunc();
        }

        /**
         * This separate method adds mouse functionality to avoid bloating the constructor.
         */
        public void addMouseFunc() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) { // mouse clicks are one and done
                    GeneralPath generalPath = new GeneralPath();
                    generalPath.moveTo(e.getX(), e.getY()); // required
                    generalPath.lineTo(e.getX(), e.getY()); // one line, to the single dot
                    DrawingPath drawingPath = new DrawingPath(
                            brushSize * 5,
                            e.getButton() == MouseEvent.BUTTON1 ? primaryColor : secondaryColor, // left:right
                            generalPath
                    );
                    paths.add(drawingPath);
                    repaint();
                }
            });

            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) { // mouse drags are either newly created or updated
                    if (index == paths.size()) { // create new line
                        GeneralPath generalPath = new GeneralPath();
                        generalPath.moveTo(e.getX(), e.getY()); // required
                        DrawingPath drawingPath = new DrawingPath(
                                brushSize * 5,
                                SwingUtilities.isLeftMouseButton(e) ? primaryColor : secondaryColor, // left:right
                                generalPath
                        );
                        paths.add(drawingPath);
                    }
                    else { // update an existing line. color/stroke doesn't change.
                        DrawingPath drawingPath = paths.get(index);
                        drawingPath.lineTo(e.getX(), e.getY());
                    }
                    repaint();
                }
            });

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    index++; // click has finished. A new DrawingPath is added, update index.
                }
            });
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2D = (Graphics2D) g;
            for (DrawingPath p : paths) { // create all the drawn lines
                g2D.setColor(p.getColor());
                g2D.setStroke(p.getStroke());
                g2D.draw(p.getPath());
            }
            g2D.dispose();
        }
    }

    /**
     * DrawingPath is a class that allows for properties like color and stroke to be used while drawing with
     * the GeneralPath.
     */
    private static class DrawingPath {
        private final BasicStroke stroke;
        private final Color color;
        private final GeneralPath path;

        public DrawingPath(int s, Color c, GeneralPath p) {
            stroke = new BasicStroke(s);
            color = c;
            path = p;
        }

        public BasicStroke getStroke() {
            return stroke;
        }

        public Color getColor() {
            return color;
        }

        public GeneralPath getPath() {
            return path;
        }

        public void lineTo(float x, float y) { // updating the path by drawing to a point.
            path.lineTo(x, y);
        }
    }
}
