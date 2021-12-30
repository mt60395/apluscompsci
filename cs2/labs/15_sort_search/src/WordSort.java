import java.util.Arrays;
import static java.lang.System.*; 

public class WordSort
{
	private String[] wordRay;

	public WordSort(String line)
	{
	   setList(line);
	}

	public void setList(String line)
	{
		wordRay = line.split(" ");
	}

	public void sort()
	{
		boolean go = true;
		while (go) {
			boolean flag = false;
			for (int i = 0; i < wordRay.length - 1; i++) {
				if (wordRay[i].charAt(0) > wordRay[i + 1].charAt(0)) {
					String first = wordRay[i];
					wordRay[i] = wordRay[ i + 1];
					wordRay[i + 1] = first;
					flag = true;
				}
			}
			if (!flag) go = false;
		}
	}

	public String toString( )
	{
		String output="";
		for (int i = 0; i < wordRay.length; i++) {
			output += String.format("word %d :: %s\n", i, wordRay[i]);
		}
		return output+"\n";
	}
}
