import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.lang.System.*;

public class PersonRunner
{
	public static void main ( String[] args ) throws IOException
	{
		Scanner file = new Scanner(new File("person.dat"));

		int size = file.nextInt();
		Person[] people = new Person[size];
		for (int i = 0; i < size; i++) {
			Person p = new Person(file.nextInt(), file.nextInt(), file.nextInt(), file.next());
			file.nextLine();
			people[i] = p;
		}
		Arrays.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person person, Person t1) {
				return person.compareTo(t1);
			}
		});
		Collections.reverse(Arrays.asList(people)); // descending order
		for (Person p: people) {
			out.println(p);
		}
	}
}
