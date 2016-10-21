public class O029DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if (divisor == -1) {
			return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
		}
		
		int signal = 1;
		if (dividend < 0) signal = -signal;
		if (divisor < 0) signal = -signal;
		
		long temp = Math.abs((long)dividend);
		long temp2 = Math.abs((long)divisor);
		long resPart = 1;
			
		while (temp > temp2) {
			temp2 <<= 1;
			resPart <<= 1;
		}
			
		int res = 0;
			
		while (temp >= Math.abs((long)divisor)) {
			if (temp >= temp2) {
				temp -= temp2;
				res += resPart;
			}
			temp2 >>= 1;
			resPart >>= 1;
		}
		if (signal == 1) {
			return res;
		}
		else {
			return -res;
		}
	}
	
	public static void main(String[] args) {
		O029DivideTwoIntegers e = new O029DivideTwoIntegers();
 		e.divide(15, 3);
	}
}