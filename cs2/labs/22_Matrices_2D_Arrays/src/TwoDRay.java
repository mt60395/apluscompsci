import java.util.Arrays;

public class TwoDRay
{
	private int[][] matrix;

	public TwoDRay(int numrows)
	{
		matrix = new int[numrows][0];
	}

	public TwoDRay(int numrows, int numcols)
	{
		matrix = new int[numrows][numcols];
	}

	public void setRowSize(int r, int size)
	{
		matrix[r] = new int[size];
	}

	public void setRow(int r, int[] row)
	{
	   setRowSize(r,row.length);
		for(int i=0;i<row.length;i++)
		   matrix[r][i]=row[i];
	}

	public int[] getRow(int r)
	{
		return matrix[r];
	}

	public void sortRow(int r)
	{
		Arrays.sort(matrix[r]);
	}

	public String toString()
	{
		String output="";
		for(int r=0; r<matrix.length; r++)
		{
			output+="row "+r+" ";
			for(int c=0; c<matrix[r].length; c++)
			{
				output+=matrix[r][c] + " ";
			}
			output+="\n";
		}
		return output;
	}
}
