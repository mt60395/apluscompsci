import static java.lang.System.*;
import java.util.Scanner;

public class PasswordRunner
{
	public static void main ( String[] args )
	{
		Scanner s = new Scanner(System.in);
		while (s.hasNextLine()) {
			Password p = new Password(s.nextLine());
			out.println(p);
		}
	}
}