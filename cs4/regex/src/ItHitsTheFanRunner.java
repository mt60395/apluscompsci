// Score: 85
import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;

public class ItHitsTheFanRunner
{
	public static void main ( String[] args ) throws FileNotFoundException {
		ItHitsTheFan a = new ItHitsTheFan();
		File f = new File("ItHitsTheFan.txt");
		Scanner s = new Scanner(f);
		while (s.hasNextLine()) {
			String b = s.nextLine();
			a.countLine(b);
		}
		out.println(a);
	}
}
