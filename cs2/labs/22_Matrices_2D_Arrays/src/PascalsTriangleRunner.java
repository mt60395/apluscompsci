import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class PascalsTriangleRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("triangle.dat"));
		int size = file.nextInt();
		PascalsTriangle test;
		for(int i=0; i<size; i++)
		{
			test = new PascalsTriangle(file.nextInt());
			test.createTriangle();
			//out.println(test);
			test.print();
		}
	}
}
