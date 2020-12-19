import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class Words
{
	private ArrayList<Word> words = new ArrayList<Word>();

	public Words()
	{
		setWords("apple, pear");
	}

	public Words(String wordList)
	{
		setWords(wordList);
	}

	public void setWords(String wordList)
	{
		for (String word: wordList.split(", ")) {
			words.add(new Word(word));
		}
	}
	
	public int countWordsWithXChars(int size)
	{
		int count=0;
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).getLength() == size) {
				count++;
			}
		}
		return count;
	}
	
	//this method will remove all words with a specified size / length
	//this method will also return the sum of the vowels in all words removed
	public int removeWordsWithXChars(int size)
	{
		int count=0;
		for (int i = words.size() - 1; i >= 0; i--) {
			if (words.get(i).getLength() == size) {
				words.remove(i);
				count++;
			}
		}
		return count;
	}

	public int countWordsWithXVowels(int numVowels)
	{
		int count=0;
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).getNumVowels() == numVowels) {
				count++;
			}
		}
		return count;
	}
	
	public String toString()
	{
		return "" + words;
	}
}
