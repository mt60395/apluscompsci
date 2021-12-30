import static java.lang.System.*;

public class TriangleTwo {
    private int size;
    private String letter;

    public TriangleTwo() {
        size = 1;
        letter = "A";
    }

    public TriangleTwo(String let, int sz) {
        size = sz;
        letter = let;
    }

    public void setTriangle(int count, String let) {
        size = count;
        letter = let;
    }

    public String getLetter() {
        return letter;
    }

    public String toString() {
        String output = "";
        for (int i = size; i > 0; i--) {
            String line = "";
            for (int length = 0; length < i; length++) {
                line += getLetter();
            }
            output += line + "\n";
        }
        return output + "\n";
    }
}
