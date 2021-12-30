import java.util.*;
import java.io.*; 

public class MatrixSumming
{
    private int[][] m = {{0, 0, 0, 0, 0, 0, 0},
    {0, 1, 2, 3, 4, 5, 0},
    {0, 6, 7, 8, 9, 0, 0},
    {0, 6, 7, 1, 2, 5, 0},
    {0, 6, 7, 8, 9, 0, 0},
    {0, 5, 4, 3, 2, 1, 0},
    {0, 0, 0, 0, 0, 0, 0}};

    public int sum( int r, int c )
    {
        int sum = 0;
        int[] rr = {1,0,-1};
        for( int x : rr)
            for(int i : rr)
                sum+= m[r+x][c+i]; // in bounds
    }

    sum = 0; 
    for(int i = r-1; i<=r+1; i++)
        for(int j = c-1; j<=c+1;j++)
            if(i>=0 && i < m.length && c>=0 && c<m[i].length)
                sum += m[i][j];

    sum = 0; 
    for(int i = Math.max(0,r-1); i<=r+1 && i < m.length; i++)
        for(int j = Math.max(0,c-1); j<=c+1 && j < m[i].length;j++)
            sum += m[i][j];
        return sum;
    }

    public void go() throws Exception
    {
        Scanner f = new Scanner( new File( "lab24x.dat" ));
        int times = f.nextInt();
        for( int dx = 0; dx < times; dx++ )
        {
            int r = f.nextInt();
            int c = f.nextInt();
            System.out.println("The sum of " + r + "," + c + " is "  + sum(r+1,c+1) );
        }
    }

    public static void main(String[] args) throws Exception
    {
        MatrixSumming x = new MatrixSumming();
        x.go();
    }
}
