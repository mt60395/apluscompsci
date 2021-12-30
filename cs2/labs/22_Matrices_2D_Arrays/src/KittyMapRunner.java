import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class KittyMapRunner
{
	public static void main( String args[] ) throws IOException
	{
		KittyMap km = new KittyMap(20, 20);
		System.out.println( km + "\n\n");
		km.printKittyCount();
	}
}
