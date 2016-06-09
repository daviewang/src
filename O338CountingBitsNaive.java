public class O338CountingBitsNaive {
	public int[] countBits(int num) {
		if (num <= 0) return new int[] {0};
		int[] res = new int[num + 1];
		for (int i = 0; i <= num; i++) {
			res[i] = getBits(i);
		}
		return res;
	}
	private int getBits(int n) {
		int res = 0;
		while (n > 0) {
			if ((n & 1) == 1) {
				res++;
			}
			n >>= 1;
		}
		return res;
	}
	
	public static void main(String[] args) {
		O338CountingBitsNaive e = new O338CountingBitsNaive();
		e.countBits(2);
	}
}