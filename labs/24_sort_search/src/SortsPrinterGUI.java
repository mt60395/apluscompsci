import javax.swing.*;
import java.awt.*;

public class SortsPrinterGUI {
    private static int passes;
    private static JFrame frame;
    private static JTextArea t;
    private static String output;

    public SortsPrinterGUI() {
        JOptionPane.showConfirmDialog(null, "Enter a list without brackets; just the numbers and commas.", "", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
        frame = new JFrame("Sort Passes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 170));
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        t = new JTextArea(5, 40);
        t.setEditable(true);
        t.setAlignmentX(TextArea.RIGHT_ALIGNMENT);
        panel.add(t);
        frame.add(panel, BorderLayout.NORTH);

        addSorts();
    }

    private static void addSorts() {
        String[] sorts = {"Selection", "Insertion", "Quick", "Merge"};
        ButtonGroup bg = new ButtonGroup();
        JPanel panel = new JPanel();
        for (String s: sorts) {
            JButton b = new JButton(s);
            panel.add(b);
            bg.add(b);
            b.addActionListener(a -> {
                passes = 1;
                output = "";
                int[] arr = stringToArray(t.getText());
                switch (s) {
                    case "Selection":
                        SortsPrinterGUI.selectSort(arr);
                        break;
                    case "Insertion":
                        SortsPrinterGUI.insertSort(arr);
                        break;
                    case "Quick":
                        SortsPrinterGUI.quickSort(arr);
                        break;
                    case "Merge":
                        SortsPrinterGUI.mergeSort(arr);
                        break;
                };
                JOptionPane.showConfirmDialog(null, output, "Passes", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            });
        }
        frame.add(panel, BorderLayout.SOUTH);
    }

    public static int[] stringToArray(String s) {
        String[] split = s.split(s.contains(" ")? ", ":",");
        // commas with space vs commas with no space. separate to get numbers.
        int[] arr = new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        return arr;
    }

    public static String arrayToString(int[] arr) {
        String s = "[";
        for (int i : arr) {
            s += i + ", ";
        }
        s = s.substring(0, s.length() - 2); // excess comma at the end
        return s + "]";
    }

    public static void selectSort(int[] arr) {
        int sorted = -1; // the sorted index. starts off none sorted
        while (sorted != arr.length - 1) {
            int min = sorted + 1;
            for (int i = sorted + 2; i < arr.length; i++) { // find minimum index
                if (arr[i] < arr[min]) {
                    min = i;
                }
            }
            if (min != ++sorted) {
                int temp = arr[min];
                arr[min] = arr[sorted];
                arr[sorted] = temp;
            }
            if (passes == arr.length) return;
            output += String.format("Pass %d - %s\n", passes++, arrayToString(arr));
        }
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int greaterThan = -1;
            for (int j = 0; j < i; j++) { // find the first number of the sorted that is greater than
                if (arr[j] > arr[i]) {
                    greaterThan = j;
                    break;
                }
            }
            if (greaterThan != -1) {
                int current = arr[i];
                for (int j = i; j > greaterThan; j--) { // shift. must shift from back
                    arr[j] = arr[j - 1];
                }
                arr[greaterThan] = current;
            }
            output += String.format("Pass %d - %s\n", passes++, arrayToString(arr));
        }
    }

    public static void quickSort(int[] arr) {
        quickSortRecursive(arr, 0, arr.length - 1);
    }

    private static void quickSortRecursive(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = pivot(arr, left, right);
        output += String.format("Pass %d - %s\n", passes++, arrayToString(arr));
        quickSortRecursive(arr, left, index - 1); // inclusive
        quickSortRecursive(arr, index, right);
    }

    private static int pivot(int[] arr, int left, int right) {
        int piv = arr[left]; // first element works
        while (left <= right) {
            while (arr[left] < piv) {
                left++;
            }
            while (arr[right] > piv) {
                right--;
            }
            if (left <= right) {
                int temp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = temp;
            }
        }
        return left;
    }

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length);
    }

    private static void mergeSort(int[] arr, int front, int back) {
        int mid = (front + back) / 2;
        if (mid == front) return;
        mergeSort(arr, front, mid);
        mergeSort(arr, mid, back);
        merge(arr, front, back);
        output += String.format("Pass %d - %s\n", passes++, arrayToString(arr));
    }

    private static void merge(int[] list, int front, int back) {
        int[] temp = new int[back - front];
        int i = front, j = (front + back) / 2, k = 0;
        int mid = j;
        while (i < mid && j < back) {
            if (list[i] < list[j])
                temp[k++] = list[i++];
            else
                temp[k++] = list[j++];
        }
        while (i < mid)
            temp[k++] = list[i++];
        while (j < back)
            temp[k++] = list[j++];
        for (i = 0; i < back - front; ++i)
            list[front + i] = temp[i];
    }

    public static void main(String[] args) {
        new SortsPrinterGUI();
    }
}
