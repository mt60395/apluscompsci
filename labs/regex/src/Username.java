import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Username
{
	private int count;

	public Username()
	{
		count = 0;
	}

	public void checkName(String name) {
		Pattern p = Pattern.compile("^([\\w]{4,16})$");
		Matcher matcher = p.matcher(name);
		while (matcher.find()) {
			count++;
		}
	}

	public String toString()
	{
		return String.format("The list has %d valid user names.", count);
	}
}
