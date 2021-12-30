import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;
import java.util.Arrays;

public class FancyWordTwo
{
	private String[][] mat;

	public FancyWordTwo()
	{
		mat=new String[0][0];
	}

	public FancyWordTwo(String s)
	{
		int end = s.length();
		mat = new String[end][end];

		for( String[] row : mat )
			Arrays.fill(row," ");

		for(int i=0; i<end; i++)
		{
			mat[0][i]=s.substring(i,i+1);
			mat[end-1][i]=s.substring(end-i-1,end-i-1+1);
			mat[i][0]=s.substring(0+i,0+i+1);
			mat[i][end-1]=s.substring(end-i-1,end-i-1+1);
		}
	}

	public String toString()
	{
		String output="";
		for (int r=0; r<mat.length; r++)
		{
			for (int c=0; c<mat[r].length; c++)
			{
				output+=mat[r][c];
			}
			output+="\n";
		}
		return output;
	}
}
