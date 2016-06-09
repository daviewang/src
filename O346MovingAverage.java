import java.util.LinkedList;
import java.util.Queue;

public class O346MovingAverage {
	Queue<Integer> queue;
	int sum;
	int len;
	
	public O346MovingAverage(int len) {
		queue = new LinkedList<>();
		sum = 0;
		this.len = len;
	}
	
	public int next(int item) {
		if (queue.size() >= len) {
			sum -= queue.poll();
		}
		queue.offer(item);
		sum += item;
		return sum / queue.size();
	}
	
	public static void main(String[] args) {
		O346MovingAverage m = new O346MovingAverage(3);
		System.out.println(m.next(1));
		System.out.println(m.next(10));
		System.out.println(m.next(3));
		System.out.println(m.next(5));
	}
}