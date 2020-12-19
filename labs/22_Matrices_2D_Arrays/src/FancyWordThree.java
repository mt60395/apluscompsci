import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;
import java.util.Arrays;

class FancyWordThree
{
	private String[][] mat;

	public FancyWordThree() {
		mat=new String[0][0];
	}

	public FancyWordThree(String s) {
		int size = (s.length()*2-1)*2-1;
		mat = new String[size][size];

		for( String[] row : mat )
			Arrays.fill(row," ");

		int center = s.length()*2-2;
		StringBuffer sb = new StringBuffer(s);
		String one = sb.reverse()+s.substring(1);
		String two = s+sb.substring(1);

		for(int spot=0;spot<one.length();spot++)
		{
			mat[center-spot][spot]= one.substring(spot,spot+1);
			mat[center+spot][spot]= one.substring(spot,spot+1);
			mat[center-spot][size-spot-1]= one.substring(spot,spot+1);
			mat[center+spot][size-spot-1]= one.substring(spot,spot+1);
			mat[s.length()-1+spot][s.length()-1+spot]=two.substring(spot,spot+1);
			mat[size-s.length()-spot][s.length()-1+spot]=two.substring(spot,spot+1);
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
