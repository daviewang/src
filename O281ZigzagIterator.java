import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class O281ZigzagIterator {
	Queue<Iterator<Integer>> queue;
	public O281ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		queue = new LinkedList<>();
		if (!v1.isEmpty()) {
			queue.add(v1.iterator());
		}
		if (!v2.isEmpty()) {
			queue.add(v2.iterator());
		}
	}
	
	public int next() {
		if (!hasNext()) return -1;
		int res = 0;
		Iterator<Integer> curr = queue.poll();
		res = curr.next();
		if (curr.hasNext())
			queue.offer(curr);
		return res;
	}
	
	public boolean hasNext() {
		return !queue.isEmpty();
	}
}