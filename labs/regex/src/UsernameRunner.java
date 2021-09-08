import static java.lang.System.*;

import java.util.Scanner;
import java.io.*;

public class UsernameRunner
{
	public static void main ( String[] args ) throws FileNotFoundException {
		File f = new File("names.txt");
		Scanner s = new Scanner(f);
		Username u = new Username();
		while (s.hasNextLine()) {
			u.checkName(s.nextLine());
		}
		out.println(u);
	}
}
