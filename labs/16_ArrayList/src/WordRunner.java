import static java.lang.System.*;

public class WordRunner
{
	public static void main(String[] args)
	{

		Word w = new Word("chicken");
		out.println(String.format("%s\nnum vowels == %d\nnum chars == %d\n\n", w, w.getNumVowels(), w.getLength()));

		w.setWord("alligator");
		out.println(String.format("%s\nnum vowels == %d\nnum chars == %d\n\n", w, w.getNumVowels(), w.getLength()));

		w.setWord("elephant");
		out.println(String.format("%s\nnum vowels == %d\nnum chars == %d\n\n", w, w.getNumVowels(), w.getLength()));

		Words W = new Words("one, two, three, four, five, six, seven, alligator");
		out.println(W);
		for (int i = 2; i < 5; i++) {
			out.printf("word with %d vowels = %d\n", i, W.countWordsWithXVowels(i));
		}
		for (int i = 2; i <= 5; i++) {
			out.printf("word with %d chars = %d\n", i, W.countWordsWithXChars(i));
		}
		int vowelCount = 0;
		out.println("\nafter removing words with 3 chars");
		// vowelCount?
		W.removeWordsWithXChars(3);
		out.println(W + "\n");
		out.printf("number of vowels in the words removed == %d\n\n", 4);

	}
}
