import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import static java.lang.System.*;

public class Word2Runner {
    public static void main(String args[]) throws IOException {
        Scanner file = new Scanner(new File("word2.dat"));

        int size = file.nextInt();
        file.nextLine();
        Word2[] words = new Word2[size];
        for (int i = 0; i < size; i++) {
            Word2 w = new Word2(file.nextLine());
            words[i] = w;
        }
        Arrays.sort(words, new Comparator<Word2>() {
            @Override
            public int compare(Word2 word, Word2 t1) {
                return word.compareTo(t1);
            }
        });
        for (Word2 w : words) {
            out.println(w);
        }
    }
}
