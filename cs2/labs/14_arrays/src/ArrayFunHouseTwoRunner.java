import java.util.Arrays;

public class ArrayFunHouseTwoRunner
{
	public static void main( String args[] )
	{
		int[] one = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(Arrays.toString(one));
		System.out.println("is going Up ? " + ArrayFunHouseTwo.goingUp(one));

		int[] two = {1, 2, 3, 9, 11, 20, 30};
		System.out.println(Arrays.toString(two));
		System.out.println("is going Up ? " + ArrayFunHouseTwo.goingUp(two));

		int[] three = {9, 8, 7, 6, 5, 4, 3, 2, 0, -2};
		System.out.println(Arrays.toString(three));
		System.out.println("is going Up ? " + ArrayFunHouseTwo.goingUp(three));

		int[] four = {3, 6, 9, 12, 15, 18, 21, 23, 19, 17, 15, 13, 11, 10, 9, 6, 3, 2, 1, 0};
		System.out.println(Arrays.toString(four));
		System.out.println("is going Up ? " + ArrayFunHouseTwo.goingUp(four));

		System.out.println();

		int[] five = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(Arrays.toString(five));
		System.out.println("is going Down ? " + ArrayFunHouseTwo.goingDown(five));

		int[] six = {1, 2, 3, 9, 11, 20, 30};
		System.out.println(Arrays.toString(six));
		System.out.println("is going Down ? " + ArrayFunHouseTwo.goingDown(six));

		int[] seven = {9, 8, 7, 6, 5, 4, 3, 2, 0, -2};
		System.out.println(Arrays.toString(seven));
		System.out.println("is going Down ? " + ArrayFunHouseTwo.goingDown(seven));

		int[] eight = {3, 6, 9, 12, 15, 18, 21, 23, 19, 17, 15, 13, 11, 10, 9, 6, 3, 2, 1, 0};
		System.out.println(Arrays.toString(eight));
		System.out.println("is going Down ? " + ArrayFunHouseTwo.goingDown(eight));

		int[] nine = {3, 6, 9, 12, 15, 18, 21, 23, 19, 17, 15, 13, 11, 10, 9, 6, 3, 2, 1, 0};
		System.out.println("first 7 values greater than 9 " + Arrays.toString(ArrayFunHouseTwo.getCountValuesBiggerThanX(nine, 7, 9)));
		System.out.println("first 5 values greater than 15 " + Arrays.toString(ArrayFunHouseTwo.getCountValuesBiggerThanX(nine, 5, 15)));

	}
}
