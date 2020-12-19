import java.util.Arrays;
public class OddsAndEvensRunner {
	public static void main( String args[] )
	{
		OddsAndEvens o = new OddsAndEvens();
		int[] one = {2, 4, 6, 8, 10, 12, 14};
		System.out.println("Odds - " + Arrays.toString(o.getAllOdds(one)));
		System.out.println("Evens - " + Arrays.toString(o.getAllEvens(one)));

		System.out.println();

		int[] two = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println("Odds - " + Arrays.toString(o.getAllOdds(two)));
		System.out.println("Evens - " + Arrays.toString(o.getAllEvens(two)));

		System.out.println();

		int[] three = {2, 10, 20, 21, 23, 24, 40, 55, 60, 61};
		System.out.println("Odds - " + Arrays.toString(o.getAllOdds(three)));
		System.out.println("Evens - " + Arrays.toString(o.getAllEvens(three)));
	}
}
