import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class O251Flatten2DVector {
	Queue<Iterator<Integer>> queue;
	Iterator<Integer> curr;
	
	public O251Flatten2DVector(List<List<Integer>> vec2d) {
		for (List<Integer> list : vec2d) {
			queue.add(list.iterator());
		}
		curr = queue.poll();
	}
	
	public int next() {
		if (!curr.hasNext()) {
			return -1;
		}
		return curr.next();
	}
	
	public boolean hasNext() {
		if (curr == null)
			return false;
			
		while(!curr.hasNext()) {
			if (!queue.isEmpty()) {
				curr = queue.poll();
			}
			else {
				return false;
			}
		}
		return true;
	}
}