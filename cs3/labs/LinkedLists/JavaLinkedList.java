import java.util.LinkedList;

public class JavaLinkedList
{
	private LinkedList<Integer> list;

	public JavaLinkedList()
	{
		list = new LinkedList<Integer>();
	}

	public JavaLinkedList(int[] nums)
	{
		list = new LinkedList<Integer>();
		for(int num : nums)
		{
			list.add(num);
		}
	}

	public double getSum(  )
	{
		double total=0;
		for (int i: list) {
			total += i;
		}
		return total;
	}

	public double getAvg(  )
	{
		return getSum() / list.size();
	}

	public int getLargest()
	{
		int largest=Integer.MIN_VALUE;
		for (int i: list) {
			if (i > largest) largest = i;
		}
		return largest;
	}

	public int getSmallest()
	{
		int smallest =Integer.MAX_VALUE;
		for (int i: list) {
			if (i < smallest) smallest = i;
		}
		return smallest;
	}

	public String toString()
	{
		String output="";
		output += "SUM:: " + getSum() + "\n";
		output += "AVERAGE:: " + getAvg() + "\n";
		output += "SMALLEST:: " + getSmallest() + "\n";
		output += "LARGEST:: " + getLargest() + "\n";
		return output;
	}
}