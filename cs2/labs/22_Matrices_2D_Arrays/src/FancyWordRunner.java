import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class FancyWordRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner( new File("mofancyword.dat") );
		int zz = file.nextInt();
		file.nextLine();
		for( int xx = 0; xx < zz; xx++) {
			String line = file.nextLine();
			FancyWordThree one = new FancyWordThree(line);
			System.out.println( one );
		}
	}
}
