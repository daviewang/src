public class O007ReverseInteger {
	public int reverse(int num) {
			long res = 0;
			if (num == 0) return 0;
			
			while (num != 0) {
				res = res * 10 + num % 10;
				if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
					res = 0;
					break;
				}
				num /= 10;
			}
			return (int) res;
	}
	
	public static void main(String[] args) {
		O007ReverseInteger e = new O007ReverseInteger();
		e.reverse(-123);
	}
}