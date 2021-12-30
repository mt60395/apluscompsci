import static java.lang.System.*;

public class Recursion234Runner
{
	public static void main(String args[])
	{
		out.println("\nLab 2\n");
        System.out.println(RecursionFunOne.countOddDigits(4532));
        System.out.println(RecursionFunOne.countOddDigits(1114532));
        System.out.println(RecursionFunOne.countOddDigits(2245327));
        System.out.println(RecursionFunOne.countOddDigits(2468));
        System.out.println(RecursionFunOne.countOddDigits(13579));

        out.println("\nLab 3\n");
        System.out.println(RecursionFunTwo.countChickens("itatfun"));
        System.out.println(RecursionFunTwo.countChickens("itatchickenfun"));
        System.out.println(RecursionFunTwo.countChickens("chchickchickenenicken"));
        System.out.println(RecursionFunTwo.countChickens("chickchickfun"));
        System.out.println(RecursionFunTwo.countChickens("chickenbouncetheballchicken"));

        out.println("\nLab 4\n");
        System.out.println(RecursionFunThree.luckySevens(1087171));
        System.out.println(RecursionFunThree.luckySevens(1077171));
        System.out.println(RecursionFunThree.luckySevens(77077));
        System.out.println(RecursionFunThree.luckySevens(97171771707797L));
        System.out.println(RecursionFunThree.luckySevens(1089651234));
	}
}
