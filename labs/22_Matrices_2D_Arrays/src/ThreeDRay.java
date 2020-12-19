import java.util.*;
public class ThreeDRay
{
    private int[][][] matrices;

    public ThreeDRay(int numMats)
    {
        matrices = new int[numMats][0][0];
    }

    public ThreeDRay(int numMats, int numRows, int numCols)
    {
        matrices = new int[numMats][numRows][numCols];
    }

    public void setMatrixSize(int whichMat, int rowsize, int colSize)
    {
        matrices[whichMat] = new int[rowsize][colSize];
    }

    public void setMatrix(int whichMat, int[][] mat)
    {
        setMatrixSize(whichMat,mat.length,mat[0].length);
        for(int r=0;r<mat.length;r++)
            for(int c=0;c<mat[r].length;c++)
                matrices[whichMat][r][c]=mat[r][c];
    }

    public int[][] getMatrix(int whichMat) {
        return matrices[whichMat];
    }

    public int[][] addMatrices(int one, int two ) {
        int[][] result = new int[matrices[one].length][matrices[one].length];
        for(int r=0;r<result.length;r++)
            for(int c=0;c<result.length;c++)
                result[r][c] = matrices[one][r][c] + matrices[two][r][c];
        return result;
    }

    public static int[][] mult(int[][]a, int[][]b){
        int[][]m = new int[a.length][b[0].length];
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[i].length; j++){
                for(int k = 0; k< b.length; k++){
                    m[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return m;
    }

    public String toString() {
        String output="";
        for(int i=0; i<matrices.length;i++) {
            output+="mat "+i+"\n";
            for(int r=0; r<matrices[i].length; r++) {
                output+="\trow "+r+"\t";
                for(int c=0; c<matrices[i][r].length; c++) {
                    output+=matrices[i][r][c] + "  ";
                }
                output+="\n";
            }
        }
        return output;
    }
 
    public static void main(String[] args){
        int[][]a = {{1,2,3}, {4,5,6}};
        int[][]b = {{7,8},{9,10},{11,12}};
        System.out.println(Arrays.deepToString(mult(a,b)));
    }
}
