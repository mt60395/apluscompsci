import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SSN
{
	private String social;
	private boolean b;

	public SSN()
	{
		social = "000-00-0000";
		b = true;
	}

	public SSN(String s)
	{
		social = s;
		b = false;
	}
	// use the Pattern and Matcher classes
	public void validate()
	{
		Pattern p = Pattern.compile("^\\d{3}-?\\d{2}-?\\d{4}$");
		Matcher matcher = p.matcher(social);
		while (matcher.find()) {
			b = true;
		}
	}

	// use the String class and matches method. This method can be used for simple validations.
	public void matches()
	{
		b = !social.matches("\\d{3}-?\\d{4}");
	}

	public String toString()
	{
		String output="valid";
		return b?output:"invalid";
	}
}
