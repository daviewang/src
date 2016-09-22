public class O067AddBinary {
	public String addBinary(String a, String b) {
		if (a == null || a.length() == 0) return b;
		if (b == null || b.length() == 0) return a;
		
		StringBuilder res = new StringBuilder();
		
		int carry = 0;
		
		int aIdx = a.length() - 1;
		int bIdx = b.length() - 1;
		
		while (aIdx >= 0 || bIdx >= 0) {
			int singleRes = carry;
			if (aIdx >= 0) singleRes += a.charAt(aIdx--) - '0';
			if (bIdx >= 0) singleRes += b.charAt(bIdx--) - '0';
			res.append(singleRes % 2);
			carry = singleRes / 2;
		}
		if (carry > 0) res.append(carry);
		return res.reverse().toString();
	}
	
	public static void main(String[] args) {
		O067AddBinary e = new O067AddBinary();
		System.out.println(e.addBinary("11", "1"));
	}
}