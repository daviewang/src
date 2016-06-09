import java.util.Arrays;

//3步
public class O070ClimbingStairs {
	public int climbStairs(int n) {
		int[] res = new int[n];
		if (n == 1) return 1;
		if (n == 2) return 2;
		if (n == 3) return 4;
		res[0] = 1;
		res[1] = 2;
		res[2] = 4;
		for (int i = 3; i < n; i++) {
			res[i] = res[i -1] + res[i - 2] + res[i - 3];
		}
		return res[n - 1];
	}
	
	public int countWaysDP(int n, int[] map) {
		if (n < 0) {
			return 0;
		}
		else if (n == 0) {
			return 1;
		}
		else if (map[n] > -1) {
			return map[n];
		}
		else {
			map[n] = countWaysDP(n - 1, map) +
					 countWaysDP(n - 2, map) + 
					 countWaysDP(n - 3, map);
			return map[n];
		}
	}
	
	public int countWays(int n) {
		if (n < 0) {
			return 0;
		}
		else if (n == 0) {
			return 1;
		}
		else {
			return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
		}
	}
	public static void main(String[] args) {
		O070ClimbingStairs e = new O070ClimbingStairs();
		int[] map = new int[10];
		Arrays.fill(map, -1);
		System.out.println(e.climbStairs(5));
		int outP = e.countWaysDP(5, map);
		System.out.println(outP);
	}
	
}