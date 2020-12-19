import static java.lang.System.*;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayStats
{
	//instance variable
	int[] array;
	//constructor
	public ArrayStats(int[] n) {
		array = n;
	}
	//set method
	public void setarray(int[] n) {
		array = n;
	}
	
	public int getNumGroupsOfSize(int size)
	{
		int cnt=0;
		int groups = 0;
		for (int i: array) {
			if (i != cnt) {
				cnt = i;
				groups++;
			}
		}
		int currentGroup = 0;
		int g[] = new int[groups];
		cnt = array[0];
		int groupCount = 0; // counting how many in each group
		for (int i: array) {
			if (i != cnt) { // new group
				System.out.println("New: " + i);
				cnt = i;
				g[currentGroup++] = groupCount;
				groupCount = 1;
			}
			//else if () { // same group, make sure it's not last else last not added
				//groupCount++;
			//}
		}
		System.out.println(Arrays.toString(g));
		// g[] now has counts of every group, now we find sizes
		int count = 0;
		for (int i = 0; i < g.length; i++) {
			if (g[i] >= size) {
				count++;
			}
		}
		return count;
	}
	
	public String toString()
	{
		return ""+Arrays.toString(array);
	}
}
