import static java.lang.System.*;

public class Toy
{
	private String name;
	private int count;

	public Toy()
	{
		name = "yo-yo";
		count = 1;
	}

	public Toy( String nm )
	{
		name = nm;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public void setCount( int cnt )
	{
		count = cnt;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName( String nm )
	{
		name = nm;
	}

	public String toString()
	{
	   return String.format("%s %d", name, count==0? 1:count);
	}
}
