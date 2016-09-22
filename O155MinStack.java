import java.util.Stack;

public class O155MinStack {
	Stack<Integer> minStack;
	Stack<Integer> normalStack;
	
	public O155MinStack() {
		minStack = new Stack<>();
		normalStack = new Stack<>();
	}
	
	public void push(int val) {
		if (minStack.isEmpty() || minStack.peek() >= val) {
			minStack.push(val);
		}
		normalStack.push(val);
	}
	
	public void pop() {
		if (!minStack.isEmpty() && minStack.peek().equals(normalStack.peek())) {
			minStack.pop();
		}
		normalStack.pop();
	}
	
	public int top() {
		return normalStack.peek();
	}
	
	public int getMin() {
		return minStack.peek();
	}
	
	public static void main(String[] args) {
		O155MinStack e = new O155MinStack();
		e.push(512);
		e.push(-1024);
		e.push(-1024);
		e.push(512);
		e.pop();
		System.out.println(e.getMin());
		e.pop();
		System.out.println(e.getMin());
		e.pop();
		System.out.println(e.getMin());		
	}
}