import java.util.Scanner;
import static java.lang.System.*;

public class MonsterRunner
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(System.in);

		//ask for name and size
		out.print("Enter 1st monster's name : ");
		String name = keyboard.nextLine();
		out.print("Enter 1st monster's size : ");
		int size = keyboard.nextInt();
		keyboard.nextLine();

		//instantiate monster one
		Monster one = new Monster(name, size);

		//ask for name and size
		out.print("Enter 2nd monster's name : ");
		name = keyboard.nextLine();
		out.print("Enter 2nd monster's size : ");
		size = keyboard.nextInt();

		//instantiate monster two
		Monster two = new Monster(name, size);

		out.println();

		out.println("Monster 1 - " + one);
		out.println("Monster 2 - " + two);

		out.println();

		out.printf("Monster one is %s than Monster two.\n", one.isSmaller(two)?"smaller":"bigger");
		out.printf("Monster one %s the same name as Monster two.\n", one.namesTheSame(two)?"has":"does not have");
	}
}
