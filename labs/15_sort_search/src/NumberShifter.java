import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberShifter
{
	public static int[] makeLucky7Array( int size)
	{
		int[] nums = new int[20];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) Math.floor(Math.random() * 10 + 1);
		}
		return nums;
	}
	public static void shiftEm(int[] array)
	{
		int sorted = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 7) {
				int swap = array[sorted];
				array[sorted++] = 7;
				array[i] = swap;
			}
		}
		out.println(Arrays.toString(array));
	}
}
