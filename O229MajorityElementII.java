import java.util.ArrayList;
import java.util.List;

public class O229MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		int a = nums[0];
		int b = nums[0];
		int countA = 0;
		int countB = 0;
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] == a) {
				countA++;
			}
			else if (nums[i] == b) {
				countB++;
			}
			else if (countA == 0) {
				a = nums[i];
				countA = 1;
			}
			else if (countB == 0) {
				b = nums[i];
				countB = 1;
			}
			else {
				countA--;
				countB--;
			}
		}
		
		countA = 0;
		countB = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] == a) {
				countA++;
			}
			else if (nums[i] == b) {
				countB++;
			}
		}
		if (countA > len / 3) {
			res.add(a);
		}
		if (countB > len / 3) {
			res.add(b);
		}
		return res;
	}
	public static void main(String[] args) {
		O229MajorityElementII e = new O229MajorityElementII();
		int[] in = {1};
		e.majorityElement(in);
	}
}