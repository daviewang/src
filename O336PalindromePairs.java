import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class O336PalindromePairs {
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<>();
		if (words == null || words.length == 0) return res;
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], i);
		}
		for (int i = 0; i < words.length; i++) {
			int left = 0, right = 0;
			while (left <= right) {
				String s = words[i].substring(left, right);
				Integer j = map.get(new StringBuilder(s).reverse().toString());
				if (j != null && j != i && 
						isPalindrome(words[i].substring(left == 0 ? right : 0, 
								left == 0 ? words[i].length() : left)
								)) {
					//res.add(Arrays.asList(left == 0 ? new Integer[]{i, j} : new Integer[]{j, i}));
					List<Integer> singleRes = new ArrayList<>();
					if (left == 0) {
						singleRes.add(i);
						singleRes.add(j);
					}
					else {
						singleRes.add(j);
						singleRes.add(i);
					}
					res.add(new ArrayList<>(singleRes));
				}
				if (right < words[i].length()) {
					right++;
				}
				else {
					left++;
				}
			}
		}
		return res;
	}
	private boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}