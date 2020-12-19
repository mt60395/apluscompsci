import java.util.Arrays;
import static java.lang.System.*; 

public class WordSortRunner
{
	public static void main(String args[])
	{
		WordSort w = new WordSort("abc ABC 12321 fred alexander");
		w.sort();
		out.println(w);

		w.setList("a zebra friendly acrobatics 435 TONER PRinTeR");
		w.sort();
		out.println(w);

		w.setList("b x 4 r s y $");
		w.sort();
		out.println(w);

		w.setList("123 ABC abc 034 dog cat sally sue bob 2a2");
		w.sort();
		out.println(w);
	}
}
