public class O204CountPrimes {
	public int countPrimes(int n) {
		int res = 0;
		if (n <= 1) return res;
		boolean[] isPrimes = new boolean[n];
		for (int i = 2; i < isPrimes.length; i++) {
			isPrimes[i] = true;
		}
		for (int i = 2; i * i < n; i++) {
			if (!isPrimes[i]) continue;
			for (int j = i * i; j < n; j += i) {
				isPrimes[j] = false;
			}
		}
		for (int i = 2; i < n; i++) {
			if (isPrimes[i]) res++;
		}
		return res;
	}
}