public class O360SortTransformedArray {
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}
		int begin = 0;
		int end = nums.length - 1;
		int[] res = new int[nums.length];
		int idx = a >= 0 ? nums.length - 1 : 0;
		while (begin <= end) {
			int beginResult = quad(nums[begin], a, b, c);
			int endResult = quad(nums[end], a, b, c);
			if (a >= 0) {
				if (beginResult >= endResult) {
					res[idx--] = beginResult;
					begin++;
				}
				else {
					res[idx--] = endResult;
					end--;
				}
			}
			else {
				if (beginResult <= endResult) {
					res[idx++] = beginResult;
					begin++;
				}
				else {
					res[idx++] = endResult;
					end--;
				}
			}
		}
		return res;
	}
	
	private int quad(int x, int a, int b, int c) {
		return a * x * x + b * x + c;
	}
	
	public static void main(String[] args) {
		O360SortTransformedArray e = new O360SortTransformedArray();
		int[] in = {-4, -2, 2, 4};
		e.sortTransformedArray(in, -1, 3, 5);
	}
}