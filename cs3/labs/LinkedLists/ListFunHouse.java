public class ListFunHouse
{
	//this method will print the entire list on the screen
	public static void print(ListNode list)
	{
		StringBuffer output = new StringBuffer();
		while (list != null) {
			output.append(list.getValue());
			output.append(" ");
			list = list.getNext();
		}
		System.out.println(output);
	}		
	
	//this method will return the number of nodes present in list
	public static int nodeCount(ListNode list)
	{
   		int count=0;
		while (list != null) {
			list = list.getNext();
			count++;
		}
		return count;
	}
		
	//this method will create a new node with the same value as the first node and add this
	//new node to the list.  Once finished, the first node will occur twice.
	public static void doubleFirst(ListNode list)
	{
		list.setNext(new ListNode(list.getValue(), list.getNext()));
	}

	//this method will create a new node with the same value as the last node and add this
	//new node at the end.  Once finished, the last node will occur twice.
	public static void doubleLast(ListNode list)
	{
		while (list.getNext() != null) {
			list = list.getNext();
		}
		ListNode addLast = new ListNode(list.getValue(), null);
		list.setNext(addLast);
	}
		
	//method skipEveryOther will remove every other node
	public static void skipEveryOther(ListNode list)
	{
		boolean toRemove = true;
		while (list != null) {
			toRemove = !toRemove;
			if (toRemove) {
				list.setNext(list.getNext().getNext());
			}
			else {
				list = list.getNext();
			}
		}
	}

	//this method will set the value of every xth node in the list
	public static void setXthNode(ListNode list, int x, Comparable value)
	{
		int count = x;
		while (list != null) {
			if (count-- == 1) {
				list.setValue(value);
			}
			if (count < 1) count = x;
			list = list.getNext();
		}
	}

	//this method will remove every xth node in the list
	public static void removeXthNode(ListNode list, int x)
	{
		int count = 1;
		while (list != null) {
			if (count + 1 == x) {
				list.setNext(list.getNext().getNext());
				count = 1;
			}
			else {
				count++;
			}
			list = list.getNext();
		}
	}
}
