import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Substitution
{
	public Substitution()
	{
		String orig = "This is a list of students: studentID=1234, studentID=4865, studentID=7894, studentID=7744, studentID=231233.";
		orig+="\nIt's not comprehensive.";
		System.out.println(orig);
		StringBuffer sb = new StringBuffer();
		Pattern p = Pattern.compile("(\\d{4,6})");
		Matcher matcher = p.matcher(orig);
		while (matcher.find()) {
			String masked = "\"masked\"";
			System.out.printf(masked + ": %s\n", matcher.group());
			matcher.appendReplacement(sb, "\"masked\"");
		}
		matcher.appendTail(sb);
		System.out.println(sb.toString());
	}
	public static void main(String[] args){
		new Substitution();
	}
}
