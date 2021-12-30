import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Graveyard {
    private static int[] histogram;
    public static void main(String[] args) throws FileNotFoundException {
        histogram = new int[26];
        File f = new File("graveyard.dat");
        Scanner s = new Scanner(f);
        while (s.hasNextLine()) {
            for (char c: s.nextLine().toCharArray()) {
                char C = String.valueOf(c).toUpperCase().charAt(0);
                if (C >= 65 && C <= 90) {
                    histogram[C - 65]++;
                }
            }
        }
        //System.out.println("" + Arrays.toString(histogram));

        Letter[] letters = new Letter[26];
        for (int i = 0; i < histogram.length; i++) {
            letters[i] = new Letter((char) (i + 65), histogram[i]);
        }
        Arrays.sort(letters);
        Collections.reverse(Arrays.asList(letters));
        for (Letter letter: letters) {
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < letter.getCount(); i++) {
                buffer.append(letter.getChar());
            }
            System.out.println(buffer);
        }
    }
    private static class Letter implements Comparable<Letter> {
        char c;
        int count;
        public Letter(char character, int a) {
            c = character;
            count = a;
        }
        public char getChar() {
            return c;
        }
        public int getCount() {
            return count;
        }
        public int compareTo(Letter other) {
            if (count == other.getCount()) {
                return Integer.compare(other.getChar(), c);
            }
            return Integer.compare(count, other.getCount());
        }
    }
}
