import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;
import java.util.Arrays;

public class ToyStore
{
	private ArrayList<Toy> toyList;

	public ToyStore()
	{
		toyList = new ArrayList<Toy>();
	}

	public void loadToys( String toys )
	{
		String[] t = toys.split(" ");
		for (String toy: t) {
			boolean found = false;
			for (Toy obj: toyList) {
				if (toy.equals(obj.getName())) {
					found = true;
					obj.setCount(obj.getCount() + 1);
				}
			}
			if (!found) {
				toyList.add(new Toy(toy));
				toyList.get(toyList.size() - 1).setCount(1);
			}
		}
	}
  
	public Toy getThatToy( String nm )
	{
		for (Toy t: toyList) {
			if (t.getName().equals(nm)) {
				return t;
			}
		}
		return null;
	}

	public String getMostFrequentToy()
	{
		String name = "";
		int count = 0;
		for (Toy toy: toyList) {
			if (toy.getCount() > count) {
				count = toy.getCount();
				name = toy.getName();
			}
		}
		return "max == " + name;
	}

	public void sortToysByCount()
	{
	}
  	  
	public String toString()
	{
	   return "" + toyList;
	}
}
