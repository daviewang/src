public class O096UniqueBST {
	public int numTrees(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		
		int[] res = new int[n + 1];
		res[0] = 1;
		res[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			for (int k = 1; k <= i; k++) {
				res[i] += res[k - 1] * res[i - k];
			}
		}
		return res[n];
	}
}