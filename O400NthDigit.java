public class O400NthDigit {
	public int findNthDigit(int n) {
		int len = 1;
		long base = 9;
		int start = 1;
		
		while (n > len * base) {
			n -= len * base;
			len++;
			base *= 10;
			start *= 10;
		}
		start += (n - 1) / len;
		String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % len));
	}
}