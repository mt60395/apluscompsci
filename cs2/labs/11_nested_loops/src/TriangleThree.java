import static java.lang.System.*;

public class TriangleThree {
    private int size;
    private String letter;

    public TriangleThree() {
        size = 1;
        letter = "A";
    }

    public TriangleThree(int count, String let) {
        size = count;
        letter = let;
    }

    public void setTriangle(String let, int sz) {
        size = sz;
        letter = let;
    }

    public String getLetter() {
        return letter;
    }

    public String toString() {
        String output = "";
        for (int i = 1; i <= size; i++) {
            String line = "";
            for (int spaces = 0; spaces < size - i; spaces++) {
                line += " ";
            }
            for (int length = 0; length < i; length++) {
                line += getLetter();
            }
            output += line + "\n";
        }
        return output + "\n";
    }
}
