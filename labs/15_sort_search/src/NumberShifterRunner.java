import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;
import java.util.Arrays;

public class NumberShifterRunner
{
	public static void main( String args[] ) throws IOException
	{
		NumberShifter n = new NumberShifter();
		int[] nums = n.makeLucky7Array(20);
		out.println(Arrays.toString(nums));
		n.shiftEm(nums);
	}
}
