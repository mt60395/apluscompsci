// minimalist guess the color game. no bloat 🙅
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuessTheColor extends JFrame {
    private static JFrame f;

    private static JLabel correct; // The color to guess, set as the background of a JLabel
    private static int R;
    private static int G;
    private static int B;

    private static JLabel guess; // The current color guessed, set as the background of another JLabel
    private static int guessR = 0;
    private static int guessG = 0;
    private static int guessB = 0;

    private static int step; // default steps.
    // My approach was to do only valid factors of 255,
    // though you can do any number by using modulus.
    // For easy, medium, and hard, it is: (15, 5, 1).

    // Extra: Timer and Clicks
    private static Timer t;
    private static int seconds;
    private static int count;
    private static JLabel clicks;

    public GuessTheColor() {
        f = new JFrame("Guess the Color");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 175);
        f.setVisible(true);
        count = 0;
        setDifficulty();
        createGUI();
        genColors(); // Generate the random colors to guess
        initExtras();
    }

    public static void main(String[] args) {
        new GuessTheColor();
    }

    /**
     * Sets the difficulty (variable step) based on the user's input.
     */
    private static void setDifficulty() {
        while (step == 0) {
            String difficulty = JOptionPane.showInputDialog(null, "Difficulty? (easy || medium || hard)");
            switch (difficulty) {
                case "easy":
                    step = 15;
                    break;
                case "medium":
                    step = 5;
                    break;
                case "hard":
                    step = 1;
                    break;
            }
        }
        System.out.printf("New difficulty/increment set: %d\n", step);
    }

    /**
     * Create the gui.
     * It consists of 2 JLabels (the colors) and the buttons for the game.
     */
    private static void createGUI() {
        JPanel top = new JPanel();  // panel will be holding the 2 labels
        // This label shows the current color derived from the user's guessed R, G, and B values.
        guess = new JLabel();
        guess.setOpaque(true);
        guess.setBackground(Color.BLACK);
        guess.setPreferredSize(new Dimension(50, 50));

        // This label shows the correct color for the user to guess.
        correct = new JLabel();
        correct.setBackground(Color.GRAY);
        correct.setOpaque(true);
        correct.setPreferredSize(new Dimension(50, 50));

        top.add(guess);
        top.add(correct);
        f.getContentPane().add(top, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        for (Color c: new Color[]{Color.RED, Color.GREEN, Color.BLUE}) {
            for (JButton b: createButtons(c)) {
                buttonPanel.add(b);
            }
        }

        f.getContentPane().add(buttonPanel, BorderLayout.CENTER);
    }

    /**
     * Create buttons with listeners that manipulate the values of the guessed R G and B.
     *
     * @param c the color. Each color correlates with a different value of the guess being manipulated.
     * @return the j button array returned is to be added to the button panel and GUI
     */
    private static JButton[] createButtons(Color c) {
        JButton add = new JButton("+");
        JButton min = new JButton("-");
        add.setBackground(c);
        min.setBackground(c);

        add.addActionListener((ActionEvent a) -> { // Increment a value of the current guess by 5.
            // Checks to make sure it doesn't increment past 255.
            if (c == Color.RED && guessR != 255) {
                guessR += step;
            }
            else if (c == Color.GREEN && guessG != 255) {
                guessG += step;
            }
            else if (c == Color.BLUE && guessB != 255) {
                guessB += step;
            }
            count++;
            printStats();
        });
        min.addActionListener((ActionEvent a) -> { // Decrement a value of the current guess by 5.
            // Checks to make sure it doesn't decrement below 0.
            if (c == Color.RED && guessR != 0) {
                guessR -= step;
            }
            else if (c == Color.GREEN && guessG != 0) {
                guessG -= step;
            }
            else if (c == Color.BLUE && guessB != 0) {
                guessB -= step;
            }
            count++;
            printStats();
        });
        return new JButton[]{add, min};
    }

    /**
     * Generate each value, R G and B; then change background colors and print before you click anything.
     */
    private static void genColors() {
        // 255 / 5 = 51. + 1 for 0 = 52 numbers. Do the same for the other numbers.
        // Increments of x only so there will only be multiples of x.
        R = (int) (Math.random() * (255 / step)) * step;
        G = (int) (Math.random() * (255 / step)) * step;
        B = (int) (Math.random() * (255 / step)) * step;
        correct.setBackground(new Color(R, G, B));
        System.out.printf("(%d, %d, %d)\n", R, G, B);
    }

    /**
     * Prints the color to guess, guessed color, and if the user has guessed it correctly.
     * This is called after the user makes an incremental change.
     */
    private static void printStats() {
        guess.setBackground(new Color(guessR, guessG, guessB)); // new colors, new background
        System.out.printf("(%d, %d, %d)\n", R, G, B); // print correct colors
        System.out.printf("Current Guess: (%d, %d, %d)\n", guessR, guessG, guessB);
        if (R == guessR && G == guessG && B == guessB) {
            t.stop();
            JOptionPane.showConfirmDialog(null, String.format("You guessed it! RGB: (%d, %d, %d)", R, G, B), "GG!", JOptionPane.OK_CANCEL_OPTION);
            JOptionPane.showConfirmDialog(null, String.format("It took you %d seconds and %d clicks!\n", seconds, count), "GG!", JOptionPane.OK_CANCEL_OPTION);
            System.exit(0);
        }
        clicks.setText("Clicks: " + count);
    }

    /**
     * Instantiates the timer and click counter.
     */
    private static void initExtras() {
        JPanel extra = new JPanel();
        JLabel timer = new JLabel("Time elapsed: ");
        timer.setOpaque(true);

        t = new Timer(1000, a -> {
            timer.setText(String.format("Time elapsed: %ds", seconds++)); // lame but it works
        });
        t.start();

        clicks = new JLabel("Clicks: 0");
        clicks.setOpaque(true);

        extra.add(timer);
        extra.add(clicks);

        f.getContentPane().add(extra, BorderLayout.SOUTH);
    }
}
