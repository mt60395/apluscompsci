import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MatrixSummingRunner
{
	public static void main( String args[] ) throws IOException
	{
		MatrixSumming m = new MatrixSumming();
		Scanner file = new Scanner(new File("matsum.dat"));
		for (int i = 0; i < file.nextInt(); i++) {
			int r = file.nextInt();
			int c = file.nextInt();
			System.out.printf("The sum of %d,%d is %d.", r, c, m.sum(r,c));
		}
	}
}
