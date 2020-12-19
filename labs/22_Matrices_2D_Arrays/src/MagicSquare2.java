import static java.lang.System.*;

public class MagicSquare2
{
	private int[][] magicSquare;

	public MagicSquare2()
	{
		setSize(0);
	}

	public MagicSquare(int size)
	{
		setSize(size);
	}

	public void setSize(int size)
	{
		magicSquare = new int[size][size];
	}

	public void createMagic()
	{
		int num = 1;
		int end = magicSquare.length;

		magicSquare[0][end/2]= num;
		int row=0;
		int col = end/2;

		for(int i = 1; i < end*end; i++)
		{
			num++;
			row--;
			col++;

			if(row < 0)
			{
				row = end - 1;
			}
			if(col > end - 1)
			{
				col= 0;
			}
			if(magicSquare[row][col] != 0)
			{
				row++;
				col--;
				if(row>end - 1)
					row=0;
				if(col<0)
					col=end - 1;
				row++;
			}
			magicSquare[row][col]= num;
		}
	}

	public String toString( )
	{
		String output="";
		int end = magicSquare.length;
		for(int r = 0; r < end; r ++)
		{
			for(int c = 0; c < end; c++)
			{
				output+=magicSquare[r][c]+"\t";
			}
			output+="\n";
		}
		out.println();
		return output;
	}
}
