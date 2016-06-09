public class O313SuperUglyNumber {
	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] res = new int[n];
		res[0] = 1;
		int[] idx = new int[primes.length];
		for (int i = 1; i < n; i++) {
			int singleItem = Integer.MAX_VALUE;
			for (int j = 0; j < primes.length; j++) {
				if (singleItem > primes[j] * res[idx[j]]) {
					singleItem = primes[j] * res[idx[j]];
				}
			}
			res[i] = singleItem;
			for (int j = 0; j < primes.length; j++) {
				if (singleItem == primes[j] * res[idx[j]]) {
					idx[j]++;
				}
			}
		}
		return res[n - 1];
	}
}