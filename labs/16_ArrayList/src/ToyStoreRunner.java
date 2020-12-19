import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStoreRunner
{
	public static void main( String args[] )
	{
		String toys = "sorry bat sorry sorry sorry train train teddy teddy ball ball";
		ToyStore store = new ToyStore();
		out.println(store);
		store.loadToys(toys);
		out.println(store);
		out.println(store.getMostFrequentToy());
	}
}
