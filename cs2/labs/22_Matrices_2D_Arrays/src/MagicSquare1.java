import java.util.Scanner;
import static java.lang.System.*;

public class MagicSquare1
{
	private int[][] mat;

	//size the matrix and load in the numbers into the matrix
	//write all nested loop code here in the constructor
	public MagicSquare1(int size, String numbers)
	{
		mat = new int[size][size];
		String[] s = numbers.split(" " );
		int k = 0;
		for( int i = 0; i < size; i++)
		{
			for( int j = 0; j < size; j++)
			{
				mat[i][j] = Integer.parseInt(s[k++]);
			}
		}
	}

	public boolean isMagicSquare()
	{
		int x = sumRow(0);
		for(int i = 1; i < mat.length; i++)
		{
			if(sumRow(i)!=x)
				return false;
		}
		for(int i = 1; i < mat[0].length; i++)
		{
			if(sumCol(i)!=x)
				return false;
		}
		if(sumDownDiag()!=x)
			return false;
		if(sumUpDiag()!=x)
			return false;
		return true;
	}

	public int sumRow( int r )
	{
		int sum = 0;
		for( int v : mat[r] )
		{
			sum+= v;
		}
		return sum;
	}

	public int sumCol( int c )
	{
		int sum = 0;
		for( int i = 0; i < mat.length; i++ )
		{
			sum+= mat[i][c];
		}
		return sum;
	}

	public int sumDownDiag()
	{
		int sum = 0;
		for( int i = 0; i < mat.length; i++ )
		{
			sum+= mat[i][i];
		}
		return sum;
	}

	public int sumUpDiag()
	{
		int sum = 0;
		for( int i = 0; i < mat.length; i++ )
		{
			sum+= mat[mat.length-i-1][i];
		}
		return sum;
	}

	public String toString()
	{
		String output="";
		for( int[] row : mat )
		{
			for( int val : row)
			{
				output += val + " ";
			}
			output += "\n";
		}
		return output.trim();
	}
}
