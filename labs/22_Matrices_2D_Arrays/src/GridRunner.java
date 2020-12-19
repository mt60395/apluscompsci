import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class GridRunner
{
	public static void main( String args[] ) throws IOException
	{
		String[] vals = new String[] {"a", "b", "c", "x", "2", "7", "9"};
		Grid g = new Grid(20, 20, vals);
		out.print(g);
		out.printf("%s occurs the most.\n\n", g.findMax(vals));

		Grid g2 = new Grid(10, 10, vals);
		out.print(g);
		out.printf("%s occurs the most.\n\n", g.findMax(vals));
	}
}
