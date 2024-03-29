import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeDate
{
	public static void main( String[] args) {

		// for 12 hour clock
		String regularExpression = "^([1-9]|1[0-2]):[0-9][0-9] [ap]m$";

		String time1 ="10:15 pm";
		String time2 ="12:45 a.m";
		String time3 ="01:45 am";
		String time4 ="2:45 am";

		Pattern p = Pattern.compile(regularExpression);
		Matcher m = p.matcher(time1);
		Matcher m2 = p.matcher(time2);
		Matcher m3 = p.matcher(time3);
		Matcher m4 = p.matcher( time4);

		System.out.println("Testing 12 hour clock\n");
		System.out.println("The time 1 matches:" + m.matches());
		System.out.println("The time 2 matches:" + m2. matches());
		System.out.println("The time 3 matches:" + m3. matches());
		System.out.println("The time 4 matches:" + m4. matches());

		// for 24 hour clock
		regularExpression = "^([0-1][0-9]|2[0-3]):[0-5][0-9]$";

		time1 ="10:15";
		time2 ="12:45";
		time3 ="23:45";
		time4 ="25:45";

		p = Pattern.compile(regularExpression);
		m = p.matcher(time1);
		m2 = p.matcher(time2);
		m3 = p.matcher(time3);
		m4 = p.matcher( time4);

		System.out.println("\nTesting 24 hour clock\n");
		System.out.println("The time 1 matches:" + m.matches());
		System.out.println("The time 2 matches:" + m2. matches());
		System.out.println("The time 3 matches:" + m3. matches());
		System.out.println("The time 4 matches:" + m4. matches());

		// to validate a date in the format dd/mm/yyyy
		String input = "^([0][1-9]|[1-2][0-9]|[3][01])\\/([0][1-9]|[1][012])\\/[0-9]{3}[1-9]$";
		// todo february has 28 days?

		String date1 ="31/08/2016";
		String date2 ="12345";

		p = Pattern.compile(input);
		m = p.matcher(date1);
		m2 = p.matcher(date2);

		System.out.println("\nTesting dates\n");
		System.out.println("The date 1 matches:" + m.matches());
		System.out.println("The date 2 matches:" + m2. matches());
	}
}