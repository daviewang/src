public class O066PlusOne {
	public int[] plusOne(int[] digits) {
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int temp = digits[i] + carry;
			if(temp / 10 == 0) {
				digits[i] = temp;
				carry = 0;
				break;
			}
			else {
				digits[i] = temp % 10;
				carry = 1;
			}
		}
		if (carry == 0) {
			return digits;
		}

		int[] res = new int[digits.length + 1];
		res[0] = 1;
		for (int i = 1; i < res.length; i++) {
			res[i] = digits[i - 1];
		}
		return res;
	}
	
	public static void main(String[] args) {
		O066PlusOne e = new O066PlusOne();
		int[] in = {9,9};
		e.plusOne(in);
	}
}