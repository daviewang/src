public class O264UglyNumberII {
	public int nthUglyNumber(int n) {
		int idx2 = 0;
		int idx3 = 0;
		int idx5 = 0;
		int[] res = new int[n];
		res[0] = 1;
		for (int i = 1; i < n; i++) {
			res[i] = Math.min(Math.min(res[idx2] * 2, res[idx3] * 3), res[idx5] * 5);
			if (res[i] == res[idx2] * 2) idx2++;
			if (res[i] == res[idx3] * 3) idx3++;
			if (res[i] == res[idx5] * 5) idx5++;
		}
		return res[n - 1];
	}
}