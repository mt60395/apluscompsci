import static java.lang.System.*;

public class SpiralMatrix {
	private int[][] spiral;

	public SpiralMatrix()
	{
		setSize(0);
	}

	public SpiralMatrix(int size)
	{
		setSize(size);
	}
	
	public void setSize(int size)
	{
		spiral = new int[size][size];		
	}

	public void createSpiral()
	{
		int size = spiral[0].length;
		int num = size;
		int counter = 1;
		do{
			int gap=size-num;

			for(int r=gap; r<num; r++)
				spiral[r][gap] = counter++;

			for(int c=gap+1; c<num; c++)
				spiral[num-1][c] = counter++;

			for(int r= gap+1; r<num; r++)
				spiral[size-r-1][num-1] = counter++;

			for(int c = gap +1; c<num-1; c++)
				spiral[gap][size-c-1] = counter++;
				
			num--;
		}
		while(num>=1);
	}

	public String toString( )
	{
		String output="";
		int end = spiral.length;
		for(int r = 0; r < end; r ++)
		{
			for(int c = 0; c < end; c++)
			{
				output+=spiral[r][c]+"\t";
			}
			output+="\n";
		}
		return output;
	}
}
