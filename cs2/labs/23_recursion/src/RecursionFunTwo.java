import static java.lang.System.*;

public class RecursionFunTwo
{
	public static int countChickens(String word)
	{
		if (word.indexOf("chicken") != -1) {
			return 1 + countChickens(word.replaceFirst("chicken", ""));
		}
		return 0;
	}
}
