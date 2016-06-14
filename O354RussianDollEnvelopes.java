import java.util.Comparator;
import java.util.Arrays;

public class O354RussianDollEnvelopes {
	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0)
			return 0;
		Comparator<int[]> cp = new Comparator<int[]>(){
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0]) {
					return a[0] - b[0];
				}
				else {
					return a[1] - b[1];
				}
			}
		};
		Arrays.sort(envelopes, cp);
		
		int len = envelopes.length;
		int[] dp = new int[len];
		int res = 0;
		
		for (int i = 0; i < len; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (envelopes[j][0] < envelopes[i][0] &&
						envelopes[j][1] < envelopes[i][1]) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}
}