import java.util.Stack;

public class O331VerifyPreorderSerializationBT {
	public boolean isValidSerialization(String preorder) {
		if (preorder == null) {
			return false;
		}
		Stack<String> stack = new Stack<>();
		String[] strs = preorder.split(",");
		for (String str : strs) {
			while (str.equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
				stack.pop();
				if (stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
			stack.push(str);
		}
		return stack.size() == 1 && stack.peek().equals("#");
	}
	
	public static void main(String[] args) {
		O331VerifyPreorderSerializationBT e = new O331VerifyPreorderSerializationBT();
		System.out.println(e.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
	}
}