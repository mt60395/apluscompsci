import static java.lang.System.*;

class TriangleWord {
    private String word;

    public TriangleWord() {
        word = "cat";
    }

    public TriangleWord(String w) {
        word = w;
    }

    public void setWord(String w) {
        word = w;
    }

    public String toPalindrome(String s) {

        return s;
    }

    public String toString() {
        String output = "";
        char ch[] = word.toCharArray();
        String rev = "";
        for (int i = ch.length - 1; i >= 0; i--) {
            rev += ch[i];
        }
        String bottom = word;
        if (word.length() > 1) {
            bottom = rev.substring(0, word.length() - 1) + bottom;
        }
        int lineLength = bottom.length(); // maximum length based on the triangle base

        for (int line = 1; line <= word.length(); line++) { // how tall the triangle is
            // dealing with each line now
            int spaces = line == 1 ? lineLength - 1 : lineLength - 2;
            // only one character taken away if first line
            String currentLine = "";
            if (line == 1) { // no spaces between two characters
                for (int space = 0; space < spaces / 2; space++) { // spaces prepended to char
                    currentLine += " ";
                }
                currentLine += word.charAt(line - 1);
            } else {
                int between = line - 1;
                spaces -= between; // amount of spaces between two characters
                for (int space = 0; space < Math.ceil(spaces / 2); space++) {
                    currentLine += " ";
                }
                currentLine += word.charAt(line - 1);
                for (int space = 0; space < between; space++) { // spaces between the two characters
                    currentLine += " ";
                }
                currentLine += word.charAt(line - 1);
            }
            output += currentLine;
            output += "\n";
        }
        return output + bottom + "\n";
    }
}
