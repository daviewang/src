public class O008StringToInteger {
	public int myAtoi(String str) {
		if (str == null || str.length() == 0) return 0;
		str = str.trim();
		long res = 0;
		boolean isPositive = true;
		int i = 0;
		if (str.charAt(0) == '+') {
			isPositive = true;
			i++;
		}
		else if (str.charAt(0) == '-'){
			isPositive = false;
			i++;
		}
		
		for (; i < str.length(); i++ ) {
			char c = str.charAt(i);
			if (c < '0' || c > '9') break;
			if (isPositive) {
				res = res * 10 + c - '0';
				if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
			}
			else {
				res = res * 10 - (c - '0');
				if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
			}
		}
		return (int) res;
	}
}