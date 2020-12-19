import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class MagicSquare1Runner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner( new File("magic1.dat") );
		int zz = file.nextInt();
		for( int xx = 0; xx < zz; xx++)
		{
			int size = file.nextInt();
			file.nextLine();  //pick up the trash left by the prior line
			String line = file.nextLine();
			MagicSquare1 one = new MagicSquare1(size, line);
			System.out.println( one );
			System.out.println( one.isMagicSquare() ? "MAGIC SQUARE\n\n" : "NOT MAGIC SQUARE\n\n" );
		}
	}
}
