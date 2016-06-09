import java.util.Collections;
import java.util.PriorityQueue;

public class O295FindMedianDataStream {
	PriorityQueue<Long> leftHeap = new PriorityQueue<Long>(Collections.reverseOrder());
	PriorityQueue<Long> rightHeap = new PriorityQueue<Long>();
	
	public void addNum(int num) {
		leftHeap.add((long)num);
		rightHeap.add(leftHeap.poll());
		if (leftHeap.size() < rightHeap.size()) {
			leftHeap.add(rightHeap.poll());
		}
	}
	
	public double findMedian() {
		if (leftHeap.size() == rightHeap.size()) {
			return (leftHeap.peek() + rightHeap.peek()) / 2.0;
		}
		else {
			return leftHeap.peek();
		}
	}
	
	public static void main(String[] args) {
		O295FindMedianDataStream e = new O295FindMedianDataStream();
		e.addNum(-1);
		e.findMedian();
		e.addNum(-2);
		e.findMedian();
		e.addNum(-3);
		e.findMedian();
		e.addNum(-4);
		e.findMedian();
		e.addNum(-5);
		e.findMedian();
	}
}