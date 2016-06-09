public class O067AddBinary {
	public String addBinary(String a, String b) {
		if (a == null || a.length() == 0) {
			return b;
		}
		if (b == null || b.length() == 0) {
			return a;
		}
		StringBuilder sb = new StringBuilder();
		char[] aChars = a.toCharArray();
		char[] bChars = b.toCharArray();
		int carry = 0;
		
		int aIdx = aChars.length - 1;
		int bIdx = bChars.length - 1;
		
		while (aIdx >= 0 && bIdx >= 0) {
			int aTemp = aChars[aIdx--] - '0';
			int bTemp = bChars[bIdx--] - '0';
			sb.append((aTemp + bTemp + carry) % 2);
			carry = (aTemp + bTemp + carry) / 2;
		}
		
		while (aIdx >= 0) {
			int aTemp = aChars[aIdx--] - '0';
			sb.append((aTemp + carry) % 2);
			carry = (aTemp + carry) / 2;
		}
		
		while (bIdx >= 0) {
			int bTemp = bChars[bIdx--] - '0';
			sb.append((bTemp + carry) % 2);
			carry = (bTemp + carry) / 2;
		}
		
		if (carry != 0) {
			sb.append(carry);
		}
		
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		O067AddBinary e = new O067AddBinary();
		System.out.println(e.addBinary("11", "11"));
	}
}