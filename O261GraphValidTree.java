import java.util.Arrays;

public class  O261GraphValidTree {
	public boolean validTree(int n, int[][] edges) {
		int[] nums = new int[n];
		Arrays.fill(nums, -1);
		
		for (int[] edge : edges) {
			int x = find(nums, edge[0]);
			int y = find(nums, edge[1]);
			if (x == y) return false;
			nums[x] = y;
		}
		return edges.length == n - 1;
	}
	int find(int nums[], int i) {
		if(nums[i] == -1) return i;
		return find(nums, nums[i]);
	}
	public static void main(String[] args) {
		int[][] in = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
		O261GraphValidTree e = new O261GraphValidTree();
		e.validTree(5, in);
	}
}