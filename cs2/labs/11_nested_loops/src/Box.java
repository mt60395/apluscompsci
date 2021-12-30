import static java.lang.System.*;

public class Box
{
   private int size;

	public Box()
	{
		size = 1;
	}

	public Box(int count)
	{
		size = count;
	}

	public void setSize(int count)
	{
		size = count;
	}

	public int getSize()
	{
		return size;
	}

	public String toString()
	{
		String output="";
		for (int i = 1; i <= size; i ++) {
			for (int stars = 0; stars <= size-i; stars++) {
				output += "*";
			}
			for (int length = 0; length < i; length++) {
				output += "#";
			}
			output += "\n";
		}
		return output;
	}
}
