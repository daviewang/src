public class O415AddStrings {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) {
			return num2;
		}
		if (num2 == null || num2.length() == 0) {
			return num1;
		}
		char[] num1Chars = num1.toCharArray();
		char[] num2Chars = num2.toCharArray();
		
		StringBuilder res = new StringBuilder();
		int carry = 0;
		int num1Idx = num1Chars.length - 1;
		int num2Idx = num2Chars.length - 1;
		
		while (num1Idx >= 0 && num2Idx >= 0) {
			int temp = num1Chars[num1Idx] - '0' + num2Chars[num2Idx] - '0' + carry;
			carry = temp / 10;
			res.insert(0, temp % 10);
			num1Idx--;
			num2Idx--;
		}
		
		while (num1Idx >= 0) {
			int temp = num1Chars[num1Idx] - '0' + carry;
			carry = temp / 10;
			res.insert(0, temp % 10);
			num1Idx--;				
		}
		
		while (num2Idx >= 0) {
			int temp = num2Chars[num2Idx] - '0' + carry;
			carry = temp / 10;
			res.insert(0, temp % 10);
			num2Idx--;
		}
		
		if (carry != 0) {
			res.insert(0, carry);
		}
		
		return res.toString();
    }
    
    public static void main(String[] args) {
    	O415AddStrings e = new O415AddStrings();
    	e.addStrings("9", "99");
    }
}