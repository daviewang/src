import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class O146LRUCache {
	class DLinkedNode {
		int key;
		int val;
		DLinkedNode pre, next;
		DLinkedNode(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
	int capacity;
	DLinkedNode head;
	DLinkedNode end;
	PriorityQueue<DLinkedNode> minQueue, maxQueue;
	Map<Integer, DLinkedNode> map;
	
	public O146LRUCache(int capacity) {
		this.capacity = capacity;
		head = null;
		end = null;
		map = new HashMap<>();
		minQueue = new PriorityQueue<DLinkedNode>(10,
				new Comparator<DLinkedNode>() {
					public int compare(DLinkedNode a, DLinkedNode b) {
						return a.val - b.val;
					}
				});
		maxQueue = new PriorityQueue<DLinkedNode>(10,
				new Comparator<DLinkedNode>() {
					public int compare(DLinkedNode a, DLinkedNode b) {
						return b.val - a.val;
					}
				});
	}
	public void set(int key, int val) {
		if (map.containsKey(key)) {
			DLinkedNode node = map.get(key);
			remove(node);
			node.val = val;
			setHead(node);
		}
		else {
			DLinkedNode node = new DLinkedNode(key, val);
			if (map.size() >= capacity) {
				map.remove(end.key);
				remove(end);	
			}
			setHead(node);
			map.put(key, node);
		}
	}
	public int get(int key) {
		if (map.containsKey(key)) {
			DLinkedNode node = map.get(key);
			remove(node);
			setHead(node);
			return node.val;
		}
		else {
			return -1;
		}
	}
	public int getMin() {
		return minQueue.peek().val;
	}
	public int getMax() {
		return maxQueue.peek().val;
	}
	private void remove(DLinkedNode node) {
		if (node != head) {
			node.pre.next = node.next;
		}
		else {
			head = head.next;
		}
		if (node != end) {
			node.next.pre = node.pre;
		}
		else {
			end = end.pre;
		}
	}
	private void setHead(DLinkedNode node) {
		node.next = head;
		node.pre = null;
		if (head != null)
			head.pre = node;
		head = node;
		if (end == null)
			end = head;
	}
}