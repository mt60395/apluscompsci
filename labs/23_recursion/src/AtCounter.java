import static java.lang.System.*;

public class AtCounter
{
   private String[][] atMat;

	public AtCounter()
	{
		//size the matrix
		atMat = new String[10][10];
		//use nested loops to randomly load the matrix
		//you will need to use Math.random()
		for(String[] i: atMat) {
			for (int j = 0; j < i.length; j++) {
				i[j] = ((int) (Math.random() * 2)) == 0? "@":"-";
			}
		}
	}

	public int countAts(int r, int c)
	{
		//add in recursive code to count up the # of @s connected
		//start checking at spot [r,c]
		if (r >= 0 && r <= 10 && c >= 0 && c <= 10 && atMat[r][c] == "@") {
			atMat[r][c] = "-";
			return 1 + countAts(r, c - 1) + countAts(r, c + 1) + countAts(r - 1, c) + countAts(r + 1, c);
		}
		return 0;
	}

	/*
	 *this method will return all values in the matrix
	 *this method should return a view of the matrix
	 *that looks like a matrix
	 */
	public String toString()
	{
		String out = "";
		for (String[] s: atMat) {
			for (String st: s) {
				out += st + " ";
			}
			out +="\n";
		}
		return out;
	}
}
