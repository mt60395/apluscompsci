import java.util.Scanner;
import static java.lang.System.*;

public class KittyMap
{
	private boolean[][] kittyGrid;

	public KittyMap(int rows, int cols)
	{
		kittyGrid = new boolean[rows][cols];
		for( int i = 0; i < rows; i++)
		{
			for( int j = 0; j < cols; j++)
			{
				int v = (int)(Math.random()*8);
				kittyGrid[i][j] = v== 1 ? true : false;
			}
		}
	}

	public void printKittyCount()
	{
		int[][] km =  getKittyCountsGrid();
		for( int[] row : km )
		{
			for( int val : row)
			{
				System.out.print( val + " ");
			}
			System.out.print( "\n" );
		}
	}

	private int[][] getKittyCountsGrid()
	{
		int[][] km =  new int[kittyGrid.length][kittyGrid[0].length];
		for( int r = 0; r < kittyGrid.length; r++)
		{
			for( int c = 0; c < kittyGrid[0].length; c++)
			{
				km[r][c] = getKittyCount(r,c);
			}
		}
		return km;
	}

	public int getKittyCount( int r, int c)
	{
		if( kittyGrid[r][c] )
			return 9;
		int cnt = 0;
		int[] rr = {1,0,-1};
		for( int x : rr)
		{
			for(int i : rr)
			{
			    if( inBounds(r+x, c+i) )
			    	cnt += kittyGrid[r+x][c+i]?1:0;
			}
		}
		return cnt;
	}

	private boolean inBounds( int r, int c)
	{
		return r < kittyGrid.length && r>=0 && c <kittyGrid[0].length && c>=0;
	}

	public String toString()
	{
		String output="";
		for( boolean[] row : kittyGrid )
		{
			for( boolean val : row)
			{
				output += val ? "1 " : "0 ";
			}
			output += "\n";
		}
		return output.trim();
	}
}
