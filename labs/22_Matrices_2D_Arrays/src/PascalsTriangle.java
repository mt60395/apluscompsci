import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class PascalsTriangle
{
	private int[][] mat;

	public PascalsTriangle()
	{
		mat=new int[0][0];
	}

	public PascalsTriangle(int size)
	{
		mat=new int[size][size];
	}

	public void createTriangle()
	{
		for (int r=0; r<mat.length; r++)
		{
			for (int c=0; c<=r; c++)
			{
				if (c==0 || r==0){
					mat[r][c]=1;
				}
				else
					mat[r][c] = mat[r-1][c]+mat[r-1][c-1];
			}
		}
	}
	public void print()
	{
		String spacing = "   ";
		String indent = "  ";
		for(int i=0; i<mat.length; i++)
		{
			int r = mat.length-1;
			while(r>i)
			{
				out.print(indent);
				r--;
			}
			for(int j=0; j<=i; j++)
			{
				if(j+1<mat[i].length && mat[i][j+1]/10>0)
					spacing="  ";
				out.printf("%d%s",mat[i][j],spacing);
				spacing="   ";
			}
			out.println("");
		}
		out.println("");
	}

	public String toString()
	{
		String output="";
		for(int r=0; r<mat.length; r++)
		{
			for(int c=0; c<=r; c++)
			{
				output+=mat[r][c]+"\t";
			}
			output+="\n";
		}
		return output;
	}
}
