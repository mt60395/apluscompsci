import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;
import java.util.Arrays;

public class NumberAnalyzer
{
	private ArrayList<Number> list;

	public NumberAnalyzer()
	{
		list = new ArrayList<Number>();
	}

	public NumberAnalyzer(String numbers)
	{
		setList(numbers);
	}
	
	public void setList(String numbers)
	{
		String[] nums = numbers.split(" ");
		list = new ArrayList<Number>();
		for (String n: nums) {
			list.add(new Number(Integer.parseInt(n)));
		}
	}

	public int countOdds()
	{
      int oddCount=0;
      for (Number i: list) {
      	if (i.isOdd()) {
      		oddCount++;
		}
	  }
      return oddCount;
	}

	public int countEvens()
	{
      int evenCount=0;
		for (Number i: list) {
			if (!i.isOdd()) {
				evenCount++;
			}
		}
      return evenCount;
	}

	public int countPerfects()
	{
	  int perfectCount=0;
		for (Number i: list) {
			if (i.isPerfect()) {
				perfectCount++;
			}
		}
      return perfectCount;
	}
	
	public String toString( )
	{
		return list.toString();
	}
}
