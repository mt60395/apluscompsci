import static java.lang.System.*;

public class TriangleFour
{
   private int size;
   private String letter;

	public TriangleFour()
	{
		size = 1;
		letter = "A";
	}

	public TriangleFour(int count, String let)
	{
		size = count;
		letter = let;
	}

	public void setTriangle( String let, int sz )
	{
		size = sz;
		letter = let;
	}

	public String getLetter() 
	{
		return letter;
	}

	public String toString()
	{
		String output="";
		for (int i = size; i > 0; i --) {
			for (int spaces = 0; spaces < size - i; spaces++) {
				output += " ";
			}
			for (int character = i; character > 0; character--) {
				output += getLetter();
			}
			output += "\n";
		}
		return output+"\n";
	}
}
