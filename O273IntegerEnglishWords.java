import java.util.LinkedList;
import java.util.Stack;

public class O273IntegerEnglishWords {
	private final String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", 
			"Six", "Seven", "Eight", "Nine", "Ten", 
			"Eleven", "Twelve", "Thirteen", "Fourteen", 
			"Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", 
			"Sixty", "Seventy", "Eighty", "Ninety"};
	private final String[] thousands = {"", "Thousand", "Million", "Billion"};
	
	public String numberToWords(int num) {
		Stack<String> stack = new Stack<>();
		if (num == 0) return "Zero";
		while (num > 0) {
			if (num % 1000 != 0) {
				stack.push(helper(num % 1000));
			}
			else {
				stack.push("0");
			}
			num /= 1000;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = stack.size() - 1; i >= 0; i--) {
			if (!stack.peek().equals("0"))
				sb.append(stack.pop() + thousands[i] + " ");
			else 
				stack.pop();
		}
		return sb.toString().trim();
    }
	
	//1000以内的转换
	private String helper(int num) {
		if (num == 0) return "";
		if (num < 20) return lessThan20[num] + " ";
		else if (num < 100) {
			return tens[num / 10] + " " + helper(num % 10);
		}
		else {
			return lessThan20[num / 100] + " Hundred " + helper(num % 100);
		}
	}
	public static void main(String[] args) {
		O273IntegerEnglishWords e = new O273IntegerEnglishWords();
		e.numberToWords( 1000010);
	}
}