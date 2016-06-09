import java.util.ArrayList;
import java.util.List;

public class O060PermutationSequence {
	public String getPermutation(int n, int k) {
		StringBuilder res = new StringBuilder();
		List<Integer> nums = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			nums.add(i);
		}
		int[] factorial = new int[n];
		factorial[0] = 1;
		for (int i = 1; i < n; i++) {
			factorial[i] = factorial[i - 1] * i;
		}
		k--; //subtract 1 because of things always starting at 0
		for (int i = n; i > 0; i--) {
			int idx = k / factorial[i - 1];
			res.append(nums.get(idx));
			k %= factorial[i - 1];
			nums.remove(idx);
		}
		return res.toString();
	}
	
	public static void main(String[] args) {
		O060PermutationSequence e = new O060PermutationSequence();
		System.out.println(e.getPermutation(3, 6));
	}
}