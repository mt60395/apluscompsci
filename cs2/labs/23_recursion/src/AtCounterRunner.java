import static java.lang.System.*;

public class AtCounterRunner
{
	public static void main(String args[])
	{
		//instantiate an AtCounter
		AtCounter a = new AtCounter();
		//test the code
		out.println(a);
		out.println(a.countAts(0,0));
	}
}
