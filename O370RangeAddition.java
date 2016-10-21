public class O370RangeAddition {
	public int[] getModifiedArray(int length, int[][] updates) {
		if (length == 0) {
			return new int[0];
		}
		int[] res = new int[length];
		for (int[] update : updates) {
			int start = update[0];
			int end = update[1];
			int val = update[2];
			res[start] += val;
			if (end < length - 1) {
				res[end + 1] += - val;
			}
		}
		for (int i = 1; i < length; i++) {
			res[i] += res[i - 1];
		}
		return res;
	}
	public static void main(String[] args) {
		O370RangeAddition e = new O370RangeAddition();
		int[][] updates = {
		                     {1,  3,  2},
		                     {2,  4,  3},
		                     {0,  2, -2},
		                     };
		e.getModifiedArray(5, updates);
	}
}