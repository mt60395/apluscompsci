import java.util.Stack;

public class ListFunHouseTwo
{
	private ListNode theList;
	
	public ListFunHouseTwo()
	{
		theList = new ListNode(); // TODO
	}
	
	public void add(Comparable data)
	{
		ListNode prev = new ListNode(data, theList);
		theList = prev;
	}
	
	//this method will return the number of nodes present in list
	public int nodeCount()
	{
		int count=0;
		ListNode tracker = theList;
		while (tracker.getNext() != null) {
			tracker = tracker.getNext();
			count++;
		}
   		return count;
	}
		
	//this method will create a new node with the same value as the first node and add this
	//new node at the front of the list.  Once finished, the first node will occur twice.
	public void doubleFirst()
	{
		add(theList.getValue());
	}

	//this method will create a new node with the same value as the last node and add this
	//new node at the end.  Once finished, the last node will occur twice.
	public void doubleLast()
	{
		Stack<Comparable> stack = new Stack<>(); // todo
		ListNode tracker = theList;
		while (tracker.getNext() != null && tracker.getNext().getValue() != null) { // TODO lol
			stack.push(tracker.getValue());
			tracker = tracker.getNext();
		}
		stack.push(tracker.getValue());
		stack.push(tracker.getValue());
		theList = new ListNode();
		while (!stack.isEmpty()) {
			add(stack.pop());
		}
	}
	
	//method skipEveryOther will remove every other node
	public void skipEveryOther()
	{
		Stack<Comparable> stack = new Stack<>();
		ListNode tracker = theList;
		boolean skip = false;
		while (tracker.getNext() != null) { // TODO lol
			if (!skip) {
				stack.push(tracker.getValue());
			}
			skip = !skip;
			tracker = tracker.getNext();
		}
		theList = new ListNode();
		while (!stack.isEmpty()) {
			add(stack.pop());
		}
	}

	//this method will set the value of every xth node in the list
	public void setXthNode(int x, Comparable value)
	{
		Stack<Comparable> stack = new Stack<>();
		ListNode tracker = theList;
		int count = 1;
		while (tracker.getNext() != null) {
			if (count == x) {
				stack.push(value);
				count = 1;
			}
			else {
				stack.push(tracker.getValue());
				count++;
			}
			tracker = tracker.getNext();
		}
		theList = new ListNode();
		while (!stack.isEmpty()) {
			add(stack.pop());
		}
	}	

	//this method will remove every xth node in the list
	public void removeXthNode(int x)
	{
		Stack<Comparable> stack = new Stack<>();
		ListNode tracker = theList;
		int count = x;
		while (tracker.getNext() != null) {
			if (count-- == 1) {
				count = x;
			}
			else {
				stack.push(tracker.getValue());
			}
			if (count < 1) count = x;
			tracker = tracker.getNext();
		}
		theList = new ListNode();
		while (!stack.isEmpty()) {
			add(stack.pop());
		}
	}		
	//this method will return a String containing the entire list
	public String toString()
	{
		String output="";
		ListNode tracker = theList;
		while (tracker.getNext() != null) {
			output += tracker.getValue() + " ";
			tracker = tracker.getNext();
		}
		return output;
	}			

}
