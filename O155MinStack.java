import java.util.Stack;

public class O155MinStack extends Stack<Integer> {
	Stack<Integer> minStack;
	
	public O155MinStack() {
		minStack = new Stack<>();
	}
	
	public void push(int val) {
		if (minStack.isEmpty() || minStack.peek() >= val) {
			minStack.push(val);
		}
		super.push(val);
	}
	
	public Integer pop() {
		Integer val = super.pop();
		if (!minStack.isEmpty() && minStack.peek() <= val) {
			minStack.pop();
		}
		return val;
	}
}