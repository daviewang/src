public class O402RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0) return num;
		int digits = num.length() - k;
		char[] stack = new char[num.length()];
		int stackPoint = 0;
		for (int i = 0; i < num.length(); i++) {
			char c = num.charAt(i);
			while (stackPoint > 0 && stack[stackPoint - 1] > c && k > 0) {
				stackPoint--;
				k--;
			}
			stack[stackPoint++] = c;
		}
		
		int i = 0;
		for (; i < digits; i++) {
			if (stack[i] != '0') break;
		}
		return i == digits ? "0" : new String(stack, i, digits - i);
    }
    
    public static void main(String[] args) {
    	O402RemoveKDigits e = new O402RemoveKDigits();
    	e.removeKdigits( "21", 2);
    }
}