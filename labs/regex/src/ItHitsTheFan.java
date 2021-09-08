import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItHitsTheFan
{
	private int count;

	public ItHitsTheFan()
	{
		count = 0;
	}

	// use the Pattern and Matcher classes
	public void countLine(String s)
	{
		Pattern p = Pattern.compile(" [iI]t ");
		Matcher m = p.matcher(s);
		while (m.find()) {
			count++;
		}
	}

	public String toString()
	{
		return "" + count + " times";
	}
}
