import java.lang.System;
import java.lang.Math;

public class ArrayFunHouseTwo
{
	//goingUp() will return true if all numbers
	//in numArray are in increasing order
	//[1,2,6,9,23] returns true
	//[9, 11, 13, 8]  returns false
	public static boolean goingUp(int[] numArray)
	{
		int num = numArray[0];
		boolean isUp = true;
		for (int i: numArray) {
			if (i < num) isUp = false; // if next number less than previous, flag
			num = i;
		}
		return isUp;
	}

	//goingDown() will return true if all numbers
	//in numArray are in decreasing order
	//[31,12,6,2,1] returns true
	//[31, 20, 10, 15, 9] returns false
	public static boolean goingDown(int[] numArray)
	{
		int num = numArray[0];
		boolean isDown = true;
		for (int i: numArray) {
			if (i > num) isDown = false; // if next number greater than previous, flag
			num = i;
		}
		return isDown;
	}

	//getValuesBiggerThanX will return an array that contains
	//count number of values that are larter than parameter x
	//[1,2,3,4,5,6,7,8,9,10,11,6],3,5  would return [6,7,8]
	public static int[] getCountValuesBiggerThanX(int[] numArray, int count, int x)
	{
		int toCount = 0;
		int[] numArray2 = new int[numArray.length]; // make it + 1 for the indexes that are greater
		for (int i = 0; i < numArray.length; i++) {
			if (toCount < count) {
				if (numArray[i] > x) {
					numArray2[i]++;
					toCount++;
				}
			}
		}
		int index = 0;
		int[] greater = new int[toCount];
		for (int i = 0; i < numArray2.length; i++) {
			if (numArray2[i] > 0) {
				greater[index] = numArray[i];
				index++;
			}
		}
		return greater;
	}
}
