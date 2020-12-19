public class ArrayStatsRunner
{
	public static void main(String args[])
	{

		ArrayStats a = new ArrayStats(new int[]{3, 3, 3, 3, 3, 9, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8});
		System.out.println(a);
		System.out.printf("size %d count == %d", 1, a.getNumGroupsOfSize(1));
	}
}
