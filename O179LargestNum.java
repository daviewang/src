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
				return s2.compareTo(s1);
			}
		};
		
		Arrays.sort(strNum, cmp);
		
		if (strNum[strNum.length - 1].charAt(0) == '0') {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		for (String s : strNum) {
			sb.append(s);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		O179LargestNum e = new O179LargestNum();
		int[] in = {1,2,3,4,5,6,7,8,9,0};
		e.largestNumber(in);
	}
}