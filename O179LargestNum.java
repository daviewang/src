import java.util.Arrays;
import java.util.Comparator;

public class O179LargestNum {
	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) return "";
		String[] strNum = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strNum[i] = String.valueOf(nums[i]);
		}
		
		Comparator<String> cmp = new Comparator<String>() {
			public int compare(String a, String b) {
				String s1 = a + b;
				String s2 = b + a;
				return s1.compareTo(s2);
			}
		};
		
		Arrays.sort(strNum, cmp);
		
		if (strNum[strNum.length - 1].charAt(0) == '0') {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		for (String s : strNum) {
			sb.insert(0, s);
		}
		return sb.toString();
	}
}