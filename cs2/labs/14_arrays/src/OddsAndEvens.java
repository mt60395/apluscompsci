import java.util.Scanner;

public class OddsAndEvens
{
	private static int countEm(int[] array, boolean odd)
	{
		int even = 0;
		for (int i: array) {
			if (i % 2 == 0) even++;
		}
		return odd ? array.length-even:even;
	}
	
	public static int[] getAllEvens(int[] array)
	{
		int[] evens = new int[countEm(array, false)];
		int index = 0;
		for (int i: array) {
			if (i % 2 == 0) {
				evens[index++] = i;
			}
		}
		return evens;
	}

	public static int[] getAllOdds(int[] array)
	{
		int[] odds = new int[countEm(array, true)];
		int index = 0;
		for (int i: array) {
			if (i % 2 != 0) {
				odds[index++] = i;
			}
		}
		return odds;
	}
}
