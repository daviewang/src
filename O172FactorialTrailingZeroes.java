public class O172FactorialTrailingZeroes {
	public int zeroCount(int n) {
		
		int res = 0;
		if (n <= 0) return res;
		/*
		while(n > 0) {
			res += n / 5;
			n /= 5;
		}
		return res;
		*/
		for (int i = 2; i <= n; i++) {
			res += factorsOf5(i);
		}
		return res;
	}
	
	private int factorsOf5(int n) {
		int res = 0;
		while (n / 5 > 0 && n % 5 == 0) {
			res++;
			n /= 5;
		}
		return res;
	}
	
	public static void main(String[] args) {
		O172FactorialTrailingZeroes e = new O172FactorialTrailingZeroes();
		System.out.println(e.zeroCount(100));
	}
}