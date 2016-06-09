public class O043MultiplyStrings {
	public String multiply(String nums1, String nums2) {
		if (nums1 == null || nums1.length() == 0 || nums2 == null || nums2.length() == 0) return "";
		int len1 = nums1.length();
		int len2 = nums2.length();
		int[] res = new int[len1 + len2];
		
		for (int i = len1 - 1; i >= 0; i--) {
			int level = i;
			for (int j = len2 - 1; j >= 0; j--) {
				int a = nums1.charAt(i) - '0';
				int b = nums2.charAt(j) - '0';
				int singleRes = res[level + j + 1] + a * b;
				res[level + j + 1] = singleRes % 10;
				res[level + j] += singleRes /10;
			}
			level--;
		}
		int zeroCount = 0;
		while (zeroCount < res.length && res[zeroCount] == 0) {
			zeroCount++;
		}
		if (zeroCount == res.length) return "0";
		
		StringBuilder sb = new StringBuilder();
		for (; zeroCount < res.length; zeroCount++) {
			sb.append(res[zeroCount]);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		O043MultiplyStrings e = new O043MultiplyStrings();
		e.multiply("0", "0");
	}
}