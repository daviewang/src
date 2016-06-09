import java.util.ArrayList;
import java.util.List;

public class O131PalindromePartitioning {
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return res;
		}
		dfs(res, new ArrayList<>(), s);
		return res;
	}
	
	private void dfs(List<List<String>> res, List<String> singleRes, String s) {
		if (s.length() == 0) {
			res.add(new ArrayList<>(singleRes));
		}
		for (int i = 1; i <= s.length(); i++) {
			String subStr = s.substring(0, i);
			if (isPalindrome(subStr)) {
				singleRes.add(subStr);
				dfs(res, singleRes, s.substring(i));
				singleRes.remove(singleRes.size() - 1);
			}
		}
	}
	
	private boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) return true;
		int start = 0;
		int end = s.length() - 1;
		while (start <= end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		O131PalindromePartitioning e = new O131PalindromePartitioning();
		e.partition("aab");
	}
}