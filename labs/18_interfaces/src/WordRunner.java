import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;

public class WordRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("words.dat"));

		int size = file.nextInt();
		file.nextLine();
		Word[] words = new Word[size];
		for (int i = 0; i < size; i++) {
			Word w = new Word(file.nextLine());
			words[i] = w;
		}
		Arrays.sort(words, new Comparator<Word>() {
			@Override
			public int compare(Word word, Word t1) {
				return word.compareTo(t1);
			}
		});
		for (Word w: words) {
			out.println(w);
		}
	}
}
