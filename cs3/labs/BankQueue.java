import java.util.PriorityQueue;
public class BankQueue {
	public static int waitTime(int[] customers, int n) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (Integer num: customers) {
			if (pq.size() < n) {
				pq.offer(num);
			}
			else {
				//System.out.println(pq.toString());
				pq.add(pq.poll() + num);
			}
		}
		int largest = -1;
		while (!pq.isEmpty()) largest = pq.poll();
		return largest;
	}
}
