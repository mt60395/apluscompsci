import static java.lang.System.*;

public class TriangleFive
{
	private char letter;
	private int amount;

	public TriangleFive()
	{
		letter = 'A';
		amount = 1;
	}

	public TriangleFive(char c, int amt)
	{
		letter = c;
		amount = amt;
	}

	public void setLetter(char c)
	{
		letter = c;
	}

	public void setAmount(int amt)
	{
		amount = amt;
	}

	public String toString()
	{
		String output="";
		for (int Amt = amount; Amt > 0; Amt--) {
			String line = "";
			for (int i = letter + Amt - 1; i >= letter; i--) {
				char ch = (char) i;
				if (i > 90)
					ch = (char) (i - 90 + 64);
				String duplicate = "" + ch;
				for (int dupe = 1; dupe < letter + amount - i; dupe++) {
					duplicate += ch;
				}
				line = duplicate + line;
				if (i != letter) line = " " + line;
			}
			output += line + "\n";
		}
		return output +'\n';
	}
}
