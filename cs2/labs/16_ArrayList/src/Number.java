import java.util.ArrayList;
public class Number
{
	private Integer number;

	public Number()
	{
		number = 0;
	}

	public Number(int num)
	{
		number = num;
	}

	public void setNumber(int num)
	{
		number = num;
	}

	public int getNumber()
	{
		return number;
	}

	public boolean isOdd()
	{
		return number % 2 != 0;
	}

	public boolean isPerfect()
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < number; i++) {
			if (number % i == 0) {
				list.add(i);
			}
		}
		int total=0;
		for (int i: list) {
			total += i;
		}
		return (number==total);
	}

	public String toString( )
	{
		return "" + number;
	}
}
