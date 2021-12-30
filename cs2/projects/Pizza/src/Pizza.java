// I didn't want to mess with Enumeration https://docs.oracle.com/javase/7/docs/api/javax/swing/ButtonGroup.html#getElements()
// Original Pizza was quite 'featureful' (bloated); this one doesn't check for required options.
// Might want to change colors and stuff to make it look more pretty.

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class Pizza {
    private static final String[] dining = {"Eat In", "Take Out"};
    private static final String[] sizes = {"Small", "Medium", "Large"};
    private static final String[] crust = {"Thin Crust", "Thick Crust"};
    private static final String[] toppings = {"Extra Cheese", "Onions", "Mushrooms", "Green Peppers", "Olives", "Tomatoes"};

    private static final String[][] groups = {dining, sizes, crust, toppings};
    private static final String[] groupNames = {"Dining", "Size", "Crust", "Toppings"};

    private static JFrame frame;
    private static ArrayList<JToggleButton> toggleButtons; // reading the documentation. JCheckBox and JRadioButton are JToggleButtons

    public Pizza() {
        frame = new JFrame("Pizza Order");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 300);
        frame.setVisible(true);
        frame.setLayout(new GridLayout()); // must set a Layout or it won't show properly
        toggleButtons = new ArrayList<>();
        addSelectionButtons();
        addMiscButtons();
    }

    public static void main(String[] args) {
        new Pizza();
    }

    /**
     * Adds all of the buttons to the GUI.
     */
    private static void addSelectionButtons() {
        for (int i = 0; i < groups.length; i++) {
            ButtonGroup bg = new ButtonGroup();
            JPanel panel = new JPanel();

            String title = groupNames[i]; // appropriate border and title
            TitledBorder border = new TitledBorder(title);
            panel.setBorder(border);

            for (String buttonName : groups[i]) {
                if (!title.equals("Toppings")) {
                    JRadioButton button = new JRadioButton(buttonName);
                    bg.add(button); // in a ButtonGroup, only one button can be selected. JRadioButton groups only require one
                    toggleButtons.add(button); // add it to the ArrayList so it can be looped through to be checked if it's selected later
                    panel.add(button);
                } else {
                    JCheckBox button = new JCheckBox(buttonName);
                    toggleButtons.add(button);
                    panel.add(button);
                }
            }

            frame.add(panel);
        }
    }

    /**
     * Adds the Build and Exit Buttons.
     */
    private static void addMiscButtons() {
        JPanel panel = new JPanel();
        JButton build = new JButton("Build Pizza");
        JButton exit = new JButton("Exit");
        build.addActionListener(a -> {
            String pizza = "";
            for (JToggleButton radio: toggleButtons) {
                if (radio.isSelected()) {
                    pizza += radio.getText() + "\n"; // add the selected options for the pizza to the final display message
                }
            }
            JOptionPane.showConfirmDialog(null, pizza, "Your Pizza", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE); // show the final pizza
        });
        exit.addActionListener(a -> System.exit(0));

        panel.add(build);
        panel.add(exit);
        frame.add(panel);
    }
}
