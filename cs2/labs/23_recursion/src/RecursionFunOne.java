import static java.lang.System.*;

public class RecursionFunOne
{
	public static int countOddDigits(int num)
	{
		if (num > 0) {
			if ((num % 10) % 2 != 0) { // last digit odd
				return 1 + countOddDigits(num / 10);
			}
			else {
				return countOddDigits(num / 10);
			}
		}
		return 0;
	}
}
