import java.io.File;
import java.util.*;

public class Tester {
    private ArrayList<Rectangle> list;

    public Tester() {
        readData();
        sortAndPrintData();
    }

    public void readData() {
        list = new ArrayList<Rectangle>();
        try {
            // read in the data
            Scanner file = new Scanner(new File("rect.dat"));
            int size = file.nextInt();
            file.nextLine();
            for (int i = 0; i < size; i++) {
                list.add(new Rectangle(file.nextInt(), file.nextInt()));
                file.nextLine();
            }
        } catch (Exception e) {
            // you don't have to add anything here
            e.printStackTrace();
        }

    }

    public void sortAndPrintData() {
        // sort the data using Comparator and then print the data
        Collections.sort(list, new Comparator<Rectangle> () {
            public int compare(Rectangle rect, Rectangle other) {
                return Integer.compare(rect.getArea(), other.getArea());
            }
        });
        for (Rectangle r: list) {
            System.out.println(r);
        }
    }

    public static void main(String[] args) {
        new Tester();
    }

    private class Rectangle implements ComparableRect<Rectangle> {
        int length, width;

        public Rectangle(int length, int width) {
            this.length = length;
            this.width = width;
        }

        public int getArea() {
            return length * width;
        }

        // you are not allowed to modify this method
        public int compareTo(Rectangle other) {
            return width - other.width;    // DO NOT TOUCH
        }

        public String toString() {
            // format the data appropriately
            return String.format("%d\t%d\t%d", length, width, getArea());
        }
    }
}
