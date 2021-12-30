import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class TicTacToe
{
	private char[][] mat;

	public TicTacToe()
	{
		mat = new char[3][3];
	}

	public TicTacToe(String game)
	{
		mat = new char[3][3];
		int cnt=0;
		for(int r=0; r<3; r++)
		{
			for(int c=0; c<3; c++)
			{
				mat[r][c]=game.charAt(cnt);
				cnt++;
			}
		}
	}

	public String getWinner()
	{
		String winner="";
		for (int r = 0; r<3; r++)
		{
			if(mat[r][0]==mat[r][1]&&mat[r][0]==mat[r][2])
			{
				winner=mat[r][0]+" wins horizontally!";
				break;
			}
			if(mat[0][r]==mat[1][r]&&mat[0][r]==mat[2][r])
			{
				winner=mat[0][r]+" wins vertically!";
				break;
			}			
		}
		if(mat[0][0]==mat[1][1]&&mat[0][0]==mat[2][2])
		{
			winner=mat[0][0]+" wins diagonally!";
		}
		if(mat[2][0]==mat[1][1]&&mat[2][0]==mat[0][2])
		{
			winner=mat[2][0]+" wins diagonally!";
		}

		if(winner.length()==0)
		   return "cat's game - no winner!\n\n";
		else{
		   return winner + "\n\n";
		}
	}

	public String toString()
	{
		String output="";
		for (int r = 0; r<mat.length; r++)
		{
			for (int c = 0; c<mat[r].length; c++)
			{
				output+=mat[r][c] + " ";
			}
			output+="\n";
		}
		return output;
	}
}
