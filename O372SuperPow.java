public class O372SuperPow {
	public int superPow(int a, int[] b) {
		int res = 1;
		int p = a;
		for (int i = b.length - 1; i >= 0; i--) {
			res = res * pow(p, b[i], 1337) % 1337;
			p = pow(p, 10, 1337);
		}
		return res;
	}
	
	private int pow(int a, int b, int c) {
		int p = a;
		int res = 1;
		while (b > 0) {
			if ((b & 1) == 1) {
				res = (res * p) % c;
			}
			p = (p * p) % c;
			b >>= 1;
		}
		return (int)(res % c);
	}
	
	public static void main(String[] args) {
		O372SuperPow e = new O372SuperPow();
		int[] b = {2, 0, 0};
//		System.out.println(e.pow(2, 3, 1337));
		System.out.println(e.superPow(2147483647, b));
	}
}