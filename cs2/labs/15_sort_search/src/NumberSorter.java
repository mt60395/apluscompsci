import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSorter
{
	//instance variables and other methods not shown

	private static int getNumDigits(int number)
	{
		int count = 0;
		while (number != 0) {
			number = number / 10;
			count++;
		}
		return count;
	}

	public static int[] getSortedDigitArray(int number)
	{
		int[] sorted = new int[getNumDigits(number)];
		int index = 0;
		while (number != 0) {
			int digit = number % 10;
			number = number / 10;
			sorted[index++] = digit;
		}
		for (int i = 0; i < sorted.length; i++) {
			int minimum = i;
			for (int j = i; j < sorted.length; j++) {
				if (sorted[j] < sorted[minimum]) {
					minimum = j;
				}
			}
			int min = sorted[minimum];
			sorted[minimum] = sorted[i];
			sorted[i] = min;
		}
		return sorted;
	}
}
